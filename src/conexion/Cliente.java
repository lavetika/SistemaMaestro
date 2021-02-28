/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import gui.GUIObserver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;

/**
 *
 * @author Diana Jiménez
 */
public class Cliente implements Framer {

    private Socket socket;
    private final GUIObserver observer;
    private OutputStream out;
    private InputStream in;

    public Cliente(GUIObserver observer) {
        this.observer = observer;
    }

    public void escuchar() {
        try {
            

//            while (true) {
//                System.out.println("Sistema Maestro esta en la escucha");
//                System.out.println("----");
//                in = socket.getInputStream();
////                byte[] bytes = new byte[esperarDatos(in)];
////                in.read(bytes);
//                String recibido = deserializar(nextMsg());
//                System.out.println("Enviando: " + recibido);
//                System.out.println("----");
//                notificar(recibido);
//            }
        } catch (Exception ex) {
            System.out.println("Ocurrió un error: " + ex.getMessage());
        }
    }

    public void enviar(String contenido) {
        try {
            socket = new Socket("127.0.0.1", 9002);     
            System.out.println("El sistema Maestro esta conectado al servidor.");
            out = socket.getOutputStream();
            System.out.println("Enviando: " + contenido);
            System.out.println("----");
            byte[] bytes = serializar(contenido);
            frameMsgJson(bytes, out);
//          out.write(bytes);
//          out.flush();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error: " + ex.getMessage());
        }
    }

    private static byte[] serializar(String cadena) throws IOException {
        
        return cadena.getBytes();
    }

//    private static String deserializar(byte[] datos) throws IOException, ClassNotFoundException {
//        return new String(datos, StandardCharsets.UTF_8);
//    }
    private void notificar(String contenido) {
        observer.update(contenido);
    }


    @Override
    public void frameMsgJson(byte[] mensaje, OutputStream out) throws IOException {
        try{
            JSONObject json=new JSONObject(new String(mensaje, StandardCharsets.UTF_8));
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new IOException("El mensaje no es un JSON");
        }
        
        out.write(mensaje);
        out.flush();
        out.close();
        socket.close();
    }
}

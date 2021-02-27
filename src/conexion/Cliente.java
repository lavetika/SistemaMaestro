/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import gui.GUIObserver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Diana Jiménez
 */
public class Cliente implements Runnable, Framer{

    private Socket socket;
    private final GUIObserver observer;
    private OutputStream out;
    private InputStream in;

    public Cliente(GUIObserver observer) {
        this.observer = observer;
    }

    public void escuchar() {
        System.out.println("El sistema Maestro esta conectado al servidor.");
        try {
            socket = new Socket("127.0.0.1", 9001);
            out = socket.getOutputStream();

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
            System.out.println("Enviando: " + contenido);
            System.out.println("----");
            JsonObject jsonO = serializar(contenido);
            frameMsgJson(jsonO, out);
//          out.write(bytes);
//          out.flush();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error: " + ex.getMessage());
        }
    }

//    private int esperarDatos(InputStream in) throws IOException {
//
//        int tam;
//        while ((tam = in.available()) == 0) {
//            if (tam > 0) {
//                break;
//            }
//        }
//        return tam;
//    }

    private static JsonObject serializar(String cadena) throws IOException {
        JsonObject json= new Gson().fromJson(cadena, JsonObject.class);
        return json;
    }

//    private static String deserializar(byte[] datos) throws IOException, ClassNotFoundException {
//        return new String(datos, StandardCharsets.UTF_8);
//    }

    private void notificar(String contenido) {
        observer.update(contenido);
    }

    @Override
    public void run() {
        escuchar();
    }

    @Override
    public void frameMsgJson(JsonObject mensaje, OutputStream out) throws IOException {
        out.write(mensaje.toString().getBytes());//jelp si no es mensaje.getAsByte()
        out.flush();
    }

    @Override
    public byte[] nextMsgJson(InputStream in) throws IOException {
        ByteArrayOutputStream msgBuffer=new ByteArrayOutputStream();
       //jsjsjs
        return msgBuffer.toByteArray();
    }
}

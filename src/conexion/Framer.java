/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Diana Jiménez
 */
public interface Framer{
    public void frameMsgJson(JsonObject message, OutputStream out) throws IOException;
    public byte[] nextMsgJson(InputStream in) throws IOException;
}

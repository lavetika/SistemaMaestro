/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONObject;

/**
 *
 * @author Diana Jiménez
 */
public interface Framer{
    public void frameMsgJson(byte[] message, OutputStream out) throws IOException;
}

package co.edu.usbbog.datanetworkoverlock.controller.logic;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.ByteArrayOutputStream;

public class ConexionSSH {

    public void ejecutarComando(String usuario, String clave, String host, int puerto, String comando) {
        Session sesion = null;
        ChannelExec canal = null;

        try {
            sesion = new JSch().getSession(usuario, host, puerto);
            sesion.setPassword(clave);
            sesion.setConfig("StrictHostKeyChecking", "no");
            sesion.connect();

            canal = (ChannelExec) sesion.openChannel("exec");
            canal.setCommand(comando);

            ByteArrayOutputStream respuesta = new ByteArrayOutputStream();
            canal.setOutputStream(respuesta);
            canal.connect();

            while(canal.isConnected()) {
                Thread.sleep(100);
            }

            String respuestaFormato = respuesta.toString();
            System.out.println(respuestaFormato);
        } catch (JSchException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (sesion != null)
                sesion.disconnect();
            if (canal != null)
                canal.disconnect();
        }
    }

}

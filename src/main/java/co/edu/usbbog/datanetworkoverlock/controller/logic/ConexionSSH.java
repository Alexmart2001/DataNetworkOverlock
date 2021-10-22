package co.edu.usbbog.datanetworkoverlock.controller.logic;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.*;

public class ConexionSSH {

    public void ejecutarComando(String usuario, String clave, String host, int puerto, String comando) {
        Session sesion = null;
        ChannelExec canal = null;
        InputStream resultado;
        BufferedReader lector;
        String linea;

        try {
            sesion = new JSch().getSession(usuario, host, puerto);
            sesion.setPassword(clave);
            sesion.setConfig("StrictHostKeyChecking", "no");
            sesion.connect();

            canal = (ChannelExec) sesion.openChannel("exec");
            canal.setCommand(comando);

            resultado = canal.getInputStream();
            lector = new BufferedReader(new InputStreamReader(resultado));
            canal.connect(5000);

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (JSchException | IOException e) {
            System.out.println("Excepción de Jsch: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (canal != null)
                canal.disconnect();
            if (sesion != null)
                sesion.disconnect();
        }
    }

    public static void main(String[] args) {
        new ConexionSSH().ejecutarComando("root", "password", "192.168.1.100", 22, "ls -la");
    }

}

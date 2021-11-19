package co.edu.usbbog.datanetworkoverlock.controller.logic;

import co.edu.usbbog.datanetworkoverlock.controller.config.HostInfo;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SocketFactory;

import java.io.*;

import java.net.Socket;

public class ConexionSSH {

    Session sesion = null;
    ChannelExec canal = null;
    InputStream resultado;
    BufferedReader lector;
    String linea;
    String salida = "";

    public String ejecutarComando(String usuario, String clave, String host, int puerto, String comando) {
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
                //salida += linea + "\n";
                System.out.println(linea);
            }
            salida += "\nadmin@dno-$ ";
            //System.out.println(salida);
            return salida;
        } catch (JSchException | IOException e) {
            System.out.println("Excepción de Jsch: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (canal != null)
                canal.disconnect();
            if (sesion != null)
                sesion.disconnect();
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new ConexionSSH().ejecutarComando(
                HostInfo.USER.getValue(),
                HostInfo.PASSWORD.getValue(),
                HostInfo.HOST.getValue(),
                Integer.parseInt(HostInfo.PORT.getValue()),
                "ll"));
    }

}

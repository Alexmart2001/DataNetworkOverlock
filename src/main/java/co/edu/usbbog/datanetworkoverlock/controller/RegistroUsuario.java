package co.edu.usbbog.datanetworkoverlock.controller;

import co.edu.usbbog.datanetworkoverlock.model.Usuario;

public class RegistroUsuario {

    public boolean registrar(String nombre, String apellido, String user, String clave, String confirmacionClave) {
        if (validarClaves(clave, confirmacionClave)) {
            Usuario usuario = new Usuario(nombre, apellido, user, clave);
            //lógica DB
            return true;
        }
        return false;
    }

    private boolean validarClaves(String clave, String confirmacionClave) {
        return clave.equals(confirmacionClave);
    }

    public void registroFallido() {
        // Alerta de que no se pudo completar el registro
    }

}

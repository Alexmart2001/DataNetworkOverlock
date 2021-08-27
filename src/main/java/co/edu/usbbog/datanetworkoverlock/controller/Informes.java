package co.edu.usbbog.datanetworkoverlock.controller;

import co.edu.usbbog.datanetworkoverlock.model.Usuario;

import java.util.Calendar;

@FunctionalInterface
public interface Informes {

    void generar(String descripcionInforme, Calendar fechaInforme, Usuario usuario);

}

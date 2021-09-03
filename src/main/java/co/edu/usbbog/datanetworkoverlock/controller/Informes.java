package co.edu.usbbog.datanetworkoverlock.controller;

import co.edu.usbbog.datanetworkoverlock.model.PersonaDTO;

import java.util.Calendar;

@FunctionalInterface
public interface Informes {

    void generar(String descripcionInforme, Calendar fechaInforme, PersonaDTO usuario);

}

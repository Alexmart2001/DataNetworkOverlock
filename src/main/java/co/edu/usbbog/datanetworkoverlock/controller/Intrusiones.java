package co.edu.usbbog.datanetworkoverlock.controller;

import co.edu.usbbog.datanetworkoverlock.model.Informacion;

import java.util.Calendar;

public class Intrusiones extends Informacion {

    private String danios;

    public Intrusiones(String descripcion, String herramienta, Calendar fecha, String danios) {
        super(descripcion, herramienta, fecha);
        this.danios = danios;
    }

    public void buscar(String herramienta) {
        // se define con que herramienta va a analizar
    }

}

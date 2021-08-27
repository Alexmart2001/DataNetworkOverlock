package co.edu.usbbog.datanetworkoverlock.controller;

import co.edu.usbbog.datanetworkoverlock.model.Informacion;

import java.util.Calendar;

public class BusquedaVulnerabilidades extends Informacion {

    public BusquedaVulnerabilidades(String descripcion, String herramienta, Calendar fecha) {
        super(descripcion, herramienta, fecha);
    }

    public void buscar(String herramienta) {
        // se define con que herramienta va a analizar
    }

}

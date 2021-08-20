package co.edu.usbbog.datanetworkoverlock.programa;

import java.util.Calendar;

public class FallosDeRed extends Informacion {

    private String tipo;

    public FallosDeRed(String descripcion, String herramienta, Calendar fecha, String tipo) {
        super(descripcion, herramienta, fecha);
        this.tipo = tipo;
    }

    public void buscar(String herramienta) {
        // se define con que herramienta va a analizar
    }

}

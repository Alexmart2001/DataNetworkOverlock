package co.edu.usbbog.datanetworkoverlock.programa;

import java.util.Calendar;

public class Backdoor extends Informacion {

    private String ubicacion;
    private String puertos;
    
    public Backdoor(String descripcion, String herramienta, Calendar fecha, String ubicacion, String... puertos) {
        super(descripcion, herramienta, fecha);
        this.ubicacion = ubicacion;
        this.puertos = concatenarPuertos(puertos);
    }

    private String concatenarPuertos(String[] puertos) {
        //Los puertos que estén abiertos se mostrarán en la salida
        return "";
    }

    public void buscar(String herramienta) {
        // se define con que herramienta va a analizar
    }

}

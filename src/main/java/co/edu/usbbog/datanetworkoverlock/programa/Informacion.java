package co.edu.usbbog.datanetworkoverlock.programa;

import java.util.Calendar;

public class Informacion {

    private String descripcion;
    private String herramienta;
    private Calendar fecha;

    public Informacion(String descripcion, String herramienta, Calendar fecha) {
        this.descripcion = descripcion;
        this.herramienta = herramienta;
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(String herramienta) {
        this.herramienta = herramienta;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Informacion{" +
                "descripcion='" + descripcion + '\'' +
                ", herramienta='" + herramienta + '\'' +
                ", fecha=" + fecha +
                '}';
    }

}

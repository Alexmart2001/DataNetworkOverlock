package co.edu.usbbog.datanetworkoverlock.controller;

import co.edu.usbbog.datanetworkoverlock.model.Usuario;

import java.util.Calendar;

public class InformeModificaciones implements Informes {

    private int idInforme;
    private String nombreInforme;
    private String descripcion;
    private Calendar fecha;

    public InformeModificaciones(int idInforme, String nombreInforme, String descripcion, Calendar fecha) {
        this.idInforme = idInforme;
        this.nombreInforme = nombreInforme;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public String concatenar(int idInforme, String nombreInforme, String descripcion) {
        //Concatenar todo para que se imprima correctamente en el informe
        return "";
    }

    @Override
    public void generar(String descripcionInforme, Calendar fechaInforme, Usuario usuario) {

    }

    public void consultar(int idInforme) {
        //Para consultar los informes buscndo por id
    }

}

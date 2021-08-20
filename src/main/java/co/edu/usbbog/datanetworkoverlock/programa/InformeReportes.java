package co.edu.usbbog.datanetworkoverlock.programa;

import java.util.Calendar;

public class InformeReportes implements Informes {

    private int idReporte;
    private String nombreReporte;
    private String descripcion;
    private String tipoReporte;
    private Calendar fecha;

    public InformeReportes(int idReporte, String nombreReporte, String descripcion, String tipoReporte, Calendar fecha) {
        this.idReporte = idReporte;
        this.nombreReporte = nombreReporte;
        this.descripcion = descripcion;
        this.tipoReporte = tipoReporte;
        this.fecha = fecha;
    }

    public String concatenar(int idReporte, String nombreReporte, String descripcion, String tipoReporte) {
        //Concatenar todo para que se imprima correctamente en el informe
        return "";
    }

    @Override
    public void generar(String descripcionInforme, Calendar fechaInforme, Usuario usuario) {

    }

    public void consultar(int idReporte) {
        //Para consultar los reportes buscndo por id
    }

}

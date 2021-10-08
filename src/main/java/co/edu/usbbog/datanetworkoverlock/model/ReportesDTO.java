package co.edu.usbbog.datanetworkoverlock.model;

import java.util.Calendar;

public class ReportesDTO {

    private Integer idReporte;
    private String nombreReporte;
    private String tipoReporte;
    private String descripcion;
    private Calendar fecha;

    public ReportesDTO() {

    }

    public ReportesDTO(Calendar fecha) {
        this.idReporte = 0;
        this.nombreReporte = "";
        this.tipoReporte = "";
        this.descripcion = "";
        this.fecha = fecha;
    }

    public ReportesDTO(Integer idReporte, Calendar fecha) {
        this.idReporte = idReporte;
        this.nombreReporte = "";
        this.tipoReporte = "";
        this.descripcion = "";
        this.fecha = fecha;
    }

    public ReportesDTO(Integer idReporte, String nombreReporte, String tipoReporte, String descripcion, Calendar fecha) {
        this.idReporte = idReporte;
        this.nombreReporte = nombreReporte;
        this.tipoReporte = tipoReporte;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Integer getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Integer idReporte) {
        this.idReporte = idReporte;
    }

    public String getNombreReporte() {
        return nombreReporte;
    }

    public void setNombreReporte(String nombreReporte) {
        this.nombreReporte = nombreReporte;
    }

    public String getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(String tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

}


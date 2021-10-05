package co.edu.usbbog.datanetworkoverlock.model;

import java.util.Calendar;

public class ReportesDTO {

    private Integer id_reporte;
    private String nombre_reporte;
    private String tipo_reporte;
    private String descripcion;
    private Calendar fecha;

    public ReportesDTO(Calendar fecha) {
        this.id_reporte = 0;
        this.nombre_reporte = "";
        this.tipo_reporte = "";
        this.descripcion = "";
        this.fecha = fecha;
    }

    public ReportesDTO(Integer id_reporte,Calendar fecha) {
        this.id_reporte = id_reporte;
        this.nombre_reporte = "";
        this.tipo_reporte = "";
        this.descripcion = "";
        this.fecha = fecha;
    }

    public ReportesDTO(Integer id_reporte, String nombre_reporte, String tipo_reporte, String descripcion, Calendar fecha) {
        this.id_reporte = id_reporte;
        this.nombre_reporte = nombre_reporte;
        this.tipo_reporte = tipo_reporte;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Integer getId_reporte() {
        return id_reporte;
    }

    public void setId_reporte(Integer id_reporte) {
        this.id_reporte = id_reporte;
    }

    public String getNombre_reporte() {
        return nombre_reporte;
    }

    public void setNombre_reporte(String nombre_reporte) {
        this.nombre_reporte = nombre_reporte;
    }

    public String getTipo_reporte() {
        return tipo_reporte;
    }

    public void setTipo_reporte(String tipo_reporte) {
        this.tipo_reporte = tipo_reporte;
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


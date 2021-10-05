package co.edu.usbbog.datanetworkoverlock.model;

import java.util.Calendar;

public class FallosDeRedDTO {

    private Integer id_fallo;
    private String tipo_fallo;
    private String descripcion;
    private Calendar fecha;
    private ReportesDTO reporte;

    public FallosDeRedDTO(Calendar fecha) {
        this.id_fallo = 0;
        this.tipo_fallo = "";
        this.descripcion = "";
        this.fecha = fecha;
        this.reporte = new ReportesDTO();
    }

    public FallosDeRedDTO(Integer id_fallo,Calendar fecha) {
        this.id_fallo = id_fallo;
        this.tipo_fallo = "";
        this.descripcion = "";
        this.fecha = fecha;
        this.reporte = new ReportesDTO();
    }

    public FallosDeRedDTO(Integer id_fallo, String tipo_fallo, String descripcion, Calendar fecha) {
        this.id_fallo = id_fallo;
        this.tipo_fallo = tipo_fallo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.reporte = new ReportesDTO();
    }

    public FallosDeRedDTO(Integer id_fallo, String tipo_fallo, String descripcion, Calendar fecha, ReportesDTO reporte) {
        this.id_fallo = id_fallo;
        this.tipo_fallo = tipo_fallo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.reporte = reporte;
    }

    public Integer getId_fallo() {
        return id_fallo;
    }

    public void setId_fallo(Integer id_fallo) {
        this.id_fallo = id_fallo;
    }

    public String getTipo_fallo() {
        return tipo_fallo;
    }

    public void setTipo_fallo(String tipo_fallo) {
        this.tipo_fallo = tipo_fallo;
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

    public ReportesDTO getReporte() {
        return reporte;
    }

    public void setReporte(ReportesDTO reporte) {
        this.reporte = reporte;
    }
}

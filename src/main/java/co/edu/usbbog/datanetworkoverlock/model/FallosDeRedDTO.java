package co.edu.usbbog.datanetworkoverlock.model;

import java.util.Calendar;

public class FallosDeRedDTO {

    private Integer idFallo;
    private String tipoFallo;
    private String descripcion;
    private Calendar fecha;
    private ReportesDTO reporte;

    public FallosDeRedDTO() {

    }

    public FallosDeRedDTO(Calendar fecha) {
        this.idFallo = 0;
        this.tipoFallo = "";
        this.descripcion = "";
        this.fecha = fecha;
        this.reporte = new ReportesDTO();
    }

    public FallosDeRedDTO(Integer idFallo, Calendar fecha) {
        this.idFallo = idFallo;
        this.tipoFallo = "";
        this.descripcion = "";
        this.fecha = fecha;
        this.reporte = new ReportesDTO();
    }

    public FallosDeRedDTO(Integer idFallo, String tipoFallo, String descripcion, Calendar fecha) {
        this.idFallo = idFallo;
        this.tipoFallo = tipoFallo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.reporte = new ReportesDTO();
    }

    public FallosDeRedDTO(Integer idFallo, String tipoFallo, String descripcion, Calendar fecha, ReportesDTO reporte) {
        this.idFallo = idFallo;
        this.tipoFallo = tipoFallo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.reporte = reporte;
    }

    public Integer getIdFallo() {
        return idFallo;
    }

    public void setIdFallo(Integer idFallo) {
        this.idFallo = idFallo;
    }

    public String getTipoFallo() {
        return tipoFallo;
    }

    public void setTipoFallo(String tipoFallo) {
        this.tipoFallo = tipoFallo;
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

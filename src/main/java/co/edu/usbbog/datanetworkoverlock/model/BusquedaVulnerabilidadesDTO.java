package co.edu.usbbog.datanetworkoverlock.model;

import java.util.Calendar;

public class BusquedaVulnerabilidadesDTO {

    private Integer idBusqueda;
    private String descripcion;
    private Calendar fecha;
    private Integer codigoCVE;
    private String baseScore;
    private String vector;
    private ReportesDTO reporte;

    public BusquedaVulnerabilidadesDTO() {

    }

    public BusquedaVulnerabilidadesDTO(Calendar fecha) {
        this.idBusqueda = 0;
        this.descripcion = "";
        this.fecha = fecha;
        this.codigoCVE = 0;
        this.baseScore = "";
        this.vector = "";
        this.reporte = new ReportesDTO();
    }

    public BusquedaVulnerabilidadesDTO(Integer idBusqueda, Calendar fecha) {
        this.idBusqueda = idBusqueda;
        this.descripcion = "";
        this.fecha = fecha;
        this.codigoCVE = 0;
        this.baseScore = "";
        this.vector = "";
        this.reporte = new ReportesDTO();
    }

    public BusquedaVulnerabilidadesDTO(Integer idBusqueda, String descripcion, Calendar fecha, Integer codigoCVE, String baseScore, String vector) {
        this.idBusqueda = idBusqueda;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.codigoCVE = codigoCVE;
        this.baseScore = baseScore;
        this.vector = vector;
        this.reporte = new ReportesDTO();
    }

    public BusquedaVulnerabilidadesDTO(Integer idBusqueda, String descripcion, Calendar fecha, Integer codigoCVE, String baseScore, String vector, ReportesDTO reporte) {
        this.idBusqueda = idBusqueda;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.codigoCVE = codigoCVE;
        this.baseScore = baseScore;
        this.vector = vector;
        this.reporte = reporte;
    }

    public Integer getIdBusqueda() {
        return idBusqueda;
    }

    public void setIdBusqueda(Integer idBusqueda) {
        this.idBusqueda = idBusqueda;
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

    public Integer getCodigoCVE() {
        return codigoCVE;
    }

    public void setCodigoCVE(Integer codigoCVE) {
        this.codigoCVE = codigoCVE;
    }

    public String getBaseScore() {
        return baseScore;
    }

    public void setBaseScore(String baseScore) {
        this.baseScore = baseScore;
    }

    public String getVector() {
        return vector;
    }

    public void setVector(String vector) {
        this.vector = vector;
    }

    public ReportesDTO getReporte() {
        return reporte;
    }

    public void setReporte(ReportesDTO reporte) {
        this.reporte = reporte;
    }

}


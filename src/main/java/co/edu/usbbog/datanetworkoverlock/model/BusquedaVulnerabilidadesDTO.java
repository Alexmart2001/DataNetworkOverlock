package co.edu.usbbog.datanetworkoverlock.model;

import java.util.Calendar;

public class BusquedaVulnerabilidadesDTO {

    private Integer id_busqueda;
    private String descripcion;
    private Calendar fecha;
    private Integer codigo_cve;
    private String base_score;
    private String vector;
    private ReportesDTO reporte;

    public BusquedaVulnerabilidadesDTO(Calendar fecha) {
        this.id_busqueda = 0;
        this.descripcion = "";
        this.fecha = fecha;
        this.codigo_cve = 0;
        this.base_score = "";
        this.vector = "";
        this.reporte = new ReportesDTO();
    }

    public BusquedaVulnerabilidadesDTO(Integer id_busqueda, Calendar fecha) {
        this.id_busqueda = id_busqueda;
        this.descripcion = "";
        this.fecha = fecha;
        this.codigo_cve = 0;
        this.base_score = "";
        this.vector = "";
        this.reporte = new ReportesDTO();
    }

    public BusquedaVulnerabilidadesDTO(Integer id_busqueda, String descripcion, Calendar fecha, Integer codigo_cve, String base_score, String vector) {
        this.id_busqueda = id_busqueda;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.codigo_cve = codigo_cve;
        this.base_score = base_score;
        this.vector = vector;
        this.reporte = new ReportesDTO();
    }

    public BusquedaVulnerabilidadesDTO(Integer id_busqueda, String descripcion, Calendar fecha, Integer codigo_cve, String base_score, String vector, ReportesDTO reporte) {
        this.id_busqueda = id_busqueda;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.codigo_cve = codigo_cve;
        this.base_score = base_score;
        this.vector = vector;
        this.reporte = reporte;
    }

    public Integer getId_busqueda() {
        return id_busqueda;
    }

    public void setId_busqueda(Integer id_busqueda) {
        this.id_busqueda = id_busqueda;
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

    public Integer getCodigo_cve() {
        return codigo_cve;
    }

    public void setCodigo_cve(Integer codigo_cve) {
        this.codigo_cve = codigo_cve;
    }

    public String getBase_score() {
        return base_score;
    }

    public void setBase_score(String base_score) {
        this.base_score = base_score;
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


package co.edu.usbbog.datanetworkoverlock.model;

import java.util.Calendar;

public class RegistroCambiosDTO {

    private Integer idRegistro;
    private String descripcion;
    private Calendar fecha;
    private PersonaDTO usuario;
    private ReportesDTO reporte;

    public RegistroCambiosDTO(Calendar fecha) {
        this.idRegistro = 0;
        this.descripcion = "";
        this.fecha = fecha;
        this.usuario = new PersonaDTO();
        this.reporte = new ReportesDTO();
    }

    public RegistroCambiosDTO(Integer idRegistro, Calendar fecha) {
        this.idRegistro = idRegistro;
        this.descripcion = "";
        this.fecha = fecha;
        this.usuario = new PersonaDTO();
        this.reporte = new ReportesDTO();
    }

    public RegistroCambiosDTO(Integer idRegistro, String descripcion, Calendar fecha) {
        this.idRegistro = idRegistro;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.usuario = new PersonaDTO();
        this.reporte = new ReportesDTO();
    }

    public RegistroCambiosDTO(Integer idRegistro, String descripcion, Calendar fecha, PersonaDTO usuario, ReportesDTO reporte) {
        this.idRegistro = idRegistro;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.usuario = usuario;
        this.reporte = reporte;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
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

    public PersonaDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(PersonaDTO usuario) {
        this.usuario = usuario;
    }

    public ReportesDTO getReporte() {
        return reporte;
    }

    public void setReporte(ReportesDTO reporte) {
        this.reporte = reporte;
    }

}

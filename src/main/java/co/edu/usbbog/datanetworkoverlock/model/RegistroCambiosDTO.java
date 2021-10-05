package co.edu.usbbog.datanetworkoverlock.model;

import java.util.Calendar;

public class RegistroCambiosDTO {

    private Integer id_registro;
    private String descripcion;
    private Calendar fecha;
    private PersonaDTO usuario;
    private ReportesDTO reporte;

    public RegistroCambiosDTO(Calendar fecha) {
        this.id_registro = 0;
        this.descripcion = "";
        this.fecha = fecha;
        this.usuario = new PersonaDTO();
        this.reporte = new ReportesDTO();
    }

    public RegistroCambiosDTO(Integer id_registro, Calendar fecha) {
        this.id_registro = id_registro;
        this.descripcion = "";
        this.fecha = fecha;
        this.usuario = new PersonaDTO();
        this.reporte = new ReportesDTO();
    }

    public RegistroCambiosDTO(Integer id_registro, String descripcion, Calendar fecha) {
        this.id_registro = id_registro;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.usuario = new PersonaDTO();
        this.reporte = new ReportesDTO();
    }

    public RegistroCambiosDTO(Integer id_registro, String descripcion, Calendar fecha, PersonaDTO usuario, ReportesDTO reporte) {
        this.id_registro = id_registro;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.usuario = usuario;
        this.reporte = reporte;
    }

    public Integer getId_registro() {
        return id_registro;
    }

    public void setId_registro(Integer id_registro) {
        this.id_registro = id_registro;
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

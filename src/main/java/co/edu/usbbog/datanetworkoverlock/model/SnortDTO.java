package co.edu.usbbog.datanetworkoverlock.model;

import java.util.Calendar;

public class SnortDTO {

    private Integer idAnalisisSnort;
    private Calendar fecha;
    private Calendar hora;
    private String prioridad;
    private String nombre_host;
    private String mensaje;
    private IntrusionesDTO intrusiones;

    public SnortDTO(Calendar fecha, Calendar hora) {
        this.idAnalisisSnort = 0;
        this.fecha = fecha;
        this.hora = hora;
        this.prioridad = "";
        this.nombre_host = "";
        this.mensaje = "";
        this.intrusiones = new IntrusionesDTO();
    }

    public SnortDTO(Integer idAnalisisSnort, Calendar fecha, Calendar hora) {
        this.idAnalisisSnort = idAnalisisSnort;
        this.fecha = fecha;
        this.hora = hora;
        this.prioridad = "";
        this.nombre_host = "";
        this.mensaje = "";
        this.intrusiones = new IntrusionesDTO();
    }

    public SnortDTO(Integer idAnalisisSnort, Calendar fecha, Calendar hora, String prioridad, String nombre_host, String mensaje) {
        this.idAnalisisSnort = idAnalisisSnort;
        this.fecha = fecha;
        this.hora = hora;
        this.prioridad = prioridad;
        this.nombre_host = nombre_host;
        this.mensaje = mensaje;
        this.intrusiones = new IntrusionesDTO();
    }

    public SnortDTO(Integer idAnalisisSnort, Calendar fecha, Calendar hora, String prioridad, String nombre_host, String mensaje, IntrusionesDTO intrusiones) {
        this.idAnalisisSnort = idAnalisisSnort;
        this.fecha = fecha;
        this.hora = hora;
        this.prioridad = prioridad;
        this.nombre_host = nombre_host;
        this.mensaje = mensaje;
        this.intrusiones = intrusiones;
    }

    public Integer getIdAnalisisSnort() {
        return idAnalisisSnort;
    }

    public void setIdAnalisisSnort(Integer idAnalisisSnort) {
        this.idAnalisisSnort = idAnalisisSnort;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getNombre_host() {
        return nombre_host;
    }

    public void setNombre_host(String nombre_host) {
        this.nombre_host = nombre_host;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public IntrusionesDTO getIntrusiones() {
        return intrusiones;
    }

    public void setIntrusiones(IntrusionesDTO intrusiones) {
        this.intrusiones = intrusiones;
    }

}

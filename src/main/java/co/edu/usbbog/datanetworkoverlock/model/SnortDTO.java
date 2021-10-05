package co.edu.usbbog.datanetworkoverlock.model;

import java.util.Calendar;

public class SnortDTO {
    private Integer id_analisis_snort;
    private Calendar fecha;
    private Calendar hora;
    private String prioridad;
    private String nombre_host;
    private String mensaje;
    private IntrusionesDTO intrusiones;

    public SnortDTO(Calendar fecha, Calendar hora) {
        this.id_analisis_snort = 0;
        this.fecha = fecha;
        this.hora = hora;
        this.prioridad = "";
        this.nombre_host = "";
        this.mensaje = "";
        this.intrusiones = new IntrusionesDTO();
    }

    public SnortDTO(Integer id_analisis_snort, Calendar fecha, Calendar hora) {
        this.id_analisis_snort = id_analisis_snort;
        this.fecha = fecha;
        this.hora = hora;
        this.prioridad = "";
        this.nombre_host = "";
        this.mensaje = "";
        this.intrusiones = new IntrusionesDTO();
    }

    public SnortDTO(Integer id_analisis_snort, Calendar fecha, Calendar hora, String prioridad, String nombre_host, String mensaje) {
        this.id_analisis_snort = id_analisis_snort;
        this.fecha = fecha;
        this.hora = hora;
        this.prioridad = prioridad;
        this.nombre_host = nombre_host;
        this.mensaje = mensaje;
        this.intrusiones = new IntrusionesDTO();
    }

    public SnortDTO(Integer id_analisis_snort, Calendar fecha, Calendar hora, String prioridad, String nombre_host, String mensaje, IntrusionesDTO intrusiones) {
        this.id_analisis_snort = id_analisis_snort;
        this.fecha = fecha;
        this.hora = hora;
        this.prioridad = prioridad;
        this.nombre_host = nombre_host;
        this.mensaje = mensaje;
        this.intrusiones = intrusiones;
    }

    public Integer getId_analisis_snort() {
        return id_analisis_snort;
    }

    public void setId_analisis_snort(Integer id_analisis_snort) {
        this.id_analisis_snort = id_analisis_snort;
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

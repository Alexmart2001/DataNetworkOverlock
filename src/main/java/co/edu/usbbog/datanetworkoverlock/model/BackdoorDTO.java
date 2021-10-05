package co.edu.usbbog.datanetworkoverlock.model;

import java.util.Calendar;

public class BackdoorDTO {

     private Integer id_backdoor;
     private String tipo_backdoor;
     private String descripcion;
     private Calendar fecha;
     // relacion
     private ReportesDTO reporte;

    public BackdoorDTO(Calendar fecha) {
        this.id_backdoor = 0;
        this.tipo_backdoor = "";
        this.descripcion = "";
        this.fecha = fecha;
        this.reporte = new ReportesDTO();
    }

    public BackdoorDTO(Integer id_backdoor, Calendar fecha) {
        this.id_backdoor = id_backdoor;
        this.tipo_backdoor = "";
        this.descripcion = "";
        this.fecha = fecha;
        this.reporte = new ReportesDTO();
    }

    public BackdoorDTO(Integer id_backdoor, String tipo_backdoor, String descripcion, Calendar fecha) {
        this.id_backdoor = id_backdoor;
        this.tipo_backdoor = tipo_backdoor;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.reporte = new ReportesDTO();
    }

    public BackdoorDTO(Integer id_backdoor, String tipo_backdoor, String descripcion, Calendar fecha, ReportesDTO reporte) {
        this.id_backdoor = id_backdoor;
        this.tipo_backdoor = tipo_backdoor;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.reporte = reporte;
    }

    public Integer getId_backdoor() {
        return id_backdoor;
    }

    public void setId_backdoor(Integer id_backdoor) {
        this.id_backdoor = id_backdoor;
    }

    public String getTipo_backdoor() {
        return tipo_backdoor;
    }

    public void setTipo_backdoor(String tipo_backdoor) {
        this.tipo_backdoor = tipo_backdoor;
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

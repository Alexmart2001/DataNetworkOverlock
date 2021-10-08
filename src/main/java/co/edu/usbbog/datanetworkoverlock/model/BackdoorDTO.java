package co.edu.usbbog.datanetworkoverlock.model;

import java.util.Calendar;

public class BackdoorDTO {

     private Integer idBackdoor;
     private String tipoBackdoor;
     private String descripcion;
     private Calendar fecha;
     // relacion
     private ReportesDTO reporte;

     public BackdoorDTO() {

     }

    public BackdoorDTO(Calendar fecha) {
        this.idBackdoor = 0;
        this.tipoBackdoor = "";
        this.descripcion = "";
        this.fecha = fecha;
        this.reporte = new ReportesDTO();
    }

    public BackdoorDTO(Integer idBackdoor, Calendar fecha) {
        this.idBackdoor = idBackdoor;
        this.tipoBackdoor = "";
        this.descripcion = "";
        this.fecha = fecha;
        this.reporte = new ReportesDTO();
    }

    public BackdoorDTO(Integer idBackdoor, String tipoBackdoor, String descripcion, Calendar fecha) {
        this.idBackdoor = idBackdoor;
        this.tipoBackdoor = tipoBackdoor;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.reporte = new ReportesDTO();
    }

    public BackdoorDTO(Integer idBackdoor, String tipoBackdoor, String descripcion, Calendar fecha, ReportesDTO reporte) {
        this.idBackdoor = idBackdoor;
        this.tipoBackdoor = tipoBackdoor;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.reporte = reporte;
    }

    public Integer getIdBackdoor() {
        return idBackdoor;
    }

    public void setIdBackdoor(Integer idBackdoor) {
        this.idBackdoor = idBackdoor;
    }

    public String getTipoBackdoor() {
        return tipoBackdoor;
    }

    public void setTipoBackdoor(String tipoBackdoor) {
        this.tipoBackdoor = tipoBackdoor;
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

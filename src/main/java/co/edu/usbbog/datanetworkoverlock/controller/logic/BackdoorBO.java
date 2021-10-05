package co.edu.usbbog.datanetworkoverlock.model;

import co.edu.usbbog.datanetworkoverlock.controller.dao.BackdoorDAO;
import co.edu.usbbog.datanetworkoverlock.model.BackdoorDAOImpl;

import java.util.Calendar;

public class BackdoorBO {

    private final BackdoorDAO backdoorDAO;

    public BackdoorBO(){
        this.backdoorDAO = BackdoorDAOImpl();
    }

    public String crearBackdoor(Integer id_backdoor, String tipo_backdoor, String descripcion, Calendar fecha, ReportesDTO reporte ){
        return backdoorDAO.create(new BackdoorDTO(id_backdoor, tipo_backdoor,descripcion,fecha,reporte)) ? "Creado" : "No se creó";
    }


}

package co.edu.usbbog.datanetworkoverlock.controller.logic;

import co.edu.usbbog.datanetworkoverlock.controller.dao.BackdoorDAO;
import co.edu.usbbog.datanetworkoverlock.controller.dao.BackdoorDAOImpl;
import co.edu.usbbog.datanetworkoverlock.model.BackdoorDTO;
import co.edu.usbbog.datanetworkoverlock.model.ReportesDTO;

import java.util.Calendar;

public class BackdoorBO {

    private final BackdoorDAO backdoorDAO;

    public BackdoorBO(){
        this.backdoorDAO = new BackdoorDAOImpl();
    }

    public String crearBackdoor(Integer id_backdoor, String tipo_backdoor, String descripcion, Calendar fecha, ReportesDTO reporte ){
        return backdoorDAO.create(new BackdoorDTO(id_backdoor, tipo_backdoor,descripcion,fecha,reporte)) ? "Creado" : "No se creó";
    }


}

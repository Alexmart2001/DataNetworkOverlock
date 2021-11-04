package co.edu.usbbog.datanetworkoverlock.controller.logic;

import co.edu.usbbog.datanetworkoverlock.controller.dao.BackdoorDAO;
import co.edu.usbbog.datanetworkoverlock.controller.dao.BackdoorDAOImpl;
import co.edu.usbbog.datanetworkoverlock.model.BackdoorDTO;
import co.edu.usbbog.datanetworkoverlock.model.ReportesDTO;

import java.util.Calendar;
import java.util.List;

public class BackdoorBO {

    private final BackdoorDAO backdoorDAO;

    public BackdoorBO(){
        this.backdoorDAO = new BackdoorDAOImpl();
    }

    public String crearBackdoor(Integer id_backdoor, String tipo_backdoor, String descripcion, Calendar fecha, ReportesDTO reporte ){
        return backdoorDAO.create(new BackdoorDTO(id_backdoor, tipo_backdoor,descripcion,fecha,reporte)) ? "Creado" : "No se creó";
    }

    public String modificarBackdoor (Integer id_backdoor, String tipo_backdoor, String descripcion, Calendar fecha, ReportesDTO reporte){
        return backdoorDAO.edit(new BackdoorDTO(id_backdoor, tipo_backdoor,descripcion,fecha,reporte))  ? "Modificado" : "No se modificó";
    }

    public String eliminarBackdoor (Integer id_backdoor){
        return backdoorDAO.remove(id_backdoor) ? "Eliminado" : "No se eliminó";
    }

    public BackdoorDTO buscarBackdoor (Integer id_backdoor){
        return backdoorDAO.find(id_backdoor);
    }

    public List<BackdoorDTO> mostrarBackdoor(){
        return backdoorDAO.findAll();
    }

}

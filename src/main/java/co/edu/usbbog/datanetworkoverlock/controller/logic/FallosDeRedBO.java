package co.edu.usbbog.datanetworkoverlock.controller.logic;

import co.edu.usbbog.datanetworkoverlock.controller.dao.FallosDeRedDAO;
import co.edu.usbbog.datanetworkoverlock.controller.dao.FallosDeRedDAOImpl;
import co.edu.usbbog.datanetworkoverlock.model.FallosDeRedDTO;
import co.edu.usbbog.datanetworkoverlock.model.ReportesDTO;

import java.util.Calendar;
import java.util.List;

public class FallosDeRedBO {

    private final FallosDeRedDAO fallosdao;

    public FallosDeRedBO(){
        this.fallosdao = new FallosDeRedDAOImpl();
    }

    public String crearFallo (Integer id_fallo, String tipo_fallo, String descripcion, Calendar fecha, ReportesDTO reporte){
        return fallosdao.create(new FallosDeRedDTO(id_fallo, tipo_fallo, descripcion,fecha,reporte)) ? "Creado" : "No se creó";
    }

    public String modificarFallo (Integer id_fallo, String tipo_fallo, String descripcion, Calendar fecha, ReportesDTO reporte){
        return  fallosdao.edit(new FallosDeRedDTO(id_fallo, tipo_fallo, descripcion, fecha, reporte)) ? "Modificado" : "No se modificó";
    }

    public String eliminarFallo (Integer id_fallo){
        return fallosdao.remove(id_fallo)  ? "Eliminado" : "No se eliminó";
    }

    public FallosDeRedDTO buscarFallo (Integer id_fallo){
        return fallosdao.find(id_fallo);
    }

    public List<FallosDeRedDTO> mostrarFallos (){
        return fallosdao.findAll();
    }

}

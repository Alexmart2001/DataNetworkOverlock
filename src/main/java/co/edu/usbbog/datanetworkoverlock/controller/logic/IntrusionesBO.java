package co.edu.usbbog.datanetworkoverlock.controller.logic;

import co.edu.usbbog.datanetworkoverlock.controller.dao.IntrusionesDAO;
import co.edu.usbbog.datanetworkoverlock.controller.dao.IntrusionesDAOImpl;
import co.edu.usbbog.datanetworkoverlock.model.IntrusionesDTO;
import co.edu.usbbog.datanetworkoverlock.model.ReportesDTO;

import java.util.List;

public class IntrusionesBO {

    private final IntrusionesDAO intrusionesdao;

    public IntrusionesBO(){
        this.intrusionesdao = new IntrusionesDAOImpl();
    }

    public String crearIntrusion (Integer id_intrusion, String unidades_afectadas, Integer ataques, ReportesDTO reporte){
        return intrusionesdao.create(new IntrusionesDTO(id_intrusion, unidades_afectadas, ataques, reporte))? "Creado" : "No se creó";
    }

    public String modificarIntrusion (Integer id_intrusion, String unidades_afectadas, Integer ataques, ReportesDTO reporte){
        return intrusionesdao.edit(new IntrusionesDTO(id_intrusion, unidades_afectadas, ataques, reporte))? "Modificado" : "No se modificó";
    }

    public String eliminarIntrusion (Integer id_intrusion){
        return intrusionesdao.remove(id_intrusion) ? "Eliminado" : "No se eliminó";
    }

    public IntrusionesDTO buscarIntrusion (Integer id_intrusion){
        return intrusionesdao.find(id_intrusion);
    }

    public List<IntrusionesDTO> mostrarIntrusiones(){
        return intrusionesdao.findAll();
    }
}

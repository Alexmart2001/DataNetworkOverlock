package co.edu.usbbog.datanetworkoverlock.controller.logic;

import co.edu.usbbog.datanetworkoverlock.controller.dao.PersonaDAOImpl;
import co.edu.usbbog.datanetworkoverlock.controller.dao.SnortDAO;
import co.edu.usbbog.datanetworkoverlock.controller.dao.SnortDAOImpl;
import co.edu.usbbog.datanetworkoverlock.model.IntrusionesDTO;
import co.edu.usbbog.datanetworkoverlock.model.PersonaDTO;
import co.edu.usbbog.datanetworkoverlock.model.SnortDTO;

import java.util.Calendar;
import java.util.List;

;

public class SnortBO {

    private final SnortDAO snortDAO;

    public SnortBO(){
        this.snortDAO = new SnortDAOImpl();
    }

    public String crearSnort(Integer id_analisis_snort, Calendar fecha, Calendar hora, String prioridad, String nombre_host, String mensaje, IntrusionesDTO intrusionesDTO){
        return snortDAO.create(new SnortDTO(id_analisis_snort, fecha, hora, prioridad, nombre_host, mensaje, intrusionesDTO)) ? "Creado" : "No se creó";
    }

    public SnortDTO buscarSnortDTO (Integer id_analisis_snort){
        return snortDAO.find(id_analisis_snort);
    }

    public List<SnortDTO> mostrarSnort() {
        return snortDAO.findAll();
    }
}

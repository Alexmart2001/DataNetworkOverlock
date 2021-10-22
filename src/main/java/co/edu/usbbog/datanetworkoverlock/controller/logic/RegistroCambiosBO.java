package co.edu.usbbog.datanetworkoverlock.controller.logic;



import co.edu.usbbog.datanetworkoverlock.controller.dao.RegistroCambiosDAO;
import co.edu.usbbog.datanetworkoverlock.controller.dao.RegistroCambiosDAOImpl;
import co.edu.usbbog.datanetworkoverlock.model.PersonaDTO;
import co.edu.usbbog.datanetworkoverlock.model.RegistroCambiosDTO;
import co.edu.usbbog.datanetworkoverlock.model.ReportesDTO;

import java.util.Calendar;
import java.util.List;

public class RegistroCambiosBO {

    private final RegistroCambiosDAO registroCambiosDAO;

    public RegistroCambiosBO(){
        this.registroCambiosDAO = new RegistroCambiosDAOImpl();
    }

    public String crearRC(Integer idRegistro, String descripcion, Calendar fecha, PersonaDTO personaDTO, ReportesDTO reportesDTO){
        return registroCambiosDAO.create(new RegistroCambiosDTO(idRegistro, descripcion, fecha, personaDTO, reportesDTO)) ? "Creado" : "No se creó";
    }

    public RegistroCambiosDTO buscarRCDTO (Integer idRegistro){
        return registroCambiosDAO.find(idRegistro);
    }

    public List<RegistroCambiosDTO> mostrarRC() {
        return registroCambiosDAO.findAll();
    }
}

package co.edu.usbbog.datanetworkoverlock.controller.logic;

import co.edu.usbbog.datanetworkoverlock.controller.dao.PersonaDAO;
import co.edu.usbbog.datanetworkoverlock.controller.dao.PersonaDAOImpl;
import co.edu.usbbog.datanetworkoverlock.model.PersonaDTO;

import java.util.List;

public class PersonaBO {

    private final PersonaDAO personaDAO;

    public PersonaBO(){
        this.personaDAO = new PersonaDAOImpl();
    }

    public String crearPersona(String usuario, String nombre, String apellido, String clave, String correo){
        return personaDAO.create(new PersonaDTO(usuario, nombre, apellido, clave, correo)) ? "Creado" : "No se creó";
    }

    public String modificarPersona(String usuario, String nombre, String apellido, String clave, String correo){
        return personaDAO.edit(new PersonaDTO(usuario, nombre, apellido, clave, correo)) ? "Modificado" : "No se modificó";
    }

    public String eliminarPersona(String usuario){
        return personaDAO.remove(usuario) ? "Eliminado" : "No se eliminó";
    }

    public PersonaDTO buscarPersona (String usuario){
        return personaDAO.find(usuario);
    }

    public List<PersonaDTO> mostrarPersonas() {
    return personaDAO.findAll();
    }

}

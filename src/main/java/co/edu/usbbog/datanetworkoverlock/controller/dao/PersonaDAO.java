package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.model.PersonaDTO;

import java.util.List;

public interface PersonaDAO {

    public boolean create(PersonaDTO persona);

    public boolean edit(PersonaDTO persona);

    public boolean remove(String usuario);

    public PersonaDTO find(String ususario);

    public PersonaDTO validate(String usuario, String clave);

    public List<PersonaDTO> findAll();

    public int count();

}

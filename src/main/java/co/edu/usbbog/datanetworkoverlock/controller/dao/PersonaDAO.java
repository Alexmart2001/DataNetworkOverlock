package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.model.PersonaDTO;

import java.util.List;

public interface PersonaDAO {

    public boolean create(PersonaDTO persona);

    public PersonaDTO find(String usuario);

    public List<PersonaDTO> findAll();

    public int count();

}

package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.model.PersonaDTO;

import java.util.List;

public interface PersonaDAO {
    public boolean create();
    public boolean edit();
    public boolean remove();
    public PersonaDTO find ();
    public List<PersonaDTO> findAll();
}

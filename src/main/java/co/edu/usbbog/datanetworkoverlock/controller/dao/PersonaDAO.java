package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.model.PersonaDTO;

import java.util.List;

public interface PersonaDAO {
    public boolean create(PersonaDTO persona);
    public boolean edit(PersonaDTO persona );
    public boolean remove(Integer usuario);
    public PersonaDTO find (Integer usuario);
    public List<PersonaDTO> findAll();
    public int count();
}

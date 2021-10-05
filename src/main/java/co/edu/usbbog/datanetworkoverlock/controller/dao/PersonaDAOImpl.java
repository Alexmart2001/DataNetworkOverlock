package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.model.PersonaDTO;

import java.util.List;

public class PersonaDAOImpl implements PersonaDAO {

    @Override
    public boolean create(PersonaDTO persona) {
        return false;
    }

    @Override
    public boolean edit(PersonaDTO persona) {
        return false;
    }

    @Override
    public boolean remove(Integer usuario) {
        return false;
    }

    @Override
    public PersonaDTO find(Integer usuario) {
        return null;
    }

    @Override
    public List<PersonaDTO> findAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}

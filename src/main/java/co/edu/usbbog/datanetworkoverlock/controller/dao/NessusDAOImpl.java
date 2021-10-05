package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.model.NessusDTO;

import java.util.List;

public class NessusDAOImpl implements NessusDAO{
    @Override
    public boolean create(NessusDTO nessus) {
        return false;
    }

    @Override
    public boolean edit(NessusDTO nessus) {
        return false;
    }

    @Override
    public boolean remove(Integer id_analisis_nessus) {
        return false;
    }

    @Override
    public NessusDTO find(Integer id_analisis_nessus) {
        return null;
    }

    @Override
    public List<NessusDTO> findAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}

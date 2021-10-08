package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.model.SnortDTO;

import java.util.List;

public class SnortDAOImpl implements SnortDAO {

    @Override
    public boolean create(SnortDTO snort) {
        return false;
    }

    @Override
    public boolean edit(SnortDTO snort) {
        return false;
    }

    @Override
    public boolean remove(Integer id_analisis_snort) {
        return false;
    }

    @Override
    public SnortDTO find(Integer id_analisis_snort) {
        return null;
    }

    @Override
    public List<SnortDTO> findAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

}

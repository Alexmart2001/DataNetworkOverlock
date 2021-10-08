package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.model.FallosDeRedDTO;

import java.util.List;

public interface FallosDeRedDAO {

    public boolean create(FallosDeRedDTO fallos);

    public boolean edit(FallosDeRedDTO fallos);

    public boolean remove(Integer id_fallo);

    public FallosDeRedDTO find(Integer id_fallo);

    public List<FallosDeRedDTO> findAll();

    public int count();

}

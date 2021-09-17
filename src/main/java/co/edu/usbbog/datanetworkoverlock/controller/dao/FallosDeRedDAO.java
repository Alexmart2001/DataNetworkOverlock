package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.model.FallosDeRedDTO;

import java.util.List;

public interface FallosDeRedDAO {
    public boolean create();
    public boolean edit();
    public boolean remove();
    public FallosDeRedDTO find ();
    public List<FallosDeRedDTO> findAll();
}

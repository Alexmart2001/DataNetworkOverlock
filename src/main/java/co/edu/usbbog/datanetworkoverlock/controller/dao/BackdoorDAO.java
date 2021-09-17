package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.model.BackdoorDTO;

import java.util.List;

public interface BackdoorDAO {
    public boolean create();
    public boolean edit();
    public boolean remove();
    public BackdoorDTO find ();
    public List<BackdoorDTO> findAll();

}

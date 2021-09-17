package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.model.NessusDTO;

import java.util.List;

public interface NessusDAO {

    public boolean create();
    public boolean edit();
    public boolean remove();
    public NessusDTO find ();
    public List<NessusDTO> findAll();
}

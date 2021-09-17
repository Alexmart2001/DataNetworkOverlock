package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.model.NmapDTO;

import java.util.List;

public interface NmapDAO {
    public boolean create();
    public boolean edit();
    public boolean remove();
    public NmapDTO find ();
    public List<NmapDTO> findAll();
}

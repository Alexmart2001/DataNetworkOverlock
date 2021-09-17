package co.edu.usbbog.datanetworkoverlock.controller.dao;



import co.edu.usbbog.datanetworkoverlock.model.IntrusionesDTO;

import java.util.List;

public interface IntrusionesDAO {
    public boolean create();
    public boolean edit();
    public boolean remove();
    public IntrusionesDTO find ();
    public List<IntrusionesDTO> findAll();
}

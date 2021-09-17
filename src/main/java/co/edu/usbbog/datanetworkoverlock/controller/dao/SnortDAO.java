package co.edu.usbbog.datanetworkoverlock.controller.dao;
import co.edu.usbbog.datanetworkoverlock.model.SnortDTO;

import java.util.List;

public interface SnortDAO {
    public boolean create();
    public boolean edit();
    public boolean remove();
    public SnortDTO find ();
    public List<SnortDTO> findAll();
}

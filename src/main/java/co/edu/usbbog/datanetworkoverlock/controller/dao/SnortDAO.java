package co.edu.usbbog.datanetworkoverlock.controller.dao;
import co.edu.usbbog.datanetworkoverlock.model.SnortDTO;

import java.util.List;

public interface SnortDAO {
    public boolean create(SnortDTO snort);
    public boolean edit(SnortDTO snort);
    public boolean remove(Integer id_analisis_snort);
    public SnortDTO find (Integer id_analisis_snort);
    public List<SnortDTO> findAll();
    public int count();
}

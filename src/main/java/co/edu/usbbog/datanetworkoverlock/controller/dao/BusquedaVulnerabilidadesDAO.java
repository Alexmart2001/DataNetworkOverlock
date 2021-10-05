package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.model.BusquedaVulnerabilidadesDTO;

import java.util.List;

public interface BusquedaVulnerabilidadesDAO {
    public boolean create( BusquedaVulnerabilidadesDTO busqueda);
    public boolean edit(BusquedaVulnerabilidadesDTO busqueda);
    public boolean remove(Integer id_busqueda);
    public BusquedaVulnerabilidadesDTO find (Integer id_busqueda);
    public List<BusquedaVulnerabilidadesDTO> findAll();
    public int count();
}

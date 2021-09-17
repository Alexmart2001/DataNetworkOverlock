package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.model.BusquedaVulnerabilidadesDTO;

import java.util.List;

public interface BusquedaVulnerabilidadesDAO {
    public boolean create();
    public boolean edit();
    public boolean remove();
    public BusquedaVulnerabilidadesDTO find ();
    public List<BusquedaVulnerabilidadesDTO> findAll();
}

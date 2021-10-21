package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.model.NmapDTO;

import java.util.List;

public interface NmapDAO {

    public boolean create(NmapDTO nmap);

    public NmapDTO find(Integer id_analisis_nmap);

    public List<NmapDTO> findAll();

    public int count();

}

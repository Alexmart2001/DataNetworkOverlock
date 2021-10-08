package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.model.NessusDTO;

import java.util.List;

public interface NessusDAO {

    public boolean create(NessusDTO nessus);

    public boolean edit(NessusDTO nessus);

    public boolean remove(Integer id_analisis_nessus);

    public NessusDTO find(Integer id_analisis_nessus);

    public List<NessusDTO> findAll();

    public int count();

}

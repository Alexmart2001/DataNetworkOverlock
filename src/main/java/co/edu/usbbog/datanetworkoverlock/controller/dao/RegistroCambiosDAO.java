package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.model.RegistroCambiosDTO;

import java.util.List;

public interface RegistroCambiosDAO {

    public boolean create(RegistroCambiosDTO registro);

    public boolean edit(RegistroCambiosDTO registro);

    public boolean remove(Integer id_registro);

    public RegistroCambiosDTO find(Integer id_registro);

    public List<RegistroCambiosDTO> findAll();

    public int count();

}

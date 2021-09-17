package co.edu.usbbog.datanetworkoverlock.controller.dao;


import co.edu.usbbog.datanetworkoverlock.model.RegistroCambiosDTO;

import java.util.List;

public interface RegistroCambiosDAO {
    public boolean create();
    public boolean edit();
    public boolean remove();
    public RegistroCambiosDTO find ();
    public List<RegistroCambiosDTO> findAll();
}

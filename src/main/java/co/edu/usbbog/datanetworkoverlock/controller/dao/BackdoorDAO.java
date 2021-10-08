package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.model.BackdoorDTO;

import java.util.List;

public interface BackdoorDAO {

    public boolean create(BackdoorDTO backdoor);

    public boolean edit(BackdoorDTO backdoor);

    public boolean remove(Integer id_backdoor);

    public BackdoorDTO find(Integer id_backdoor);

    public List<BackdoorDTO> findAll();

    public int count();

}

package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.model.IntrusionesDTO;

import java.util.List;

public interface IntrusionesDAO {

    public boolean create(IntrusionesDTO intrusiones);

    public boolean edit(IntrusionesDTO intrusiones);

    public boolean remove(Integer id_intrusion);

    public IntrusionesDTO find(Integer id_intrusion);

    public List<IntrusionesDTO> findAll();

    public int count();

}

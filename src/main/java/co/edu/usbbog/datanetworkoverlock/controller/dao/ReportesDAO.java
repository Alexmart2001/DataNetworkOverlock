package co.edu.usbbog.datanetworkoverlock.controller.dao;


import co.edu.usbbog.datanetworkoverlock.model.ReportesDTO;

import java.util.List;

public interface ReportesDAO {
    public boolean create();
    public boolean edit();
    public boolean remove();
    public ReportesDTO find ();
    public List<ReportesDTO> findAll();
}

package co.edu.usbbog.datanetworkoverlock.controller.dao;


import co.edu.usbbog.datanetworkoverlock.model.ReportesDTO;

import java.util.List;

public interface ReportesDAO {
    public boolean create(ReportesDTO reporte);
    public boolean edit(ReportesDTO reporte);
    public boolean remove(Integer id_reporte);
    public ReportesDTO find (Integer id_reporte);
    public List<ReportesDTO> findAll();
    public int count();
}

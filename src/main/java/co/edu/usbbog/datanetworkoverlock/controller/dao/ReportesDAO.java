package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.model.ReportesDTO;

import java.util.List;

public interface ReportesDAO {

    public boolean create(ReportesDTO reporte);

    public ReportesDTO find(Integer id_reporte);

    public List<ReportesDTO> findAll();

    public int count();

}

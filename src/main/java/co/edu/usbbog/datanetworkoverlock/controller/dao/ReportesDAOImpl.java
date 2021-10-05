package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.model.ReportesDTO;

import java.util.List;

public class ReportesDAOImpl implements ReportesDAO{

    @Override
    public boolean create(ReportesDTO reporte) {
        return false;
    }

    @Override
    public boolean edit(ReportesDTO reporte) {
        return false;
    }

    @Override
    public boolean remove(Integer id_reporte) {
        return false;
    }

    @Override
    public ReportesDTO find(Integer id_reporte) {
        return null;
    }

    @Override
    public List<ReportesDTO> findAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}

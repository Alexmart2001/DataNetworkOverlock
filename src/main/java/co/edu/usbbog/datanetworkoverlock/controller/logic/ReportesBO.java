package co.edu.usbbog.datanetworkoverlock.controller.logic;

import co.edu.usbbog.datanetworkoverlock.controller.dao.ReportesDAO;
import co.edu.usbbog.datanetworkoverlock.controller.dao.ReportesDAOImpl;
import co.edu.usbbog.datanetworkoverlock.model.IntrusionesDTO;
import co.edu.usbbog.datanetworkoverlock.model.ReportesDTO;
import co.edu.usbbog.datanetworkoverlock.model.SnortDTO;

import java.util.Calendar;
import java.util.List;

public class ReportesBO {
    private final ReportesDAO reportesDAO;

    public ReportesBO() {this.reportesDAO = new ReportesDAOImpl();}

    public String crearReportes(Integer idReporte, String nombreReporte, String tipoReporte, String descripcion, Calendar fecha){
        return reportesDAO.create(new ReportesDTO(idReporte, nombreReporte, tipoReporte, descripcion, fecha)) ? "Creado" : "No se creó";
    }

    public ReportesDTO buscarReportes (Integer idReporte){
        return reportesDAO.find(idReporte);
    }

    public List<ReportesDTO> mostrarReportes() {
        return reportesDAO.findAll();
    }
}

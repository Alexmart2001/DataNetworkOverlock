package co.edu.usbbog.datanetworkoverlock.controller.logic;

import co.edu.usbbog.datanetworkoverlock.controller.dao.BusquedaVulnerabilidadesDAO;
import co.edu.usbbog.datanetworkoverlock.controller.dao.BusquedaVulnerabilidadesDAOImpl;
import co.edu.usbbog.datanetworkoverlock.model.BusquedaVulnerabilidadesDTO;

import co.edu.usbbog.datanetworkoverlock.model.ReportesDTO;

import java.util.Calendar;
import java.util.List;

public class BusquedaVulnerabilidadesBO {

    private final BusquedaVulnerabilidadesDAO busquedaDao;

    public BusquedaVulnerabilidadesBO(){
        this.busquedaDao = new BusquedaVulnerabilidadesDAOImpl();
    }

    public String crearbusqueda (Integer id_busqueda, String descripcion, Calendar fecha, Integer codigo_cve, String base_score, String vector, ReportesDTO reporte){
        return busquedaDao.create(new BusquedaVulnerabilidadesDTO(id_busqueda, descripcion, fecha, codigo_cve, base_score, vector, reporte)) ? "Creado" : "No se creó";
    }

    public String modificarBusqueda (Integer id_busqueda, String descripcion, Calendar fecha, Integer codigo_cve, String base_score, String vector, ReportesDTO reporte){
        return busquedaDao.edit(new BusquedaVulnerabilidadesDTO(id_busqueda, descripcion, fecha, codigo_cve, base_score, vector, reporte)) ? "Modificado" : "No se modificó";
    }

    public String eliminarVulnerabilidad (Integer id_busqueda){
        return busquedaDao.remove(id_busqueda) ? "Eliminado" : "No se eliminó";
    }
    public BusquedaVulnerabilidadesDTO buscarVulne (Integer id_busqueda){
        return busquedaDao.find(id_busqueda);
    }

    public List<BusquedaVulnerabilidadesDTO> mostrarVulne(){
        return busquedaDao.findAll();
    }


}

package co.edu.usbbog.datanetworkoverlock.controller.logic;

import co.edu.usbbog.datanetworkoverlock.controller.dao.NessusDAO;
import co.edu.usbbog.datanetworkoverlock.controller.dao.NessusDAOImpl;
import co.edu.usbbog.datanetworkoverlock.model.*;

import java.util.List;

public class NessusBO {

    private final NessusDAO nessusDAO;

    public NessusBO(){
        this.nessusDAO = new NessusDAOImpl();
    }

    public String crearNessus(Integer idAnalisisNessus, Integer ip, Integer puerto, Integer hostNumber, String descripcion, String solucion, String nombreDNS, String nombreNetbios, String direccionMac, String nist, String baseScore, String vector, BusquedaVulnerabilidadesDTO busqueda){
        return nessusDAO.create(new NessusDTO(idAnalisisNessus, ip, puerto, hostNumber, descripcion, solucion, nombreDNS, nombreNetbios,direccionMac, nist, baseScore, vector, busqueda)) ? "Creado" : "No se creó";
    }

    public NessusDTO buscarNessusDTO (Integer idAnalisisNmap){
        return nessusDAO.find(idAnalisisNmap);
    }

    public List<NessusDTO> mostrarNessus() {
        return nessusDAO.findAll();
    }
}

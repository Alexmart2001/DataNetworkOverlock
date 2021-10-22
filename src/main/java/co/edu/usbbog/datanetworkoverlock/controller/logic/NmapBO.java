package co.edu.usbbog.datanetworkoverlock.controller.logic;

import co.edu.usbbog.datanetworkoverlock.controller.dao.NmapDAO;
import co.edu.usbbog.datanetworkoverlock.controller.dao.NmapDAOImpl;
import co.edu.usbbog.datanetworkoverlock.model.BackdoorDTO;
import co.edu.usbbog.datanetworkoverlock.model.FallosDeRedDTO;
import co.edu.usbbog.datanetworkoverlock.model.NmapDTO;

import java.util.List;

public class NmapBO {
    private final NmapDAO nmapDAO;

    public NmapBO(){
        this.nmapDAO = new NmapDAOImpl();
    }

    public String crearNmap(Integer idAnalisisNmap, String protocoloPuerto, String estado, String razon, String nombreServicio, String producto, String version, Integer puertoId, String informacionExtra, BackdoorDTO backdoorDTO, FallosDeRedDTO fallosDeRedDTO){
        return nmapDAO.create(new NmapDTO(idAnalisisNmap, protocoloPuerto, estado, razon, nombreServicio, producto, version, puertoId, informacionExtra, backdoorDTO, fallosDeRedDTO)) ? "Creado" : "No se creó";
    }

    public NmapDTO buscarNmapDTO (Integer idAnalisisNmap){
        return nmapDAO.find(idAnalisisNmap);
    }

    public List<NmapDTO> mostrarNmap() {
        return nmapDAO.findAll();
    }
}

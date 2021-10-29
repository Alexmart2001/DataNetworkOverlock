package co.edu.usbbog.datanetworkoverlock.controller.logic;

import co.edu.usbbog.datanetworkoverlock.controller.dao.KismetDAO;
import co.edu.usbbog.datanetworkoverlock.controller.dao.KismetDAOImpl;
import co.edu.usbbog.datanetworkoverlock.model.IntrusionesDTO;
import co.edu.usbbog.datanetworkoverlock.model.KismetDTO;

import java.util.List;

public class KismetBO {
    private final KismetDAO kismetd;

    public KismetBO(){
        this.kismetd = new KismetDAOImpl();
    }

    public String crearKismet(Integer id_analisis_kismet, String nombre_red_detectada, String clientes_detectados, String modo_funcionamiento_disp_wifi, String tipo_encriptacion, String canal_operacion_red, String paquetes_capturados, IntrusionesDTO intrusiones) {
        return kismetd.create(new KismetDTO(id_analisis_kismet, nombre_red_detectada, clientes_detectados, modo_funcionamiento_disp_wifi, tipo_encriptacion, canal_operacion_red, paquetes_capturados, intrusiones)) ? "creado" : "no se creo";
    }
        public KismetDTO buscarKismet(Integer id_analisis_kismet){
            return kismetd.find(id_analisis_kismet);
        }
        public List<KismetDTO> mostrarKismets(){
            return kismetd.findAll();
        }
}

package co.edu.usbbog.datanetworkoverlock.model;

public class KismetDTO {

    private Integer id_analisis_kismet;
    private String nombre_red_detectada;
    private String clientes_detectados;
    private String modo_funcionamiento_disp_wifi;
    private String tipo_encriptacion;
    private String canal_operacion_red;
    private String paquetes_capturados;
    private IntrusionesDTO intrusiones;

    public KismetDTO() {
        this.id_analisis_kismet = 0;
        this.nombre_red_detectada = "";
        this.clientes_detectados = "";
        this.modo_funcionamiento_disp_wifi = "";
        this.tipo_encriptacion = "";
        this.canal_operacion_red = "";
        this.paquetes_capturados = "";
        this.intrusiones = new IntrusionesDTO();
    }

    public KismetDTO(Integer id_analisis_kismet) {
        this.id_analisis_kismet = id_analisis_kismet;
        this.nombre_red_detectada = "";
        this.clientes_detectados = "";
        this.modo_funcionamiento_disp_wifi = "";
        this.tipo_encriptacion = "";
        this.canal_operacion_red = "";
        this.paquetes_capturados = "";
        this.intrusiones = new IntrusionesDTO();
    }

    public KismetDTO(Integer id_analisis_kismet, String nombre_red_detectada, String clientes_detectados, String modo_funcionamiento_disp_wifi, String tipo_encriptacion, String canal_operacion_red, String paquetes_capturados) {
        this.id_analisis_kismet = id_analisis_kismet;
        this.nombre_red_detectada = nombre_red_detectada;
        this.clientes_detectados = clientes_detectados;
        this.modo_funcionamiento_disp_wifi = modo_funcionamiento_disp_wifi;
        this.tipo_encriptacion = tipo_encriptacion;
        this.canal_operacion_red = canal_operacion_red;
        this.paquetes_capturados = paquetes_capturados;
        this.intrusiones = new IntrusionesDTO();
    }

    public KismetDTO(Integer id_analisis_kismet, String nombre_red_detectada, String clientes_detectados, String modo_funcionamiento_disp_wifi, String tipo_encriptacion, String canal_operacion_red, String paquetes_capturados, IntrusionesDTO intrusiones) {
        this.id_analisis_kismet = id_analisis_kismet;
        this.nombre_red_detectada = nombre_red_detectada;
        this.clientes_detectados = clientes_detectados;
        this.modo_funcionamiento_disp_wifi = modo_funcionamiento_disp_wifi;
        this.tipo_encriptacion = tipo_encriptacion;
        this.canal_operacion_red = canal_operacion_red;
        this.paquetes_capturados = paquetes_capturados;
        this.intrusiones = intrusiones;
    }

    public Integer getId_analisis_kismet() {
        return id_analisis_kismet;
    }

    public void setId_analisis_kismet(Integer id_analisis_kismet) {
        this.id_analisis_kismet = id_analisis_kismet;
    }

    public String getNombre_red_detectada() {
        return nombre_red_detectada;
    }

    public void setNombre_red_detectada(String nombre_red_detectada) {
        this.nombre_red_detectada = nombre_red_detectada;
    }

    public String getClientes_detectados() {
        return clientes_detectados;
    }

    public void setClientes_detectados(String clientes_detectados) {
        this.clientes_detectados = clientes_detectados;
    }

    public String getModo_funcionamiento_disp_wifi() {
        return modo_funcionamiento_disp_wifi;
    }

    public void setModo_funcionamiento_disp_wifi(String modo_funcionamiento_disp_wifi) {
        this.modo_funcionamiento_disp_wifi = modo_funcionamiento_disp_wifi;
    }

    public String getTipo_encriptacion() {
        return tipo_encriptacion;
    }

    public void setTipo_encriptacion(String tipo_encriptacion) {
        this.tipo_encriptacion = tipo_encriptacion;
    }

    public String getCanal_operacion_red() {
        return canal_operacion_red;
    }

    public void setCanal_operacion_red(String canal_operacion_red) {
        this.canal_operacion_red = canal_operacion_red;
    }

    public String getPaquetes_capturados() {
        return paquetes_capturados;
    }

    public void setPaquetes_capturados(String paquetes_capturados) {
        this.paquetes_capturados = paquetes_capturados;
    }

    public IntrusionesDTO getIntrusiones() {
        return intrusiones;
    }

    public void setIntrusiones(IntrusionesDTO intrusiones) {
        this.intrusiones = intrusiones;
    }
}

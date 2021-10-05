package co.edu.usbbog.datanetworkoverlock.model;

public class NmapDTO {
    private Integer id_analisis_nmap;
    private String protocolo_puerto;
    private String estado;
    private String razon;
    private String nombre_servicio;
    private String producto;
    private String version;
    private Integer puerto_id;
    private String informacion_extra;
    private BackdoorDTO backdoor;
    private FallosDeRedDTO fallos_de_red;

    public NmapDTO() {
        this.id_analisis_nmap = 0;
        this.protocolo_puerto = "";
        this.estado = "";
        this.razon = "";
        this.nombre_servicio = "";
        this.producto = "";
        this.version = "";
        this.puerto_id = 0;
        this.informacion_extra = "";
        this.backdoor = new BackdoorDTO();
        this.fallos_de_red = new FallosDeRedDTO();
    }

    public NmapDTO(Integer id_analisis_nmap) {
        this.id_analisis_nmap = id_analisis_nmap;
        this.protocolo_puerto = "";
        this.estado = "";
        this.razon = "";
        this.nombre_servicio = "";
        this.producto = "";
        this.version = "";
        this.puerto_id = 0;
        this.informacion_extra = "";
        this.backdoor = new BackdoorDTO();
        this.fallos_de_red = new FallosDeRedDTO();
    }

    public NmapDTO(Integer id_analisis_nmap, String protocolo_puerto, String estado, String razon, String nombre_servicio, String producto, String version, Integer puerto_id, String informacion_extra) {
        this.id_analisis_nmap = id_analisis_nmap;
        this.protocolo_puerto = protocolo_puerto;
        this.estado = estado;
        this.razon = razon;
        this.nombre_servicio = nombre_servicio;
        this.producto = producto;
        this.version = version;
        this.puerto_id = puerto_id;
        this.informacion_extra = informacion_extra;
        this.backdoor = new BackdoorDTO();
        this.fallos_de_red = new FallosDeRedDTO();
    }

    public Integer getId_analisis_nmap() {
        return id_analisis_nmap;
    }

    public void setId_analisis_nmap(Integer id_analisis_nmap) {
        this.id_analisis_nmap = id_analisis_nmap;
    }

    public String getProtocolo_puerto() {
        return protocolo_puerto;
    }

    public void setProtocolo_puerto(String protocolo_puerto) {
        this.protocolo_puerto = protocolo_puerto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getPuerto_id() {
        return puerto_id;
    }

    public void setPuerto_id(Integer puerto_id) {
        this.puerto_id = puerto_id;
    }

    public String getInformacion_extra() {
        return informacion_extra;
    }

    public void setInformacion_extra(String informacion_extra) {
        this.informacion_extra = informacion_extra;
    }

    public BackdoorDTO getBackdoor() {
        return backdoor;
    }

    public void setBackdoor(BackdoorDTO backdoor) {
        this.backdoor = backdoor;
    }

    public FallosDeRedDTO getFallos_de_red() {
        return fallos_de_red;
    }

    public void setFallos_de_red(FallosDeRedDTO fallos_de_red) {
        this.fallos_de_red = fallos_de_red;
    }
}

package co.edu.usbbog.datanetworkoverlock.model;

public class NmapDTO {

    private Integer idAnalisisNmap;
    private String protocoloPuerto;
    private String estado;
    private String razon;
    private String nombreServicio;
    private String producto;
    private String version;
    private Integer puertoId;
    private String informacionExtra;
    private BackdoorDTO backdoor;
    private FallosDeRedDTO fallosRed;

    public NmapDTO() {
        this.idAnalisisNmap = 0;
        this.protocoloPuerto = "";
        this.estado = "";
        this.razon = "";
        this.nombreServicio = "";
        this.producto = "";
        this.version = "";
        this.puertoId = 0;
        this.informacionExtra = "";
        this.backdoor = new BackdoorDTO();
        this.fallosRed = new FallosDeRedDTO();
    }

    public NmapDTO(Integer idAnalisisNmap) {
        this.idAnalisisNmap = idAnalisisNmap;
        this.protocoloPuerto = "";
        this.estado = "";
        this.razon = "";
        this.nombreServicio = "";
        this.producto = "";
        this.version = "";
        this.puertoId = 0;
        this.informacionExtra = "";
        this.backdoor = new BackdoorDTO();
        this.fallosRed = new FallosDeRedDTO();
    }

    public NmapDTO(Integer idAnalisisNmap, String protocoloPuerto, String estado, String razon, String nombreServicio, String producto, String version, Integer puertoId, String informacionExtra, BackdoorDTO backdoor, FallosDeRedDTO fallosDeRedDTO) {
        this.idAnalisisNmap = idAnalisisNmap;
        this.protocoloPuerto = protocoloPuerto;
        this.estado = estado;
        this.razon = razon;
        this.nombreServicio = nombreServicio;
        this.producto = producto;
        this.version = version;
        this.puertoId = puertoId;
        this.informacionExtra = informacionExtra;
        this.backdoor = backdoor;
        this.fallosRed = fallosDeRedDTO;
    }

    public Integer getIdAnalisisNmap() {
        return idAnalisisNmap;
    }

    public void setIdAnalisisNmap(Integer idAnalisisNmap) {
        this.idAnalisisNmap = idAnalisisNmap;
    }

    public String getProtocoloPuerto() {
        return protocoloPuerto;
    }

    public void setProtocoloPuerto(String protocoloPuerto) {
        this.protocoloPuerto = protocoloPuerto;
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

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
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

    public Integer getPuertoId() {
        return puertoId;
    }

    public void setPuertoId(Integer puertoId) {
        this.puertoId = puertoId;
    }

    public String getInformacionExtra() {
        return informacionExtra;
    }

    public void setInformacionExtra(String informacionExtra) {
        this.informacionExtra = informacionExtra;
    }

    public BackdoorDTO getBackdoor() {
        return backdoor;
    }

    public void setBackdoor(BackdoorDTO backdoor) {
        this.backdoor = backdoor;
    }

    public FallosDeRedDTO getFallosRed() {
        return fallosRed;
    }

    public void setFallosRed(FallosDeRedDTO fallosRed) {
        this.fallosRed = fallosRed;
    }

}

package co.edu.usbbog.datanetworkoverlock.model;

public class NessusDTO {

    private Integer idAnalisisNessus;
    private Integer ip;
    private Integer puerto;
    private Integer hostNumber;
    private String descripcion;
    private String solucion;
    private String nombreDNS;
    private String nombreNetbios;
    private String direccionMac;
    private String nist;
    private String baseScore;
    private String vector;
    private BusquedaVulnerabilidadesDTO busqueda;

    public NessusDTO() {
        this.idAnalisisNessus = 0;
        this.ip = 0;
        this.puerto = 0;
        this.hostNumber = 0;
        this.descripcion = "";
        this.solucion = "";
        this.nombreDNS = "";
        this.nombreNetbios = "";
        this.direccionMac = "";
        this.nist = "";
        this.baseScore = "";
        this.vector = "";
        this.busqueda = new BusquedaVulnerabilidadesDTO();
    }

    public NessusDTO(Integer idAnalisisNessus) {
        this.idAnalisisNessus = idAnalisisNessus;
        this.ip = 0;
        this.puerto = 0;
        this.hostNumber = 0;
        this.descripcion = "";
        this.solucion = "";
        this.nombreDNS = "";
        this.nombreNetbios = "";
        this.direccionMac = "";
        this.nist = "";
        this.baseScore = "";
        this.vector = "";
        this.busqueda = new BusquedaVulnerabilidadesDTO();
    }

    public NessusDTO(Integer idAnalisisNessus, Integer ip, Integer puerto, Integer hostNumber, String descripcion, String solucion, String nombreDNS, String nombreNetbios, String direccionMac, String nist, String baseScore, String vector) {
        this.idAnalisisNessus = idAnalisisNessus;
        this.ip = ip;
        this.puerto = puerto;
        this.hostNumber = hostNumber;
        this.descripcion = descripcion;
        this.solucion = solucion;
        this.nombreDNS = nombreDNS;
        this.nombreNetbios = nombreNetbios;
        this.direccionMac = direccionMac;
        this.nist = nist;
        this.baseScore = baseScore;
        this.vector = vector;
        this.busqueda = new BusquedaVulnerabilidadesDTO();
    }

    public NessusDTO(Integer idAnalisisNessus, Integer ip, Integer puerto, Integer hostNumber, String descripcion, String solucion, String nombreDNS, String nombreNetbios, String direccionMac, String nist, String baseScore, String vector, BusquedaVulnerabilidadesDTO busqueda) {
        this.idAnalisisNessus = idAnalisisNessus;
        this.ip = ip;
        this.puerto = puerto;
        this.hostNumber = hostNumber;
        this.descripcion = descripcion;
        this.solucion = solucion;
        this.nombreDNS = nombreDNS;
        this.nombreNetbios = nombreNetbios;
        this.direccionMac = direccionMac;
        this.nist = nist;
        this.baseScore = baseScore;
        this.vector = vector;
        this.busqueda = busqueda;
    }

    public Integer getIdAnalisisNessus() {
        return idAnalisisNessus;
    }

    public void setIdAnalisisNessus(Integer idAnalisisNessus) {
        this.idAnalisisNessus = idAnalisisNessus;
    }

    public Integer getIp() {
        return ip;
    }

    public void setIp(Integer ip) {
        this.ip = ip;
    }

    public Integer getPuerto() {
        return puerto;
    }

    public void setPuerto(Integer puerto) {
        this.puerto = puerto;
    }

    public Integer getHostNumber() {
        return hostNumber;
    }

    public void setHostNumber(Integer hostNumber) {
        this.hostNumber = hostNumber;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public String getNombreDNS() {
        return nombreDNS;
    }

    public void setNombreDNS(String nombreDNS) {
        this.nombreDNS = nombreDNS;
    }

    public String getNombreNetbios() {
        return nombreNetbios;
    }

    public void setNombreNetbios(String nombreNetbios) {
        this.nombreNetbios = nombreNetbios;
    }

    public String getDireccionMac() {
        return direccionMac;
    }

    public void setDireccionMac(String direccionMac) {
        this.direccionMac = direccionMac;
    }

    public String getNist() {
        return nist;
    }

    public void setNist(String nist) {
        this.nist = nist;
    }

    public String getBaseScore() {
        return baseScore;
    }

    public void setBaseScore(String baseScore) {
        this.baseScore = baseScore;
    }

    public String getVector() {
        return vector;
    }

    public void setVector(String vector) {
        this.vector = vector;
    }

    public BusquedaVulnerabilidadesDTO getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(BusquedaVulnerabilidadesDTO busqueda) {
        this.busqueda = busqueda;
    }

}

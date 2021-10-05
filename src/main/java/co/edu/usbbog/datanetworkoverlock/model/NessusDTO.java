package co.edu.usbbog.datanetworkoverlock.model;

public class NessusDTO {
    private Integer id_analisis_nessus;
    private Integer ip;
    private Integer puerto;
    private Integer host_number;
    private String descripcion;
    private String solucion;
    private String nombre_dns;
    private String nombre_netbios;
    private String direccion_mac;
    private String nist;
    private String base_score;
    private String vector;
    private BusquedaVulnerabilidadesDTO busqueda;

    public NessusDTO() {
        this.id_analisis_nessus = 0;
        this.ip = 0;
        this.puerto = 0;
        this.host_number = 0;
        this.descripcion = "";
        this.solucion = "";
        this.nombre_dns = "";
        this.nombre_netbios = "";
        this.direccion_mac = "";
        this.nist = "";
        this.base_score = "";
        this.vector = "";
        this.busqueda = new BusquedaVulnerabilidadesDTO();
    }

    public NessusDTO(Integer id_analisis_nessus) {
        this.id_analisis_nessus = id_analisis_nessus;
        this.ip = 0;
        this.puerto = 0;
        this.host_number = 0;
        this.descripcion = "";
        this.solucion = "";
        this.nombre_dns = "";
        this.nombre_netbios = "";
        this.direccion_mac = "";
        this.nist = "";
        this.base_score = "";
        this.vector = "";
        this.busqueda = new BusquedaVulnerabilidadesDTO();
    }

    public NessusDTO(Integer id_analisis_nessus, Integer ip, Integer puerto, Integer host_number, String descripcion, String solucion, String nombre_dns, String nombre_netbios, String direccion_mac, String nist, String base_score, String vector) {
        this.id_analisis_nessus = id_analisis_nessus;
        this.ip = ip;
        this.puerto = puerto;
        this.host_number = host_number;
        this.descripcion = descripcion;
        this.solucion = solucion;
        this.nombre_dns = nombre_dns;
        this.nombre_netbios = nombre_netbios;
        this.direccion_mac = direccion_mac;
        this.nist = nist;
        this.base_score = base_score;
        this.vector = vector;
        this.busqueda = new BusquedaVulnerabilidadesDTO();
    }

    public NessusDTO(Integer id_analisis_nessus, Integer ip, Integer puerto, Integer host_number, String descripcion, String solucion, String nombre_dns, String nombre_netbios, String direccion_mac, String nist, String base_score, String vector, BusquedaVulnerabilidadesDTO busqueda) {
        this.id_analisis_nessus = id_analisis_nessus;
        this.ip = ip;
        this.puerto = puerto;
        this.host_number = host_number;
        this.descripcion = descripcion;
        this.solucion = solucion;
        this.nombre_dns = nombre_dns;
        this.nombre_netbios = nombre_netbios;
        this.direccion_mac = direccion_mac;
        this.nist = nist;
        this.base_score = base_score;
        this.vector = vector;
        this.busqueda = busqueda;
    }

    public Integer getId_analisis_nessus() {
        return id_analisis_nessus;
    }

    public void setId_analisis_nessus(Integer id_analisis_nessus) {
        this.id_analisis_nessus = id_analisis_nessus;
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

    public Integer getHost_number() {
        return host_number;
    }

    public void setHost_number(Integer host_number) {
        this.host_number = host_number;
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

    public String getNombre_dns() {
        return nombre_dns;
    }

    public void setNombre_dns(String nombre_dns) {
        this.nombre_dns = nombre_dns;
    }

    public String getNombre_netbios() {
        return nombre_netbios;
    }

    public void setNombre_netbios(String nombre_netbios) {
        this.nombre_netbios = nombre_netbios;
    }

    public String getDireccion_mac() {
        return direccion_mac;
    }

    public void setDireccion_mac(String direccion_mac) {
        this.direccion_mac = direccion_mac;
    }

    public String getNist() {
        return nist;
    }

    public void setNist(String nist) {
        this.nist = nist;
    }

    public String getBase_score() {
        return base_score;
    }

    public void setBase_score(String base_score) {
        this.base_score = base_score;
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

package co.edu.usbbog.datanetworkoverlock.model;

public class KismetDTO {

    private Integer idAnalisisKismet;
    private String nombreRedDetectada;
    private String clientesDetectados;
    private String modoFuncionamientoWifi;
    private String tipoEncriptacion;
    private String canalOperacionRed;
    private String paquetesCapturados;
    private IntrusionesDTO intrusiones;

    public KismetDTO() {
        this.idAnalisisKismet = 0;
        this.nombreRedDetectada = "";
        this.clientesDetectados = "";
        this.modoFuncionamientoWifi = "";
        this.tipoEncriptacion = "";
        this.canalOperacionRed = "";
        this.paquetesCapturados = "";
        this.intrusiones = new IntrusionesDTO();
    }

    public KismetDTO(Integer idAnalisisKismet) {
        this.idAnalisisKismet = idAnalisisKismet;
        this.nombreRedDetectada = "";
        this.clientesDetectados = "";
        this.modoFuncionamientoWifi = "";
        this.tipoEncriptacion = "";
        this.canalOperacionRed = "";
        this.paquetesCapturados = "";
        this.intrusiones = new IntrusionesDTO();
    }

    public KismetDTO(Integer idAnalisisKismet, String nombreRedDetectada, String clientesDetectados, String modoFuncionamientoWifi, String tipoEncriptacion, String canalOperacionRed, String paquetesCapturados) {
        this.idAnalisisKismet = idAnalisisKismet;
        this.nombreRedDetectada = nombreRedDetectada;
        this.clientesDetectados = clientesDetectados;
        this.modoFuncionamientoWifi = modoFuncionamientoWifi;
        this.tipoEncriptacion = tipoEncriptacion;
        this.canalOperacionRed = canalOperacionRed;
        this.paquetesCapturados = paquetesCapturados;
        this.intrusiones = new IntrusionesDTO();
    }

    public KismetDTO(Integer idAnalisisKismet, String nombreRedDetectada, String clientesDetectados, String modoFuncionamientoWifi, String tipoEncriptacion, String canalOperacionRed, String paquetesCapturados, IntrusionesDTO intrusiones) {
        this.idAnalisisKismet = idAnalisisKismet;
        this.nombreRedDetectada = nombreRedDetectada;
        this.clientesDetectados = clientesDetectados;
        this.modoFuncionamientoWifi = modoFuncionamientoWifi;
        this.tipoEncriptacion = tipoEncriptacion;
        this.canalOperacionRed = canalOperacionRed;
        this.paquetesCapturados = paquetesCapturados;
        this.intrusiones = intrusiones;
    }

    public Integer getIdAnalisisKismet() {
        return idAnalisisKismet;
    }

    public void setIdAnalisisKismet(Integer idAnalisisKismet) {
        this.idAnalisisKismet = idAnalisisKismet;
    }

    public String getNombreRedDetectada() {
        return nombreRedDetectada;
    }

    public void setNombreRedDetectada(String nombreRedDetectada) {
        this.nombreRedDetectada = nombreRedDetectada;
    }

    public String getClientesDetectados() {
        return clientesDetectados;
    }

    public void setClientesDetectados(String clientesDetectados) {
        this.clientesDetectados = clientesDetectados;
    }

    public String getModoFuncionamientoWifi() {
        return modoFuncionamientoWifi;
    }

    public void setModoFuncionamientoWifi(String modoFuncionamientoWifi) {
        this.modoFuncionamientoWifi = modoFuncionamientoWifi;
    }

    public String getTipoEncriptacion() {
        return tipoEncriptacion;
    }

    public void setTipoEncriptacion(String tipoEncriptacion) {
        this.tipoEncriptacion = tipoEncriptacion;
    }

    public String getCanalOperacionRed() {
        return canalOperacionRed;
    }

    public void setCanalOperacionRed(String canalOperacionRed) {
        this.canalOperacionRed = canalOperacionRed;
    }

    public String getPaquetesCapturados() {
        return paquetesCapturados;
    }

    public void setPaquetesCapturados(String paquetesCapturados) {
        this.paquetesCapturados = paquetesCapturados;
    }

    public IntrusionesDTO getIntrusiones() {
        return intrusiones;
    }

    public void setIntrusiones(IntrusionesDTO intrusiones) {
        this.intrusiones = intrusiones;
    }

}

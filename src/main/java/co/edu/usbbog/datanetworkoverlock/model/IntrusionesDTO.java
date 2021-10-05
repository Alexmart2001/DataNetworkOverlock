package co.edu.usbbog.datanetworkoverlock.model;

public class IntrusionesDTO {

    private Integer id_intrusion;
    private String unidades_afectadas;
    private Integer ataques;
    private ReportesDTO reporte;

    public IntrusionesDTO() {
        this.id_intrusion = 0;
        this.unidades_afectadas = "";
        this.ataques = 0;
        this.reporte = new ReportesDTO();
    }

    public IntrusionesDTO(Integer id_intrusion) {
        this.id_intrusion = id_intrusion;
        this.unidades_afectadas = "";
        this.ataques = 0;
        this.reporte = new ReportesDTO();
    }

    public IntrusionesDTO(Integer id_intrusion, String unidades_afectadas, Integer ataques) {
        this.id_intrusion = id_intrusion;
        this.unidades_afectadas = unidades_afectadas;
        this.ataques = ataques;
        this.reporte = new ReportesDTO();
    }

    public IntrusionesDTO(Integer id_intrusion, String unidades_afectadas, Integer ataques, ReportesDTO reporte) {
        this.id_intrusion = id_intrusion;
        this.unidades_afectadas = unidades_afectadas;
        this.ataques = ataques;
        this.reporte = reporte;
    }

    public Integer getId_intrusion() {
        return id_intrusion;
    }

    public void setId_intrusion(Integer id_intrusion) {
        this.id_intrusion = id_intrusion;
    }

    public String getUnidades_afectadas() {
        return unidades_afectadas;
    }

    public void setUnidades_afectadas(String unidades_afectadas) {
        this.unidades_afectadas = unidades_afectadas;
    }

    public Integer getAtaques() {
        return ataques;
    }

    public void setAtaques(Integer ataques) {
        this.ataques = ataques;
    }

    public ReportesDTO getReporte() {
        return reporte;
    }

    public void setReporte(ReportesDTO reporte) {
        this.reporte = reporte;
    }
}

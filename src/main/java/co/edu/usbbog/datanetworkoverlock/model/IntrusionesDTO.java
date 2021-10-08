package co.edu.usbbog.datanetworkoverlock.model;

public class IntrusionesDTO {

    private Integer idIntrusion;
    private String unidadesAfectadas;
    private Integer ataques;
    private ReportesDTO reporte;

    public IntrusionesDTO() {
        this.idIntrusion = 0;
        this.unidadesAfectadas = "";
        this.ataques = 0;
        this.reporte = new ReportesDTO();
    }

    public IntrusionesDTO(Integer idIntrusion) {
        this.idIntrusion = idIntrusion;
        this.unidadesAfectadas = "";
        this.ataques = 0;
        this.reporte = new ReportesDTO();
    }

    public IntrusionesDTO(Integer idIntrusion, String unidadesAfectadas, Integer ataques) {
        this.idIntrusion = idIntrusion;
        this.unidadesAfectadas = unidadesAfectadas;
        this.ataques = ataques;
        this.reporte = new ReportesDTO();
    }

    public IntrusionesDTO(Integer idIntrusion, String unidadesAfectadas, Integer ataques, ReportesDTO reporte) {
        this.idIntrusion = idIntrusion;
        this.unidadesAfectadas = unidadesAfectadas;
        this.ataques = ataques;
        this.reporte = reporte;
    }

    public Integer getIdIntrusion() {
        return idIntrusion;
    }

    public void setIdIntrusion(Integer idIntrusion) {
        this.idIntrusion = idIntrusion;
    }

    public String getUnidadesAfectadas() {
        return unidadesAfectadas;
    }

    public void setUnidadesAfectadas(String unidadesAfectadas) {
        this.unidadesAfectadas = unidadesAfectadas;
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

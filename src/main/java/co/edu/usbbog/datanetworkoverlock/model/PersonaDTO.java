package co.edu.usbbog.datanetworkoverlock.model;

public class PersonaDTO {

    private String usuario;
    private String nombre;
    private String apellido;
    private String clave;
    private String email;


    public PersonaDTO() {
        this.usuario = "";
        this.nombre = "";
        this.apellido = "";
        this.clave = "";
        this.email = "";
    }

    public PersonaDTO(String usuario) {
        this.usuario = usuario;
        this.nombre = "";
        this.apellido = "";
        this.clave = "";
        this.email = "";
    }

    public PersonaDTO(String usuario, String nombre, String apellido, String clave, String email) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

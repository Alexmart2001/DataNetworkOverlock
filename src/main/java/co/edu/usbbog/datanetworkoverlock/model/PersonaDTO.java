package co.edu.usbbog.datanetworkoverlock.model;

public class PersonaDTO {

    private String nombre;
    private String apellido;
    private String email;
    private String usuario;
    private String pwd;

    public PersonaDTO(String nombre, String apellido, String email, String usuario, String pwd) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.usuario = usuario;
        this.pwd = pwd;
    }

    public PersonaDTO(String nombre, String apellido, String email, String usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.usuario = usuario;
        this.pwd = "";
    }

    public PersonaDTO() {
        this.nombre = "";
        this.apellido = "";
        this.email = "";
        this.usuario = "";
        this.pwd = "";
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", usuario='" + usuario + '\'' +
                '}';
    }

}

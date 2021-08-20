package co.edu.usbbog.datanetworkoverlock.programa;

public class Usuario {

    private String nombre;
    private String apellido;
    private String user;
    private String pwd;

    public Usuario(String nombre, String apellido, String user, String pwd) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.user = user;
        this.pwd = pwd;
    }

    public Usuario(String nombre, String apellido, String user) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.user = user;
        this.pwd = "";
    }

    public Usuario() {
        this.nombre = "";
        this.apellido = "";
        this.user = "";
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
                ", user='" + user + '\'' +
                '}';
    }

}

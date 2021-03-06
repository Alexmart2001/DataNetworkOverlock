package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.controller.config.Conexion;
import co.edu.usbbog.datanetworkoverlock.model.PersonaDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAOImpl implements PersonaDAO {

    private final Conexion conexion;

    public PersonaDAOImpl() {
        this.conexion = new Conexion();
    }

    @Override
    public boolean create(PersonaDTO persona) {
        try {
            String query = "INSERT INTO persona(usuario, nombre, apellido, clave, correo) "
                    + "VALUES ("
                    + "'" + persona.getUsuario() + "', "
                    + "'" + persona.getNombre() + "', "
                    + "'" + persona.getApellido() + "', "
                    + "'" + persona.getClave() + "', "
                    + "'" + persona.getEmail() + "');";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se inserto el dato");
            return true;
        } catch (SQLTimeoutException e) {
            System.out.println("No se inserto el dato, tiempo de espera agotado");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            System.out.println("No se inserto el dato");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return false;
    }

    @Override
    public boolean edit(PersonaDTO usuario) {
        try {
            String query = "UPDATE persona SET "
                    + "nombre = '" + usuario.getNombre() + "', "
                    + "apellido = '" + usuario.getApellido() + "', "
                    + "clave = '" + usuario.getClave() + "', "
                    + "correo = '" + usuario.getEmail() + "' "
                    + "WHERE usuario = '" + usuario.getUsuario() + "';";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se modifico el dato");
            return true;
        } catch (SQLTimeoutException e) {
            System.out.println("No se modific?? el dato, tiempo de espera agotado");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            System.out.println("Error al modificar el dato");
            System.out.println("Error: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
        }
        return false;
    }

    @Override
    public boolean remove(String usuario) {
        try {
            String query = "DELETE FROM persona WHERE usuario = '" + usuario + "';";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se elimino el dato");
            return true;
        } catch (SQLTimeoutException e) {
            System.out.println("No se elimino el dato, tiempo de espera agotado");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            System.out.println("No se elimino el dato");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return false;
    }

    @Override
    public PersonaDTO validate(String usuario, String clave) {
        return query(1, usuario, clave);
    }

    @Override
    public PersonaDTO find(String usuario) {
        return query(0, usuario, null);
    }

    @Override
    public List<PersonaDTO> findAll() {
        List<PersonaDTO> personas = new ArrayList<>();
        PersonaDTO persona;
        try {
            String query = "SELECT * FROM persona;";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                persona = new PersonaDTO(
                        rs.getString("usuario"),
                        rs.getString("nombre"),
                        rs.getString("Apellido"),
                        rs.getString("clave"),
                        rs.getString("correo"));
                personas.add(persona);
            }
            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvieron los datos");
            return personas;
        } catch (SQLTimeoutException e) {
            System.out.println("No se obtuvieron los datos, tiempo de espera agotado");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            System.out.println("No se obtuvieron los datos");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return null;
    }

    @Override
    public int count() {
        return findAll().size();
    }

    private PersonaDTO query(int option, String usuario, String clave) {
        PersonaDTO persona;
        try {
            String query =
                    option == 0 ?
                            "SELECT * FROM persona WHERE usuario = '" + usuario + "';"
                            :
                            "SELECT * FROM persona WHERE usuario = '" + usuario + "' AND clave = '" + clave + "';";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            persona = new PersonaDTO(
                    rs.getString("usuario"),
                    rs.getString("nombre"),
                    rs.getString("Apellido"),
                    rs.getString("clave"),
                    rs.getString("correo"));
            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvo el dato");
            return persona;
        } catch (SQLTimeoutException e) {
            System.out.println("No se obtuvo el dato, tiempo de espera agotado");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            System.out.println("No se obtuvo el dato");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return null;
    }

}

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

    public PersonaDAOImpl(){
        this.conexion = new Conexion();

    }

    @Override
    public boolean create(PersonaDTO persona) {
        boolean seHizo = false;
        try{
            String query = "INSERT INTO persona(usuario, nombre, apellido, clave, correo)"
                    + "VALUES ("
                    +"'"+ persona.getUsuario() + "',"
                    +"'" + persona.getNombre() + "',"
                    +"'" + persona.getApellido() + "',"
                    +"'" + persona.getClave() + "',"
                    +"'" + persona.getEmail() + ");";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se inserto el dato");
            seHizo = true;
        } catch (SQLTimeoutException e) {
            seHizo = false;
            System.out.println("No se inserto el dato");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            seHizo = false;
            System.out.println("No se inserto el dato");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return seHizo;
    }

    @Override
    public boolean edit(PersonaDTO persona) {
        try {
            String query = "UPDATE persona SET"
                    + "usuario = '" + persona.getUsuario() + "',"
                    + "nombre = '" + persona.getNombre() + "',"
                    + "apellido = '" + persona.getApellido() + "',"
                    + "clave = '" + persona.getClave() + "',"
                    + "correo = '" + persona.getEmail() + "',"
                    + ";";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se modifico el dato");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar el dato");
            System.out.println("Error: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
        }
        return false;
    }

    @Override
    public boolean remove(String usuario) {
        boolean seHizo = false;
        try{
            String query = "DELETE FROM persona where usuario = " + usuario + ";";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se elimino el dato");
            seHizo = true;
        } catch (SQLTimeoutException e) {
            seHizo = false;
            System.out.println("No se elimino el dato");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            seHizo = false;
            System.out.println("No se elimino el dato");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return seHizo;
    }


    @Override
    public PersonaDTO find(String usuario) {
        PersonaDTO persona = null;
        try{
            String query = "SELECT * FROM persona WHERE usuario = "+ usuario + ";";
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
        } catch (SQLTimeoutException e) {
            persona = null;
            System.out.println("No se obtuvo el dato");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            persona = null;
            System.out.println("No se obtuvo el dato");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return persona;
    }

    @Override
    public List<PersonaDTO> findAll() {
        List<PersonaDTO> persona = new ArrayList<>();
        PersonaDTO personaa = null;
        try{
            String query = "SELECT*FROM persona;";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                personaa = new PersonaDTO(
                        rs.getString("usuario"),
                        rs.getString("nombre"),
                        rs.getString("Apellido"),
                        rs.getString("clave"),
                        rs.getString("correo"));
                        persona.add(personaa);
            }
            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvieron los datos");
        } catch (SQLTimeoutException e) {
            persona = new ArrayList<>();
            System.out.println("No se obtuvieron los datos");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            persona = new ArrayList<>();
            System.out.println("No se obtuvieron los datos");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return persona;
    }

    @Override
    public int count() {
        return findAll().size();
    }
}

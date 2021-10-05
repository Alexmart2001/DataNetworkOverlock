package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.controller.config.Conexion;
import co.edu.usbbog.datanetworkoverlock.model.FallosDeRedDTO;
import co.edu.usbbog.datanetworkoverlock.model.ReportesDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FallosDeRedDAOImpl implements FallosDeRedDAO {

    private final Conexion conexion;

    public FallosDeRedDAOImpl() {
        this.conexion = new Conexion();
    }


    @Override
    public boolean create(FallosDeRedDTO fallos) {
        boolean seHizo = false;
        try {
            String query = "INSERT INTO fallos_de_red(id_fallo, tipo_fallo, descripcion, fecha, reporte)"
                    + " VALUES ("
                    + fallos.getId_fallo() + ","
                    + "'" + fallos.getTipo_fallo() + "',"
                    + "'" + fallos.getDescripcion() + "',"
                    + "'" + fallos.getFecha() + "',"
                    + fallos.getReporte().getId_reporte()
                    + ");";
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
    public boolean edit(FallosDeRedDTO fallos) {
        try {
            String query = "UPDATE fallos_de_red SET"
                    + "id_fallo = " + fallos.getId_fallo() + ", "
                    + "tipo_fallo = '" + fallos.getTipo_fallo() + "', "
                    + "descripcion = '" + fallos.getDescripcion() + "', "
                    + "fecha = '" + fallos.getFecha() + "', "
                    + "reporte = " + fallos.getReporte().getId_reporte()
                    + " WHERE id_fallo = " + fallos.getId_fallo() + ";";
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
    public boolean remove(Integer id_fallo) {
        boolean seHizo = false;
        try {
            String query = "DELETE FROM fallos_de_red WHERE id_fallo = " + id_fallo + ";";
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
    public FallosDeRedDTO find(Integer id_fallo) {
        FallosDeRedDTO fallos = null;
        ReportesDTO reporte;
        ReportesDAO reportedao = new ReportesDAOImpl();
        try {
            String query = "SELECT * FROM fallos_de_red WHERE id_fallo = " + id_fallo + ";";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            reporte = reportedao.find(rs.getInt("reporte"));
            fallos = new FallosDeRedDTO(
                    rs.getInt("id_fallo"),
                    rs.getString("tipo_fallo"),
                    rs.getString("descripcion"),
                    prueba(rs.getTime("fecha")),
                    reporte);
            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvo el empleado");
        } catch (SQLTimeoutException e) {
            fallos = null;
            System.out.println("No se obtuvo el empleado");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            fallos = null;
            System.out.println("No se obtuvo el empleado");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return fallos;
    }

    @Override
    public List<FallosDeRedDTO> findAll() {
        List<FallosDeRedDTO> falloss = new ArrayList<>();
        FallosDeRedDTO fallo = null;
        ReportesDTO reporte;
        ReportesDAO reportedao = new ReportesDAOImpl();
        try{
            String query = "SELECT * FROM fallos_de_red;";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                reporte = reportedao.find(rs.getInt("reporte"));
                fallo = new FallosDeRedDTO(
                        rs.getInt("id_fallo"),
                        rs.getString("tipo_fallo"),
                        rs.getString("descripcion"),
                        prueba(rs.getTime("fecha")),
                        reporte);
                falloss.add(fallo);
            }
            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvieron los datos");
        } catch (SQLTimeoutException e) {
            falloss = new ArrayList<>();
            System.out.println("No se obtuvieron los datos");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            falloss = new ArrayList<>();
            System.out.println("No se obtuvieron los datos");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return falloss;
    }

    @Override
    public int count() {
        return findAll().size();
    }

    public Calendar prueba(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}

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
    public boolean create(FallosDeRedDTO fallo) {
        try {
            String query = "INSERT INTO fallos_de_red(id_fallo, tipo_fallo, descripcion, fecha, reporte)"
                    + " VALUES ("
                    + fallo.getIdFallo() + ","
                    + "'" + fallo.getTipoFallo() + "',"
                    + "'" + fallo.getDescripcion() + "',"
                    + "'" + fallo.getFecha() + "',"
                    + fallo.getReporte().getIdReporte()
                    + ");";
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
    public boolean edit(FallosDeRedDTO idFallo) {
        try {
            String query = "UPDATE fallos_de_red SET"
                    + "id_fallo = " + idFallo.getIdFallo() + ", "
                    + "tipo_fallo = '" + idFallo.getTipoFallo() + "', "
                    + "descripcion = '" + idFallo.getDescripcion() + "', "
                    + "fecha = '" + idFallo.getFecha() + "', "
                    + "reporte = " + idFallo.getReporte().getIdReporte()
                    + " WHERE id_fallo = " + idFallo.getIdFallo() + ";";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se modifico el dato");
            return true;
        } catch (SQLTimeoutException e) {
            System.out.println("No se modificó el dato, tiempo de espera agotado");
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
    public boolean remove(Integer idFallo) {
        try {
            String query = "DELETE FROM fallos_de_red WHERE id_fallo = " + idFallo + ";";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se elimino el dato");
            return true;
        } catch (SQLTimeoutException e) {
            System.out.println("No se eliminó el dato, tiempo de espera agotado");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            System.out.println("No se eliminó el dato");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return false;
    }

    @Override
    public FallosDeRedDTO find(Integer idFallo) {
        FallosDeRedDTO fallos;
        ReportesDTO reportesDTO;
        ReportesDAO reportesDAO = new ReportesDAOImpl();
        try {
            String query = "SELECT * FROM fallos_de_red WHERE id_fallo = " + idFallo + ";";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            reportesDTO = reportesDAO.find(rs.getInt("reporte"));
            fallos = new FallosDeRedDTO(
                    rs.getInt("id_fallo"),
                    rs.getString("tipo_fallo"),
                    rs.getString("descripcion"),
                    prueba(rs.getTime("fecha")),
                    reportesDTO);
            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvo el empleado");
            return fallos;
        } catch (SQLTimeoutException e) {
            System.out.println("No se obtuvo el empleado, tiempo de espera agotado");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            System.out.println("No se obtuvo el empleado");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return null;
    }

    @Override
    public List<FallosDeRedDTO> findAll() {
        List<FallosDeRedDTO> fallos = new ArrayList<>();
        FallosDeRedDTO fallosDeRedDTO;
        ReportesDTO reportesDTO;
        ReportesDAO reportesDAO = new ReportesDAOImpl();
        try {
            String query = "SELECT * FROM consola.fallos_de_red;";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                reportesDTO = reportesDAO.find(rs.getInt("reporte"));
                fallosDeRedDTO = new FallosDeRedDTO(
                        rs.getInt("id_fallo"),
                        rs.getString("tipo_fallo"),
                        rs.getString("descripcion"),
                        prueba(rs.getTime("fecha")),
                        reportesDTO);
                fallos.add(fallosDeRedDTO);
            }
            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvieron los datos");
            return fallos;
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

    public Calendar prueba(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

}

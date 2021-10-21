
package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.controller.config.Conexion;
import co.edu.usbbog.datanetworkoverlock.model.BackdoorDTO;
import co.edu.usbbog.datanetworkoverlock.model.ReportesDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BackdoorDAOImpl implements BackdoorDAO {

    private final Conexion conexion;

    public BackdoorDAOImpl() {
        this.conexion = new Conexion();
    }

    @Override
    public boolean create(BackdoorDTO backdoor) {
        try {
            String query = "INSERT INTO backdoor(id_backdoor, tipo_backdoor, descripcion, fecha, reporte) VALUES ("
                    + backdoor.getIdBackdoor() + ","
                    + backdoor.getTipoBackdoor() + ","
                    + backdoor.getDescripcion() + ","
                    + backdoor.getFecha() + ","
                    + backdoor.getReporte().getIdReporte() +
                    ");";
            System.out.println("query");
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
    public boolean edit(BackdoorDTO idBackdoor) {
        try {
            String query = "UPDATE backdoor SET "
                    + "id_backdoor = " + idBackdoor.getIdBackdoor() + ", "
                    + "tipo_backdoor = " + idBackdoor.getTipoBackdoor() + ", "
                    + "descripcion = " + idBackdoor.getDescripcion() + ", "
                    + "fecha = " + idBackdoor.getFecha() + ", "
                    + "reporte = " + idBackdoor.getReporte().getIdReporte()
                    + " WHERE id_backdoor = " + idBackdoor.getIdBackdoor() + ";";
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
    public boolean remove(Integer idBackdoor) {
        try {
            String query = "DELETE FROM backdoor WHERE id_backdoor = " + idBackdoor + ";";
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
    public BackdoorDTO find(Integer idBackdoor) {
        BackdoorDTO backdoor;
        ReportesDTO reportesDTO;
        ReportesDAO reportesDAO = new ReportesDAOImpl();
        try {
            String query = "SELECT * FROM backdoor WHERE id_backdoor = " + idBackdoor + ";";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            reportesDTO = reportesDAO.find(rs.getInt("reporte"));

            backdoor = new BackdoorDTO(
                    rs.getInt("id_backdoor"),
                    rs.getString("tipo_backdoor"),
                    rs.getString("descripcion"),
                    prueba(rs.getTime("fecha")),
                    reportesDTO);

            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvo el dato");
            return backdoor;
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

    @Override
    public List<BackdoorDTO> findAll() {
        List<BackdoorDTO> backdoor = new ArrayList<>();
        BackdoorDTO backdoorDTO;
        ReportesDTO reportesDTO;
        ReportesDAO reportesDAO = new ReportesDAOImpl();
        try {
            String query = "SELECT * FROM backdoor;";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                reportesDTO = reportesDAO.find(rs.getInt("reporte"));
                backdoorDTO = new BackdoorDTO(
                        rs.getInt("id_backdoor"),
                        rs.getString("tipo_backdoor"),
                        rs.getString("descripcion"),
                        prueba(rs.getTime("fecha")),
                        reportesDTO);
                backdoor.add(backdoorDTO);
            }
            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvieron los datos");
            return backdoor;
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

package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.controller.config.Conexion;
import co.edu.usbbog.datanetworkoverlock.model.BusquedaVulnerabilidadesDTO;
import co.edu.usbbog.datanetworkoverlock.model.ReportesDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BusquedaVulnerabilidadesDAOImpl implements BusquedaVulnerabilidadesDAO {

    private final Conexion conexion;

    public BusquedaVulnerabilidadesDAOImpl() {
        this.conexion = new Conexion();
    }

    @Override
    public boolean create(BusquedaVulnerabilidadesDTO resultado) {
        try {
            String query = "INSERT INTO (id_busqueda, descripcion, fecha, codigo_cve, base_score,vector,reporte ) "
                    + " VALUES ("
                    + resultado.getIdBusqueda() + ","
                    + "'" + resultado.getDescripcion() + "',"
                    + "'" + resultado.getFecha() + "',"
                    + "'" + resultado.getFecha() + "',"
                    + "'" + resultado.getCodigoCVE() + "',"
                    + "'" + resultado.getBaseScore() + "',"
                    + "'" + resultado.getVector() + "',"
                    + resultado.getReporte().getIdReporte()
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
    public boolean edit(BusquedaVulnerabilidadesDTO idBusqueda) {
        try {
            String query = "UPDATE busqueda_vulnerabilidades SET "
                    + "id_busqueda = " + idBusqueda.getIdBusqueda() + ","
                    + "descripcion = '" + idBusqueda.getDescripcion() + "',"
                    + "fecha = '" + idBusqueda.getFecha() + "',"
                    + "codigo_cve = '" + idBusqueda.getCodigoCVE() + "',"
                    + "base_score = '" + idBusqueda.getBaseScore() + "',"
                    + "vector = '" + idBusqueda.getVector() + "',"
                    + "reporte = " + idBusqueda.getReporte().getIdReporte()
                    + "WHERE id_busqueda = " + idBusqueda.getIdBusqueda() + ";";
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
    public boolean remove(Integer idBusqueda) {
        try {
            String query = "DELETE FROM busqueda_vulnerabilidades WHERE id_busqueda = " + idBusqueda + ";";
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
            System.out.println("No se elimino el dato");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return false;
    }

    @Override
    public BusquedaVulnerabilidadesDTO find(Integer idBusqueda) {
        BusquedaVulnerabilidadesDTO busqueda = null;
        ReportesDTO reportesDTO;
        ReportesDAO reportesDAO = new ReportesDAOImpl();
        try {
            String query = "SELECT * FROM busqueda_vulnerabilidades = " + idBusqueda + ";";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            reportesDTO = reportesDAO.find(rs.getInt("reporte"));
            busqueda = new BusquedaVulnerabilidadesDTO(
                    rs.getInt("id_busqueda"),
                    rs.getString("descripcion"),
                    prueba(rs.getTime("fecha")),
                    rs.getInt("codigo_cve"),
                    rs.getString("base_score"),
                    rs.getString("vector"),
                    reportesDTO);
            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvo el dato");
            return busqueda;
        } catch (SQLTimeoutException e) {
            System.out.println("No se encontró el dato, tiempo de espera agotado");
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
    public List<BusquedaVulnerabilidadesDTO> findAll() {
        List<BusquedaVulnerabilidadesDTO> listado = new ArrayList<>();
        BusquedaVulnerabilidadesDTO busqueda;
        ReportesDTO reportesDTO;
        ReportesDAO reportesDAO = new ReportesDAOImpl();
        try {
            String query = "SELECT * FROM busqueda_vulnerabilidades;";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                reportesDTO = reportesDAO.find(rs.getInt("reporte"));
                busqueda = new BusquedaVulnerabilidadesDTO(
                        rs.getInt("id_busqueda"),
                        rs.getString("descripcion"),
                        prueba(rs.getTime("fecha")),
                        rs.getInt("codigo_cve"),
                        rs.getString("base_score"),
                        rs.getString("vector"),
                        reportesDTO);
                listado.add(busqueda);
            }
            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvieron los datos");
            return listado;
        } catch (SQLTimeoutException e) {
            System.out.println("No se encontraron datos, tiempo de espera agotado");
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

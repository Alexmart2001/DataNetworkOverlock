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

public class BusquedaVulnerabilidadesDAOImpl implements BusquedaVulnerabilidadesDAO{

    private final Conexion conexion;

    public BusquedaVulnerabilidadesDAOImpl(){
        this.conexion = new Conexion();
    }

    @Override
    public boolean create(BusquedaVulnerabilidadesDTO busqueda) {
        boolean seHizo = false;
        try{
            String query = "INSERT INTO (id_busqueda, descripcion, fecha, codigo_cve, base_score,vector,reporte ) "
                    + " VALUES ("
                    + busqueda.getId_busqueda() + ","
                    + "'" + busqueda.getDescripcion() + "',"
                    + "'" + busqueda.getFecha() + "',"
                    + "'" + busqueda.getFecha() + "',"
                    + "'" + busqueda.getCodigo_cve() + "',"
                    + "'" + busqueda.getBase_score() + "',"
                    + "'" + busqueda.getVector() + "',"
                    + busqueda.getReporte().getId_reporte()
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
    public boolean edit(BusquedaVulnerabilidadesDTO busqueda) {
        try {
            String query = "UPDATE busqueda_vulnerabilidades SET "
                    + "id_busqueda = " + busqueda.getId_busqueda() + ","
                    + "descripcion = '" + busqueda.getDescripcion() + "',"
                    + "fecha = '" + busqueda.getFecha() + "',"
                    + "codigo_cve = '" +  busqueda.getCodigo_cve() + "',"
                    + "base_score = '" + busqueda.getBase_score() + "',"
                    + "vector = '" + busqueda.getVector() + "',"
                    + "reporte = " + busqueda.getReporte().getId_reporte()
                    + "WHERE id_busqueda = " + busqueda.getId_busqueda() + ";";
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
    public boolean remove(Integer id_busqueda) {
        boolean seHizo = false;
        try{
            String query = "DELETE FROM busqueda_vulnerabilidades WHERE id_busqueda = " + id_busqueda + ";";
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
    public BusquedaVulnerabilidadesDTO find(Integer id_busqueda) {
       BusquedaVulnerabilidadesDTO busqueda = null;
        ReportesDTO reporte;
        ReportesDAO reportedao = new ReportesDAOImpl();
        try{
            String query = "SELECT*FROM busqueda_vulnerabilidades = " + id_busqueda + ";";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            reporte = reportedao.find(rs.getInt("reporte"));
            busqueda = new BusquedaVulnerabilidadesDTO(
                    rs.getInt("id_busqueda"),
                    rs.getString("descripcion"),
                    prueba(rs.getTime("fecha")),
                    rs.getInt("codigo_cve"),
                    rs.getString("base_score"),
                    rs.getString("vector"),
                    reporte);
            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvo el dato");
        } catch (SQLTimeoutException e) {
            busqueda = null;
            System.out.println("No se obtuvo el dato");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            busqueda = null;
            System.out.println("No se obtuvo el dato");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return busqueda;
    }

    @Override
    public List<BusquedaVulnerabilidadesDTO> findAll() {
       List<BusquedaVulnerabilidadesDTO> busquedas = new ArrayList<>();
       BusquedaVulnerabilidadesDTO busqueda = null;
       ReportesDTO reporte;
       ReportesDAO reportedao = new ReportesDAOImpl();
       try{
           String query = "SELECT * FROM busqueda_vulnerabilidades;";
           System.out.println(query);
           this.conexion.conectar();
           Statement stmt = this.conexion.getConnection().createStatement();
           ResultSet rs = stmt.executeQuery(query);
           while (rs.next()) {
               reporte = reportedao.find(rs.getInt("reporte"));
               busqueda = new BusquedaVulnerabilidadesDTO(
                       rs.getInt("id_busqueda"),
                       rs.getString("descripcion"),
                       prueba(rs.getTime("fecha")),
                       rs.getInt("codigo_cve"),
                       rs.getString("base_score"),
                       rs.getString("vector"),
                       reporte);
               busquedas.add(busqueda);
           }
           rs.close();
           stmt.close();
           this.conexion.desconectar();
           System.out.println("Se obtuvieron los datos");
       } catch (SQLTimeoutException e) {
           busquedas = new ArrayList<>();
           System.out.println("No se obtuvieron los datos");
           System.out.println("Causa: " + e.getMessage());
           System.out.println("Causa: " + e.getSQLState());
       } catch (SQLException e) {
           busquedas = new ArrayList<>();
           System.out.println("No se obtuvieron los datos");
           System.out.println("Causa: " + e.getMessage());
           System.out.println("Causa: " + e.getSQLState());
       }
        return busquedas;
    }

    @Override
    public int count() {
        return findAll().size();
    }

    public Calendar prueba (Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}

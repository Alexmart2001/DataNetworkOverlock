package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.controller.config.Conexion;
import co.edu.usbbog.datanetworkoverlock.model.PersonaDTO;
import co.edu.usbbog.datanetworkoverlock.model.RegistroCambiosDTO;
import co.edu.usbbog.datanetworkoverlock.model.ReportesDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReportesDAOImpl implements ReportesDAO{

    private final Conexion conexion;

    public ReportesDAOImpl() {
        this.conexion = new Conexion();
    }

    @Override
    public boolean create(ReportesDTO reporte) {
        try {
            String query = "INSERT INTO backdoor(id_registro, nombre_reporte, tipo_reporte, descripcion, fecha) VALUES ("
                    + reporte.getIdReporte() + ","
                    + reporte.getNombreReporte() + ","
                    + reporte.getTipoReporte() + ","
                    + reporte.getDescripcion() + ","
                    + reporte.getFecha() + ","+
                    ");";
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
    public ReportesDTO find(Integer id_reporte) {
        ReportesDTO reportesDTO;
        try {
            String query = "SELECT * FROM backdoor WHERE id_reporte = " + id_reporte + ";";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            reportesDTO = new ReportesDTO(
                    rs.getInt("id_reporte"),
                    rs.getString("nombre_reporte"),
                    rs.getString("tipo_reporte"),
                    rs.getString("descripcion"),
                    calendario(rs.getTime("fecha"))
                );

            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvo el dato");
            return reportesDTO;
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
    public List<ReportesDTO> findAll() {
        List<ReportesDTO> reportes = new ArrayList<>();
        ReportesDTO reportesDTO;
        try {
            String query = "SELECT * FROM backdoor;";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            reportesDTO = new ReportesDTO(
                    rs.getInt("id_reporte"),
                    rs.getString("nombre_reporte"),
                    rs.getString("tipo_reporte"),
                    rs.getString("descripcion"),
                    calendario(rs.getTime("fecha")));
                    reportes.add(reportesDTO);

            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvo el dato");
            return reportes;
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
    public int count() {
        return findAll().size();
    }

    public Calendar calendario(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}

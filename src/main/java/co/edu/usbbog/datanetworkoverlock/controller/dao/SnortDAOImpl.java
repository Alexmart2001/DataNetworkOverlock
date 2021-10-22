package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.controller.config.Conexion;
import co.edu.usbbog.datanetworkoverlock.model.IntrusionesDTO;
import co.edu.usbbog.datanetworkoverlock.model.RegistroCambiosDTO;
import co.edu.usbbog.datanetworkoverlock.model.SnortDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SnortDAOImpl implements SnortDAO {

    private final Conexion conexion;

    public SnortDAOImpl() {
        this.conexion = new Conexion();
    }

    @Override
    public boolean create(SnortDTO snort) {

        try {
            String query = "INSERT INTO backdoor(id_analisis_snort, fecha, hora, prioridad, nombre_host, mensaje, intrusiones) VALUES ("
                    + snort.getIdAnalisisSnort() + ","
                    + snort.getFecha() + ","
                    + snort.getHora() + ","
                    + snort.getPrioridad() + ","
                    + snort.getNombre_host() + ","
                    + snort.getMensaje() + ","
                    + snort.getIntrusiones().getIdIntrusion() +
                    ");";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se inserto el dato");
            return true;
        } catch (
                SQLTimeoutException e) {
            System.out.println("No se inserto el dato, tiempo de espera agotado");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (
                SQLException e) {
            System.out.println("No se inserto el dato");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return false;
    }
    @Override
    public SnortDTO find(Integer id_analisis_snort) {
        SnortDTO snort;
        IntrusionesDTO intrusionesDTO;
        IntrusionesDAO intrusionesDAO = new IntrusionesDAOImpl();
        try {
            String query = "SELECT * FROM snort WHERE id_analisis_snort = " + id_analisis_snort + ";";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            intrusionesDTO = intrusionesDAO.find(rs.getInt("escaneo"));
            snort = new SnortDTO(
                    rs.getInt("id_analisis_snort"),
                    calendario(rs.getTime("fecha")),
                    cal(rs.getTime("hora")),
                    rs.getString("prioridad"),
                    rs.getString("nombre_host"),
                    rs.getString("mensaje"),
                    intrusionesDTO);

            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvo el dato");
            return snort;
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
    public List<SnortDTO> findAll() {
        List<SnortDTO> snortDTOList = new ArrayList<>();
        SnortDTO snort;
        IntrusionesDTO intrusionesDTO;
        IntrusionesDAO intrusionesDAO = new IntrusionesDAOImpl();
        try {
            String query = "SELECT * FROM snort;";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            intrusionesDTO = intrusionesDAO.find(rs.getInt("escaneo"));

            snort = new SnortDTO(
                    rs.getInt("id_analisis_snort"),
                    calendario(rs.getTime("fecha")),
                    cal(rs.getTime("hora")),
                    rs.getString("prioridad"),
                    rs.getString("nombre_host"),
                    rs.getString("mensaje"),
                    intrusionesDTO);
                    snortDTOList.add(snort);

            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvo el dato");
            return snortDTOList;
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

    public Calendar cal(Time date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}

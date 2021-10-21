package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.controller.config.Conexion;
import co.edu.usbbog.datanetworkoverlock.model.BackdoorDTO;
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

public class RegistroCambiosDAOImpl implements RegistroCambiosDAO {

    private final Conexion conexion;

    public RegistroCambiosDAOImpl() {
        this.conexion = new Conexion();
    }

    @Override
    public boolean create(RegistroCambiosDTO registro) {
        try {
            String query = "INSERT INTO backdoor(id_registro, descripcion, fecha, usuario, reporte) VALUES ("
                    + registro.getIdRegistro() + ","
                    + registro.getDescripcion() + ","
                    + registro.getFecha() + ","
                    + registro.getUsuario().getUsuario() +
                    + registro.getReporte().getIdReporte() +
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
    public RegistroCambiosDTO find(Integer id_registro) {
        RegistroCambiosDTO rc;
        ReportesDTO reportesDTO;
        PersonaDTO usuarioDTO;
        ReportesDAO reportesDAO = new ReportesDAOImpl();
        PersonaDAO usuarioDAO = new PersonaDAOImpl();
        try {
            String query = "SELECT * FROM backdoor WHERE id_registro = " + id_registro + ";";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            reportesDTO = reportesDAO.find(rs.getInt("reporte"));
            usuarioDTO = usuarioDAO.find(rs.getString("usuario"));

            rc = new RegistroCambiosDTO(
                    rs.getInt("id_registro"),
                    rs.getString("descripcion"),
                    calendario(rs.getTime("fecha")),
                    usuarioDTO,
                    reportesDTO);

            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvo el dato");
            return rc;
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
    public List<RegistroCambiosDTO> findAll() {
        List<RegistroCambiosDTO> r = new ArrayList<>();
        RegistroCambiosDTO rc;
        ReportesDTO reportesDTO;
        PersonaDTO usuarioDTO;
        ReportesDAO reportesDAO = new ReportesDAOImpl();
        PersonaDAO usuarioDAO = new PersonaDAOImpl();
        try {
            String query = "SELECT * FROM registro_cambios;";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            reportesDTO = reportesDAO.find(rs.getInt("reporte"));
            usuarioDTO = usuarioDAO.find(rs.getString("usuario"));

            rc = new RegistroCambiosDTO(
                    rs.getInt("id_registro"),
                    rs.getString("descripcion"),
                    calendario(rs.getTime("fecha")),
                    usuarioDTO,
                    reportesDTO);
                    r.add(rc);

            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvo el dato");
            return r;
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

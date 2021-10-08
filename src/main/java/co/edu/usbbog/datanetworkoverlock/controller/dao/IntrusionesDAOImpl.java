package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.controller.config.Conexion;
import co.edu.usbbog.datanetworkoverlock.model.IntrusionesDTO;
import co.edu.usbbog.datanetworkoverlock.model.ReportesDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IntrusionesDAOImpl implements IntrusionesDAO {

    private final Conexion conexion;

    public IntrusionesDAOImpl() {
        this.conexion = new Conexion();
    }

    @Override
    public boolean create(IntrusionesDTO intrusion) {
        try {
            String query = "INSERT INTO intrusiones (id_intrusion, unidades_afectadas, ataques, reporte)"
                    + "VALUES ("
                    + intrusion.getIdIntrusion() + ","
                    + "'" + intrusion.getUnidadesAfectadas() + "',"
                    + intrusion.getAtaques() + ","
                    + intrusion.getReporte().getIdReporte()
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
    public boolean edit(IntrusionesDTO idintrusion) {
        try {
            String query = "UPDATE intrusiones SET "
                    + "id_intrusion = " + idintrusion.getIdIntrusion() + ","
                    + "unidades_afectadas = '" + idintrusion.getIdIntrusion() + "',"
                    + "ataques = " + idintrusion.getAtaques()
                    + "reporte = " + idintrusion.getReporte().getIdReporte()
                    + " WHERE id_intrusion = " + idintrusion.getIdIntrusion() + ";";
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
    public boolean remove(Integer idIntrusion) {
        try {
            String query = "DELETE FROM intrusiones WHERE id_intrusion = " + idIntrusion + ";";
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
    public IntrusionesDTO find(Integer idIntrusion) {
        IntrusionesDTO intrusion;
        ReportesDTO reportesDTO;
        ReportesDAO reportesDAO = new ReportesDAOImpl();
        try {
            String query = "SELECT * FROM intrusiones WHERE id_intrusion = " + idIntrusion + ";";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            reportesDTO = reportesDAO.find(rs.getInt("reporte"));
            intrusion = new IntrusionesDTO(
                    rs.getInt("id_intrusion"),
                    rs.getString("unidades_afectadas"),
                    rs.getInt("ataques"),
                    reportesDTO);
            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvo el dato");
            return intrusion;
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
    public List<IntrusionesDTO> findAll() {
        List<IntrusionesDTO> intrusiones = new ArrayList<>();
        IntrusionesDTO intrusion;
        ReportesDTO reportesDTO;
        ReportesDAO reportesDAO = new ReportesDAOImpl();
        try {
            String query = "SELECT * FROM intrusiones;";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                reportesDTO = reportesDAO.find(rs.getInt("reporte"));
                intrusion = new IntrusionesDTO(
                        rs.getInt("id_intrusion"),
                        rs.getString("unidades_afectadas"),
                        rs.getInt("ataques"),
                        reportesDTO);
                intrusiones.add(intrusion);
            }
            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvieron los empleados");
            return intrusiones;
        } catch (SQLTimeoutException e) {
            System.out.println("No se encontró ningún dato, tiempo de espera agotado");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            System.out.println("No se obtuvieron los empleados");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return null;
    }

    @Override
    public int count() {
        return findAll().size();
    }

}

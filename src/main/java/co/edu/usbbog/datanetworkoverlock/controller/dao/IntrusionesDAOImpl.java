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
    public boolean create(IntrusionesDTO intrusiones) {
        boolean seHizo = false;
        try {
            String query = "INSERT INTO intrusiones (id_intrusion, unidades_afectadas, ataques, reporte)"
                    + "VALUES ("
                    + intrusiones.getId_intrusion() + ","
                    + "'" + intrusiones.getUnidades_afectadas() + "',"
                    + intrusiones.getAtaques() + ","
                    + intrusiones.getReporte().getId_reporte()
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
    public boolean edit(IntrusionesDTO intrusiones) {
        try {
            String query = "UPDATE intrusiones SET "
                    + "id_intrusion = " + intrusiones.getId_intrusion() + ","
                    + "unidades_afectadas = '" + intrusiones.getId_intrusion() + "',"
                    + "ataques = " + intrusiones.getAtaques()
                    + "reporte = " + intrusiones.getReporte().getId_reporte()
                    + " WHERE id_intrusion = " + intrusiones.getId_intrusion() + ";";
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
    public boolean remove(Integer id_intrusion) {
        boolean seHizo = false;
        try {
            String query = "DELETE FROM intrusiones WHERE id_intrusion = " + id_intrusion + ";";
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
    public IntrusionesDTO find(Integer id_intrusion) {
        IntrusionesDTO intrusion = null;
        ReportesDTO reporte;
        ReportesDAO reportedao = new ReportesDAOImpl();
        try {
            String query = "SELECT * FROM intrusiones WHERE id_intrusion = " + id_intrusion + ";";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            reporte = reportedao.find(rs.getInt("reporte"));
            intrusion = new IntrusionesDTO(
                    rs.getInt("id_intrusion"),
                    rs.getString("unidades_afectadas"),
                    rs.getInt("ataques"),
                    reporte);
            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvo el dato");
        } catch (SQLTimeoutException e) {
            intrusion = null;
            System.out.println("No se obtuvo el dato");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            intrusion = null;
            System.out.println("No se obtuvo el dato");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return intrusion;
    }

    @Override
    public List<IntrusionesDTO> findAll() {
        List<IntrusionesDTO> intrusioness = new ArrayList<>();
        IntrusionesDTO intrusion = null;
        ReportesDTO reporte;
        ReportesDAO reportedao = new ReportesDAOImpl();
        try {
            String query = "SELECT * FROM intrusiones;";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                reporte = reportedao.find(rs.getInt("reporte"));
                intrusion = new IntrusionesDTO(
                        rs.getInt("id_intrusion"),
                        rs.getString("unidades_afectadas"),
                        rs.getInt("ataques"),
                        reporte);
                intrusioness.add(intrusion);
            }
            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvieron los empleados");
        } catch (SQLTimeoutException e) {
            intrusioness = new ArrayList<>();
            System.out.println("No se obtuvieron los empleados");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            intrusioness = new ArrayList<>();
            System.out.println("No se obtuvieron los empleados");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return intrusioness;
    }

    @Override
    public int count() {
        return findAll().size();
    }
}

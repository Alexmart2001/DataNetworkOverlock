
package co.edu.usbbog.datanetworkoverlock.controller.dao;
import co.edu.usbbog.datanetworkoverlock.controller.config.Conexion;
import co.edu.usbbog.datanetworkoverlock.controller.dao.BackdoorDAO;
import co.edu.usbbog.datanetworkoverlock.model.BackdoorDTO;
import co.edu.usbbog.datanetworkoverlock.model.ReportesDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
        boolean seHizo = false;
        try {
            String query = "INSERT INTO backdoor(id_backdoor, tipo_backdoor, descripcion, fecha, reporte) VALUES ("
                    + backdoor.getId_backdoor() + ","
                    + backdoor.getTipo_backdoor() + ","
                    + backdoor.getDescripcion() + ","
                    + backdoor.getFecha() + ","
                    + backdoor.getReporte().getId_reporte() +
                    ");";
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
    public boolean edit(BackdoorDTO backdoor) {
    try {
        String query = "UPDATE backdoor SET "
                + "id_backdoor = " + backdoor.getId_backdoor() + ", "
                + "tipo_backdoor = " + backdoor.getTipo_backdoor() + ", "
                + "descripcion = " + backdoor.getDescripcion() + ", "
                + "fecha = " + backdoor.getFecha() + ", "
                + "reporte = " + backdoor.getReporte().getId_reporte()
                + " WHERE id_backdoor = " + backdoor.getId_backdoor() + ";";
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
    public boolean remove(Integer id_backdoor) {
        boolean seHizo = false;
        try{
            String query = "DELETE FROM backdoor WHERE id_backdoor = " + id_backdoor + ";";
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
    public BackdoorDTO find(Integer id_backdoor) {
        BackdoorDTO backdoor = null;
        ReportesDTO reporte;
        ReportesDAO reportesdao = new ReportesDAOImpl();
        try{
            String query = "SELECT * FROM backdoor WHERE id_backdoor = " + id_backdoor + ";";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            reporte = reportesdao.find(rs.getInt("reporte"));

            backdoor = new BackdoorDTO(
                rs.getInt("id_backdoor"),
                rs.getString("tipo_backdoor"),
                rs.getString("descripcion"),
                prueba(rs.getTime("fecha")),
                reporte);
            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvo el dato");
        } catch (SQLTimeoutException e) {
            backdoor = null;
            System.out.println("No se obtuvo el dato");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            backdoor = null;
            System.out.println("No se obtuvo el dato");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return backdoor;
    }

    @Override
    public List<BackdoorDTO> findAll() {
        List<BackdoorDTO> backdoor = new ArrayList<>();
        BackdoorDTO backdoo = null;
        ReportesDTO reporte;
        ReportesDAO reportedao = new ReportesDAOImpl();
        try{
            String query = "SELECT * FROM backdoor;";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                reporte = reportedao.find(rs.getInt("reporte"));
                backdoo = new BackdoorDTO(
                        rs.getInt("id_backdoor"),
                        rs.getString("tipo_backdoor"),
                        rs.getString("descripcion"),
                        prueba(rs.getTime("fecha")),
                        reporte);
                backdoor.add(backdoo);
            } rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvieron los datos");
        } catch (SQLTimeoutException e) {
            backdoor = new ArrayList<>();
            System.out.println("No se obtuvieron los datos");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            backdoor = new ArrayList<>();
            System.out.println("No se obtuvieron los datos");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return backdoor;
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

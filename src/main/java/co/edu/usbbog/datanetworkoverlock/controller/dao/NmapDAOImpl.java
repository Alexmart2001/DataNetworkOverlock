package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.controller.config.Conexion;
import co.edu.usbbog.datanetworkoverlock.model.BackdoorDTO;
import co.edu.usbbog.datanetworkoverlock.model.FallosDeRedDTO;
import co.edu.usbbog.datanetworkoverlock.model.NmapDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NmapDAOImpl implements NmapDAO{
    private final Conexion conexion;

    public NmapDAOImpl(){
        this.conexion = new Conexion();
    }

    @Override
    public boolean create(NmapDTO nmap) {
        boolean seHizo = false;
        try{
            String query = "INSERT INTO nmap (id_analisis_nmap, protocolo_puerto, estado, razon, nombre_servicio,"
                    + "producto, version, puerto_id, informacion_extra, backdoor, fallos_de_red) VALUES ("
                    + nmap.getIdAnalisisNmap() + ", '"
                    + nmap.getProtocoloPuerto() + ",'"
                    + nmap.getEstado() +"','"
                    + nmap.getRazon() +"','"
                    + nmap.getNombreServicio() + "','"
                    + nmap.getProducto() + "','"
                    + nmap.getVersion() + "',"
                    + nmap.getPuertoId() + ",'"
                    + nmap.getInformacionExtra() +"',"
                    + nmap.getBackdoor().getIdBackdoor() +","
                    + nmap.getFallosRed().getIdFallo()
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
    public NmapDTO find(Integer id_analisis_nmap) {
    NmapDTO nmap = null;
        BackdoorDTO backdoor;
        FallosDeRedDTO fallos;
        BackdoorDAO backdoordao = new BackdoorDAOImpl();
        FallosDeRedDAO fallosdao = new FallosDeRedDAOImpl();
        try{
            String query = "SELECT*FROM nmap WHERE id_analisis_nmap = " + id_analisis_nmap + ";";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            backdoor = backdoordao.find(rs.getInt("backdoor"));
            fallos = fallosdao.find(rs.getInt("fallos_de_red"));
            nmap = new NmapDTO(
                    rs.getInt("id_analisis_nmap"),
                    rs.getString("protocolo_puerto"),
                    rs.getString("estado"),
                    rs.getString("razon"),
                    rs.getString("nombre_servicio"),
                    rs.getString("produto"),
                    rs.getString("version"),
                    rs.getInt("puerto_id"),
                    rs.getString("informacion_extra"),
                    backdoor,
                    fallos);
            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvo el dato");
        } catch (SQLTimeoutException e) {
            nmap = null;
            System.out.println("No se obtuvo el dato");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            nmap = null;
            System.out.println("No se obtuvo el dato");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return nmap;
    }
    @Override
    public List<NmapDTO> findAll() {
        List<NmapDTO> nmap = new ArrayList<>();
        NmapDTO nma =null;
        BackdoorDTO backdoor;
        FallosDeRedDTO fallos;
        BackdoorDAO backdoordao = new BackdoorDAOImpl();
        FallosDeRedDAO fallosdao = new FallosDeRedDAOImpl();
        try{
            String query = "SELECT * FROM nmap;";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                backdoor = backdoordao.find(rs.getInt("backdoor"));
                fallos = fallosdao.find(rs.getInt("fallos_de_red"));
                nma = new NmapDTO(
                        rs.getInt("id_analisis_nmap"),
                        rs.getString("protocolo_puerto"),
                        rs.getString("estado"),
                        rs.getString("razon"),
                        rs.getString("nombre_servicio"),
                        rs.getString("produto"),
                        rs.getString("version"),
                        rs.getInt("puerto_id"),
                        rs.getString("informacion_extra"),
                        backdoor,
                        fallos);
                nmap.add(nma);
            }
            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvieron los empleados");
        } catch (SQLTimeoutException e) {
            nmap = new ArrayList<>();
            System.out.println("No se obtuvieron los empleados");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            nmap = new ArrayList<>();
            System.out.println("No se obtuvieron los empleados");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return nmap;
    }

    @Override
    public int count() {
        return findAll().size();
    }
}

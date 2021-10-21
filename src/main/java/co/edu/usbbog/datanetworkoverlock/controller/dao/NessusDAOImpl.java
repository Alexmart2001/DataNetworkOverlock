package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.controller.config.Conexion;
import co.edu.usbbog.datanetworkoverlock.model.BusquedaVulnerabilidadesDTO;
import co.edu.usbbog.datanetworkoverlock.model.NessusDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NessusDAOImpl implements NessusDAO{

    private final Conexion conexion;

    public NessusDAOImpl(){
        this.conexion = new Conexion();
    }
    @Override
    public boolean create(NessusDTO nessus) {
        boolean seHizo = false;
        try{
            String query = "INSERT INTO nessus(id_analisis_nessus, ip, puerto, host_number, descripcion,solucion, nombre_dns, "
                    + "nombre_netbios, direccion_mac, nist, base_score, vector, busqueda) VALUES("
                    + nessus.getIdAnalisisNessus() + ","
                    + nessus.getIp() + ","
                    + nessus.getPuerto() + ","
                    + nessus.getHostNumber() + ","
                    + "'" + nessus.getDescripcion() + "',"
                    + "'" + nessus.getSolucion() + "',"
                    + "'" + nessus.getNombreDNS() + "',"
                    + "'" + nessus.getNombreNetbios() + "',"
                    + "'" + nessus.getDireccionMac() + "',"
                    + "'" + nessus.getNist() + "',"
                    + "'" + nessus.getBaseScore() +"',"
                    + "'" + nessus.getVector() + "',"
                    + nessus.getBusqueda().getIdBusqueda()
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
    public NessusDTO find(Integer id_analisis_nessus) {
    NessusDTO nessus = null;
        BusquedaVulnerabilidadesDTO busqueda;
        BusquedaVulnerabilidadesDAO busquedadao = new BusquedaVulnerabilidadesDAOImpl();
        try {
            String query = "SELECT*FROM nessus where id_analisis_nessus = " + id_analisis_nessus + ";";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            busqueda = busquedadao.find(rs.getInt("busqueda"));
            nessus = new NessusDTO(
                    rs.getInt("id_analisis_nessus"),
                    rs.getInt("ip"),
                    rs.getInt("puerto"),
                    rs.getInt("host_number"),
                    rs.getString("descripcion"),
                    rs.getString("solucion"),
                    rs.getString("nombre_dns"),
                    rs.getString("nombre_netbios"),
                    rs.getString("direccion_mac"),
                    rs.getString("nist"),
                    rs.getString("base_score"),
                    rs.getString("vector"),
                    busqueda);
            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvo el dato");
        } catch (SQLTimeoutException e) {
            nessus = null;
            System.out.println("No se obtuvo el dato");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            nessus = null;
            System.out.println("No se obtuvo el dato");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return nessus;
    }


    @Override
    public List<NessusDTO> findAll() {
        List<NessusDTO> nessus = new ArrayList<>();
        NessusDTO nessu = null;
        BusquedaVulnerabilidadesDTO busqueda;
        BusquedaVulnerabilidadesDAO busquedadao = new BusquedaVulnerabilidadesDAOImpl();
        try{
            String query = "SELECT*FROM nessus;";
            System.out.println(query);
            this.conexion.conectar();
            Statement stmt = this.conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                busqueda = busquedadao.find(rs.getInt("busqueda"));
                nessu = new NessusDTO(
                        rs.getInt("id_analisis_nessus"),
                        rs.getInt("ip"),
                        rs.getInt("puerto"),
                        rs.getInt("host_number"),
                        rs.getString("descripcion"),
                        rs.getString("solucion"),
                        rs.getString("nombre_dns"),
                        rs.getString("nombre_netbios"),
                        rs.getString("direccion_mac"),
                        rs.getString("nist"),
                        rs.getString("base_score"),
                        rs.getString("vector"),
                        busqueda);
                nessus.add(nessu);
            }
            rs.close();
            stmt.close();
            this.conexion.desconectar();
            System.out.println("Se obtuvieron los datos");
        } catch (SQLTimeoutException e) {
            nessus = new ArrayList<>();
            System.out.println("No se obtuvieron los datos");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        } catch (SQLException e) {
            nessus = new ArrayList<>();
            System.out.println("No se obtuvieron los datos");
            System.out.println("Causa: " + e.getMessage());
            System.out.println("Causa: " + e.getSQLState());
        }
        return nessus;
    }

    @Override
    public int count() {
        return findAll().size();
    }
}

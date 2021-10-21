package co.edu.usbbog.datanetworkoverlock.controller.dao;

import co.edu.usbbog.datanetworkoverlock.controller.config.Conexion;
import co.edu.usbbog.datanetworkoverlock.model.IntrusionesDTO;
import co.edu.usbbog.datanetworkoverlock.model.KismetDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KismetDAOImpl implements KismetDAO{

        private final Conexion conexion;

        public KismetDAOImpl(){

            this.conexion = new Conexion();
        }
    @Override
    public boolean create(KismetDTO kismet) {
            boolean seHizo = false;
            try{
                String query = "INSERT INTO kismet (id_analisis_kismet, nombre_red_detectada, clientes_detectados, modo_funcionamiento_disp_wifi, "
                        + "tipo_encriptacion, canal_operacion_red, paquetes_capturados, intrusiones) VALUES ("
                        + kismet.getIdAnalisisKismet() + ","
                        + "'"+ kismet.getNombreRedDetectada() + "',"
                        + "'" + kismet.getClientesDetectados() + "',"
                        + "'" + kismet.getModoFuncionamientoWifi() + "',"
                        + "'" + kismet.getTipoEncriptacion() + "',"
                        + "'" + kismet.getCanalOperacionRed() + "',"
                        + "'" + kismet.getPaquetesCapturados() + "',"
                        +       kismet.getIntrusiones().getIdIntrusion()
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
    public KismetDTO find(Integer id_analisis_kismet) {
            KismetDTO kismet = null;
            IntrusionesDTO intrusion;
            IntrusionesDAO intrusionesDAO = new IntrusionesDAOImpl();
            try{
                String query = "SELECT*FROM kismet where id_analisis_kismet = " + id_analisis_kismet + ";";
                System.out.println(query);
                this.conexion.conectar();
                Statement stmt = this.conexion.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                rs.first();
                intrusion = intrusionesDAO.find(rs.getInt("instrusiones"));
                kismet = new KismetDTO(
                        rs.getInt("id_analisis_kismet"),
                        rs.getString("nombre_red_detectada"),
                        rs.getString("clientes_detectados"),
                        rs.getString("modo_funcionamiento_disp_wifi"),
                        rs.getString("tipo_encriptacion"),
                        rs.getString("canal_operacion_red"),
                        rs.getString("paquetes_capturados"),
                        intrusion);
                rs.close();
                stmt.close();
                this.conexion.desconectar();
                System.out.println("Se obtuvo el dato");
            } catch (SQLTimeoutException e) {
                kismet = null;
                System.out.println("No se obtuvo el dato");
                System.out.println("Causa: " + e.getMessage());
                System.out.println("Causa: " + e.getSQLState());
            } catch (SQLException e) {
                kismet = null;
                System.out.println("No se obtuvo el dato");
                System.out.println("Causa: " + e.getMessage());
                System.out.println("Causa: " + e.getSQLState());
            }
        return kismet;
    }

    @Override
    public List<KismetDTO> findAll() {
            List<KismetDTO> kismet = new ArrayList<>();
            KismetDTO kisme = null;
            IntrusionesDTO intrusiones;
            IntrusionesDAO intrusiondao = new IntrusionesDAOImpl();
            try{
                String query = "SELECT * FROM kismet;";
                System.out.println(query);
                this.conexion.conectar();
                Statement stmt = this.conexion.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    intrusiones = intrusiondao.find(rs.getInt("intrusiones"));
                    kisme = new KismetDTO(
                            rs.getInt("id_analisis_kismet"),
                            rs.getString("nombre_red_detectada"),
                            rs.getString("clientes_detectados"),
                            rs.getString("modo_funcionamiento_disp_wifi"),
                            rs.getString("tipo_encriptacion"),
                            rs.getString("canal_operacion_red"),
                            rs.getString("paquetes_capturados"),
                            intrusiones);
                    kismet.add(kisme);
                }
                rs.close();
                stmt.close();
                this.conexion.desconectar();
                System.out.println("Se obtuvieron los datos");
            } catch (SQLTimeoutException e) {
                kismet = new ArrayList<>();
                System.out.println("No se obtuvieron los datos");
                System.out.println("Causa: " + e.getMessage());
                System.out.println("Causa: " + e.getSQLState());
            } catch (SQLException e) {
                kismet = new ArrayList<>();
                System.out.println("No se obtuvieron los datos");
                System.out.println("Causa: " + e.getMessage());
                System.out.println("Causa: " + e.getSQLState());
            }
        return kismet;
    }

    @Override
    public int count() {
        return findAll().size();
    }

}

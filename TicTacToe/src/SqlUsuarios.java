//A class that connects to a database and performs some operations.

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class SqlUsuarios extends Conexion {

    DefaultTableModel modelo;

    //Inserting a new row into the database.
    public boolean registrar(score usr) {

        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "INSERT INTO usuarios (usuario, puntaje, partidasg,partidasp, partidase, totalp) VALUES(?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            ps.setInt(2, usr.getPuntaje());
            ps.setInt(3, usr.getPartidasg());
            ps.setInt(4, usr.getPartidasp());
            ps.setInt(5, usr.getPartidase());
            ps.setInt(6, usr.getTotalp());


            ps.execute();
            return true;

        } catch (SQLException e) {
            return false;
        }

    }

    public boolean detallest(score usr) {

        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "INSERT INTO partidas (jugador1, jugador2, ganador, time) VALUES(?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            ps.setString(2, usr.getUsuario2());
            ps.setString(3,usr.getNa());
            ps.setString(4,usr.getTime());
            ps.execute();
            return true;

        } catch (SQLException e) {
            return false;
        }

    }


    //Adding the new score to the existing one.
    public boolean add(score usr) {

        PreparedStatement ps;
        Connection con = getConexion();
        String sqlUpdate = "update usuarios SET usuarios.puntaje=(select SUM( ? + puntaje)) where usuario = ? ";

        try {
            ps = con.prepareStatement(sqlUpdate);
            ps.setInt(1, usr.getPuntaje());
            ps.setString(2, usr.getUsuario());
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    public boolean addpg(score usr) {

        PreparedStatement ps;
        Connection con = getConexion();
        String sqlUpdate = "update usuarios SET usuarios.partidasg=(select SUM( ? + partidasg)) where usuario = ? ";

        try {
            ps = con.prepareStatement(sqlUpdate);
            ps.setInt(1, usr.getPartidasg());
            ps.setString(2, usr.getUsuario());
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }


    public boolean addpp(score usr) {

        PreparedStatement ps;
        Connection con = getConexion();
        String sqlUpdate = "update usuarios SET usuarios.partidasp=(select SUM( ? + partidasp)) where usuario = ? ";

        try {
            ps = con.prepareStatement(sqlUpdate);
            ps.setInt(1, usr.getPartidasp());
            ps.setString(2, usr.getUsuario());
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    public boolean addpe(score usr) {

        PreparedStatement ps;
        Connection con = getConexion();
        String sqlUpdate = "update usuarios SET usuarios.partidase=(select SUM( ? + partidase)) where usuario = ? ";

        try {
            ps = con.prepareStatement(sqlUpdate);
            ps.setInt(1, usr.getPartidase());
            ps.setString(2, usr.getUsuario());
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    public boolean addpt(score usr) {

        PreparedStatement ps;
        Connection con = getConexion();
        String sqlUpdate = "update usuarios SET usuarios.totalp=(select SUM( partidasg + partidasp + partidase)) where usuario = ?";

        try {
            ps = con.prepareStatement(sqlUpdate);
            ps.setString(1, usr.getUsuario());
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }
    //Checking if the user exists in the database.
    public int consulta(String usuario) {

        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT count(id) FROM usuarios WHERE usuario = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

            return 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    //A method that returns a DefaultTableModel.
    public DefaultTableModel listar(){

        try {

            PreparedStatement ps;
            Connection con = getConexion();
            String columna[] = {"Usuario","Score","Partidas_G", "Partidas_P", "Partidas_E", "Total_P"};
            modelo = new DefaultTableModel(null, columna);
            String sql = "Select usuario, puntaje, partidasg, partidasp, partidase, totalp From score.usuarios order by puntaje DESC, partidasg DESC, totalp asc";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String fila [] = new String[6];

            while (rs.next()){
                fila[0] = rs.getString("usuario");
                fila[1] = rs.getString("puntaje");
                fila[2] = rs.getString("partidasg");
                fila[3] = rs.getString("partidasp");
                fila[4] = rs.getString("partidase");
                fila[5] = rs.getString("totalp");

                modelo.addRow(fila);
            }

            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error. Revisar conexion a base de datos");
        }

        return modelo;
    }

    public DefaultTableModel tdetalle(){

        try {

            PreparedStatement ps;
            Connection con = getConexion();
            String columna[] = {"Jugador(X)","Jugador(O)","Ganador", "Time"};
            modelo = new DefaultTableModel(null, columna);
            String sql = "Select jugador1, jugador2, ganador, time From score.partidas order by time desc";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String fila [] = new String[4];

            while (rs.next()){
                fila[0] = rs.getString("jugador1");
                fila[1] = rs.getString("jugador2");
                fila[2] = rs.getString("ganador");
                fila[3] = rs.getString("time");

                modelo.addRow(fila);
            }

            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error. Revisar conexion a base de datos");
        }

        return modelo;
    }

}

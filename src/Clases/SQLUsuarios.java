/** ** @author Richard */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLUsuarios extends Conectar {

    public boolean registrar(usuarios urs) {

        Conectar cc = new Conectar();
        Connection con = cc.conexion();

        String sql = "INSERT INTO usuario (nombre, apellido, tipo_usuario, correo, password) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement insert = con.prepareStatement(sql);
            insert.setString(1, urs.getNombre());
            insert.setString(2, urs.getApellido());
            insert.setString(3, urs.getTipousuario());
            insert.setString(4, urs.getCorreo());
            insert.setString(5, urs.getPassword());
            insert.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SQLUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public int existeusuario(String usuario) {

        Conectar cc = new Conectar();
        ResultSet rs = null;
        Connection con = cc.conexion();

        String sql = "SELECT count(id) FROM usuario WHERE nombre = ?";

        try {
            PreparedStatement insert = con.prepareStatement(sql);
            insert.setString(1, usuario);
            rs = insert.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(SQLUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
    }

    public boolean login(usuarios usr) {

        Conectar cc = new Conectar();
        ResultSet rs = null;
        Connection con = cc.conexion();

        String sql = "SELECT id, nombre, apellido, tipo_usuario, password FROM usuario WHERE nombre = ?";

        try {
            PreparedStatement insert = con.prepareStatement(sql);
            insert.setString(1, usr.getNombre());
            rs = insert.executeQuery();

            if (rs.next()) {
                if (usr.getPassword().equals(rs.getString(5))) {
                    usr.setId(rs.getInt(1));
                    usr.setNombre(rs.getString(2));
                    usr.setTipousuario(rs.getString(4));
                    return true;
                }else{
                    return false;
                }
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(SQLUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}

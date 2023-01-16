package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import puntoventa.FrmRegistro;

public class metodosResgistro {
    
    Conectar cc = new Conectar();
    Connection con = cc.conexion();
    
    DefaultTableModel model;
    
    public void buscar(){
        String titulos [] = {"ID", "NOMBRE", "APELLIDO", "TIPO USUARIO", "CORREO"};
        String empleados [] = new String [6];
        
        model = new DefaultTableModel(null, titulos);
        
        String nombre = FrmRegistro.txtBuscar.getText();
        String sql = "SELECT * FROM usuario WHERE nombre = '" + nombre +"'";
        
        try{
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                empleados[0] = rs.getString("id");
                empleados[1] = rs.getString("nombre");
                empleados[2] = rs.getString("apellido");
                empleados[3] = rs.getString("tipo_usuario");
                empleados[4] = rs.getString("correo");
                
                model.addRow(empleados);
            }
            FrmRegistro.tbUsuarios.setModel(model);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void cargar() {

        try {
            String titulos[] = {"ID", "NOMBRE", "APELLIDO", "TIPO USUARIO", "CORREO"};

            model = new DefaultTableModel(null, titulos);

            String consultar = "SELECT * FROM usuario";
            String[] datos = new String[6];
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consultar);
            while (rs.next()) {
                datos[0] = rs.getString("id");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("apellido");
                datos[3] = rs.getString("tipo_usuario");
                datos[4] = rs.getString("correo");

                model.addRow(datos);
            }
            FrmRegistro.tbUsuarios.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void eliminar() {
        int fila = FrmRegistro.tbUsuarios.getSelectedRow();

        if (fila >= 0) {
            int valor = Integer.parseInt(FrmRegistro.tbUsuarios.getValueAt(fila, 0).toString());
            try {
                PreparedStatement pss = con.prepareStatement("DELETE FROM usuario WHERE id = '" + valor + "'");
                pss.executeUpdate();

                JOptionPane.showMessageDialog(null, "Empleado borrado correctamente");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }
    }
    
    public void modificar() {
        int fila = FrmRegistro.tbUsuarios.getSelectedRow();
        if (fila >= 0) {
            int id = Integer.parseInt((String) FrmRegistro.tbUsuarios.getValueAt(fila, 0));
            FrmRegistro.txtNombre.setText(FrmRegistro.tbUsuarios.getValueAt(fila, 1).toString());
            FrmRegistro.txtApellido.setText(FrmRegistro.tbUsuarios.getValueAt(fila, 2).toString());
            FrmRegistro.cmbTipo.setSelectedItem(FrmRegistro.tbUsuarios.getValueAt(fila, 3).toString());
            FrmRegistro.txtCorreo.setText(FrmRegistro.tbUsuarios.getValueAt(fila, 4).toString());

            String sql = "SELECT password FROM usuario WHERE id = '" + id + "'";

            try {
                Statement st = (Statement) con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    FrmRegistro.desbloquear();
                    FrmRegistro.pssContrasenia.setText(rs.getString("password"));
                    FrmRegistro.pssPassValidada.setText(rs.getString("password"));
                    FrmRegistro.btnActualizar.setEnabled(true);
                    FrmRegistro.btnAgregar.setEnabled(false);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }
    }
    
    public void actualizar() {
        String nombre = FrmRegistro.txtNombre.getText();
        String apellido = FrmRegistro.txtApellido.getText();
        String tipousuario = FrmRegistro.cmbTipo.getSelectedItem().toString();
        String correo = FrmRegistro.txtCorreo.getText();
        String password = new String(FrmRegistro.pssContrasenia.getPassword());
        String passval = new String(FrmRegistro.pssPassValidada.getPassword());

        if (password.equals(passval)) {
            String sql = "UPDATE usuario SET nombre='" + nombre + "', apellido='" + apellido + "',"
                    + " tipo_usuario='" + tipousuario + "', correo='" + correo + "',"
                    + "password='" + password + "' WHERE nombre='" + nombre + "'";

            try {
                PreparedStatement pss = con.prepareStatement(sql);
                pss.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
        }
    }
    
}

/** ** @author Richard */
package Clases;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import puntoventa.FrmProducto;

public class metodosProducto {

    Conectar cc = new Conectar();
    Connection con = cc.conexion();

    DefaultTableModel model, mds;

    public void agregar() {
        int codigo = Integer.parseInt(FrmProducto.txtCodigo.getText());
        String nombre = FrmProducto.txtNombre.getText();
        int existencias = Integer.parseInt(FrmProducto.txtExistencia.getText());
        double precio = Double.parseDouble(FrmProducto.txtPrecio.getText());
        String nomimagen = FrmProducto.txtImagen.getText();

        String sql = "INSERT INTO productos (cod_producto, nombre, existencias, precio, "
                + "nom_imagen, imagen) VALUES (?,?,?,?,?,?)";

        try {
            FileInputStream archivofoto;
            PreparedStatement insert = con.prepareStatement(sql);
            insert.setInt(1, codigo);
            insert.setString(2, nombre);
            insert.setInt(3, existencias);
            insert.setDouble(4, precio);
            insert.setString(5, nomimagen);
            archivofoto = new FileInputStream(nomimagen);
            insert.setBinaryStream(6, archivofoto);

            int n = insert.executeUpdate();

            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void cargar() {
        try {
            String titulos[] = {"CÓDIGO", "NOMBRE", "EXISTENCIAS", "PRECIO", "IMAGEN"};

            mds = new DefaultTableModel(null, titulos);

            String consultar = "SELECT * FROM productos";
            String[] datos = new String[5];
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consultar);
            while (rs.next()) {
                datos[0] = rs.getString("cod_producto");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("existencias");
                datos[3] = rs.getString("precio");
                datos[4] = rs.getString("nom_imagen");

                mds.addRow(datos);
            }
            FrmProducto.tbProducto.setModel(mds);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void buscar() {
        String titulos[] = {"CÓDIGO", "NOMBRE", "EXISTENCIAS", "PRECIO", "IMAGEN"};
        String productos[] = new String[10];

        mds = new DefaultTableModel(null, titulos);

        String codigo = FrmProducto.txtBuscar.getText();
        String sql = "SELECT * FROM productos WHERE cod_producto = '" + codigo + "'";

        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InputStream is = null;
            ImageIcon ii = null;
            while (rs.next()) {
                productos[0] = rs.getString("cod_producto");
                productos[1] = rs.getString("nombre");
                productos[2] = rs.getString("existencias");
                productos[3] = rs.getString("precio");
                productos[4] = rs.getString("nom_imagen");
                is = rs.getBinaryStream("imagen");
                BufferedImage bi = ImageIO.read(is);
                ii = new ImageIcon(bi);
                FrmProducto.lbImagen.setIcon(ii);

                mds.addRow(productos);
            }
            FrmProducto.tbProducto.setModel(mds);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void modificar() {
        int fila = FrmProducto.tbProducto.getSelectedRow();
        if (fila >= 0) {
            int codigo = Integer.parseInt(FrmProducto.tbProducto.getValueAt(fila, 0).toString());
            FrmProducto.txtCodigo.setText(FrmProducto.tbProducto.getValueAt(fila, 0).toString());
            FrmProducto.txtNombre.setText(FrmProducto.tbProducto.getValueAt(fila, 1).toString());
            FrmProducto.txtExistencia.setText(FrmProducto.tbProducto.getValueAt(fila, 2).toString());
            FrmProducto.txtPrecio.setText(FrmProducto.tbProducto.getValueAt(fila, 3).toString());
            FrmProducto.txtImagen.setText(FrmProducto.tbProducto.getValueAt(fila, 4).toString());
            
            String sql = "SELECT imagen FROM productos WHERE cod_producto = '" + codigo + "'";
            
            try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InputStream is = null;
            ImageIcon ii = null;
            while (rs.next()) {
                is = rs.getBinaryStream("imagen");
                BufferedImage bi = ImageIO.read(is);
                ii = new ImageIcon(bi);
                FrmProducto.lbImagen.setIcon(ii);
                FrmProducto.lbImagen.setIcon(ii);
                FrmProducto.txtCodigo.setEditable(false);
                FrmProducto.txtImagen.setEditable(false);
                FrmProducto.btnActualizar.setEnabled(true);
                FrmProducto.btnAgregar.setEnabled(false);
                FrmProducto.btnSeleccionar.setEnabled(false);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        } else {
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }
    }

    public void actualizar() {
        int codigo = Integer.parseInt(FrmProducto.txtCodigo.getText());
        String nombre = FrmProducto.txtNombre.getText();
        int existencias = Integer.parseInt(FrmProducto.txtExistencia.getText());
        double precio = Double.parseDouble(FrmProducto.txtPrecio.getText());
        //String nombreimagen = FrmProducto.txtImagen.getText();
//        String nomimagen = FrmProducto.txtImagen.getText();
//        FileInputStream archivofoto = null;
//        try {
//            archivofoto = new FileInputStream(nomimagen);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(metodosProducto.class.getName()).log(Level.SEVERE, null, ex);
//        }
        

        String sql = "UPDATE productos SET nombre='" + nombre + "', existencias='" + existencias + "', "
                + "precio='"+ precio +"' WHERE cod_producto='" + codigo + "'";

        try {
            PreparedStatement pss = con.prepareStatement(sql);
            pss.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void eliminar() {
        int fila = FrmProducto.tbProducto.getSelectedRow();
        
        if (fila >= 0) {
            int valor = Integer.parseInt(FrmProducto.tbProducto.getValueAt(fila, 0).toString());
            try {
                PreparedStatement pss = con.prepareStatement("DELETE FROM productos WHERE"
                        + " cod_producto = '" + valor + "'");
                pss.executeUpdate();

                JOptionPane.showMessageDialog(null, "Producto borrado correctamente");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            } 
        } else {
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }
    }
    
}

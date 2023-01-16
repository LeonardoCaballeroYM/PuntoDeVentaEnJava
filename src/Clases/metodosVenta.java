/** ** @author Richard */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import puntoventa.FrmVentas;

public class metodosVenta {

    Conectar cc = new Conectar();
    Connection con = cc.conexion();
    
    static ArrayList<ventas> ListVentas = new ArrayList<>();

    DefaultTableModel model;

    public void Vendedor() {

        String vendedor = FrmVentas.txtVendedor.getText();
        String cliente = FrmVentas.cmbCliente.getSelectedItem().toString();

        int idvendedor = 0;

        Date date = FrmVentas.jdcFecha.getDate();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);

        String sql = "SELECT id FROM usuario WHERE nombre = '" + vendedor + "'";

        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idvendedor = rs.getInt("id");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        String sqlinsertar = "INSERT INTO vendedor (id, id_empleado, cliente, fecha)"
                + " VALUES (NULL,?,?,?)";

        try {
            PreparedStatement insert = con.prepareStatement(sqlinsertar);
            insert.setInt(1, idvendedor);
            insert.setString(2, cliente);
            insert.setDate(3, fecha);
            insert.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void buscar() {

        int codigo = Integer.parseInt(FrmVentas.txtcodProducto.getText());
        String sql = "SELECT nombre, precio FROM productos WHERE cod_producto = '" + codigo + "'";

        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                FrmVentas.txtProducto.setText(rs.getString("nombre"));
                FrmVentas.txtPrecio.setText(rs.getString("precio"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void agregarProducto() {

        String producto = FrmVentas.txtProducto.getText();
        int codigo = Integer.parseInt(FrmVentas.txtcodProducto.getText());
        double precio = Double.parseDouble(FrmVentas.txtPrecio.getText());
        int cantidad = Integer.parseInt(FrmVentas.txtCantidad.getText());
        double total = cantidad * precio;
        int id_venta = Integer.parseInt(FrmVentas.txtNoFactura.getText());

        Date date = FrmVentas.jdcFecha.getDate();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        String sqlinsertar = "INSERT INTO inv_salidas (id_articulo, id_venta, cod_producto, "
                + "producto, precio, cantidad, total, fecha) VALUES (NULL,?,?,?,?,?,?,?)";

        try {
            PreparedStatement insert = con.prepareStatement(sqlinsertar);
            insert.setInt(1, id_venta);
            insert.setInt(2, codigo);
            insert.setString(3, producto);
            insert.setDouble(4, precio);
            insert.setInt(5, cantidad);
            insert.setDouble(6, total);
            insert.setDate(7, fecha);
            insert.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        existencias();
    }

    public void limpiartbVentas() {
        DefaultTableModel llenar = (DefaultTableModel) FrmVentas.tbVenta.getModel();
        Object[] fila = new Object[6];
        //primero se limpia el grid
        for (int i = 0; i < FrmVentas.tbVenta.getRowCount(); i++) {
            llenar.removeRow(i);
            i = i - 1;
        }
    }

    public void llenartbVentas() {
        
        DefaultTableModel llenar = (DefaultTableModel) FrmVentas.tbVenta.getModel();
        Object[] fila = new Object[6];
        //primero se limpia el grid
        for (int i = 0; i < FrmVentas.tbVenta.getRowCount(); i++) {
            llenar.removeRow(i);
            i = i - 1;
        }
        //aqui se hace el recorrido de Equipo para llenar la tabla
        for (ventas aux : ListVentas) {
            fila[0] = aux.getCodigo();
            fila[1] = aux.getProducto();
            fila[2] = aux.getPrecio();
            fila[3] = aux.getCantidad();
            fila[4] = aux.getTotal();
            fila[5] = aux.getFecha();
            llenar.addRow(fila);
        }
    }

    public void actualizartbVentas() {
        int codigo = Integer.parseInt(FrmVentas.txtcodProducto.getText());
        String producto = FrmVentas.txtProducto.getText();
        double precio = Double.parseDouble(FrmVentas.txtPrecio.getText());
        int cantidad = Integer.parseInt(FrmVentas.txtCantidad.getText());
        double total = precio * cantidad;
        Date date = FrmVentas.jdcFecha.getDate();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);

        ventas rg = new ventas(codigo, producto, precio, cantidad, total, fecha);
        ListVentas.add(rg);
        llenartbVentas();//actualizar la tabla
    }

    public void realizarVenta() {
        double total = Double.parseDouble(FrmVentas.txtTotal.getText());
        Date date = FrmVentas.jdcFecha.getDate();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);

        String vendedor = FrmVentas.txtVendedor.getText();
        int idempleado = 0;

        String sql = "SELECT id FROM usuario WHERE nombre = '" + vendedor + "'";

        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idempleado = rs.getInt("id");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        int factura = Integer.parseInt(FrmVentas.txtNoFactura.getText());
        double importe = Double.parseDouble(FrmVentas.txtImporte.getText());
        double cambio = Double.parseDouble(FrmVentas.txtCambio.getText());

        String sqlinsertar = "INSERT INTO ventas (id_venta, factura, id_vendedor, total_vendido, importe, cambio, fecha)"
                + " VALUES (NULL,?,?,?,?,?,?)";

        try {
            PreparedStatement insert = con.prepareStatement(sqlinsertar);
            insert.setInt(1, factura);
            insert.setInt(2, idempleado);
            insert.setDouble(3, total);
            insert.setDouble(4, importe);
            insert.setDouble(5, cambio);
            insert.setDate(6, fecha);
            insert.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        JOptionPane.showMessageDialog(null, "Venta realizada correctamente");
        vaciar();
    }
    
    public void vaciar(){
        for (int i = 0; i < 1000; i++) {
            ListVentas.clear();
        }
    }

    public void existencias() {

        int cantidad = Integer.parseInt(FrmVentas.txtCantidad.getText());
        int codigo = Integer.parseInt(FrmVentas.txtcodProducto.getText());

        int existencias = 0;

        String sqlexistencias = "SELECT existencias FROM productos WHERE cod_producto = '" + codigo + "'";

        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sqlexistencias);
            while (rs.next()) {
                existencias = rs.getInt("existencias");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        int newExistencias = existencias - cantidad;

        String sql = "UPDATE productos SET existencias='" + newExistencias + "'"
                + " WHERE cod_producto='" + codigo + "'";

        try {
            PreparedStatement pss = con.prepareStatement(sql);
            pss.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public int BuscarCodigoVenta() {
        String sql;

        sql = "SELECT id_venta from ventas order by id_venta DESC limit 1 ";

        try {
            int codigo_venta = 0;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                codigo_venta = rs.getInt("id_venta");
            }
            return codigo_venta;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }
    
    public int BuscarNfacturas() {
        String sql;

        sql = "SELECT COUNT(*) as factura FROM ventas";

        try {
            int Nfactura = 0;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Nfactura = rs.getInt("factura");
            }
            return Nfactura;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }

    }
}

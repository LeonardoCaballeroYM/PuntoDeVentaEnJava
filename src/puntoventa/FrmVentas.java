/** ** @author Richard */
package puntoventa;

import Clases.Conectar;
import Clases.metodosVenta;
import Clases.validaciones;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import static puntoventa.FrmLogin.usu;
import static puntoventa.FrmPrincipa.mod;

public class FrmVentas extends javax.swing.JFrame {

    int factura = 0;

    Conectar cc = new Conectar();
    Connection con = cc.conexion();

    public FrmVentas() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/img/ClothesNexus.png")).getImage());
        ConfigForm();
        this.setLocationRelativeTo(null);
        txtVendedor.setText("" + usu);
        cmbCliente.setSelectedItem("Publico en general");
        txtPrecio.setEditable(false);
        txtProducto.setEditable(false);
        NfacturaAtxt();

    }

    int BuscarCodigoVenta() {
        String sql = "SELECT factura from ventas order by factura";

        try {
            factura = 0;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                factura = rs.getInt("factura");
            }
            return factura;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }

    public void NfacturaAtxt() {
        DecimalFormat formateador = new DecimalFormat("0");
        metodosVenta funcion = new metodosVenta();
        int Nfactura = funcion.BuscarNfacturas();

        Nfactura = Nfactura + 1;

        String format = formateador.format(Nfactura);

        txtNoFactura.setText(String.valueOf(format));

    }

    void calcularTotal() {
        double totalPago = 0.0;
        int totalRowp = tbVenta.getRowCount();
        totalRowp -= 1;
        for (int i = 0; i <= (totalRowp); i++) {
            double sum = Double.parseDouble(String.valueOf(tbVenta.getValueAt(i, 4)));
            totalPago += sum;
            txtTotal.setText("" + totalPago);
        }
    }

    void limpiarCajas() {
        txtcodProducto.setText("");
        txtProducto.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
        txtImporte.setText("");
        txtTotal.setText("");
        txtCambio.setText("");
    }

    void limpiar() {
        txtcodProducto.setText("");
        txtProducto.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
    }

    public final void ConfigForm() {
        validaciones val = new validaciones();
        val.SNumeros(txtcodProducto);
        val.SNumeros(txtCantidad);
        val.SNumeros(txtImporte);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtVendedor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcodProducto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtProducto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVenta = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtImporte = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCambio = new javax.swing.JTextField();
        btnVender = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtNoFactura = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ventas");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ventas Clothes Nexus");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 12, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Vendedor:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 109, -1, -1));

        txtVendedor.setEditable(false);
        txtVendedor.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        txtVendedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 107, 142, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cliente:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 109, -1, -1));

        cmbCliente.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Publico en general" }));
        jPanel1.add(cmbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 105, 170, -1));
        jPanel1.add(jdcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(639, 65, 131, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 71, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 187, -1, -1));

        txtcodProducto.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jPanel1.add(txtcodProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 207, 122, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Producto");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 153, -1, -1));

        btnBuscar.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 204, -1, -1));

        txtProducto.setEditable(false);
        txtProducto.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jPanel1.add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 185, 293, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Precio:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 219, -1, -1));

        txtPrecio.setEditable(false);
        txtPrecio.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 217, 77, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cantidad:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 219, -1, -1));

        txtCantidad.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 217, 113, -1));

        btnAgregar.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 208, -1, -1));

        tbVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "PRODUCTO", "PRECIO", "CANTIDAD", "TOTAL", "FECHA"
            }
        ));
        jScrollPane1.setViewportView(tbVenta);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 255, 747, 185));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Importe:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 454, -1, -1));

        txtImporte.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        txtImporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImporteActionPerformed(evt);
            }
        });
        jPanel1.add(txtImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 452, 72, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 454, -1, -1));

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 452, 72, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cambio:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 454, -1, -1));

        txtCambio.setEditable(false);
        txtCambio.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jPanel1.add(txtCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 452, 79, -1));

        btnVender.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        btnVender.setText("Vender");
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });
        jPanel1.add(btnVender, new org.netbeans.lib.awtextra.AbsoluteConstraints(692, 498, 85, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("No Factura:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 109, -1, -1));

        txtNoFactura.setEditable(false);
        txtNoFactura.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        txtNoFactura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtNoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 131, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Lucida Calligraphy", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Regresar");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 46, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 65, 62, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wc1677008.jpg"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtcodProducto.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Ingrese un código de barras");
        } else {
        metodosVenta modsql = new metodosVenta();
        modsql.buscar();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (txtProducto.getText().equals("") || txtPrecio.getText().equals("")
                || txtCantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan algunos datos del producto");
        } else {
            metodosVenta modsql = new metodosVenta();
            modsql.agregarProducto();
            modsql.actualizartbVentas();
            calcularTotal();
            limpiar();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        if (txtImporte.getText().equals("") || txtTotal.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Datos de la venta incomplentos");
        } else {
            metodosVenta modsql = new metodosVenta();
            modsql.Vendedor();
            modsql.realizarVenta();
            BuscarCodigoVenta();
            try {
                JasperReport tickets = null;
                String path = "src\\Reportes\\Tickets.jasper";

                Map parametro = new HashMap();
                parametro.put("factura", factura);

                tickets = (JasperReport) JRLoader.loadObjectFromFile(path);

                JasperPrint jprint = JasperFillManager.fillReport(tickets, parametro, con);

                JasperViewer view = new JasperViewer(jprint, false);
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);

            } catch (JRException ex) {
                Logger.getLogger(FrmRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }
            NfacturaAtxt();
            limpiarCajas();
            modsql.limpiartbVentas();
            jdcFecha.setDateFormatString("dd/MM/yyyy");
        }
    }//GEN-LAST:event_btnVenderActionPerformed

    private void txtImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImporteActionPerformed
        if (txtImporte.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese un importe");
        } else {
        int importe = Integer.parseInt(txtImporte.getText());
        double total = Double.parseDouble(txtTotal.getText());
        double cambio = importe - total;
        txtCambio.setText("" + cambio);
        }
    }//GEN-LAST:event_txtImporteActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        FrmPrincipa frm = new FrmPrincipa();
        frm.setVisible(true);
        if (mod.getTipousuario().equals("Empleado")) {
            FrmPrincipa.mProductos.setVisible(false);
            FrmPrincipa.mUsuarios.setVisible(false);
            FrmPrincipa.mrptVentas.setVisible(false);
        }
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnVender;
    public static javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public static com.toedter.calendar.JDateChooser jdcFecha;
    public static javax.swing.JTable tbVenta;
    public static javax.swing.JTextField txtCambio;
    public static javax.swing.JTextField txtCantidad;
    public static javax.swing.JTextField txtImporte;
    public static javax.swing.JTextField txtNoFactura;
    public static javax.swing.JTextField txtPrecio;
    public static javax.swing.JTextField txtProducto;
    public static javax.swing.JTextField txtTotal;
    public static javax.swing.JTextField txtVendedor;
    public static javax.swing.JTextField txtcodProducto;
    // End of variables declaration//GEN-END:variables
}

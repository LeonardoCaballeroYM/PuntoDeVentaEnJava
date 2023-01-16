package puntoventa;

import Clases.Conectar;
import Clases.SQLUsuarios;
import Clases.metodosResgistro;
import Clases.usuarios;
import Clases.validaciones;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import static puntoventa.FrmPrincipa.mod;

public class FrmRegistro extends javax.swing.JFrame {

    Conectar cc = new Conectar();
    Connection con = cc.conexion();

    public FrmRegistro() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/img/ClothesNexus.png")).getImage());
        ConfigForm();
        this.setLocationRelativeTo(null);
        metodosResgistro modSql = new metodosResgistro();
        modSql.cargar();
        bloquearinicio();

    }

    private void bloquearinicio() {
        txtNombre.setEnabled(false);
        txtApellido.setEnabled(false);
        cmbTipo.setEnabled(false);
        txtCorreo.setEnabled(false);
        pssContrasenia.setEnabled(false);
        pssPassValidada.setEnabled(false);
        btnAgregar.setEnabled(false);
        btnActualizar.setEnabled(false);
    }

    public static void desbloquear() {
        txtNombre.setEnabled(true);
        txtApellido.setEnabled(true);
        cmbTipo.setEnabled(true);
        txtCorreo.setEnabled(true);
        pssContrasenia.setEnabled(true);
        pssPassValidada.setEnabled(true);
        btnAgregar.setEnabled(true);
    }

    private void limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        cmbTipo.setSelectedItem("Seleccionar");
        txtCorreo.setText("");
        pssContrasenia.setText("");
        pssPassValidada.setText("");
    }

    public final void ConfigForm() {
        validaciones val = new validaciones();
        val.SLetras(txtBuscar);
        val.SLetras(txtNombre);
        val.SLetras(txtApellido);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        cmbTipo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        pssContrasenia = new javax.swing.JPasswordField();
        pssPassValidada = new javax.swing.JPasswordField();
        btnAgregar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        lbLogo = new javax.swing.JLabel();
        btnPDFempleados = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tipo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 158, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contraseña:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 195, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Confirmar:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 190, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 121, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Apellido:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 121, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Registro Usuarios");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 20, -1, -1));

        txtNombre.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 119, 164, -1));

        txtApellido.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 119, 191, -1));

        cmbTipo.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Administrador", "Empleado" }));
        jPanel1.add(cmbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 154, 164, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Correo:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 156, -1, -1));

        txtCorreo.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 154, 191, -1));

        pssContrasenia.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jPanel1.add(pssContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 193, 164, -1));

        pssPassValidada.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        jPanel1.add(pssPassValidada, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 188, 191, -1));

        btnAgregar.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 232, -1, -1));

        txtBuscar.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarMouseClicked(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 70, 149, -1));

        btnBuscar.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 67, -1, -1));

        btnModificar.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 283, -1, -1));

        btnEliminar.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 283, -1, -1));

        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbUsuarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 320, 680, 139));

        btnActualizar.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 232, -1, -1));

        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Clothes.png"))); // NOI18N
        jPanel1.add(lbLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 111, -1, -1));

        btnPDFempleados.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        btnPDFempleados.setText("Generar PDF");
        btnPDFempleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFempleadosActionPerformed(evt);
            }
        });
        jPanel1.add(btnPDFempleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 283, -1, -1));

        btnNuevo.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 232, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Lucida Calligraphy", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Regresar");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(648, 47, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(648, 67, 62, 10));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wc1677008.jpg"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 490));

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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        SQLUsuarios modSql = new SQLUsuarios();
        usuarios mod = new usuarios();

        String pass = new String(pssContrasenia.getPassword());
        String passval = new String(pssPassValidada.getPassword());
        String tipo = cmbTipo.getSelectedItem().toString();

        if (txtNombre.getText().equals("") || txtApellido.getText().equals("") || tipo.equals("Seleccionar")
                || txtCorreo.getText().equals("") || pass.equals("") || passval.equals("")) {
            JOptionPane.showMessageDialog(null, "Hay campos vacios, debe llenar todos los campos");
        } else {

            if (pass.equals(passval)) {

                if (modSql.existeusuario(txtNombre.getText()) == 0) {

                    mod.setNombre(txtNombre.getText());
                    mod.setApellido(txtApellido.getText());
                    mod.setTipousuario(cmbTipo.getSelectedItem().toString());
                    mod.setCorreo(txtCorreo.getText());
                    mod.setPassword(passval);

                    if (modSql.registrar(mod)) {
                        JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
                        limpiar();
                        bloquearinicio();
                        btnNuevo.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guardar");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario ya existe");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            }
        }
        metodosResgistro modSqlcagar = new metodosResgistro();
        modSqlcagar.cargar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtBuscar.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Ingrese el nombre del empleado");
        } else {
        metodosResgistro modSql = new metodosResgistro();
        modSql.buscar();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarMouseClicked
        txtBuscar.setText("");
        metodosResgistro modSql = new metodosResgistro();
        modSql.cargar();
    }//GEN-LAST:event_txtBuscarMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        metodosResgistro modSql = new metodosResgistro();
        modSql.eliminar();
        metodosResgistro modSqlcagar = new metodosResgistro();
        modSqlcagar.cargar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        metodosResgistro modSql = new metodosResgistro();
        modSql.modificar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        metodosResgistro modSql = new metodosResgistro();
        modSql.actualizar();
        metodosResgistro modSqlcagar = new metodosResgistro();
        modSqlcagar.cargar();
        limpiar();
        bloquearinicio();
        btnNuevo.setEnabled(true);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        desbloquear();
        btnNuevo.setEnabled(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnPDFempleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFempleadosActionPerformed
        try {
            JasperReport empleados = null;
            String path = "src\\Reportes\\Empleados.jasper";

            empleados = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(empleados, null, con);

            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(FrmRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnPDFempleadosActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        FrmPrincipa frm = new FrmPrincipa();
        frm.setVisible(true);
        if (mod.getTipousuario().equals("Empleado")) {
            FrmPrincipa.mProductos.setVisible(false);
            FrmPrincipa.mUsuarios.setVisible(false);
        }
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

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
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnActualizar;
    public static javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPDFempleados;
    public static javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbLogo;
    public static javax.swing.JPasswordField pssContrasenia;
    public static javax.swing.JPasswordField pssPassValidada;
    public static javax.swing.JTable tbUsuarios;
    public static javax.swing.JTextField txtApellido;
    public static javax.swing.JTextField txtBuscar;
    public static javax.swing.JTextField txtCorreo;
    public static javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

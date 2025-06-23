/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

import Conexion.Conectar;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class FrmMClientes extends javax.swing.JFrame {

    public FrmMClientes() {
        initComponents();
        this.setLocationRelativeTo(null);
        verDatos();
        limpiar();
    }
    
    public void limpiar() {
        this.TxtNombres.setText("");
        this.TxtApellidos.setText("");
        this.TxtDni.setText("");
        this.TxtDireccion.setText("");
        this.TxtIdCliente.setText("");
    }

    public void vaciarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
    }
    
    public void verDatos() {
        try {
            Connection con1;
            DefaultTableModel miModelo = (DefaultTableModel) jTable1.getModel();
            Conectar conect1 = new Conectar();
            con1 = conect1.getConexion();
            String dts[] = new String[5];
            String sql = "select * from TClientes";
            Statement st = con1.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dts[0] = rs.getString("Id");
                dts[1] = rs.getString("apellidos");
                dts[2] = rs.getString("nombres");
                dts[3] = rs.getString("dni");
                dts[4] = rs.getString("direccion");
                miModelo.addRow(dts);
            }
            jTable1.setModel(miModelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDEN VISUALIZAR LOS DATOS DE LA TABLA", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }    
    
private boolean validarDocumento() {
    String tipo = cmbTipoDoc.getSelectedItem().toString();
    String doc = TxtDni.getText().trim();

    if (tipo.equals("DNI")) {
        // DNI: 8 dígitos numéricos
        if (!doc.matches("\\d{8}")) {
            JOptionPane.showMessageDialog(this, "El DNI debe tener 8 números.", "Validación", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    } else if (tipo.equals("RUC")) {
        // RUC: 11 dígitos numéricos, empieza con 10, 15, 16, 17 o 20
        if (!doc.matches("\\d{11}")) {
            JOptionPane.showMessageDialog(this, "El RUC debe tener 11 números.", "Validación", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (!doc.startsWith("10") && !doc.startsWith("15") && !doc.startsWith("16") && !doc.startsWith("17") && !doc.startsWith("20")) {
            JOptionPane.showMessageDialog(this, "El RUC debe empezar con 10 o 20.", "Validación", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    return true;
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtIdCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtNombres = new javax.swing.JTextField();
        TxtDni = new javax.swing.JTextField();
        TxtDireccion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BtnNuevo = new javax.swing.JButton();
        BtnGrabar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        cmbTipoDoc = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Mantenimiento Clientes");

        jLabel2.setText("Codigo:");

        TxtIdCliente.setEditable(false);
        TxtIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdClienteActionPerformed(evt);
            }
        });

        jLabel3.setText("Apellidos:");

        jLabel4.setText("Nombres:");

        jLabel5.setText("DNI o RUC:");

        jLabel6.setText("Direccion:");

        TxtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDireccionActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Apellido", "Nombres", "DNI", "Direccion"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        BtnNuevo.setText("Nuevo");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });

        BtnGrabar.setText("Grabar");
        BtnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGrabarActionPerformed(evt);
            }
        });

        BtnModificar.setText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        jButton5.setText("Cerrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        cmbTipoDoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "RUC" }));
        cmbTipoDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoDocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(BtnNuevo)
                            .addGap(90, 90, 90)
                            .addComponent(BtnGrabar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnModificar)
                            .addGap(96, 96, 96)
                            .addComponent(BtnEliminar)
                            .addGap(88, 88, 88)
                            .addComponent(jButton5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TxtDni, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                    .addComponent(TxtApellidos)
                                    .addComponent(TxtNombres)
                                    .addComponent(TxtDireccion))
                                .addGap(18, 18, 18)
                                .addComponent(cmbTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TxtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cmbTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnNuevo)
                    .addComponent(BtnGrabar)
                    .addComponent(BtnModificar)
                    .addComponent(BtnEliminar)
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdClienteActionPerformed

    private void TxtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDireccionActionPerformed

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
                                  
   limpiar();
    this.TxtApellidos.requestFocus();

    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void BtnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGrabarActionPerformed
    try {
        Connection con1;
        Conectar conect1 = new Conectar();
        con1 = conect1.getConexion();
        String sql = "INSERT INTO TClientes(apellidos, nombres, dni, direccion) VALUES (?, ?, ?, ?)";
        PreparedStatement pst = con1.prepareStatement(sql);
        pst.setString(1, TxtApellidos.getText());
        pst.setString(2, TxtNombres.getText());
        pst.setString(3, TxtDni.getText());
        pst.setString(4, TxtDireccion.getText());
        if (!validarDocumento()) 
        return;
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Cliente guardado correctamente!");
        limpiar();
        vaciarTabla();
        verDatos();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al guardar cliente: " + e.getMessage());
    }
    }//GEN-LAST:event_BtnGrabarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
    try {
        Connection con1;
        Conectar conect1 = new Conectar();
        con1 = conect1.getConexion();
        String sql = "DELETE FROM TClientes WHERE Id=?";
        PreparedStatement pst = con1.prepareStatement(sql);
        pst.setString(1, TxtIdCliente.getText());
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente!");
        limpiar();
        verDatos();
        vaciarTabla();
verDatos();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar cliente: " + e.getMessage());
    }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
    try {
        Connection con1;
        Conectar conect1 = new Conectar();
        con1 = conect1.getConexion();
        String sql = "UPDATE TClientes SET apellidos=?, nombres=?, dni=?, direccion=? WHERE Id=?";
        PreparedStatement pst = con1.prepareStatement(sql);
        pst.setString(1, TxtApellidos.getText());
        pst.setString(2, TxtNombres.getText());
        pst.setString(3, TxtDni.getText());
        pst.setString(4, TxtDireccion.getText());
        pst.setString(5, TxtIdCliente.getText());
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente!");
        limpiar();
        vaciarTabla(); // <-- Vacía la tabla antes de volver a llenarla
        verDatos();    // <-- Vuelve a llenar con los datos correctos de la BD
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar cliente: " + e.getMessage());
    }
    
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JOptionPane.showMessageDialog(null,"Saliendo....");
       this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    try {
        int fila = jTable1.getSelectedRow();
        this.TxtIdCliente.setText(jTable1.getValueAt(fila, 0).toString());
        this.TxtApellidos.setText(jTable1.getValueAt(fila, 1).toString());
        this.TxtNombres.setText(jTable1.getValueAt(fila, 2).toString());
        this.TxtDni.setText(jTable1.getValueAt(fila, 3).toString());
        this.TxtDireccion.setText(jTable1.getValueAt(fila, 4).toString());
    } catch (Exception ex) {
        System.out.println("ERROR AL SELECCIONAR UN REGISTRO: " + ex.getMessage());
    }
    }//GEN-LAST:event_jTable1MouseClicked

    private void cmbTipoDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoDocActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    /* ====== Ajustes globales (JDK 8) ====== */
    java.util.Map<String, String> props = new java.util.HashMap<>();
    props.put("Component.arc",     "14");
    props.put("Button.arc",        "20");
    props.put("TextComponent.arc", "18");
    com.formdev.flatlaf.FlatLaf.setGlobalExtraDefaults(props);

    /* ===== Look & Feel ===== */
    com.formdev.flatlaf.themes.FlatMacDarkLaf.setup();
        /* Create and display the form */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGrabar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevo;
    public javax.swing.JTextField TxtApellidos;
    public javax.swing.JTextField TxtDireccion;
    public javax.swing.JTextField TxtDni;
    private javax.swing.JTextField TxtIdCliente;
    public javax.swing.JTextField TxtNombres;
    private javax.swing.JComboBox<String> cmbTipoDoc;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

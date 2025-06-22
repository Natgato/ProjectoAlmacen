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



public class FrmClientes extends javax.swing.JFrame {

    public FrmClientes() {
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
     

    

    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TxtDni, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                .addComponent(TxtApellidos)
                                .addComponent(TxtNombres)
                                .addComponent(TxtDireccion))
                            .addComponent(TxtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BtnNuevo)
                                .addGap(93, 93, 93)
                                .addComponent(BtnGrabar)
                                .addGap(93, 93, 93)
                                .addComponent(BtnModificar)
                                .addGap(93, 93, 93)
                                .addComponent(BtnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel1)
                .addGap(200, 200, 200))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
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
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnNuevo)
                    .addComponent(jButton5)
                    .addComponent(BtnGrabar)
                    .addComponent(BtnModificar)
                    .addComponent(BtnEliminar))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        if (this.TxtNombres.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL NOMBRE", "Advertencia", JOptionPane.WARNING_MESSAGE);
            this.TxtNombres.requestFocus();
        } else if (this.TxtApellidos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL APELLIDO", "Advertencia", JOptionPane.WARNING_MESSAGE);
            this.TxtApellidos.requestFocus();
        } else if (this.TxtDni.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL DNI", "Advertencia", JOptionPane.WARNING_MESSAGE);
            this.TxtDni.requestFocus();
        } else if (this.TxtDireccion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA DIRECCION", "Advertencia", JOptionPane.WARNING_MESSAGE);
            this.TxtDireccion.requestFocus();
        } else {
            try {
                Connection con;
Conectar conect = new Conectar();
                con = conect.getConexion();
                String sql = "insert into tclientes(apellidos,nombres,dni,direccion) values (?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, this.TxtApellidos.getText());
                pst.setString(2, this.TxtNombres.getText());
                pst.setString(3, this.TxtDni.getText());
                pst.setString(4, this.TxtDireccion.getText());
                int n = pst.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(this, "DATOS GUARDADOS CORRECTAMENTE");
                    limpiar();
                    vaciarTabla();
                    verDatos();
                }
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(this, "LOS DATOS NO HAN SIDO GUARDADOS CORRECTAMENTE", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    
    }//GEN-LAST:event_BtnGrabarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed

        int fila = jTable1.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN REGISTRO", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            int opc = JOptionPane.showConfirmDialog(this, "¿ESTA SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opc == JOptionPane.YES_OPTION) {
                try {
                    Connection con;
Conectar conect = new Conectar();
                    con = conect.getConexion();
                    String sql = "delete from TClientes where Id= ?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setInt(1, Integer.parseInt(this.TxtIdCliente.getText()));
                    int n = pst.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(this, "DATOS ELIMINADOS CORRECTAMENTE");
                        limpiar();
                        vaciarTabla();
                        verDatos();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "DATOS NO ELIMINADOS CORRECTAMENTE: " + ex.getMessage());
                }
            }
        }  
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed

        try {
            Connection con;
Conectar conect = new Conectar();
            con = conect.getConexion();
            String sql = "update TClientes set apellidos = ?, nombres = ?, dni = ?, direccion = ? where Id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, this.TxtApellidos.getText());
            pst.setString(2, this.TxtNombres.getText());
            pst.setString(3, this.TxtDni.getText());
            pst.setString(4, this.TxtDireccion.getText());
            pst.setInt(5, Integer.parseInt(this.TxtIdCliente.getText()));
            int n = pst.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(this, "DATOS ACTUALIZADOS CORRECTAMENTE");
                limpiar();
                vaciarTabla();
                verDatos();
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, "LOS DATOS NO HAN SIDO ACTUALIZADOS CORRECTAMENTE", "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JOptionPane.showMessageDialog(null,"Saliendo....");
       this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmClientes().setVisible(true);
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

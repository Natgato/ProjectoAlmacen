package Formularios;
import Conexion.Conectar;
import java.awt.*;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class FrmProveedores extends javax.swing.JFrame {


    public FrmProveedores() {
        initComponents();
        this.setLocationRelativeTo(null);
        limpiar();
        vaciarTabla();
        verDatos();
    }

        public void limpiar(){
        this.TxtRazon.setText("");
        this.TxtRuc.setText("");
        this.TxtDireccion.setText("");
 }
    
     public void vaciarTabla(){
        DefaultTableModel Modelo = (DefaultTableModel) jTable1.getModel();
        String titulos[] = {"Id","RazonSocial","RUC","Direccion","Telefono"};
        Modelo = new DefaultTableModel(null,titulos);
        jTable1.setModel(Modelo);
 }
    
    public void verDatos(){
        try {
        Connection con1 = null;
        DefaultTableModel miModelo = (DefaultTableModel) jTable1.getModel();
        Conectar conect1 = new Conectar();
        con1 = conect1.getConexion();
        String dts[] = new String[5];
        String sql = "select * from TProveedores";
        Statement st = con1.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
        dts[0] = rs.getString("Id");
        dts[1] = rs.getString("RazonSocial");
        dts[2] = rs.getString("RUC");
        dts[3] = rs.getString("Direccion");
        dts[4] = rs.getString("Telefono");
        miModelo.addRow(dts);
        }
        jTable1.setModel(miModelo);
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "NO SE PUEDEN VISUALIZAR LOS DATOS DE LA TABLA PRODUCTOS", "Error",
       JOptionPane.ERROR_MESSAGE);
        }
        } 
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        TxtIdCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtRazon = new javax.swing.JTextField();
        TxtRuc = new javax.swing.JTextField();
        TxtDireccion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BtnNuevo = new javax.swing.JButton();
        BtnGrabar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtTelefono = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Codigo:");

        TxtIdCliente.setEditable(false);
        TxtIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdClienteActionPerformed(evt);
            }
        });

        jLabel5.setText("Razon Social:");

        jLabel6.setText("DNI o RUC:");

        jLabel7.setText("Direccion:");

        TxtRazon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtRazonActionPerformed(evt);
            }
        });

        TxtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDireccionActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Razon social:", "DNI", "Direccion"
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Mantenimiento de Proveedores");

        jLabel2.setText("Telefono:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TxtRuc, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                .addComponent(TxtRazon)
                                .addComponent(TxtDireccion))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TxtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(128, 128, 128)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(213, 213, 213))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtRazon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
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
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void BtnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGrabarActionPerformed
if (this.TxtRazon.getText().isEmpty()) {
    JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA RAZON SOCIAL", "Advertencia", JOptionPane.WARNING_MESSAGE);
    this.TxtRazon.requestFocus();
} else if (this.TxtRuc.getText().isEmpty()) {
    JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL RUC", "Advertencia", JOptionPane.WARNING_MESSAGE);
    this.TxtRuc.requestFocus();
} else if (this.TxtDireccion.getText().isEmpty()) {
    JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA DIRECCION", "Advertencia", JOptionPane.WARNING_MESSAGE);
    this.TxtDireccion.requestFocus();
} else {
    try {
        Connection con;
        Conectar conect = new Conectar();
        con = conect.getConexion();
        String sql = "insert into tproveedores(telefono,RazonSocial,RUC,direccion) values (?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, this.TxtTelefono.getText());
        pst.setString(2, this.TxtRazon.getText());
        pst.setString(3, this.TxtRuc.getText());
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

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed

try {
    Connection con;
    Conectar conect = new Conectar();
    con = conect.getConexion();
    String sql = "UPDATE TClientes SET apellidos = ?, nombres = ?, dni = ?, direccion = ? WHERE Id = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    
    pst.setString(1, this.TxtRazon.getText());      // apellidos
    pst.setString(2, this.TxtRuc.getText());        // nombres
    pst.setString(3, this.TxtTelefono.getText());   // dni
    pst.setString(4, this.TxtDireccion.getText());  // direccion
    pst.setInt(5, Integer.parseInt(this.TxtIdCliente.getText())); // Id

    int n = pst.executeUpdate();
    if (n > 0) {
        JOptionPane.showMessageDialog(this, "DATOS ACTUALIZADOS CORRECTAMENTE");
        limpiar();
        vaciarTabla();
        verDatos();
    }
} catch (SQLException | HeadlessException e) {
    JOptionPane.showMessageDialog(this, "LOS DATOS NO HAN SIDO ACTUALIZADOS CORRECTAMENTE\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed

int fila = jTable1.getSelectedRow();
if (fila == -1) {
    JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN REGISTRO", "Advertencia", JOptionPane.WARNING_MESSAGE);
} else {
    int opc = JOptionPane.showConfirmDialog(this, "¿ESTÁ SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (opc == JOptionPane.YES_OPTION) {
        try {
            int id = Integer.parseInt(jTable1.getValueAt(fila, 0).toString()); // Asumiendo que la columna 0 es el ID

            Connection con;
            Conectar conect = new Conectar();
            con = conect.getConexion();
            String sql = "DELETE FROM TProveedores WHERE Id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            int n = pst.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(this, "DATOS ELIMINADOS CORRECTAMENTE");
                limpiar();
                vaciarTabla();
                verDatos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "DATOS NO ELIMINADOS CORRECTAMENTE: " + ex.getMessage());
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "ID no válido: " + nfe.getMessage());
        }
    }
}

    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void TxtRazonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtRazonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtRazonActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
dispose(); // Cierra solo la ventana actual
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
try {
    int fila = jTable1.getSelectedRow(); // fila seleccionada
    this.TxtIdCliente.setText(jTable1.getValueAt(fila, 0).toString());
    this.TxtRazon.setText(jTable1.getValueAt(fila, 1).toString());
    this.TxtRuc.setText(jTable1.getValueAt(fila, 2).toString());
    this.TxtDireccion.setText(jTable1.getValueAt(fila, 3).toString());
    this.TxtTelefono.setText(jTable1.getValueAt(fila, 3).toString());
} catch (Exception ex) {
    System.out.println("ERROR AL SELECCIONAR UN PRODUCTO : " + ex.getMessage());
}    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(FrmProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGrabar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevo;
    public javax.swing.JTextField TxtDireccion;
    private javax.swing.JTextField TxtIdCliente;
    public javax.swing.JTextField TxtRazon;
    public javax.swing.JTextField TxtRuc;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

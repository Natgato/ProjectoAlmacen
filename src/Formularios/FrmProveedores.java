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


public class FrmProveedores extends javax.swing.JFrame {


    public FrmProveedores() {
        initComponents();
        this.setLocationRelativeTo(null);
        verDatos();
        limpiar();
    }

    public void limpiar() {
        this.TxtIdProveedor.setText("");
        this.TxtRazonSocial.setText("");
        this.TxtRUC.setText("");
        this.TxtDireccion.setText("");
        this.TxtTelefono.setText("");
    }

    public void vaciarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) jTableProveedores.getModel();
        modelo.setRowCount(0);
    }
    
    public void verDatos() {
        try {
            Connection con1;
            DefaultTableModel miModelo = (DefaultTableModel) jTableProveedores.getModel();
            Conectar conect1 = new Conectar();
            con1 = conect1.getConexion();
            String dts[] = new String[5];
            String sql = "select * from TProveedores";
            Statement st = con1.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dts[0] = rs.getString("Id");
                dts[1] = rs.getString("RazonSocial");
                dts[2] = rs.getString("RUC");
                dts[3] = rs.getString("Direccion");
                dts[4] = rs.getString("Telefono");
                miModelo.addRow(dts);
            }
            jTableProveedores.setModel(miModelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDEN VISUALIZAR LOS DATOS DE LA TABLA", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtIdProveedor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtRazonSocial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtRUC = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtTelefono = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProveedores = new javax.swing.JTable();
        BtnNuevo = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Proveedores");

        jLabel2.setText("Codigo:");

        jLabel3.setText("Razón Social:");

        jLabel4.setText("RUC:");

        jLabel5.setText("Dirección:");

        jLabel6.setText("Telefono:");

        jTableProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Razón Social", "RUC", "Dirección", "Teléfono"
            }
        ));
        jTableProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProveedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProveedores);

        BtnNuevo.setText("Nuevo");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });

        BtnGuardar.setText("Guardar");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        BtnModificar.setText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Cerrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtRazonSocial)
                            .addComponent(TxtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(BtnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnNuevo)
                    .addComponent(BtnGuardar)
                    .addComponent(BtnModificar)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProveedoresMouseClicked
        try {
            int fila = jTableProveedores.getSelectedRow();
            this.TxtIdProveedor.setText(jTableProveedores.getValueAt(fila, 0).toString());
            this.TxtRazonSocial.setText(jTableProveedores.getValueAt(fila, 1).toString());
            this.TxtRUC.setText(jTableProveedores.getValueAt(fila, 2).toString());
            this.TxtDireccion.setText(jTableProveedores.getValueAt(fila, 3).toString());
            this.TxtTelefono.setText(jTableProveedores.getValueAt(fila, 4).toString());
        } catch (Exception ex) {
            System.out.println("ERROR AL SELECCIONAR UN REGISTRO: " + ex.getMessage());
        }
    }//GEN-LAST:event_jTableProveedoresMouseClicked

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        limpiar();
        this.TxtRazonSocial.requestFocus();
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        if (this.TxtRazonSocial.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA RAZÓN SOCIAL", "Advertencia", JOptionPane.WARNING_MESSAGE);
            this.TxtRazonSocial.requestFocus();
        } else if (this.TxtRUC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL RUC", "Advertencia", JOptionPane.WARNING_MESSAGE);
            this.TxtRUC.requestFocus();
        } else if (this.TxtDireccion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA DIRECCIÓN", "Advertencia", JOptionPane.WARNING_MESSAGE);
            this.TxtDireccion.requestFocus();
        } else if (this.TxtTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL TELÉFONO", "Advertencia", JOptionPane.WARNING_MESSAGE);
            this.TxtTelefono.requestFocus();
        } else {
            try {
                Connection con;
                Conectar conect = new Conectar();
                con = conect.getConexion();
                String sql = "insert into TProveedores(RazonSocial,RUC,Direccion,Telefono) values (?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, this.TxtRazonSocial.getText());
                pst.setString(2, this.TxtRUC.getText());
                pst.setString(3, this.TxtDireccion.getText());
                pst.setString(4, this.TxtTelefono.getText());
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
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        try {
            Connection con;
            Conectar conect = new Conectar();
            con = conect.getConexion();
            String sql = "update TProveedores set RazonSocial = ?, RUC = ?, Direccion = ?, Telefono = ? where Id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, this.TxtRazonSocial.getText());
            pst.setString(2, this.TxtRUC.getText());
            pst.setString(3, this.TxtDireccion.getText());
            pst.setString(4, this.TxtTelefono.getText());
            pst.setInt(5, Integer.parseInt(this.TxtIdProveedor.getText()));
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int fila = jTableProveedores.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN REGISTRO", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            int opc = JOptionPane.showConfirmDialog(this, "¿ESTÁ SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opc == JOptionPane.YES_OPTION) {
                try {
                    Connection con;
                    Conectar conect = new Conectar();
                    con = conect.getConexion();
                    String sql = "delete from TProveedores where Id= ?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setInt(1, Integer.parseInt(this.TxtIdProveedor.getText()));
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
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JTextField TxtDireccion;
    private javax.swing.JTextField TxtIdProveedor;
    private javax.swing.JTextField TxtRUC;
    private javax.swing.JTextField TxtRazonSocial;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProveedores;
    // End of variables declaration//GEN-END:variables
}

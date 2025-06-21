
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


public class FrmCompras extends javax.swing.JFrame {

    public FrmCompras() {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        limpiar();
        vaciarTabla();
        verDatos();
    }

    public void limpiar(){
        this.TxtDescripcion.setText("");
        this.TxtUnidadMedida.setText("");
        this.TxtPrecio.setText("");
        this.TxtIdProducto.setText("");
 }

     public void vaciarTabla(){
        DefaultTableModel Modelo = (DefaultTableModel) jTable1.getModel();
        String titulos[] = {"CODIGO","DESCRIPCION","PRECIO","UNIDAD DE MEDIDA"};
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
        String sql = "select * from TProductos";
        Statement st = con1.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
        dts[0] = rs.getString("Id");
        dts[1] = rs.getString("descripcion");
        dts[2] = rs.getString("PrecioUnitario");
        dts[3] = rs.getString("UNidadMedida");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtIdProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtDescripcion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TxtPrecio = new javax.swing.JTextField();
        TxtUnidadMedida = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BtnNuevo = new javax.swing.JButton();
        BtnGrabar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Mantenimiento de Productos");

        jLabel2.setText("Codigo:");

        TxtIdProducto.setEditable(false);
        TxtIdProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdProductoActionPerformed(evt);
            }
        });

        jLabel3.setText("Descripcion");

        jLabel4.setText("Precio Unitario");

        jLabel5.setText("Unidad de Medida");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Precio Unitario", "Unidad de Medida"
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
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TxtUnidadMedida, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                .addComponent(TxtDescripcion)
                                .addComponent(TxtPrecio))
                            .addComponent(TxtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(BtnNuevo)
                            .addGap(93, 93, 93)
                            .addComponent(BtnGrabar)
                            .addGap(93, 93, 93)
                            .addComponent(BtnModificar)
                            .addGap(93, 93, 93)
                            .addComponent(BtnEliminar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
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

    private void TxtIdProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdProductoActionPerformed

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
    limpiar(); 
    this.TxtDescripcion.requestFocus(); 
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void BtnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGrabarActionPerformed

    if (this.TxtPrecio.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL PRECIO", "Advertencia", JOptionPane.WARNING_MESSAGE); 
        this.TxtPrecio.requestFocus(); 
    } else if (this.TxtDescripcion.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA DESCRIPCION ", "Advertencia", JOptionPane.WARNING_MESSAGE); 
        this.TxtDescripcion.requestFocus(); 
    } else if (this.TxtUnidadMedida.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "FALTA INGRESAR LA UNIDAD DE MEDIDA", "Advertencia", JOptionPane.WARNING_MESSAGE); 
        this.TxtUnidadMedida.requestFocus(); 
    } else {
        try {
            Connection con = null; 
            Conectar conect = new Conectar(); 
            con = conect.getConexion(); 

            String sql = "insert into TProductos(descripcion,PrecioUnitario,UnidadMedida) values (?,?,?)"; 
            PreparedStatement pst = con.prepareStatement(sql); 
            pst.setString(1, this.TxtDescripcion.getText()); 
            pst.setString(2, this.TxtPrecio.getText()); 
            pst.setString(3, this.TxtUnidadMedida.getText()); 

            int n = pst.executeUpdate(); 
            if (n > 0) {
                JOptionPane.showMessageDialog(this, "DATOS GUARDADOS CORRECTAMENTE"); 
                limpiar(); 
                vaciarTabla(); 
                verDatos(); 
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, "LOS DATOS NO HAN SIDO GUARDADOS CORRECTAMENTE", "Error", JOptionPane.ERROR_MESSAGE); 
            System.err.println("Error al persistir los datos: " + e.getMessage()); 
            e.printStackTrace(); 
        }
    }   
        
        
    }//GEN-LAST:event_BtnGrabarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed

    try {
        Connection con = null; 
        Conectar conect = new Conectar(); 
        con = conect.getConexion(); 

        String sql = "update TProductos set Descripcion = ?, PrecioUnitario = ?, UnidadMedida = ? where Id = ?"; 
        PreparedStatement pst = con.prepareStatement(sql); 
        pst.setString(1, this.TxtDescripcion.getText()); 
        pst.setString(2, this.TxtPrecio.getText()); 
        pst.setString(3, this.TxtUnidadMedida.getText()); 
        pst.setInt(4, Integer.parseInt(this.TxtIdProducto.getText())); 

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

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
       int fila = jTable1.getSelectedRow(); 
    if (fila == -1) {
        JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN REGISTRO", "Advertencia", JOptionPane.WARNING_MESSAGE); 
    } else {
        int opc = JOptionPane.showConfirmDialog(this, "¿ESTA SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
        if (opc == JOptionPane.YES_OPTION) {
            try {
                Connection con = null; 
                Conectar conect = new Conectar(); 
                con = conect.getConexion(); 

                String sql = "delete from TProductos where Id= ?"; 
                PreparedStatement pst = con.prepareStatement(sql); 
                pst.setInt(1, Integer.parseInt(this.TxtIdProducto.getText())); 

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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
try {
    int fila = jTable1.getSelectedRow(); // fila seleccionada
    this.TxtIdProducto.setText(jTable1.getValueAt(fila, 0).toString());
    this.TxtDescripcion.setText(jTable1.getValueAt(fila, 1).toString());
    this.TxtPrecio.setText(jTable1.getValueAt(fila, 2).toString());
    this.TxtUnidadMedida.setText(jTable1.getValueAt(fila, 3).toString());
} catch (Exception ex) {
    System.out.println("ERROR AL SELECCIONAR UN PRODUCTO : " + ex.getMessage());
}
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCompras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGrabar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevo;
    public javax.swing.JTextField TxtDescripcion;
    private javax.swing.JTextField TxtIdProducto;
    public javax.swing.JTextField TxtPrecio;
    public javax.swing.JTextField TxtUnidadMedida;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

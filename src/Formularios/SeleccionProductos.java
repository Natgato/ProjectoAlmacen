
package Formularios;

import Conexion.Conectar;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeleccionProductos extends javax.swing.JFrame {
    private FrmCotizaciones frmCotizacionesRef;

public SeleccionProductos() {
    this.frmCotizacionesRef = null;
    initComponents();
    setLocationRelativeTo(null);
}
    
    public SeleccionProductos(FrmCotizaciones frmCotiz) {
        
        this.frmCotizacionesRef = frmCotiz;
        this.setUndecorated(true);
        initComponents();

        this.setLocationRelativeTo(null);
        vaciarTablaProductos();
    verDatosProductos(); // ← debe llamarse aquí
    }

    
    public void buscarProducto() {
    String busqueda = txtBuscarProducto.getText().trim();
    DefaultTableModel modelo = (DefaultTableModel) tablaProductos.getModel();
    modelo.setRowCount(0); // limpia la tabla

    String sql = "SELECT * FROM TProductos WHERE descripcion LIKE ?";
    try (Connection con = new Conectar().getConexion();
         PreparedStatement pst = con.prepareStatement(sql)) {
        pst.setString(1, "%" + busqueda + "%");
        try (ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                String[] fila = {
                    rs.getString("Id"),
                    rs.getString("descripcion"),
                    rs.getString("PrecioUnitario"),
                    rs.getString("UnidadMedida")
                };
                modelo.addRow(fila);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al buscar producto.", "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}

    
public void verDatosProductos() {
    DefaultTableModel modelo = (DefaultTableModel) tablaProductos.getModel();
    modelo.setRowCount(0); // Limpia filas viejas

    try (Connection con = new Conectar().getConexion();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM TProductos")) {
        while (rs.next()) {
            Object[] fila = {
                rs.getString("Id"),
                rs.getString("descripcion"),
                rs.getString("PrecioUnitario"),
                rs.getString("UnidadMedida"),
                rs.getString("Stock")
            };
            modelo.addRow(fila);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error mostrando productos", "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}
        
public void vaciarTablaProductos() {
    String[] titulos = {"ID", "Descripción", "Precio Unitario", "Unidad de Medida"};
    DefaultTableModel modelo = new DefaultTableModel(null, titulos);
    tablaProductos.setModel(modelo);
}
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarProducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        TxtDescripcion = new javax.swing.JTextField();
        TxtPrecio = new javax.swing.JTextField();
        TxtUnidadMedida = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtIdProducto = new javax.swing.JTextField();
        BtnCancelar = new javax.swing.JButton();
        btnBuscarProducto = new javax.swing.JButton();
        btnSeleccionarProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Registro de Productos");

        jLabel2.setText("Buscar Producto:");

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Apellidos", "Nombres", "Direccion"
            }
        ));
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        TxtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPrecioActionPerformed(evt);
            }
        });

        jLabel5.setText("Unidad de Medida:");

        jLabel4.setText("Precio Unitario:");

        jLabel3.setText("Descripcion:");

        jLabel6.setText("Codigo:");

        TxtIdProducto.setEditable(false);
        TxtIdProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdProductoActionPerformed(evt);
            }
        });

        BtnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnCancelar.setText("X");
        BtnCancelar.setBorder(null);
        BtnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnCancelarMouseExited(evt);
            }
        });
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        btnSeleccionarProducto.setText("Seleccionar");
        btnSeleccionarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(83, 83, 83)
                                        .addComponent(btnBuscarProducto))
                                    .addComponent(TxtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(TxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(56, 56, 56)
                                        .addComponent(btnSeleccionarProducto)))))
                        .addGap(0, 52, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnCancelar)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProducto)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TxtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarProducto))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
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

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked

        int fila = tablaProductos.getSelectedRow();
        this.TxtIdProducto.setText(tablaProductos.getValueAt(fila, 0).toString());
        this.TxtDescripcion.setText(tablaProductos.getValueAt(fila, 1).toString());
        this.TxtUnidadMedida.setText(tablaProductos.getValueAt(fila, 3).toString());
        this.TxtPrecio.setText(tablaProductos.getValueAt(fila, 2).toString());
        

    }//GEN-LAST:event_tablaProductosMouseClicked

    private void TxtIdProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdProductoActionPerformed

    private void TxtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPrecioActionPerformed

    private void BtnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCancelarMouseEntered
        BtnCancelar.setBackground(Color.red);
        BtnCancelar.setForeground(Color.white);
    }//GEN-LAST:event_BtnCancelarMouseEntered

    private void BtnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCancelarMouseExited
        BtnCancelar.setBackground(Color.WHITE);
        BtnCancelar.setForeground(Color.black);
    }//GEN-LAST:event_BtnCancelarMouseExited

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
    buscarProducto();
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnSeleccionarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarProductoActionPerformed
    int fila = tablaProductos.getSelectedRow();

    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un producto de la lista.");
        return;
    }

    Object objCodigo      = tablaProductos.getValueAt(fila, 0);
    Object objDescripcion = tablaProductos.getValueAt(fila, 1);
    Object objPrecio      = tablaProductos.getValueAt(fila, 2);

    // Validación estricta anti-null
    if (objCodigo == null || objDescripcion == null || objPrecio == null
        || objCodigo.toString().trim().isEmpty()
        || objDescripcion.toString().trim().isEmpty()
        || objPrecio.toString().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "El producto seleccionado tiene datos incompletos.");
        return;
    }

    String codigo = objCodigo.toString();
    String descripcion = objDescripcion.toString();
    double precioUnitario;
    try {
        precioUnitario = Double.parseDouble(objPrecio.toString());
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "El precio del producto no es válido.");
        return;
    }


    if (frmCotizacionesRef != null) {
        frmCotizacionesRef.agregarProductoDetalle(codigo, descripcion, precioUnitario);
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo agregar el producto. No hay una cotización activa.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    dispose();
    }//GEN-LAST:event_btnSeleccionarProductoActionPerformed


    public static void main(String args[]) {
    /* ====== Ajustes globales (JDK 8) ====== */
    java.util.Map<String, String> props = new java.util.HashMap<>();
    props.put("Component.arc",     "14");
    props.put("Button.arc",        "20");
    props.put("TextComponent.arc", "18");
    com.formdev.flatlaf.FlatLaf.setGlobalExtraDefaults(props);

    /* ===== Look & Feel ===== */
    com.formdev.flatlaf.themes.FlatMacDarkLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeleccionProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    public javax.swing.JTextField TxtDescripcion;
    private javax.swing.JTextField TxtIdProducto;
    public javax.swing.JTextField TxtPrecio;
    public javax.swing.JTextField TxtUnidadMedida;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnSeleccionarProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtBuscarProducto;
    // End of variables declaration//GEN-END:variables
}

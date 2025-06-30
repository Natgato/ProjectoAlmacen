
package Formularios;
import Conexion.Conectar;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;




public class FrmAddCliente extends javax.swing.JFrame {
private FrmCotizaciones frmPadre; // referencia al padre
private FrmVentas frmMadre; // referencia al padre

public FrmAddCliente() {
    initComponents();
    this.setLocationRelativeTo(null);
    vaciarTablaClientes();
    verDatosCliente();
    jTextField1.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { buscarClientesTiempoReal(); }
        public void removeUpdate(DocumentEvent e) { buscarClientesTiempoReal(); }
        public void changedUpdate(DocumentEvent e) { buscarClientesTiempoReal(); }
    });
}

    public FrmAddCliente(FrmVentas Madre) {
    this.frmMadre = Madre;
    this.setUndecorated(true);
    this.setUndecorated(true);
    initComponents();
    this.setLocationRelativeTo(null);
    vaciarTablaClientes();
    verDatosCliente();
    jTextField1.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { buscarClientesTiempoReal(); }
        public void removeUpdate(DocumentEvent e) { buscarClientesTiempoReal(); }
        public void changedUpdate(DocumentEvent e) { buscarClientesTiempoReal(); }
});
            
    }

    public FrmAddCliente(FrmCotizaciones padre) {
    this.frmPadre = padre;
    this.setUndecorated(true);
    this.setUndecorated(true);
    initComponents();
    this.setLocationRelativeTo(null);
    vaciarTablaClientes();
    verDatosCliente();
    jTextField1.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { buscarClientesTiempoReal(); }
        public void removeUpdate(DocumentEvent e) { buscarClientesTiempoReal(); }
        public void changedUpdate(DocumentEvent e) { buscarClientesTiempoReal(); }
});
            
    }
    
    
private void buscarClientesTiempoReal() {
    String filtro = jTextField1.getText().trim();
    vaciarTablaClientes();
    DefaultTableModel modelo = (DefaultTableModel) TablaClientes.getModel();

    String sql = "SELECT * FROM TClientes WHERE apellidos LIKE ? OR nombres LIKE ? OR dni LIKE ? OR direccion LIKE ?";
    try (Connection con = new Conectar().getConexion();
         java.sql.PreparedStatement pst = con.prepareStatement(sql)) {

        String busqueda = "%" + filtro + "%";
        for (int i = 1; i <= 4; i++) pst.setString(i, busqueda);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getString("Id"),
                rs.getString("apellidos"),
                rs.getString("nombres"),
                rs.getString("dni"),
                rs.getString("direccion")
            });
        }
    } catch (Exception e) {
        // No es crítico mostrar error en cada tecla, solo para debug
        // JOptionPane.showMessageDialog(this, "Error en la búsqueda.");
        e.printStackTrace();
    }
}

    
    
public void verDatosCliente() {
    vaciarTablaClientes();
    DefaultTableModel modelo = (DefaultTableModel) TablaClientes.getModel();

    try (Connection con = new Conectar().getConexion()) {

        if (con == null) {          // ⬅ comprueba
            JOptionPane.showMessageDialog(this,
                "No se pudo conectar a la base de datos.",
                "Error de conexión", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM TClientes")) {

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("Id"),
                    rs.getString("apellidos"),
                    rs.getString("nombres"),
                    rs.getString("dni"),
                    rs.getString("direccion")
                });
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,"Error consultando clientes");
        e.printStackTrace();
    }
}



        
        public void vaciarTablaClientes() {
        DefaultTableModel Modelo = (DefaultTableModel) TablaClientes.getModel();
        String titulos[] = {"ID", "APELLIDOS", "NOMBRES", "DNI", "DIRECCION"};
        Modelo = new DefaultTableModel(null, titulos);
        TablaClientes.setModel(Modelo);
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaClientes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApenom = new javax.swing.JTextField();
        BtnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Registro de clientes");

        jLabel2.setText("Buscar Cliente:");

        TablaClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaClientes);

        jLabel3.setText("Codigo del cliente");

        jLabel4.setText("Apellidos y Nombres del Cliente");

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

        jLabel5.setText("Direccion del Cliente");

        jLabel6.setText("DNI o RUC:");

        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarCliente)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSeleccionar)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(txtApenom, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                .addComponent(txtIdCliente)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addComponent(txtDireccion)
                                .addComponent(jLabel6)
                                .addComponent(txtRuc)))
                        .addContainerGap(49, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addComponent(BtnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente)
                    .addComponent(btnSeleccionar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

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

    private void TablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaClientesMouseClicked

    int fila = TablaClientes.getSelectedRow();
    this.txtIdCliente.setText(TablaClientes.getValueAt(fila, 0).toString());
    this.txtApenom.setText(TablaClientes.getValueAt(fila, 1).toString() + " " + TablaClientes.getValueAt(fila, 2).toString());
    this.txtDireccion.setText(TablaClientes.getValueAt(fila, 4).toString());
    this.txtRuc.setText(TablaClientes.getValueAt(fila, 3).toString());


    }//GEN-LAST:event_TablaClientesMouseClicked

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCancelarMouseExited
        BtnCancelar.setBackground(Color.WHITE);
        BtnCancelar.setForeground(Color.black);
    }//GEN-LAST:event_BtnCancelarMouseExited

    private void BtnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCancelarMouseEntered
        BtnCancelar.setBackground(Color.red);
        BtnCancelar.setForeground(Color.white);
    }//GEN-LAST:event_BtnCancelarMouseEntered

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
    String filtro = jTextField1.getText().trim();
    vaciarTablaClientes();
    DefaultTableModel modelo = (DefaultTableModel) TablaClientes.getModel();

    String sql = "SELECT * FROM TClientes WHERE apellidos LIKE ? OR nombres LIKE ? OR dni LIKE ? OR direccion LIKE ?";
    try (Connection con = new Conectar().getConexion();
         java.sql.PreparedStatement pst = con.prepareStatement(sql)) {

        String busqueda = "%" + filtro + "%";
        for (int i = 1; i <= 4; i++) pst.setString(i, busqueda);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getString("Id"),
                rs.getString("apellidos"),
                rs.getString("nombres"),
                rs.getString("dni"),
                rs.getString("direccion")
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error en la búsqueda.");
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
    int fila = TablaClientes.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Selecciona un cliente de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }
    // Obtén los datos del cliente seleccionado
    String idCliente  = TablaClientes.getValueAt(fila, 0).toString();
    String apellidos  = TablaClientes.getValueAt(fila, 1).toString();
    String nombres    = TablaClientes.getValueAt(fila, 2).toString();
    String nombreCompleto = apellidos + " " + nombres;

    // Manda el cliente al formulario padre
    if (frmPadre != null) {
        frmPadre.setCliente(idCliente, nombreCompleto);
        
    }
    else if (frmMadre != null) {
    // Si el formulario madre es FrmVentas
    frmMadre.setCliente(idCliente, nombreCompleto);
}
    this.dispose(); // Cierra la ventana de clientes
    }//GEN-LAST:event_btnSeleccionarActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAddCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JTable TablaClientes;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtApenom;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtRuc;
    // End of variables declaration//GEN-END:variables
}

package Formularios;

import Conexion.Conectar;
import Formularios.FrmMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class FrmInicio1 extends javax.swing.JFrame {
    private Conectar conexionBD; // Crear una instancia de la clase Conexion
    public FrmInicio1() {
        initComponents();
        this.setLocationRelativeTo(null);
        conexionBD = new Conectar(); // Inicializar la conexión
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TxtUser = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        TxtPswd = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        BtnInicioSesion = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(255, 0, 51));
        jLabel3.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jLabel3.setText("INICIO DE SESION ");

        jLabel1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel1.setText("Usuario :");

        TxtUser.setForeground(new java.awt.Color(204, 204, 204));
        TxtUser.setBorder(null);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel2.setText("Clave :");

        TxtPswd.setForeground(new java.awt.Color(204, 204, 204));
        TxtPswd.setBorder(null);
        TxtPswd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPswdActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        BtnInicioSesion.setBackground(new java.awt.Color(20, 160, 200));
        BtnInicioSesion.setFont(new java.awt.Font("Arial", 3, 16)); // NOI18N
        BtnInicioSesion.setForeground(new java.awt.Color(255, 255, 255));
        BtnInicioSesion.setText("Iniciar Sesión");
        BtnInicioSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnInicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInicioSesionActionPerformed(evt);
            }
        });

        BtnCancelar.setBackground(new java.awt.Color(20, 160, 200));
        BtnCancelar.setFont(new java.awt.Font("Arial", 3, 16)); // NOI18N
        BtnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/com/logo  (3).jpg"))); // NOI18N
        jLabel4.setText("jLabel4");

        jButton1.setBackground(new java.awt.Color(153, 204, 255));
        jButton1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 51, 51));
        jButton1.setText("X");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BtnInicioSesion)
                                .addGap(55, 55, 55)
                                .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtPswd, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(TxtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(TxtPswd, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void BtnInicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInicioSesionActionPerformed
        // TODO add your handling code here:
        String usuario = this.TxtUser.getText();  // Obtiene el texto del campo de usuario
        String contrasena = new String(this.TxtPswd.getPassword());  // Obtiene el texto del campo de contraseña
        // Llama al método para iniciar sesión
        iniciarSesion(usuario, contrasena);
    }//GEN-LAST:event_BtnInicioSesionActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void TxtPswdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPswdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPswdActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
// Método para realizar la validación de inicio de sesión
    private void iniciarSesion(String usuario, String contrasena) {
        // Conexión a la base de datos
        Connection conexion = conexionBD.getConexion();

        // Consulta SQL para validar usuario y contraseña
        String consultaSQL = "SELECT * FROM TUsuarios WHERE usuario = ? AND clave = ?";

        try (PreparedStatement sentencia = conexion.prepareStatement(consultaSQL)) {
            // Asignar los parámetros de la consulta SQL
            sentencia.setString(1, usuario);
            sentencia.setString(2, contrasena);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                // Si hay un resultado, las credenciales son correctas
                JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso.");
                
                // Abrir el formulario FrmMenu y cerrar el formulario actual (LoginForm)
                
                    java.util.Map<String, String> props = new java.util.HashMap<>();
    props.put("Component.arc",     "14");
    props.put("Button.arc",        "20");
    props.put("TextComponent.arc", "18");
    com.formdev.flatlaf.FlatLaf.setGlobalExtraDefaults(props);

    /* ===== Look & Feel ===== */
    com.formdev.flatlaf.themes.FlatMacDarkLaf.setup();
                
                FrmMenu menu = new FrmMenu(); // Asumiendo que FrmMenu es el nombre de tu formulario principal
                menu.setVisible(true);  // Muestra el formulario principal
                this.dispose();  // Cierra el formulario de inicio de sesión

            } else {
                // Si no hay resultado, las credenciales son incorrectas
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
            }

        } catch (SQLException ex) {
            // Manejo de errores SQL
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error en la conexión a la base de datos.");
        } finally {
            // Cerrar la conexión después de usarla
            conexionBD.cerrarConexion();
        }
    }


    public static void main(String args[]) {
    java.util.Map<String, String> props = new java.util.HashMap<>();
    props.put("Component.arc",     "14");
    props.put("Button.arc",        "20");
    props.put("TextComponent.arc", "18");
    com.formdev.flatlaf.FlatLaf.setGlobalExtraDefaults(props);

    /* ===== Look & Feel ===== */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInicio1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnInicioSesion;
    private javax.swing.JPasswordField TxtPswd;
    private javax.swing.JTextField TxtUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables


}

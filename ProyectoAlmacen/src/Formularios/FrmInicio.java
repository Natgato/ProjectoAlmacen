package Formularios;

import Conexion.Conectar;
import Formularios.FrmMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class FrmInicio extends javax.swing.JFrame {
    private Conectar conexionBD; // Crear una instancia de la clase Conexion
    public FrmInicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        conexionBD = new Conectar(); // Inicializar la conexión
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TxtUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtPswd = new javax.swing.JPasswordField();
        BtnCancelar = new javax.swing.JButton();
        BtnInicioSesion = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario");

        jLabel2.setText("Clave");

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        BtnInicioSesion.setText("Iniciar Sesión");
        BtnInicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInicioSesionActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 0, 51));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("VIRGEN DEL ROSARIO");

        jLabel4.setBackground(new java.awt.Color(255, 0, 51));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setText("FERRETERIA ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtPswd, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(166, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(140, 140, 140)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtPswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(295, Short.MAX_VALUE)))
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
        // Crear y mostrar el formulario
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnInicioSesion;
    private javax.swing.JPasswordField TxtPswd;
    private javax.swing.JTextField TxtUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables


}

package Formularios;
import java.sql.SQLException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Conexion.Conectar;
import Formularios.FrmMClientes;
import Formularios.FrmMProductos;
import Formularios.FrmCotizaciones;
import Formularios.FrmDevolucionP;
import Formularios.FrmDevoluciones;
import Formularios.FrmEmpleados;
import Formularios.FrmMarcas;
import Formularios.SeleccionProductos;
import Formularios.FrmAddCliente;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FrmMenu extends javax.swing.JFrame {


    public FrmMenu() {
        initComponents();
    this.setLocationRelativeTo(null); // Centrar (opcional si ya maximizas)
    this.setExtendedState(JFrame.MAXIMIZED_BOTH); // ✅ Maximizar pantalla
    }

public void generarReporteTotal() {
        try {
            // Configuración del archivo PDF
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Guardar Reporte Total");
            chooser.setSelectedFile(new java.io.File("ReporteTotal.pdf"));
            int userSelection = chooser.showSaveDialog(null);

            if (userSelection != JFileChooser.APPROVE_OPTION) {
                return;
            }

            String rutaArchivo = chooser.getSelectedFile().getAbsolutePath();

            Document doc = new Document(PageSize.A4);
            PdfWriter.getInstance(doc, new FileOutputStream(rutaArchivo));
            doc.open();

            // Título del reporte
            doc.add(new Paragraph("Reporte Total", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
            doc.add(new Paragraph("Generado el: " + new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date())));
            doc.add(new Paragraph(" "));

            Connection conexion = new Conectar().getConexion();
            if (conexion == null) {
                JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Listas de tablas y sus columnas
            String[][] tablasColumnas = {
                {"TClientes", "Id", "apellidos", "nombres", "dni", "direccion"},
                {"TCotizaciones", "IdCotizacion", "fecha", "validezDias", "Idcliente", "NOMBRECLIENTE"},
                {"TEmpleados", "Id", "Apellidos", "Nombres", "Telefono", "NivelAcceso"},
                {"TProductos", "Id", "descripcion", "PrecioUnitario", "UnidadMedida", "Stock"},
                {"TProveedores", "Id", "RazonSocial", "RUC", "Direccion", "Telefono"},
                {"TUsuarios", "Id", "usuario", "clave"},
                {"TVentas", "IdCotizacion", "fecha", "Idcliente", "NOMBRECLIENTE"}
            };

            for (String[] tabla : tablasColumnas) {
                String nombreTabla = tabla[0];
                String[] columnas = new String[tabla.length - 1];
                System.arraycopy(tabla, 1, columnas, 0, tabla.length - 1);

                try (Statement stmt = conexion.createStatement();
                     ResultSet rs = stmt.executeQuery("SELECT * FROM " + nombreTabla)) {

                    // Crear tabla en el PDF
                    doc.add(new Paragraph(nombreTabla, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
                    PdfPTable pdfTable = new PdfPTable(columnas.length);
                    pdfTable.setWidthPercentage(100);

                    for (String columna : columnas) {
                        pdfTable.addCell(columna);
                    }

                    while (rs.next()) {
                        for (String columna : columnas) {
                            pdfTable.addCell(rs.getString(columna));
                        }
                    }

                    doc.add(pdfTable);
                    doc.add(new Paragraph(" "));

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al acceder a la tabla " + nombreTabla + ": " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }

            doc.close();
            conexion.close();

            JOptionPane.showMessageDialog(null, "Reporte generado correctamente:\n" + rutaArchivo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar el reporte: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/com/pexels-ahmetyuksek-32119340.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");

        jMenu2.setText("Sistema");

        jMenuItem1.setText("Gestión de usuarios ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar2.add(jMenu2);

        jMenu1.setText("Archivos Maestros");

        jMenuItem6.setText("Productos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem8.setText("Proveedores ");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem9.setText("Clientes");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuItem10.setText("Empleados");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuBar2.add(jMenu1);

        jMenu3.setText("Procesos");

        jMenuItem12.setText("Ventas");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuItem13.setText("Compras");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem13);

        jMenuItem17.setText("Cotizaciones ");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem17);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Reportes");

        jMenuItem2.setText("Reporte Completo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1878, 1878, 1878)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 944, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        /* ====== Ajustes globales (JDK 8) ====== */
    java.util.Map<String, String> props = new java.util.HashMap<>();
    props.put("Component.arc",     "14");
    props.put("Button.arc",        "20");
    props.put("TextComponent.arc", "18");
    com.formdev.flatlaf.FlatLaf.setGlobalExtraDefaults(props);

    /* ===== Look & Feel ===== */
    com.formdev.flatlaf.themes.FlatMacDarkLaf.setup();
        FrmMProductos productos = new FrmMProductos();
    productos.setLocationRelativeTo(null);
    productos.setVisible(true);        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        /* ====== Ajustes globales (JDK 8) ====== */
    java.util.Map<String, String> props = new java.util.HashMap<>();
    props.put("Component.arc",     "14");
    props.put("Button.arc",        "20");
    props.put("TextComponent.arc", "18");
    com.formdev.flatlaf.FlatLaf.setGlobalExtraDefaults(props);

    /* ===== Look & Feel ===== */
    com.formdev.flatlaf.themes.FlatMacDarkLaf.setup();
        FrmMClientes Clientes = new FrmMClientes();
    Clientes.setLocationRelativeTo(null);
    Clientes.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
    java.util.Map<String, String> props = new java.util.HashMap<>();
    props.put("Component.arc",     "14");
    props.put("Button.arc",        "20");
    props.put("TextComponent.arc", "18");
    com.formdev.flatlaf.FlatLaf.setGlobalExtraDefaults(props);

    /* ===== Look & Feel ===== */
    com.formdev.flatlaf.themes.FlatMacDarkLaf.setup();
        FrmProveedores Proveedores = new FrmProveedores();
        Proveedores.setLocationRelativeTo(null);
        Proveedores.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        /* ====== Ajustes globales (JDK 8) ====== */
    java.util.Map<String, String> props = new java.util.HashMap<>();
    props.put("Component.arc",     "14");
    props.put("Button.arc",        "20");
    props.put("TextComponent.arc", "18");
    com.formdev.flatlaf.FlatLaf.setGlobalExtraDefaults(props);

    /* ===== Look & Feel ===== */
    com.formdev.flatlaf.themes.FlatMacDarkLaf.setup();
        FrmEmpleados Empleados = new FrmEmpleados();
    Empleados.setLocationRelativeTo(null);
    Empleados.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
            /* ====== Ajustes globales (JDK 8) ====== */
    java.util.Map<String, String> props = new java.util.HashMap<>();
    props.put("Component.arc",     "14");
    props.put("Button.arc",        "20");
    props.put("TextComponent.arc", "18");
    com.formdev.flatlaf.FlatLaf.setGlobalExtraDefaults(props);

    /* ===== Look & Feel ===== */
    com.formdev.flatlaf.themes.FlatMacDarkLaf.setup();
        FrmCotizaciones Cotizaciones = new FrmCotizaciones();
        Cotizaciones.setLocationRelativeTo(null);
        Cotizaciones.setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
            /* ====== Ajustes globales (JDK 8) ====== */
    java.util.Map<String, String> props = new java.util.HashMap<>();
    props.put("Component.arc",     "14");
    props.put("Button.arc",        "20");
    props.put("TextComponent.arc", "18");
    com.formdev.flatlaf.FlatLaf.setGlobalExtraDefaults(props);

    /* ===== Look & Feel ===== */
    com.formdev.flatlaf.themes.FlatMacDarkLaf.setup();
        FrmMProductos Compras = new FrmMProductos();
        Compras.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
            /* ====== Ajustes globales (JDK 8) ====== */
    java.util.Map<String, String> props = new java.util.HashMap<>();
    props.put("Component.arc",     "14");
    props.put("Button.arc",        "20");
    props.put("TextComponent.arc", "18");
    com.formdev.flatlaf.FlatLaf.setGlobalExtraDefaults(props);

    /* ===== Look & Feel ===== */
    com.formdev.flatlaf.themes.FlatMacDarkLaf.setup();
        FrmAddCliente Ventas = new FrmAddCliente();
        Ventas.setLocationRelativeTo(null);
        Ventas.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    try {
        generarReporteTotal();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al generar el reporte: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> {
            new FrmMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}

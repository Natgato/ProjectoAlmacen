package Formularios;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import Conexion.Conectar;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmCotizaciones extends javax.swing.JFrame {

    public FrmCotizaciones() {
        initComponents();
        txtValidezDias.addKeyListener(new java.awt.event.KeyAdapter() {
    public void keyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
            getToolkit().beep();
        }
    }});
        txtNroCotizacion.setText(obtenerProximoNumeroCotizacion());
        lblTotal.setText("0.00");
        tablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] { },
    new String [] { "Codigo", "Descripcion", "Cantidad", "Precio Unitario", "Importe" }
) {
    // Solo la columna 2 ("Cantidad") es editable
    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 2|| column == 3|| column == 1;
    }
    
    
});

        
        txtFecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
tablaDetalle.getModel().addTableModelListener(e -> {
    int row = e.getFirstRow();
    int column = e.getColumn();
    DefaultTableModel modelo = (DefaultTableModel) tablaDetalle.getModel();
    if (column == 2 || column == 3|| column == 1) { // Si se editó cantidad o precio unitario
        try {
            int cantidad = Integer.parseInt(modelo.getValueAt(row, 2).toString());
            double precioUnitario = Double.parseDouble(modelo.getValueAt(row, 3).toString());
            double nuevoImporte = cantidad * precioUnitario;
            modelo.setValueAt(nuevoImporte, row, 4);
            actualizarTotal();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Valor inválido en cantidad o precio.", "Error", JOptionPane.ERROR_MESSAGE);
            // Opcional: restaurar valor anterior o dejar 1
        }
    }
});

    }

    
    
    
public void actualizarTotal() {
    DefaultTableModel modelo = (DefaultTableModel) tablaDetalle.getModel();
    double total = 0;
    for (int i = 0; i < modelo.getRowCount(); i++) {
        double importe = Double.parseDouble(modelo.getValueAt(i, 4).toString());
        total += importe;
    }
    lblTotal.setText(String.format("%.2f", total));
}

private String idClienteSeleccionado;
    
public void setCliente(String id, String nombre) {
    idClienteSeleccionado = id;
    txtCliente.setText(nombre); // txtCliente es tu campo donde muestras el nombre (no editable)
    txtIdCliente.setText(id);
}



public void agregarProductoDetalle(String codigo, String descripcion, double precioUnitario) {
    DefaultTableModel modelo = (DefaultTableModel) tablaDetalle.getModel();
    boolean productoExiste = false;
    for (int i = 0; i < modelo.getRowCount(); i++) {
        String codigoTabla = modelo.getValueAt(i, 0).toString();
        if (codigoTabla.equals(codigo)) {
            // Si el producto ya existe, suma cantidad +1 y actualiza el importe
            int cantidadActual = Integer.parseInt(modelo.getValueAt(i, 2).toString());
            cantidadActual += 1;
            modelo.setValueAt(cantidadActual, i, 2); // actualiza cantidad
            double nuevoImporte = cantidadActual * precioUnitario;
            modelo.setValueAt(nuevoImporte, i, 4); // actualiza importe
            productoExiste = true;
            break;
        }
    }
    if (!productoExiste) {
        int cantidad = 1;
        double importe = cantidad * precioUnitario;
        modelo.addRow(new Object[]{codigo, descripcion, cantidad, precioUnitario, importe});
    }
    actualizarTotal();
}


// Celda con estilo
private PdfPCell getCell(String text, Font font, BaseColor bg) {
    PdfPCell cell = new PdfPCell(new Phrase(text, font));
    cell.setBackgroundColor(bg);
    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell.setPadding(5f);
    return cell;
}

public void exportarCotizacionAPDF(String nroCotizacion) {
    try {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Guardar PDF de cotización");
        chooser.setSelectedFile(new java.io.File(nroCotizacion + ".pdf"));
        int userSelection = chooser.showSaveDialog(this);

        if (userSelection != JFileChooser.APPROVE_OPTION) return;

        String rutaArchivo = chooser.getSelectedFile().getAbsolutePath();

        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(rutaArchivo));
        doc.open();

        doc.add(new Paragraph("Ferretería Virgen del Rosario", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
        doc.add(new Paragraph("Cotización N°: " + nroCotizacion));
        doc.add(new Paragraph("Cliente: " + txtCliente.getText()));
        doc.add(new Paragraph("Fecha: " + txtFecha.getText()));
        doc.add(new Paragraph("Dias de Validez: " + txtValidezDias.getText()));
        doc.add(new Paragraph(" "));

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.addCell("Código");
        table.addCell("Descripción");
        table.addCell("Cantidad");
        table.addCell("Precio Unitario");
        table.addCell("Importe");

        DefaultTableModel modelo = (DefaultTableModel) tablaDetalle.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            for (int j = 0; j < modelo.getColumnCount(); j++) {
                table.addCell(modelo.getValueAt(i, j).toString());
            }
        }
        doc.add(table);

        doc.add(new Paragraph(" "));
        doc.add(new Paragraph("Total: S/ " + lblTotal.getText(), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
        doc.close();

        JOptionPane.showMessageDialog(this, "PDF generado correctamente:\n" + rutaArchivo);
} catch (Exception e) {
    {
        JOptionPane.showMessageDialog(this, "Error al exportar PDF: " + e.getMessage());
        e.printStackTrace();
    }
}
}

public String obtenerProximoNumeroCotizacion() {
    String numero = "";
    try {
        Connection conexion = new Conectar().getConexion();
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery("SELECT MAX(idCotizacion) FROM TCotizaciones");
        int proximo = 1; // Si no hay registros, el primero será 1
        if (rs.next()) {
            proximo = rs.getInt(1) + 1;
        }
        // Formatea con ceros a la izquierda si quieres (ej: 0001)
        numero = String.format("%04d", proximo);
        conexion.close();
    } catch (Exception e) {
        numero = "0001"; // Valor por defecto si hay error
    }
    return numero;
}


public String guardarCotizacion() {
    try {
        // Evita guardar si ya tiene número asignado
        if (!txtNroCotizacion.getText().equals("") && !txtNroCotizacion.getText().equals("Pendiente")) {
            return txtNroCotizacion.getText();
        }
        // Validaciones (puedes llamar aquí las mismas que en btnGuardarActionPerformed)
        String nombreCliente = txtCliente.getText();
        String fechaTexto = txtFecha.getText();
        String idClienteTexto = txtIdCliente.getText();
        String validezDiasTexto = txtValidezDias.getText();

        if (idClienteTexto == null || idClienteTexto.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        if (nombreCliente == null || nombreCliente.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre del cliente no puede estar vacío.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        if (fechaTexto == null || fechaTexto.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La fecha no puede estar vacía.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        if (validezDiasTexto == null || validezDiasTexto.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo 'Validez de Días' es obligatorio.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        int idCliente = Integer.parseInt(idClienteTexto);
        int validezDias = Integer.parseInt(validezDiasTexto);

        Connection conexion = new Conectar().getConexion();
        String sql = "INSERT INTO TCotizaciones (fecha, idCliente, nombreCliente, validezDias) VALUES (?, ?, ?, ?)";
        PreparedStatement pst = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        java.sql.Date fechaSQL = new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(fechaTexto).getTime());

        pst.setDate(1, fechaSQL);
        pst.setInt(2, idCliente);
        pst.setString(3, nombreCliente);
        pst.setInt(4, validezDias);

        int filas = pst.executeUpdate();

        if (filas > 0) {
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                int idCotizacion = rs.getInt(1);
                String numeroFormateado = String.format("%04d", idCotizacion);
                txtNroCotizacion.setText(numeroFormateado);
                conexion.close();
                return numeroFormateado;
            }
        }
        conexion.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
        e.printStackTrace();
    }
    return null;
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAgregarProducto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNroCotizacion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDetalle = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnQuitarProducto = new javax.swing.JButton();
        txtValidezDias = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAgregarProducto.setText("Añadir Producto");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Cotizaciones");

        jLabel3.setText("Cliente: ");

        txtCliente.setEditable(false);
        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha:");

        txtFecha.setEditable(false);
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        jLabel5.setText("No. de Cotizacion");

        tablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Cantidad", "Precio Unitario", "Importe"
            }
        ));
        jScrollPane1.setViewportView(tablaDetalle);

        jLabel6.setText("Total :");

        lblTotal.setText("0.00");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnClientes.setText("Buscar Cliente");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnQuitarProducto.setText("QuitarProducto");
        btnQuitarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarProductoActionPerformed(evt);
            }
        });

        txtValidezDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValidezDiasActionPerformed(evt);
            }
        });
        txtValidezDias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValidezDiasKeyTyped(evt);
            }
        });

        jLabel1.setText("Validez dias:");

        jLabel7.setText("Id Cliente:");

        txtIdCliente.setEditable(false);
        txtIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(103, 103, 103))
                                    .addComponent(lblTotal, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnQuitarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(txtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(txtFecha)
                            .addComponent(txtNroCotizacion))
                        .addGap(41, 41, 41)
                        .addComponent(btnClientes)
                        .addGap(108, 108, 108)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(txtValidezDias)
                            .addComponent(jLabel7)
                            .addComponent(txtIdCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClientes)
                    .addComponent(txtValidezDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNroCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregarProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitarProducto))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        // Lógica para abrir tu ventana de productos
    SeleccionProductos frmProd = new SeleccionProductos(this); // PASA LA REFERENCIA
    frmProd.setVisible(true);
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    try {
        // Validación de campos obligatorios
        String nombreCliente = txtCliente.getText();
        String fechaTexto = txtFecha.getText();
        String idClienteTexto = txtIdCliente.getText();
        String validezDiasTexto = txtValidezDias.getText();

        if (idClienteTexto == null || idClienteTexto.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (nombreCliente == null || nombreCliente.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre del cliente no puede estar vacío.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (fechaTexto == null || fechaTexto.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La fecha no puede estar vacía.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (validezDiasTexto == null || validezDiasTexto.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo 'Validez de Días' es obligatorio.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int idCliente;
        int validezDias;
        try {
            idCliente = Integer.parseInt(idClienteTexto);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El id del cliente no es válido.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            validezDias = Integer.parseInt(validezDiasTexto);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Solo se permiten números en 'Validez de Días'.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Conexión a la BD
        Connection conexion = new Conectar().getConexion();
        if (conexion == null) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Insertar cotización SOLO con los campos que tienes en la tabla nueva
        String sql = "INSERT INTO TCotizaciones (fecha, idCliente, nombreCliente, validezDias) VALUES (?, ?, ?, ?)";
        PreparedStatement pst = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // Formatear la fecha para SQL
        java.sql.Date fechaSQL;
        try {
            java.util.Date fecha = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(fechaTexto);
            fechaSQL = new java.sql.Date(fecha.getTime());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Formato de fecha inválido.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        pst.setDate(1, fechaSQL);
        pst.setInt(2, idCliente);
        pst.setString(3, nombreCliente);
        pst.setInt(4, validezDias);

        int filas = pst.executeUpdate();
        if (filas > 0) {
            // Obtener el id generado por Access (número de cotización)
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                int idCotizacion = rs.getInt(1);
                txtNroCotizacion.setText(String.valueOf(idCotizacion));
                JOptionPane.showMessageDialog(this, "Cotización guardada con N°: " + txtNroCotizacion.getText());
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo guardar la cotización.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        conexion.close();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed

    FrmAddCliente frm = new FrmAddCliente(this); // 'this' es referencia al padre
    frm.setVisible(true);


    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnQuitarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarProductoActionPerformed
    int filaSeleccionada = tablaDetalle.getSelectedRow();
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Selecciona un producto para quitar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }
    DefaultTableModel modelo = (DefaultTableModel) tablaDetalle.getModel();
    modelo.removeRow(filaSeleccionada);
    actualizarTotal(); // Llama a tu método que recalcula el total
    }//GEN-LAST:event_btnQuitarProductoActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
    if (txtNroCotizacion.getText().equals("") || txtNroCotizacion.getText().equals("Pendiente")) {
        // Guardar primero y actualizar campo
        String numeroGenerado = guardarCotizacion(); // Retorna el nuevo número o null si falla
        if (numeroGenerado == null) {
            JOptionPane.showMessageDialog(this, "No se pudo guardar la cotización, no se puede imprimir.");
            return;
        }
        txtNroCotizacion.setText(numeroGenerado);
    }
    // Luego generar el PDF normal
    exportarCotizacionAPDF(txtNroCotizacion.getText());
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void txtIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdClienteActionPerformed

    private void txtValidezDiasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValidezDiasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValidezDiasKeyTyped

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void txtValidezDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValidezDiasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValidezDiasActionPerformed


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
            java.util.logging.Logger.getLogger(FrmCotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCotizaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnQuitarProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tablaDetalle;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNroCotizacion;
    private javax.swing.JTextField txtValidezDias;
    // End of variables declaration//GEN-END:variables
}

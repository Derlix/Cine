package ChristianArias;

import ChristianArias.InformeDetalladoVentas;
import Principal.MenuAdministrador;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.HeadlessException;
import java.awt.Menu;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.BaseDatos_ChristianArias;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Analisis_Y_ReportesCajero extends javax.swing.JPanel {

    BaseDatos_ChristianArias db;

    public Analisis_Y_ReportesCajero(BaseDatos_ChristianArias db) {
        initComponents();
        eventosMouse();
        this.db = db;
        initComponents();
        setVisible(true);
        componentesAlternos();
    }

    private void componentesAlternos() {
        boton_Generarreporte.setBackground(Color.WHITE);
        Image icono_listar = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/reporte.png"));
        icono_listar = icono_listar.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        boton_Generarreporte.setIcon(new ImageIcon(icono_listar));
        boton_Generarreporte.setForeground(new Color(0, 0, 200));

        boton_Informeventas.setBackground(Color.WHITE);
        Image icono_informe = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/informeVentas.png"));
        icono_listar = icono_informe.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        boton_Informeventas.setIcon(new ImageIcon(icono_listar));
        boton_Informeventas.setForeground(new Color(0, 0, 200));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        boton_Generarreporte = new javax.swing.JToggleButton();
        boton_Informeventas = new javax.swing.JToggleButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        boton_Generarreporte.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boton_Generarreporte.setText("Generar Reporte");
        boton_Generarreporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_Generarreporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_GenerarreporteActionPerformed(evt);
            }
        });

        boton_Informeventas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boton_Informeventas.setText("Informe de ventas");
        boton_Informeventas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_Informeventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_InformeventasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(boton_Generarreporte, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boton_Informeventas, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_Generarreporte, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_Informeventas, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(345, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boton_GenerarreporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_GenerarreporteActionPerformed
        Document documento = new Document();

        try {
            String directorioActual = System.getProperty("user.dir");
            String rutaArchivoPDF = directorioActual + "\\ReporteVentasCajero.pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(rutaArchivoPDF));
            documento.open();

            Font fontCabecera = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLUE);
            Paragraph cabecera = new Paragraph("Reporte de Ventas", fontCabecera);
            cabecera.setAlignment(Paragraph.ALIGN_CENTER);
            documento.add(cabecera);

            PdfPTable tabla = new PdfPTable(3);
            tabla.setWidthPercentage(100);
            tabla.addCell("Fecha de Venta");
            tabla.addCell("Cantidad de Boletos");
            tabla.addCell("Total de Ventas");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bd_cine", "root", "");
            PreparedStatement statement = connection.prepareStatement("SELECT Fecha_Venta, SUM(Cantidad_Boletos), SUM(Total_Venta) FROM Ventas GROUP BY Fecha_Venta");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                tabla.addCell(resultSet.getString("Fecha_Venta"));
                tabla.addCell(resultSet.getString("SUM(Cantidad_Boletos)"));
                tabla.addCell(resultSet.getString("SUM(Total_Venta)"));
            }

            documento.add(tabla);
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte generado con éxito en: " + rutaArchivoPDF);
        } catch (DocumentException | SQLException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el reporte: " + e.getMessage());
        }

    }//GEN-LAST:event_boton_GenerarreporteActionPerformed


    private void boton_InformeventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_InformeventasActionPerformed
        InformeDetalladoVentas ventana = new InformeDetalladoVentas(db);
    }//GEN-LAST:event_boton_InformeventasActionPerformed

    //ESTILOS
    Color customColor = Color.decode("#7F265B");

    public void eventosMouse() {

        boton_Generarreporte.addMouseListener(new MouseAdapter() {
            @Override
            // Evento cambio de color cuando se pasa el mouse por el boton
            public void mouseEntered(MouseEvent e) {
                boton_Generarreporte.setBackground(customColor);
                boton_Generarreporte.setCursor(new Cursor(Cursor.HAND_CURSOR));
                boton_Generarreporte.setForeground(Color.WHITE);
            }

            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                boton_Generarreporte.setBackground(Color.WHITE);
                boton_Generarreporte.setForeground(Color.BLACK);
            }

            // Establecer el color personalizado cuando se hace clic en cualquier botón
            @Override
            public void mouseClicked(MouseEvent e) {
                boton_Generarreporte.setBackground(customColor);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton boton_Generarreporte;
    private javax.swing.JToggleButton boton_Informeventas;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

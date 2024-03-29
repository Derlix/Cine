
package ChristianArias;

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
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;




public class Analisis_Y_Reportes extends javax.swing.JPanel {

    BaseDatos_ChristianArias db;
    public Analisis_Y_Reportes(BaseDatos_ChristianArias db) {
        initComponents();
        initComponents();
        this.db = db;
        initComponents();
        setVisible(true);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        boton_Generarinforme = new javax.swing.JToggleButton();
        boton_Informeventas = new javax.swing.JToggleButton();

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        boton_Generarinforme.setText("Generar Informe");
        boton_Generarinforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_GenerarinformeActionPerformed(evt);
            }
        });

        boton_Informeventas.setText("Informe de ventas");
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
                .addGap(18, 18, 18)
                .addComponent(boton_Generarinforme)
                .addGap(105, 105, 105)
                .addComponent(boton_Informeventas)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_Generarinforme)
                    .addComponent(boton_Informeventas))
                .addContainerGap(246, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boton_GenerarinformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_GenerarinformeActionPerformed
         Document documento = new Document() {};
       
        try {
            
            PdfWriter.getInstance(documento, new FileOutputStream("C:\\Users\\chris\\OneDrive\\Escritorio\\Reporte_Cine.pdf"));
            documento.open();
            
            PdfPTable tabla = new PdfPTable(2);
            tabla.addCell("Numero Usuario");
            tabla.addCell("Nombre del usuario");
            
            
            try {
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_cine", "root", "");
                PreparedStatement pst = cn.prepareStatement("select ID_Usuario,Nombre_Usuario from usuarios");
                
                ResultSet rs = pst.executeQuery();
                
                if(rs.next()){
                                       
                    do {                        
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                    } while (rs.next());
                    documento.add(tabla);                    
                }
                
            } catch (DocumentException | SQLException e) {
                System.out.println(e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            System.out.println("manco");
            System.out.println(e);
        }
       
    }//GEN-LAST:event_boton_GenerarinformeActionPerformed

    private void boton_InformeventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_InformeventasActionPerformed
        
    }//GEN-LAST:event_boton_InformeventasActionPerformed
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton boton_Generarinforme;
    private javax.swing.JToggleButton boton_Informeventas;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

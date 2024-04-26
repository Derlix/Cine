package ChristianArias;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import utils.BaseDatos_ChristianArias;

public class PeliculasSala extends javax.swing.JPanel {

    private Timer timer;
    private int currentIndex = 0;
    BaseDatos_ChristianArias bd;

    public PeliculasSala(BaseDatos_ChristianArias bd) throws MalformedURLException {
        this.bd = bd;
        initComponents();
        llenarTabla();
        componentesAlternos();
    }

    public void componentesAlternos() {
        Mostrar.setFillsViewportHeight(true);
        Mostrar.setBackground(new Color(255, 255, 255)); // Blanco
        Mostrar.setForeground(new Color(51, 51, 51)); // Gris oscuro
        Mostrar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        Mostrar.getTableHeader().setBackground(new Color(34, 34, 34)); // Casi negro
        Mostrar.getTableHeader().setForeground(new Color(255, 255, 255)); // Blanco
        Mostrar.setGridColor(new Color(200, 200, 200)); // Gris claro
        Mostrar.setShowGrid(true);
        Mostrar.setRowHeight(50);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Mostrar = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Mostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Mostrar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 140, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void llenarTabla() {
        ArrayList<HashMap<String, String>> peliculasInfo = bd.ObtenerPeliculasConDetalles(); // Asumimos que este método ya está adaptado para la nueva consulta
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Título", "Sala", "Fecha", "Hora Inicio", "Hora Fin"}, 0);
        for (HashMap<String, String> info : peliculasInfo) {
            modelo.addRow(new Object[]{
                info.get("Titulo"),
                info.get("Nombre_Sala"),
                info.get("Fecha"),
                info.get("Hora_Inicio"),
                info.get("Hora_Final")
            });
        }
        Mostrar.setModel(modelo);
        Mostrar.setRowHeight(50);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Mostrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

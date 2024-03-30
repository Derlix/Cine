package JuanCamilo;

import utils.BaseDatosJuanPrincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import utils.Pelicula;

public class GestionPeliculas extends javax.swing.JPanel {
    BaseDatosJuanPrincipal basedatos; 
    
    public GestionPeliculas(BaseDatosJuanPrincipal basedatos) {
        this.basedatos = basedatos;
        initComponents();
        mostrarPeliculas();
    }

    public void mostrarPeliculas() {
        List<Pelicula> peliculas = basedatos.obtenerTodasLasPeliculas();

        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Título");
        modeloTabla.addColumn("Categoría");
        modeloTabla.addColumn("Restricción Edad");
        modeloTabla.addColumn("Duración");
        modeloTabla.addColumn("País Origen");
        modeloTabla.addColumn("Estado");

        for (Pelicula pelicula : peliculas) {
            Object[] fila = {
                pelicula.getIdPelicula(),
                pelicula.getTitulo(),
                pelicula.getCategoria(),
                pelicula.getRestriccionEdad(),
                pelicula.getDuracion(),
                pelicula.getPaisOrigen(),
                pelicula.getEstado(),
            };
            modeloTabla.addRow(fila);
        }

        tablaDePeliculas.setModel(modeloTabla);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CrearPelicula = new javax.swing.JToggleButton();
        EditarPelicula = new javax.swing.JToggleButton();
        EliminarPelicula = new javax.swing.JToggleButton();
        PanelPeliculas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDePeliculas = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 255, 255));

        CrearPelicula.setText("Crear Pelicula");
        CrearPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearPeliculaActionPerformed(evt);
            }
        });

        EditarPelicula.setText("Editar Pelicula");
        EditarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarPeliculaActionPerformed(evt);
            }
        });

        EliminarPelicula.setText("Elimnar Pelicula");
        EliminarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarPeliculaActionPerformed(evt);
            }
        });

        tablaDePeliculas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaDePeliculas);

        javax.swing.GroupLayout PanelPeliculasLayout = new javax.swing.GroupLayout(PanelPeliculas);
        PanelPeliculas.setLayout(PanelPeliculasLayout);
        PanelPeliculasLayout.setHorizontalGroup(
            PanelPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPeliculasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        PanelPeliculasLayout.setVerticalGroup(
            PanelPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPeliculasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelPeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(CrearPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(EditarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(EliminarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 76, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EliminarPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EditarPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CrearPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CrearPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearPeliculaActionPerformed
       CrearPelicula ventana = new CrearPelicula(basedatos);
    }//GEN-LAST:event_CrearPeliculaActionPerformed

    private void EditarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarPeliculaActionPerformed
        EditarPelicula ventana2 = new EditarPelicula(basedatos);
    }//GEN-LAST:event_EditarPeliculaActionPerformed

    private void EliminarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarPeliculaActionPerformed
        EliminarPelicula ventana3 = new EliminarPelicula(basedatos);
    }//GEN-LAST:event_EliminarPeliculaActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton CrearPelicula;
    private javax.swing.JToggleButton EditarPelicula;
    private javax.swing.JToggleButton EliminarPelicula;
    private javax.swing.JPanel PanelPeliculas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDePeliculas;
    // End of variables declaration//GEN-END:variables
}

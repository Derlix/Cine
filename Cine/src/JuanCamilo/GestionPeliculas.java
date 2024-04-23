package JuanCamilo;

import utils.BaseDatosJuanPrincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    Color customColor = Color.decode("#7F265B");
    public GestionPeliculas(BaseDatosJuanPrincipal basedatos) {
        this.basedatos = basedatos;
        initComponents();
        mostrarPeliculas();
        eventoMouse();
        componentesAlternos();
    }

    public void componentesAlternos(){
        btnCrearPelicula.setBackground(Color.WHITE);
        btnEditarPelicula.setBackground(Color.WHITE);
        btnEliminarPelicula.setBackground(Color.WHITE);
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

        btnCrearPelicula = new javax.swing.JToggleButton();
        btnEditarPelicula = new javax.swing.JToggleButton();
        btnEliminarPelicula = new javax.swing.JToggleButton();
        PanelPeliculas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDePeliculas = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        btnCrearPelicula.setText("Crear Pelicula");
        btnCrearPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPeliculaActionPerformed(evt);
            }
        });

        btnEditarPelicula.setText("Editar Pelicula");
        btnEditarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPeliculaActionPerformed(evt);
            }
        });

        btnEliminarPelicula.setText("Elimnar Pelicula");
        btnEliminarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPeliculaActionPerformed(evt);
            }
        });

        PanelPeliculas.setBackground(new java.awt.Color(255, 255, 255));

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
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
                        .addComponent(btnCrearPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 76, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminarPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditarPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCrearPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPeliculaActionPerformed
       CrearPelicula ventana = new CrearPelicula(basedatos);
    }//GEN-LAST:event_btnCrearPeliculaActionPerformed

    private void btnEditarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPeliculaActionPerformed
        EditarPelicula ventana2 = new EditarPelicula(basedatos);
    }//GEN-LAST:event_btnEditarPeliculaActionPerformed

    private void btnEliminarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPeliculaActionPerformed
        EliminarPelicula ventana3 = new EliminarPelicula(basedatos);
    }//GEN-LAST:event_btnEliminarPeliculaActionPerformed

    
    public void eventoMouse(){
        
        btnCrearPelicula.addMouseListener(new MouseAdapter() {
            @Override
            // Evento cambio de color cuando se pasa el mouse por el boton
            public void mouseEntered(MouseEvent e) {
                btnCrearPelicula.setBackground(customColor);
                btnCrearPelicula.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnCrearPelicula.setForeground(Color.WHITE);
            }
            
             
            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                btnCrearPelicula.setBackground(Color.WHITE);            
                btnCrearPelicula.setForeground(Color.BLACK);
            }
            // Establecer el color personalizado cuando se hace clic en cualquier botón
            @Override
            public void mouseClicked(MouseEvent e) {
                btnCrearPelicula.setBackground(customColor);
            }
        });
        btnEditarPelicula.addMouseListener(new MouseAdapter() {
            @Override
            // Evento cambio de color cuando se pasa el mouse por el boton
            public void mouseEntered(MouseEvent e) {
                btnEditarPelicula.setBackground(customColor);
                btnEditarPelicula.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnEditarPelicula.setForeground(Color.WHITE);
            }
            
             
            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                btnEditarPelicula.setBackground(Color.WHITE);            
                btnEditarPelicula.setForeground(Color.BLACK);
            }
            // Establecer el color personalizado cuando se hace clic en cualquier botón
            @Override
            public void mouseClicked(MouseEvent e) {
                btnEditarPelicula.setBackground(customColor);
            }
        });
        btnEliminarPelicula.addMouseListener(new MouseAdapter() {
            @Override
            // Evento cambio de color cuando se pasa el mouse por el boton
            public void mouseEntered(MouseEvent e) {
                btnEliminarPelicula.setBackground(customColor);
                btnEliminarPelicula.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnEliminarPelicula.setForeground(Color.WHITE);
            }
            
             
            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                btnEliminarPelicula.setBackground(Color.WHITE);            
                btnEliminarPelicula.setForeground(Color.BLACK);
            }
            // Establecer el color personalizado cuando se hace clic en cualquier botón
            @Override
            public void mouseClicked(MouseEvent e) {
                btnEliminarPelicula.setBackground(customColor);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPeliculas;
    private javax.swing.JToggleButton btnCrearPelicula;
    private javax.swing.JToggleButton btnEditarPelicula;
    private javax.swing.JToggleButton btnEliminarPelicula;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDePeliculas;
    // End of variables declaration//GEN-END:variables
}

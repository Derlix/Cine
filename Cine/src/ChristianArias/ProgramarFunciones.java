package ChristianArias;

import JuanCamilo.CrearFuncion;
import JuanCamilo.EditarFuncion;
import JuanCamilo.EliminarFuncion;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import utils.BaseDatosJuanPrincipal;
import utils.Funcion;

public class ProgramarFunciones extends javax.swing.JPanel {

    BaseDatosJuanPrincipal bd;
    public ProgramarFunciones(BaseDatosJuanPrincipal bd) {
        this.bd = bd;
        initComponents();
        componenetesAlternos();
        eventosMouse();
        cargarFunciones();
    }
    
    public void componenetesAlternos(){
        btnCrearFuncion.setBackground(Color.WHITE);
        Image iconoCrearF = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/crearFuncion.png"));
        iconoCrearF = iconoCrearF.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        btnCrearFuncion.setIcon(new ImageIcon(iconoCrearF));
        btnCrearFuncion.setForeground(new Color(0, 0, 200));
        btnCrearFuncion.setBackground(Color.WHITE);
        
        btnEditarFuncion.setBackground(Color.WHITE);
        Image icono = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/editarFuncion.png"));
        icono = icono.getScaledInstance(45,45,Image.SCALE_SMOOTH);
        btnEditarFuncion.setIcon(new ImageIcon(icono));
        btnEditarFuncion.setIcon(new ImageIcon(icono));
        btnEditarFuncion.setForeground(new Color(0, 0, 200));
        
        btnEliminarFuncion.setBackground(Color.WHITE);
        Image iconos = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/crearFuncion.png"));
        iconos = iconos.getScaledInstance(45,45,Image.SCALE_SMOOTH);
        btnEliminarFuncion.setIcon(new ImageIcon(iconos));
        btnEliminarFuncion.setIcon(new ImageIcon(iconos));
        btnEliminarFuncion.setForeground(new Color(0, 0, 200));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCrearFuncion = new javax.swing.JButton();
        btnEditarFuncion = new javax.swing.JButton();
        btnEliminarFuncion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFuncuones = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnCrearFuncion.setText("Crear Funcion");
        btnCrearFuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearFuncionActionPerformed(evt);
            }
        });

        btnEditarFuncion.setText("Editar Funcion");
        btnEditarFuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarFuncionActionPerformed(evt);
            }
        });

        btnEliminarFuncion.setText("Eliminar Funcion");
        btnEliminarFuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarFuncionActionPerformed(evt);
            }
        });

        tablaFuncuones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaFuncuones);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnCrearFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearFuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearFuncionActionPerformed
        CrearFuncion ventana = new CrearFuncion(bd);
    }//GEN-LAST:event_btnCrearFuncionActionPerformed

    private void btnEditarFuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarFuncionActionPerformed
        EditarFuncion bentana = new EditarFuncion(bd);
    }//GEN-LAST:event_btnEditarFuncionActionPerformed

    private void btnEliminarFuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarFuncionActionPerformed
        EliminarFuncion ventana = new EliminarFuncion(bd);
    }//GEN-LAST:event_btnEliminarFuncionActionPerformed


    Color customColor = Color.decode("#7F265B");
    public void eventosMouse(){
        
        
        btnCrearFuncion.addMouseListener(new MouseAdapter() {
            @Override
            // Evento cambio de color cuando se pasa el mouse por el boton
            public void mouseEntered(MouseEvent e) {
                btnCrearFuncion.setBackground(customColor);
                btnCrearFuncion.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnCrearFuncion.setForeground(Color.WHITE);
            }
            
             
            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                btnCrearFuncion.setBackground(Color.WHITE);            
                btnCrearFuncion.setForeground(Color.BLACK);
            }
            // Establecer el color personalizado cuando se hace clic en cualquier botón
            @Override
            public void mouseClicked(MouseEvent e) {
                btnCrearFuncion.setBackground(customColor);
            }
        });
        btnEditarFuncion.addMouseListener(new MouseAdapter() {
            @Override
            // Evento cambio de color cuando se pasa el mouse por el boton
            public void mouseEntered(MouseEvent e) {
                btnEditarFuncion.setBackground(customColor);
                btnEditarFuncion.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnEditarFuncion.setForeground(Color.WHITE);
            }
            
             
            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                btnEditarFuncion.setBackground(Color.WHITE);            
                btnEditarFuncion.setForeground(Color.BLACK);
            }
            // Establecer el color personalizado cuando se hace clic en cualquier botón
            @Override
            public void mouseClicked(MouseEvent e) {
                btnEditarFuncion.setBackground(customColor);
            }
        });
        btnEliminarFuncion.addMouseListener(new MouseAdapter() {
            @Override
            // Evento cambio de color cuando se pasa el mouse por el boton
            public void mouseEntered(MouseEvent e) {
                btnEliminarFuncion.setBackground(customColor);
                btnEliminarFuncion.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnEliminarFuncion.setForeground(Color.WHITE);
            }
            
             
            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                btnEliminarFuncion.setBackground(Color.BLACK);            
                btnCrearFuncion.setForeground(Color.WHITE);
            }
            // Establecer el color personalizado cuando se hace clic en cualquier botón
            @Override
            public void mouseClicked(MouseEvent e) {
                btnEliminarFuncion.setBackground(customColor);
            }
        });
    }
    
    
    
    public void cargarFunciones() {
        try {
            List<Funcion> funciones = bd.obtenerTodasFunciones();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Funcion");
            model.addColumn("ID Pelicula");
            model.addColumn("ID Sala");
            model.addColumn("Fecha");
            model.addColumn("Hora Inicio");
            model.addColumn("Hora Final");
            model.addColumn("Precio");

            for (Funcion funcion : funciones) {
                model.addRow(new Object[]{
                    funcion.getId_funcion(),
                    funcion.getId_pelicula(),
                    funcion.getId_sala(),
                    funcion.getFecha(),
                    funcion.getHora_inicio(),
                    funcion.getHora_final(),
                    funcion.getPrecio()
                });
            }

            tablaFuncuones.setModel(model);
        } catch (Exception ex) {
            System.out.println("Error al cargar las funciones:");
            System.out.println(ex.getMessage());
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearFuncion;
    private javax.swing.JButton btnEditarFuncion;
    private javax.swing.JButton btnEliminarFuncion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaFuncuones;
    // End of variables declaration//GEN-END:variables
}

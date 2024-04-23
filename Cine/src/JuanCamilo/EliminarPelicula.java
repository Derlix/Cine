
package JuanCamilo;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import utils.BaseDatosJuanPrincipal;
import utils.Pelicula;


public class EliminarPelicula extends javax.swing.JFrame {

    BaseDatosJuanPrincipal basedatos;

    public EliminarPelicula(BaseDatosJuanPrincipal basedatos) {
        initComponents();
        this.basedatos = basedatos;
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("imagenes/iconoPrincipal.png")));
        setTitle("Eliminar Pelicula");
        getContentPane().setBackground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JLabel();
        campo_id_pelicula = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        campoTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        etq_etiqueta = new javax.swing.JLabel();
        campoEtiquetas = new javax.swing.JTextField();
        etq_origen = new javax.swing.JLabel();
        campoOrigen = new javax.swing.JTextField();
        etq_categoria = new javax.swing.JLabel();
        campoCategoria = new javax.swing.JTextField();
        etq_fecha_inicio = new javax.swing.JLabel();
        campoFechaInicio = new javax.swing.JTextField();
        etq_fecha_fin = new javax.swing.JLabel();
        campoFechaFin = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        fondo.setText("Ingresa identificador de la pelicula:");

        btn_buscar.setBackground(new java.awt.Color(0, 0, 255));
        btn_buscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscar.setText("BUSCAR");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ELIMINAR PELICULA");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("TITULO:");

        etq_etiqueta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_etiqueta.setText("ETIQUETAS: ");

        etq_origen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_origen.setText("PAIS DE ORIGEN:");

        etq_categoria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_categoria.setText("CATEGORIA:");

        etq_fecha_inicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_fecha_inicio.setText("F. INICIO: ");

        etq_fecha_fin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_fecha_fin.setText("F. FIN: ");

        btn_cancelar.setBackground(new java.awt.Color(0, 255, 0));
        btn_cancelar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_eliminar.setBackground(new java.awt.Color(255, 0, 0));
        btn_eliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar.setText("ELIMINAR");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fondo)
                                .addGap(18, 18, 18)
                                .addComponent(campo_id_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btn_buscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(etq_categoria)
                                    .addComponent(campoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etq_fecha_inicio)
                                    .addComponent(campoFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etq_etiqueta)
                                    .addComponent(campoEtiquetas, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etq_fecha_fin)
                                    .addComponent(campoFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etq_origen)
                                    .addComponent(campoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(btn_cancelar)
                                .addGap(46, 46, 46)
                                .addComponent(btn_eliminar)))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campo_id_pelicula)
                        .addComponent(btn_buscar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addComponent(campoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etq_etiqueta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoEtiquetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etq_categoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etq_origen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etq_fecha_inicio)
                            .addComponent(etq_fecha_fin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campoFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        try {
            String idPelicula = campo_id_pelicula.getText();
            if (!idPelicula.isEmpty()) {
                Pelicula pelicula = basedatos.buscarPeliculaPorId(idPelicula);
                if (pelicula != null) {
                    mostrarDatosPelicula(pelicula);
                } else {
                    System.out.println("No se encontró ninguna película con el ID: " + idPelicula);
                }
            } else {
                System.out.println("Error: Debes ingresar el ID de la película.");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Error: Ingresa un ID de película válido.");
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        campoTitulo.setText("");
        campoCategoria.setText("");
        campoEtiquetas.setText("");
        campoOrigen.setText("");
        campo_id_pelicula.setText("");
        campoFechaInicio.setText("");
        campoFechaFin.setText("");
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        try {
            String idPelicula = campo_id_pelicula.getText();
            if (!idPelicula.isEmpty()) {
                int id = Integer.parseInt(idPelicula);
                basedatos.eliminarPelicula(id);
                limpiarCampos();
                System.out.println("Pelicula eliminada correctamente.");
            } else {
                System.out.println("Error: Debes ingresar el ID de la película.");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Error: Ingresa un ID de película válido.");
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed
    
    private void limpiarCampos() {
        campoTitulo.setText("");
        campoCategoria.setText("");
        campoEtiquetas.setText("");
        campoOrigen.setText("");
        campo_id_pelicula.setText("");
        campoFechaInicio.setText("");
        campoFechaFin.setText("");
    }
    
    private void initAlterComponens() {
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
    }
    
    private void mostrarDatosPelicula(Pelicula pelicula) {
        campoTitulo.setText(pelicula.getTitulo());
        campoCategoria.setText(pelicula.getCategoria());
        campoEtiquetas.setText(pelicula.getEtiquetas());
        campoOrigen.setText(pelicula.getPaisOrigen());
        campoFechaInicio.setText(pelicula.getFechaInicio());
        campoFechaFin.setText(pelicula.getFechaFin());
    }
    
     Color customColor = Color.decode("#7F265B");
    public void eventosMouse(){
        
        
        btn_buscar.addMouseListener(new MouseAdapter() {
            @Override
            // Evento cambio de color cuando se pasa el mouse por el boton
            public void mouseEntered(MouseEvent e) {
                btn_buscar.setBackground(customColor);
                btn_buscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btn_buscar.setForeground(Color.WHITE);
            }
            
             
            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                btn_buscar.setBackground(Color.WHITE);            
                btn_buscar.setForeground(Color.BLACK);
            }
            // Establecer el color personalizado cuando se hace clic en cualquier botón
            @Override
            public void mouseClicked(MouseEvent e) {
                btn_buscar.setBackground(customColor);
            }
        });
        
        btn_cancelar.addMouseListener(new MouseAdapter() {
            @Override
            // Evento cambio de color cuando se pasa el mouse por el boton
            public void mouseEntered(MouseEvent e) {
                btn_cancelar.setBackground(customColor);
                btn_cancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btn_cancelar.setForeground(Color.WHITE);
            }
            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                btn_cancelar.setBackground(Color.WHITE);
                btn_cancelar.setForeground(Color.BLACK);
            }
            // Establecer el color personalizado cuando se hace clic en cualquier botón
            @Override
            public void mouseClicked(MouseEvent e) {
                btn_cancelar.setBackground(customColor);
                
            }
        });
        
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JTextField campoCategoria;
    private javax.swing.JTextField campoEtiquetas;
    private javax.swing.JTextField campoFechaFin;
    private javax.swing.JTextField campoFechaInicio;
    private javax.swing.JTextField campoOrigen;
    private javax.swing.JTextField campoTitulo;
    private javax.swing.JTextField campo_id_pelicula;
    private javax.swing.JLabel etq_categoria;
    private javax.swing.JLabel etq_etiqueta;
    private javax.swing.JLabel etq_fecha_fin;
    private javax.swing.JLabel etq_fecha_inicio;
    private javax.swing.JLabel etq_origen;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    
}

package Principal;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import utils.BaseDatos;

public class CrearPelicula extends javax.swing.JFrame {
    BaseDatos basedatos;
    JFileChooser archivoSeleccionado; 

    public CrearPelicula(BaseDatos basedatos) {
        this.basedatos = basedatos;
        initComponents();
        archivoSeleccionado = new JFileChooser();
        setVisible(true);
        btn_crear_peliculaActionPerformed(null); // Llamada al método al inicio
    }

    private boolean imagenSeleccionada = false; // Add this variable to track if an image has been selected

    private void abrirExploradorArchivos() {
        // Si ya se ha seleccionado una imagen previamente, no abrir la ventana de selección nuevamente
        if (imagenSeleccionada) {
            return;
        }

        // Si no se ha seleccionado una imagen previamente, abrir la ventana de selección
        int ventana = archivoSeleccionado.showOpenDialog(null);
        campo_imagen.setEnabled(false);

        if (ventana == JFileChooser.APPROVE_OPTION) {
            File archivo = archivoSeleccionado.getSelectedFile();
            campo_imagen.setText(archivo.getPath());
            Image foto = getToolkit().getImage(campo_imagen.getText());
            foto = foto.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            ImageIcon icono = new ImageIcon(foto);
            previsualizacion.setIcon(icono);

            // Marcar que se ha seleccionado una imagen
            imagenSeleccionada = true;
        }
    }


    private String guardarImagen(String rutaImagen) {
        String rutaDestino = "";
        try {
            JFileChooser guardarArchivo = new JFileChooser();
            int ventana = guardarArchivo.showSaveDialog(null);
            if (ventana == JFileChooser.APPROVE_OPTION) {
                File archivo = guardarArchivo.getSelectedFile();
                String nombreImagen = archivo.getName();
                rutaDestino = "src/imagenes/" + nombreImagen;
                Files.copy(new File(rutaImagen).toPath(), Paths.get(rutaDestino), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return rutaDestino;
    }



    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoTitulo = new javax.swing.JTextField();
        etq_categoria = new javax.swing.JLabel();
        panel_pelicula = new javax.swing.JPanel();
        etq_imagen = new javax.swing.JLabel();
        btn_seleccionar = new javax.swing.JButton();
        previsualizacion = new javax.swing.JLabel();
        campo_imagen = new javax.swing.JTextField();
        etq_etiqueta = new javax.swing.JLabel();
        etq_restricccion = new javax.swing.JLabel();
        etq_duracion = new javax.swing.JLabel();
        etq_origen = new javax.swing.JLabel();
        campoDuracion = new javax.swing.JTextField();
        campoEtiquetas = new javax.swing.JTextField();
        campoResteicciones = new javax.swing.JTextField();
        campoOrigen = new javax.swing.JTextField();
        campoCategoria = new javax.swing.JTextField();
        btn_crear_pelicula = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CREAR PELICULA");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("TITULO:");

        etq_categoria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_categoria.setText("CATEGORIA:");

        panel_pelicula.setBackground(new java.awt.Color(204, 204, 204));

        etq_imagen.setBackground(new java.awt.Color(255, 255, 255));
        etq_imagen.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        etq_imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_imagen.setText("IMAGEN: ");

        btn_seleccionar.setBackground(new java.awt.Color(0, 0, 255));
        btn_seleccionar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_seleccionar.setForeground(new java.awt.Color(255, 255, 255));
        btn_seleccionar.setText("SELECCIONAR");
        btn_seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seleccionarActionPerformed(evt);
            }
        });

        previsualizacion.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_peliculaLayout = new javax.swing.GroupLayout(panel_pelicula);
        panel_pelicula.setLayout(panel_peliculaLayout);
        panel_peliculaLayout.setHorizontalGroup(
            panel_peliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_peliculaLayout.createSequentialGroup()
                .addGroup(panel_peliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_peliculaLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(etq_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_peliculaLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panel_peliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campo_imagen, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(previsualizacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_peliculaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_seleccionar)
                .addGap(49, 49, 49))
        );
        panel_peliculaLayout.setVerticalGroup(
            panel_peliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_peliculaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etq_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_seleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(previsualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(campo_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        etq_etiqueta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_etiqueta.setText("ETIQUETAS: ");

        etq_restricccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_restricccion.setText("RESTRICCCION DE EDAD: ");

        etq_duracion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_duracion.setText("DURACION:");

        etq_origen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_origen.setText("PAIS DE ORIGEN:");

        btn_crear_pelicula.setBackground(new java.awt.Color(0, 255, 0));
        btn_crear_pelicula.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_crear_pelicula.setForeground(new java.awt.Color(255, 255, 255));
        btn_crear_pelicula.setText("CREAR");
        btn_crear_pelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crear_peliculaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(etq_restricccion)
                                    .addComponent(etq_etiqueta)
                                    .addComponent(jLabel2)
                                    .addComponent(etq_duracion)
                                    .addComponent(etq_origen)
                                    .addComponent(etq_categoria))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoEtiquetas, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoResteicciones, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_crear_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)))
                .addComponent(panel_pelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(panel_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(campoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etq_etiqueta)
                            .addComponent(campoEtiquetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etq_restricccion)
                            .addComponent(campoResteicciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etq_duracion)
                            .addComponent(campoDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etq_origen)
                            .addComponent(campoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etq_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btn_crear_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seleccionarActionPerformed
        abrirExploradorArchivos();
    }//GEN-LAST:event_btn_seleccionarActionPerformed

    private void btn_crear_peliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crear_peliculaActionPerformed

        try {
            String titulo = campoTitulo.getText();
            String categoria = campoCategoria.getText();
            String etiquetas = campoEtiquetas.getText();
            int restriccionEdad = Integer.parseInt(campoResteicciones.getText());
            int duracion = Integer.parseInt(campoDuracion.getText());
            String paisOrigen = campoOrigen.getText();
            String rutaImagen = campo_imagen.getText();

            if (!rutaImagen.isEmpty()) {
                rutaImagen = guardarImagen(rutaImagen);
                if (!rutaImagen.isEmpty()) {
                    basedatos.crearPeliculaConImagen(titulo, categoria, etiquetas, restriccionEdad, duracion, paisOrigen, rutaImagen);
                    System.out.println("PELÍCULA CREADA CON ÉXITO :V");

                    // Limpiar campos
                    campoTitulo.setText("");
                    campoCategoria.setText("");
                    campoEtiquetas.setText("");
                    campoResteicciones.setText("");
                    campoDuracion.setText("");
                    campoOrigen.setText("");
                    campo_imagen.setText("");
                }
            } else {
                // Si no se ha seleccionado una imagen, mostrar un mensaje de error
                System.out.println("Error: Debes seleccionar una imagen.");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Error: Ingresa un valor numérico válido en los campos de restricción de edad y duración.");
        }
    
    }//GEN-LAST:event_btn_crear_peliculaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_crear_pelicula;
    private javax.swing.JButton btn_seleccionar;
    private javax.swing.JTextField campoCategoria;
    private javax.swing.JTextField campoDuracion;
    private javax.swing.JTextField campoEtiquetas;
    private javax.swing.JTextField campoOrigen;
    private javax.swing.JTextField campoResteicciones;
    private javax.swing.JTextField campoTitulo;
    private javax.swing.JTextField campo_imagen;
    private javax.swing.JLabel etq_categoria;
    private javax.swing.JLabel etq_duracion;
    private javax.swing.JLabel etq_etiqueta;
    private javax.swing.JLabel etq_imagen;
    private javax.swing.JLabel etq_origen;
    private javax.swing.JLabel etq_restricccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel_pelicula;
    private javax.swing.JLabel previsualizacion;
    // End of variables declaration//GEN-END:variables

}

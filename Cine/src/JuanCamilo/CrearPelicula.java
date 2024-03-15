package JuanCamilo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import utils.BaseDatosJuanPrincipal;

public class CrearPelicula extends javax.swing.JFrame {
    BaseDatosJuanPrincipal basedatos;
    JFileChooser archivoSeleccionado;
    private boolean imagenSeleccionada = false;

    public CrearPelicula(BaseDatosJuanPrincipal basedatos) {
        this.basedatos = basedatos;
        initComponents();
        setLocationRelativeTo(null);
        archivoSeleccionado = new JFileChooser();
        setVisible(true);
    }

    private void abrirExploradorArchivos() {
        if (imagenSeleccionada) {
            return;
        }

        int ventana = archivoSeleccionado.showOpenDialog(null);
        campo_imagen.setEnabled(false);

        if (ventana == JFileChooser.APPROVE_OPTION) {
            File archivo = archivoSeleccionado.getSelectedFile();
            campo_imagen.setText(archivo.getPath());
            imagenSeleccionada = true;

            // Cargar y mostrar la imagen en la previsualización
            try {
                BufferedImage img = ImageIO.read(archivo);
                Image dimg = img.getScaledInstance(previsualizacion.getWidth(), previsualizacion.getHeight(), Image.SCALE_SMOOTH);
                previsualizacion.setIcon(new ImageIcon(dimg));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
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
        etq_fecha_inicio = new javax.swing.JLabel();
        campoFechaInicio = new javax.swing.JTextField();
        campoFechaFin = new javax.swing.JTextField();
        etq_fecha_fin = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_peliculaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_seleccionar)
                .addGap(49, 49, 49))
            .addGroup(panel_peliculaLayout.createSequentialGroup()
                .addGroup(panel_peliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_peliculaLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(panel_peliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(previsualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campo_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel_peliculaLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(etq_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
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
        etq_restricccion.setText("REST. EDAD: ");

        etq_duracion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_duracion.setText("DURACION:");

        etq_origen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_origen.setText("P DE ORIGEN:");

        campoDuracion.setText("12");

        campoResteicciones.setText("12");

        btn_crear_pelicula.setBackground(new java.awt.Color(0, 255, 0));
        btn_crear_pelicula.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_crear_pelicula.setForeground(new java.awt.Color(255, 255, 255));
        btn_crear_pelicula.setText("CREAR");
        btn_crear_pelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crear_peliculaActionPerformed(evt);
            }
        });

        etq_fecha_inicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_fecha_inicio.setText("F. INICIO: ");

        campoFechaInicio.setText("25/2/2024");

        campoFechaFin.setText("25/10/2024");

        etq_fecha_fin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_fecha_fin.setText("F. FIN: ");

        btn_cancelar.setBackground(new java.awt.Color(255, 0, 0));
        btn_cancelar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        jLabel3.setText("FORMATO DE FECHAS: (DD/MM/YYYY)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(btn_crear_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(etq_etiqueta)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(campoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoEtiquetas, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(etq_origen)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(campoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(etq_duracion)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(campoDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(etq_fecha_inicio)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(campoFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(etq_categoria)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(campoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(24, 24, 24)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(etq_fecha_fin)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(campoFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(etq_restricccion)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(campoResteicciones, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(199, 199, 199)))
                .addComponent(panel_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(campoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etq_etiqueta)
                            .addComponent(campoEtiquetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etq_origen)
                            .addComponent(campoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(etq_duracion)
                    .addComponent(campoDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etq_categoria)
                    .addComponent(campoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_restricccion)
                    .addComponent(campoResteicciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etq_fecha_inicio)
                    .addComponent(campoFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_fecha_fin)
                    .addComponent(campoFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_crear_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
            String fechaInicioString = campoFechaInicio.getText();
            String fechaFinString = campoFechaFin.getText();
            String estado = "Activo";

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            if (imagenSeleccionada) {
                byte[] imagen = obtenerBytesDeImagen(rutaImagen);
                
                // Convertir las fechas de texto a objetos Date
                java.util.Date fechaInicio = dateFormat.parse(fechaInicioString);
                java.util.Date fechaFin = dateFormat.parse(fechaFinString);

                basedatos.crearPelicula(titulo, categoria, etiquetas, restriccionEdad, duracion, paisOrigen, imagen, rutaImagen, fechaInicio, fechaFin, estado);
                System.out.println("PELÍCULA CREADA CON ÉXITO");

                // Limpiar campos
                campoTitulo.setText("");
                campoCategoria.setText("");
                campoEtiquetas.setText("");
                campoOrigen.setText("");
                campo_imagen.setText("");
                
                previsualizacion.setIcon(null);


                // Reiniciar la bandera de imagen seleccionada
                imagenSeleccionada = false;
            } else {
                // Si no se ha seleccionado una imagen, mostrar un mensaje de error
                System.out.println("Error: Debes seleccionar una imagen.");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Error: Ingresa un valor numérico válido en los campos de restricción de edad y duración.");
        } catch (IOException ex) {
            System.out.println("Error al procesar la imagen: " + ex.getMessage());
        } catch (ParseException ex) {
            System.out.println("Error al parsear las fechas: " + ex.getMessage());
        }
    }//GEN-LAST:event_btn_crear_peliculaActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        campoTitulo.setText("");
        campoCategoria.setText("");
        campoEtiquetas.setText("");
        campoOrigen.setText("");
        campo_imagen.setText("");        
        previsualizacion.setIcon(null);
    }//GEN-LAST:event_btn_cancelarActionPerformed
    
    
    private byte[] obtenerBytesDeImagen(String rutaImagen) throws IOException {
        File file = new File(rutaImagen);
        BufferedImage bufferedImage = ImageIO.read(file);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_crear_pelicula;
    private javax.swing.JButton btn_seleccionar;
    private javax.swing.JTextField campoCategoria;
    private javax.swing.JTextField campoDuracion;
    private javax.swing.JTextField campoEtiquetas;
    private javax.swing.JTextField campoFechaFin;
    private javax.swing.JTextField campoFechaInicio;
    private javax.swing.JTextField campoOrigen;
    private javax.swing.JTextField campoResteicciones;
    private javax.swing.JTextField campoTitulo;
    private javax.swing.JTextField campo_imagen;
    private javax.swing.JLabel etq_categoria;
    private javax.swing.JLabel etq_duracion;
    private javax.swing.JLabel etq_etiqueta;
    private javax.swing.JLabel etq_fecha_fin;
    private javax.swing.JLabel etq_fecha_inicio;
    private javax.swing.JLabel etq_imagen;
    private javax.swing.JLabel etq_origen;
    private javax.swing.JLabel etq_restricccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel_pelicula;
    private javax.swing.JLabel previsualizacion;
    // End of variables declaration//GEN-END:variables

}

package JuanCamilo;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import utils.BaseDatosJuanPrincipal;
import utils.Pelicula;

public class EditarPelicula extends javax.swing.JFrame {
    BaseDatosJuanPrincipal basedatos;
    JFileChooser archivoSeleccionado;

    public EditarPelicula() {
        this.basedatos = new BaseDatosJuanPrincipal();
        initComponents();
        initAltersComponens();
        setLocationRelativeTo(null);
        archivoSeleccionado = new JFileChooser();
        setVisible(true);
        Object idPelicula = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etq_restricccion = new javax.swing.JLabel();
        etq_duracion = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        etq_titulo = new javax.swing.JLabel();
        etq_origen = new javax.swing.JLabel();
        campoTitulo = new javax.swing.JTextField();
        campoDuracion = new javax.swing.JTextField();
        etq_categoria = new javax.swing.JLabel();
        campoEtiquetas = new javax.swing.JTextField();
        campoResteicciones = new javax.swing.JTextField();
        campoOrigen = new javax.swing.JTextField();
        campoCategoria = new javax.swing.JTextField();
        btn_editar_pelicula = new javax.swing.JButton();
        etq_etiqueta = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        campo_id_pelicula = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        panel_pelicula = new javax.swing.JPanel();
        etq_imagen = new javax.swing.JLabel();
        btn_seleccionar = new javax.swing.JButton();
        previsualizacion = new javax.swing.JLabel();
        campo_imagen = new javax.swing.JTextField();
        campoFechaInicio = new javax.swing.JTextField();
        etq_fecha_inicio = new javax.swing.JLabel();
        etq_fecha_fin = new javax.swing.JLabel();
        campoFechaFin = new javax.swing.JTextField();
        etq_estado = new javax.swing.JLabel();
        campoEstado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        etq_restricccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_restricccion.setText("RESTRICCCION DE EDAD: ");

        etq_duracion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_duracion.setText("DURACION:");

        btn_cancelar.setBackground(new java.awt.Color(255, 0, 0));
        btn_cancelar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        etq_titulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_titulo.setText("TITULO:");

        etq_origen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_origen.setText("PAIS DE ORIGEN:");

        campoDuracion.setText("12");

        etq_categoria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_categoria.setText("CATEGORIA:");

        campoResteicciones.setText("12");

        btn_editar_pelicula.setBackground(new java.awt.Color(0, 255, 0));
        btn_editar_pelicula.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_editar_pelicula.setForeground(new java.awt.Color(255, 255, 255));
        btn_editar_pelicula.setText("GUARDAR");
        btn_editar_pelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editar_peliculaActionPerformed(evt);
            }
        });

        etq_etiqueta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_etiqueta.setText("ETIQUETAS: ");

        btn_buscar.setBackground(new java.awt.Color(0, 0, 255));
        btn_buscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscar.setText("BUSCAR");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        fondo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        fondo.setText("ID DE PELCULA: ");

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("EDITAR PELICULA");

        panel_pelicula.setBackground(new java.awt.Color(204, 204, 204));

        etq_imagen.setBackground(new java.awt.Color(255, 255, 255));
        etq_imagen.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        etq_imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_imagen.setText("IMAGEN: ");

        btn_seleccionar.setBackground(new java.awt.Color(255, 255, 51));
        btn_seleccionar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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
                .addGap(56, 56, 56)
                .addComponent(etq_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_peliculaLayout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addGroup(panel_peliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_peliculaLayout.createSequentialGroup()
                        .addComponent(btn_seleccionar)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_peliculaLayout.createSequentialGroup()
                        .addGroup(panel_peliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(previsualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campo_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))))
        );
        panel_peliculaLayout.setVerticalGroup(
            panel_peliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_peliculaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etq_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_seleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(previsualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campo_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        campoFechaInicio.setText("25/2/2024");

        etq_fecha_inicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_fecha_inicio.setText("F. INICIO: ");

        etq_fecha_fin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_fecha_fin.setText("F. FIN: ");

        campoFechaFin.setText("25/10/2024");

        etq_estado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_estado.setText("ESTADO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(etq_restricccion)
                            .addComponent(etq_etiqueta)
                            .addComponent(etq_titulo)
                            .addComponent(etq_duracion)
                            .addComponent(etq_origen)
                            .addComponent(etq_categoria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoEtiquetas, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoResteicciones, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(fondo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campo_id_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etq_fecha_inicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(etq_estado)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(campoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(etq_fecha_fin)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(campoFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_editar_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campo_id_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etq_titulo)
                            .addComponent(campoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etq_etiqueta)
                            .addComponent(campoEtiquetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etq_restricccion)
                            .addComponent(campoResteicciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etq_duracion)
                            .addComponent(campoDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etq_origen)
                            .addComponent(campoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etq_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etq_fecha_inicio)
                            .addComponent(campoFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etq_fecha_fin)
                            .addComponent(campoFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(panel_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etq_estado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoEstado))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_editar_pelicula)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private boolean imagenSeleccionada = false;
    
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



    
    
    private void btn_seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seleccionarActionPerformed
        abrirExploradorArchivos();
    }//GEN-LAST:event_btn_seleccionarActionPerformed

    private void btn_editar_peliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editar_peliculaActionPerformed
        try {
            String idPelicula = campo_id_pelicula.getText();
            String titulo = campoTitulo.getText();
            String categoria = campoCategoria.getText();
            String etiquetas = campoEtiquetas.getText();
            int restriccionEdad = Integer.parseInt(campoResteicciones.getText());
            int duracion = Integer.parseInt(campoDuracion.getText());
            String paisOrigen = campoOrigen.getText();
            String rutaImagen = campo_imagen.getText();
            String estado = campoEstado.getText();

            if (!rutaImagen.isEmpty() && archivoSeleccionado.getSelectedFile() != null) {
                String nuevaRutaImagen = guardarImagen(rutaImagen);
                if (!nuevaRutaImagen.isEmpty()) {
                    basedatos.actualizarPelicula(Integer.parseInt(idPelicula), titulo, categoria, etiquetas, restriccionEdad, duracion, paisOrigen, nuevaRutaImagen, estado);
                    System.out.println("PELÍCULA EDITADA CON ÉXITO");
                    limpiarCampos();
                    previsualizacion.setIcon(null);
                }
            } else {
                basedatos.actualizarPelicula(Integer.parseInt(idPelicula), titulo, categoria, etiquetas, restriccionEdad, duracion, paisOrigen, rutaImagen, estado); // Actualizar con el mismo estado
                System.out.println("PELÍCULA EDITADA CON ÉXITO");
                limpiarCampos();
                previsualizacion.setIcon(null);
            }
        } catch (NumberFormatException ex) {
            System.out.println("Error: Ingresa un valor numérico válido en los campos de restricción de edad y duración.");
        }
    }//GEN-LAST:event_btn_editar_peliculaActionPerformed

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
        limpiarCampos();
        campo_id_pelicula.setEnabled(true);
    }//GEN-LAST:event_btn_cancelarActionPerformed
    
    private void limpiarCampos() {
        campo_id_pelicula.setText("");
        campoTitulo.setText("");
        campoCategoria.setText("");
        campoEtiquetas.setText("");
        campoResteicciones.setText("");
        campoDuracion.setText("");
        campoOrigen.setText("");
        campo_imagen.setText("");
        previsualizacion.setIcon(null);
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

    private void mostrarDatosPelicula(Pelicula pelicula) {
        campoTitulo.setText(pelicula.getTitulo());
        campoCategoria.setText(pelicula.getCategoria());
        campoEtiquetas.setText(pelicula.getEtiquetas());
        campoResteicciones.setText(String.valueOf(pelicula.getRestriccionEdad()));
        campoDuracion.setText(String.valueOf(pelicula.getDuracion()));
        campoOrigen.setText(pelicula.getPaisOrigen());
        campo_imagen.setText(pelicula.getRutaImagen());
        campoEstado.setText(pelicula.getEstado());
        if (pelicula.getImagen() != null && pelicula.getImagen().length > 0) {
            ImageIcon icono = new ImageIcon(pelicula.getImagen());
            previsualizacion.setIcon(icono);
        } else {
            previsualizacion.setIcon(null);
        }
    }

    private void initAltersComponens() {
        btn_seleccionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_seleccionarActionPerformed(evt);
            }
        });

        btn_editar_pelicula.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_editar_peliculaActionPerformed(evt);
            }
        });

        btn_buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        btn_cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
    }

    private byte[] obtenerBytesDeImagen(String rutaImagen) throws IOException {
        File file = new File(rutaImagen);
        BufferedImage bufferedImage = ImageIO.read(file);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
    
    


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_editar_pelicula;
    private javax.swing.JButton btn_seleccionar;
    private javax.swing.JTextField campoCategoria;
    private javax.swing.JTextField campoDuracion;
    private javax.swing.JTextField campoEstado;
    private javax.swing.JTextField campoEtiquetas;
    private javax.swing.JTextField campoFechaFin;
    private javax.swing.JTextField campoFechaInicio;
    private javax.swing.JTextField campoOrigen;
    private javax.swing.JTextField campoResteicciones;
    private javax.swing.JTextField campoTitulo;
    private javax.swing.JTextField campo_id_pelicula;
    private javax.swing.JTextField campo_imagen;
    private javax.swing.JLabel etq_categoria;
    private javax.swing.JLabel etq_duracion;
    private javax.swing.JLabel etq_estado;
    private javax.swing.JLabel etq_etiqueta;
    private javax.swing.JLabel etq_fecha_fin;
    private javax.swing.JLabel etq_fecha_inicio;
    private javax.swing.JLabel etq_imagen;
    private javax.swing.JLabel etq_origen;
    private javax.swing.JLabel etq_restricccion;
    private javax.swing.JLabel etq_titulo;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel panel_pelicula;
    private javax.swing.JLabel previsualizacion;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}

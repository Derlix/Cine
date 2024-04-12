
package JuanCamilo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import utils.BaseDatosJuanPrincipal;
import utils.Usuario;

public class CrearUsuario extends javax.swing.JFrame {
    JFileChooser archivoSeleccionado;
    BaseDatosJuanPrincipal basedatos;
    private boolean imagenSeleccionada = false;
    public CrearUsuario(BaseDatosJuanPrincipal basedatos) {
        this.basedatos = basedatos;
        archivoSeleccionado = new JFileChooser();
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_pelicula = new javax.swing.JPanel();
        etq_imagen = new javax.swing.JLabel();
        btn_seleccionar = new javax.swing.JButton();
        previsualizacion = new javax.swing.JLabel();
        campo_imagen = new javax.swing.JTextField();
        btn_crear_usuario = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        etq_correo = new javax.swing.JLabel();
        CampoCorreo = new javax.swing.JTextField();
        etq_hora_inicio = new javax.swing.JLabel();
        CampoHoraInicio = new javax.swing.JTextField();
        etq_nombre = new javax.swing.JLabel();
        CampoNombre = new javax.swing.JTextField();
        etq_hora_fin = new javax.swing.JLabel();
        CampoHoraFin = new javax.swing.JTextField();
        etq_contraseña = new javax.swing.JLabel();
        CampoContraseña = new javax.swing.JTextField();
        etq_rol = new javax.swing.JLabel();
        CampoRol = new javax.swing.JTextField();
        etq_dias_laborales = new javax.swing.JLabel();
        CampoDiasLaborales = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        btn_crear_usuario.setBackground(new java.awt.Color(0, 255, 0));
        btn_crear_usuario.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_crear_usuario.setForeground(new java.awt.Color(255, 255, 255));
        btn_crear_usuario.setText("CREAR");
        btn_crear_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crear_usuarioActionPerformed(evt);
            }
        });

        btn_cancelar.setBackground(new java.awt.Color(255, 0, 0));
        btn_cancelar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("CREAR USUARIO");

        etq_correo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_correo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etq_correo.setText("CORREO:");

        etq_hora_inicio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_hora_inicio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etq_hora_inicio.setText("HORA INICIO");

        etq_nombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_nombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etq_nombre.setText("NOMBRE:");

        etq_hora_fin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_hora_fin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etq_hora_fin.setText("HORA FIN");

        etq_contraseña.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_contraseña.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etq_contraseña.setText("CONTRASEÑA:");

        etq_rol.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_rol.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etq_rol.setText("ROL:");

        etq_dias_laborales.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_dias_laborales.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etq_dias_laborales.setText("DIAS LABORABLES:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(etq_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(etq_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(etq_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(etq_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(etq_hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(etq_hora_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(etq_dias_laborales))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CampoCorreo)
                                    .addComponent(CampoNombre)
                                    .addComponent(CampoContraseña)
                                    .addComponent(CampoRol)
                                    .addComponent(CampoDiasLaborales)
                                    .addComponent(CampoHoraInicio)
                                    .addComponent(CampoHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(btn_crear_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(etq_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(etq_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(etq_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(etq_dias_laborales, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(etq_hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(etq_hora_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CampoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etq_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(CampoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CampoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CampoRol, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CampoDiasLaborales, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CampoHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CampoHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panel_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_crear_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seleccionarActionPerformed
        abrirExploradorArchivos();
    }//GEN-LAST:event_btn_seleccionarActionPerformed

    private void btn_crear_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crear_usuarioActionPerformed
        try {
            String correo = CampoCorreo.getText();
            String nombreUsuario = CampoNombre.getText();
            String contraseña = CampoContraseña.getText();

            // Verificar si se seleccionó una imagen
            if (campo_imagen.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una imagen.");
                return;
            }

            byte[] foto = obtenerBytesDeImagen(campo_imagen.getText());
            String rol = CampoRol.getText();
            String diasLaborales = CampoDiasLaborales.getText();
            String horaInicio = CampoHoraInicio.getText();
            String horaFinal = CampoHoraFin.getText();
            int idCine = 1; 

            basedatos.crearUsuario(correo,nombreUsuario,contraseña,foto,rol,diasLaborales,horaInicio,horaFinal,idCine);

            JOptionPane.showMessageDialog(this, "Usuario creado correctamente.");
            limpiarCampos();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo de imagen.");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_crear_usuarioActionPerformed
    
    
    private void limpiarCampos() {
        CampoCorreo.setText("");
        CampoNombre.setText("");
        CampoContraseña.setText("");
        campo_imagen.setText("");
        CampoRol.setText("");
        CampoDiasLaborales.setText("");
        CampoHoraInicio.setText("");
        CampoHoraFin.setText("");
        previsualizacion.setIcon(null);
    }
    
    
    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed

        campo_imagen.setText("");
        previsualizacion.setIcon(null);
    }//GEN-LAST:event_btn_cancelarActionPerformed

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
    
    private byte[] obtenerBytesDeImagen(String rutaImagen) throws IOException {
    File file = new File(rutaImagen);
    if (!file.exists()) {
        throw new FileNotFoundException("El archivo no existe.");
    }
    
    BufferedImage bufferedImage = ImageIO.read(file);
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
    return byteArrayOutputStream.toByteArray();
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CampoContraseña;
    private javax.swing.JTextField CampoCorreo;
    private javax.swing.JTextField CampoDiasLaborales;
    private javax.swing.JTextField CampoHoraFin;
    private javax.swing.JTextField CampoHoraInicio;
    private javax.swing.JTextField CampoNombre;
    private javax.swing.JTextField CampoRol;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_crear_usuario;
    private javax.swing.JButton btn_seleccionar;
    private javax.swing.JTextField campo_imagen;
    private javax.swing.JLabel etq_contraseña;
    private javax.swing.JLabel etq_correo;
    private javax.swing.JLabel etq_dias_laborales;
    private javax.swing.JLabel etq_hora_fin;
    private javax.swing.JLabel etq_hora_inicio;
    private javax.swing.JLabel etq_imagen;
    private javax.swing.JLabel etq_nombre;
    private javax.swing.JLabel etq_rol;
    private javax.swing.JPanel panel_pelicula;
    private javax.swing.JLabel previsualizacion;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}

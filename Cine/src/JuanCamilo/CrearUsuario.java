package JuanCamilo;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.plaf.basic.BasicComboPopup;
import utils.BaseDatosJuanPrincipal;
import utils.Usuario;

public class CrearUsuario extends javax.swing.JFrame {

    JFileChooser archivoSeleccionado;
    BaseDatosJuanPrincipal basedatos;
    private boolean imagenSeleccionada = false;
    Color customColor = Color.decode("#7F265B");

    public CrearUsuario(BaseDatosJuanPrincipal basedatos) {
        this.basedatos = basedatos;
        archivoSeleccionado = new JFileChooser();
        initComponents();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        componentesAlternos();

    }

    public void componentesAlternos() {
        btn_cancelar.setBackground(customColor);
        btn_crear_usuario.setBackground(customColor);
        btn_seleccionar.setBackground(customColor);

        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("imagenes/iconoPrincipal.png")));
        setTitle("Crear usuario");

        Object child = elegirRoll.getAccessibleContext().getAccessibleChild(0);
        if (child instanceof BasicComboPopup) {
            BasicComboPopup popup = (BasicComboPopup) child;
            JScrollPane scrollPane = (JScrollPane) popup.getComponent(0);
            JViewport viewport = scrollPane.getViewport();
            JList list = (JList) viewport.getView();
            list.setSelectionBackground(new Color(100, 149, 237));
            list.setBackground(new Color(176, 196, 222));
        }
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
        etq_dias_laborales = new javax.swing.JLabel();
        CampoDiasLaborales = new javax.swing.JTextField();
        elegirRoll = new javax.swing.JComboBox<>();

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
        btn_seleccionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_peliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_seleccionar)
                    .addGroup(panel_peliculaLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(etq_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_peliculaLayout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addComponent(campo_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_peliculaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(previsualizacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_peliculaLayout.setVerticalGroup(
            panel_peliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_peliculaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etq_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_seleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(previsualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(campo_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        btn_crear_usuario.setBackground(new java.awt.Color(0, 255, 0));
        btn_crear_usuario.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_crear_usuario.setForeground(new java.awt.Color(255, 255, 255));
        btn_crear_usuario.setText("CREAR");
        btn_crear_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_crear_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crear_usuarioActionPerformed(evt);
            }
        });

        btn_cancelar.setBackground(new java.awt.Color(255, 0, 0));
        btn_cancelar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("CREAR USUARIO");

        etq_correo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_correo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etq_correo.setText("CORREO:");

        CampoCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        etq_hora_inicio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_hora_inicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etq_hora_inicio.setText("HORA INICIO");

        CampoHoraInicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        etq_nombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_nombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etq_nombre.setText("NOMBRE:");

        CampoNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        etq_hora_fin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_hora_fin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etq_hora_fin.setText("HORA FIN");

        CampoHoraFin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        etq_contraseña.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_contraseña.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etq_contraseña.setText("CONTRASEÑA:");

        CampoContraseña.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        etq_rol.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_rol.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etq_rol.setText("ROL:");

        etq_dias_laborales.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_dias_laborales.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etq_dias_laborales.setText("DIAS LABORABLES:");

        CampoDiasLaborales.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CampoDiasLaborales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoDiasLaboralesActionPerformed(evt);
            }
        });

        elegirRoll.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        elegirRoll.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Cajero" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CampoCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(CampoNombre)
                            .addComponent(etq_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etq_hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etq_hora_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etq_correo)
                            .addComponent(etq_dias_laborales)
                            .addComponent(etq_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoContraseña)
                            .addComponent(CampoHoraFin)
                            .addComponent(CampoHoraInicio)
                            .addComponent(CampoDiasLaborales)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(etq_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(elegirRoll, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(btn_crear_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(etq_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(etq_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etq_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etq_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(elegirRoll, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etq_dias_laborales, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoDiasLaborales, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etq_hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etq_hora_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_crear_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
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
            // Obtener el rol seleccionado del JComboBox
            String rol = (String) elegirRoll.getSelectedItem();
            String diasLaborales = CampoDiasLaborales.getText();
            String horaInicio = CampoHoraInicio.getText();
            String horaFinal = CampoHoraFin.getText();
            int idCine = 1;
            System.out.println("Rol desde JComboBox: " + elegirRoll.getSelectedItem().toString());

            basedatos.crearUsuario(correo, nombreUsuario, contraseña, foto, rol, diasLaborales, horaInicio, horaFinal, idCine);

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
        CampoDiasLaborales.setText("");
        CampoHoraInicio.setText("");
        CampoHoraFin.setText("");
        previsualizacion.setIcon(null);
    }


    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed

        campo_imagen.setText("");
        previsualizacion.setIcon(null);
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void CampoDiasLaboralesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoDiasLaboralesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoDiasLaboralesActionPerformed

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
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_crear_usuario;
    private javax.swing.JButton btn_seleccionar;
    private javax.swing.JTextField campo_imagen;
    private javax.swing.JComboBox<String> elegirRoll;
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

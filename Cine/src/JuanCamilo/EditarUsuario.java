package JuanCamilo;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
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

public class EditarUsuario extends javax.swing.JFrame {
    JFileChooser archivoSeleccionado;
    BaseDatosJuanPrincipal basedatos;
    private boolean imagenSeleccionada = false;
    
    public EditarUsuario(BaseDatosJuanPrincipal basedatos) {
        this.basedatos = basedatos;
        archivoSeleccionado = new JFileChooser();
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("imagenes/iconoPrincipal.png")));
        setTitle("Editar Usuario");
        eventosMouse();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        CampoCorreo = new javax.swing.JTextField();
        etq_correo = new javax.swing.JLabel();
        CampoNombre = new javax.swing.JTextField();
        etq_nombre = new javax.swing.JLabel();
        etq_contraseña = new javax.swing.JLabel();
        CampoContraseña = new javax.swing.JTextField();
        CampoRol = new javax.swing.JTextField();
        etq_rol = new javax.swing.JLabel();
        etq_dias_laborales = new javax.swing.JLabel();
        CampoDiasLaborales = new javax.swing.JTextField();
        CampoHoraInicio = new javax.swing.JTextField();
        etq_hora_inicio = new javax.swing.JLabel();
        etq_hora_fin = new javax.swing.JLabel();
        CampoHoraFin = new javax.swing.JTextField();
        btn_editar_usuario = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        panel_pelicula = new javax.swing.JPanel();
        etq_imagen = new javax.swing.JLabel();
        btn_seleccionar = new javax.swing.JButton();
        previsualizacion = new javax.swing.JLabel();
        campo_imagen = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        etq_id = new javax.swing.JLabel();
        CampoID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("EDITAR USUARIO");

        etq_correo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_correo.setText("CORREO:");

        etq_nombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_nombre.setText("NOMBRE:");

        etq_contraseña.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_contraseña.setText("CONTRASEÑA:");

        etq_rol.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_rol.setText("ROL:");

        etq_dias_laborales.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_dias_laborales.setText("DIAS LABORABLES:");

        etq_hora_inicio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_hora_inicio.setText("HORA INICIO");

        etq_hora_fin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etq_hora_fin.setText("HORA FIN");

        btn_editar_usuario.setBackground(new java.awt.Color(0, 255, 0));
        btn_editar_usuario.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_editar_usuario.setForeground(new java.awt.Color(255, 255, 255));
        btn_editar_usuario.setText("EDITAR");
        btn_editar_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editar_usuarioActionPerformed(evt);
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

        btn_buscar.setBackground(new java.awt.Color(255, 255, 51));
        btn_buscar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn_buscar.setText("BUSCAR");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        etq_id.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etq_id.setText("ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(etq_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoID, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etq_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(CampoNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(etq_correo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CampoCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CampoHoraInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                        .addComponent(etq_hora_inicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CampoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etq_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etq_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CampoRol, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etq_hora_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CampoHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CampoDiasLaborales, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etq_dias_laborales))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(panel_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(btn_editar_usuario)
                        .addGap(87, 87, 87)
                        .addComponent(btn_cancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etq_id, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoID))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etq_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etq_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etq_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etq_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CampoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoRol, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etq_hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etq_hora_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CampoHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(etq_dias_laborales, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoDiasLaborales, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_editar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editar_usuarioActionPerformed
        try {
            int id = Integer.parseInt(CampoID.getText());
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
            int idCine = 1; // Aquí debes definir el valor correcto para idCine, si es necesario

            basedatos.actualizarUsuario(id, nombreUsuario, contraseña, rol, correo, diasLaborales, horaInicio, horaFinal, idCine, foto);

            JOptionPane.showMessageDialog(this, "Usuario actualizado correctamente.");
            limpiarCampos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID debe ser un número.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo de imagen.");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_editar_usuarioActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed

        limpiarCampos();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seleccionarActionPerformed
        abrirExploradorArchivos();
    }//GEN-LAST:event_btn_seleccionarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        try {
            int id = Integer.parseInt(CampoID.getText());
            Usuario usuario = basedatos.obtenerUsuarioPorId(id);

            if (usuario != null) {
                CampoCorreo.setText(usuario.getCorreo());
                CampoNombre.setText(usuario.getNombreUsuario());
                CampoContraseña.setText(usuario.getContraseña());
                CampoRol.setText(usuario.getRol());
                CampoDiasLaborales.setText(usuario.getDiasLaborales());
                CampoHoraInicio.setText(usuario.getHoraInicio());
                CampoHoraFin.setText(usuario.getHoraFinal());

                // Cargar y mostrar la imagen en la previsualización
                byte[] foto = usuario.getFoto();
                if (foto != null) {
                    ByteArrayInputStream bis = new ByteArrayInputStream(foto);
                    BufferedImage bufferedImage = ImageIO.read(bis);

                    if (bufferedImage != null) { // Verificar si bufferedImage es null
                        Image dimg = bufferedImage.getScaledInstance(previsualizacion.getWidth(), previsualizacion.getHeight(), Image.SCALE_SMOOTH);
                        previsualizacion.setIcon(new ImageIcon(dimg));
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al cargar la imagen.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID debe ser un número.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar la imagen.");
        }
    }//GEN-LAST:event_btn_buscarActionPerformed
    
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
    
    private void limpiarCampos() {
        CampoID.setText("");
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
        btn_editar_usuario.addMouseListener(new MouseAdapter() {
            @Override
            // Evento cambio de color cuando se pasa el mouse por el boton
            public void mouseEntered(MouseEvent e) {
                btn_editar_usuario.setBackground(customColor);
                btn_editar_usuario.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btn_editar_usuario.setForeground(Color.WHITE);
            }
            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                btn_editar_usuario.setBackground(Color.WHITE);
                btn_editar_usuario.setForeground(Color.BLACK);
            }
            // Establecer el color personalizado cuando se hace clic en cualquier botón
            @Override
            public void mouseClicked(MouseEvent e) {
                btn_editar_usuario.setBackground(customColor);
                
            }
        });
        btn_seleccionar.addMouseListener(new MouseAdapter() {
            @Override
            // Evento cambio de color cuando se pasa el mouse por el boton
            public void mouseEntered(MouseEvent e) {
                btn_seleccionar.setBackground(customColor);
                btn_seleccionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btn_seleccionar.setForeground(Color.WHITE);
            }
            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                btn_seleccionar.setBackground(Color.WHITE);
                btn_seleccionar.setForeground(Color.BLACK);
            }
            // Establecer el color personalizado cuando se hace clic en cualquier botón
            @Override
            public void mouseClicked(MouseEvent e) {
                btn_seleccionar.setBackground(customColor);
                
            }
        });
        
        
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CampoContraseña;
    private javax.swing.JTextField CampoCorreo;
    private javax.swing.JTextField CampoDiasLaborales;
    private javax.swing.JTextField CampoHoraFin;
    private javax.swing.JTextField CampoHoraInicio;
    private javax.swing.JTextField CampoID;
    private javax.swing.JTextField CampoNombre;
    private javax.swing.JTextField CampoRol;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_editar_usuario;
    private javax.swing.JButton btn_seleccionar;
    private javax.swing.JTextField campo_imagen;
    private javax.swing.JLabel etq_contraseña;
    private javax.swing.JLabel etq_correo;
    private javax.swing.JLabel etq_dias_laborales;
    private javax.swing.JLabel etq_hora_fin;
    private javax.swing.JLabel etq_hora_inicio;
    private javax.swing.JLabel etq_id;
    private javax.swing.JLabel etq_imagen;
    private javax.swing.JLabel etq_nombre;
    private javax.swing.JLabel etq_rol;
    private javax.swing.JPanel panel_pelicula;
    private javax.swing.JLabel previsualizacion;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}

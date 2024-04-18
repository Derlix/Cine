package Principal;

import ChristianArias.Analisis_Y_Reportes;
import JuanBustamante.Gestion_personal;
import JuanCamilo.CrearPelicula;
import JuanCamilo.GestionPeliculas;
import com.mysql.cj.xdevapi.DbDoc;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import utils.BaseDatosJuanBustamante;
/*import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;*/
import utils.BaseDatosJuanPrincipal;
import utils.BaseDatos_ChristianArias;
import utils.CristianBD;
import utils.Usuario;


public class MenuAdministrador extends javax.swing.JFrame {
    
    BaseDatosJuanPrincipal basedatos;
    Usuario usuarioActual;
    
    public MenuAdministrador(BaseDatosJuanPrincipal basedatos, Usuario usuario) {
        initComponents();
        this.basedatos = new BaseDatosJuanPrincipal();
        eventosMouse();
        initAlternComponents();
        this.usuarioActual = usuario;
        mostrarInformacionUsuario(); 
        getContentPane().setBackground(Color.WHITE);
    }
    
    private void mostrarInformacionUsuario() {
        if (usuarioActual != null) {
            // Mostrar nombre y rol
            etq_nombreUsuario.setText(usuarioActual.getNombreUsuario());
            etq_roll.setText(usuarioActual.getRol());

            // Mostrar imagen del usuario
            byte[] imagenBytes = usuarioActual.getFoto();
            if (imagenBytes != null) {
                try {
                    BufferedImage imagenOriginal = ImageIO.read(new ByteArrayInputStream(imagenBytes));

                    // Redimensionar la imagen para que se adapte al tamaño del JLabel
                    ImageIcon icono = new ImageIcon(imagenOriginal.getScaledInstance(etq_imagenUser.getWidth(), etq_imagenUser.getHeight(), Image.SCALE_SMOOTH));

                    etq_imagenUser.setIcon(icono);
                } catch (IOException ex) {
                    System.out.println("Error al leer la imagen: " + ex.getMessage());
                }
            } else {
                ImageIcon iconoOriginal = new ImageIcon(ClassLoader.getSystemResource("imagenes/user.png"));
                Image imagenOriginal = iconoOriginal.getImage();
                Image imagenRedimensionada = imagenOriginal.getScaledInstance(etq_imagenUser.getWidth(), etq_imagenUser.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                etq_imagenUser.setIcon(iconoRedimensionado);
            }
        }
    }



    public void initAlternComponents(){
        setTitle("Menu");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        
        //Image icono_registro = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/icono_usuario.png"));
        //icono_registro = icono_registro.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        //etqImagen.setIcon(new ImageIcon(icono_registro));
        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("imagenes/iconoPrincipal.png")));
        
        
        Image icono_etqImagen = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/etqimagen.png"));
        icono_etqImagen = icono_etqImagen.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        etqImagen.setIcon(new ImageIcon(icono_etqImagen));
        btnAdministrarSedes.setBackground(Color.WHITE);
        
        Image icono_listar = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/adminSede.png"));
        icono_listar = icono_listar.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        btnAdministrarSedes.setIcon(new ImageIcon(icono_listar));
        btnAdministrarSedes.setForeground(Color.BLACK);
        
        btnGestionPeliculas.setBackground(Color.WHITE);
        Image icono_Gestionpeliculas = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/gestionPeliculas.png"));
        icono_Gestionpeliculas = icono_Gestionpeliculas.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        btnGestionPeliculas.setIcon(new ImageIcon(icono_Gestionpeliculas));
        btnGestionPeliculas.setForeground(Color.BLACK);
        
        btnGestionPersonas.setBackground(Color.WHITE);
        Image icono_GestionPersonas = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/gestionPersonas.png"));
        icono_GestionPersonas = icono_GestionPersonas.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        btnGestionPersonas.setIcon(new ImageIcon(icono_GestionPersonas));
        btnGestionPersonas.setForeground(Color.BLACK);
        
        btnProgramarFunciones.setBackground(Color.WHITE);
        Image icono_programarFunciones = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/programacionFunciones.png"));
        icono_programarFunciones = icono_programarFunciones.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        btnProgramarFunciones.setIcon(new ImageIcon(icono_programarFunciones));
        btnProgramarFunciones.setForeground(Color.BLACK);
        
        btnAnalisisReporte.setBackground(Color.WHITE);
        Image icono_analisisReporte = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/AnalisisReporte.png"));
        icono_analisisReporte = icono_analisisReporte.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        btnAnalisisReporte.setIcon(new ImageIcon(icono_analisisReporte));
        btnAnalisisReporte.setForeground(Color.BLACK);
        
        
                
        //Muestra un notificacion para confirmar si deseas cerrar la aplicacion
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                confirmarCerrarAplicacion();
            }
        });
        
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentMenu = new javax.swing.JPanel();
        btnAdministrarSedes = new javax.swing.JButton();
        btnGestionPeliculas = new javax.swing.JButton();
        btnGestionPersonas = new javax.swing.JButton();
        btnProgramarFunciones = new javax.swing.JButton();
        btnAnalisisReporte = new javax.swing.JButton();
        boton_cerrarSesion = new javax.swing.JToggleButton();
        contentPrincipal = new javax.swing.JPanel();
        etqTemporal = new javax.swing.JLabel();
        panelIcon = new javax.swing.JPanel();
        etiquetatitulo = new javax.swing.JLabel();
        etqImagen = new javax.swing.JLabel();
        lineaCentral = new javax.swing.JPanel();
        lineaIzquierda = new javax.swing.JPanel();
        panelInfo = new javax.swing.JPanel();
        etq_nombreUsuario = new javax.swing.JLabel();
        etq_roll = new javax.swing.JLabel();
        etq_imagenUser = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        rol = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(204, 51, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contentMenu.setBackground(new java.awt.Color(255, 255, 255));

        btnAdministrarSedes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdministrarSedes.setText("ADMINISTRAR SEDES");
        btnAdministrarSedes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAdministrarSedes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdministrarSedes.setFocusable(false);
        btnAdministrarSedes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarSedesActionPerformed(evt);
            }
        });

        btnGestionPeliculas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGestionPeliculas.setText("GESTION DE PELICULAS");
        btnGestionPeliculas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnGestionPeliculas.setFocusable(false);
        btnGestionPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionPeliculasActionPerformed(evt);
            }
        });

        btnGestionPersonas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGestionPersonas.setText("GESTION DE PERSONAS");
        btnGestionPersonas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnGestionPersonas.setFocusable(false);
        btnGestionPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionPersonasActionPerformed(evt);
            }
        });

        btnProgramarFunciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnProgramarFunciones.setText("PROGRAMAR FUNCIONES");
        btnProgramarFunciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnProgramarFunciones.setFocusable(false);
        btnProgramarFunciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProgramarFuncionesActionPerformed(evt);
            }
        });

        btnAnalisisReporte.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAnalisisReporte.setText("ANALISIS Y REPORTES");
        btnAnalisisReporte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAnalisisReporte.setFocusable(false);
        btnAnalisisReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisisReporteActionPerformed(evt);
            }
        });

        boton_cerrarSesion.setText("CERRAR SESION");
        boton_cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_cerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentMenuLayout = new javax.swing.GroupLayout(contentMenu);
        contentMenu.setLayout(contentMenuLayout);
        contentMenuLayout.setHorizontalGroup(
            contentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdministrarSedes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGestionPeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGestionPersonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProgramarFunciones, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(btnAnalisisReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(contentMenuLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(boton_cerrarSesion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentMenuLayout.setVerticalGroup(
            contentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentMenuLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnAdministrarSedes, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGestionPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGestionPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProgramarFunciones, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnalisisReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(boton_cerrarSesion)
                .addGap(22, 22, 22))
        );

        getContentPane().add(contentMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 138, 290, -1));

        contentPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        etqTemporal.setBackground(new java.awt.Color(255, 255, 255));
        etqTemporal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        etqTemporal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqTemporal.setText("PANEL PRINCIPAL");

        javax.swing.GroupLayout contentPrincipalLayout = new javax.swing.GroupLayout(contentPrincipal);
        contentPrincipal.setLayout(contentPrincipalLayout);
        contentPrincipalLayout.setHorizontalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etqTemporal, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );
        contentPrincipalLayout.setVerticalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etqTemporal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(contentPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 138, 650, 430));

        panelIcon.setBackground(new java.awt.Color(255, 255, 255));

        etiquetatitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetatitulo.setText("Menu Administrador");

        etqImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelIconLayout = new javax.swing.GroupLayout(panelIcon);
        panelIcon.setLayout(panelIconLayout);
        panelIconLayout.setHorizontalGroup(
            panelIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIconLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etiquetatitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etqImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelIconLayout.setVerticalGroup(
            panelIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIconLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(etiquetatitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panelIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, -1));

        lineaCentral.setBackground(new java.awt.Color(0, 0, 0));
        lineaCentral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout lineaCentralLayout = new javax.swing.GroupLayout(lineaCentral);
        lineaCentral.setLayout(lineaCentralLayout);
        lineaCentralLayout.setHorizontalGroup(
            lineaCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        lineaCentralLayout.setVerticalGroup(
            lineaCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(lineaCentral, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, -1, 568));

        lineaIzquierda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout lineaIzquierdaLayout = new javax.swing.GroupLayout(lineaIzquierda);
        lineaIzquierda.setLayout(lineaIzquierdaLayout);
        lineaIzquierdaLayout.setHorizontalGroup(
            lineaIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        lineaIzquierdaLayout.setVerticalGroup(
            lineaIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(lineaIzquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 960, -1));

        panelInfo.setBackground(new java.awt.Color(255, 255, 255));

        etq_nombreUsuario.setText("Nombre Usuario Admin");

        etq_roll.setText("Roll: ~~~");

        etq_imagenUser.setText("Imagen");

        user.setText("Usuario");

        rol.setText("Rol");

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoLayout.createSequentialGroup()
                .addContainerGap(338, Short.MAX_VALUE)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etq_roll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etq_nombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(etq_imagenUser, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etq_nombreUsuario)
                            .addComponent(user))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etq_roll)
                            .addComponent(rol)))
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(etq_imagenUser, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 0, 650, 124));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdministrarSedesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarSedesActionPerformed
        /*
         nuevo = new (basedatos);
        
        
        //Ajustar el tamaño del nuevo contenedor
        nuevo.setPreferredSize(contentPrincipal.getPreferredSize());
        nuevo.setSize(contentPrincipal.getSize());
        //Eliminar el contenido del contentPrincipal
        contentPrincipal.removeAll();
        //Agregar dentro de contentPrincipal el contenedor nuevo
        contentPrincipal.add(nuevo);
        //repaint(); Re pintamos 
        repaint();
        revalidate();
        */
    }//GEN-LAST:event_btnAdministrarSedesActionPerformed

    private void btnGestionPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionPeliculasActionPerformed
        
        GestionPeliculas ventana = new GestionPeliculas(basedatos);
    
        // Eliminar todos los componentes del panel contentPrincipal
        contentPrincipal.removeAll();

        // Establecer el layout del panel contentPrincipal
        contentPrincipal.setLayout(new BorderLayout());

        // Agregar la instancia de CrearPelicula al panel contentPrincipal
        contentPrincipal.add(ventana, BorderLayout.CENTER);

        // Validar y repintar el panel contentPrincipal
        contentPrincipal.revalidate();
        contentPrincipal.repaint();
    }//GEN-LAST:event_btnGestionPeliculasActionPerformed

    private void btnGestionPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionPersonasActionPerformed
        BaseDatosJuanBustamante db = new BaseDatosJuanBustamante();
        Gestion_personal nuevo = new Gestion_personal(db);
        
                /*
        Gestion_personal nuevo = Gestion_personal new (basedatos);
        
        
        //Ajustar el tamaño del nuevo contenedor
        nuevo.setPreferredSize(contentPrincipal.getPreferredSize());
        nuevo.setSize(contentPrincipal.getSize());
        //Eliminar el contenido del contentPrincipal
        contentPrincipal.removeAll();
        //Agregar dentro de contentPrincipal el contenedor nuevo
        contentPrincipal.add(nuevo);
        //repaint(); Re pintamos 
        repaint();
        revalidate();
        */
        
        //Ajustar el tamaño del nuevo contenedor
       
        
    }//GEN-LAST:event_btnGestionPersonasActionPerformed

    private void btnProgramarFuncionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProgramarFuncionesActionPerformed
        /*
         nuevo = new (basedatos);
        
        
        //Ajustar el tamaño del nuevo contenedor
        nuevo.setPreferredSize(contentPrincipal.getPreferredSize());
        nuevo.setSize(contentPrincipal.getSize());
        //Eliminar el contenido del contentPrincipal
        contentPrincipal.removeAll();
        //Agregar dentro de contentPrincipal el contenedor nuevo
        contentPrincipal.add(nuevo);
        //repaint(); Re pintamos 
        repaint();
        revalidate();
        */
    }//GEN-LAST:event_btnProgramarFuncionesActionPerformed

    private void btnAnalisisReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisisReporteActionPerformed
        BaseDatos_ChristianArias db = new BaseDatos_ChristianArias();
        Analisis_Y_Reportes ventana = new Analisis_Y_Reportes(db);

         

    
        // Eliminar todos los componentes del panel contentPrincipal
        contentPrincipal.removeAll();

        // Establecer el layout del panel contentPrincipal
        contentPrincipal.setLayout(new BorderLayout());

        // Agregar la instancia de CrearPelicula al panel contentPrincipal
        contentPrincipal.add(ventana, BorderLayout.CENTER);

        // Validar y repintar el panel contentPrincipal
        contentPrincipal.revalidate();
        contentPrincipal.repaint();
        
        
        /*
         
        */
        
        
        
    }//GEN-LAST:event_btnAnalisisReporteActionPerformed

    private void boton_cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_cerrarSesionActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de cerrar sesion?", "Cerrar aplicación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            // Cerrar la aplicación
            CristianBD bd = new CristianBD();
            this.dispose();
            InicioSesion ventana = new InicioSesion(basedatos, bd);
        }
    }//GEN-LAST:event_boton_cerrarSesionActionPerformed
    Color customColor = Color.decode("#7F265B");
    public void eventosMouse(){
        
        
        btnAdministrarSedes.addMouseListener(new MouseAdapter() {
            @Override
            // Evento cambio de color cuando se pasa el mouse por el boton
            public void mouseEntered(MouseEvent e) {
                btnAdministrarSedes.setBackground(customColor);
                btnAdministrarSedes.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnAdministrarSedes.setForeground(Color.WHITE);
            }
            
             
            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                btnAdministrarSedes.setBackground(Color.WHITE);            
                btnAdministrarSedes.setForeground(Color.BLACK);
            }
            // Establecer el color personalizado cuando se hace clic en cualquier botón
            @Override
            public void mouseClicked(MouseEvent e) {
                btnAdministrarSedes.setBackground(customColor);
            }
        });
        
        btnGestionPeliculas.addMouseListener(new MouseAdapter() {
            @Override
            // Evento cambio de color cuando se pasa el mouse por el boton
            public void mouseEntered(MouseEvent e) {
                btnGestionPeliculas.setBackground(customColor);
                btnGestionPeliculas.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnGestionPeliculas.setForeground(Color.WHITE);
            }
            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                btnGestionPeliculas.setBackground(Color.WHITE);
                btnGestionPeliculas.setForeground(Color.BLACK);
            }
            // Establecer el color personalizado cuando se hace clic en cualquier botón
            @Override
            public void mouseClicked(MouseEvent e) {
                btnGestionPeliculas.setBackground(customColor);
                
            }
        });
        btnGestionPersonas.addMouseListener(new MouseAdapter() {
            @Override
            // Evento cambio de color cuando se pasa el mouse por el boton
            public void mouseEntered(MouseEvent e) {
                btnGestionPersonas.setBackground(customColor);
                btnGestionPersonas.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnGestionPersonas.setForeground(Color.WHITE);
            }
            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                btnGestionPersonas.setBackground(Color.WHITE);            
                btnGestionPersonas.setForeground(Color.BLACK);
            }
            // Establecer el color personalizado cuando se hace clic en cualquier botón
            @Override
            public void mouseClicked(MouseEvent e) {
                btnGestionPersonas.setBackground(customColor);
            }
        });
        btnProgramarFunciones.addMouseListener(new MouseAdapter() {
            @Override
            // Evento cambio de color cuando se pasa el mouse por el boton
            public void mouseEntered(MouseEvent e) {
                btnProgramarFunciones.setBackground(customColor);
                btnProgramarFunciones.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnProgramarFunciones.setForeground(Color.WHITE);
            }
            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                btnProgramarFunciones.setBackground(Color.WHITE);
                btnProgramarFunciones.setForeground(Color.BLACK);
            }
            // Establecer el color personalizado cuando se hace clic en cualquier botón
            @Override
            public void mouseClicked(MouseEvent e) {
                btnProgramarFunciones.setBackground(customColor);
            }
        });
        btnAnalisisReporte.addMouseListener(new MouseAdapter() {
            @Override
            // Evento cambio de color cuando se pasa el mouse por el boton
            public void mouseEntered(MouseEvent e) {
                btnAnalisisReporte.setForeground(Color.WHITE);
                btnAnalisisReporte.setBackground(customColor);
                btnAnalisisReporte.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
            }
            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                btnAnalisisReporte.setBackground(Color.WHITE);    
                btnAnalisisReporte.setForeground(Color.BLACK);
            }
            // Establecer el color personalizado cuando se hace clic en cualquier botón
            @Override
            public void mouseClicked(MouseEvent e) {
                btnAnalisisReporte.setBackground(customColor);
            }
        });
    }
    private void confirmarCerrarAplicacion() {
    int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de cerrar la aplicación?", "Cerrar aplicación", JOptionPane.YES_NO_OPTION);
    if (opcion == JOptionPane.YES_OPTION) {
        // Cerrar la aplicación
        System.exit(0);
    }
}
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton boton_cerrarSesion;
    private javax.swing.JButton btnAdministrarSedes;
    private javax.swing.JButton btnAnalisisReporte;
    private javax.swing.JButton btnGestionPeliculas;
    private javax.swing.JButton btnGestionPersonas;
    private javax.swing.JButton btnProgramarFunciones;
    private javax.swing.JPanel contentMenu;
    private javax.swing.JPanel contentPrincipal;
    private javax.swing.JLabel etiquetatitulo;
    private javax.swing.JLabel etqImagen;
    private javax.swing.JLabel etqTemporal;
    private javax.swing.JLabel etq_imagenUser;
    private javax.swing.JLabel etq_nombreUsuario;
    private javax.swing.JLabel etq_roll;
    private javax.swing.JPanel lineaCentral;
    private javax.swing.JPanel lineaIzquierda;
    private javax.swing.JPanel panelIcon;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JLabel rol;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}

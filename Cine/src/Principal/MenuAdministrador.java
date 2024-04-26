package Principal;

import ChristianArias.Analisis_Y_ReportesAdmin;
import ChristianArias.ProgramarFunciones;
import JuanBustamante.Gestion_empresa;
import JuanBustamante.Gestion_personal;
import JuanCamilo.CrearPelicula;
import JuanCamilo.GestionPeliculas;
import com.mysql.cj.xdevapi.DbDoc;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
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
import utils.BaseDatosJuanPrincipal;
import utils.BaseDatos_ChristianArias;
import utils.CristianBD;
import utils.Usuario;


public class MenuAdministrador extends javax.swing.JFrame {
    
    BaseDatosJuanPrincipal basedatos;
    Usuario usuarioActual;
    
    public MenuAdministrador(BaseDatosJuanPrincipal basedatos, Usuario usuario) {
        getContentPane().setBackground(Color.WHITE);
        initComponents();
        this.basedatos = new BaseDatosJuanPrincipal();
        eventosMouse();
        initAlternComponents();
        this.usuarioActual = usuario;
        mostrarInformacionUsuario(); 
        
    }
    
    private void mostrarInformacionUsuario() {
    if (usuarioActual != null) {
        etq_nombreUsuario.setText(usuarioActual.getNombreUsuario());
        etq_roll.setText(usuarioActual.getRol());

        byte[] imagenBytes = usuarioActual.getFoto();
        if (imagenBytes != null) {
            try {
                BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(imagenBytes));
                ImageIcon icon = createCircleImageIcon(originalImage.getScaledInstance(etq_imagenUser.getWidth(), etq_imagenUser.getHeight(), Image.SCALE_SMOOTH));
                etq_imagenUser.setIcon(icon);
            } catch (IOException ex) {
                System.out.println("Error al leer la imagen: " + ex.getMessage());
            }
        } else {
            ImageIcon defaultIcon = new ImageIcon(getClass().getResource("/imagenes/user.png"));
            etq_imagenUser.setIcon(createCircleImageIcon(defaultIcon.getImage().getScaledInstance(etq_imagenUser.getWidth(), etq_imagenUser.getHeight(), Image.SCALE_SMOOTH)));
            
        }
    }
}




    public void initAlternComponents(){
        setTitle("Menu");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        
        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("imagenes/iconoPrincipal.png")));
        
        
        Image icono_etqImagen = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/iconoAdministador.png"));
        icono_etqImagen = icono_etqImagen.getScaledInstance(180, 90, Image.SCALE_SMOOTH);
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
        
        boton_cerrarSesion.setBackground(Color.WHITE);
        boton_cerrarSesion.setForeground(Color.BLACK);
        
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
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

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

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

        boton_cerrarSesion.setText("Cerrar Sesion");
        boton_cerrarSesion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        boton_cerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addGap(90, 90, 90)
                .addComponent(boton_cerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(boton_cerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        getContentPane().add(contentMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 138, 290, 430));

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
                .addComponent(etqTemporal, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );
        contentPrincipalLayout.setVerticalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etqTemporal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(contentPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 138, 660, 430));

        panelIcon.setBackground(new java.awt.Color(255, 255, 255));

        etiquetatitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        etiquetatitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetatitulo.setText("Menu Administrador");

        etqImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelIconLayout = new javax.swing.GroupLayout(panelIcon);
        panelIcon.setLayout(panelIconLayout);
        panelIconLayout.setHorizontalGroup(
            panelIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIconLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetatitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(etqImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelIconLayout.setVerticalGroup(
            panelIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIconLayout.createSequentialGroup()
                .addComponent(etiquetatitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
        );

        getContentPane().add(panelIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 130));

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

        etq_nombreUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etq_nombreUsuario.setText("Nombre Usuario Admin");

        etq_roll.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etq_roll.setText("Roll: ~~~");

        etq_imagenUser.setText("Imagen");

        user.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        user.setText("Usuario:");

        rol.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rol.setText("Rol:");

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoLayout.createSequentialGroup()
                .addContainerGap(281, Short.MAX_VALUE)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(user, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etq_roll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etq_nombreUsuario))
                .addGap(18, 18, 18)
                .addComponent(etq_imagenUser, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_nombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rol, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(etq_roll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
            .addComponent(etq_imagenUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(panelInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 0, 670, 124));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdministrarSedesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarSedesActionPerformed
        
        BaseDatosJuanBustamante db = new BaseDatosJuanBustamante();
               
        Gestion_empresa nuevo = new Gestion_empresa(db);
        
        
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
        
        //Ajustar el tamaño del nuevo contenedor
       
        
        
    }//GEN-LAST:event_btnGestionPersonasActionPerformed

    private void btnProgramarFuncionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProgramarFuncionesActionPerformed
        
        ProgramarFunciones nuevo = new ProgramarFunciones(basedatos);
        
        
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
        
    }//GEN-LAST:event_btnProgramarFuncionesActionPerformed

    private void btnAnalisisReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisisReporteActionPerformed
        BaseDatos_ChristianArias db = new BaseDatos_ChristianArias();
        Analisis_Y_ReportesAdmin ventana = new Analisis_Y_ReportesAdmin(db);

         

    
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
        boton_cerrarSesion.addMouseListener(new MouseAdapter() {
            @Override
            // Evento cambio de color cuando se pasa el mouse por el boton
            public void mouseEntered(MouseEvent e) {
                boton_cerrarSesion.setForeground(Color.WHITE);
                boton_cerrarSesion.setBackground(customColor);
                boton_cerrarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
            }
            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                boton_cerrarSesion.setBackground(Color.WHITE);    
                boton_cerrarSesion.setForeground(Color.BLACK);
            }
            // Establecer el color personalizado cuando se hace clic en cualquier botón
            @Override
            public void mouseClicked(MouseEvent e) {
                boton_cerrarSesion.setBackground(customColor);
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
    
    private ImageIcon createCircleImageIcon(Image img) {
        // Asume que la imagen ya está escalada al tamaño del JLabel
        int diameter = Math.min(img.getWidth(null), img.getHeight(null));
        BufferedImage circleBuffer = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = circleBuffer.createGraphics();
        g2.setClip(new Ellipse2D.Float(0, 0, diameter, diameter));
        g2.drawImage(img, 0, 0, null);
        g2.dispose();
        return new ImageIcon(circleBuffer);
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
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel lineaCentral;
    private javax.swing.JPanel lineaIzquierda;
    private javax.swing.JPanel panelIcon;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JLabel rol;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}

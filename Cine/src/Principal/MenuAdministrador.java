package Principal;

import ChristianArias.Analisis_Y_Reportes;
import JuanBustamante.Gestion_empresa;
import JuanBustamante.Gestion_personal;
import JuanCamilo.CrearPelicula;
import JuanCamilo.GestionPeliculas;
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
        icono_Gestionpeliculas = icono_Gestionpeliculas.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
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
        revalidate();
        
        
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
        contentPrincipal = new javax.swing.JPanel();
        etqTemporal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        etiquetatitulo = new javax.swing.JLabel();
        etqImagen = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        etq_nombreUsuario = new javax.swing.JLabel();
        etq_roll = new javax.swing.JLabel();
        etq_imagenUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(204, 51, 255));

        contentMenu.setBackground(new java.awt.Color(255, 255, 255));

        btnAdministrarSedes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdministrarSedes.setText("ADMINISTRACION DE SEDES");
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
        btnProgramarFunciones.setText("PROGRAMACION DE FUNCIONES");
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
        btnAnalisisReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisisReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentMenuLayout = new javax.swing.GroupLayout(contentMenu);
        contentMenu.setLayout(contentMenuLayout);
        contentMenuLayout.setHorizontalGroup(
            contentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnalisisReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdministrarSedes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProgramarFunciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGestionPersonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGestionPeliculas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );
        contentMenuLayout.setVerticalGroup(
            contentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentMenuLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnAdministrarSedes, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGestionPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGestionPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProgramarFunciones, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnalisisReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        contentPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        etqTemporal.setBackground(new java.awt.Color(255, 255, 255));
        etqTemporal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        etqTemporal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqTemporal.setText("PANEL PRINCIPAL");

        javax.swing.GroupLayout contentPrincipalLayout = new javax.swing.GroupLayout(contentPrincipal);
        contentPrincipal.setLayout(contentPrincipalLayout);
        contentPrincipalLayout.setHorizontalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etqTemporal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPrincipalLayout.setVerticalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etqTemporal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        etiquetatitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetatitulo.setText("Menu Administrador");

        etqImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etiquetatitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etqImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(etiquetatitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        etq_nombreUsuario.setText("Nombre Usuario Admin");

        etq_roll.setText("Roll: ~~~");

        etq_imagenUser.setText("Imagen");
        etq_imagenUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(455, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etq_roll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etq_nombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(etq_imagenUser, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(etq_nombreUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etq_roll))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(etq_imagenUser, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contentPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(contentPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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
    Color customColor = Color.decode("#7F265B");
    public void eventosMouse(){
        
        
        btnAdministrarSedes.addMouseListener(new MouseAdapter() {
            @Override
            // Evento cambio de color cuando se pasa el mouse por el boton
            public void mouseEntered(MouseEvent e) {
                btnAdministrarSedes.setBackground(customColor);
                btnAdministrarSedes.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
             
            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                btnAdministrarSedes.setBackground(Color.WHITE);            
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
            }
            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                btnGestionPeliculas.setBackground(Color.WHITE);            
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
            }
            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                btnGestionPersonas.setBackground(Color.WHITE);            
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
            }
            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                btnProgramarFunciones.setBackground(Color.WHITE);            
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
                btnAnalisisReporte.setBackground(customColor);
                btnAnalisisReporte.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                btnAnalisisReporte.setBackground(Color.WHITE);            
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}

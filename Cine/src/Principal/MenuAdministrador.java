package Principal;

import JuanCamilo.CrearPelicula;
import JuanCamilo.GestionPeliculas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/*import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;*/
import utils.BaseDatosJuanPrincipal;






public class MenuAdministrador extends javax.swing.JFrame {
    BaseDatosJuanPrincipal basedatos;
    public MenuAdministrador(BaseDatosJuanPrincipal baseDatosJuanPrincipal) {
        initComponents();
        this.basedatos = new BaseDatosJuanPrincipal();

        initAlternComponents();
    }

    public void initAlternComponents(){
        setTitle("Menu");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        
        //Image icono_registro = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/icono_usuario.png"));
        //icono_registro = icono_registro.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        //etqImagen.setIcon(new ImageIcon(icono_registro));
        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("imagenes/icono_usuario.png")));
        
        
        btnAdministrarSedes.setBackground(Color.WHITE);
        //Image icono_listar = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/buscar_usuario.png"));
        //icono_listar = icono_listar.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        //btnAdministrarSedes.setIcon(new ImageIcon(icono_listar));
        btnAdministrarSedes.setForeground(new Color(0, 0, 200));
        
        btnGestionPeliculas.setBackground(Color.WHITE);
        //Image icono_crear = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/crear_usuario.png"));
        //icono_crear = icono_crear.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        //btnGestionPeliculas.setIcon(new ImageIcon(icono_crear));
        btnGestionPeliculas.setForeground(new Color(0, 200, 0));
        
        btnGestionPersonas.setBackground(Color.WHITE);
        //Image icono_editar = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/editar_usuario.png"));
        //icono_editar = icono_editar.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        //btnGestionPersonas.setIcon(new ImageIcon(icono_editar));
        btnGestionPersonas.setForeground(new Color(250, 195, 30));
        
        btnProgramarFunciones.setBackground(Color.WHITE);
        Image icono_eliminar = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/eliminar_usuario.png"));
        icono_eliminar = icono_eliminar.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        btnProgramarFunciones.setIcon(new ImageIcon(icono_eliminar));
        btnProgramarFunciones.setForeground(new Color(200, 0, 0));
        
        revalidate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentMenu = new javax.swing.JPanel();
        etqImagen = new javax.swing.JLabel();
        btnAdministrarSedes = new javax.swing.JButton();
        btnGestionPeliculas = new javax.swing.JButton();
        btnGestionPersonas = new javax.swing.JButton();
        btnProgramarFunciones = new javax.swing.JButton();
        btnAnalisisReporte = new javax.swing.JButton();
        contentPrincipal = new javax.swing.JPanel();
        etqTemporal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentMenu.setBackground(new java.awt.Color(255, 255, 255));

        etqImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnAdministrarSedes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdministrarSedes.setText("ADMINISTRACION DE SEDES");
        btnAdministrarSedes.setFocusable(false);
        btnAdministrarSedes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarSedesActionPerformed(evt);
            }
        });

        btnGestionPeliculas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGestionPeliculas.setText("GESTION DE PELICULAS");
        btnGestionPeliculas.setFocusable(false);
        btnGestionPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionPeliculasActionPerformed(evt);
            }
        });

        btnGestionPersonas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGestionPersonas.setText("GESTION DE PERSONAS");
        btnGestionPersonas.setFocusable(false);
        btnGestionPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionPersonasActionPerformed(evt);
            }
        });

        btnProgramarFunciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnProgramarFunciones.setText("PROGRAMACION DE FUNCIONES");
        btnProgramarFunciones.setFocusable(false);
        btnProgramarFunciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProgramarFuncionesActionPerformed(evt);
            }
        });

        btnAnalisisReporte.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAnalisisReporte.setText("ANALISIS Y REPORTES");
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentMenuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(contentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnGestionPeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGestionPersonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnProgramarFunciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentMenuLayout.createSequentialGroup()
                                .addComponent(etqImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)))))
                .addContainerGap())
        );
        contentMenuLayout.setVerticalGroup(
            contentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etqImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdministrarSedes, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGestionPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGestionPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProgramarFunciones, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnalisisReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        contentPrincipal.setBackground(new java.awt.Color(153, 204, 255));

        etqTemporal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        etqTemporal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqTemporal.setText("PANEL PRINCIPAL");

        javax.swing.GroupLayout contentPrincipalLayout = new javax.swing.GroupLayout(contentPrincipal);
        contentPrincipal.setLayout(contentPrincipalLayout);
        contentPrincipalLayout.setHorizontalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etqTemporal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        );
        contentPrincipalLayout.setVerticalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etqTemporal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(contentMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contentPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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
        /*
         String direccion = "C:\\Users\\chris\\OneDrive\\Escritorio\\Cine\\Cine\\src\\utils\\Reporte.jrxml";
    try {
        // Compilar el archivo JRXML
        JasperReport reporteJasper = JasperCompileManager.compileReport(direccion);

        // Llenar el reporte con datos
        JasperPrint mostrarReport = JasperFillManager.fillReport(reporteJasper, null, basedatos.getConnection());

        // Mostrar el reporte
        JasperViewer.viewReport(mostrarReport);
    } catch (JRException ex) {
        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
    }
        */
        
        
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
    }//GEN-LAST:event_btnAnalisisReporteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministrarSedes;
    private javax.swing.JButton btnAnalisisReporte;
    private javax.swing.JButton btnGestionPeliculas;
    private javax.swing.JButton btnGestionPersonas;
    private javax.swing.JButton btnProgramarFunciones;
    private javax.swing.JPanel contentMenu;
    private javax.swing.JPanel contentPrincipal;
    private javax.swing.JLabel etqImagen;
    private javax.swing.JLabel etqTemporal;
    // End of variables declaration//GEN-END:variables
}

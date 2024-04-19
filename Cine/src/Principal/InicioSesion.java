
package Principal;

import CristianArce.SesionCajero;
import JuanCamilo.CrearUsuario;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.LineBorder;
import utils.BaseDatosJuanPrincipal;
import utils.CristianBD;
import utils.Usuario;

public class InicioSesion extends javax.swing.JFrame {

    private BaseDatosJuanPrincipal baseDatos;
    CristianBD bd;
    public InicioSesion(BaseDatosJuanPrincipal baseDatos, CristianBD bd) {
        this.baseDatos = baseDatos;
        this.bd = bd;
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        componentesAlternos();
    }
    
    public void componentesAlternos(){
        //icono Principal
        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("imagenes/iconoPrincipal.png")));
        setTitle("Inicio de Sesion");
        setResizable(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        Image icono_listar = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/cine.jpg"));
        icono_listar = icono_listar.getScaledInstance(550, 500, Image.SCALE_SMOOTH);
        etq_imagePrincipal.setIcon(new ImageIcon(icono_listar));
        LineBorder rebordear = new LineBorder(null, 2, true);
        
        campo_contraseña.setBorder(rebordear);
        campo_usuario.setBorder(rebordear);
        btn_inicar.setBackground(Color.WHITE);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        etq_titulo = new javax.swing.JLabel();
        etq_usuario = new javax.swing.JLabel();
        etq_contraseña = new javax.swing.JLabel();
        btn_inicar = new javax.swing.JButton();
        campo_usuario = new javax.swing.JTextField();
        etq_olvido_contraseña = new javax.swing.JLabel();
        etq_imagePrincipal = new javax.swing.JLabel();
        campo_contraseña = new javax.swing.JPasswordField();
        btn_registrarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(255, 255, 255));

        etq_titulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        etq_titulo.setText("INICIAR SESION");

        etq_usuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        etq_usuario.setText("USUARIO: ");

        etq_contraseña.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        etq_contraseña.setText("CONTRASEÑA: ");

        btn_inicar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_inicar.setText("INICIAR");
        btn_inicar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_inicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inicarActionPerformed(evt);
            }
        });

        etq_olvido_contraseña.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etq_olvido_contraseña.setText("¿Olvidaste tu contraseña?");
        etq_olvido_contraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        etq_imagePrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_imagePrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_registrarse.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_registrarse.setText("REGISTRARSE ");
        btn_registrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(campo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_inicar, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(fondoLayout.createSequentialGroup()
                                        .addComponent(etq_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(243, 243, 243))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(etq_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campo_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                                .addComponent(etq_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                                .addComponent(etq_olvido_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                                .addComponent(btn_registrarse)
                                .addGap(97, 97, 97)))))
                .addComponent(etq_imagePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(etq_imagePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(etq_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etq_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(campo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(etq_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(campo_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btn_inicar)
                        .addGap(18, 18, 18)
                        .addComponent(etq_olvido_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_registrarse)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_inicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inicarActionPerformed
        String correo = campo_usuario.getText();
        String contraseña = campo_contraseña.getText();
        iniciarSesion(correo, contraseña);
    }//GEN-LAST:event_btn_inicarActionPerformed

    private void btn_registrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarseActionPerformed
        CrearUsuario v = new CrearUsuario(baseDatos);
    }//GEN-LAST:event_btn_registrarseActionPerformed
    
    public void iniciarSesion(String correo, String contraseña) {
        // Verificar las credenciales en la base de datos
        Usuario usuario = baseDatos.verificarCredenciales(correo, contraseña);

        if (usuario != null) {
            if (usuario.getRol().equals("Cajero")) {
                // Rol es Cajero
                System.out.println("Bienvenido Cajero");
                SesionCajero ventana = new SesionCajero(bd, usuario);
            } else if (usuario.getRol().equals("Administrador")) {
                // Rol es Administrador
                System.out.println("Bienvenido Administrador");
                MenuAdministrador menu = new MenuAdministrador(baseDatos, usuario); // Pasar el usuario
            } else {
                // mensaje de error en caso de no encontrar datos
                System.out.println("Rol desconocido: " + usuario.getRol());
            }
        } else {
            // mensaje de error en caso de no encontrar usuario
            System.out.println("Usuario o contraseña incorrectos");
        }
    }





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_inicar;
    private javax.swing.JButton btn_registrarse;
    private javax.swing.JPasswordField campo_contraseña;
    private javax.swing.JTextField campo_usuario;
    private javax.swing.JLabel etq_contraseña;
    private javax.swing.JLabel etq_imagePrincipal;
    private javax.swing.JLabel etq_olvido_contraseña;
    private javax.swing.JLabel etq_titulo;
    private javax.swing.JLabel etq_usuario;
    private javax.swing.JPanel fondo;
    // End of variables declaration//GEN-END:variables
}

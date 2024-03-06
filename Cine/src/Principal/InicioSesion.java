
package Principal;

import utils.BaseDatos;

public class InicioSesion extends javax.swing.JFrame {

    private BaseDatos baseDatos;

    public InicioSesion(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
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
        campo_contraseña = new javax.swing.JTextField();
        etq_olvido_contraseña = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        etq_titulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        etq_titulo.setText("CINE TAQUILLA");

        etq_usuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        etq_usuario.setText("USUARIO: ");

        etq_contraseña.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        etq_contraseña.setText("CONTRASEÑA: ");

        btn_inicar.setBackground(new java.awt.Color(0, 255, 0));
        btn_inicar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_inicar.setForeground(new java.awt.Color(255, 255, 255));
        btn_inicar.setText("INICIAR");
        btn_inicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inicarActionPerformed(evt);
            }
        });

        etq_olvido_contraseña.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etq_olvido_contraseña.setText("¿Olvidaste tu contraseña?");

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etq_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194))
            .addGroup(fondoLayout.createSequentialGroup()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(btn_inicar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(etq_olvido_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(etq_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etq_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campo_usuario)
                            .addComponent(campo_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etq_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(btn_inicar)
                .addGap(68, 68, 68)
                .addComponent(etq_olvido_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
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
        String usuario = campo_usuario.getText();
        String contraseña = campo_contraseña.getText();
        iniciarSesion(usuario, contraseña);
    }//GEN-LAST:event_btn_inicarActionPerformed
    
    public void iniciarSesion(String usuario, String contraseña) {
        // Verificar las credenciales en la base de datos
        String rol = baseDatos.verificarCredenciales(usuario, contraseña);
        
        if (rol.equals("Cajero")) {
            // Rol es Cajero
            System.out.println("Bienvenido Cajero");
        } else if (rol.equals("Administrador")) {
            // Rol es Administrador
            System.out.println("Bienvenido Administrador");
            Menu menu = new Menu();
        } else {
            // mensaje de error en caso de no encontrar datos
            System.out.println("Usuario o contraseña incorrectos");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_inicar;
    private javax.swing.JTextField campo_contraseña;
    private javax.swing.JTextField campo_usuario;
    private javax.swing.JLabel etq_contraseña;
    private javax.swing.JLabel etq_olvido_contraseña;
    private javax.swing.JLabel etq_titulo;
    private javax.swing.JLabel etq_usuario;
    private javax.swing.JPanel fondo;
    // End of variables declaration//GEN-END:variables
}

package JuanCamilo;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import utils.Cine;
import utils.BaseDatosJuanPrincipal;

public class CrearCine extends javax.swing.JFrame {
    BaseDatosJuanPrincipal basedatos;
    public CrearCine(BaseDatosJuanPrincipal basedatos) {
        initComponents();
        this.basedatos = basedatos;
        setVisible(true);
        setLocationRelativeTo(null);
        eventoMouse();
        getContentPane().setBackground(Color.WHITE);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        etq_nombre = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        etq_ciudad = new javax.swing.JLabel();
        campoCiudad = new javax.swing.JTextField();
        etq_pais = new javax.swing.JLabel();
        campoPais = new javax.swing.JTextField();
        etq_direccion = new javax.swing.JLabel();
        campoDireccion = new javax.swing.JTextField();
        btn_crear_cine = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CREAR CINE");

        etq_nombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_nombre.setText("NOMBRE:");

        etq_ciudad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_ciudad.setText("CIUDAD: ");

        etq_pais.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_pais.setText("PAIS:");

        etq_direccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_direccion.setText("DIRECCION:");

        btn_crear_cine.setBackground(new java.awt.Color(0, 255, 0));
        btn_crear_cine.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_crear_cine.setForeground(new java.awt.Color(255, 255, 255));
        btn_crear_cine.setText("CREAR");
        btn_crear_cine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crear_cineActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etq_nombre)
                                    .addComponent(etq_ciudad)
                                    .addComponent(campoCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoPais, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etq_pais)
                                    .addComponent(etq_direccion)
                                    .addComponent(campoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btn_crear_cine, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_cancelar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etq_nombre)
                    .addComponent(etq_direccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etq_ciudad)
                    .addComponent(etq_pais))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_crear_cine, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_crear_cineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crear_cineActionPerformed
        String nombre = campoNombre.getText();
        String ciudad = campoCiudad.getText();
        String pais = campoPais.getText();
        String direccion = campoDireccion.getText();

        if (nombre.isEmpty() || ciudad.isEmpty() || pais.isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            basedatos.crearCine(nombre, direccion, ciudad, pais);
            JOptionPane.showMessageDialog(this, "Cine creado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        }
    }//GEN-LAST:event_btn_crear_cineActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btn_cancelarActionPerformed
    private void limpiarCampos() {
        campoNombre.setText("");
        campoCiudad.setText("");
        campoPais.setText("");
        campoDireccion.setText("");
    }
    
    Color customColor = Color.decode("#7F265B");
    public void eventoMouse(){
        btn_crear_cine.addMouseListener(new MouseAdapter() {
            @Override
            // Evento cambio de color cuando se pasa el mouse por el boton
            public void mouseEntered(MouseEvent e) {
                btn_crear_cine.setBackground(customColor);
                btn_crear_cine.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btn_crear_cine.setForeground(Color.WHITE);
            }
            
             
            // Volver al color predeterminado cuando el raton sale del botón
            @Override
            public void mouseExited(MouseEvent e) {
                btn_crear_cine.setBackground(Color.WHITE);            
                btn_crear_cine.setForeground(Color.BLACK);
            }
            // Establecer el color personalizado cuando se hace clic en cualquier botón
            @Override
            public void mouseClicked(MouseEvent e) {
                btn_crear_cine.setBackground(customColor);
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
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_crear_cine;
    private javax.swing.JTextField campoCiudad;
    private javax.swing.JTextField campoDireccion;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPais;
    private javax.swing.JLabel etq_ciudad;
    private javax.swing.JLabel etq_direccion;
    private javax.swing.JLabel etq_nombre;
    private javax.swing.JLabel etq_pais;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

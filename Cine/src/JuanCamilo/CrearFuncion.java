
package JuanCamilo;

import java.awt.Color;
import javax.swing.JOptionPane;
import utils.BaseDatosJuanPrincipal;
import utils.Funcion;

public class CrearFuncion extends javax.swing.JFrame {
    BaseDatosJuanPrincipal basedatos;
    public CrearFuncion(BaseDatosJuanPrincipal basedatos) {
        initComponents();
        this.basedatos = basedatos;
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        componentesAlternos();
    }


    public void componentesAlternos(){
        setTitle("Crear Funcion");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("imagenes/iconoPrincipal.png")));
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        etq_id_pelicula = new javax.swing.JLabel();
        etq_id_sala = new javax.swing.JLabel();
        campoIdSala = new javax.swing.JTextField();
        campoIdPelcula = new javax.swing.JTextField();
        etq_fecha = new javax.swing.JLabel();
        etq_h_inicio = new javax.swing.JLabel();
        campoHInicio = new javax.swing.JTextField();
        campoFecha = new javax.swing.JTextField();
        etq_h_final = new javax.swing.JLabel();
        etq_precio = new javax.swing.JLabel();
        campoPrecio = new javax.swing.JTextField();
        campoHFinal = new javax.swing.JTextField();
        btn_crear_fucion = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CREAR FUNCION");

        etq_id_pelicula.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_id_pelicula.setText("ID PELICULA:");

        etq_id_sala.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_id_sala.setText("ID SALA:");

        etq_fecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_fecha.setText("FECHA:");

        etq_h_inicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_h_inicio.setText("H. INICIO:");

        campoHInicio.setText("17:00:00");

        campoFecha.setText("2024-05-01");

        etq_h_final.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_h_final.setText("H. FINAL:");

        etq_precio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_precio.setText("PRECIO:");

        campoHFinal.setText("19:00:00");

        btn_crear_fucion.setBackground(new java.awt.Color(0, 255, 0));
        btn_crear_fucion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_crear_fucion.setForeground(new java.awt.Color(255, 255, 255));
        btn_crear_fucion.setText("CREAR");
        btn_crear_fucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crear_fucionActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoHFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etq_h_final)
                        .addGap(128, 128, 128)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etq_precio)
                            .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(campoIdPelcula, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etq_id_pelicula)
                            .addComponent(etq_fecha)
                            .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoHInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etq_h_inicio)
                            .addComponent(etq_id_sala)
                            .addComponent(campoIdSala, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btn_crear_fucion, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etq_id_pelicula)
                    .addComponent(etq_id_sala))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoIdPelcula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoIdSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etq_fecha)
                    .addComponent(etq_h_inicio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoHInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etq_h_final)
                    .addComponent(etq_precio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoHFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_crear_fucion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_crear_fucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crear_fucionActionPerformed
        try {
            int idPelicula = Integer.parseInt(campoIdPelcula.getText());
            int idSala = Integer.parseInt(campoIdSala.getText());
            String fecha = campoFecha.getText();
            String horaInicio = campoHInicio.getText();
            String horaFinal = campoHFinal.getText();
            int precio = Integer.parseInt(campoPrecio.getText());

            Funcion nuevaFuncion = new Funcion(0, idPelicula, idSala, fecha, horaInicio, horaFinal, precio); // El ID se establece en 0 porque se generará automáticamente en la base de datos
            basedatos.guardarFuncion(nuevaFuncion);

            limpiarCampos();
        } catch (IllegalArgumentException e) {
            // Mostrar el mensaje de error en la consola
            e.printStackTrace();

            // Intentar mostrar el mensaje de error en la ventana JOptionPane
            JOptionPane.showMessageDialog(this, "Error al guardar la función: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_crear_fucionActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btn_cancelarActionPerformed
    
    private void limpiarCampos() {
        campoIdPelcula.setText("");
        campoIdSala.setText("");
        campoPrecio.setText("");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_crear_fucion;
    private javax.swing.JTextField campoFecha;
    private javax.swing.JTextField campoHFinal;
    private javax.swing.JTextField campoHInicio;
    private javax.swing.JTextField campoIdPelcula;
    private javax.swing.JTextField campoIdSala;
    private javax.swing.JTextField campoPrecio;
    private javax.swing.JLabel etq_fecha;
    private javax.swing.JLabel etq_h_final;
    private javax.swing.JLabel etq_h_inicio;
    private javax.swing.JLabel etq_id_pelicula;
    private javax.swing.JLabel etq_id_sala;
    private javax.swing.JLabel etq_precio;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

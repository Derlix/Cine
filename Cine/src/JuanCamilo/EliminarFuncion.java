
package JuanCamilo;

import java.awt.Color;
import javax.swing.JOptionPane;
import utils.BaseDatosJuanPrincipal;
import utils.Funcion;


public class EliminarFuncion extends javax.swing.JFrame {
    BaseDatosJuanPrincipal basedatos;
    public EliminarFuncion(BaseDatosJuanPrincipal basedatos) {
        initComponents();
        this.basedatos = basedatos;
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        etq_id = new javax.swing.JLabel();
        CampoID = new javax.swing.JTextField();
        btn_buscar1 = new javax.swing.JButton();
        etq_id_pelicula = new javax.swing.JLabel();
        campoIdPelcula = new javax.swing.JTextField();
        etq_id_sala = new javax.swing.JLabel();
        campoIdSala = new javax.swing.JTextField();
        etq_fecha = new javax.swing.JLabel();
        campoFecha = new javax.swing.JTextField();
        etq_h_inicio = new javax.swing.JLabel();
        campoHInicio = new javax.swing.JTextField();
        etq_h_final = new javax.swing.JLabel();
        campoHFinal = new javax.swing.JTextField();
        etq_precio = new javax.swing.JLabel();
        campoPrecio = new javax.swing.JTextField();
        btn_eliminar_fucion = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ELIMINAR FUNCION");

        etq_id.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etq_id.setText("ID:");

        btn_buscar1.setBackground(new java.awt.Color(255, 255, 51));
        btn_buscar1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn_buscar1.setText("BUSCAR");
        btn_buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar1ActionPerformed(evt);
            }
        });

        etq_id_pelicula.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_id_pelicula.setText("ID PELICULA:");

        etq_id_sala.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_id_sala.setText("ID SALA:");

        etq_fecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_fecha.setText("FECHA:");

        etq_h_inicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_h_inicio.setText("H. INICIO:");

        etq_h_final.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_h_final.setText("H. FINAL:");

        etq_precio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_precio.setText("PRECIO:");

        btn_eliminar_fucion.setBackground(new java.awt.Color(0, 255, 0));
        btn_eliminar_fucion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_eliminar_fucion.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar_fucion.setText("ELIMINAR");
        btn_eliminar_fucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_fucionActionPerformed(evt);
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
                .addGap(48, 48, 48)
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
                            .addComponent(campoIdSala, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(etq_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoID, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_buscar1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btn_eliminar_fucion)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cancelar)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_buscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_id, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoID))
                .addGap(57, 57, 57)
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
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_eliminar_fucion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar1ActionPerformed
        try {
            int idFuncion = Integer.parseInt(CampoID.getText());

            Funcion funcionEncontrada = basedatos.buscarFuncion(idFuncion);

            if(funcionEncontrada != null) {
                campoIdPelcula.setText(String.valueOf(funcionEncontrada.getId_pelicula()));
                campoIdSala.setText(String.valueOf(funcionEncontrada.getId_sala()));
                campoFecha.setText(funcionEncontrada.getFecha());
                campoHInicio.setText(funcionEncontrada.getHora_inicio());
                campoHFinal.setText(funcionEncontrada.getHora_final());
                campoPrecio.setText(String.valueOf(funcionEncontrada.getPrecio()));
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró una función con el ID proporcionado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID válido.");
        } catch (Exception e) {
            // Mostrar el mensaje de error en la consola
            e.printStackTrace();

            // Intentar mostrar el mensaje de error en la ventana JOptionPane
            JOptionPane.showMessageDialog(this, "Error al buscar la función: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_buscar1ActionPerformed

    private void btn_eliminar_fucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_fucionActionPerformed
            try {
            int idFuncion = Integer.parseInt(CampoID.getText());

            boolean eliminado = basedatos.eliminarFuncion(idFuncion);

            if(eliminado) {
                JOptionPane.showMessageDialog(this, "Función eliminada correctamente.");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar la función con el ID proporcionado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID válido.");
        } catch (Exception e) {
            // Mostrar el mensaje de error en la consola
            e.printStackTrace();

            // Intentar mostrar el mensaje de error en la ventana JOptionPane
            JOptionPane.showMessageDialog(this, "Error al eliminar la función: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_eliminar_fucionActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btn_cancelarActionPerformed
    
    private void limpiarCampos() {
        campoIdPelcula.setText("");
        campoIdSala.setText("");
        campoFecha.setText("");
        CampoID.setText("");
        campoHFinal.setText("");
        campoHInicio.setText("");
        campoPrecio.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CampoID;
    private javax.swing.JButton btn_buscar1;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar_fucion;
    private javax.swing.JTextField campoFecha;
    private javax.swing.JTextField campoHFinal;
    private javax.swing.JTextField campoHInicio;
    private javax.swing.JTextField campoIdPelcula;
    private javax.swing.JTextField campoIdSala;
    private javax.swing.JTextField campoPrecio;
    private javax.swing.JLabel etq_fecha;
    private javax.swing.JLabel etq_h_final;
    private javax.swing.JLabel etq_h_inicio;
    private javax.swing.JLabel etq_id;
    private javax.swing.JLabel etq_id_pelicula;
    private javax.swing.JLabel etq_id_sala;
    private javax.swing.JLabel etq_precio;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

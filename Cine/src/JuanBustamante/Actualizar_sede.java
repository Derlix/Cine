package JuanBustamante;

import javax.swing.JOptionPane;
import utils.BaseDatosJuanBustamante;

public class Actualizar_sede extends javax.swing.JFrame {
    BaseDatosJuanBustamante basedatos;
    int idSede;
    public Actualizar_sede(BaseDatosJuanBustamante basedatos, int idSede) {
        this.basedatos = basedatos;
        this.idSede = idSede;
        initComponents();
        setVisible(true);
        etq_sedeID.setText("Actualizar sede: #"+String.valueOf(idSede));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etq_sedeID = new javax.swing.JLabel();
        etq_NombreSede = new javax.swing.JLabel();
        campo_NombreSede = new javax.swing.JTextField();
        etq_Direccion = new javax.swing.JLabel();
        campo_Direccion = new javax.swing.JTextField();
        etq_ciudad = new javax.swing.JLabel();
        campo_ciudad = new javax.swing.JTextField();
        etq_pais = new javax.swing.JLabel();
        campo_pais = new javax.swing.JTextField();
        btn_actualizarSede = new javax.swing.JButton();
        btn_CancelarSede = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        etq_sedeID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        etq_sedeID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_sedeID.setText("Actualizar sede: #");

        etq_NombreSede.setText("Nombre sede:");

        etq_Direccion.setText("Direccion:");

        etq_ciudad.setText("Ciudad:");

        etq_pais.setText("Pais:");

        btn_actualizarSede.setBackground(new java.awt.Color(0, 138, 55));
        btn_actualizarSede.setForeground(new java.awt.Color(255, 255, 255));
        btn_actualizarSede.setText("ACTUALIZAR");
        btn_actualizarSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarSedeActionPerformed(evt);
            }
        });

        btn_CancelarSede.setBackground(new java.awt.Color(255, 102, 102));
        btn_CancelarSede.setText("CANCELAR");
        btn_CancelarSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarSedeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etq_pais, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_NombreSede, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                    .addComponent(etq_Direccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etq_ciudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campo_pais, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                    .addComponent(campo_ciudad)
                    .addComponent(campo_Direccion)
                    .addComponent(campo_NombreSede)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(etq_sedeID, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_actualizarSede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_CancelarSede, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(etq_sedeID)
                .addGap(18, 18, 18)
                .addComponent(etq_NombreSede)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_NombreSede, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etq_Direccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(etq_ciudad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(etq_pais)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_pais, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(btn_actualizarSede, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_CancelarSede, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_actualizarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarSedeActionPerformed
        // TODO add your handling code here:
        // Obtener los valores de los campos de texto
        String nombreSede = campo_NombreSede.getText();
        String direccion = campo_Direccion.getText();
        String ciudad = campo_ciudad.getText();
        String pais = campo_pais.getText();

        // Llamar a la función para actualizar la sede
        basedatos.actualizarSede(idSede, nombreSede, direccion, ciudad, pais);
       
        
        if (nombreSede.isEmpty() || direccion.isEmpty() || ciudad.isEmpty() || pais.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            // Llamar a la función para actualizar la sede
            basedatos.actualizarSede(1,nombreSede, direccion, ciudad, pais);
            JOptionPane.showMessageDialog(this, "Sala actualizada con exito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        }
    }//GEN-LAST:event_btn_actualizarSedeActionPerformed

    private void limpiarCampos() {
        campo_NombreSede.setText("");
        campo_Direccion.setText("");
        campo_ciudad.setText("");
        campo_pais.setText("");
    }
    
    private void btn_CancelarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarSedeActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_CancelarSedeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CancelarSede;
    private javax.swing.JButton btn_actualizarSede;
    private javax.swing.JTextField campo_Direccion;
    private javax.swing.JTextField campo_NombreSede;
    private javax.swing.JTextField campo_ciudad;
    private javax.swing.JTextField campo_pais;
    private javax.swing.JLabel etq_Direccion;
    private javax.swing.JLabel etq_NombreSede;
    private javax.swing.JLabel etq_ciudad;
    private javax.swing.JLabel etq_pais;
    private javax.swing.JLabel etq_sedeID;
    // End of variables declaration//GEN-END:variables
}

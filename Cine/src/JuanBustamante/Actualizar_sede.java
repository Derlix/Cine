package JuanBustamante;

import utils.BaseDatosJuanBustamante;

public class Actualizar_sede extends javax.swing.JFrame {
    BaseDatosJuanBustamante basedatos;
    
    public Actualizar_sede(BaseDatosJuanBustamante basedatos) {
        this.basedatos = basedatos;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        etq_NombreSede = new javax.swing.JLabel();
        campo_NombreSede = new javax.swing.JTextField();
        etq_Direccion = new javax.swing.JLabel();
        campo_Direccion = new javax.swing.JTextField();
        etq_ciudad = new javax.swing.JLabel();
        campo_ciudad = new javax.swing.JTextField();
        etq_pais = new javax.swing.JLabel();
        campo_pais = new javax.swing.JTextField();
        btn_actualizarSede = new javax.swing.JButton();
        btn_eliminarSede = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Actualizar sede: ARBOLEDA #1");

        etq_NombreSede.setText("Nombre sede:");

        campo_NombreSede.setText("jTextField1");
        campo_NombreSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_NombreSedeActionPerformed(evt);
            }
        });

        etq_Direccion.setText("Direccion:");

        campo_Direccion.setText("jTextField2");
        campo_Direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_DireccionActionPerformed(evt);
            }
        });

        etq_ciudad.setText("Ciudad:");

        campo_ciudad.setText("jTextField3");

        etq_pais.setText("Pais:");

        campo_pais.setText("jTextField4");

        btn_actualizarSede.setBackground(new java.awt.Color(0, 138, 55));
        btn_actualizarSede.setForeground(new java.awt.Color(255, 255, 255));
        btn_actualizarSede.setText("ACTUALIZAR");
        btn_actualizarSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarSedeActionPerformed(evt);
            }
        });

        btn_eliminarSede.setBackground(new java.awt.Color(255, 102, 102));
        btn_eliminarSede.setText("ELIMINAR SEDE");
        btn_eliminarSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarSedeActionPerformed(evt);
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
                        .addComponent(jLabel1)))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_actualizarSede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_eliminarSede, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
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
                .addComponent(btn_eliminarSede, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
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
        basedatos.actualizarSede(1, nombreSede, direccion, ciudad, pais);
    }//GEN-LAST:event_btn_actualizarSedeActionPerformed

    private void campo_NombreSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_NombreSedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_NombreSedeActionPerformed

    private void campo_DireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_DireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_DireccionActionPerformed

    private void btn_eliminarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarSedeActionPerformed

    }//GEN-LAST:event_btn_eliminarSedeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizarSede;
    private javax.swing.JButton btn_eliminarSede;
    private javax.swing.JTextField campo_Direccion;
    private javax.swing.JTextField campo_NombreSede;
    private javax.swing.JTextField campo_ciudad;
    private javax.swing.JTextField campo_pais;
    private javax.swing.JLabel etq_Direccion;
    private javax.swing.JLabel etq_NombreSede;
    private javax.swing.JLabel etq_ciudad;
    private javax.swing.JLabel etq_pais;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

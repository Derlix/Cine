
package JuanBustamante;


public class Empleados_jornada extends javax.swing.JFrame {

    /**
     * Creates new form Empleados_jornada
     */
    public Empleados_jornada() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        etq_empleado_nombre = new javax.swing.JLabel();
        etq_cambiar_rol = new javax.swing.JLabel();
        select_rol = new javax.swing.JComboBox<>();
        etq_sede = new javax.swing.JLabel();
        select_sede = new javax.swing.JComboBox<>();
        etq_dias_laboral = new javax.swing.JLabel();
        rbtn_lunes = new javax.swing.JRadioButton();
        rbtn_martes = new javax.swing.JRadioButton();
        rbtn_miercoles = new javax.swing.JRadioButton();
        rbtn_jueves = new javax.swing.JRadioButton();
        rbtn_viernes = new javax.swing.JRadioButton();
        rbtn_sabado = new javax.swing.JRadioButton();
        rbtn_domingo = new javax.swing.JRadioButton();
        etq_inicio_jornada = new javax.swing.JLabel();
        campo_inicio_jornada = new javax.swing.JTextField();
        etq_formato_horas = new javax.swing.JLabel();
        etq_fin_jornada = new javax.swing.JLabel();
        campo_fin_jornada = new javax.swing.JTextField();
        etq_formato_horas_dos = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        etq_empleado_nombre.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        etq_empleado_nombre.setText("Empleada/o: Nombre empleado");

        etq_cambiar_rol.setText("Cambiar rol:");

        select_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cajero", "Admin" }));

        etq_sede.setText("Sede:");

        select_sede.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguna" }));

        etq_dias_laboral.setText("Dias de laborales:");

        rbtn_lunes.setText("L");

        rbtn_martes.setText("M");

        rbtn_miercoles.setText("MI");

        rbtn_jueves.setText("J");

        rbtn_viernes.setText("V");

        rbtn_sabado.setText("S");

        rbtn_domingo.setText("D");
        rbtn_domingo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_domingoActionPerformed(evt);
            }
        });

        etq_inicio_jornada.setText("Inicio de jornada:");

        campo_inicio_jornada.setText("00:00");

        etq_formato_horas.setText("* Fomato 24 Horas *");

        etq_fin_jornada.setText("Fin de jornada");

        campo_fin_jornada.setText("00:00");

        etq_formato_horas_dos.setText("* Fomato 24 Horas *");

        btn_cancelar.setText("Cancelar");

        btn_actualizar.setText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etq_sede, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etq_empleado_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etq_cambiar_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(select_sede, javax.swing.GroupLayout.Alignment.LEADING, 0, 328, Short.MAX_VALUE)
                                .addComponent(select_rol, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(etq_dias_laboral, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(campo_fin_jornada, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(etq_formato_horas_dos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(etq_fin_jornada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(campo_inicio_jornada, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(etq_inicio_jornada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(etq_formato_horas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rbtn_lunes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbtn_martes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbtn_miercoles)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbtn_jueves)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbtn_viernes))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(65, 65, 65)
                                        .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(rbtn_sabado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbtn_domingo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8)))))))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(etq_empleado_nombre)
                .addGap(18, 18, 18)
                .addComponent(etq_cambiar_rol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(select_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(etq_sede)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(select_sede, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(etq_dias_laboral)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtn_martes)
                    .addComponent(rbtn_lunes)
                    .addComponent(rbtn_miercoles)
                    .addComponent(rbtn_jueves)
                    .addComponent(rbtn_viernes)
                    .addComponent(rbtn_sabado)
                    .addComponent(rbtn_domingo))
                .addGap(26, 26, 26)
                .addComponent(etq_inicio_jornada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_inicio_jornada, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_formato_horas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etq_fin_jornada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_fin_jornada, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_formato_horas_dos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtn_domingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_domingoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtn_domingoActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_actualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JTextField campo_fin_jornada;
    private javax.swing.JTextField campo_inicio_jornada;
    private javax.swing.JLabel etq_cambiar_rol;
    private javax.swing.JLabel etq_dias_laboral;
    private javax.swing.JLabel etq_empleado_nombre;
    private javax.swing.JLabel etq_fin_jornada;
    private javax.swing.JLabel etq_formato_horas;
    private javax.swing.JLabel etq_formato_horas_dos;
    private javax.swing.JLabel etq_inicio_jornada;
    private javax.swing.JLabel etq_sede;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbtn_domingo;
    private javax.swing.JRadioButton rbtn_jueves;
    private javax.swing.JRadioButton rbtn_lunes;
    private javax.swing.JRadioButton rbtn_martes;
    private javax.swing.JRadioButton rbtn_miercoles;
    private javax.swing.JRadioButton rbtn_sabado;
    private javax.swing.JRadioButton rbtn_viernes;
    private javax.swing.JComboBox<String> select_rol;
    private javax.swing.JComboBox<String> select_sede;
    // End of variables declaration//GEN-END:variables
}

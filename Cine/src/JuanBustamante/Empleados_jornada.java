package JuanBustamante;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import utils.BaseDatosJuanBustamante;
import utils.Usuario;

public class Empleados_jornada extends javax.swing.JFrame {

    BaseDatosJuanBustamante basedatos;
    int idEmpleado;
    public Empleados_jornada(BaseDatosJuanBustamante basedatos, int idEmpleado) {
        this.basedatos = basedatos;
        this.idEmpleado = idEmpleado;
        initComponents();
        cargarInfoUsuario();
        setTitle("Jornada de empleados");
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        componentesAlternos();
    }
    
    public void componentesAlternos(){
        setTitle("Eliminar Funcion");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("imagenes/iconoPrincipal.png")));
    }
    
    private void cargarInfoUsuario() {
    // Obtener el objeto Usuario directamente de la base de datos
    Usuario empleado = basedatos.obtenerEmpleadoPorId(idEmpleado);

    // Verificar si se encontró el empleado
    if (empleado != null) {
        // Mostrar el nombre del empleado en la etiqueta
        etq_empleado_nombre.setText("Empleado: " + empleado.getNombreUsuario());

        // Obtener los nombres de todos los cines disponibles
        List<String> cines = basedatos.obtenerCines();

        // Limpiar el ComboBox select_sede antes de agregar las nuevas sedes
        select_sede.removeAllItems();

        // Agregar los nombres de los cines al ComboBox select_sede
        for (String cine : cines) {
            select_sede.addItem(cine);
        }

        // Obtener el nombre de la sede del empleado
        String nombreSedeEmpleado = basedatos.obtenerNombreCine(empleado.getIdCine());

        // Seleccionar la sede del empleado en el ComboBox
        if (nombreSedeEmpleado != null) {
            select_sede.setSelectedItem(nombreSedeEmpleado);
        } else {
            // Si no se encontró la sede del empleado, seleccionar la primera sede disponible
            if (select_sede.getItemCount() > 0) {
                select_sede.setSelectedIndex(0);
            }
        }

        // Mostrar el rol del empleado en el ComboBox
        select_rol.setSelectedItem(empleado.getRol());

        // Obtener los días laborales del empleado y marcar los botones de radio correspondientes
        String diasLaborales = empleado.getDiasLaborales();
        marcarDiasLaborales(diasLaborales);

        // Mostrar la hora de inicio de jornada en el campo correspondiente
        campo_inicio_jornada.setText(empleado.getHoraInicio());

        // Mostrar la hora final de jornada en el campo correspondiente
        campo_fin_jornada.setText(empleado.getHoraFinal());
    } else {
        // Si no se encontró el empleado, mostrar un mensaje de error
        JOptionPane.showMessageDialog(this, "No se encontró el empleado en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
    }
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        etq_empleado_nombre.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        etq_empleado_nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etq_empleado_nombre.setText("Empleada/o: Nombre empleado");

        etq_cambiar_rol.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        etq_cambiar_rol.setText("Cambiar rol:");

        select_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cajero", "Administrador" }));
        select_rol.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        etq_sede.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        etq_sede.setText("Sede:");

        select_sede.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguna" }));
        select_sede.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        etq_dias_laboral.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        etq_dias_laboral.setText("Dias laborales:");

        rbtn_lunes.setBackground(new java.awt.Color(255, 255, 255));
        rbtn_lunes.setText("L");

        rbtn_martes.setBackground(new java.awt.Color(255, 255, 255));
        rbtn_martes.setText("M");

        rbtn_miercoles.setBackground(new java.awt.Color(255, 255, 255));
        rbtn_miercoles.setText("MI");

        rbtn_jueves.setBackground(new java.awt.Color(255, 255, 255));
        rbtn_jueves.setText("J");

        rbtn_viernes.setBackground(new java.awt.Color(255, 255, 255));
        rbtn_viernes.setText("V");

        rbtn_sabado.setBackground(new java.awt.Color(255, 255, 255));
        rbtn_sabado.setText("S");

        rbtn_domingo.setBackground(new java.awt.Color(255, 255, 255));
        rbtn_domingo.setText("D");

        etq_inicio_jornada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        etq_inicio_jornada.setText("Inicio de jornada:");

        campo_inicio_jornada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campo_inicio_jornada.setText("00:00");
        campo_inicio_jornada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        etq_formato_horas.setText("* Fomato 24 Horas *");

        etq_fin_jornada.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        etq_fin_jornada.setText("Fin de jornada");

        campo_fin_jornada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campo_fin_jornada.setText("00:00");
        campo_fin_jornada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        etq_formato_horas_dos.setText("* Fomato 24 Horas *");

        btn_cancelar.setText("Cancelar");
        btn_cancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_actualizar.setText("Actualizar");
        btn_actualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(etq_sede, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etq_cambiar_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etq_dias_laboral, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(select_rol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(select_sede, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(etq_empleado_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etq_fin_jornada)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)
                                .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(campo_fin_jornada, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(etq_formato_horas_dos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rbtn_lunes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etq_inicio_jornada)
                                    .addComponent(campo_inicio_jornada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etq_formato_horas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rbtn_martes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbtn_miercoles)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbtn_jueves, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbtn_viernes, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbtn_sabado, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbtn_domingo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(35, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addComponent(etq_fin_jornada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_fin_jornada, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etq_formato_horas_dos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
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

    // Método para marcar los botones de radio según los días laborales del empleado
private void marcarDiasLaborales(String diasLaborales) {
    if (diasLaborales != null) {
        String[] dias = diasLaborales.split(",");
        for (String dia : dias) {
            switch (dia) {
                case "L":
                    rbtn_lunes.setSelected(true);
                    break;
                case "M":
                    rbtn_martes.setSelected(true);
                    break;
                case "MI":
                    rbtn_miercoles.setSelected(true);
                    break;
                case "J":
                    rbtn_jueves.setSelected(true);
                    break;
                case "V":
                    rbtn_viernes.setSelected(true);
                    break;
                case "S":
                    rbtn_sabado.setSelected(true);
                    break;
                case "D":
                    rbtn_domingo.setSelected(true);
                    break;
            }
        }
    }
}
    
    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        
        String nombreCineSeleccionado = select_sede.getSelectedItem().toString();
        String rolSeleccionado = select_rol.getSelectedItem().toString();
        String inicioJornada = campo_inicio_jornada.getText();
        String finJornada = campo_fin_jornada.getText();

        // Comprobar si algún campo está vacío
        if (nombreCineSeleccionado.isEmpty() || rolSeleccionado.isEmpty() || inicioJornada.isEmpty() || finJornada.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;  // Detener la ejecución si falta algún dato
        }

        // Validar el formato de hora
        if (!inicioJornada.matches("\\d{2}:\\d{2}") || !finJornada.matches("\\d{2}:\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Ingrese el formato HH:mm en los campos de inicio y fin de jornada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar el orden de las horas
        LocalTime inicio = LocalTime.parse(inicioJornada, DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime fin = LocalTime.parse(finJornada, DateTimeFormatter.ofPattern("HH:mm"));
        if (inicio.isAfter(fin)) {
            JOptionPane.showMessageDialog(this, "El inicio de la jornada debe ser antes que el fin de la jornada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Instancia de la base de datos
        BaseDatosJuanBustamante db = new BaseDatosJuanBustamante();
        int idCine = db.obtenerIdCinePorNombre(nombreCineSeleccionado);
        if (idCine == -1) {
            JOptionPane.showMessageDialog(this, "Error al obtener el ID del cine.", "Error", JOptionPane.ERROR_MESSAGE);
            return;  // Detener si no se encuentra el cine
        }

        // Actualiza el cine y el rol
        boolean actualizado = db.actualizarEmpleadoCineYRol(idEmpleado, idCine, rolSeleccionado);
        if (!actualizado) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el cine y el rol del empleado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Recopilar los días laborales seleccionados
        StringBuilder diasLaborales = new StringBuilder();
        if (rbtn_lunes.isSelected()) diasLaborales.append("L,");
        if (rbtn_martes.isSelected()) diasLaborales.append("M,");
        if (rbtn_miercoles.isSelected()) diasLaborales.append("MI,");
        if (rbtn_jueves.isSelected()) diasLaborales.append("J,");
        if (rbtn_viernes.isSelected()) diasLaborales.append("V,");
        if (rbtn_sabado.isSelected()) diasLaborales.append("S,");
        if (rbtn_domingo.isSelected()) diasLaborales.append("D,");
        if (diasLaborales.length() > 0) {
            diasLaborales.setLength(diasLaborales.length() - 1); // Elimina la última coma
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione al menos un día laboral.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Actualizar los días laborales en la base de datos
        db.actualizarDiasLaborales(idEmpleado, diasLaborales.toString());

        // Actualizar la jornada en la base de datos
        db.actualizarJornada(idEmpleado, inicioJornada, finJornada);
        JOptionPane.showMessageDialog(this, "Información actualizada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    
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

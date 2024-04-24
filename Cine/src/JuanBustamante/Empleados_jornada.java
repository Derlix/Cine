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

        etq_empleado_nombre.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        etq_empleado_nombre.setText("Empleada/o: Nombre empleado");

        etq_cambiar_rol.setText("Cambiar rol:");

        select_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cajero", "Administrador" }));

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

        etq_inicio_jornada.setText("Inicio de jornada:");

        campo_inicio_jornada.setText("00:00");

        etq_formato_horas.setText("* Fomato 24 Horas *");

        etq_fin_jornada.setText("Fin de jornada");

        campo_fin_jornada.setText("00:00");

        etq_formato_horas_dos.setText("* Fomato 24 Horas *");

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

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
         // TODO add your handling code here:
        
        
        // Recopilar los datos de los botones de radio
        StringBuilder diasLaborales = new StringBuilder();
        if (rbtn_lunes.isSelected()) diasLaborales.append("L,");
        if (rbtn_martes.isSelected()) diasLaborales.append("M,");
        if (rbtn_miercoles.isSelected()) diasLaborales.append("MI,");
        if (rbtn_jueves.isSelected()) diasLaborales.append("J,");
        if (rbtn_viernes.isSelected()) diasLaborales.append("V,");
        if (rbtn_sabado.isSelected()) diasLaborales.append("S,");
        if (rbtn_domingo.isSelected()) diasLaborales.append("D,");

        // Eliminar la última coma si hay días seleccionados
        if (diasLaborales.length() > 0) {
            diasLaborales.setLength(diasLaborales.length() - 1); // Elimina la última coma
        }

        // Asumiendo que hay un método para obtener el ID del empleado, por ejemplo, getEmpleadoID()
        // int idEmpleado = getEmpleadoID(); // Este método debe ser implementado según tu lógica de negocio

        // Llamar al método para actualizar los días laborales en la base de datos
        basedatos.actualizarDiasLaborales(idEmpleado, diasLaborales.toString());
        
        String inicio_jornada = campo_inicio_jornada.getText();
        String fin_jornada = campo_fin_jornada.getText();
        
        // Validar que los campos de inicio y fin de jornada sigan el formato HH:mm
        if (!inicio_jornada.matches("\\d{2}:\\d{2}") || !fin_jornada.matches("\\d{2}:\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el formato HH:mm en los campos de inicio y fin de jornada.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (inicio_jornada.isEmpty() || fin_jornada.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Convertir las cadenas de inicio y fin de jornada a objetos LocalTime para realizar la comparación
            LocalTime inicio = LocalTime.parse(inicio_jornada, DateTimeFormatter.ofPattern("HH:mm"));
            LocalTime fin = LocalTime.parse(fin_jornada, DateTimeFormatter.ofPattern("HH:mm"));

            // Validar que los tiempos estén dentro del rango de 00:00 a 24:00
            if (inicio.isBefore(LocalTime.MIN) || inicio.isAfter(LocalTime.MAX) || fin.isBefore(LocalTime.MIN) || fin.isAfter(LocalTime.MAX)) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese tiempos entre 00:00 y 24:00 en los campos de inicio y fin de jornada.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (inicio.isAfter(fin)) {
                // Asegurar que el inicio de la jornada sea menor que el fin
                JOptionPane.showMessageDialog(this, "El inicio de la jornada debe ser menor que el fin.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Actualizar la jornada en la base de datos
                basedatos.actualizarJornada(idEmpleado, inicio_jornada, fin_jornada);
                JOptionPane.showMessageDialog(this, "Jornada actualizada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            }
        }
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void limpiarCampos(){
        campo_inicio_jornada.setText("");
        campo_fin_jornada.setText("");
    }

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

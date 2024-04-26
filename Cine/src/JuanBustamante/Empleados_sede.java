/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package JuanBustamante;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import utils.BaseDatosJuanBustamante;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import utils.Usuario;

public class Empleados_sede extends javax.swing.JFrame {

    BaseDatosJuanBustamante basedatos;
    int idCine;
    public Empleados_sede(BaseDatosJuanBustamante basedatos, int idCine) {
        this.basedatos = basedatos;
        this.idCine = idCine;
        initComponents();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        // Obtener el nombre del cine y mostrarlo en el label
        String nombreCine = basedatos.obtenerNombrePorIDCine(idCine);
        setTitle("Empleados de "+nombreCine);
        etq_empleados_sede.setText("Empleados de la sede: " + nombreCine);

        // Llenar la tabla con los datos de los empleados
        llenarTabla();
        
        // Agregar un MouseListener a la tabla
        empleados_jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Obtener la fila seleccionada
                int filaSeleccionada = empleados_jTable.getSelectedRow();
                // Verificar si se hizo doble clic y la fila seleccionada es válida
                if (e.getClickCount() == 2 && filaSeleccionada != -1) {
                    // Obtener la ID del empleado seleccionado en la tabla
                    int idEmpleado = (int) empleados_jTable.getValueAt(filaSeleccionada, 0);
                    // Abrir la ventana Empleados_jornada y pasar la ID del empleado seleccionado
                    Empleados_jornada empleadosSedeFrame = new Empleados_jornada(basedatos, idEmpleado);
                }
            }
        });
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        etq_empleados_sede = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        empleados_jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        etq_empleados_sede.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        etq_empleados_sede.setText("EMPLEADOS DE LA SEDE: UNICENTRO");

        empleados_jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Sede", "Rol"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(empleados_jTable);

        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<< Doble clic al usuario a seleccionar >>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addComponent(etq_empleados_sede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(etq_empleados_sede)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(32, Short.MAX_VALUE))
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
    // Método para llenar la tabla con los datos de los empleados
    private void llenarTabla() {
        this.idCine = idCine;
        //int idMCine = 3;
        // Obtener la lista de usuarios empleados
        List<Usuario> empleados = basedatos.obtenerEmpleadosPorCine(idCine);

        // Limpiar la tabla antes de llenarla
        DefaultTableModel model = (DefaultTableModel) empleados_jTable.getModel();
        model.setRowCount(0);

        // Llenar la tabla con los datos de los empleados
        for (Usuario empleado : empleados) {
            model.addRow(new Object[]{
                empleado.getIdUsuario(),
                empleado.getNombreUsuario(),
                empleado.getIdCine(),
                empleado.getRol()
            });
        }
        
        // Hacer la tabla no editable
        empleados_jTable.setDefaultEditor(Object.class, null);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable empleados_jTable;
    private javax.swing.JLabel etq_empleados_sede;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

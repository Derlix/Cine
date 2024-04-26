
package JuanBustamante;

import com.mysql.cj.x.protobuf.MysqlxExpr;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import utils.BaseDatosJuanBustamante;
import JuanBustamante.Empleados_sede;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Gestion_personal extends javax.swing.JPanel {

    BaseDatosJuanBustamante basedatos;
    public Gestion_personal(BaseDatosJuanBustamante db) {
        initComponents();
        this.basedatos = db;
        initComponents();
        setVisible(true);

        // Agregar un ListSelectionListener a la lista sedes_jList
        sedes_jList.addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                // Obtener el índice seleccionado
                int selectedIndex = sedes_jList.getSelectedIndex();
                if (selectedIndex != -1) { // Verificar si se ha seleccionado un elemento
                    // Obtener el nombre completo del cine seleccionado
                    String cineSeleccionado = sedes_jList.getModel().getElementAt(selectedIndex);

                    // Separar el nombre del cine de la ciudad
                    String[] partes = cineSeleccionado.split(", ");
                    // Obtener el nombre del cine
                    String nombreCine = partes[0];
                    // Obtener la ID del cine a partir del nombre
                    int idCine = basedatos.obtenerIdCinePorNombre(nombreCine);

                    // Crear la ventana Empleados_sede y pasar la ID del cine
                    Empleados_sede empleadosSedeFrame = new Empleados_sede(basedatos, idCine);
                    // Mostrar la ventana Empleados_sede
                    empleadosSedeFrame.setVisible(true);

                    // Deseleccionar el elemento actualmente seleccionado
                    sedes_jList.clearSelection();
            }
        }
    });

        cargarCinesEnLista();
        
    }

    
      private void cargarCinesEnLista() {
    List<String> cines = basedatos.obtenerCines();
    DefaultListModel<String> model = new DefaultListModel<>();
    for (String cine : cines) {
        model.addElement(cine);
    }
        sedes_jList.setModel(model);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        etq_gestionPersonal = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        sedes_jList = new javax.swing.JList<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        etq_gestionPersonal.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        etq_gestionPersonal.setText("Gestion de Personal");

        campoBuscar.setText("Buscar por sede...");
        campoBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        sedes_jList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        sedes_jList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(sedes_jList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(etq_gestionPersonal)
                        .addGap(110, 110, 110)
                        .addComponent(campoBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_buscar))
                    .addComponent(jScrollPane1))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(etq_gestionPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:
        String criterioBusqueda = campoBuscar.getText();
        List<String> resultadosBusqueda = basedatos.buscarCinePorNombre(criterioBusqueda);
        DefaultListModel<String> model = new DefaultListModel<>();
        if (resultadosBusqueda.isEmpty()) {
            // Si no hay resultados, agrega un mensaje indicando que no hay cines relacionados
            model.addElement("No hay ningún cine con ese nombre");
        } else {
            // Si hay resultados, los agrega a la lista
            for (String cine : resultadosBusqueda) {
                model.addElement(cine);
            }
        }
        sedes_jList.setModel(model);
    }//GEN-LAST:event_btn_buscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JLabel etq_gestionPersonal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> sedes_jList;
    // End of variables declaration//GEN-END:variables
}

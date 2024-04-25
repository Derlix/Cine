
package JuanBustamante;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import utils.BaseDatosJuanBustamante;
import utils.Cine;
import utils.Sala;


public class Gestion_asientos extends javax.swing.JFrame {

    BaseDatosJuanBustamante basedatos;
    int idSede;
    public Gestion_asientos(BaseDatosJuanBustamante db, int idSede) {
        this.basedatos = db;
        this.idSede = idSede;
        initComponents();
        // Llamar a un método para cargar la información del cine al iniciar la ventana
        cargarInformacionCine();
        cargarSalas();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        componentesAlternos();
    }
    
    // Método para cargar la información del cine
    private void cargarInformacionCine() {
        // Realizar una consulta a la base de datos para obtener la información del cine
        Cine cine = basedatos.obtenerInformacionCine(idSede);
        if (cine != null) {
            // Actualizar las etiquetas con los datos del cine
            etq_Nombre_sede.setText("Sede: " + cine.getNombre());
            // Obtener el número de salas utilizando el método obtenerTotalSalasPorIdCine()
            int totalSalas = basedatos.obtenerTotalSalasPorIdCine(idSede);
            etq_SalaTotal.setText("Salas: " + totalSalas);
            etq_DireccionSede.setText("Direccion: " + cine.getDireccion());
            etq_CiudadSede.setText("Ciudad: " + cine.getCiudad());
            etq_PaisSede.setText("Pais: " + cine.getPais());
        } else {
            // Manejar el caso en que no se encuentre la información del cine
            System.out.println("No se pudo obtener la información del cine.");
        }
    }
    
    public void componentesAlternos(){
        setTitle("Eliminar Funcion");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("imagenes/iconoPrincipal.png")));
    }

    private void cargarSalas() {
    // Obtener todas las salas vinculadas a la sede
    List<Sala> salas = basedatos.obtenerSalasPorIdSede(idSede);
    
    DefaultListModel<String> model = new DefaultListModel<>();
    
    // Construir las cadenas de nombre y capacidad de cada sala y agregarlas al modelo
    for (Sala sala : salas) {
        String nombreSala = sala.getNombre();
        int capacidad = sala.getCapacidad();
        int idSala = sala.getId_sala(); // Asegúrate de que la clase Sala tenga un método getId_sala()
        String infoSala = "Sala: " + nombreSala + " - Capacidad: " + capacidad + " - ID: " + idSala;
        model.addElement(infoSala);
    }
    
    // Establecer el modelo en la JList
    SalaCap_jList.setModel(model);
    
    // Agregar un ListSelectionListener a la lista
    SalaCap_jList.addListSelectionListener((ListSelectionEvent event) -> {
        if (!event.getValueIsAdjusting()) {
            // Obtener el índice del elemento seleccionado
            int selectedIndex = SalaCap_jList.getSelectedIndex();
            if (selectedIndex != -1) {
                // Obtener el elemento seleccionado
                String selectedElement = SalaCap_jList.getModel().getElementAt(selectedIndex);
                // Extraer la ID de la sala del elemento seleccionado
                // Aquí asumimos que la ID de la sala siempre está al final del elemento
                String idSalaStr = selectedElement.substring(selectedElement.lastIndexOf("ID: ") + 4);
                // Convertir la ID de la sala a int
                int idSala = Integer.parseInt(idSalaStr);
                // Ahora puedes usar la ID de la sala para lo que necesites
                System.out.println("ID de la sala seleccionada: " + idSala);
                Actualizar_sala actuaSala = new Actualizar_sala(basedatos, idSala, idSede);
            }
        }
    });
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        etq_InformacionSede = new javax.swing.JLabel();
        btn_Editar = new javax.swing.JButton();
        etq_Nombre_sede = new javax.swing.JLabel();
        etq_SalaTotal = new javax.swing.JLabel();
        etq_DireccionSede = new javax.swing.JLabel();
        etq_CiudadSede = new javax.swing.JLabel();
        etq_PaisSede = new javax.swing.JLabel();
        btn_crearSala = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        SalaCap_jList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        etq_InformacionSede.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        etq_InformacionSede.setText("Informacion sede:");

        btn_Editar.setText("Editar");
        btn_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditarActionPerformed(evt);
            }
        });

        etq_Nombre_sede.setText("Sede: Arboleda");

        etq_SalaTotal.setText("Salas: 5");

        etq_DireccionSede.setText("Direccion: Calle 123");

        etq_CiudadSede.setText("Ciudad: Ciudad Principal");

        etq_PaisSede.setText("Pais: Pais A");

        btn_crearSala.setText("Crear sala");
        btn_crearSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearSalaActionPerformed(evt);
            }
        });

        SalaCap_jList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Sala: 1 - Capacidad: 30", "Sala: 2 - Capacidad: 30", "Sala: 3 - Capacidad: 30", "Sala: 4 - Capacidad: 30" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(SalaCap_jList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_crearSala)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(etq_PaisSede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(etq_CiudadSede, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(etq_DireccionSede, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(etq_SalaTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(etq_InformacionSede, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etq_Nombre_sede, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(161, 161, 161)
                        .addComponent(btn_Editar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etq_InformacionSede)
                    .addComponent(btn_Editar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etq_Nombre_sede)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etq_SalaTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etq_DireccionSede)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etq_CiudadSede)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etq_PaisSede)
                .addGap(18, 18, 18)
                .addComponent(btn_crearSala)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
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

    private void btn_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarActionPerformed
        // TODO add your handling code here:
        Actualizar_sede ActualizadorSede = new Actualizar_sede(basedatos, idSede);
    }//GEN-LAST:event_btn_EditarActionPerformed

    private void btn_crearSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearSalaActionPerformed
        // TODO add your handling code here:
        
        Crear_sala CreaLaSala = new Crear_sala(basedatos,idSede);
    }//GEN-LAST:event_btn_crearSalaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> SalaCap_jList;
    private javax.swing.JButton btn_Editar;
    private javax.swing.JButton btn_crearSala;
    private javax.swing.JLabel etq_CiudadSede;
    private javax.swing.JLabel etq_DireccionSede;
    private javax.swing.JLabel etq_InformacionSede;
    private javax.swing.JLabel etq_Nombre_sede;
    private javax.swing.JLabel etq_PaisSede;
    private javax.swing.JLabel etq_SalaTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

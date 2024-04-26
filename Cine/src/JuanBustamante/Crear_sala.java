package JuanBustamante;
import javax.swing.JOptionPane;
import utils.BaseDatosJuanBustamante;
import utils.Sala;

public class Crear_sala extends javax.swing.JFrame {
    BaseDatosJuanBustamante basedatos;
    int idSede;
    public Crear_sala(BaseDatosJuanBustamante basedatos,int idSede) {
        this.basedatos = basedatos;
        
        this.idSede = idSede;
        initComponents();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        componentesAlternos();
    }

    public void componentesAlternos(){
        setTitle("Crear Sala");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("imagenes/iconoPrincipal.png")));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campo_Nombre_sala = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campo_Capacidad_sala = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();
        btn_Crear_sala = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Crear nueva sala");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nombre sala:");

        campo_Nombre_sala.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Capacidad:");

        campo_Capacidad_sala.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_cancelar.setText("Cancelar");
        btn_cancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_Crear_sala.setBackground(new java.awt.Color(0, 204, 102));
        btn_Crear_sala.setForeground(new java.awt.Color(255, 255, 255));
        btn_Crear_sala.setText("Crear");
        btn_Crear_sala.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_Crear_sala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Crear_salaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(campo_Nombre_sala, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campo_Capacidad_sala, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Crear_sala, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(campo_Nombre_sala, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(campo_Capacidad_sala, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Crear_sala, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
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

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_Crear_salaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Crear_salaActionPerformed
        // Obtener el nombre de la sala y la capacidad desde los campos de texto
        String nombreSala = campo_Nombre_sala.getText();
        String capacidadTexto = campo_Capacidad_sala.getText();

        // Verificar si alguno de los campos está vacío
        if (nombreSala.isEmpty() || capacidadTexto.isEmpty()) {
            // Mostrar alerta de error si alguno de los campos está vacío
            JOptionPane.showMessageDialog(this, "Por favor completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Convertir la capacidad a entero
            int capacidad = Integer.parseInt(capacidadTexto);

            // Llamar a la función para actualizar la sede
            basedatos.insertarSala(nombreSala, capacidad, idSede);
            
            JOptionPane.showMessageDialog(this, "Sala creada con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
            
            this.dispose();
        }
    }//GEN-LAST:event_btn_Crear_salaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Crear_sala;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JTextField campo_Capacidad_sala;
    private javax.swing.JTextField campo_Nombre_sala;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

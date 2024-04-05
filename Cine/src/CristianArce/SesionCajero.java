package CristianArce;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.List;
import utils.Cine;
import utils.Asiento;
import utils.CristianBD;
import utils.Pelicula;
import utils.Sala;

public class SesionCajero extends javax.swing.JFrame {
    CristianBD bd;
    public SesionCajero(CristianBD bd) {
        this.bd = bd;
        initComponents();
        initAlterComponents();
        
    }
    
    public void initAlterComponents(){
        
        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("imagenes/iconoPrincipal.png")));
        setTitle("Menu Cajero");
        setResizable(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        List<Pelicula> lista_peliculas = bd.obtenerTodasLasPeliculas();
        List<Asiento> lista_asientos = bd.obtenerAsientos();
        List<Sala> lista_salas = bd.obtenerSalas();
        
        for (Pelicula pelicula : lista_peliculas) {
             seleccionar_pelicula.addItem(pelicula.getTitulo());
        }
        
        for (Asiento asiento : lista_asientos) {
            seleccionar_asiento.addItem(String.valueOf(asiento.getNumero()));
        }
        
        for (Sala sala : lista_salas) {
            seleccionar_sala.addItem(sala.getNombre());
        }
  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        seleccionar_pelicula = new javax.swing.JComboBox<>();
        seleccionar_sala = new javax.swing.JComboBox<>();
        seleccionar_asiento = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        etq_mostrar_asiento = new javax.swing.JLabel();
        etq_mostrar_sala = new javax.swing.JLabel();
        etq_mostrar_hora = new javax.swing.JLabel();
        etq_mostrar_pelicula = new javax.swing.JLabel();
        etq_mostrar_asiento1 = new javax.swing.JLabel();
        etq_mostrar_asiento2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Hacer reembolso");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 610, -1));

        jPanel11.setBackground(new java.awt.Color(204, 204, 204));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel12.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 22));

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 240, 60));

        jPanel13.setBackground(new java.awt.Color(204, 204, 204));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Ingrese ID de la factura");
        jPanel13.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 210, -1));

        jPanel11.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 60));

        jPanel4.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 510, 60));

        jButton3.setBackground(new java.awt.Color(102, 0, 102));
        jButton3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("IMPRIMIR FACTURA");
        jButton3.setBorder(null);
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 200, 40));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 610, 210));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Crear factura");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 610, -1));

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Seleccionar asiento");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Seleccionar sala");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 200, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Seleccionar pelicula");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 40));

        seleccionar_pelicula.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel2.add(seleccionar_pelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 200, 40));

        seleccionar_sala.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel2.add(seleccionar_sala, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 200, 40));

        seleccionar_asiento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel2.add(seleccionar_asiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 200, 40));

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 510, 140));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Factura:");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etq_mostrar_asiento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etq_mostrar_asiento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etq_mostrar_asiento.setText("ID");
        jPanel8.add(etq_mostrar_asiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 210, -1));

        etq_mostrar_sala.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etq_mostrar_sala.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etq_mostrar_sala.setText("Sala");
        jPanel8.add(etq_mostrar_sala, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 210, -1));

        etq_mostrar_hora.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etq_mostrar_hora.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etq_mostrar_hora.setText("Hora");
        jPanel8.add(etq_mostrar_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 210, -1));

        etq_mostrar_pelicula.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etq_mostrar_pelicula.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etq_mostrar_pelicula.setText("Pelicula");
        jPanel8.add(etq_mostrar_pelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 210, -1));

        etq_mostrar_asiento1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etq_mostrar_asiento1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etq_mostrar_asiento1.setText("Asiento");
        jPanel8.add(etq_mostrar_asiento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 210, -1));

        etq_mostrar_asiento2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etq_mostrar_asiento2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etq_mostrar_asiento2.setText("Precio");
        jPanel8.add(etq_mostrar_asiento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 210, -1));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 240, 240));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("ID");
        jPanel9.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 210, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Pelicula");
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 210, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Hora");
        jPanel9.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 210, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Sala");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 210, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Asiento");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 210, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Precio");
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 210, -1));

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 240));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 510, -1));

        jButton2.setBackground(new java.awt.Color(102, 0, 102));
        jButton2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("IMPRIMIR FACTURA");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 600, 200, 40));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 610, 680));

        jButton4.setBackground(new java.awt.Color(0, 51, 153));
        jButton4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Vista de asientos");
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 200, 40));

        jButton5.setBackground(new java.awt.Color(204, 0, 0));
        jButton5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Cerrar sesión");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_cajero.jpg"))); // NOI18N
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, 610, 320));

        fondo.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1240, 680));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etq_mostrar_asiento;
    private javax.swing.JLabel etq_mostrar_asiento1;
    private javax.swing.JLabel etq_mostrar_asiento2;
    private javax.swing.JLabel etq_mostrar_hora;
    private javax.swing.JLabel etq_mostrar_pelicula;
    private javax.swing.JLabel etq_mostrar_sala;
    private javax.swing.JPanel fondo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> seleccionar_asiento;
    private javax.swing.JComboBox<String> seleccionar_pelicula;
    private javax.swing.JComboBox<String> seleccionar_sala;
    // End of variables declaration//GEN-END:variables

    private List<Pelicula> obtenerTodasLasPeliculas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

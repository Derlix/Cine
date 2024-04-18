package CristianArce;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Connection;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement; 
import utils.BaseDatos_ChristianArias;

/**
 *
 * @author chris
 */
public class ReservacionesAsientos extends javax.swing.JFrame {

    BaseDatos_ChristianArias db;
    public ReservacionesAsientos(BaseDatos_ChristianArias db) {
        this.db = db;
        initComponents();
        setLocationRelativeTo(null);
        botones();
        setVisible(true);
        mantenerAsientosOcupados();
        componentesAlternos();
    }

    public void componentesAlternos(){
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        Image icono_disponible = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/sillanull.png"));
        icono_disponible = icono_disponible.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        botonejemploDisponible.setIcon(new ImageIcon(icono_disponible));
        
        Image icono_ocupado = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/sillavendida.png"));
        icono_ocupado = icono_ocupado.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        botonejemploOcupado.setIcon(new ImageIcon(icono_ocupado));
        
        botonejemploDisponible.setContentAreaFilled(false);
        botonejemploDisponible.setBorderPainted(false);
        
        botonejemploOcupado.setContentAreaFilled(false);
        botonejemploOcupado.setBorderPainted(false);
        Pantalla.setBorderPainted(false);
        Pantalla.setContentAreaFilled(false);
        
        Image icono= getToolkit().createImage(ClassLoader.getSystemResource("imagenes/pantalla.png"));
        icono = icono.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Pantalla.setIcon(new ImageIcon(icono));
        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("imagenes/iconoPrincipal.png")));
        setTitle("Reservacion de Asientos ");
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    String rutaImg = "imgs/icon.png";
    //
    int filas = 5;
    int columnas = 7;
    int anchoboton =90;
    int largoboton = 50;
    int ejeX = 20;
    int ejeY = 20;
    
    public static Connection conexion;
    public static PreparedStatementWrapper sentenciaPreparada;
    public static ResultSet resultado;
     
    public JToggleButton [][] DimensionBotones = new JToggleButton[filas][columnas];
    
    //Las filas son las que van hacia la derecha = horizontal
    //Las columnas son las que van a ir hacia abajo = verticalmente
    
    public void botones(){
        Font Fuenteletra = new Font("Arial",Font.BOLD,12);
        int contadorDeAsientos = 1;
        DimensionBotones = new JToggleButton[filas][columnas];
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                
                DimensionBotones[i][j]= new JToggleButton();
                DimensionBotones[i][j].setBounds(ejeX,ejeY,anchoboton,largoboton);
                DimensionBotones[i][j].setText("Asiento"+contadorDeAsientos);
                DimensionBotones[i][j].setFont(Fuenteletra);
                
                
                
                
                
                Image icono_etqImagen = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/sillanull.png"));
                icono_etqImagen = icono_etqImagen.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                DimensionBotones[i][j].setIcon(new ImageIcon(icono_etqImagen));
               
                
                DimensionBotones[i][j].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                
                DimensionBotones[i][j].setContentAreaFilled(false);
                DimensionBotones[i][j].setBorderPainted(false);
                accionbotones accion = new accionbotones();
                DimensionBotones[i][j].addActionListener(accion);
                PanelPrincipal.add(DimensionBotones[i][j]);
                ejeX += 100;//separacion entre columnas
                contadorDeAsientos ++;
            }
            ejeX=20;// devolver el ejeX a su posicion inicial
            ejeY += 60;//separacion de los boton en cuanto a filas
            
        }
        
        
    }
    
   public void reservarAsiento(int numeroAsiento){
    try {
        conexion = (Connection) db.conectar();
        String consulta = "UPDATE Asientos_funciones SET ID_Venta = ? WHERE ID_Asiento = ? AND ID_Venta IS NULL";
        PreparedStatement sentenciaPreparada = conexion.prepareStatement(consulta);
        // En lugar de usar el número de asiento, usamos el ID_Asiento
        sentenciaPreparada.setInt(1, obtenerIdVenta());
        sentenciaPreparada.setInt(2, numeroAsiento);
        int mensaje = sentenciaPreparada.executeUpdate();

        if(mensaje > 0){
            JOptionPane.showMessageDialog(null,"Asiento reservado correctamente");
        } else {
            JOptionPane.showMessageDialog(null,"El asiento ya está reservado");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL: " + e.getMessage());
    } finally {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservacionesAsientos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
        }
    }
}
    
    public void quitarReservacionAsiento(int numeroAsiento){
    try {
        conexion = (Connection) db.conectar();

        String consulta = "UPDATE Asientos_funciones SET ID_Venta = NULL WHERE ID_Asiento = ?";
        PreparedStatement sentenciaPreparada = conexion.prepareStatement(consulta);
        sentenciaPreparada.setInt(1, numeroAsiento);
        int mensaje = sentenciaPreparada.executeUpdate();

        if(mensaje > 0){
            JOptionPane.showMessageDialog(null,"Reserva del asiento cancelada");
        } else {
            JOptionPane.showMessageDialog(null,"Error al cancelar la reserva del asiento");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL: " + e.getMessage());
    } finally {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservacionesAsientos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
        }
    }
}


    
    
    
    public class accionbotones implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if(e.getSource().equals(DimensionBotones[i][j])){
                        if (DimensionBotones[i][j].isSelected()) {
                            Image icono_etqImagen = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/sillavendida.png"));
                            icono_etqImagen = icono_etqImagen.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                            DimensionBotones[i][j].setIcon(new ImageIcon(icono_etqImagen));
                            
                            
                            String textoBton = DimensionBotones[i][j].getText();
                            int numeroAsiento = Integer.parseInt(textoBton.split("Asiento")[1]);
                            reservarAsiento(numeroAsiento);
                        }else{
                            Image icono_etqImagen = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/sillanull.png"));
                            icono_etqImagen = icono_etqImagen.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                            DimensionBotones[i][j].setIcon(new ImageIcon(icono_etqImagen));
                            String textoBton = DimensionBotones[i][j].getText();
                            int numeroAsiento = Integer.parseInt(textoBton.split("Asiento")[1]);
                            quitarReservacionAsiento(numeroAsiento);
                        
                        }
                    }
                }
                
            }
            
        }
        
        
    }
    
    public void mantenerAsientosOcupados() {
    try {
        conexion = db.conectar();
        String consulta = "SELECT ID_Asiento, ID_Venta FROM Asientos_funciones";
        PreparedStatement sentenciaPreparada = conexion.prepareStatement(consulta);
        resultado = sentenciaPreparada.executeQuery();

        int numeroAsiento;
        int idVenta;

        while (resultado.next()) {
            numeroAsiento = resultado.getInt("ID_Asiento");
            idVenta = resultado.getInt("ID_Venta");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    String textoBton = DimensionBotones[i][j].getText();
                    int numeroAsientoN = Integer.parseInt(textoBton.split("Asiento")[1]);
                    if (numeroAsiento == numeroAsientoN) {
                        if (idVenta != 0) {
                            // El asiento está ocupado
                            Image icono_etqImagen = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/sillavendida.png"));
                            icono_etqImagen = icono_etqImagen.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                            DimensionBotones[i][j].setIcon(new ImageIcon(icono_etqImagen));
                            DimensionBotones[i][j].setEnabled(false); // Deshabilitar el botón para que no se pueda seleccionar
                            DimensionBotones[i][j].setContentAreaFilled(false); // Quitar el fondo del botón
                            DimensionBotones[i][j].setBorderPainted(false); // Quitar el borde del botón
                        } else {
                            // El asiento está disponible
                            Image icono_etqImagen = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/sillanull.png"));
                            icono_etqImagen = icono_etqImagen.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                            DimensionBotones[i][j].setIcon(new ImageIcon(icono_etqImagen));
                            DimensionBotones[i][j].setEnabled(true); // Habilitar el botón para que se pueda seleccionar
                            DimensionBotones[i][j].setContentAreaFilled(true); // Restaurar el fondo del botón
                            DimensionBotones[i][j].setBorderPainted(true); // Restaurar el borde del botón
                        }
                    }
                }
            }
        }
    } catch (SQLException e) {
        System.out.println("Error" + e);
    }
}

    
    private int obtenerIdVenta() {
    int idVenta = 0;
    try {
        conexion = (Connection) db.conectar();
        String consulta = "SELECT ID_Venta FROM Asientos_funciones WHERE ID_Venta IS NULL LIMIT 1";
        PreparedStatement sentenciaPreparada = conexion.prepareStatement(consulta);
        ResultSet resultado = sentenciaPreparada.executeQuery();
        if (resultado.next()) {
            idVenta = resultado.getInt("ID_Venta");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener el ID de venta: " + e.getMessage());
    } finally {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservacionesAsientos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
        }
    }
    return idVenta;
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        Pantalla = new javax.swing.JToggleButton();
        PanelEjemplos = new javax.swing.JPanel();
        botonejemploDisponible = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        botonejemploOcupado = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        PanelPrincipal.setBackground(java.awt.SystemColor.activeCaption);

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(336, Short.MAX_VALUE)
                .addComponent(Pantalla, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelEjemplos.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Asiento Disponible");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Asiento Ocupado");

        javax.swing.GroupLayout PanelEjemplosLayout = new javax.swing.GroupLayout(PanelEjemplos);
        PanelEjemplos.setLayout(PanelEjemplosLayout);
        PanelEjemplosLayout.setHorizontalGroup(
            PanelEjemplosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEjemplosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonejemploDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonejemploOcupado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(43, 43, 43))
        );
        PanelEjemplosLayout.setVerticalGroup(
            PanelEjemplosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEjemplosLayout.createSequentialGroup()
                .addGroup(PanelEjemplosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEjemplosLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(PanelEjemplosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonejemploOcupado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonejemploDisponible, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelEjemplosLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel1))
                    .addGroup(PanelEjemplosLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel2)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelEjemplos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelEjemplos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelEjemplos;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JToggleButton Pantalla;
    private javax.swing.JToggleButton botonejemploDisponible;
    private javax.swing.JToggleButton botonejemploOcupado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}

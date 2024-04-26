package CristianArce;

import ChristianArias.ImagenDeFondoPanel;
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
import java.util.ArrayList;
import java.util.List;
import utils.BaseDatos_ChristianArias;

import utils.Funcion;

public class ReservacionesAsientos extends javax.swing.JFrame {

    BaseDatos_ChristianArias db;
    int funcion;
    int cantidadBoletos;
    public static ArrayList<Integer> asientosSeleccionados = new ArrayList<>();

    public ReservacionesAsientos(BaseDatos_ChristianArias db, int funcion, int cantidadBoletos) {
        PanelPrincipal = new ImagenDeFondoPanel("imagenes/fondoPrin.jpg");
        this.funcion = funcion;
        this.db = db;
        this.cantidadBoletos = cantidadBoletos;
        initComponents();
        setLocationRelativeTo(null);
        botones();
        setVisible(true);
        mantenerAsientosOcupados(funcion);
        componentesAlternos();
        asientosSeleccionados.clear();
        int cantidadAsientos = db.obtenerCapacidadSala(funcion);
        numeroDeasientos.setText("Cantidad de Asientos: " + cantidadAsientos);
    }

    public void componentesAlternos() {
       

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Reservación de Asientos");

        // Configuración de la pantalla
        Image iconoPantalla = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/pantalla.png"));
        iconoPantalla = iconoPantalla.getScaledInstance(700, 80, Image.SCALE_SMOOTH);
        Pantalla.setIcon(new ImageIcon(iconoPantalla));
        Pantalla.setBorderPainted(false);
        Pantalla.setContentAreaFilled(false);

        // Configuración de los botones de ejemplo
        Image iconoDisponible = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/sillanull.png"));
        iconoDisponible = iconoDisponible.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        botonejemploDisponible.setIcon(new ImageIcon(iconoDisponible));
        botonejemploDisponible.setContentAreaFilled(false);
        botonejemploDisponible.setBorderPainted(false);

        Image iconoOcupado = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/sillavendida.png"));
        iconoOcupado = iconoOcupado.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        botonejemploOcupado.setIcon(new ImageIcon(iconoOcupado));
        botonejemploOcupado.setContentAreaFilled(false);
        botonejemploOcupado.setBorderPainted(false);

        // Estilos de texto y panel
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 18));
        jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        jLabel3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        numeroDeasientos.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        // Colores de fondo y texto
        PanelPrincipal.setBackground(new Color(25, 24, 24));
        PanelEjemplos.setBackground(new Color(60, 63, 65));
        jLabel1.setForeground(new Color(180, 180, 180));
        jLabel2.setForeground(new Color(180, 180, 180));
        jLabel3.setForeground(new Color(255, 203, 5));
        numeroDeasientos.setForeground(new Color(255, 203, 5));
        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("imagenes/iconoPrincipal.png")));

    }

    String rutaImg = "imgs/icon.png";
    //
    int filas = 5;
    int columnas = 7;
    int anchoboton = 90;
    int largoboton = 50;
    int ejeX = 20;
    int ejeY = 20;
    int limite = 0;
    public static Connection conexion;
    public static PreparedStatementWrapper sentenciaPreparada;
    public static ResultSet resultado;

    public JToggleButton[][] DimensionBotones = new JToggleButton[filas][columnas];

    //Las filas son las que van hacia la derecha = horizontal
    //Las columnas son las que van a ir hacia abajo = verticalmente
    public void botones() {
        Font Fuenteletra = new Font("Arial", Font.BOLD, 12);
        int contadorDeAsientos = 1;
        DimensionBotones = new JToggleButton[filas][columnas];
        int asientosDisponibles = filas * columnas;
        char letraFila = 'A';
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                DimensionBotones[i][j] = new JToggleButton();
                DimensionBotones[i][j].setBounds(ejeX, ejeY, anchoboton, largoboton);
                DimensionBotones[i][j].setText("Asiento" + contadorDeAsientos);
                DimensionBotones[i][j].setForeground(new Color(25, 24, 24));

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

                if (asientosDisponibles <= 0) {
                    DimensionBotones[i][j].setEnabled(false); // Deshabilitar el botón si no hay asientos disponibles
                }
                if (limite >= cantidadBoletos) {
                    DimensionBotones[i][j].setEnabled(false);
                }
                contadorDeAsientos++;
            }
            letraFila++;
            ejeX = 20;// devolver el ejeX a su posicion inicial
            ejeY += 60;//separacion de los boton en cuanto a filas

        }

    }

    public static List<Integer> getAsientosSeleccionados() {
        return asientosSeleccionados;
    }

    public void reservarAsiento(int numeroAsiento) {
        try {
            conexion = (Connection) db.conectar();
            String consulta = "INSERT INTO Asientos_funciones (ID_Funcion, ID_Asiento) VALUES (?, ?)";
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(consulta);

            sentenciaPreparada.setInt(1, funcion); // Utilizamos el atributo funcion
            sentenciaPreparada.setInt(2, numeroAsiento);

            int mensaje = sentenciaPreparada.executeUpdate();

            if (mensaje > 0) {
                JOptionPane.showMessageDialog(null, "Asiento reservado correctamente");
                limite--;
            } else {
                JOptionPane.showMessageDialog(null, "El asiento ya está reservado");
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

    public void quitarReservacionAsiento(int numeroAsiento) {
        Connection conexion = null;
        try {
            conexion = db.conectar(); // Supongo que bd es tu instancia de CristianBD
            String consulta = "DELETE FROM Asientos_funciones WHERE ID_Funcion = ? AND ID_Asiento = ?";
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(consulta);

            sentenciaPreparada.setInt(1, funcion); // Utilizamos el ID de la función almacenado en tu clase
            sentenciaPreparada.setInt(2, numeroAsiento);

            int resultado = sentenciaPreparada.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Reserva del asiento eliminada correctamente");
                limite++;
            } else {
                JOptionPane.showMessageDialog(null, "La reserva del asiento no existe");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL: " + e.getMessage());
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SesionCajero.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
                }
            }
        }
    }

    int asientosReservados = 0;

    public class accionbotones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (e.getSource().equals(DimensionBotones[i][j])) {
                        if (DimensionBotones[i][j].isSelected()) {
                            if (asientosReservados < cantidadBoletos) {
                                Image icono_etqImagen = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/sillavendida.png"));
                                icono_etqImagen = icono_etqImagen.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                                DimensionBotones[i][j].setIcon(new ImageIcon(icono_etqImagen));

                                String textoBton = DimensionBotones[i][j].getText();
                                int numeroAsiento = Integer.parseInt(textoBton.split("Asiento")[1]);
                                asientosSeleccionados.add(numeroAsiento);
                                reservarAsiento(numeroAsiento);
                                asientosReservados++;
                            } else {
                                JOptionPane.showMessageDialog(null, "Has alcanzado el límite de asientos reservados.");
                                DimensionBotones[i][j].setSelected(false);
                            }
                        } else {
                            Image icono_etqImagen = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/sillanull.png"));
                            icono_etqImagen = icono_etqImagen.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                            DimensionBotones[i][j].setIcon(new ImageIcon(icono_etqImagen));
                            String textoBton = DimensionBotones[i][j].getText();
                            int numeroAsiento = Integer.parseInt(textoBton.split("Asiento")[1]);
                            quitarReservacionAsiento(numeroAsiento);
                            asientosSeleccionados.remove(Integer.valueOf(numeroAsiento));
                            asientosReservados--;
                        }
                    }
                }
            }
        }

    }

    public void mantenerAsientosOcupados(int funcion) {
        try {
            conexion = db.conectar();
            String consulta = "SELECT ID_Asiento, ID_Venta FROM Asientos_funciones WHERE ID_Funcion = ?";
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(consulta);
            sentenciaPreparada.setInt(1, funcion); // Especifica la función

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

    public int obtenerCantidadAsientos(int funcion) {
        int cantidadAsientos = 0;
        try {
            conexion = db.conectar();
            String consulta = "SELECT COUNT(*) AS cantidad FROM Asientos_funciones WHERE ID_Funcion = ?";
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(consulta);
            sentenciaPreparada.setInt(1, funcion);

            ResultSet resultado = sentenciaPreparada.executeQuery();

            if (resultado.next()) {
                cantidadAsientos = resultado.getInt("cantidad");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la cantidad de asientos: " + e.getMessage());
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }
        return cantidadAsientos;
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
        numeroDeasientos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        PanelPrincipal.setBackground(new java.awt.Color(86, 52, 52));

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
        jLabel2.setText("Asiento Seleccionado");

        numeroDeasientos.setText("jLabel3");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Asientos Grises son asientos ya vendidos");

        javax.swing.GroupLayout PanelEjemplosLayout = new javax.swing.GroupLayout(PanelEjemplos);
        PanelEjemplos.setLayout(PanelEjemplosLayout);
        PanelEjemplosLayout.setHorizontalGroup(
            PanelEjemplosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEjemplosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEjemplosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelEjemplosLayout.createSequentialGroup()
                        .addGroup(PanelEjemplosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelEjemplosLayout.createSequentialGroup()
                                .addComponent(botonejemploDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelEjemplosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelEjemplosLayout.createSequentialGroup()
                                        .addGap(184, 184, 184)
                                        .addComponent(botonejemploOcupado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelEjemplosLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel1)
                                        .addGap(184, 184, 184)
                                        .addComponent(jLabel2))))
                            .addComponent(numeroDeasientos))
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelEjemplosLayout.setVerticalGroup(
            PanelEjemplosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEjemplosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(numeroDeasientos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelEjemplosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonejemploOcupado, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelEjemplosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(botonejemploDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEjemplosLayout.createSequentialGroup()
                            .addGroup(PanelEjemplosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(23, 23, 23))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel numeroDeasientos;
    // End of variables declaration//GEN-END:variables
}

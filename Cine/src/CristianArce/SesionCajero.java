package CristianArce;

import ChristianArias.MenuCajero;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.List;
import utils.Cine;
import utils.Asiento;
import utils.CristianBD;
import utils.Funcion;
import utils.Pelicula;
import utils.Sala;
import utils.Usuario;
import CristianArce.ItemCombo;
import static CristianArce.ReservacionesAsientos.conexion;
import utils.BaseDatos_ChristianArias;
import CristianArce.Venta;
import Principal.InicioSesion;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import utils.BaseDatosJuanBustamante;
import utils.BaseDatosJuanPrincipal;

public class SesionCajero extends javax.swing.JFrame {

    private List<Integer> asientosSeleccionados = new ArrayList<>();
    CristianBD bd;
    List<String> meses_disponibles = new ArrayList<>();
    List<String> dias_disponibles = new ArrayList<>();
    int id_pelicula;
    int id_funcion;
    int id_usuario;
    int cantidad_boletos;
    int total_venta;
    int id_venta;
    Usuario usuario;
    BaseDatos_ChristianArias db = new BaseDatos_ChristianArias();

    public SesionCajero(CristianBD bd, Usuario usuario) {

        this.usuario = usuario;
        id_usuario = usuario.getIdUsuario();
        this.bd = bd;
        initComponents();
        initAlterComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        botonDesactivar();
    }

    public void initAlterComponents() {
        obtener_meses();
        seleccionar_pelicula.setEnabled(false);

        seleccionar_mes.addItem("Mes");
        seleccionar_dia.addItem("Día");
        
        btn_imprimir_factura.setEnabled(false);

        for (String mes : meses_disponibles) {
            seleccionar_mes.addItem(mes);
        }

        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("imagenes/iconoPrincipal.png")));
        setTitle("Menu Cajero");
        setResizable(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void botonDesactivar() {
        seleccionar_cantidad.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int cantidadSeleccionada = (int) seleccionar_cantidad.getValue();
                if (cantidadSeleccionada > 0) {
                    BotonSeleccionarAsiento.setEnabled(true);
                } else {
                    BotonSeleccionarAsiento.setEnabled(false);
                }
            }
        });
    }

    public void obtener_meses() {
        meses_disponibles.clear();
        List<Funcion> lista_funciones = bd.obtenerFunciones();
        List<Pelicula> lista_peliculas = bd.obtenerTodasLasPeliculas();
        for (Funcion funcion : lista_funciones) {
            for (Pelicula pelicula : lista_peliculas) {
                if (funcion.getId_pelicula() == pelicula.getIdPelicula()) {
                    String fecha = funcion.getFecha();
                    String[] fecha_separada = fecha.split("-");
                    String mes = fecha_separada[1];
                    if (!meses_disponibles.contains(mes)) {
                        meses_disponibles.add(mes);
                    }
                }
            }
        }
    }

    public void limpiar_factura() {
        seleccionar_cantidad.setValue(1);
        etq_pelicula.setText("");
        etq_hora.setText("");
        etq_sala.setText("");
        etq_asiento.setText("");
        etq_precio.setText("");
        etq_cantidad.setText("");
        etq_id.setText("");
        etq_valor_total.setText("");

        etq_mostrar_pelicula.setText("");
        etq_mostrar_hora.setText("");
        etq_mostrar_sala.setText("");
        etq_mostrar_asiento.setText("");
        etq_mostrar_precio.setText("");
        etq_mostrar_cantidad.setText("");
        etq_mostrar_id.setText("");
        etq_mostrar_valor_total.setText("");
    }

    public void setAsientosSeleccionados(List<Integer> asientosSeleccionados) {
        this.asientosSeleccionados = asientosSeleccionados;
    }

    public void obtener_dias(String mes_seleccionado) {
        dias_disponibles.clear();
        seleccionar_dia.removeAllItems();
        seleccionar_dia.addItem("Día");
        List<Funcion> lista_funciones = bd.obtenerFunciones();
        List<Pelicula> lista_peliculas = bd.obtenerTodasLasPeliculas();
        for (Funcion funcion : lista_funciones) {
            for (Pelicula pelicula : lista_peliculas) {
                if (funcion.getId_pelicula() == pelicula.getIdPelicula()) {

                    String fecha = funcion.getFecha();
                    String[] fecha_separada = fecha.split("-");

                    if (fecha_separada[1].equals(mes_seleccionado)) {
                        String dia = fecha_separada[2];
                        if (!dias_disponibles.contains(dia)) {
                            dias_disponibles.add(dia);
                        }
                    }
                }
            }
        }

        for (String dia : dias_disponibles) {
            seleccionar_dia.addItem(dia);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        seleccionar_mes = new javax.swing.JComboBox<>();
        seleccionar_dia = new javax.swing.JComboBox<>();
        seleccionar_pelicula = new javax.swing.JComboBox<>();
        BotonSeleccionarAsiento = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        etq_mostrar_id = new javax.swing.JLabel();
        etq_mostrar_sala = new javax.swing.JLabel();
        etq_mostrar_hora = new javax.swing.JLabel();
        etq_mostrar_pelicula = new javax.swing.JLabel();
        etq_mostrar_asiento = new javax.swing.JLabel();
        etq_mostrar_precio = new javax.swing.JLabel();
        etq_mostrar_cantidad = new javax.swing.JLabel();
        etq_mostrar_valor_total = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        etq_pelicula = new javax.swing.JLabel();
        etq_hora = new javax.swing.JLabel();
        etq_sala = new javax.swing.JLabel();
        etq_asiento = new javax.swing.JLabel();
        etq_id = new javax.swing.JLabel();
        etq_cantidad = new javax.swing.JLabel();
        etq_precio = new javax.swing.JLabel();
        etq_valor_total = new javax.swing.JLabel();
        seleccionar_cantidad = new javax.swing.JSpinner();
        btn_generar = new javax.swing.JButton();
        btn_imprimir_factura = new javax.swing.JButton();
        btn_cancelar_factura = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btn_reembolso = new javax.swing.JButton();
        btn_cancelar_factura2 = new javax.swing.JButton();
        campo_id_reembolso = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Seleccionar pelicula");
        jLabel2.setPreferredSize(new java.awt.Dimension(160, 24));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 200, 40));

        seleccionar_mes.setPreferredSize(new java.awt.Dimension(72, 24));
        seleccionar_mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionar_mesActionPerformed(evt);
            }
        });
        jPanel2.add(seleccionar_mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 80, 40));

        seleccionar_dia.setPreferredSize(new java.awt.Dimension(72, 24));
        seleccionar_dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionar_diaActionPerformed(evt);
            }
        });
        jPanel2.add(seleccionar_dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 80, 40));

        seleccionar_pelicula.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        seleccionar_pelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionar_peliculaActionPerformed(evt);
            }
        });
        jPanel2.add(seleccionar_pelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 510, 40));

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 510, 130));

        BotonSeleccionarAsiento.setBackground(new java.awt.Color(0, 0, 153));
        BotonSeleccionarAsiento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        BotonSeleccionarAsiento.setForeground(new java.awt.Color(255, 255, 255));
        BotonSeleccionarAsiento.setText("Seleccionar Asiento Graficamente");
        BotonSeleccionarAsiento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BotonSeleccionarAsiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonSeleccionarAsiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSeleccionarAsientoActionPerformed(evt);
            }
        });
        jPanel5.add(BotonSeleccionarAsiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 340, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Cantidad");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 90, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etq_mostrar_id.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etq_mostrar_id.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel8.add(etq_mostrar_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 210, 22));

        etq_mostrar_sala.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etq_mostrar_sala.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel8.add(etq_mostrar_sala, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 210, 22));

        etq_mostrar_hora.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etq_mostrar_hora.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel8.add(etq_mostrar_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 210, 22));

        etq_mostrar_pelicula.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etq_mostrar_pelicula.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel8.add(etq_mostrar_pelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 210, 22));

        etq_mostrar_asiento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etq_mostrar_asiento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel8.add(etq_mostrar_asiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 210, 22));

        etq_mostrar_precio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etq_mostrar_precio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel8.add(etq_mostrar_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 210, 22));

        etq_mostrar_cantidad.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etq_mostrar_cantidad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel8.add(etq_mostrar_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 210, 22));

        etq_mostrar_valor_total.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etq_mostrar_valor_total.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel8.add(etq_mostrar_valor_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 210, -1));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 240, 250));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etq_pelicula.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etq_pelicula.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel9.add(etq_pelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 210, 22));

        etq_hora.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etq_hora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel9.add(etq_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 210, 22));

        etq_sala.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etq_sala.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel9.add(etq_sala, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 210, 22));

        etq_asiento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etq_asiento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel9.add(etq_asiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 210, 22));

        etq_id.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etq_id.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel9.add(etq_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 210, 22));

        etq_cantidad.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etq_cantidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel9.add(etq_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 210, 22));

        etq_precio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etq_precio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel9.add(etq_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 210, 22));

        etq_valor_total.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        etq_valor_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel9.add(etq_valor_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 210, 22));

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 250));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 510, 250));

        seleccionar_cantidad.setModel(new javax.swing.SpinnerNumberModel(1, null, null, 1));
        seleccionar_cantidad.setFocusable(false);
        jPanel5.add(seleccionar_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 60, 40));

        btn_generar.setBackground(new java.awt.Color(102, 102, 102));
        btn_generar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_generar.setForeground(new java.awt.Color(255, 255, 255));
        btn_generar.setText("Generar");
        btn_generar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generarActionPerformed(evt);
            }
        });
        jPanel5.add(btn_generar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 150, 40));

        btn_imprimir_factura.setBackground(new java.awt.Color(0, 153, 51));
        btn_imprimir_factura.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_imprimir_factura.setForeground(new java.awt.Color(255, 255, 255));
        btn_imprimir_factura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_imprimir_factura.setLabel("Imprimir factura");
        btn_imprimir_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimir_facturaActionPerformed(evt);
            }
        });
        jPanel5.add(btn_imprimir_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 620, 200, 40));

        btn_cancelar_factura.setBackground(new java.awt.Color(102, 102, 102));
        btn_cancelar_factura.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_cancelar_factura.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar_factura.setText("Cancelar");
        btn_cancelar_factura.setActionCommand("");
        btn_cancelar_factura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cancelar_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar_facturaActionPerformed(evt);
            }
        });
        jPanel5.add(btn_cancelar_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 150, 40));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 610, 680));

        jButton5.setBackground(new java.awt.Color(204, 0, 0));
        jButton5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Regresar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_cajero.jpg"))); // NOI18N
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, 610, 320));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Hacer reembolso");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 610, -1));

        btn_reembolso.setBackground(new java.awt.Color(0, 153, 51));
        btn_reembolso.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_reembolso.setForeground(new java.awt.Color(255, 255, 255));
        btn_reembolso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_reembolso.setLabel("Hacer reembolso");
        btn_reembolso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reembolsoActionPerformed(evt);
            }
        });
        jPanel4.add(btn_reembolso, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 200, 40));

        btn_cancelar_factura2.setBackground(new java.awt.Color(204, 0, 0));
        btn_cancelar_factura2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btn_cancelar_factura2.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar_factura2.setText("Cancelar");
        btn_cancelar_factura2.setActionCommand("");
        btn_cancelar_factura2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cancelar_factura2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar_factura2ActionPerformed(evt);
            }
        });
        jPanel4.add(btn_cancelar_factura2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, 200, 40));
        jPanel4.add(campo_id_reembolso, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 100, 40));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Ingrese ID de la factura");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 200, 40));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 610, 280));

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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de cerrar sesion?", "Cerrar aplicación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            // Cerrar la aplicación
            CristianBD bd = new CristianBD();
            MenuCajero ventana = new MenuCajero(bd, usuario);
            this.dispose();
            
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    private void seleccionar_mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionar_mesActionPerformed
        String mes = (String) seleccionar_mes.getSelectedItem();
        obtener_dias(mes);
    }//GEN-LAST:event_seleccionar_mesActionPerformed

    private void seleccionar_diaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionar_diaActionPerformed

        seleccionar_pelicula.removeAllItems();

        String dia_seleccionado = (String) seleccionar_dia.getSelectedItem();
        String mes_seleccionado = (String) seleccionar_mes.getSelectedItem();

        Boolean pelicula_encontrada = false;

        if (dia_seleccionado != null && mes_seleccionado != null) {
            if (!dia_seleccionado.equals("Día") && !mes_seleccionado.equals("Mes")) {
                pelicula_encontrada = true;

            }
        }

        if (pelicula_encontrada) {

            List<Funcion> lista_funciones = bd.obtenerFunciones();
            List<Pelicula> lista_peliculas = bd.obtenerTodasLasPeliculas();

            for (Funcion funcion : lista_funciones) {
                for (Pelicula pelicula : lista_peliculas) {
                    if (funcion.getId_pelicula() == pelicula.getIdPelicula()) {

                        String fecha = funcion.getFecha();
                        String[] fecha_separada = fecha.split("-");

                        String dia = fecha_separada[2];
                        String mes = fecha_separada[1];

                        if (dia_seleccionado.equals(dia) && mes_seleccionado.equals(mes)) {
                            ItemCombo item;
                            item = new ItemCombo(pelicula.getIdPelicula(), funcion.getId_funcion(), funcion.getId_sala(), pelicula.getTitulo(), funcion.getHora_inicio(), funcion.getPrecio());
                            seleccionar_pelicula.addItem(item);

                        }
                    }
                }
            }
            seleccionar_pelicula.setEnabled(true);
        } else {
            seleccionar_pelicula.setEnabled(false);
        }
    }//GEN-LAST:event_seleccionar_diaActionPerformed

    public int obtenerFuncionPorId(int funcion) {

        int id = 1;
        return id;
    }
    private void seleccionar_peliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionar_peliculaActionPerformed

    }//GEN-LAST:event_seleccionar_peliculaActionPerformed

    private void BotonSeleccionarAsientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSeleccionarAsientoActionPerformed
        BaseDatos_ChristianArias db = new BaseDatos_ChristianArias();
        ItemCombo item = (ItemCombo) seleccionar_pelicula.getSelectedItem();
        int cantidad_boletoss = (int) seleccionar_cantidad.getValue();
        int id_funcions = item.getId_funcion();
        ReservacionesAsientos reservacionesAsientos = new ReservacionesAsientos(db, id_funcions, cantidad_boletoss);
        reservacionesAsientos.setVisible(true);

    }//GEN-LAST:event_BotonSeleccionarAsientoActionPerformed

    private void btn_generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generarActionPerformed

        ItemCombo item = (ItemCombo) seleccionar_pelicula.getSelectedItem();
        if (item != null) {
            
            etq_pelicula.setText("Pelicula");
            etq_hora.setText("Hora");
            etq_sala.setText("Sala");
            etq_asiento.setText("Asiento");
            etq_precio.setText("Precio");
            etq_cantidad.setText("Cantidad");
            etq_id.setText("id");
            etq_valor_total.setText("Valor total");

            id_pelicula = item.getId_pelicula();
            id_funcion = item.getId_funcion();
            id_venta = bd.ultimo_id_venta() + 1;
            cantidad_boletos = (int) seleccionar_cantidad.getValue();
            total_venta = item.getPrecio() * cantidad_boletos;
            mostrarAsientosSeleccionados();
            etq_mostrar_pelicula.setText(item.getNombre_pelicula() + "");
            etq_mostrar_hora.setText(item.getHora());
            etq_mostrar_sala.setText(item.getId_sala() + "");

            etq_mostrar_precio.setText(item.getPrecio() + "");
            etq_mostrar_cantidad.setText(seleccionar_cantidad.getValue() + "");
            etq_mostrar_id.setText((bd.ultimo_id_venta() + 1) + "");
            etq_mostrar_valor_total.setText((item.getPrecio() * cantidad_boletos) + "");
            
            btn_imprimir_factura.setEnabled(true);

        }
    }//GEN-LAST:event_btn_generarActionPerformed

    private void btn_imprimir_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimir_facturaActionPerformed
        int idVenta = bd.insertarVenta(id_pelicula, id_funcion, id_usuario, cantidad_boletos, total_venta, obtenerFecha());

        if (idVenta != -1) {
            actualizarAsientosConVenta(idVenta);
        } else {
            JOptionPane.showMessageDialog(this, "Error al generar la venta. No se actualizarán los asientos.");
        }

        limpiar_factura();
        btn_imprimir_factura.setEnabled(false);
        this.dispose();
    }//GEN-LAST:event_btn_imprimir_facturaActionPerformed

    private void btn_cancelar_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar_facturaActionPerformed
        limpiar_factura();
        btn_imprimir_factura.setEnabled(false);
    }//GEN-LAST:event_btn_cancelar_facturaActionPerformed

    private void btn_reembolsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reembolsoActionPerformed

        String id = campo_id_reembolso.getText();
        bd.eliminarVenta(id);
        campo_id_reembolso.setText("");
    }//GEN-LAST:event_btn_reembolsoActionPerformed

    private void btn_cancelar_factura2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar_factura2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cancelar_factura2ActionPerformed

    public static String obtenerFecha() {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatoDeseado = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada = fechaActual.format(formatoDeseado);
        return fechaFormateada;
    }

//    public void seleccionarAsientos(int id_sala, int capacidad) {
//        seleccionar_asiento.removeAllItems();
//        List<Asiento> lista_asientos = bd.obtenerAsientos();
//        for (Asiento asiento : lista_asientos) {
//            if (id_sala == asiento.getId()) {
//                for (int i = 1; i <= capacidad; i++) {
//                    seleccionar_asiento.addItem(i);
//                }
//            }
//        }
//    }

    public void abrirventanaAlCerrar() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                InicioSesion ventana = new InicioSesion(bd, bd);
            }
        });
    }

    public void finalizarVenta() {
        int idVenta = bd.ultimo_id_venta();  // Este método debería generar un nuevo ID de venta en la base de datos y retornarlo.
        actualizarAsientosConVenta(idVenta);
    }

    private void actualizarAsientosConVenta(int idVenta) {
        try (Connection conn = db.conectar(); PreparedStatement pstmt = conn.prepareStatement("UPDATE Asientos_funciones SET ID_Venta = ? WHERE ID_Asiento = ?")) {
            for (Integer idAsiento : ReservacionesAsientos.getAsientosSeleccionados()) {
                pstmt.setInt(1, idVenta);
                pstmt.setInt(2, idAsiento);
                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotonSeleccionarAsiento;
    private javax.swing.JButton btn_cancelar_factura;
    private javax.swing.JButton btn_cancelar_factura2;
    private javax.swing.JButton btn_generar;
    private javax.swing.JButton btn_imprimir_factura;
    private javax.swing.JButton btn_reembolso;
    private javax.swing.JTextField campo_id_reembolso;
    private javax.swing.JLabel etq_asiento;
    private javax.swing.JLabel etq_cantidad;
    private javax.swing.JLabel etq_hora;
    private javax.swing.JLabel etq_id;
    private javax.swing.JLabel etq_mostrar_asiento;
    private javax.swing.JLabel etq_mostrar_cantidad;
    private javax.swing.JLabel etq_mostrar_hora;
    private javax.swing.JLabel etq_mostrar_id;
    private javax.swing.JLabel etq_mostrar_pelicula;
    private javax.swing.JLabel etq_mostrar_precio;
    private javax.swing.JLabel etq_mostrar_sala;
    private javax.swing.JLabel etq_mostrar_valor_total;
    private javax.swing.JLabel etq_pelicula;
    private javax.swing.JLabel etq_precio;
    private javax.swing.JLabel etq_sala;
    private javax.swing.JLabel etq_valor_total;
    private javax.swing.JPanel fondo;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSpinner seleccionar_cantidad;
    private javax.swing.JComboBox<String> seleccionar_dia;
    private javax.swing.JComboBox<String> seleccionar_mes;
    private javax.swing.JComboBox<ItemCombo> seleccionar_pelicula;
    // End of variables declaration//GEN-END:variables

    private void mostrarAsientosSeleccionados() {
        List<Integer> asientos = ReservacionesAsientos.getAsientosSeleccionados();
        String asientosStr = asientos.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        etq_mostrar_asiento.setText(asientosStr);
    }

}

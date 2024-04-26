
package ChristianArias;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Component;
import java.awt.FontMetrics;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import utils.BaseDatos_ChristianArias;



public class InformeDetalladoVentas extends javax.swing.JFrame {

    BaseDatos_ChristianArias db;
    public InformeDetalladoVentas(BaseDatos_ChristianArias db) {
        this.db = db;
        initComponents();
        compenentesAlternos();
        mostrar();
        ajustarAnchoColumnas();
    }

    
    public void compenentesAlternos(){
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle(" Informe detallado de ventas ");
        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("imagenes/iconoPrincipal.png")));
    }
    
    public void componentesAlternos(){
    
    }
    
    public void mostrar() {
       setResizable(false);
       setLocationRelativeTo(null);
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_cine", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT p.Titulo AS Nombre_Pelicula, f.ID_Funcion AS Numero_Funcion, u.Nombre_Usuario, v.Cantidad_Boletos, v.Total_Venta, v.Fecha_Venta " +
               "FROM Ventas v " +
               "JOIN Peliculas p ON v.ID_Pelicula = p.ID_Pelicula " +
               "JOIN Funciones f ON v.ID_Funcion = f.ID_Funcion " +
               "JOIN Usuarios u ON v.ID_Usuario = u.ID_Usuario");

            ResultSetMetaData metaData = (ResultSetMetaData) pst.getMetaData();
            int columnCount = metaData.getColumnCount();

            DefaultTableModel model = (DefaultTableModel) Visor.getModel();
            model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
        
            // Limpiar las columnas existentes
            model.setColumnCount(0);
        
            // Agregar columnas al modelo de tabla con nombres personalizados
            model.addColumn("Nombre de Película");
            model.addColumn("Número de Función");
            model.addColumn("Nombre del Usuario");
            model.addColumn("Cantidad de Boletos");
            model.addColumn("Total de Venta");
            model.addColumn("Fecha de Venta");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = rs.getObject(i);
                }
                // Agregar fila al modelo de la tabla
                model.addRow(rowData);
            }
        
            // Ajustar automaticamente el ancho de las columnas
            for (int column = 0; column < Visor.getColumnCount(); column++) {
                TableColumn tableColumn = Visor.getColumnModel().getColumn(column);
                int preferredWidth = tableColumn.getMinWidth();
                int maxWidth = tableColumn.getMaxWidth();
                for (int row = 0; row < Visor.getRowCount(); row++) {
                TableCellRenderer cellRenderer = Visor.getCellRenderer(row, column);
                Component c = Visor.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + Visor.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);
                // Si el ancho excede el máximo, se establece en el máximo
                if (preferredWidth >= maxWidth) {
                    preferredWidth = maxWidth;
                    break;
                }
            }
            tableColumn.setPreferredWidth(preferredWidth);
        }
        } catch (SQLException e) {
            System.out.println("Error al conectar"+ e.getMessage());
        }
    }

    public void ajustarAnchoColumnas() {
    JTableHeader header = Visor.getTableHeader();
    TableColumnModel columnModel = Visor.getColumnModel();

    for (int column = 0; column < Visor.getColumnCount(); column++) {
        TableColumn tableColumn = columnModel.getColumn(column);
        TableCellRenderer headerRenderer = header.getDefaultRenderer();
        if (headerRenderer instanceof JLabel) {
            JLabel label = (JLabel) headerRenderer;
            FontMetrics fontMetrics = label.getFontMetrics(label.getFont());
            int width = fontMetrics.stringWidth(tableColumn.getHeaderValue().toString()) + 10; // Ajuste adicional para el ancho
            tableColumn.setPreferredWidth(width);
        }
    }
}




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Visor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        Visor.setModel(new javax.swing.table.DefaultTableModel(

            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Visor);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
      
      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable Visor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

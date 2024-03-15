package Principal;


import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import utils.Pelicula;
import java.util.List;
import utils.BaseDatosJuanPrincipal;

public class MostrarPeliculas extends javax.swing.JFrame {
    private BaseDatosJuanPrincipal basedatos;

    public MostrarPeliculas(BaseDatosJuanPrincipal basedatos) {
        this.basedatos = basedatos;
        initComponents();
        mostrarPeliculasEnTabla();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void mostrarPeliculasEnTabla() {
        List<Pelicula> peliculas = obtenerPeliculasDesdeBaseDeDatos();
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Título");
        modeloTabla.addColumn("Categoría");
        modeloTabla.addColumn("Restricción Edad");
        modeloTabla.addColumn("Duración");
        modeloTabla.addColumn("País Origen");
        for (Pelicula pelicula : peliculas) {
            Object[] fila = {
                pelicula.getIdPelicula(),
                pelicula.getTitulo(),
                pelicula.getCategoria(),
                pelicula.getRestriccionEdad(),
                pelicula.getDuracion(),
                pelicula.getPaisOrigen(),
            };
            modeloTabla.addRow(fila);
        }

        panel_peliculas.setModel(modeloTabla);
    }



    private List<Pelicula> obtenerPeliculasDesdeBaseDeDatos() {
        List<Pelicula> peliculas = basedatos.obtenerTodasLasPeliculas();
        List<Pelicula> peliculasActivas = new ArrayList<>();

        for (Pelicula pelicula : peliculas) {
            if (pelicula.getEstado().equals("Activo")) {
                peliculasActivas.add(pelicula);
            }
        }

        return peliculasActivas;
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel_peliculas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("LISTA DE PELICULAS DISPONIBLES");

        panel_peliculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(panel_peliculas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(titulo)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable panel_peliculas;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}

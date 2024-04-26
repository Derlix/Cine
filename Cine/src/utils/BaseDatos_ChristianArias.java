package utils;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseDatos_ChristianArias extends BaseDatosJuanPrincipal{
    //Funcionalidades De christian
    Connection conexion;
    Statement manipularDB;
    
    public BaseDatos_ChristianArias(){
        String hostname = "localhost";
        String puerto = "3306";
        String databasename = "bd_cine";
        String user = "root";
        String password = "";
        
        String url = "jdbc:mysql://"+hostname+":"+puerto+"/"+databasename;
        
        try {
            conexion = DriverManager.getConnection(url, user, password);
            manipularDB = conexion.createStatement();
            System.out.println("Conexion exitosa.");
        } catch (SQLException ex) {
            System.out.println("Error en conexion a BD:");
            System.out.println(ex.getMessage());
        }
    }
    public Connection getConn() {
        return conexion;
    }
    
     private static final String URL = "jdbc:mysql://localhost:3306/bd_cine";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection conectar() throws SQLException {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador JDBC: " + e.getMessage());
        }
        return conexion;
    }

    public int obtenerCapacidadSala(int idSala) {
        int capacidad = 0;
        try {
            Connection conexion = conectar();
            String consulta = "SELECT Capacidad FROM Salas_Cine WHERE ID_Sala = ?";
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(consulta);
            sentenciaPreparada.setInt(1, idSala);

            ResultSet resultado = sentenciaPreparada.executeQuery();

            if (resultado.next()) {
                capacidad = resultado.getInt("Capacidad");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la capacidad de la sala: " + e.getMessage());
        }
        return capacidad;
    }



    public ArrayList<HashMap<String, String>> ObtenerPeliculasConDetalles() {
        ArrayList<HashMap<String, String>> peliculas = new ArrayList<>();
        try {
            Connection conexion = conectar(); // Asumiendo que 'conectar()' es tu método para obtener la conexión
            String consulta = "SELECT p.Titulo, s.Nombre_Sala, f.Fecha, f.Hora_Inicio, f.Hora_Final " +
                              "FROM Peliculas p " +
                              "JOIN Funciones f ON p.ID_Pelicula = f.ID_Pelicula " +
                              "JOIN Salas_Cine s ON f.ID_Sala = s.ID_Sala " +
                              "WHERE p.Estado = 'Activo' " +
                              "ORDER BY f.Fecha, f.Hora_Inicio;";
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(consulta);
            ResultSet resultado = sentenciaPreparada.executeQuery();

            while (resultado.next()) {
                HashMap<String, String> detallesPelicula = new HashMap<>();
                detallesPelicula.put("Titulo", resultado.getString("Titulo"));
                detallesPelicula.put("Nombre_Sala", resultado.getString("Nombre_Sala"));
                detallesPelicula.put("Fecha", resultado.getDate("Fecha").toString());
                detallesPelicula.put("Hora_Inicio", resultado.getTime("Hora_Inicio").toString());
                detallesPelicula.put("Hora_Final", resultado.getTime("Hora_Final").toString());
                peliculas.add(detallesPelicula);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener detalles de películas: " + e.getMessage());
        }
        return peliculas;
}




    

    
    
    
}

package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


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




    

    
    
    
}

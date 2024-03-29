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
    
}

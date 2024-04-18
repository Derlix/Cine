package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDatosJuanBustamante extends BaseDatosJuanPrincipal{
    
    Connection conexion;
    Statement manipularDB;
    
    public BaseDatosJuanBustamante(){
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

    public List<String> obtenerCines() {
        List<String> cines = new ArrayList<>();
        String query = "SELECT Nombre_Cine, Ciudad FROM cines";
        try {
            ResultSet rs = manipularDB.executeQuery(query);
            while (rs.next()) {
                cines.add(rs.getString("Nombre_Cine") + ", " + rs.getString("Ciudad"));
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener los cines:");
            System.out.println(ex.getMessage());
        }
        return cines;
    }
    
    // En la clase BaseDatosJuanBustamante
    public void actualizarSede(int idSede, String nombreSede, String direccion, String ciudad, String pais) {
        String query = "UPDATE cines SET Nombre_Cine = '" + nombreSede + "', Direccion = '" + direccion + "', Ciudad = '" + ciudad + "', Pais = '" + pais + "' WHERE ID_Cine = " + idSede;
        try {
            manipularDB.executeUpdate(query);
            System.out.println("Sede actualizada exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error al actualizar la sede:");
            System.out.println(ex.getMessage());
        }
    }
    
    public void eliminarSede(int idSede) {
        String query = "DELETE FROM cines WHERE ID_Cine = " + idSede;
        try {
            manipularDB.executeUpdate(query);
            System.out.println("Sede eliminada exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la sede:");
            System.out.println(ex.getMessage());
        }
    }


}

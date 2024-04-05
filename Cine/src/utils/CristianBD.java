
package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.Asiento;
import utils.Sala;


public class CristianBD extends BaseDatosJuanPrincipal{
    
    
    //Obtener asientos
    public List<Asiento> obtenerAsientos() {
        List<Asiento> asientos = new ArrayList<>();
        try {
            String query = "SELECT * FROM asientos";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id_asiento = resultSet.getInt("ID_Asiento");
                int id_sala = resultSet.getInt("ID_Sala");
                String fila = resultSet.getString("Fila");
                int numero = resultSet.getInt("Numero");
                String estado = resultSet.getString("Estado");
                Asiento asiento = new Asiento(id_asiento, id_sala, fila, numero, estado);
                asientos.add(asiento);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener los asientos:");
            System.out.println(ex.getMessage());
        }
        return asientos;
    }

    //Obtener salas
    public List<Sala> obtenerSalas() {
        List<Sala> salas = new ArrayList<>();
        try {
            String query = "SELECT * FROM salas_cine";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int id_sala = resultSet.getInt("ID_Sala");
                String nombre = resultSet.getString("Nombre_Sala");
                String capacidad = resultSet.getString("Capacidad");
                int id_cine = resultSet.getInt("ID_Cine");
                Sala sala = new Sala(id_sala, nombre, capacidad, id_cine);
                salas.add(sala);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener las salas:");
            System.out.println(ex.getMessage());
        }
        return salas;
    }
 
}

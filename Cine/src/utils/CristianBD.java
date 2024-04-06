
package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.Asiento;
import utils.Sala;


public class CristianBD extends BaseDatosJuanPrincipal{
    
    //Obtener funciones
    public List<Funcion> obtenerFunciones() {
        List<Funcion> funciones = new ArrayList<>();
        try {
            String query = "SELECT * FROM funciones";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id_funcion = resultSet.getInt("ID_Funcion");
                int id_pelicula = resultSet.getInt("ID_Pelicula");
                int id_sala = resultSet.getInt("ID_Sala");
                String fecha = resultSet.getString("Fecha");
                String hora_inicio = resultSet.getString("Hora_Inicio");
                String hora_final = resultSet.getString("Hora_Final");
                Funcion funcion = new Funcion(id_funcion, id_pelicula, id_sala, fecha, hora_inicio, hora_final);
                funciones.add(funcion);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener las funciones:");
            System.out.println(ex.getMessage());
        }
        return funciones;
    }
    
    public void rellenarFactura(){
        
        
        
    }
    
    
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
                int capacidad = resultSet.getInt("Capacidad");
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

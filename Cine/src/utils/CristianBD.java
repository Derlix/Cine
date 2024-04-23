package utils;

import CristianArce.VentanaEmergente;
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
                int precio = resultSet.getInt("Precio");
                Funcion funcion = new Funcion(id_funcion, id_pelicula, id_sala, fecha, hora_inicio, hora_final, precio);
                funciones.add(funcion);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener las funciones:");
            System.out.println(ex.getMessage());
        }
        return funciones;
    }
    
    //obtener la ultima venta ingresada
    public int ultimo_id_venta() {
        int id_venta = -1;
        try {
            String query = "SELECT MAX(ID_Venta) FROM ventas";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id_venta = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener último ID de venta:");
            System.out.println(ex.getMessage());
        }
        return id_venta;
    }
    
    public void eliminarVenta(int id) {
        try {
            String query = "DELETE FROM VENTAS WHERE ID_Venta = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            VentanaEmergente nueva = new VentanaEmergente("Reembolso exitoso", "El reembolso se ha realizado con éxico");

        } catch (SQLException ex) {
            VentanaEmergente nueva = new VentanaEmergente("Error", "No se ha podido realizar el reembolso");
            System.out.println(ex.getMessage());
        }
    }

    //insertar venta
    public void insertarVenta(int id_venta, int id_pelicula, int id_funcion, int id_usuario, int cantidad_boletos, double total_venta, String fecha) {
        String query = "INSERT INTO ventas (ID_Venta, ID_Pelicula, ID_Funcion, ID_Usuario, Cantidad_Boletos, Total_Venta, Fecha_Venta) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id_venta);
            statement.setInt(2, id_pelicula);
            statement.setInt(3, id_funcion);
            statement.setInt(4, id_usuario);
            statement.setInt(5, cantidad_boletos);
            statement.setDouble(6, total_venta);
            statement.setString(7, fecha);

            statement.executeUpdate();
            VentanaEmergente nueva = new VentanaEmergente("Venta exitosa", "La venta se ha agregado con exito");
        } catch (SQLException ex) {
            VentanaEmergente nueva = new VentanaEmergente("Error", "No se ha podido hacer la venta");
            System.out.println("Error al agregar la venta.");
        }
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

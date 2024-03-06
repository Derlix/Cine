package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDatos {
    
    Connection conexion;
    Statement manipularDB;
    
    public BaseDatos(){
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
    
    public void crearCine(String nombre, String direccion, String ciudad, String pais) {
        try {
            conexion.setAutoCommit(false);
            String query = "INSERT INTO Cines (Nombre_Cine, Direccion, Ciudad, Pais) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, nombre);
            statement.setString(2, direccion);
            statement.setString(3, ciudad);
            statement.setString(4, pais);
            statement.executeUpdate();
            conexion.commit();
            System.out.println("Cine creado correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al crear el cine:");
            System.out.println(ex.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException e) {
                System.out.println("Error al hacer rollback:");
                System.out.println(e.getMessage());
            }
        }
    }
    
    // Método para obtener todos los cines
    public List<Cine> obtenerTodosLosCines() {
        List<Cine> cines = new ArrayList<>();
        try {
            String query = "SELECT * FROM Cines";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_Cine");
                String nombre = resultSet.getString("Nombre_Cine");
                String direccion = resultSet.getString("Direccion");
                String ciudad = resultSet.getString("Ciudad");
                String pais = resultSet.getString("Pais");
                Cine cine = new Cine(id, nombre, direccion, ciudad, pais);
                cines.add(cine);
                System.out.println(cine.getNombre());
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener los cines:");
            System.out.println(ex.getMessage());
        }
        return cines;
    }
    
    // Método para obtener un cine por su ID
    public Cine obtenerCinePorId(int idCine) {
        Cine cine = null;
        try {
            String query = "SELECT * FROM Cines WHERE ID_Cine = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, idCine);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nombre = resultSet.getString("Nombre_Cine");
                String direccion = resultSet.getString("Direccion");
                String ciudad = resultSet.getString("Ciudad");
                String pais = resultSet.getString("Pais");
                cine = new Cine(idCine, nombre, direccion, ciudad, pais);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el cine por ID:");
            System.out.println(ex.getMessage());
        }
        return cine;
    }
    
    // Método para actualizar un cine
    public void actualizarCine(int idCine, String nombre, String direccion, String ciudad, String pais) {
        try {
            conexion.setAutoCommit(false);
            String query = "UPDATE Cines SET Nombre_Cine = ?, Direccion = ?, Ciudad = ?, Pais = ? WHERE ID_Cine = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, nombre);
            statement.setString(2, direccion);
            statement.setString(3, ciudad);
            statement.setString(4, pais);
            statement.setInt(5, idCine);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                conexion.commit();
                System.out.println("Cine actualizado correctamente.");
            } else {
                System.out.println("No se encontró el cine con ID: " + idCine);
            }
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el cine:");
            System.out.println(ex.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException e) {
                System.out.println("Error al hacer rollback:");
                System.out.println(e.getMessage());
            }
        }
    }
    
    // Método para eliminar un cine por su ID
    public void eliminarCine(int idCine) {
        try {
            conexion.setAutoCommit(false);
            String query = "DELETE FROM Cines WHERE ID_Cine = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, idCine);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                conexion.commit();
                System.out.println("Cine eliminado correctamente.");
            } else {
                System.out.println("No se encontró el cine con ID: " + idCine);
            }
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el cine:");
            System.out.println(ex.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException e) {
                System.out.println("Error al hacer rollback:");
                System.out.println(e.getMessage());
            }
        }
    }
    // Método para crear un usuario
    public void crearUsuario(String nombreUsuario, String contraseña, String rol) {
        try {
            conexion.setAutoCommit(false);
            String query = "INSERT INTO Usuarios (Nombre_Usuario, Contraseña, Rol) VALUES (?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, nombreUsuario);
            statement.setString(2, contraseña);
            statement.setString(3, rol);
            statement.executeUpdate();
            conexion.commit();
            System.out.println("Usuario creado correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al crear el usuario:");
            System.out.println(ex.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException e) {
                System.out.println("Error al hacer rollback:");
                System.out.println(e.getMessage());
            }
        }
    }
    
    // Método para obtener todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            String query = "SELECT * FROM Usuarios";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_Usuario");
                String nombreUsuario = resultSet.getString("Nombre_Usuario");
                String contraseña = resultSet.getString("Contraseña");
                String rol = resultSet.getString("Rol");
                Usuario usuario = new Usuario(id, nombreUsuario, contraseña, rol);
                usuarios.add(usuario);
                System.out.println(usuario.getNombreUsuario()+" "+usuario.getRol());
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener los usuarios:");
            System.out.println(ex.getMessage());
        }
        return usuarios;
    }

    // Método para obtener un usuario por su ID
    public Usuario obtenerUsuarioPorId(int idUsuario) {
        Usuario usuario = null;
        try {
            String query = "SELECT * FROM Usuarios WHERE ID_Usuario = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, idUsuario);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nombreUsuario = resultSet.getString("Nombre_Usuario");
                String contraseña = resultSet.getString("Contraseña");
                String rol = resultSet.getString("Rol");
                usuario = new Usuario(idUsuario, nombreUsuario, contraseña, rol);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el usuario por ID:");
            System.out.println(ex.getMessage());
        }
        return usuario;
    }

    // Método para actualizar un usuario
    public void actualizarUsuario(int idUsuario, String nombreUsuario, String contraseña, String rol) {
        try {
            conexion.setAutoCommit(false);
            String query = "UPDATE Usuarios SET Nombre_Usuario = ?, Contraseña = ?, Rol = ? WHERE ID_Usuario = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, nombreUsuario);
            statement.setString(2, contraseña);
            statement.setString(3, rol);
            statement.setInt(4, idUsuario);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                conexion.commit();
                System.out.println("Usuario actualizado correctamente.");
            } else {
                System.out.println("No se encontró el usuario con ID: " + idUsuario);
            }
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el usuario:");
            System.out.println(ex.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException e) {
                System.out.println("Error al hacer rollback:");
                System.out.println(e.getMessage());
            }
        }
    }

    // Método para eliminar un usuario por su ID
    public void eliminarUsuario(int idUsuario) {
        try {
            conexion.setAutoCommit(false);
            String query = "DELETE FROM Usuarios WHERE ID_Usuario = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, idUsuario);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                conexion.commit();
                System.out.println("Usuario eliminado correctamente.");
            } else {
                System.out.println("No se encontró el usuario con ID: " + idUsuario);
            }
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el usuario:");
            System.out.println(ex.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException e) {
                System.out.println("Error al hacer rollback:");
                System.out.println(e.getMessage());
            }
        }
    }
    
    // Método para crear una película
    public void crearPelicula(String titulo, String categoria, String etiquetas, int restriccionEdad, int duracion, String paisOrigen) {
        try {
            conexion.setAutoCommit(false);
            String query = "INSERT INTO Peliculas (Titulo, Categoria, Etiquetas, Restriccion_Edad, Duracion, Pais_Origen) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, titulo);
            statement.setString(2, categoria);
            statement.setString(3, etiquetas);
            statement.setInt(4, restriccionEdad);
            statement.setInt(5, duracion);
            statement.setString(6, paisOrigen);
            statement.executeUpdate();
            conexion.commit();
            System.out.println("Película creada correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al crear la película:");
            System.out.println(ex.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException e) {
                System.out.println("Error al hacer rollback:");
                System.out.println(e.getMessage());
            }
        }
    }

    // Método para obtener todas las películas
    public List<Pelicula> obtenerTodasLasPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            String query = "SELECT * FROM Peliculas";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_Pelicula");
                String titulo = resultSet.getString("Titulo");
                String categoria = resultSet.getString("Categoria");
                String etiquetas = resultSet.getString("Etiquetas");
                int restriccionEdad = resultSet.getInt("Restriccion_Edad");
                int duracion = resultSet.getInt("Duracion");
                String paisOrigen = resultSet.getString("Pais_Origen");
                Pelicula pelicula = new Pelicula(id, titulo, categoria, etiquetas, restriccionEdad, duracion, paisOrigen);
                peliculas.add(pelicula);
                System.out.println(pelicula.getTitulo());
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener las películas:");
            System.out.println(ex.getMessage());
        }
        return peliculas;
    }

    // Método para obtener una película por su ID
    public Pelicula obtenerPeliculaPorId(int idPelicula) {
        Pelicula pelicula = null;
        try {
            String query = "SELECT * FROM Peliculas WHERE ID_Pelicula = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, idPelicula);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String titulo = resultSet.getString("Titulo");
                String categoria = resultSet.getString("Categoria");
                String etiquetas = resultSet.getString("Etiquetas");
                int restriccionEdad = resultSet.getInt("Restriccion_Edad");
                int duracion = resultSet.getInt("Duracion");
                String paisOrigen = resultSet.getString("Pais_Origen");
                pelicula = new Pelicula(idPelicula, titulo, categoria, etiquetas, restriccionEdad, duracion, paisOrigen);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la película por ID:");
            System.out.println(ex.getMessage());
        }
        return pelicula;
    }

    // Método para actualizar una película
    public void actualizarPelicula(int idPelicula, String titulo, String categoria, String etiquetas, int restriccionEdad, int duracion, String paisOrigen) {
        try {
            conexion.setAutoCommit(false);
            String query = "UPDATE Peliculas SET Titulo = ?, Categoria = ?, Etiquetas = ?, Restriccion_Edad = ?, Duracion = ?, Pais_Origen = ? WHERE ID_Pelicula = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, titulo);
            statement.setString(2, categoria);
            statement.setString(3, etiquetas);
            statement.setInt(4, restriccionEdad);
            statement.setInt(5, duracion);
            statement.setString(6, paisOrigen);
            statement.setInt(7, idPelicula);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                conexion.commit();
                System.out.println("Película actualizada correctamente.");
            } else {
                System.out.println("No se encontró la película con ID: " + idPelicula);
            }
        } catch (SQLException ex) {
            System.out.println("Error al actualizar la película:");
            System.out.println(ex.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException e) {
                System.out.println("Error al hacer rollback:");
                System.out.println(e.getMessage());
            }
        }
    }

    // Método para eliminar una película por su ID
    public void eliminarPelicula(int idPelicula) {
        try {
            conexion.setAutoCommit(false);
            String query = "DELETE FROM Peliculas WHERE ID_Pelicula = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, idPelicula);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                conexion.commit();
                System.out.println("Película eliminada correctamente.");
            } else {
                System.out.println("No se encontró la película con ID: " + idPelicula);
            }
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la película:");
            System.out.println(ex.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException e) {
                System.out.println("Error al hacer rollback:");
                System.out.println(e.getMessage());
            }
        }
    }
}

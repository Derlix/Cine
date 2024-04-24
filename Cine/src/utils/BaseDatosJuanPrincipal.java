package utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import static javax.crypto.Cipher.SECRET_KEY;
import utils.Funcion;


public class BaseDatosJuanPrincipal {
    
    Connection conexion;
    Statement manipularDB;
    
    public BaseDatosJuanPrincipal(){
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

            // Eliminar de la tabla Ventas
            String queryVentas = "DELETE FROM Ventas WHERE ID_Funcion IN (SELECT ID_Funcion FROM Funciones WHERE ID_Sala IN (SELECT ID_Sala FROM Salas_Cine WHERE ID_Cine = ?))";
            PreparedStatement statementVentas = conexion.prepareStatement(queryVentas);
            statementVentas.setInt(1, idCine);
            statementVentas.executeUpdate();

            // Eliminar de la tabla Funciones
            String queryFunciones = "DELETE FROM Funciones WHERE ID_Sala IN (SELECT ID_Sala FROM Salas_Cine WHERE ID_Cine = ?)";
            PreparedStatement statementFunciones = conexion.prepareStatement(queryFunciones);
            statementFunciones.setInt(1, idCine);
            statementFunciones.executeUpdate();

            // Eliminar de la tabla Asientos
            String queryAsientos = "DELETE FROM Asientos WHERE ID_Sala IN (SELECT ID_Sala FROM Salas_Cine WHERE ID_Cine = ?)";
            PreparedStatement statementAsientos = conexion.prepareStatement(queryAsientos);
            statementAsientos.setInt(1, idCine);
            statementAsientos.executeUpdate();

            // Eliminar de la tabla Cajero_Cine
            String queryCajeroCine = "DELETE FROM Cajeros_Cine WHERE ID_Cine = ?";
            PreparedStatement statementCajeroCine = conexion.prepareStatement(queryCajeroCine);
            statementCajeroCine.setInt(1, idCine);
            statementCajeroCine.executeUpdate();

            // Eliminar de la tabla Sala_Cine
            String querySalaCine = "DELETE FROM Salas_Cine WHERE ID_Cine = ?";
            PreparedStatement statementSalaCine = conexion.prepareStatement(querySalaCine);
            statementSalaCine.setInt(1, idCine);
            statementSalaCine.executeUpdate();

            // Eliminar de la tabla Cines
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



    public void crearUsuario(String correo,String nombreUsuario,String contraseña,byte[] foto,String rol,String diasLaborales,String horaInicio,String horaFinal,int idCine) {
        try {
            conexion.setAutoCommit(false);
            String query = "INSERT INTO Usuarios (Correo, Nombre_Usuario, Contraseña, Foto, Rol, dias_laborales, hora_inicio, hora_final, ID_Cine) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, correo);
            statement.setString(2, nombreUsuario);
            statement.setString(3, encriptarContraseña(contraseña));
            statement.setBytes(4, foto);
            statement.setString(5, rol);
            statement.setString(6, diasLaborales);
            statement.setString(7, horaInicio);
            statement.setString(8, horaFinal);
            statement.setInt(9, idCine);

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


    public List<Usuario> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            String query = "SELECT * FROM Usuarios";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_Usuario");
                String correo = resultSet.getString("Correo");
                String nombreUsuario = resultSet.getString("Nombre_Usuario");
                String contraseña = resultSet.getString("Contraseña");
                byte[] foto = resultSet.getBytes("Foto");
                String rol = resultSet.getString("Rol");
                String diasLaborales = resultSet.getString("dias_laborales");
                String horaInicio = resultSet.getString("hora_inicio");
                String horaFinal = resultSet.getString("hora_final");
                int idCine = resultSet.getInt("ID_Cine");

                Usuario usuario = new Usuario(id, correo, nombreUsuario, contraseña, foto, rol, diasLaborales, horaInicio, horaFinal, idCine);
                usuarios.add(usuario);
                System.out.println(usuario.getNombreUsuario() + " " + usuario.getRol());
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
                String correo = resultSet.getString("Correo");
                String nombreUsuario = resultSet.getString("Nombre_Usuario");
                String contraseña = resultSet.getString("Contraseña");
                byte[] foto = resultSet.getBytes("Foto");
                String rol = resultSet.getString("Rol");
                String diasLaborales = resultSet.getString("dias_laborales");
                String horaInicio = resultSet.getString("hora_inicio");
                String horaFinal = resultSet.getString("hora_final");
                int idCine = resultSet.getInt("ID_Cine");

                usuario = new Usuario(idUsuario, correo, nombreUsuario, contraseña, foto, rol, diasLaborales, horaInicio, horaFinal, idCine);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el usuario por ID:");
            System.out.println(ex.getMessage());
        }
        return usuario;
    }

    // Método para actualizar un usuario
    public void actualizarUsuario(int idUsuario, String nombreUsuario, String contraseña, String rol, String correo, String diasLaborales, String horaInicio, String horaFinal, int idCine, byte[] foto) {
        try {
            conexion.setAutoCommit(false);
            String query = "UPDATE Usuarios SET Nombre_Usuario = ?, Contraseña = ?, Rol = ?, dias_laborales = ?, hora_inicio = ?, hora_final = ?, ID_Cine = ?, Foto = ? WHERE ID_Usuario = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, nombreUsuario);
            statement.setString(2, contraseña);
            statement.setString(3, rol);
            statement.setString(4, diasLaborales);
            statement.setString(5, horaInicio);
            statement.setString(6, horaFinal);
            statement.setInt(7, idCine);
            statement.setBytes(8, foto);
            statement.setInt(9, idUsuario);
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
    
    public Usuario verificarCredenciales(String correo, String contraseña) {
        Usuario usuario = null;
        try {
            String query = "SELECT * FROM Usuarios WHERE Correo = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, correo);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String contraseñaEnBaseDeDatos = resultSet.getString("Contraseña");

                if (contraseña.equals(desencriptarContraseña(contraseñaEnBaseDeDatos)) || 
                    contraseña.equals(contraseñaEnBaseDeDatos)) {

                    usuario = new Usuario(
                        resultSet.getInt("ID_Usuario"),
                        resultSet.getString("Correo"),
                        resultSet.getString("Nombre_Usuario"),
                        contraseñaEnBaseDeDatos,
                        resultSet.getBytes("Foto"),
                        resultSet.getString("Rol"),
                        resultSet.getString("dias_laborales"),
                        resultSet.getString("hora_inicio"),
                        resultSet.getString("hora_final"),
                        resultSet.getInt("ID_Cine")
                    );
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al verificar credenciales:");
            System.out.println(ex.getMessage());
        }
        return usuario;
    }

    private static final String SECRET_KEY = "mySecretKey12345"; // Clave secreta para el cifrado
    private static final String ALGORITHM = "AES";

    public static String encriptarContraseña(String contraseña) {
        try {
            SecretKey secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] encryptedBytes = cipher.doFinal(contraseña.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            System.out.println("Error al encriptar la contraseña:");
            e.printStackTrace();
            return null;
        }
    }

    public static String desencriptarContraseña(String contraseñaEncriptada) {
        try {
            SecretKey secretKey = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decodedBytes = Base64.getDecoder().decode(contraseñaEncriptada.getBytes(StandardCharsets.UTF_8));
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);

            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println("Error al desencriptar la contraseña:");
            System.out.println(e.getMessage());
            return null;
        }
    }


    
    // Método para crear una película con imagen
    public Pelicula buscarPeliculaPorId(String idPelicula) {
        Pelicula pelicula = null;
        String query = "SELECT * FROM Peliculas WHERE ID_Pelicula = ? AND Estado = 'Activo'"; // Modificado
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, idPelicula);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("ID_Pelicula");
                    String titulo = resultSet.getString("Titulo");
                    String categoria = resultSet.getString("Categoria");
                    String etiquetas = resultSet.getString("Etiquetas");
                    int restriccionEdad = resultSet.getInt("Restriccion_Edad");
                    int duracion = resultSet.getInt("Duracion");
                    String paisOrigen = resultSet.getString("Pais_Origen");
                    byte[] imagen = resultSet.getBytes("Imagen");
                    String rutaImagen = resultSet.getString("Ruta_Imagen");
                    String fechaInicio = resultSet.getString("Fecha_Inicio");
                    String fechaFin = resultSet.getString("Fecha_Fin");
                    String estado = resultSet.getString("Estado");
                    pelicula = new Pelicula(id, titulo, categoria, etiquetas, restriccionEdad, duracion, paisOrigen, imagen, rutaImagen, fechaInicio, fechaFin, estado); // Modificado
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar la película por ID: " + ex.getMessage());
        }
        return pelicula;
    }
    
    public Pelicula buscarPelicula(String idPelicula) {
        Pelicula pelicula = null;
        String query = "SELECT * FROM Peliculas WHERE ID_Pelicula = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, idPelicula);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("ID_Pelicula");
                    String titulo = resultSet.getString("Titulo");
                    String categoria = resultSet.getString("Categoria");
                    String etiquetas = resultSet.getString("Etiquetas");
                    int restriccionEdad = resultSet.getInt("Restriccion_Edad");
                    int duracion = resultSet.getInt("Duracion");
                    String paisOrigen = resultSet.getString("Pais_Origen");
                    byte[] imagen = resultSet.getBytes("Imagen");
                    String rutaImagen = resultSet.getString("Ruta_Imagen");
                    String fechaInicio = resultSet.getString("Fecha_Inicio");
                    String fechaFin = resultSet.getString("Fecha_Fin");
                    String estado = resultSet.getString("Estado");
                    pelicula = new Pelicula(id, titulo, categoria, etiquetas, restriccionEdad, duracion, paisOrigen, imagen, rutaImagen, fechaInicio, fechaFin, estado); // Modificado
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar la película por ID: " + ex.getMessage());
        }
        return pelicula;
    }


    
    public void crearPelicula(String titulo, String categoria, String etiquetas, int restriccionEdad, int duracion, String paisOrigen, byte[] imagen, String rutaImagen, Date fechaInicio, Date fechaFin, String estado) {
        try {
            File imagenFile = new File(rutaImagen);
            FileInputStream fis = new FileInputStream(imagenFile);
            byte[] imagenBytes = new byte[(int) imagenFile.length()];
            fis.read(imagenBytes);
            fis.close();

            // Insertar la película en la base de datos junto con la imagen
            String query = "INSERT INTO Peliculas (Titulo, Categoria, Etiquetas, Restriccion_Edad, Duracion, Pais_Origen, Imagen, Ruta_Imagen) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, titulo);
            statement.setString(2, categoria);
            statement.setString(3, etiquetas);
            statement.setInt(4, restriccionEdad);
            statement.setInt(5, duracion);
            statement.setString(6, paisOrigen);
            statement.setBytes(7, imagenBytes);
            statement.setString(8, rutaImagen);
            statement.executeUpdate();
        } catch (SQLException | IOException ex) {
            System.out.println("Error al crear la pelicula:");
            ex.printStackTrace();
        }
    }


    public List<Pelicula> obtenerTodasLasPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            String query = "SELECT ID_Pelicula, Titulo, Categoria, Etiquetas, Restriccion_Edad, Duracion, Pais_Origen, Ruta_Imagen, Fecha_Inicio, Fecha_Fin, Estado FROM Peliculas";
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
                String rutaImagen = resultSet.getString("Ruta_Imagen");
                String fechaInicio = resultSet.getString("Fecha_Inicio");
                String fechaFin = resultSet.getString("Fecha_Fin");
                String estado = resultSet.getString("Estado");
                peliculas.add(new Pelicula(id, titulo, categoria, etiquetas, restriccionEdad, duracion, paisOrigen, null, rutaImagen, fechaInicio, fechaFin, estado)); // Modificado
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener las películas:");
            System.out.println(ex.getMessage());
        }
        return peliculas;
    }



    // Método para actualizar una película
    public void actualizarPelicula(int idPelicula, String titulo, String categoria, String etiquetas, int restriccionEdad, int duracion, String paisOrigen, String rutaImagen, String estado) {
        try {
            conexion.setAutoCommit(false);
            String query = "UPDATE Peliculas SET Titulo = ?, Categoria = ?, Etiquetas = ?, Restriccion_Edad = ?, Duracion = ?, Pais_Origen = ?, Ruta_Imagen = ?, Estado = ? WHERE ID_Pelicula = ? AND Estado = 'Activo'"; // Modificado
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, titulo);
            statement.setString(2, categoria);
            statement.setString(3, etiquetas);
            statement.setInt(4, restriccionEdad);
            statement.setInt(5, duracion);
            statement.setString(6, paisOrigen);
            statement.setString(7, rutaImagen);
            statement.setString(8, estado);
            statement.setInt(9, idPelicula);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                conexion.commit();
                System.out.println("Película actualizada correctamente.");
            } else {
                System.out.println("No se encontró la película con ID: " + idPelicula + " o la película está inactiva.");
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

            // Eliminar registros dependientes en la tabla Ventas
            String deleteVentasQuery = "DELETE FROM ventas WHERE ID_Pelicula = ?";
            PreparedStatement deleteVentasStatement = conexion.prepareStatement(deleteVentasQuery);
            deleteVentasStatement.setInt(1, idPelicula);
            deleteVentasStatement.executeUpdate();

            // Eliminar registros dependientes en la tabla Funciones
            String deleteFuncionesQuery = "DELETE FROM funciones WHERE ID_Pelicula = ?";
            PreparedStatement deleteFuncionesStatement = conexion.prepareStatement(deleteFuncionesQuery);
            deleteFuncionesStatement.setInt(1, idPelicula);
            deleteFuncionesStatement.executeUpdate();

            // Eliminar registros dependientes en la tabla Anuncios
            String deleteAnunciosQuery = "DELETE FROM anuncios WHERE ID_Pelicula = ?";
            PreparedStatement deleteAnunciosStatement = conexion.prepareStatement(deleteAnunciosQuery);
            deleteAnunciosStatement.setInt(1, idPelicula);
            deleteAnunciosStatement.executeUpdate();

            // Eliminar la película de la tabla Peliculas
            String deletePeliculaQuery = "DELETE FROM peliculas WHERE ID_Pelicula = ?";
            PreparedStatement deletePeliculaStatement = conexion.prepareStatement(deletePeliculaQuery);
            deletePeliculaStatement.setInt(1, idPelicula);
            int rowsDeleted = deletePeliculaStatement.executeUpdate();

            if (rowsDeleted > 0) {
                conexion.commit();
                System.out.println("Pelicula eliminada correctamente.");
            } else {
                System.out.println("No se encontró la película con ID: " + idPelicula);
            }
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la pelicula:");
            System.out.println(ex.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException e) {
                System.out.println("Error al hacer rollback:");
                System.out.println(e.getMessage());
            }
        }
    }

    


    // Método para guardar una nueva función
    public void guardarFuncion(Funcion funcion) {
        try {
            conexion.setAutoCommit(false);

            String query = "INSERT INTO Funciones (ID_Pelicula, ID_Sala, Fecha, Hora_Inicio, Hora_Final, Precio) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conexion.prepareStatement(query);

            int idPelicula = funcion.getId_pelicula(); 

            pstmt.setInt(1, idPelicula); 
            pstmt.setInt(2, funcion.getId_sala()); 
            pstmt.setString(3, funcion.getFecha());
            pstmt.setString(4, funcion.getHora_inicio()); 
            pstmt.setString(5, funcion.getHora_final()); 
            pstmt.setInt(6, funcion.getPrecio());

            pstmt.executeUpdate();

            conexion.commit();
            System.out.println("Función creada correctamente.");

        } catch (SQLException ex) {
            System.out.println("Error al crear la función:");
            System.out.println(ex.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException e) {
                System.out.println("Error al hacer rollback:");
                System.out.println(e.getMessage());
            }
        }
    }






    // Método para actualizar una función existente
    public void actualizarFuncion(Funcion funcion) {
        try {
            conexion.setAutoCommit(false);
            String query = "UPDATE funciones SET ID_Pelicula = ?, ID_Sala = ?, Fecha = ?, Hora_Inicio = ?, Hora_Final = ?, Precio = ? WHERE ID_Funcion = ?";
            PreparedStatement statement = conexion.prepareStatement(query);

            statement.setInt(1, funcion.getId_pelicula());
            statement.setInt(2, funcion.getId_sala());
            statement.setString(3, funcion.getFecha());
            statement.setString(4, funcion.getHora_inicio());
            statement.setString(5, funcion.getHora_final());
            statement.setInt(6, funcion.getPrecio());
            statement.setInt(7, funcion.getId_funcion());

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                conexion.commit();
                System.out.println("Función actualizada correctamente.");
            } else {
                System.out.println("No se encontró la función con ID: " + funcion.getId_funcion());
            }
        } catch (SQLException ex) {
            System.out.println("Error al actualizar la función:");
            System.out.println(ex.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException e) {
                System.out.println("Error al hacer rollback:");
                System.out.println(e.getMessage());
            }
        }
    }



    // Método para eliminar una función
    public boolean eliminarFuncion(int idFuncion) {
        boolean eliminado = false;
        try {
            conexion.setAutoCommit(false);
            String query = "DELETE FROM funciones WHERE ID_Funcion = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, idFuncion);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                conexion.commit();
                eliminado = true;
                System.out.println("Función eliminada correctamente.");
            } else {
                System.out.println("No se encontró la función con ID: " + idFuncion);
            }
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la función:");
            System.out.println(ex.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException e) {
                System.out.println("Error al hacer rollback:");
                System.out.println(e.getMessage());
            }
        }
        return eliminado;
    }


    // Método para buscar una función por su ID
    public Funcion buscarFuncion(int idFuncion) {
        Funcion funcion = null;
        try {
            String query = "SELECT * FROM funciones WHERE ID_Funcion = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, idFuncion);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Crear el objeto Funcion con los datos obtenidos
                int idPelicula = resultSet.getInt("ID_Pelicula");
                int idSala = resultSet.getInt("ID_Sala");
                String fecha = resultSet.getString("Fecha");
                String horaInicio = resultSet.getString("Hora_Inicio");
                String horaFinal = resultSet.getString("Hora_Final");
                int precio = resultSet.getInt("Precio");

                funcion = new Funcion(idFuncion, idPelicula, idSala, fecha, horaInicio, horaFinal, precio);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return funcion;
    }
    
    public List<Funcion> obtenerTodasFunciones() throws SQLException {
        List<Funcion> funciones = new ArrayList<>();
        try {
            String query = "SELECT * FROM Funciones";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Funcion funcion = new Funcion(
                    resultSet.getInt("ID_Funcion"),
                    resultSet.getInt("ID_Pelicula"),
                    resultSet.getInt("ID_Sala"),
                    resultSet.getString("Fecha"),
                    resultSet.getString("Hora_Inicio"),
                    resultSet.getString("Hora_Final"),
                    resultSet.getInt("Precio")
                );
                funciones.add(funcion);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener las funciones:");
            System.out.println(ex.getMessage());
        }
        return funciones;
    }

    
    
}

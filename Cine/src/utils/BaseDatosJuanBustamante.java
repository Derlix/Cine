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
    
    public void actualizarDiasLaborales(int idEmpleado, String diasLaborales) {
        // Preparar la consulta SQL para actualizar los días laborales
        String query = "UPDATE usuarios SET dias_laborales = '" + diasLaborales + "' WHERE ID_Usuario = " + idEmpleado;

        try {
            // Ejecutar la consulta SQL
            manipularDB.executeUpdate(query);
            System.out.println("Días laborales actualizados exitosamente para el empleado con ID: " + idEmpleado);
        } catch (SQLException ex) {
            System.out.println("Error al actualizar los dias laborales:");
            System.out.println(ex.getMessage());
        }
    }
    
    // En la clase BaseDatosJuanBustamante
    public void actualizarJornada(int idUsuario, String hora_inicio, String hora_final) {
        String query = "UPDATE usuarios SET hora_inicio = '" + hora_inicio + "', hora_final = '" + hora_final + "' WHERE ID_Usuario = " + idUsuario;
        try {
            manipularDB.executeUpdate(query);
            System.out.println("Jornada actualizada exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error al actualizar la Jornada:");
            System.out.println(ex.getMessage());
        }
    }
    
    // Método para obtener el rol del usuario por su idUsuario
    public String obtenerRolUsuario(int idUsuario) {
        String rol = "";
        String query = "SELECT rol FROM usuarios WHERE ID_Usuario = " + idUsuario;
        try {
            ResultSet rs = manipularDB.executeQuery(query);
            if (rs.next()) {
                rol = rs.getString("rol");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el rol del usuario:");
            System.out.println(ex.getMessage());
        }
        return rol;
    }
    
    // Método para obtener el nombre del cine asociado al usuario por su idUsuario
    public String obtenerNombreCine(int idUsuario) {
        String nombreCine = "";
        String queryUsuario = "SELECT ID_cine FROM usuarios WHERE ID_Usuario = " + idUsuario;
        try {
            ResultSet rsUsuario = manipularDB.executeQuery(queryUsuario);
            if (rsUsuario.next()) {
                String ID_cine = rsUsuario.getString("ID_cine");
                String queryCine = "SELECT Nombre_Cine FROM cines WHERE ID_Cine = " + ID_cine;
                ResultSet rsCine = manipularDB.executeQuery(queryCine);
                if (rsCine.next()) {
                    nombreCine = rsCine.getString("Nombre_Cine");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el nombre del cine:");
            System.out.println(ex.getMessage());
        }
        return nombreCine;
    }
    
    // Método para obtener el rol del usuario por su idUsuario
    public String obtenerNombreUsuario(int idUsuario) {
        String Nombre_Usuario = "";
        String query = "SELECT Nombre_Usuario FROM usuarios WHERE ID_Usuario = " + idUsuario;
        try {
            ResultSet rs = manipularDB.executeQuery(query);
            if (rs.next()) {
                Nombre_Usuario = rs.getString("Nombre_Usuario");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el Nombre del Usuario del usuario:");
            System.out.println(ex.getMessage());
        }
        return Nombre_Usuario;
    }
    
    public List<String> buscarCinePorNombre(String nombreCine) {
        List<String> cines = new ArrayList<>();
        String query = "SELECT Nombre_Cine, Ciudad FROM cines WHERE Nombre_Cine LIKE ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, "%" + nombreCine + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cines.add(rs.getString("Nombre_Cine") + ", " + rs.getString("Ciudad"));
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar el cine:");
            System.out.println(ex.getMessage());
        }
        return cines;
    }

    public int obtenerIdCinePorNombre(String cineCompleto) {
    int idCine = -1; // Valor por defecto si no se encuentra el cine
    String[] partes = cineCompleto.split(", "); // Asume que siempre hay una coma seguida de un espacio
    String nombreCine = partes[0]; // El nombre del cine está antes de la coma
    String query = "SELECT ID_Cine FROM cines WHERE Nombre_Cine = ?";
    try {
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1, nombreCine);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            idCine = rs.getInt("ID_Cine");
        }
    } catch (SQLException ex) {
        System.out.println("Error al obtener el ID del cine:");
        System.out.println(ex.getMessage());
    }
    return idCine;
}


    public List<Sala> obtenerSalasPorIdCine(int idCine) {
    List<Sala> salas = new ArrayList<>();
    String query = "SELECT * FROM salas_cine WHERE ID_Cine = ?";
    try {
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1, idCine);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int idSala = rs.getInt("ID_Sala");
            String nombreSala = rs.getString("Nombre_Sala");
            int capacidad = rs.getInt("Capacidad");
            int idCineSala = rs.getInt("ID_Cine");
            Sala sala = new Sala(idSala, nombreSala, capacidad, idCineSala);
            salas.add(sala);
        }
    } catch (SQLException ex) {
        System.out.println("Error al obtener las salas del cine:");
        System.out.println(ex.getMessage());
    }
        return salas;
    }

    public int obtenerTotalSalasPorIdCine(int idCine) {
    int totalSalas = 0;
    String query = "SELECT COUNT(*) AS total FROM salas_cine WHERE ID_Cine = ?";
    try {
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1, idCine);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            totalSalas = rs.getInt("total");
        }
    } catch (SQLException ex) {
        System.out.println("Error al obtener el total de salas del cine:");
        System.out.println(ex.getMessage());
    }
        return totalSalas;
    }
    
    // Método para obtener el nombre del cine asociado a la ID del cine
    public String obtenerNombrePorIDCine(int idCine) {
        String nombreCine = "";
        String queryCine = "SELECT Nombre_Cine FROM cines WHERE ID_Cine = " + idCine;
        try {
            ResultSet rsCine = manipularDB.executeQuery(queryCine);
            if (rsCine.next()) {
                nombreCine = rsCine.getString("Nombre_Cine");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener el nombre del cine:");
            System.out.println(ex.getMessage());
        }
        return nombreCine;
    }
    
    public List<Usuario> obtenerEmpleadosPorCine(int idCine) {
    List<Usuario> empleados = new ArrayList<>();
    String query = "SELECT ID_Usuario, Correo, Nombre_Usuario, Contraseña, Foto, Rol, dias_laborales, hora_inicio, hora_final, ID_Cine FROM usuarios WHERE ID_Cine = ?";
    try {
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1, idCine);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int idUsuario = rs.getInt("ID_Usuario");
            String correo = rs.getString("Correo");
            String nombreUsuario = rs.getString("Nombre_Usuario");
            String contraseña = rs.getString("Contraseña");
            byte[] foto = rs.getBytes("Foto");
            String rol = rs.getString("Rol");
            String diasLaborales = rs.getString("dias_laborales");
            String horaInicio = rs.getString("hora_inicio");
            String horaFinal = rs.getString("hora_final");

            Usuario empleado = new Usuario(idUsuario, correo, nombreUsuario, contraseña, foto, rol, diasLaborales, horaInicio, horaFinal, idCine);
            empleados.add(empleado);
        }
    } catch (SQLException ex) {
        System.out.println("Error al obtener los empleados:");
        System.out.println(ex.getMessage());
    }
    return empleados;
    }
    
    // En la clase BaseDatosJuanBustamante
public Usuario obtenerEmpleadoPorId(int idEmpleado) {
    Usuario empleado = null;
    String query = "SELECT * FROM usuarios WHERE ID_Usuario = ?";
    try {
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1, idEmpleado);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int idUsuario = rs.getInt("ID_Usuario");
            String correo = rs.getString("Correo");
            String nombreUsuario = rs.getString("Nombre_Usuario");
            String contraseña = rs.getString("Contraseña");
            byte[] foto = rs.getBytes("Foto");
            String rol = rs.getString("Rol");
            String diasLaborales = rs.getString("dias_laborales");
            String horaInicio = rs.getString("hora_inicio");
            String horaFinal = rs.getString("hora_final");
            int idCine = rs.getInt("ID_Cine");

            empleado = new Usuario(idUsuario, correo, nombreUsuario, contraseña, foto, rol, diasLaborales, horaInicio, horaFinal, idCine);
        }
    } catch (SQLException ex) {
        System.out.println("Error al obtener el empleado:");
        System.out.println(ex.getMessage());
    }
    return empleado;
}

public Cine obtenerInformacionCine(int idCine) {
    Cine cine = null;
    String query = "SELECT * FROM cines WHERE ID_Cine = ?";
    try {
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1, idCine);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("ID_Cine");
            String nombre = rs.getString("Nombre_Cine");
            String direccion = rs.getString("Direccion");
            String ciudad = rs.getString("Ciudad");
            String pais = rs.getString("Pais");

            cine = new Cine(id, nombre, direccion, ciudad, pais);
        }
    } catch (SQLException ex) {
        System.out.println("Error al obtener la información del cine:");
        System.out.println(ex.getMessage());
    }
    return cine;
}

public List<Sala> obtenerSalasPorIdSede(int idSede) {
        List<Sala> salas = new ArrayList<>();
        String query = "SELECT * FROM salas_cine WHERE ID_Cine = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, idSede);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idSala = rs.getInt("ID_Sala");
                String nombre = rs.getString("Nombre_Sala");
                int capacidad = rs.getInt("Capacidad");

                Sala sala = new Sala(idSala, nombre, capacidad, idSede);
                salas.add(sala);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener las salas de la sede:");
            System.out.println(ex.getMessage());
        }
        return salas;
    }

    public void insertarSala(Sala sala) {
        String query = "INSERT INTO salas_cine (Nombre_Sala, Capacidad, ID_Cine) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, sala.getNombre());
            ps.setInt(2, sala.getCapacidad());
            ps.setInt(3, sala.getId_cine());

            // Ejecutar la consulta para insertar la nueva sala
            ps.executeUpdate();
            System.out.println("Sala insertada exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error al insertar la sala:");
            System.out.println(ex.getMessage());
        }
    }
    
    public void actualizarSala(Sala sala) {
        String query = "UPDATE salas_cine SET Nombre_Sala = ?, Capacidad = ? WHERE ID_Sala = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, sala.getNombre());
            ps.setInt(2, sala.getCapacidad());
            ps.setInt(3, sala.getId_sala());

            // Ejecutar la consulta para actualizar la sala
            ps.executeUpdate();
            System.out.println("Sala actualizada exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error al actualizar la sala:");
            System.out.println(ex.getMessage());
        }
    }
    
    public boolean actualizarEmpleadoCineYRol(int idEmpleado, int idCine, String rol) {
    String query = "UPDATE usuarios SET ID_Cine = ?, Rol = ? WHERE ID_Usuario = ?";
    try {
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setInt(1, idCine);
        ps.setString(2, rol);
        ps.setInt(3, idEmpleado);
        int result = ps.executeUpdate();
        return result > 0;  // Retorna true si la actualización fue exitosa
    } catch (SQLException ex) {
        System.out.println("Error al actualizar el cine y el rol del empleado:");
        System.out.println(ex.getMessage());
        return false;
    }
}

    // Método para insertar una nueva sala de cine
    public boolean insertarSala(String nombreSala, int capacidad, int idCine) {
        String query = "INSERT INTO salas_cine (Nombre_Sala, Capacidad, ID_Cine) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setString(1, nombreSala);
            stmt.setInt(2, capacidad);
            stmt.setInt(3, idCine);
            int resultado = stmt.executeUpdate();
            return resultado > 0;
        } catch (SQLException ex) {
            System.out.println("Error al insertar la sala:");
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    // Método para eliminar una sala de cine por ID
    public boolean eliminarSala(int idSala) {
        String query = "DELETE FROM salas_cine WHERE ID_Sala = ?";
        try {
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setInt(1, idSala);
            int resultado = stmt.executeUpdate();
            return resultado > 0;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la sala:");
            System.out.println(ex.getMessage());
            return false;
        }
    }

}


package utils;

public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private String contraseña;
    private String rol;
    
    public Usuario(int idUsuario, String nombreUsuario, String contraseña, String rol) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.rol = rol;
    }
    
    // Getter para el ID del usuario
    public int getIdUsuario() {
        return idUsuario;
    }
    
    // Setter para el ID del usuario
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    // Getter para el nombre del usuario
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    // Setter para el nombre del usuario
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    // Getter para la contraseña del usuario
    public String getContraseña() {
        return contraseña;
    }
    
    // Setter para la contraseña del usuario
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    // Getter para el rol del usuario
    public String getRol() {
        return rol;
    }
    
    // Setter para el rol del usuario
    public void setRol(String rol) {
        this.rol = rol;
    }
}

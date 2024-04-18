package utils;

public class Usuario {
    private int idUsuario;
    private String correo;
    private String nombreUsuario;
    private String contraseña;
    private byte[] foto;
    private String rol;
    private String diasLaborales;
    private String horaInicio;
    private String horaFinal;
    private int idCine;
    
    public Usuario(int idUsuario, String correo, String nombreUsuario, String contraseña, byte[] foto, String rol, String diasLaborales, String horaInicio, String horaFinal, int idCine) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.foto = foto;
        this.rol = rol;
        this.diasLaborales = diasLaborales;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.idCine = idCine;
    }
    
    // Getter y Setter para idUsuario
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    // Getter y Setter para correo
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Getter y Setter para nombreUsuario
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    // Getter y Setter para contraseña
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    // Getter y Setter para foto
    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    // Getter y Setter para rol
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // Getter y Setter para diasLaborales
    public String getDiasLaborales() {
        return diasLaborales;
    }

    public void setDiasLaborales(String diasLaborales) {
        this.diasLaborales = diasLaborales;
    }

    // Getter y Setter para horaInicio
    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    // Getter y Setter para horaFinal
    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    // Getter y Setter para idCine
    public int getIdCine() {
        return idCine;
    }

    public void setIdCine(int idCine) {
        this.idCine = idCine;
    }
}

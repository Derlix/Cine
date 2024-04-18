package utils;

public class Pelicula {
    private int idPelicula;
    private String titulo;
    private String categoria;
    private String etiquetas;
    private int restriccionEdad;
    private int duracion;
    private String paisOrigen;
    private byte[] imagen;
    private String rutaImagen;
    private String fechaInicio;
    private String fechaFin;
    private String estado;

    public Pelicula(int idPelicula, String titulo, String categoria, String etiquetas, int restriccionEdad, int duracion, String paisOrigen, byte[] imagen, String rutaImagen, String fechaInicio, String fechaFin, String estado) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.categoria = categoria;
        this.etiquetas = etiquetas;
        this.restriccionEdad = restriccionEdad;
        this.duracion = duracion;
        this.paisOrigen = paisOrigen;
        this.imagen = imagen;
        this.rutaImagen = rutaImagen;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado; // Se agrega el estado al constructor
    }

    // Métodos getter y setter para el campo de estado...
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Métodos getter y setter para los campos nuevos...
    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }


    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }


    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }

    public int getRestriccionEdad() {
        return restriccionEdad;
    }

    public void setRestriccionEdad(int restriccionEdad) {
        this.restriccionEdad = restriccionEdad;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
}

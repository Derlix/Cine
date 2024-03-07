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

    public Pelicula(int idPelicula, String titulo, String categoria, String etiquetas, int restriccionEdad, int duracion, String paisOrigen, byte[] imagen) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.categoria = categoria;
        this.etiquetas = etiquetas;
        this.restriccionEdad = restriccionEdad;
        this.duracion = duracion;
        this.paisOrigen = paisOrigen;
        this.imagen = imagen;
    }

    // Getters y setters omitidos por brevedad...

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    // Métodos getter y setter para los demás campos de la película...
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

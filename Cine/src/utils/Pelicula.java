
package utils;


public class Pelicula {
    private int idPelicula;
    private String titulo;
    private String categoria;
    private String etiquetas;
    private int restriccionEdad;
    private int duracion;
    private String paisOrigen;
    
    public Pelicula(int idPelicula, String titulo, String categoria, String etiquetas, int restriccionEdad, int duracion, String paisOrigen) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.categoria = categoria;
        this.etiquetas = etiquetas;
        this.restriccionEdad = restriccionEdad;
        this.duracion = duracion;
        this.paisOrigen = paisOrigen;
    }
    
    // Getter para el ID de la película
    public int getIdPelicula() {
        return idPelicula;
    }
    
    // Setter para el ID de la película
    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }
    
    // Getter para el título de la película
    public String getTitulo() {
        return titulo;
    }
    
    // Setter para el título de la película
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    // Getter para la categoría de la película
    public String getCategoria() {
        return categoria;
    }
    
    // Setter para la categoría de la película
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    // Getter para las etiquetas de la película
    public String getEtiquetas() {
        return etiquetas;
    }
    
    // Setter para las etiquetas de la película
    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }
    
    // Getter para la restricción de edad de la película
    public int getRestriccionEdad() {
        return restriccionEdad;
    }
    
    // Setter para la restricción de edad de la película
    public void setRestriccionEdad(int restriccionEdad) {
        this.restriccionEdad = restriccionEdad;
    }
    
    // Getter para la duración de la película
    public int getDuracion() {
        return duracion;
    }
    
    // Setter para la duración de la película
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    // Getter para el país de origen de la película
    public String getPaisOrigen() {
        return paisOrigen;
    }
    
    // Setter para el país de origen de la película
    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
}

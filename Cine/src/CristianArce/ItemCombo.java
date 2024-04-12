
package CristianArce;

public class ItemCombo {
    private int id_funcion;
    private int id_sala;
    private String nombre_pelicula;
    private String hora;
    private int precio;

    public ItemCombo(int id_funcion, int id_sala, String nombre_pelicula, String hora, int precio) {
        this.id_funcion = id_funcion;
        this.id_sala = id_sala;
        this.nombre_pelicula = nombre_pelicula;
        this.hora = hora;
        this.precio = precio;
    }

    public int getId_funcion() {
        return id_funcion;
    }

    public void setId_funcion(int id_funcion) {
        this.id_funcion = id_funcion;
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public String getNombre_pelicula() {
        return nombre_pelicula;
    }

    public void setNombre_pelicula(String nombre_pelicula) {
        this.nombre_pelicula = nombre_pelicula;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return nombre_pelicula;
    }

}

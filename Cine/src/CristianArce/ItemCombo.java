
package CristianArce;

public class ItemCombo {
    
    int id_sala;
    String nombre_pelicula;

    public ItemCombo(int id_sala, String nombre_pelicula) {
        this.id_sala = id_sala;
        this.nombre_pelicula = nombre_pelicula;
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
    
    @Override
    public String toString() {
        return nombre_pelicula;
    }

}

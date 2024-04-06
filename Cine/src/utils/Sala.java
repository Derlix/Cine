
package utils;

public class Sala {
    
    private int id_sala;
    private String nombre;
    private int capacidad;
    private int id_cine;

    public Sala(int id_sala, String nombre, int capacidad, int id_cine) {
        this.id_sala = id_sala;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.id_cine = id_cine;
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getId_cine() {
        return id_cine;
    }

    public void setId_cine(int id_cine) {
        this.id_cine = id_cine;
    }
    
}

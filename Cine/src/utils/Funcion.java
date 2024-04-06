
package utils;

public class Funcion {
    
    private int id_funcion;
    private int id_pelicula; 
    private int id_sala;
    private String fecha;
    private String hora_inicio;
    private String hora_final;

    public Funcion(int id_funcion, int id_pelicula, int id_sala, String fecha, String hora_inicio, String hora_final) {
        this.id_funcion = id_funcion;
        this.id_pelicula = id_pelicula;
        this.id_sala = id_sala;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
    }

    public int getId_funcion() {
        return id_funcion;
    }

    public void setId_funcion(int id_funcion) {
        this.id_funcion = id_funcion;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_final() {
        return hora_final;
    }

    public void setHora_final(String hora_final) {
        this.hora_final = hora_final;
    }
    
    
    
    
}

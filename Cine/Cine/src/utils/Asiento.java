package utils;

public class Asiento {
    
    private int id;
    private int sala;
    private String fila;
    private int numero;
    private String estado;
    
    public Asiento(int id, int sala, String fila, int numero, String estado) {
        this.id = id;
        this.sala = sala;
        this.fila = fila;
        this.numero = numero;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}

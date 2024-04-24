package utils;

public class Asiento {
    
    private int id;
    private int sala;
    private String fila;
    private int numero;
    private int id_venta;
    
    public Asiento(int id, int sala, String fila, int numero, int id_venta) {
        this.id = id;
        this.sala = sala;
        this.fila = fila;
        this.numero = numero;
        this.id_venta = id_venta;
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

    public int getVenta() {
        return id_venta;
    }

    public void setVenta(int  id_venta) {
        this.id_venta = id_venta;
    }
    
}

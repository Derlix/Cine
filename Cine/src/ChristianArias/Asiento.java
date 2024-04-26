package ChristianArias;

public class Asiento {

    private int idAsiento;
    private int idSala;
    private String fila;
    private int idFuncion;
    private int numero;

    // Constructor
    public Asiento(int idAsiento, int idSala, String fila, int idFuncion, int numero) {
        this.idAsiento = idAsiento;
        this.idSala = idSala;
        this.fila = fila;
        this.idFuncion = idFuncion;
        this.numero = numero;
    }

    // Getters y Setters
    public int getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void reservarAsiento() {

    }
}

package CristianArce;

public class Venta {
    
    private int id_venta;
    private int id_pelicula;
    private int id_funcion;
    private int id_usuario;
    private int cantidad_voletos;
    private double totalventa;
    private String fecha;

    public Venta(int id_venta, int id_pelicula, int id_funcion, int id_usuario, int cantidad_voletos, double total_venta, String fecha) {
        this.id_venta = id_venta;
        this.id_pelicula = id_pelicula;
        this.id_funcion = id_funcion;
        this.id_usuario = id_usuario;
        this.cantidad_voletos = cantidad_voletos;
        this.totalventa = total_venta;
        this.fecha = fecha;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public int getId_funcion() {
        return id_funcion;
    }

    public void setId_funcion(int id_funcion) {
        this.id_funcion = id_funcion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getCantidad_voletos() {
        return cantidad_voletos;
    }

    public void setCantidad_voletos(int cantidad_voletos) {
        this.cantidad_voletos = cantidad_voletos;
    }

    public double getTotal_venta() {
        return totalventa;
    }

    public void setTotal_venta(int totalventa) {
        this.totalventa = totalventa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}

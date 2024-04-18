
package utils;


public class Cine {
    private int id;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String pais;
    
    public Cine(int id, String nombre, String direccion, String ciudad, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
    }
    
    // Getter para el ID del cine
    public int getId() {
        return id;
    }
    
    // Setter para el ID del cine
    public void setId(int id) {
        this.id = id;
    }
    
    // Getter para el nombre del cine
    public String getNombre() {
        return nombre;
    }
    
    // Setter para el nombre del cine
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Getter para la dirección del cine
    public String getDireccion() {
        return direccion;
    }
    
    // Setter para la dirección del cine
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    // Getter para la ciudad del cine
    public String getCiudad() {
        return ciudad;
    }
    
    // Setter para la ciudad del cine
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    // Getter para el país del cine
    public String getPais() {
        return pais;
    }
    
    // Setter para el país del cine
    public void setPais(String pais) {
        this.pais = pais;
    }
}

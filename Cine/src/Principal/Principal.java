
package Principal;

import utils.BaseDatos;

public class Principal {
    
    public static void main(String[] args) {
        BaseDatos basedatos = new BaseDatos();
        basedatos.obtenerTodosLosCines();
        basedatos.obtenerTodosLosUsuarios();
        basedatos.obtenerTodasLasPeliculas();
    }
}

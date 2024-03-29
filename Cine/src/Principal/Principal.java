package Principal;


import JuanCamilo.EliminarPelicula;
import utils.BaseDatosJuanPrincipal;

public class Principal {
    
    public static void main(String[] args) {
        BaseDatosJuanPrincipal basedatos = new BaseDatosJuanPrincipal();
        //CrearPelicula ventana = new CrearPelicula(basedatos);
        MenuAdministrador ventana02 =new MenuAdministrador(basedatos);
        //EditarPelicula ventanaeditar= new EditarPelicula();
        //MostrarPeliculas ventana00 = new MostrarPeliculas(basedatos);
        //EliminarPelicula ventanaprueba = new EliminarPelicula(basedatos);
        
    }
}

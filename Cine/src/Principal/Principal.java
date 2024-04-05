package Principal;


import JuanCamilo.CrearCine;
import JuanCamilo.EditarCine;
import JuanCamilo.EliminarCine;
import JuanCamilo.EliminarPelicula;
import JuanCamilo.VerCine;
import utils.BaseDatosJuanPrincipal;

public class Principal {
    
    public static void main(String[] args) {
        BaseDatosJuanPrincipal basedatos = new BaseDatosJuanPrincipal();
        //CrearPelicula ventana = new CrearPelicula(basedatos);
        MenuAdministrador ventana02 =new MenuAdministrador(basedatos);
        //EditarPelicula ventanaeditar= new EditarPelicula();
        //MostrarPeliculas ventana00 = new MostrarPeliculas(basedatos);
        //EliminarPelicula ventanaprueba = new EliminarPelicula(basedatos);
        //CrearCine ventanaP =new CrearCine(basedatos);
        //EditarCine ventanapr = new EditarCine(basedatos);
        //EliminarCine ventanar = new EliminarCine(basedatos);
        //VerCine ventanaPru = new VerCine(basedatos);
        
    }
}

package Principal;


import JuanCamilo.CrearCine;
import JuanCamilo.CrearFuncion;
import JuanCamilo.CrearUsuario;
import JuanCamilo.EditarCine;
import JuanCamilo.EditarFuncion;
import JuanCamilo.EditarUsuario;
import JuanCamilo.EliminarCine;
import JuanCamilo.EliminarFuncion;
import JuanCamilo.EliminarPelicula;
import JuanCamilo.VerCine;
import utils.BaseDatosJuanBustamante;
import utils.BaseDatosJuanPrincipal;
import utils.CristianBD;

public class Principal {
    
    public static void main(String[] args) {
        BaseDatosJuanPrincipal basedatos = new BaseDatosJuanPrincipal();
        CristianBD bd = new CristianBD();
        BaseDatosJuanBustamante bd2 = new BaseDatosJuanBustamante();
        //CrearPelicula ventana = new CrearPelicula(basedatos);
        //MenuAdministrador ventana02 =new MenuAdministrador(basedatos);
        //EditarPelicula ventanaeditar= new EditarPelicula();
        //MostrarPeliculas ventana00 = new MostrarPeliculas(basedatos);
        //EliminarPelicula ventanaprueba = new EliminarPelicula(basedatos);
        //CrearCine ventanaP =new CrearCine(basedatos);
        //EditarCine ventanapr = new EditarCine(basedatos);
        //EliminarCine ventanar = new EliminarCine(basedatos);
        //VerCine ventanaPru = new VerCine(basedatos);
        //InicioSesion ventana = new InicioSesion(basedatos,bd);
        //CrearUsuario v = new CrearUsuario(basedatos);
        //EditarUsuario b = new EditarUsuario(basedatos);
        EliminarFuncion r = new EliminarFuncion(basedatos);

    }
}


import java.io.File;

public class Main {
    public static void main(String[] args) {
        ConfiguracionesIniciales configuracion = new ConfiguracionesIniciales();
        File archivo = new File(configuracion.getPropiedad("NOMBRE"));
        Operaciones operaciones = new Operaciones(archivo, configuracion);
        TransmisorDatos connect = new TransmisorDatos();
        Vista vista = new Vista();
        vista.setOperaciones(operaciones);
        vista.setTransmisor(connect);
        connect.setVista(vista);
        operaciones.setVista(vista);
        connect.setOperaciones(operaciones);
        vista.crearVista();
    }
}
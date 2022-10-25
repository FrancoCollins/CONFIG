public class TransmisorDatos {
    private Vista vista;
    private Operaciones operaciones;

    public void introducirFrase(String frase) {

        operaciones.guardarFrase(frase);

    }

    public void mostrarFrasesCelebres() {
        operaciones.mostrarListado();
    }

    public void mostrarFraseAleatoria() {
        operaciones.mostrarFraseAleatoria();
    }

    public void salir() {
        operaciones.finalizarBucle();
    }

    public Vista getVista() {
        return vista;
    }

    public void setVista(Vista vista) {
        this.vista = vista;
    }

    public Operaciones getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(Operaciones operaciones) {
        this.operaciones = operaciones;
    }

    public void comprobarExistenciaFichero() {
        this.operaciones.comprobarCrearFichero();
    }

    public boolean comprobarPeso() {
        return operaciones.comprobarPeso();
    }
}

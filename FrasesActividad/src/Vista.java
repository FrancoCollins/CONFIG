import javax.swing.*;

public class Vista {
    private int seleccion;
    private Operaciones operaciones;
    private TransmisorDatos transmisor;

    private boolean archivoCreado;

    public void crearVista() {
        transmisor.comprobarExistenciaFichero();
        while (seleccion != 4) {
            try {
                seleccion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la opcion que desea ejecutar:" + "\n1: Introducir frases celebres" + "\n2: Mostrar listado de frases celebres" + "\n3: Mostrar frase celebre aleatoria" + "\n4: Salir"));
                switch (this.getSeleccion()) {
                    case 1:
                        if (transmisor.comprobarPeso()) {
                            transmisor.introducirFrase(JOptionPane.showInputDialog("Introduzca la frase celebre").trim());
                        } else {
                            archivoMuyGrande(operaciones.getArchivoTxt().length(), Long.parseLong(operaciones.getConfig().getPropiedad("MAXIM")));
                        }
                        break;
                    case 2:
                        transmisor.mostrarFrasesCelebres();
                        break;
                    case 3:
                        transmisor.mostrarFraseAleatoria();
                        break;
                    case 4:
                        if (transmisor.comprobarPeso()) {
                            transmisor.salir();
                        } else {
                            archivoMuyGrande(operaciones.getArchivoTxt().length(), Long.parseLong(operaciones.getConfig().getPropiedad("MAXIM")));
                        }
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "para salir presione 4 en el menu de seleccion");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opcion fuera del rango, por favor elija una opcion");
            }
            if (seleccion < 0 || seleccion > 4) {
                JOptionPane.showMessageDialog(null, "Opcion fuera del rango, por favor elija una opcion");

            }
        }
    }

    public int getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(int seleccion) {
        this.seleccion = seleccion;
    }

    public Operaciones getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(Operaciones operaciones) {
        this.operaciones = operaciones;
    }

    public TransmisorDatos getTransmisor() {
        return transmisor;
    }

    public void setTransmisor(TransmisorDatos transmisor) {
        this.transmisor = transmisor;
    }


    public void DebeIntroducir() {
        JOptionPane.showMessageDialog(null, "Debe introducir alguna frase");
    }

    public void volverMenuInicial() {
        JOptionPane.showMessageDialog(null, "No ha introducido ningun dato, se volverá al menú inicial");

    }

    public void mostrarListaEntera(String Lista) {
        JOptionPane.showMessageDialog(null, "la lista de frases celebres en el fichero es: \n" + Lista);

    }

    public void generarFraseRandom(String frase) {
        JOptionPane.showMessageDialog(null, "la frase aleatoria es:\n'" + frase + "'");
    }

    public void ficheroVacio() {
        JOptionPane.showMessageDialog(null, "El fichero está vacio, por favor introduzca una frase antes de seleccionar esta opcion");
    }

    public void archivoCreado() {
        JOptionPane.showMessageDialog(null, "Ha sido creado el fichero para la ejecucion de tareas");

    }

    public void archivoMuyGrande(long peso, long pesoMaximo) {
        JOptionPane.showMessageDialog(null, "El archivo posee un peso de: " + peso + " KB\n" +
                "El programa está configurado para trabajar con un peso maximo de: " + pesoMaximo + " KB\n" +
                "El programa se cerrara para que modifique la configuracion\n" +
                "y sus datos no seran guardados");
        transmisor.salir();

    }

    public void frasePesada(long frase, long peso, long pesoMaximo) {
        JOptionPane.showMessageDialog(null, "La frase ingresada pesa: " + frase + " KB\n" +
                "El archivo pesa actualmente: " + peso + " KB\n" +
                "No se puede guardar la frase porque sobrepasa el peso maximo\n" +
                "El archivo puede pesar un maximo de: " + pesoMaximo + " KB\n" +
                "Por favor modifique la configuracion y vuelva a intentarlo");
    }

    public void archivoVaciado() {
        JOptionPane.showMessageDialog(null, "El archivo ha sido vaciado para la ejecucion de tareas\n" +
                "En caso querer editar esta opcion dirigirse al fichero de configuracion");
    }

    public void fraseLarga() {
        JOptionPane.showMessageDialog(null, "La frase ingresada es demasiado larga, no se guardará " +
                "en el fichero.\n" +
                "En caso de querer cambiar esta opcion " +
                "dirigirse al fichero de configuracion del proyecto");
    }
}
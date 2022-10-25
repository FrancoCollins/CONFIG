import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Operaciones {
    private Vista vista;
    private final File archivoTxt;

    private ConfiguracionesIniciales config;


    public Operaciones(File archivo, ConfiguracionesIniciales config) {
        this.archivoTxt = archivo;
        this.config = config;

    }

    public void guardarFrase(String frase) {
        try {
            String frases = "";
            Scanner scan = new Scanner(archivoTxt);
            do {
                if (archivoTxt.length() != 0) {
                    frases += scan.nextLine() + "\n";
                }
            } while (scan.hasNextLine());
            FileWriter pw = new FileWriter(archivoTxt, true);
            try {
                if (!frase.equals("")) {
                    Long largo = Long.parseLong(config.getPropiedad("LARGO"));
                    Long pesoM = Long.parseLong(config.getPropiedad("MAXIM"));
                    long aux = Long.parseLong(String.valueOf((frase + "\n").length()));
                    if (frase.length() > largo) {
                        vista.fraseLarga();
                    } else {
                        if ((aux + archivoTxt.length()) > pesoM) {
                            vista.frasePesada(aux, archivoTxt.length(), pesoM);
                        } else {
                            pw.write(frase + "\n");
                        }
                    }

                } else {
                    vista.DebeIntroducir();
                }
                pw.close();

            } catch (NullPointerException e) {
                vista.volverMenuInicial();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Vista getVista() {
        return vista;
    }

    public void setVista(Vista vista) {
        this.vista = vista;
    }

    public void mostrarListado() {
        try {
            boolean vacio = false;
            String frase = "";
            String todo = "";
            Scanner scan = new Scanner(archivoTxt);
            int contador = 1;
            do {
                BufferedReader br = new BufferedReader(new FileReader(archivoTxt));
                if (br.readLine() == null) {
                    vista.ficheroVacio();
                    System.out.println(br.toString());
                    vacio = true;
                } else {
                    todo = scan.nextLine();
                    if (!todo.equals("")) {
                        frase += contador + ": " + todo + "\n";
                        contador++;
                    }
                }
            } while (scan.hasNextLine());
            if (!vacio) {
                vista.mostrarListaEntera(frase);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarFraseAleatoria() {
        try {
            HashMap<Integer, String> frases = new HashMap<>();
            String linea = "";
            Scanner scan = new Scanner(archivoTxt);
            int contador = 1;

            do {
                BufferedReader br = new BufferedReader(new FileReader(archivoTxt));
                if (br.readLine() == null) {
                    vista.ficheroVacio();
                } else {
                    linea = scan.nextLine();
                    if (!linea.equals("")) {
                        frases.put(contador, linea);
                        contador++;
                    }
                }
            } while (scan.hasNextLine());

            int random = (int) (Math.random() * ((contador - 1)) + 1);
            if (frases.get(random) != null) {
                vista.generarFraseRandom(frases.get(random));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void finalizarBucle() {
        System.exit(0);
    }

    public boolean comprobarPeso() {
        long peso = archivoTxt.length();
        long pesoMaximo = Long.parseLong(config.getPropiedad("MAXIM"));
        if (peso > pesoMaximo) {
            vista.archivoMuyGrande(peso, pesoMaximo);
            return false;
        } else
            return true;
    }


    public void comprobarCrearFichero() {
        try {
            if (!archivoTxt.exists()) {
                archivoTxt.createNewFile();
                vista.archivoCreado();
            } else {
                comprobarPeso();
                boolean borrar = Boolean.parseBoolean(config.getPropiedad("BORRAR"));
                if (borrar) {
                    archivoTxt.delete();
                    archivoTxt.createNewFile();
                    vista.archivoVaciado();
                }
            }
        } catch (Exception f) {
            f.printStackTrace();
        }
    }

    public File getArchivoTxt() {
        return archivoTxt;
    }

    public ConfiguracionesIniciales getConfig() {
        return config;
    }
}

	import javax.swing.JOptionPane;
	import java.util.ArrayList;
	import java.util.HashMap;
public class metodosInstrumento {
	private static HashMap<String, ArrayList<Double>> estudiantes = new HashMap<>();
    private static HashMap<String, Double> promedios = new HashMap<>();

    public static void main(String[] args) {
        nombresEstudiantes();
        calcularPromedios();
        mostrarResultados();
}
    public static void nombresEstudiantes() {
        String nombre;
        do {
            nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante (o 'fin' para terminar):");
            if (!nombre.equalsIgnoreCase("fin")) {
                double nota1 = validacionNotas("Nota 1");
                double nota2 = validacionNotas("Nota 2");
                double nota3 = validacionNotas("Nota 3");
                ArrayList<Double> notas = new ArrayList<>();
                notas.add(nota1);
                notas.add(nota2);
                notas.add(nota3);
                estudiantes.put(nombre, notas);
            }
        } while (!nombre.equalsIgnoreCase("fin"));
    }

    private static double validacionNotas(String not) {
        double nota = 0;
        do {
            nota = Double.parseDouble(JOptionPane.showInputDialog("Ingrese " + not));
            if (nota < 0 || nota > 5)
                System.out.println("La nota no está en el rango");
        } while (nota < 0 || nota > 5);
        return nota;
    }

    private static void calcularPromedios() {
        for (String nombre : estudiantes.keySet()) {
            ArrayList<Double> notas = estudiantes.get(nombre);
            double promedio = (notas.get(0) + notas.get(1) + notas.get(2)) / 3;
            promedios.put(nombre, promedio);
        }
    }

    public static int obtenerCantidadEstudiantes() {
        int cantidad = estudiantes.size();
        System.out.println("Cantidad total de estudiantes validados: " + cantidad);
        return cantidad;
    }

    public static int cantidadNotas() {
        int cantidadNotas = estudiantes.size() * 3;
        System.out.println("Cantidad total de notas ingresadas: " + cantidadNotas);
        return cantidadNotas;
    }

    public static int estuadiantesGananMateria() {
        int ganan = 0;
        for (Double promedio : promedios.values()) {
            if (promedio >= 3.5) {
                ganan++;
            }
        }
        System.out.println("Cantidad de estudiantes que ganan la materia: " + ganan);
        return ganan;
    }

    public static int contarEstudiantesQuePierden() {
        int pierden = 0;
        for (Double promedio : promedios.values()) {
            if (promedio < 3.5) {
                pierden++;
            }
        }
        System.out.println("Cantidad de estudiantes que pierden la materia: " + pierden);
        return pierden;
    }

    public static int estudiantesRecuperanMateria() {
        int recuperan = 0;
        for (Double promedio : promedios.values()) {
            if (promedio > 2 && promedio < 3.5) {
                recuperan++;
            }
        }
        System.out.println("Cantidad de estudiantes que pueden recuperar: " + recuperan);
        return recuperan;
    }
    
    public static int estudiantesSinRecuperacion() {
        int pierdenSinRecuperacion = 0;
        for (Double promedio : promedios.values()) {
            if (promedio <= 2) {
                pierdenSinRecuperacion++;
            }
        }
        System.out.println("Cantidad de estudiantes que pierden sin recuperación: " + pierdenSinRecuperacion);
        return pierdenSinRecuperacion;
    }

    public static double promedioGeneral() {
        double sumaPromedios = 0;
        for (Double promedio : promedios.values()) {
            sumaPromedios += promedio;
        }
        double promedioGeneral = sumaPromedios / promedios.size();
        System.out.println("Promedio de las notas finales obtenidas: " + String.format("%.2f", promedioGeneral));
        return promedioGeneral;
    }

    public static void listadoEstudiantes() {
        System.out.println("Listado total de estudiantes y sus notas finales:");
        for (String nombre : promedios.keySet()) {
            System.out.printf("%s: %.2f%n", nombre, promedios.get(nombre));
        }
    }


    private static void mostrarResultados() {
        obtenerCantidadEstudiantes();
        cantidadNotas();
        estuadiantesGananMateria();
        contarEstudiantesQuePierden();
        estudiantesRecuperanMateria();
        estudiantesSinRecuperacion();
        promedioGeneral();
        listadoEstudiantes();
    }
}

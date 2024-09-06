import java.util.HashMap;
import java.util.Scanner;

public class NotasHashmap {
	  public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        // HashMap para almacenar los estudiantes (clave: nombre, valor: promedio de notas)
	        HashMap<String, Double> estudiantes = new HashMap<>();
	        
	        int numEstudiantes;
	        
	        // Solicitar la cantidad de estudiantes
	        System.out.print("Ingrese la cantidad de estudiantes: ");
	        numEstudiantes = scanner.nextInt();
	        
	        // Ciclo para ingresar la información de cada estudiante
	        for (int i = 0; i < numEstudiantes; i++) {
	            System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
	            String nombre = scanner.next();
	            
	            // Solicitar las tres notas del estudiante
	            double nota1, nota2, nota3;
	            System.out.print("Ingrese la nota 1: ");
	            nota1 = scanner.nextDouble();
	            System.out.print("Ingrese la nota 2: ");
	            nota2 = scanner.nextDouble();
	            System.out.print("Ingrese la nota 3: ");
	            nota3 = scanner.nextDouble();
	            
	            // Calcular el promedio de las 3 notas
	            double promedio = (nota1 + nota2 + nota3) / 3;
	            estudiantes.put(nombre, promedio);
	        }
	        
	        // Variables para contar estudiantes que ganan o pierden
	        int ganan = 0, pierden = 0, recuperacion = 0;
	        
	        // Recorrer el HashMap y contar según el promedio
	        for (double promedio : estudiantes.values()) {
	            if (promedio >= 3.5) {
	                ganan++;
	            } else if (promedio >= 2) {
	                recuperacion++;
	            } else {
	                pierden++;
	            }
	        }
	        
	        // Mostrar resultados
	        System.out.println("Cantidad de estudiantes que ganan: " + ganan);
	        System.out.println("Cantidad de estudiantes que pierden: " + pierden);
	        System.out.println("Cantidad de estudiantes que pueden recuperar: " + recuperacion);
	        
	        // Mostrar el listado de estudiantes con sus notas finales
	        System.out.println("\nListado de estudiantes y sus notas finales:");
	        for (String nombre : estudiantes.keySet()) {
	            System.out.println(nombre + ": " + estudiantes.get(nombre));
	        }
	    }
	}
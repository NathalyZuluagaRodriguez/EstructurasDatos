import java.util.ArrayList;
import java.util.Scanner;

public class NotasArray {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	      
	        ArrayList<String> estudiantes = new ArrayList<>();
	        
	      
	        ArrayList<Double> notasFinales = new ArrayList<>();
	        
	        int numEstudiantes;
	        
	      
	        System.out.print("Ingrese la cantidad de estudiantes: ");
	        numEstudiantes = scanner.nextInt();
	        
	       
	        for (int i = 0; i < numEstudiantes; i++) {
	            System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
	            String nombre = scanner.next();
	            estudiantes.add(nombre);
	            
	       
	            double nota1, nota2, nota3;
	            System.out.print("Ingrese la nota 1: ");
	            nota1 = scanner.nextDouble();
	            System.out.print("Ingrese la nota 2: ");
	            nota2 = scanner.nextDouble();
	            System.out.print("Ingrese la nota 3: ");
	            nota3 = scanner.nextDouble();
	            
	           
	            double promedio = (nota1 + nota2 + nota3) / 3;
	            notasFinales.add(promedio);
	        }
	        
	  
	        int ganan = 0, pierden = 0, recuperacion = 0;
	        
	      
	        for (double notaFinal : notasFinales) {
	            if (notaFinal >= 3.5) {
	                ganan++;
	            } else if (notaFinal >= 2) {
	                recuperacion++;
	            } else {
	                pierden++;
	            }
	        }
	        
	        
	        System.out.println("Cantidad de estudiantes que ganan: " + ganan);
	        System.out.println("Cantidad de estudiantes que pierden: " + pierden);
	        System.out.println("Cantidad de estudiantes que pueden recuperar: " + recuperacion);
	        
	      
	        System.out.println("\nListado de estudiantes y sus notas finales:");
	        for (int i = 0; i < estudiantes.size(); i++) {
	            System.out.println(estudiantes.get(i) + ": " + notasFinales.get(i));
	        }
	    }
	}
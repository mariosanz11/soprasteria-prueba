import java.util.InputMismatchException;
import java.util.Scanner;

public class Personas {     // clase con características de las personas
    static class Persona {
        char sexo;
        int edad;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Persona[] personas = new Persona[50]; //vector para almacenar personas

        // pedimos ingreso de datos
        for (int i = 0; i < personas.length; i++) {
            personas[i] = new Persona();
            try {
                System.out.println("Ingrese el sexo de la persona " + (i + 1) + " (M/F):");
                char sexo = input.next().charAt(0);
                if (sexo != 'M' && sexo != 'F') { // asi nos aseguramos de que el usuario solo pueda escribir M o F
                    throw new InputMismatchException("Valor incorrecto. Debe ser 'M' o 'F'.");
                }
                personas[i].sexo = sexo;

                System.out.println("Ingrese la edad de la persona " + (i + 1) + ":");
                int edad = input.nextInt(); 
                if (edad < 0) { // asi nos aseguramos de que el usuario solo pueda un número positivo
                    throw new InputMismatchException("Debe ser un número positivo");
                }
                personas[i].edad = edad;
            } catch (InputMismatchException e) { // asi nos aseguramos de que el usuario solo pueda un número entero
                System.out.println("Error: escribe una edad con numero entero");
                input.nextLine(); // limpiamos entrada
                i--; // repetir la iteración para volver a solicitar los datos
            }
        }

        // contadores
        int mayorEdad = 0;
        int menorEdad = 0;
        int mayorEdadMan = 0;
        int menorEdadFem = 0;
        int personaFem = 0;

        // hacemos suma de las personas
        for (Persona persona : personas) {
            if (persona.edad >= 18) { // mayores de edad
                mayorEdad++;
                if (persona.sexo == 'M') { // mayores de edad masculinos
                    mayorEdadMan++;
                }
            } else { // menores de edad
                menorEdad++;
                if (persona.sexo == 'F') { // menores de edad femeninas
                    menorEdadFem++;
                }
            }

            if (persona.sexo == 'F'){ // mujeres en total
                personaFem++;
            }
        }

        // calculamos los porcentajes
        double porcentajeMayoresEdad = (mayorEdad / 50.0) * 100;
        double porcentajeMujeres = (personaFem / 50.0) * 100;

        System.out.println("a. Cantidad de personas mayores de edad: " + mayorEdad);
        System.out.println("b. Cantidad de personas menores de edad: " + menorEdad);
        System.out.println("c. Cantidad de personas masculinas mayores de edad: " + mayorEdadMan);
        System.out.println("d. Cantidad de personas femeninas menores de edad: " + menorEdadFem);
        System.out.println("e. Porcentaje de personas mayores de edad respecto al total de personas: " + porcentajeMayoresEdad + " %");
        System.out.println("f. Porcentaje que representan las mujeres respecto al total de personas: " + porcentajeMujeres + " %");
    }
}



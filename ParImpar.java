import java.util.InputMismatchException;
import java.util.Scanner;

public class ParImpar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Escribe un número entero: ");

        try {
            
            int numero = input.nextInt(); // Intentamos leer un número entero

            if (numero % 2 == 0) {
                System.out.println(numero + " es par");
                for (int i = numero-2; i >= 0; i -= 2) { //ponemos numero - 2 para que no lo incluya en la lista
                    System.out.println(i);
                }
            } else {
                System.out.println(numero + " es impar");
                for (int i = numero-2; i >= 1; i -= 2) { //ponemos numero - 2 para que no lo incluya en la lista
                    System.out.println(i);
                }
            }
        } catch (InputMismatchException e) { // hacemos una excepción para que no de error sino escribimos un entero
            System.out.println("Error: Debes ingresar un número entero");
        }
    }
}


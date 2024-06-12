import java.util.Scanner;

public class CalculadoraSalario {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int horas;
        double tarifa;

        // solicitar la cantidad de horas trabajadas
        do {
            System.out.println("Introduzca la cantidad de horas trabajadas:");
            while (!input.hasNextInt()) {
                System.out.println("Error: Debes ingresar un número entero"); //error si no introducimos numero entero de horas
                input.nextLine();
            }
            horas = input.nextInt();
            if (horas < 0) {
                System.out.println("Error: Debes ingresar un número positivo"); //error si no introducimos numeor positivo de horas
            }
        } while (horas < 0);
        input.nextLine();

        // solicitar la tarifa por hora
        do {
            System.out.println("Introduzca la tarifa por hora:");
            while (!input.hasNextDouble()) {
                System.out.println("Error: Debes ingresar un número válido"); //error si no introducimos numeor
                input.nextLine(); // limpiar el buffer de entrada
            }
            tarifa = input.nextDouble();
            if (tarifa < 0) {
                System.out.println("Error: Debes ingresar un número positivo"); //error si no introducimos numeor positivo
            }
        } while (tarifa < 0);

        // cálculo del salario
        double salario;

        if (horas > 40) { // si trabaja más de 40 horas se incrementa el precio de las horas extras
            salario = 40 * tarifa + (horas - 40) * tarifa * 1.5;
        } 
        else { // si no hay horas extras se calcula normalmente
            salario = horas * tarifa;
        }

        // Mostrar el salario recibido
        System.out.println("El salario recibido es: " + salario + "$");
    }
}

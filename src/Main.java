import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        double cantidad = 0; // Definimos la variable cantidad fuera del bucle


        do {
            System.out.println("[0] Introducir cantidad a cambiar");
            System.out.println("[1] Cambiar entre EUR a USD");
            System.out.println("[2] Cambiar entre EUR a GPB");
            System.out.println("[3] Salir");
            System.out.println("Seleccione una opción:");

            while (!sc.hasNextInt()) {
                System.out.println("Por favor, introduzca un número entero.");
                sc.nextLine(); // Limpiar el buffer del escáner
            }

            opcion = sc.nextInt();

            switch (opcion) {
                case 0:
                    // Lógica para introducir cantidad a cambiar
                    cantidad = startingAmount();
                    System.out.println(cantidad);
                    break;
                case 1:
                    if (cantidad > 0) {
                        changeCurrency(opcion, cantidad);
                    } else {
                        System.out.println("Primero debes introducir una cantidad.");
                    }
                    break;
                case 2:
                    if (cantidad > 0) {
                        changeCurrency(opcion, cantidad);
                    } else {
                        System.out.println("Debes introducir una cantidad.");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                    break;
            }
        } while (opcion != 3);

        sc.close(); // Cerrar el escáner al salir del menú
    }

    public static double startingAmount() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica que cantidad de monedas quieres cambiar:");

        double cantidad;

        if (sc.hasNextDouble()) {
            cantidad = sc.nextDouble();
        } else {
            System.out.println("Por favor, introduce un valor válido.");
            sc.nextLine(); // Limpiar el buffer del escáner
            cantidad = startingAmount(); // Volver a solicitar la entrada
        }
        return cantidad;
    }

    public static double changeCurrency(int opcion, double cantidad) {
        double resultado = 0;

        if (opcion==1) {
            resultado = cantidad * 1.13;
            System.out.println("La conversio de " + cantidad + "EUROS a USD son: " + resultado + "USD");

        } else if (opcion==2) {
            resultado = cantidad * 0.89;
            System.out.println("La conversio de " + cantidad + "EUROS a GPB son: " + resultado + "GPB");
        }
        return resultado;
    }
}

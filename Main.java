import java.util.Scanner;

public class Main {

    // Menu principal tiene como objetivo mostrar los datos
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion;
        
        // Bucle principal del menú
        do {
            
            System.out.println("\n|========== Recarga Tu Envase ==========|");
            System.out.println("|                                       |");
            System.out.println("| (1). Registrar venta                  |");
            System.out.println("| (2). Ver ventas registradas           |");
            System.out.println("| (3). Cancelar última venta            |");
            System.out.println("|                                       |");
            System.out.println("| (4). Salir                            |");
            System.out.println("|======== by Gabriela Alchacoa =========|");
            System.out.print("|Elige una opción (1-4): ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Registrar venta
                    System.out.println("Opción 1: Registrar venta");
                    break;
                case 2:
                    // Ver ventas registradas
                    System.out.println("Opción 2: Ver ventas registradas");
                    break;
                case 3:
                    // Cancelar última venta
                    System.out.println("Opción 3: Cancelar última venta");
                    break;
                case 4:
                    // salir
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor elige una opción entre 1 y 4.");
                    break;
            }

        } while (opcion != 4); 

        scanner.close();
    }
}

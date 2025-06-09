import java.util.Scanner;

public class Main {

    // Método para limpiar la consola
    public static void limpiarConsola() {
        try {
            // Limpiar la consola para Windows
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } 
            // Limpiar la consola para sistemas basados en Unix (Linux/Mac)
            else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error al limpiar la consola");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicializando un objeto de la clase Ventas
        Ventas ventas = new Ventas();

         ventas.cargarClientesEnCola(); // cargar clientes al inicio

        int opcion;
        
        // Bucle principal del menú
        do {
            limpiarConsola();
            
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
            scanner.nextLine();  

            switch (opcion) {
                case 1:
                    // Registrar venta
                    limpiarConsola();
                    ventas.verClientesEnCola(scanner);
                    ventas.registrarVenta(scanner);
                    break;
                case 2:
                    // Ver ventas registradas
                    limpiarConsola();
                    ventas.verVentasRegistradas(scanner);
                    break;
                case 3:
                    // Cancelar última venta
                    ventas.cancelarUltimaVenta(scanner);
                    break;
                case 4:
                    // salir
                    System.out.println("Saliendo del programa...");                   
                    scanner.close();  // Cerrar el scanner al final del programa
                    return;
                default:
                    System.out.println("Opción no válida. Por favor elige una opción entre 1 y 4.");
                    break;
            }

        } while (opcion != 4); 

        scanner.close();
    }
}

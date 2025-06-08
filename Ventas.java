import java.util.Scanner;

public class Ventas {
    // Clase Nodo para la lista enlazada
    class Nodo {
        String producto;
        int cantidad;
        double precio;
        Nodo siguiente;

        public Nodo(String producto, int cantidad, double precio) {
            this.producto = producto;
            this.cantidad = cantidad;
            this.precio = precio;
            this.siguiente = null;
        }
    }


    public static void verVentasRegistradas(Scanner scanner) {
        
        System.out.println("Producto: Detergente, Cantidad: 3, Precio: 2.5");
        System.out.println("Producto: Desinfectante, Cantidad: 5, Precio: 3.0");
        System.out.println("Producto: Jabón para manos, Cantidad: 2, Precio: 1.5");
        System.out.println("Producto: Limpiador multiusos, Cantidad: 4, Precio: 2.0");
        System.out.println("Producto: Blanqueador, Cantidad: 6, Precio: 1.8");
        System.out.println("Producto: Esponja de cocina, Cantidad: 10, Precio: 0.5");
        System.out.println("Producto: Papel higiénico, Cantidad: 12, Precio: 1.2");
        System.out.println("Producto: Limpiador de baño, Cantidad: 8, Precio: 3.5");
        System.out.println("Producto: Ambientador, Cantidad: 7, Precio: 2.2");
        System.out.println("Producto: Toallitas húmedas, Cantidad: 15, Precio: 0.8");
         // Esperar que el usuario presione Enter para continuar
        System.out.println("Presiona Enter para continuar...");
        scanner.nextLine();  // Esperar a que el usuario presione Enter
        System.out.println("¡Gracias por continuar!");
    }
}

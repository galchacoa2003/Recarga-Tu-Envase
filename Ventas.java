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

    // Clase Producto que contiene nombre, cantidad y precio
    class Producto {
        String nombre;
        int cantidad;
        double precio;

        public Producto(String nombre, int cantidad, double precio) {
            this.nombre = nombre;
            this.cantidad = cantidad;
            this.precio = precio;
        }
    }

    // Lista de productos 
    Producto[] productosDisponibles;

    // Constructor de Ventas
    public Ventas() {
        // Pre-cargar productos
        productosDisponibles = new Producto[]{
            new Producto("Detergente", 50, 2.5),
            new Producto("Desinfectante", 50, 3.0),
            new Producto("Blanqueador", 20, 1.8),
            new Producto("Limpiador Multiusos", 20, 2.0)
        };
    }

    // Método para mostrar los productos disponibles
    public void mostrarProductosDisponibles(Scanner scanner) {
        System.out.println("\nProductos disponibles:");
        for (int i = 0; i < productosDisponibles.length; i++) {
            System.out.println((i + 1) + ". " + productosDisponibles[i].nombre + " - Cantidad: " + productosDisponibles[i].cantidad + " - Precio: $" + productosDisponibles[i].precio);
        }
         // Esperar que el usuario presione Enter para continuar
        System.out.println("Presiona Enter para continuar...");
        scanner.nextLine();  // Esperar a que el usuario presione Enter
        System.out.println("¡Gracias por continuar!");
    }

    // Método para mostrar ventas registradas (actualmente solo muestra los productos)
    public  void verVentasRegistradas(Scanner scanner) {
        
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

import java.util.Scanner;

// Nodo de la cola de clientes
class NodoCola {
    String nombreCliente;
    NodoCola siguiente;

    public NodoCola(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        this.siguiente = null;
    }
}

// Implementación propia de una cola
class ColaClientes {
    private NodoCola frente;
    private NodoCola fin;

    public ColaClientes() {
        frente = null;
        fin = null;
    }

    public void encolar(String nombreCliente) {
        NodoCola nuevo = new NodoCola(nombreCliente);
        if (frente == null) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public String desencolar() {
        if (frente == null) return null;
        String cliente = frente.nombreCliente;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        return cliente;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void mostrarCola() {
        NodoCola actual = frente;
        System.out.println("\nClientes en espera:");
        while (actual != null) {
            System.out.println("- " + actual.nombreCliente);
            actual = actual.siguiente;
        }
    }
}

// Clase principal de ventas
public class Ventas {

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

    class Producto {
        String nombre;
        int stock;
        double precio;

        public Producto(String nombre, int stock, double precio) {
            this.nombre = nombre;
            this.stock = stock;
            this.precio = precio;
        }
    }

    Producto[] productos;
    Nodo inicio;
    ColaClientes cola; 

    public Ventas() {
        productos = new Producto[]{
            new Producto("Detergente", 50, 2.5),
            new Producto("Desinfectante", 50, 3.0),
            new Producto("Blanqueador", 20, 1.8),
            new Producto("Multiusos", 20, 2.0)
        };
        inicio = null;
        cola = new ColaClientes();
    }

    public void limpiarConsola() {
        try {
            String sistema = System.getProperty("os.name");
            if (sistema.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("No se pudo limpiar la consola.");
        }
    }

    public void mostrarProductosDisponibles() {
        System.out.println("\nProductos disponibles:");
        for (int i = 0; i < productos.length; i++) {
            System.out.println((i + 1) + ". " + productos[i].nombre +
                " - Stock: " + productos[i].stock +
                " - Precio: $" + productos[i].precio);
        }
    }

    // Cargar algunos clientes en cola
    public void cargarClientesEnCola() {
        cola.encolar("Gabriel Villegas");
        cola.encolar("Gabriela Alchacoa");
        cola.encolar("Perez Jiménez");
    }

    public void registrarVenta(Scanner scanner) {
        if (cola.estaVacia()) {
            System.out.println("No hay clientes en cola.");
            System.out.println("Presione Enter para continuar...");
            scanner.nextLine();
            return;
        }

        String cliente = cola.desencolar();
        limpiarConsola();
        System.out.println("Atendiendo a: " + cliente);
        System.out.println("------------------------------------------");

        mostrarProductosDisponibles();

        int opcion = 0;
        while (true) {
            System.out.print("Ingrese el número del producto que quiere comprar: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); 
                if (opcion >= 1 && opcion <= productos.length) {
                    break;
                } else {
                    System.out.println("Número inválido. Intente nuevamente.");
                }
            } else {
                System.out.println("Entrada no válida. Debe ser un número.");
                scanner.nextLine(); 
            }
        }

        Producto seleccionado = productos[opcion - 1];

        limpiarConsola();
        System.out.println("Has seleccionado: " + seleccionado.nombre);
        System.out.println("Precio unitario: $" + seleccionado.precio);
        System.out.println("Stock disponible: " + seleccionado.stock);
        System.out.println("------------------------------------------");

        int cantidad = 0;
        while (true) {
            System.out.print("Ingrese la cantidad: ");
            if (scanner.hasNextInt()) {
                cantidad = scanner.nextInt();
                scanner.nextLine();
                if (cantidad > 0 && cantidad <= seleccionado.stock) {
                    break;
                } else {
                    System.out.println("Cantidad inválida o sin stock suficiente. Intente nuevamente.");
                }
            } else {
                System.out.println("Entrada no válida. Debe ser un número.");
                scanner.nextLine();
            }
        }

        double total = cantidad * seleccionado.precio;
        limpiarConsola();

        System.out.println("Resumen de la compra:");
        System.out.println("---------------------------");
        System.out.println("Cliente: " + cliente);
        System.out.println("Producto: " + seleccionado.nombre);
        System.out.println("Cantidad: " + cantidad);
        System.out.printf("Precio unitario: $%.2f\n", seleccionado.precio);
        System.out.println("---------------------------");
        System.out.printf("Total a pagar: $%.2f\n", total);

        double pago = 0;
        while (true) {
            System.out.print("Ingrese el monto con el que va a pagar: $");
            if (scanner.hasNextDouble()) {
                pago = scanner.nextDouble();
                scanner.nextLine();
                if (pago >= total) {
                    break;
                } else {
                    System.out.printf("Pago insuficiente. Faltan $%.2f\n", total - pago);
                }
            } else {
                System.out.println("Entrada no válida. Debe ser un monto numérico.");
                scanner.nextLine();
            }
        }

        double cambio = pago - total;
        System.out.printf("Pago recibido. Su cambio es: $%.2f\n", cambio);

        System.out.print("¿Desea confirmar la venta? (s/n): ");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
            seleccionado.stock -= cantidad;
            agregarVenta(seleccionado.nombre, cantidad, seleccionado.precio);
            System.out.println("Venta realizada correctamente.");
        } else {
            System.out.println("Venta cancelada. Reembolsando: $" + pago);
        }

        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
    }

    public void agregarVenta(String nombre, int cantidad, double precio) {
        Nodo nueva = new Nodo(nombre, cantidad, precio);
        if (inicio == null) {
            inicio = nueva;
        } else {
            Nodo actual = inicio;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nueva;
        }
    }

    public void verVentasRegistradas(Scanner scanner) {
        if (inicio == null) {
            System.out.println("No hay ventas aún.");
        } else {
            Nodo actual = inicio;
            System.out.println("\nVentas registradas:");
            while (actual != null) {
                System.out.println("- Producto: " + actual.producto +
                        " | Cantidad: " + actual.cantidad +
                        " | Precio unitario: $" + actual.precio);
                actual = actual.siguiente;
            }
        }

        System.out.println("Presione Enter para volver al menú...");
        scanner.nextLine();
    }

    public void verClientesEnCola(Scanner scanner) {
        cola.mostrarCola();
        scanner.nextLine();
    }
}

import factory.*;      
import pedido.*;
import envio.*;         
import validador.*;    
import iterator.*;      

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HistorialPedidos historial = new HistorialPedidos();

        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== Gestor de Pedidos ===");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ingresar nuevo pedido");
            System.out.println("2. Ver historial de pedidos");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    ingresarPedido(sc, historial);
                    break;
                case "2":
                    mostrarHistorial(historial);
                    break;
                case "3":
                    System.out.println("Saliendo del sistema. ¡Hasta pronto!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

        sc.close();
    }

    public static void ingresarPedido(Scanner sc, HistorialPedidos historial) {
        int tipo = -1;
        while (tipo != 1 && tipo != 2) {
            System.out.println("\nIngrese tipo de pedido:");
            System.out.println("1. Pedido Nacional");
            System.out.println("2. Pedido Internacional");
            System.out.print("Opción: ");
            String input = sc.nextLine();
            try {
                tipo = Integer.parseInt(input);
                if (tipo != 1 && tipo != 2) {
                    System.out.println("Opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
            }
        }

        System.out.print("Ingrese nombre del cliente: ");
        String cliente = sc.nextLine();

        double monto = -1;
        while (monto < 0) {
            System.out.print("Ingrese monto del pedido: ");
            String montoStr = sc.nextLine();
            try {
                monto = Double.parseDouble(montoStr);
                if (monto < 0) {
                    System.out.println("El monto debe ser positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Monto inválido.");
            }
        }

        // PATRON CREACIONAL
        PedidoFactory factory = (tipo == 1) ? new NacionalPedidoFactory() : new InternacionalPedidoFactory();
        Pedido pedido = factory.crearPedido(cliente, monto);
        pedido.procesarPedido();

        System.out.print("Ingrese dirección destino: ");
        String destino = sc.nextLine();
        pedido.setDestino(destino);

        // PATRON ESCRTUCTURAL
        ServicioEnvio envio = new ServicioEnvioProxy();
        envio.enviar(destino);

        // PATRON DE COMPORTAMIENTO
        Validador val1 = new ValidadorStock();
        Validador val2 = new ValidadorDireccion();
        Validador val3 = new ValidadorPago();
        val1.establecerSiguiente(val2);
        val2.establecerSiguiente(val3);
        val1.validar();

        historial.agregarPedido(pedido);
        System.out.println("✅ Pedido registrado exitosamente.");
    }

    public static void mostrarHistorial(HistorialPedidos historial) {
        System.out.println("\n=== Historial de Pedidos ===");

        // PATRON ITERATOR
        PedidoIterator iterador = historial.crearIterator();
        if (!iterador.hasNext()) {
            System.out.println("No hay pedidos registrados.");
        }
        while (iterador.hasNext()) {
            Pedido p = iterador.next();
            System.out.println(p.obtenerInfo());
        }
    }
}


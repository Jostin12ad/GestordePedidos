package pedido;

public class PedidoInternacional extends Pedido {
    public PedidoInternacional(String cliente, double monto) {
        super(cliente, monto);
    }

    @Override
    public void procesarPedido() {
        System.out.println("Procesando pedido internacional de " + cliente);
    }
}
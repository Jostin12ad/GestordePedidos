package pedido;

public class PedidoNacional extends Pedido {
    public PedidoNacional(String cliente, double monto) {
        super(cliente, monto);
    }

    @Override
    public void procesarPedido() {
        System.out.println("Procesando pedido nacional de " + cliente);
    }
}
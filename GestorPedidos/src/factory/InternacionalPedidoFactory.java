package factory;

import pedido.*;

public class InternacionalPedidoFactory implements PedidoFactory {
    @Override
    public Pedido crearPedido(String cliente, double monto) {
        return new PedidoInternacional(cliente, monto);
    }
}
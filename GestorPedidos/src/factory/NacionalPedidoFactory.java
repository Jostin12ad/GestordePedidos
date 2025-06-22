package factory;

import pedido.*;

public class NacionalPedidoFactory implements PedidoFactory {
    @Override
    public Pedido crearPedido(String cliente, double monto) {
        return new PedidoNacional(cliente, monto);
    }
}

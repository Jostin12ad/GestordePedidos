package factory;

import pedido.Pedido;

public interface PedidoFactory {
    Pedido crearPedido(String cliente, double monto);
}

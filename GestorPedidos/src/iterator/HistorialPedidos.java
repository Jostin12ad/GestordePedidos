package iterator;

import pedido.Pedido;
import java.util.*;

public class HistorialPedidos {
    private List<Pedido> pedidos = new ArrayList<>();

    public void agregarPedido(Pedido p) {
        pedidos.add(p);
    }

    public PedidoIterator crearIterator() {
        return new PedidoIterator(pedidos);
    }
}
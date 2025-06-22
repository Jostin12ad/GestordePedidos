package iterator;

import pedido.Pedido;
import java.util.List;
import java.util.Iterator;



public class PedidoIterator implements Iterator<Pedido> {
    private List<Pedido> pedidos;
    private int posicion = 0;

    public PedidoIterator(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public boolean hasNext() {
        return posicion < pedidos.size();
    }

    @Override
    public Pedido next() {
        return pedidos.get(posicion++);
    }
}
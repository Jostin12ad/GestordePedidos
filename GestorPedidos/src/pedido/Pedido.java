package pedido;

public abstract class Pedido {
    protected String cliente;
    protected double monto;
    protected String destino; 

    public Pedido(String cliente, double monto) {
        this.cliente = cliente;
        this.monto = monto;
    }

    public abstract void procesarPedido();

    
    public String getCliente() {
        return cliente;
    }

    public double getMonto() {
        return monto;
    }

    public String getDestino() {
        return destino;
    }

   
    public void setDestino(String destino) {
        this.destino = destino;
    }

  
    public String obtenerInfo() {
        return "Cliente: " + cliente + ", Monto: $" + monto + ", Destino: " + destino;
    }
}

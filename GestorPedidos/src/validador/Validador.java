package validador;

public abstract class Validador {
    protected Validador siguiente;

    public void establecerSiguiente(Validador sig) {
        this.siguiente = sig;
    }

    public void validar() {
        manejar();
        if (siguiente != null) siguiente.validar();
    }

    protected abstract void manejar();
}
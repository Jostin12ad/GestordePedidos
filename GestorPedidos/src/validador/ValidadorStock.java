package validador;

public class ValidadorStock extends Validador {
    @Override
    protected void manejar() {
        System.out.println("Validando stock disponible...");
    }
}
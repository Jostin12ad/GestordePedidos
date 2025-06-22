package envio;

public class ServicioEnvioProxy implements ServicioEnvio {
    private ServicioEnvioReal real = new ServicioEnvioReal();

    @Override
    public void enviar(String destino) {
        System.out.println("[Proxy] Verificando destino...");
        real.enviar(destino);
    }
}

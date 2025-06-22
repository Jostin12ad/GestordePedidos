package envio;

public class ServicioEnvioReal implements ServicioEnvio {
    @Override
    public void enviar(String destino) {
        System.out.println("Enviando paquete a: " + destino);
    }
}
package cajero;

public class Consulta extends Cajero{
    @Override
    public void transaccion() {
        System.out.println("Saldo es: "+getSaldo());
    }
}

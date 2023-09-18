package cajero  ;

public class DepositarSaldo extends Cajero{
    @Override
    public void transaccion() {
        System.out.println("Saldo a depositar: ");
        Depositar();
        transacciones=getSaldo();
        setSaldo(transacciones+depositar);
        System.out.println("Depositaste: "+depositar);
        System.out.println("Saldo actual: "+getSaldo());
    }   
}

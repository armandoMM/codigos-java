package cajero;

public class RetirarSaldo extends Cajero{

    @Override
    public void transaccion() {
        System.out.println("Saldo a retirar: ");
        Retiro();
        if(retiro<=getSaldo()){
            transacciones=getSaldo();
            setSaldo(transacciones-retiro);
            System.out.println("Retiraste: "+retiro);
            System.out.println("Saldo actual: "+getSaldo());
        }else{
            System.out.println("Saldo insuficiente...");
        }
    }  
}

package cajero;
import java.util.Scanner;

public abstract class Cajero {
    private static int saldo;      
    Scanner input = new Scanner(System.in);
    protected int transacciones,retiro, depositar;
    
    public void Operaciones(){
        int opc;
        Cajero user;
        do{
            System.out.println("1- Consultar saldo");
            System.out.println("2- Retirar efectivo");
            System.out.println("3- Depositar efectivo");
            System.out.println("4- Salir");
            opc=input.nextInt();
            switch(opc){
                case 1:
                    user = new Consulta();
                    user.transaccion();
                    break;
                case 2:
                    user = new RetirarSaldo();
                    user.transaccion();
                    break;
                case 3:
                    user = new DepositarSaldo();
                    user.transaccion();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("OPCION INCORRECTA");
            }
        }while(opc!=4);
    }
    
    public void Retiro(){
        retiro=input.nextInt();
    }
    
    public void Depositar(){
        depositar=input.nextInt();
    }
    
    public int getSaldo(){
        return saldo;
    }
    
    public void setSaldo(int saldo){
        this.saldo=saldo;
    }
    
    public abstract void transaccion();
}

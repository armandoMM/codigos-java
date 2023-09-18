package division;
import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        int value1, value2,res;
        Scanner input = new Scanner(System.in);
    
        try{
            System.out.println("primer valor: ");
            value1=input.nextInt();

            System.out.println("segundo valor: ");
            value2=input.nextInt();

            res=value1/value2;
            System.out.println("Resultado: "+res);
        }catch(Exception e){
            System.out.println("ERROR!!11"+e);
        }finally{
            System.out.println("OPERACION FINALIZADA.");
        }
        
    }
}

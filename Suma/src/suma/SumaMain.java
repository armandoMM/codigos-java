package suma;

import java.util.Scanner;

public class SumaMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Dame valor 1: ");
        int value1=input.nextInt();
        
        System.out.println("Dame valor 2: ");
        int value2=input.nextInt();
        
        Suma resultado=new Suma(value1,value2);
        resultado.imprimir();
    }
}

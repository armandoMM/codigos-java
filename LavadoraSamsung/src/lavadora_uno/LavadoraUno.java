package lavadora_uno;
import Libreria.LLFunciones;
import java.util.Scanner;

public class LavadoraUno {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Tipo de ropa: ");
        System.out.println("1- white clothes  / 2- color clothes");
        int type=input.nextInt();
        System.out.println("KG of clothes: ");
        int kilo=input.nextInt();
        
        LLFunciones lavadora= new LLFunciones(kilo,type);
        lavadora.setTypeClothes(2);
        lavadora.cycleFinished();
        
    }
}

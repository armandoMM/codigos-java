package classes;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        byte opc;
        Scanner input = new Scanner(System.in);
        Tree arbol = new Tree();
        
        do{
            System.out.println("menu");
            System.out.println("1. insertar elemento\n2. desplegar arbol\n3. salir");
            opc = input.nextByte();
            switch(opc){
                case 1:
                    System.out.println("Escribe un número: ");
                    int val = input.nextInt();
                    arbol.add(val);
                    break;
                case 2:
                    arbol.inorder(arbol.getRoot());
                    break;
                case 3:
                    System.out.println("Escribe el numero a buscar");
                    int b = input.nextInt();
                    //arbol.
                    break;
                case 4:
                    opc=4;
                    break;
                default:
                    System.out.println("opcion incorrecta");
                    break;
            }
        }while(opc != 4);
    }
}

package area;

import java.util.Scanner;

public class RectangleMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Base: ");
        int base=input.nextInt();
        
        System.out.println("Altura: ");
        int height=input.nextInt();
        
        Rectangle figure = new Rectangle(base,height);
        
        figure.printArea();
    }
}

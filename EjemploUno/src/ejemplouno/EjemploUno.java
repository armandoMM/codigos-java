package ejemplouno;
import java.util.Scanner;

/**
 * @author Armando Matias Montaño
 */
public class EjemploUno {
    public static void main(String[] args) {
        String invertWord="";
        String word;
        int leng;
        System.out.println("DAME UNA FRASE: ");
        Scanner input = new Scanner(System.in);
        word= input.nextLine();
        
        leng=word.length();
        
        while (leng!=0) {
            invertWord+=word.substring(leng-1,leng);
            leng--;
        }
        System.out.println("Palabra invertida: " + invertWord);
    }
    
}

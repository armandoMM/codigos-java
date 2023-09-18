 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome;

/**
 *
 * @author leledezma
 */
public class UsaPalabraRun {
    public static void main (String[] args) throws InterruptedException {
    Runnable pal1 = new PalabraRun("casa");
    Runnable pal2 = new PalabraRun("ala");
    Runnable pal3 = new PalabraRun("Oso");
    
    new Thread(pal1).start();
    new Thread(pal2).start();
    new Thread(pal3).start();
    System.out.println("Hilos terminados.");
}
}

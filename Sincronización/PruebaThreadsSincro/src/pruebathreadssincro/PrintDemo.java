/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebathreadssincro;

/**
 *
 * @author leledezma
 */
public class PrintDemo {
    private boolean available = false;
     public synchronized void printCount(){
        while(available){
            try {
                for(int i = 5; i > 0; i--) {
                    System.out.println("Contador   ---   "  + i );
                    wait();
                }
            } catch (Exception e) {
                System.out.println("Thread  interrumpido.");
            }
        }
        available = false;
        
   }
    
}

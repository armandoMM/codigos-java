/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebathreadssincro;

/**
 *
 * @author leledezma
 */
public class PruebaThreadsSincro {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

      PrintDemo PD = new PrintDemo();
      ThreadDemo T1 = new ThreadDemo( "Thread - 1 ", PD );
      ThreadDemo T2 = new ThreadDemo( "Thread - 2 ", PD );

      T1.start();
      T2.start();

      // esperando que finalizen los threads
      //Si un Thread necesita esperar a que otro termine (por ejemplo el Thread padre espera a que termine el hijo) 
      //puede usar el método join().
      //¿Por qué se llama así? Crear un proceso es como una bifurcación, 
      //se abren 2 caminos, que uno espere a otro es lo contrario, una unificación.
      try {
         T1.join();
         T2.join();
      } catch( Exception e) {
         System.out.println("interrupcion");
      }
   }
}

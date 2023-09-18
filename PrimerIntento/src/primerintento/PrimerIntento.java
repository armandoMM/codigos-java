/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primerintento;

/**
 *
 * @author leledezma
 */
public class PrimerIntento extends Thread
{
public static volatile long turno;
public static volatile long[] turnos;
public static volatile int indice = 0;
@Override          
public void run() {
    for(int i = 0; i < 10; ++i) {
        //Antes del pre-protocolo
        //System.out.println(this.getName() + ": Antes del pre-protocolo.");
        //Pre-protocolo
        //System.out.println(this.getName() + ": Pre-protocolo");
        while (turno != this.getId()) {System.out.println(this.getName() + ": *** ESPERANDO TURNO");}
            //Sección crítica
            System.out.println(this.getName() + ": Sección crítica. Vuelta " + i);
        //Post-protocolo
        //System.out.println(this.getName() + ": Post-protocolo");
          if(indice == 1)
               indice = 0;
           else
            ++indice;
        turno = turnos[indice];
    }
}
public static void main(String[] args) throws InterruptedException
{
    PrimerIntento t1 = new PrimerIntento();
    PrimerIntento t2 = new PrimerIntento();
    
    turnos = new long[2];
    turnos[0] = t1.getId();
    turnos[1] = t2.getId();
    turno = turnos[indice];
    t1.start();
    t2.start();
    t1.join();
    t2.join();
}
}

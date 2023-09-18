/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundo;

/**
 *
 * @author leledezma
 */
public class HolaMundo extends Thread {
    static private Semaphore semaforo = new Semaphore(1); //se crea el semaforo
    /*static private int COUNT=0;  */
    String cadena;
    public HolaMundo(String cad) {
     cadena=cad;
    }

    @Override
    public void run () {
        semaforo.WAIT();
        System.out.println(cadena);
        semaforo.SIGNAL();
        try {
            Thread.currentThread().sleep((int)(Math.random() * 100));
        } catch (InterruptedException e){}
    }

    public static void main (String args []) {
        HolaMundo H = new HolaMundo("Hola");
        HolaMundo M = new HolaMundo("Mundo");
        HolaMundo M2 = new HolaMundo("skirt");
        HolaMundo M4 = new HolaMundo("x");
        HolaMundo M5 = new HolaMundo("m");
        H.start();
        M.start();
        M2.start();
        M4.start();
        M5.start();
    }
}


class Semaphore{
    private int contador;
    public Semaphore(int n) {
        this.contador = n;
    }
    //metodo de espera o P()
    public synchronized void WAIT(){
        while(contador == 0) {
            try {
               wait();
             } catch (InterruptedException e) {}
             //contador--;
         }//fin de while
        contador--;
    } //fin de WAIT

    //metodo de señal o V()
    public synchronized void SIGNAL(){
        contador++;
        notify();
    }
}

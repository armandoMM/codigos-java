/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quintointento;

/**
 *
 * @author leledezma
 */
public class QuintoIntento extends Thread {

    /**
     * @param args the command line arguments
     */
    public static volatile long turno;
    public static volatile long[] turnos;
    public static volatile int indice = 0;
    public static volatile boolean[] permisos;
    public void run() {
        for(int i = 0; i < 10; ++i) {
            //Antes del pre-protocolo
            //System.out.println(this.getName() + ": Antes del pre-protocolo.");
            //Pre-protocolo
            //System.out.println(this.getName() + ": Pre-protocolo");
            String name = this.getName();
            name = name.replace("Thread-", "");
            int numThread = Integer.parseInt(name);
            int otroThread;
            if (numThread == 0)
                otroThread = 1;
            else
                otroThread = 0;
            permisos[numThread] = false;
            while(permisos[otroThread] == false) {
              if(turno != this.getId()) {
                permisos[numThread] = true;
                while(turno != this.getId()) {}
                permisos[numThread] = false;
                }
            }
            //Sección crítca
            System.out.println(this.getName() + ": Sección crítica. Vuelta " + i);
            //Post-protocolo
            //System.out.println(this.getName() + ": Post-protocolo");
             permisos[numThread] = true;
              if(indice == 1)
                    indice = 0;
              else
                    ++indice;
            turno = turnos[indice];
            }
}
    public static void main(String[] args) throws InterruptedException {
       QuintoIntento t1 = new QuintoIntento();
       QuintoIntento t2 = new QuintoIntento();
        turnos = new long[2];
        turnos[0] = t1.getId();
        turnos[1] = t2.getId();
        turno = turnos[indice];
        permisos = new boolean[2];
        for (int i = 0; i < 2; ++i)
           permisos[i] = true;
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

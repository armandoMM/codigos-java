/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package segundointento;

/**
 *
 * @author leledezma
 */
public class SegundoIntento extends Thread
{
public static volatile boolean[] permisos;
@Override
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
        
        System.out.println(this.getName() + ": permisos[otroThread:"+otroThread+"] = " + permisos[otroThread]);
         while (permisos[otroThread] == true) {
             System.out.println(this.getName() + ": En el bucle, permisos[OtroThread:" +    otroThread + "] = " + permisos[otroThread]);
          }
        permisos[numThread] = true;
        //Sección crítica
        System.out.println(this.getName() + ": Sección crítica. Vuelta " + i);
        //Post-protocolo
       // System.out.println(this.getName() + ": Post-protocolo");
        permisos[numThread] = false;
    }
}
public static void main(String[] args) throws InterruptedException
{
SegundoIntento t1 = new SegundoIntento();
SegundoIntento t2 = new SegundoIntento();
permisos = new boolean[2];
    for (int i = 0; i < 2; ++i)
        permisos[i] = false;
    t1.start();
    t2.start();
    t1.join();
    t2.join();
}
}

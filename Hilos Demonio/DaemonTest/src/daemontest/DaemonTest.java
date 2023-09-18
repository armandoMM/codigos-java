/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daemontest;

/**
 *
 * @author leledezma
 */
public class DaemonTest {

    public static void main(String[] args) {
        new WorkerThread().start();
        //try {
            //Thread.sleep(9000);
        //} catch (InterruptedException e) {}
        System.out.println("Main Thread termina") ;
    }

}
class WorkerThread extends Thread {

    public WorkerThread() {
        setDaemon(true) ;   // Cuando false, (i.e. es thread de usuario),
                // el Worker thread continua ejecutándose.
                // En true, (i.e. es un daemon thread),
                // el Worker thread finaliza cuando el thread principal 
                // termina.
    }

    public void run() {
        int count=0 ;
        while (true) {
            System.out.println("Hola desde el Worker "+count++) ;
            //try {
                //sleep(3000);
            //} catch (InterruptedException e) {}
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usosemaforos;

/**
 *
 * @author Administrador
 */
import java.util.concurrent.Semaphore;
public class p3 extends Thread  {
    protected Semaphore oFinP3;
    protected Semaphore oFinP1;
    public p3(Semaphore oFinP3,Semaphore oFinP1) {
        this.oFinP3 = oFinP3;
        this.oFinP1 = oFinP1;
    }
    public void run()  {
        try {
            sleep((int) Math.round(500 * Math.random() - 0.5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("P3");
        this.oFinP3.release(3);
        this.oFinP1.release(3);
    }
}


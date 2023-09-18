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
public class p2 extends Thread  {
    protected Semaphore oFinP1;
    protected Semaphore oFinP3;
    protected Semaphore oFinP5;
    public p2(Semaphore oFinP1,Semaphore oFinP3, Semaphore oFinP5) {
        this.oFinP3 = oFinP3;
        this.oFinP1 = oFinP1;
        this.oFinP5 = oFinP5;
    }
    
    @Override
    public void run()  {
        try {
        this.oFinP1.acquire();
        this.oFinP3.acquire();
        this.oFinP5.acquire();
        } catch(Exception e) {
            e.printStackTrace();
        }
        try {
            sleep((int) Math.round(500 * Math.random() - 0.5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("P2");
    }
}


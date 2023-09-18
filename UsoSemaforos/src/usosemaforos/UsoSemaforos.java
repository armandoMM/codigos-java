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
public class UsoSemaforos {
    protected static Semaphore oFinP1,oFinP3,oFinP5;
    public static void main(String[] args) {
         oFinP1 = new Semaphore(0,true);
         oFinP3 = new Semaphore(0,true);
         oFinP5 = new Semaphore(0,true);
         (new Thread(new p1(oFinP1))).start();
         (new Thread(new p2(oFinP1,oFinP3,oFinP5))).start();
         (new Thread(new p3(oFinP3,oFinP1))).start();
         (new Thread(new p4(oFinP1,oFinP3,oFinP5))).start();
         (new Thread(new p5(oFinP5,oFinP1,oFinP3))).start();
         //(new Thread(new p6(oFinP1,oFinP3))).start();
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usosemaforos;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;

/**
 *
 * @author yeckz
 */
public class p6 extends Thread{
    protected Semaphore oFinP1;
    protected Semaphore oFinP3;
    public p6(Semaphore oFinP1,Semaphore oFinP3) {
        this.oFinP3 = oFinP3;
        this.oFinP1 = oFinP1;
    }
    public void run()  {
        try {
            this.oFinP1.acquire();
            this.oFinP3.acquire();
            } catch(Exception e) {
                e.printStackTrace();
            }
        try {
            sleep((int) Math.round(500 * Math.random() - 0.5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("P6");
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphoreexample;

import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 *
 * @author leledezma
 */
public class PrinterQueue 
{
   private Semaphore semaphore;
 
   public PrinterQueue()
   {
      semaphore = new Semaphore(1);
   }
 
   public void printJob(Object document)
   {
      try
      {
         semaphore.acquire();
          
         Long duration = (long) (Math.random() * 10000);
         System.out.println(Thread.currentThread().getName() + ": PrintQueue: Imprimiendo un trabajo durante " + (duration / 1000) + " seconds :: Time - " + new Date());
         Thread.sleep(duration);
      }
      catch (InterruptedException e)
      {
      }
      finally
      {
         System.out.printf("%s: El documento ha sido impreso\n", Thread.currentThread().getName());
          
         semaphore.release();
      }
   }
}

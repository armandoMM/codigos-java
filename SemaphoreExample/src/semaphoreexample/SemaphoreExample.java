/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphoreexample;

/**
 *
 * @author leledezma
 */
public class SemaphoreExample 
{
   public static void main(String[] args)
   {
      PrinterQueue printerQueue = new PrinterQueue();
      Thread thread[] = new Thread[10];
      for (int i = 0; i < 10; i++)
      {
         thread[i] = new Thread(new PrintingJob(printerQueue), "Thread " + i);
      }
      for (int i = 0; i < 10; i++)
      {
         thread[i].start();
      }
   }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runpingpong;

/**
 *
 * @author luis_
 */
class RunPingPONG implements Runnable {
  private final String word;
  private final int delay;

  RunPingPONG(String whatToSay, int delayTime) {
    word =whatToSay;
    delay=delayTime;
  }

  public void run() {
    try {
      for(int i = 0; i<10; i++) {
        System.out.print(word+" ");
        Thread.sleep(delay);
      }
    }
    catch(InterruptedException e) {
    }
  }

  public static void main(String[] args) {
    Runnable ping = new RunPingPONG("ping", 500);
    Runnable PONG = new RunPingPONG("PONG", 500);
    Thread h1 = new Thread(ping);
    Thread h2 = new Thread(PONG);
    
    h1.setPriority(Thread.MAX_PRIORITY);
    h2.setPriority(Thread.NORM_PRIORITY);
    
    h1.start();
    h2.start();
  }
}

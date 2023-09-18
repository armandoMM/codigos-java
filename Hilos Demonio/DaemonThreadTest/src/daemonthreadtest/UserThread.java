/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daemonthreadtest;

/**
 *
 * @author leledezma
 */
public class UserThread implements Runnable {

	public void run() {

		try {
			for (int i = 0; i < 5; i++) {
				System.out.println("Hilo Usuario en ejecución");
				Thread.sleep(1000);
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();

		} finally {
			System.out.println("Hilo Usuario Terminando");
		}
	}

}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daemonthreadtest;

/**
 *
 * @author leledezma
 */
public class DaemonThread extends Thread {

	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("Hilo Demonio en ejecución");
				Thread.sleep(1000);
			}

		} catch (InterruptedException ie) {
			ie.printStackTrace();

		} finally {
			System.out.println("Hilo Demonio Terminando"); // never called
		}
	}

}


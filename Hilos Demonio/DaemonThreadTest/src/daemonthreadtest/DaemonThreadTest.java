/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daemonthreadtest;

/**
 *
 * @author leledezma
 */
public class DaemonThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Crear hilo Demonio y ejecutarlo
		DaemonThread daemonThread = new DaemonThread();
		//daemonThread.setDaemon(true);
		
                DaemonThread daemonThread2 = new DaemonThread();
		//daemonThread2.setDaemon(true);
		
                DaemonThread daemonThread3 = new DaemonThread();
		//daemonThread3.setDaemon(true);
                
                daemonThread.start();
                daemonThread2.start();
		daemonThread3.start();
		// Crea Hilo Usuario y se ejecuta
		Thread userThread = new Thread(new UserThread());
		userThread.start();
                Thread userThread2 = new Thread(new UserThread());
		userThread2.start();
	}

}


/*
 * Si implementamos hilos haciendo que nuestra clase herede de la clase Thread, entonces ya no podrá nuestra
clase heredar de otra más. Así pues, otra forma de crear hilos es usando la interfaz Runnable, también
del paquete java.lang. Para ello, lo que debemos hacer es implementar la interfaz Runnable en la clase
que define los hilos, y sobreescribir el método run() para definir el comportamiento que queremos que
tengan los hilos. Luego, en el programa, creamos los objetos de la clase anterior. La interfaz
Runnable expresa que los objetos que la implementen puedan ejecutarse concurrentemente. Pero estos
objetos no pueden ejecutarse de forma autónoma, ya que no son hilos. Así que es necesario que estos
objetos sean pasados como parámetros a los constructores de la clase Thread, uno por objeto.

 */
package cuenta50runnable;

/**
 *
 * @author leledezma
 */
/**
* Programa en Java que crea y lanza varios hilos utilizando la clase Cuenta50.
*
* 
*/
public class UsaCuenta50 {
public static void main (String[] args) throws InterruptedException {
Cuenta50 c1 = new Cuenta50(0);
Runnable c2 = new Cuenta50(63);
Runnable c3 = new Cuenta50(102);
//Creamos los hilos
Thread hilo1 = new Thread(c1);
Thread hilo2 = new Thread(c2);
Thread hilo3 = new Thread(c3);
//A continuaci´on lanzamos los hilos
hilo1.setPriority(Thread.MAX_PRIORITY);
hilo2.setPriority(Thread.NORM_PRIORITY);
hilo3.setPriority(Thread.MIN_PRIORITY);
hilo1.start();
hilo2.start();
hilo3.start();
//creamos y lanzamos el hilo en una sola instrucción
//new Thread(c3).start();
//Esperamos a que terminen los hilos
hilo1.join();
hilo2.join();
//hilo3.join();
System.out.println("Hilos terminados.");
}
}

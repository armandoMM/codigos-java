/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cuenta50runnable;

/**
 *
 * @author leledezma
 */

public class Cuenta50 implements Runnable {
int numero;
Cuenta50() {}
Cuenta50(int num) {
numero = num;
}
@Override
public void run() {
for(int i = 0; i < 50; ++i) {
System.out.println(numero + " + " + i + " = " + (numero + i) );
try{
    Thread.sleep(500);
}catch(InterruptedException e){
    System.out.println("ERROR HILO 1:" + e);
}

}
}
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplocontador;

/**
 *
 * @author leledezma
 */
class Usuario extends Thread { // clase hebra usuaria
private Contador cnt;

public Usuario(String nombre, Contador cnt) {
    super(nombre);
    this.cnt = cnt;
 }
public void run() {
 for (int i = 0; i < 5; i++) {
    cnt.dec();
    System.out.println("Hola, soy " + this.getName()
        + ", mi contador vale " + cnt.valor());
    
    try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
            }
    }
}
}

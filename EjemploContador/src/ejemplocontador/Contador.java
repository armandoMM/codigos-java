/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplocontador;

/**
 *
 * @author leledezma
 */
class Contador { // monitor contador
private int actual;
public Contador(int inicial) {
 actual = inicial;
 }
public synchronized void inc() {
 actual++;
 }
public synchronized void dec() {
 actual--;
 }
public synchronized int valor() {
 return actual;
 }
} 

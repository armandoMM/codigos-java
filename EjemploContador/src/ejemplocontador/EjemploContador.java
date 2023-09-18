/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplocontador;

/**
 *
 * @author leledezma
 */
public class EjemploContador {
    final static int nHebras = 5;
        public static void main(String[] args) { // metodo principal
            Contador cont1 = new Contador(10);
            Usuario hebra[] = new Usuario[nHebras];
            for (int i = 0; i < nHebras; i++) {
                hebra[i] = new Usuario("la hebra-" + i, cont1); //crea hebras
                hebra[i].start(); // lanza hebras
            }
        } 
}

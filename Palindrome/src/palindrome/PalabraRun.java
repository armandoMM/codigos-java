/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome;

/**
 *
 * @author leledezma
 */
public class PalabraRun implements Runnable {
String palabra;
PalabraRun() {}
PalabraRun(String pal) {
palabra = pal;
}
@Override
public void run() {
  boolean palindromo = true;
  int i = 0;
  int j = palabra.length() - 1;
  while(palindromo && i < j) {
    if(palabra.charAt(i) == palabra.charAt(j)) {
       ++i;
       --j;
    }
    else
      palindromo = false;
  }
if(palindromo)
      System.out.println("La palabra " + palabra + " es un palíndromo.");
else
     System.out.println("La palabra " + palabra + " no es un palíndromo.");
}
}

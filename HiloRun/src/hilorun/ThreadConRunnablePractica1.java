/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilorun;

/**
 *
 * @author leledezma
 */
class ThreadConRunnablePractica1 implements Runnable{
    String palabra;
    public ThreadConRunnablePractica1 (String _palabra){
        palabra = _palabra;
    }
    @Override
    public void run(){
        for(int i=0;i<10;i++)
            System.out.print(palabra);
    }
    public static void main(String args[]){
        ThreadConRunnablePractica1 a = new ThreadConRunnablePractica1("hiloUno\n");
        ThreadConRunnablePractica1 b = new ThreadConRunnablePractica1("hiloDos\n");
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        t1.start();
        t2.start();
        System.out.print("Fin del programa principal\n");
    }
}

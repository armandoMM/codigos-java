package classes;

public class MainClass {
    public static void main(String[] args) {
        Precess1 thread1 = new Precess1(); //con EXTENDS
        Thread thread2 = new Thread(new Process2()); //con INTERFACES
        
        thread1.start();
        thread2.start();
    }
}

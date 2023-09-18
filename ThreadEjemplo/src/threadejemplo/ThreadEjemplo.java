package threadejemplo;

/**
 *
 * @author yeckz
 */
public class ThreadEjemplo extends Thread{
    public ThreadEjemplo(String str){
        super(str);
    }
    
    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println(i+" "+ getName());
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println("ERROR HILO 1:" + e);
            }
        }
        System.out.println("Termina thread " + getName());
    }
    
    public static void main(String[] args) {
        new ThreadEjemplo("Pepe").start();
        new ThreadEjemplo("Juan").start();
        new ThreadEjemplo("Armando").start();
        new ThreadEjemplo("Angel").start();
        System.out.println("Termina thread main");
    }
    
}

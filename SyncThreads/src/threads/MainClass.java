package threads;

public class MainClass {
    public static void main(String[] args) {
        ThreadOne thrd = new ThreadOne();
        ThreadTwo thrd2 = new ThreadTwo();
        ThreadThree thrd3 = new ThreadThree();
        ThreadFour thrd4 = new ThreadFour();
        
        thrd.start();
        try{
            thrd.sleep(10);
        }catch (InterruptedException e){
            System.out.println("ERROR HILO 1:" + e);
        }
        thrd2.start();
        try{
            thrd2.sleep(10);
        }catch (InterruptedException e){
            System.out.println("ERROR HILO 1:" + e);
        }
        thrd3.start();
        try{
            thrd3.sleep(10);
        }catch (InterruptedException e){
            System.out.println("ERROR HILO 1:" + e);
        }
        thrd4.start();
        try{
            thrd4.sleep(10);
        }catch (InterruptedException e){
            System.out.println("ERROR HILO 1:" + e);
        }
   }
}

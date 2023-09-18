package threads;

public class ThreadOne extends Thread{
    @Override
    public void run(){
        for(int i = 0; i <= 5; i++){
            System.out.print(i + ": G");
            try{
                ThreadOne.sleep(1000);
            }catch (InterruptedException e){
                System.out.println("ERROR HILO 1:" + e);
            }
        }
    }
}

package classes;

public class Precess1 extends Thread{
    //METODO FORZOSO PARA USAR HILOS
    @Override
    public void run(){
        for(int i=0;i<=10;i++){
            System.out.println("Process one");
        }
    }
}

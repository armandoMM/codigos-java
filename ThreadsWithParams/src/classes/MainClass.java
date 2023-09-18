package classes;

public class MainClass {
    public static void main(String[] args) {
        //ESTADO DEL HILO: NEW
        Process thread = new Process(" hilo 1");
        Process thread2 = new Process(" hilo 2");
        
        thread.ValueCondition(5);
        thread2.ValueCondition(10);
        
        //ESTADO DEL HILO: EJECUTABLE O RUNABLE
        thread.start();
        
        //ESTADO DEL HILO: SLEEP O INTERRUMPIDO
        try{ //SIEMPRE DEBE DE IR EN UN TRY / CATCH
            thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println("error thread 1 "+e);
        }
        
        thread2.start();
        //thread2.stop(); --> ultimo estado de un hilo: Muerto o Dead
        try{
            thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println("error thread 2 "+e);
        }
    }
}

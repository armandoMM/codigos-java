package classes;

public class Process extends Thread{
    int num;
    
    public Process(String nameThread){
        super(nameThread);
    }
    
    @Override
    public void run(){
        for(int i=0;i<=num;i++){
            System.out.println(i+ this.getName());
            try{
                Process.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("Error en clase: "+e);
            }
        }
        System.out.println("");
    }
    
    public void ValueCondition(int param){
        this.num=param;
    }
}

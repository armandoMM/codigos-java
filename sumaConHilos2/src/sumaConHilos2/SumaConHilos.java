package sumaConHilos2;
import java.util.Calendar;
/**
 * @author yeckz
 */
public class SumaConHilos{
    static int suma;
    public static void main(String[] args) {       
        int ms,ms2,sec,sec2;
        Calendar calendario = Calendar.getInstance();
        ms = calendario.get(Calendar.MILLISECOND);
        sec = calendario.get(Calendar.SECOND);
        
        Hilo t1 = new Hilo(1,25);
        Hilo t2 = new Hilo(26,50);
        Hilo t3 = new Hilo(51,75);
        Hilo t4 = new Hilo(76,100);
        
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t4.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        ms2 = calendario.get(Calendar.MILLISECOND);
        sec2 = calendario.get(Calendar.SECOND);
        System.out.println("La suma total es: "+ suma +"\nTIEMPO: " + sec + "."+ ms + "   " + sec2 + "." + ms2);
    }
    
    public static class Hilo extends Thread{
        int ini,fin;

        public Hilo(int ini, int fin){
            this.ini = ini;
            this.fin = fin;
        }

        @Override
        public void run(){
            for(int i = ini; i<=fin; i++){
                suma= suma+i;
            }
        }
    }
}


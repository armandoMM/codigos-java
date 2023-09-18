package sumaConHilos;
import java.util.Calendar;
/**
 *
 * @author yeckz
 */

public class SumaConHilos{
    public static void main(String[] args) {
        Calendar calendario = Calendar.getInstance();
        int sumaTotal=0, ms,ms2;
        int sec,sec2;
        ms = calendario.get(Calendar.MILLISECOND);
        sec = calendario.get(Calendar.SECOND);
        for (int i=1;i<=100;i++){
            sumaTotal=sumaTotal+i;
        }
        ms2 = calendario.get(Calendar.MILLISECOND);
        sec2 = calendario.get(Calendar.SECOND);
        System.out.println("La suma total es: "+ sumaTotal+"\nTIEMPO: "+ sec+"."+ms+"--"+sec2+"."+ms2);
    }
}

package multiMatriz;

/**
 *
 * @author yeckz
 */
public class Consum extends Thread{
    private final Matrix m;
    private int a, ix, jx;
    
    public Consum(Matrix _m, int _i, int _j) {
        m=_m;
        ix=_i;
        jx=_j;
    }
    
    @Override 
    public void run() {
        a = m.get(ix,jx);
        //System.out.println(a);
        if(a!=0){
            //System.out.println("Hilo interrumpido");
            Thread.interrupted();
        }
    }
}

package partOne;

import javax.swing.JProgressBar;

/**
 *
 * @author yeckz
 */
public class Caballo extends Thread{
    private int porcentaje;
    private JProgressBar bar;
    private Score score;
    
    public Caballo(JProgressBar _bar, Score scr){
        bar = _bar;
        porcentaje = 0;
        score = scr;
    }
    
    @Override
    public void run(){
        try{
            while(!score.checkScore()){
                int x = (int)(Math.random() * 20);
                int t = bar.getValue();
                
                bar.setValue(t+x);
                sleep(100);
            }
        }catch(InterruptedException e){}
        
    }
    
    public JProgressBar getBar(){
        return bar;
    }   
}

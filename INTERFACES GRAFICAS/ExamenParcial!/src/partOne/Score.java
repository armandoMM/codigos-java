package partOne;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author yeckz
 */
public class Score {
    JProgressBar bar1;
    JProgressBar bar2;
    JProgressBar bar3;
    JProgressBar bar4;
    JLabel win;
    private boolean stop;
    
    public Score(JProgressBar bar1,JProgressBar bar2,JProgressBar bar3,JProgressBar bar4,JLabel label){
        this.bar1=bar1;
        this.bar2=bar2;
        this.bar3=bar3;
        this.bar4=bar4;
        win = label;
        stop=false;
    }
    public boolean checkScore(){
        if(bar1.getValue()==100){
            win.setText("Caballo 1");
            stop=true;
            return stop;
        }else if(bar2.getValue()==100){
            win.setText("Caballo 2");
            stop=true;
            return stop;
        }else if(bar3.getValue()==100){
            win.setText("Caballo 3");
            stop=true;
            return stop;
        }else if(bar4.getValue()==100){
            win.setText("Caballo 4");
            stop=true;
            return stop;
        }
        return stop;
    }
}

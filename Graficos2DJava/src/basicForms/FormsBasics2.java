package basicForms;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author yeckz
 */
public class FormsBasics2 extends JPanel{
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawArc(100, 100, 100, 100, 0, 180);
        g.fillArc(400, 100, 100, 100, 0, 180);
        
        g.drawRoundRect(100, 200, 100, 100, 40, 40);
        g.fillRoundRect(400, 200, 100, 100, 40, 40);
        
        g.setColor(Color.red);
        g.draw3DRect(100, 400, 100, 100, true);
        g.fill3DRect(400, 400, 100, 100, true);
    }
    
    public static void main(String[] args){
        JFrame ventana = new JFrame();
        FormsBasics2 obj = new FormsBasics2();
        ventana.add(obj);
        ventana.setSize(700, 700);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

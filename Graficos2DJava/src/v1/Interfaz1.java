package v1;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author yeckz
 */
public class Interfaz1 extends JPanel{
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        g.setColor(Color.red);
        g.drawLine(400, 100, 400, 600);
        g.setColor(Color.BLUE);
        g.drawLine(200, 100, 600, 500);
        g.setColor(new Color( 51, 255, 229));
        g.drawLine(100, 300, 700, 300);
        g.setColor(new Color( 246, 51, 255));
        g.drawLine(200, 500, 600, 100);
    }
    
    public static void main(String[] args){
        JFrame ventana = new JFrame();
        Interfaz1 obj = new Interfaz1();
        ventana.add(obj);
        ventana.setSize(700, 700);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

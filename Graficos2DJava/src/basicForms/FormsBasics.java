package basicForms;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author yeckz
 */
public class FormsBasics extends JPanel{
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.red);
        g.drawLine(100,100,200,200);
        g.setColor(Color.blue);
        g.drawRect(300,100,100,200);
        g.setColor(Color.green);
        g.drawOval(500,100,100,100);
        g.setColor(Color.blue);
        g.fillRect(300, 400, 100, 100);
        g.setColor(Color.green);
        g.fillOval(500, 400, 100, 150);
        int[] xPoints = {45, 15, 75};
        int[] yPoints = {410, 550, 600};
        g.drawPolygon(xPoints, yPoints, 3);
        g.fillPolygon(xPoints, yPoints, 3);
    }
    
    public static void main(String[] args){
        JFrame ventana = new JFrame();
        FormsBasics obj = new FormsBasics();
        ventana.add(obj);
        ventana.setSize(700, 700);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

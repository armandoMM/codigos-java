package polilineas;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author yeckz
 */
public class Polilinea extends JPanel{
    @Override
    public void paint(Graphics g){
        super.paint(g);
        int[] xPoitns={100,200,300,400,500,600};
        int[] yPoitns={600,100,600,100,600,100};
        
        g.drawPolyline(xPoitns, yPoitns, 6);
    }
    
    public static void main(String[] args){
        JFrame ventana = new JFrame("Polilineas");
        Polilinea objeto = new Polilinea();
        ventana.add(objeto);
        ventana.setSize(700, 700);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

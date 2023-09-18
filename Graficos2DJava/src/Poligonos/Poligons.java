package Poligonos;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author yeckz
 */
public class Poligons extends JPanel{
    @Override
    public void paint(Graphics g){
        super.paint(g);
        //ESTRELLA
        int[] xPoints = {300,250,150,230,200,300,400,370,450,350};
        int[] yPoints = {100,200,200,280,400,340,400,280,200,200};
        g.setColor(Color.cyan);
        g.fillPolygon(xPoints, yPoints, 10);
        g.setColor(Color.BLACK);
        g.drawPolygon(xPoints, yPoints, 10);
        //PENTAGONO
        int[] x2Points = {600,500,550,650,700};
        int[] y2Points = {200,300,400,400,300};
        g.setColor(Color.YELLOW);
        g.fillPolygon(x2Points, y2Points, 5);
        g.setColor(Color.BLACK);
        g.drawPolygon(x2Points,y2Points,5);
        //HEXAGONO
        int[] x3Points = {400,350,400,500,550,500};
        int[] y3Points = {500,550,600,600,550,500};
        g.setColor(Color.RED);
        g.fillPolygon(x3Points, y3Points, 6);
        g.setColor(Color.BLACK);
        g.drawPolygon(x3Points,y3Points,6);
    }
    public static void main(String[] args){
        JFrame ventana = new JFrame();
        Poligons objeto = new Poligons();
        ventana.add(objeto);
        ventana.setSize(800, 700);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

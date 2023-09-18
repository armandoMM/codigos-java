package Textos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fuentes extends JPanel{
    public void paint(Graphics g){
        super.paint(g);
        Font oldFont = getFont();
        System.out.println(oldFont.toString());
        g.setColor(Color.BLUE);
        Font fuente = new Font("Arial",Font.PLAIN,40);
        g.setFont(fuente);
        g.drawString("Cree en ti y todo será posible", 50, 50);
        oldFont = getFont();
        System.out.println(oldFont.toString());
        g.setColor(Color.black);
        Font fuente2 = new Font("Tahoma",Font.BOLD,40);
        g.setFont(fuente2);
        g.drawString("Disfruta de las pequeñas cosas", 50, 200);
        oldFont = getFont();
        System.out.println(oldFont.toString());
        g.setColor(Color.green);
        Font fuente3 = new Font("Times New Roman",Font.ITALIC,40);
        g.setFont(fuente3);
        g.drawString("hola mundo", 50, 300);
        oldFont = getFont();
        System.out.println(oldFont.toString());
    }
    public static void main(String[] args){
        JFrame ventana = new JFrame();
        Fuentes objeto = new Fuentes();
        ventana.add(objeto);
        ventana.setSize(800, 700);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

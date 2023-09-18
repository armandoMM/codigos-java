

package proyecto_2d;

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class DrawShapes2D extends JApplet implements ActionListener {
    public static void main(String s[]) {
        JFrame frame = new JFrame();
        frame.setTitle("Dibujar Objetos Geometricos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JApplet applet = new DrawShapes2D();
        applet.init();
        frame.getContentPane().add(applet);
        frame.pack();
        frame.setVisible(true);
    }

  PaintPanel panel = null;

  public void init() {
    JMenuBar mb = new JMenuBar();
    setJMenuBar(mb);
    JMenu menu = new JMenu("Objetos");
    mb.add(menu);
    JMenuItem mi = new JMenuItem("Rectangle");
    mi.addActionListener(this);
    menu.add(mi);
    mi = new JMenuItem("RoundRectangle");
    mi.addActionListener(this);
    menu.add(mi);
    mi = new JMenuItem("Ellipse");
    mi.addActionListener(this);
    menu.add(mi);
    mi = new JMenuItem("Arc");
    mi.addActionListener(this);
    menu.add(mi);
    mi = new JMenuItem("Line");
    mi.addActionListener(this);
    menu.add(mi);
    mi = new JMenuItem("QuadCurve");
    mi.addActionListener(this);
    menu.add(mi);
    mi = new JMenuItem("CubicCurve");
    mi.addActionListener(this);
    menu.add(mi);
    mi = new JMenuItem("Polygon");
    mi.addActionListener(this);
    menu.add(mi);
    panel = new PaintPanel();
    getContentPane().add(panel);
  }

  public void actionPerformed(ActionEvent ev) {
    String command = ev.getActionCommand();
    if ("Rectangle".equals(command)) {
      panel.shapeType = panel.RECTANGLE;
    } else if ("RoundRectangle".equals(command)) {
      panel.shapeType = panel.ROUNDRECTANGLE2D;
    } else if ("Ellipse".equals(command)) {
      panel.shapeType = panel.ELLIPSE2D;
    } else if ("Arc".equals(command)) {
      panel.shapeType = panel.ARC2D;
    } else if ("Line".equals(command)) {
      panel.shapeType = panel.LINE2D;
    } else if ("QuadCurve".equals(command)) {
      panel.shapeType = panel.QUADCURVE2D;
    } else if ("CubicCurve".equals(command)) {
      panel.shapeType = panel.CUBICCURVE2D;
    } else if ("Polygon".equals(command)) {
      panel.shapeType = panel.POLYGON;
    }
  }
}
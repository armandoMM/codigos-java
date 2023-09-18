package proyecto2D;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.io.IOException;
import java.io.Serializable;

public class FiguraSave implements Serializable{
        
        //private BasicStroke stroke;
        public float grosor;
        public int cap;
        public int join;
        public float qtr;
        public float[] fl;
        public float last;
        private GeneralPath path;
        private Color Contorno;
        private Color Relleno;
        private double alpha;

    public FiguraSave() {
    }

    public FiguraSave(float grosor, int cap, int join, float qtr, float[] fl, float last, GeneralPath path, Color Contorno, Color Relleno, double alpha) {
        this.grosor = grosor;
        this.cap = cap;
        this.join = join;
        this.qtr = qtr;
        this.fl = fl;
        this.last = last;
        this.path = path;
        this.Contorno = Contorno;
        this.Relleno = Relleno;
        this.alpha = alpha;
    }

    public GeneralPath getPath() {
        return path;
    }
    public Color getContorno() {
        return Contorno;
    }
    public Color getRelleno() {
        return Relleno;
    }
    public double getAlpha() {
        return alpha;
    }
    public void setPath(GeneralPath path) {
        this.path = path;
    }
    public void setContorno(Color Contorno) {
        this.Contorno = Contorno;
    }
    public void setRelleno(Color Relleno) {
        this.Relleno = Relleno;
    }
    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }
}

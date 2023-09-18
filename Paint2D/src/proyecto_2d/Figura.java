
package proyecto_2d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.io.IOException;
import java.io.Serializable;

public class Figura implements Serializable{
        
        
        private Shape shape;
        private BasicStroke stroke;
        private GeneralPath path;
        private Color Contorno;
        private Color Relleno;
        private double alpha;
        

        public Figura() {
        }

        public Figura(Shape shape, BasicStroke stroke, GeneralPath path, Color Contorno, Color Relleno, double alpha) {
            this.shape = shape;
            this.stroke = stroke;
            this.path = path;
            this.Contorno = Contorno;
            this.Relleno = Relleno;
            this.alpha = alpha;
        }

        
        public Shape getShape() {
            return shape;
        }
        public BasicStroke getStroke() {
            return stroke;
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
        
        public void setShape(Shape shape) {
            this.shape = shape;
        }
        public void setStroke(BasicStroke stroke) {
            this.stroke = stroke;
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

        @Override
        public String toString() {
            return "Figura [" + "shape =" + shape + ", stroke =" + stroke + ", path =" + path + ", Contorno =" + Contorno + ", Relleno =" + Relleno + ", alpha = " + alpha + " ]\n";
        }

        
    }

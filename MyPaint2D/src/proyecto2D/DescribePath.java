package proyecto2D;
import java.awt.*;
import java.awt.geom.*;

public class DescribePath {
    GeneralPath path;
    public  GeneralPath obtenerPath (Shape s) {
    path = new GeneralPath();
      PathIterator pi = s.getPathIterator(null);

      while (pi.isDone() == false) {
        obtieneCurrentSegment(pi);
        pi.next();
      }
    return path;
    }
    
    
    public void obtieneCurrentSegment(PathIterator pi) {
      double[] coordinates = new double[6];
      int type = pi.currentSegment(coordinates);
      switch(type) {
        case PathIterator.SEG_MOVETO:
          path.moveTo(coordinates[0], coordinates[1]);
          break;
        case PathIterator.SEG_LINETO:
          path.lineTo(coordinates[0], coordinates[1]);
          break;
        case PathIterator.SEG_QUADTO:
          path.quadTo(coordinates[0], coordinates[1], coordinates[2], coordinates[3]);
          break;
        case PathIterator.SEG_CUBICTO:
          path.curveTo(coordinates[0], coordinates[1], coordinates[2], coordinates[3], coordinates[4], coordinates[5]);
          break;
        case PathIterator.SEG_CLOSE:
          path.closePath();
          break;
        default:
          break;
      }
    }
    public void describePath(Shape s) {
    PathIterator pi = s.getPathIterator(null);

    while (pi.isDone() == false) {
      describeCurrentSegment(pi);
      pi.next();
    }
  }
  public void describeCurrentSegment(PathIterator pi) {
    double[] coordinates = new double[6];
    int type = pi.currentSegment(coordinates);
    switch(type) {
      case PathIterator.SEG_MOVETO:
        System.out.println("move to " +
            coordinates[0] + ", " + coordinates[1]);
        break;
      case PathIterator.SEG_LINETO:
        System.out.println("line to " +
            coordinates[0] + ", " + coordinates[1]);
        break;
      case PathIterator.SEG_QUADTO:
        System.out.println("quadratic to " +
            coordinates[0] + ", " + coordinates[1] + ", " +
            coordinates[2] + ", " + coordinates[3]);
        break;
      case PathIterator.SEG_CUBICTO:
        System.out.println("cubic to " +
            coordinates[0] + ", " + coordinates[1] + ", " +
            coordinates[2] + ", " + coordinates[3] + ", " +
            coordinates[4] + ", " + coordinates[5]);
        break;
      case PathIterator.SEG_CLOSE:
        System.out.println("close");
        break;
      default:
        break;
    }
  }

}
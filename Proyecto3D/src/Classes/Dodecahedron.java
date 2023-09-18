package Classes;
import javax.vecmath.*;
import java.awt.*;
import java.awt.event.*;
import javax.media.j3d.*;
import com.sun.j3d.utils.geometry.*;

public class Dodecahedron extends Shape3D{
    public Dodecahedron() {
    GeometryInfo gi = new GeometryInfo(GeometryInfo.POLYGON_ARRAY);
    double phi = 0.5*(Math.sqrt(5)+1);
    int w;
    w=1;
    Point3d[] vertices = {new Point3d(w,w,w),
    new Point3d(0,w/phi,phi),new Point3d(phi,0,w/phi),new Point3d(w/phi,phi,0),
    new Point3d(-w,w,w),new Point3d(0,-w/phi,phi),new Point3d(w,-w,w),
    new Point3d(phi,0,-w/phi),new Point3d(w,w,-w),new Point3d(-w/phi,phi,0),
    new Point3d(-phi,0,w/phi),new Point3d(-w,-w,w),new Point3d(w/phi,-phi,0),
    new Point3d(w,-w,-w),new Point3d(0,w/phi,-phi),new Point3d(-w,w,-w),
    new Point3d(-w/phi,-phi,0),new Point3d(-phi,0,-w/phi),new Point3d(0,-w/phi,-phi),
    new Point3d(-w,-w,-w)};
    
    
    int[] indices = {0,1,5,6,2, 0,2,7,8,3, 0,3,9,4,1,
    1,4,10,11,5, 2,6,12,13,7, 3,8,14,15,9,
    5,11,16,12,6, 7,13,18,14,8, 9,15,17,10,4,
    19,16,11,10,17, 19,17,15,14,18, 19,18,13,12,16};
    gi.setCoordinates(vertices);
    gi.setCoordinateIndices(indices);
    int[] stripCounts = {5,5,5,5,5,5,5,5,5,5,5,5};
    gi.setStripCounts(stripCounts);
    NormalGenerator ng = new NormalGenerator();
    ng.generateNormals(gi);
    this.setGeometry(gi.getGeometryArray());
  }
}

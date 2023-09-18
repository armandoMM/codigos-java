package Classes;

import javax.vecmath.*;
import javax.media.j3d.*;

class ColorOctahedron extends IndexedTriangleArray {
  public ColorOctahedron() {
    super(8, GeometryArray.COORDINATES | GeometryArray.NORMALS | GeometryArray.COLOR_3, 24);
    setCoordinate(0, new Point3f(0,0,1));
    setCoordinate(1, new Point3f(-0.5f,0,0));
    setCoordinate(2, new Point3f(0,-2,0));
    setCoordinate(3, new Point3f(0.5f,0,0));
    setCoordinate(4, new Point3f(0,2,0));
    setCoordinate(5, new Point3f(0,0,-1));
    int[] vertInd = {0,1,2,0,2,3,0,3,4,0,4,1,
    5,1,4,5,4,3,5,3,2,5,2,1};
    setCoordinateIndices(0, vertInd);
    float d = 1f/(float)Math.sqrt(3);
    setNormal(0, new Vector3f(-d,-d,d));
    setNormal(1, new Vector3f(d,-d,d));
    setNormal(2, new Vector3f(d,d,d));
    setNormal(3, new Vector3f(-d,d,d));
    setNormal(4, new Vector3f(-d,d,-d));
    setNormal(5, new Vector3f(d,d,-d));
    setNormal(6, new Vector3f(d,-d,-d));
    setNormal(7, new Vector3f(-d,-d,-d));
    int[] normInd = {0,0,0,1,1,1,2,2,2,3,3,3,
    4,4,4,5,5,5,6,6,6,7,7,7};
    float n = (float)(1.0/Math.sqrt(3));
    setNormalIndices(0,normInd);
    setColor(0, new Color3f(n,n,-n));
    setColor(1, new Color3f(n,-n,n));
    setColor(2, new Color3f(-n,n,n));
    setColor(3, new Color3f(n,n,-n));
    setColor(4, new Color3f(n,-n,n));
    setColor(5, new Color3f(-n,n,n));
    this.setColorIndices(0, vertInd);
  }
}
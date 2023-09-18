package graficos3d;

import javax.media.j3d.Geometry;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Appearance;

/**
 *
 * @author yeckz
 */
public class VisualObject extends Shape3D{
    private Geometry voGeometry;
    private Appearance voAppearance;
    
    public VisualObject(){
        voGeometry = createGeometry();
        voAppearance = createAppearance();
        this.setGeometry(voGeometry);
        this.setAppearance(voAppearance);
    }
    
    private Geometry createGeometry(){
        return null;
    }
    
    private Appearance createAppearance(){
        return null;
    }
}

package graphics3d;

import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.vecmath.Vector3f;
import javax.vecmath.Point3d;

/**
 *
 * @author yeckz
 */
public class Graphics3D extends JPanel{
    
    public Graphics3D(){
        GraphicsConfiguration conf = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D = new Canvas3D(conf);
        setLayout(new BorderLayout());
        add(canvas3D);
        SimpleUniverse universo = new SimpleUniverse(canvas3D);
        universo.getViewingPlatform().setNominalViewingTransform();
        
        BranchGroup escena = createSceneGrahp();
        escena.compile();
        
        universo.addBranchGraph(escena);
    }

    public BranchGroup createSceneGrahp(){
        BranchGroup root  = new BranchGroup();
        
        TransformGroup mouseGroup = new TransformGroup();
        mouseGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        mouseGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        root.addChild(mouseGroup);
        
        Transform3D translate1 = new Transform3D();
        Transform3D translate2 = new Transform3D();
        //translate1.set(new Vector3f(-0.6f,0,0));
        translate1.setTranslation(new Vector3f(-0.6f,0,0));
        translate2.set(new Vector3f(0.6f,0,0));
                
        TransformGroup tg1 = new TransformGroup(translate1);
        TransformGroup tg2 = new TransformGroup(translate2);
        
        ColorCube cube1 = new ColorCube(0.2f);
        ColorCube cube2 = new ColorCube(0.2f);
        
        tg1.addChild(cube1);
        tg2.addChild(cube2);
        
        mouseGroup.addChild(tg1);
        mouseGroup.addChild(tg2);
        
        MouseRotate mouseRot = new MouseRotate();
        mouseRot.setTransformGroup(mouseGroup);
        mouseRot.setSchedulingBounds(new BoundingSphere(new Point3d(),1000f));
        root.addChild(mouseRot);
        return root;
    }
    
    public static void main(String[] args) {
        System.setProperty("sun.awt.noerasebackground","true");
        JFrame ventana = new JFrame("Java 3D - Trasnlacion");
        Graphics3D panel = new Graphics3D();
        ventana.add(panel);
        ventana.setSize(700, 700);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

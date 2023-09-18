package graficos3d;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Frame;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.ColorCube;
import javax.media.j3d.Alpha;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3f;

/**
 *
 * @author yeckz
 */
public class Graficos3D extends Applet{
    public Graficos3D(){
        setLayout(new BorderLayout());
        Canvas3D canvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
        add("Center",canvas3D);
        
        BranchGroup scene = createSceneGraph();
        BranchGroup scene2 = createRotateGraph();
        BranchGroup scene3 = createRotateXYGraph();
        BranchGroup scene4 = createAnimateGraph();
        BranchGroup scene5 = createAnimate2Graph();
        scene.compile();
        scene2.compile();
        scene3.compile();
        scene4.compile();
        scene5.compile();
        
        SimpleUniverse universo = new SimpleUniverse(canvas3D);
        
        universo.getViewingPlatform().setNominalViewingTransform();
        universo.addBranchGraph(scene);
        universo.addBranchGraph(scene2);
        universo.addBranchGraph(scene3);
        universo.addBranchGraph(scene4);
        universo.addBranchGraph(scene5);
    }
    
    public BranchGroup createSceneGraph(){
        BranchGroup grupo = new BranchGroup();
        //grupo.addChild(new ColorCube(0.4));
        
        Transform3D translate = new Transform3D();
        translate.set(new Vector3f(0,0,0));
        
        TransformGroup objTranslate = new TransformGroup(translate);
        objTranslate.addChild(new ColorCube(0.2f));
        
        grupo.addChild(objTranslate);
               
        return grupo;
    }
    
    public BranchGroup createRotateGraph(){
        BranchGroup grupo = new BranchGroup();
        Transform3D rotate = new Transform3D();
        Transform3D translate = new Transform3D();
        translate.set(new Vector3f(0.4f,0.6f,0));
        rotate.rotX(Math.PI/4.0d);
        TransformGroup objRotate = new TransformGroup(rotate);
        objRotate.addChild(new ColorCube(0.2f));
        
        TransformGroup objTranslate = new TransformGroup(translate);
        objTranslate.addChild(objRotate);
        
        grupo.addChild(objTranslate);
        return grupo;
    }
    
    public BranchGroup createRotateXYGraph(){
        BranchGroup grupo = new BranchGroup();
        Transform3D rotate = new Transform3D();
        Transform3D rotate2 = new Transform3D();
        Transform3D translate = new Transform3D();
        translate.set(new Vector3f(-0.5f,0.6f,0));
        
        rotate.rotX(Math.PI/4.0d);
        rotate2.rotY(Math.PI/5.0d);
        rotate.mul(rotate2);
        TransformGroup objRotate = new TransformGroup(rotate);
        objRotate.addChild(new ColorCube(0.2f));
        
        TransformGroup objTranslate = new TransformGroup(translate);
        objTranslate.addChild(objRotate);
        grupo.addChild(objTranslate);
        return grupo;
    }
    
    public BranchGroup createAnimateGraph(){
        BranchGroup grupo = new BranchGroup();
        TransformGroup objSpin = new TransformGroup();
        objSpin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
       
        Transform3D translate = new Transform3D();
        translate.set(new Vector3f(-0.5f,-0.5f,0));
        
        objSpin.addChild(new ColorCube(0.2f));
        
        Alpha rotationAlpha = new Alpha(-1,4000);
        RotationInterpolator rotator = new RotationInterpolator(rotationAlpha, objSpin);
        
        BoundingSphere bounds = new BoundingSphere();
        rotator.setSchedulingBounds(bounds);
        objSpin.addChild(rotator);
        
        TransformGroup objTranslate = new TransformGroup(translate);
        objTranslate.addChild(objSpin);
        
        grupo.addChild(objTranslate);
        return grupo;
    }
    
    public BranchGroup createAnimate2Graph(){
        BranchGroup grupo = new BranchGroup();
        Transform3D rotate = new Transform3D();
        Transform3D tempRotate = new Transform3D();
        
        Transform3D translate = new Transform3D();
        translate.set(new Vector3f(0.5f,-0.5f,0));
        
        rotate.rotX(Math.PI/4.0d);
        tempRotate.rotY(Math.PI/5.0d);
        rotate.mul(tempRotate);
        TransformGroup objRotate = new TransformGroup(rotate);
        TransformGroup objSpin = new TransformGroup();
        objSpin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objRotate.addChild(objSpin);
        
        objSpin.addChild(new ColorCube(0.2f));
        
        Transform3D yAxis = new Transform3D();
        Alpha rotationAlpha = new Alpha(-1, 3000);
        
        RotationInterpolator rotator = new RotationInterpolator(rotationAlpha, objSpin, yAxis,0.0f,(float)
                Math.PI*2.0f);
        
        BoundingSphere bounds = new BoundingSphere();
        rotator.setSchedulingBounds(bounds);
        objSpin.addChild(rotator);
        
        TransformGroup objTranslate = new TransformGroup(translate);
        objTranslate.addChild(objRotate);
        
        grupo.addChild(objTranslate);
        return grupo;
    }
    
    public static void main(String[] args) {
        Frame frame = new MainFrame(new Graficos3D(),256,256);
    }
}

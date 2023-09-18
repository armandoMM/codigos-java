package arrays;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.awt.Frame;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import javax.media.j3d.Alpha;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3f;
import triangles.MyArrayForms;

/**
 *
 * @author yeckz
 */
public class Arrays extends Applet{
    private static Frame frame;
    
    public Arrays(){
        GraphicsConfiguration config =SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D = new Canvas3D(config);
        add("Center", canvas3D);
        SimpleUniverse simpleUniverse=new SimpleUniverse(canvas3D);
	BranchGroup scene=createSceneGraph();
	     
	simpleUniverse.getViewingPlatform().setNominalViewingTransform();
	simpleUniverse.addBranchGraph(scene);
	setLayout(new BorderLayout());
	add(canvas3D,BorderLayout.CENTER);
    }
    
    private BranchGroup createSceneGraph() {
	BranchGroup objRoot = new BranchGroup();
	BranchGroup objBranchGroup= createObjectBranchGroup();
	TransformGroup scaleTransformGroup = createScaleTransforGroup();
	TransformGroup spinTransformGroup = createInterpolatorSpin();
		
	objRoot.addChild(scaleTransformGroup);
	scaleTransformGroup.addChild(spinTransformGroup);
	spinTransformGroup.addChild(objBranchGroup);
	objRoot.compile();
	return objRoot;
    }
    
    private TransformGroup createScaleTransforGroup() {
	Transform3D scale = new Transform3D();
	TransformGroup scaleTG;
	scale.setScale(0.15);
	scaleTG= new TransformGroup(scale);
	return scaleTG;
    }
    
    private TransformGroup createInterpolatorSpin() {
	TransformGroup objectSpin = new TransformGroup();
	Alpha rotationAlpha = new Alpha (-1,5200);
	RotationInterpolator interpolator = new RotationInterpolator
	(rotationAlpha,objectSpin);
	BoundingSphere bounds = new BoundingSphere();
		
	objectSpin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        interpolator.setSchedulingBounds(bounds);
        objectSpin.addChild(interpolator);
        
        return objectSpin;
    }
    
    private BranchGroup createObjectBranchGroup() {
	BranchGroup objectBG = new BranchGroup();
	Transform3D rotate = null,translate=null,translate2=null;
	TransformGroup transformGroup=null,transformGroup2=null;
        
        MyArrayForms arr = new MyArrayForms(objectBG,rotate,translate,translate2,transformGroup,transformGroup2);
	
	return objectBG;
    }
    
    public static void main(String[] args) {
        frame = new MainFrame(new Arrays(),800,800);
    }
    
}

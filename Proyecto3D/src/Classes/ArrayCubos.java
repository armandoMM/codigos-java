package Classes;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import com.sun.j3d.utils.applet.MainFrame; 
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.swing.JApplet;
import javax.vecmath.*;

public class ArrayCubos extends JApplet {
    private static Frame frame;
    public ArrayCubos() {
        GraphicsConfiguration config =SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D = new Canvas3D(config);
        add("Center", canvas3D);
        SimpleUniverse simpleUniverse=new SimpleUniverse(canvas3D);
	BranchGroup branchGroup=createSceneGraph();
	     
	simpleUniverse.getViewingPlatform().setNominalViewingTransform();
	simpleUniverse.addBranchGraph(branchGroup);
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
	Alpha rotationAlpha = new Alpha (-1,4200);
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
	Transform3D rotate,translate,translate2;
	TransformGroup transformGroup,transformGroup2;
	int n=100;
	double theta;
	for( int i=0;i<=n;i++) {
            translate = new Transform3D();
            translate2 = new Transform3D();
            rotate = new Transform3D();
            transformGroup = new TransformGroup();
            transformGroup2 = new TransformGroup();
            theta = i*2*Math.PI/n;
            translate.setTranslation(new Vector3f(-(2f*(float)(Math.cos(theta))/0.3f),2f*(float)Math.sin(theta),0.0f));
            //translate2.setTranslation(new Vector3f(5f*(float)(Math.cos(theta)),5f*(float)Math.cos(theta),0.5f));
            rotate.rotX(theta);
            translate.mul(rotate);
            translate2.mul(rotate);
            transformGroup.setTransform(translate);
            transformGroup2.setTransform(translate2);
            transformGroup.addChild(new ColorCube(0.25));
            transformGroup2.addChild(new ColorCube(0.25f));
			
            objectBG.addChild(transformGroup);
            objectBG.addChild(transformGroup2);
        }
		
	return objectBG;
    }

    public static void main(String[] args) {
        frame = new MainFrame(new ArrayCubos(), 800, 600);
    }
}

package triangles;

import com.sun.j3d.utils.geometry.*;
import java.awt.Color;
import javax.media.j3d.Appearance;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3f;

/**
 *
 * @author yeckz
 */
public class MyArrayForms {
    public MyArrayForms(BranchGroup objectBG,Transform3D rotate,Transform3D translate,Transform3D translate2, TransformGroup transformGroup,TransformGroup transformGroup2){
        int n=120;
	double theta;
	for( int i=0;i<=n;i++) {
            translate = new Transform3D();
            translate2 = new Transform3D();
            rotate = new Transform3D();
            transformGroup = new TransformGroup();
            transformGroup2 = new TransformGroup();
            theta = i*2*Math.PI/25;
            translate.setTranslation(new Vector3f((2f*(float)(Math.cos(theta))/2),2f*(float)Math.sin(theta),0.5f));
            translate2.setTranslation(new Vector3f(3f*(float)(Math.cos(theta)),3f*(float)Math.cos(theta),0.5f));
            rotate.rotX(theta);
            translate.mul(rotate);
            translate2.mul(rotate);
            transformGroup.setTransform(translate);
            transformGroup2.setTransform(translate2);
            Appearance ap = new Appearance();
            ColoringAttributes ca = new ColoringAttributes();
            ca.setColor(new Color3f(Color.GREEN));
            ap.setColoringAttributes(ca);
            Appearance ap2 = new Appearance();
            ColoringAttributes ca2 = new ColoringAttributes();
            ca2.setColor(new Color3f(Color.RED));
            ap2.setColoringAttributes(ca2);
            transformGroup.addChild(new Cone(0.25f,0.7f,ap));
            transformGroup2.addChild(new Box(0.25f, 0.25f, 0.25f, ap2));

            objectBG.addChild(transformGroup);
            objectBG.addChild(transformGroup2);
        }
    }
}

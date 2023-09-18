package Classes;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import javax.media.j3d.Alpha;
import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Material;
import javax.media.j3d.PointLight;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.geometry.Cone;

public class TestPrimitivas extends Applet{
    private static Frame frame;

    public TestPrimitivas() {
	GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
	Canvas3D canvas3D = new Canvas3D(config);
	add("Center", canvas3D);
	SimpleUniverse simpleUniverse = new SimpleUniverse(canvas3D);
	BranchGroup branchGroup = createSceneGraph();

	simpleUniverse.getViewingPlatform().setNominalViewingTransform();
	simpleUniverse.addBranchGraph(branchGroup);
	setLayout(new BorderLayout());
        add(canvas3D, BorderLayout.CENTER);
    }

    private BranchGroup createSceneGraph() {
	BranchGroup objRoot = new BranchGroup();
	TransformGroup spin = new TransformGroup();
	spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objRoot.addChild(spin);
	BranchGroup objBranchGroup = createObjectBranchGroup();
	/* Primitivas */
	Appearance ap = new Appearance();
	ap.setMaterial(new Material());
	Box box = new Box (1.2f,0.3f,0.8f,ap);
	Sphere esfera = new Sphere();
	Cone cono = new Cone();

	Transform3D tr = new Transform3D();
	tr.setScale(0.09);
	TransformGroup tg = new TransformGroup(tr);
	spin.addChild(tg);

	tr.setIdentity();
	tr.setTranslation(new Vector3f(0f, 1.5f, 0f));
	TransformGroup tgEsfera = new TransformGroup(tr);
	tg.addChild(tgEsfera);
	tgEsfera.addChild(esfera);

	tr.setTranslation(new Vector3f(0f, -1.5f, 0f));
	TransformGroup tgCono = new TransformGroup(tr);
	tg.addChild(tgCono);
	cono.setAppearance(ap);
	tgCono.addChild(cono);

	tg.addChild(box);
	tg.addChild(objBranchGroup);
	Alpha alpha = new Alpha(-1, 8000);
	RotationInterpolator rotator = new RotationInterpolator(alpha, spin);
	BoundingSphere bounds = new BoundingSphere();
	rotator.setSchedulingBounds(bounds);
	spin.addChild(rotator);

	// Backgtound and light
	Background fondo = new Background(0f, 0f, 0f);
	fondo.setApplicationBounds(bounds);
	objRoot.addChild(fondo);
	AmbientLight light = new AmbientLight(true, new Color3f(2f, 1.5f, 2.6f));
	light.setInfluencingBounds(bounds);
	objRoot.addChild(light);

	PointLight ptlight = new PointLight(new Color3f(1.98f, 3.9f, 1.3f), new Point3f(3f, 3f, 3f),
			new Point3f(1f, 0f, 0f));
	ptlight.setInfluencingBounds(bounds);
	objRoot.addChild(ptlight);

	PointLight ptlight2 = new PointLight(new Color3f(1.2f, 1.9f, 1.3f), new Point3f(-3f, -3f, -2f),
			new Point3f(1f, 0f, 0f));
	ptlight2.setInfluencingBounds(bounds);
	objRoot.addChild(ptlight2);

	return objRoot;
    }

    private BranchGroup createObjectBranchGroup() {
	BranchGroup objectBG = new BranchGroup();
	Transform3D rotate, translate, translate2, translate3, rotate2;
	TransformGroup transformGroup, transformGroup2, transformGroup3;
	Sphere esfera = new Sphere();
	Cylinder cilindro = new Cylinder();
	Cone cono = new Cone();
	int n = 100;
	double theta;
	for (int i = 0; i <= n; i++) {
            translate = new Transform3D();
            translate2 = new Transform3D();
            rotate = new Transform3D();
            rotate2 = new Transform3D();
            esfera = new Sphere(0.5f);
            cilindro = new Cylinder(0.3f,2f);
            cono = new Cone();
            transformGroup = new TransformGroup();
            transformGroup2 = new TransformGroup();
            transformGroup3 = new TransformGroup();
            theta = i * 2 * Math.PI / 12;
            translate.setTranslation(new Vector3f(4f*(float)(Math.sin(theta)), 4f*(float)(Math.cos(theta)), -0.6f));
            translate2.setTranslation(new Vector3f(7f*(float)(Math.cos(theta)), 7f*(float) Math.sin(theta), 0.4f));
            rotate.rotX(theta);
            rotate2.rotZ(theta);
            translate.mul(rotate);
            translate2.mul(rotate2);
            transformGroup.setTransform(translate);
            transformGroup2.setTransform(translate2);
            transformGroup.addChild(cilindro);
            transformGroup2.addChild(new ColorCube(0.55f));
            transformGroup.addChild(esfera);
            transformGroup2.addChild(cono);
            objectBG.addChild(transformGroup);
            objectBG.addChild(transformGroup2);
	}
	return objectBG;
    }

    public static void main(String[] args) {
	frame = new MainFrame(new TestPrimitivas(), 800, 600);
    }

}

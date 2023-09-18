package Classes;

import javax.vecmath.*;
import java.awt.*;
import java.awt.event.*;
import javax.media.j3d.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.geometry.*;
import java.applet.*;
import com.sun.j3d.utils.applet.MainFrame;

public class TestDodecahedron extends Applet{
    public static void main(String[] args) {
    new MainFrame(new TestDodecahedron(), 800, 600);
  }

    public void init() {
        GraphicsConfiguration gc = SimpleUniverse.getPreferredConfiguration();
        Canvas3D cv = new Canvas3D(gc);
        setLayout(new BorderLayout());
        add(cv, BorderLayout.CENTER);
        BranchGroup bg = createSceneGraph();
        bg.compile();
        SimpleUniverse su = new SimpleUniverse(cv);
        su.getViewingPlatform().setNominalViewingTransform();
        su.addBranchGraph(bg);
    }

    private BranchGroup createSceneGraph() {
        BranchGroup root = new BranchGroup();
        TransformGroup spin = new TransformGroup();
        spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        root.addChild(spin);

        //object
        Appearance ap = new Appearance();
        ap.setMaterial(new Material());
        Transform3D tr = new Transform3D();
        tr.setTranslation(new Vector3f(0f, 0f, 0f));
        tr.setScale(0.05);
        TransformGroup tg = new TransformGroup(tr);
        spin.addChild(tg);

        //DODECAEDRO
        Appearance ap1 = new Appearance();
        ap1.setMaterial(new Material());
        Shape3D shape1 = new Dodecahedron();
        shape1.setAppearance(ap1);
        Transform3D tr1 = new Transform3D();
        tr1.setTranslation(new Vector3f(-.2f, -.2f, 0f));
        tr1.setScale(0.07);
        TransformGroup tg1 = new TransformGroup(tr1);
        spin.addChild(tg1);
        tg1.addChild(shape1);

        Appearance ap3 = new Appearance();
        ap3.setMaterial(new Material());
        Shape3D shape3 = new Dodecahedron();
        shape3.setAppearance(ap3);
        Transform3D tr3 = new Transform3D();
        tr3.setTranslation(new Vector3f(-.4f, -.4f, 0f));
        tr3.setScale(0.07);
        TransformGroup tg3 = new TransformGroup(tr3);
        spin.addChild(tg3);
        tg3.addChild(shape3);

        Appearance ap6 = new Appearance();
        ap6.setMaterial(new Material());
        Shape3D shape6 = new Dodecahedron();
        shape6.setAppearance(ap6);
        Transform3D tr6 = new Transform3D();
        tr6.setTranslation(new Vector3f(.2f, .2f, 0f));
        tr6.setScale(0.07);
        TransformGroup tg6 = new TransformGroup(tr6);
        spin.addChild(tg6);
        tg6.addChild(shape6);

        Appearance ap8 = new Appearance();
        ap8.setMaterial(new Material());
        Shape3D shape8 = new Dodecahedron();
        shape8.setAppearance(ap8);
        Transform3D tr8 = new Transform3D();
        tr8.setTranslation(new Vector3f(.4f, .4f, 0f));
        tr8.setScale(0.07);
        TransformGroup tg8 = new TransformGroup(tr8);
        spin.addChild(tg8);
        tg8.addChild(shape8);

        //TETREDROS   
        Appearance tetra = new Appearance();
        tetra.setMaterial(new Material());
        Shape3D tetrashape = new Shape3D(new Tetrahedron(), ap);
        tetrashape.setAppearance(tetra);
        //rotating object
        Transform3D tetra_tr = new Transform3D();
        tetra_tr.setTranslation(new Vector3f(.6f, .6f, 0f));
        tetra_tr.setScale(0.10);
        TransformGroup tetra_tg = new TransformGroup(tetra_tr);
        spin.addChild(tetra_tg);
        tetra_tg.addChild(tetrashape);

        Appearance tetra2 = new Appearance();
        tetra2.setMaterial(new Material());
        Shape3D tetrashape2 = new Shape3D(new Tetrahedron(), ap);
        tetrashape2.setAppearance(tetra2);
        //rotating object
        Transform3D tetra_tr2 = new Transform3D();
        tetra_tr2.setTranslation(new Vector3f(-.6f, -.6f, 0f));
        tetra_tr2.setScale(0.10);
        TransformGroup tetra_tg2 = new TransformGroup(tetra_tr2);
        spin.addChild(tetra_tg2);
        tetra_tg2.addChild(tetrashape2);

        //TOROIDE
        Appearance at = new Appearance();
        ColoringAttributes ca = new ColoringAttributes();
        ca.setColor(new Color3f(Color.CYAN));
        at.setColoringAttributes(ca);
        at.setMaterial(new Material());
        Shape3D toro = new Torus(0.5f, 0.8f);
        toro.setAppearance(at);
        tr.setTranslation(new Vector3f(0f, 0f, 0f));
        tr.setScale(2);
        TransformGroup tgToro = new TransformGroup(tr);
        tg.addChild(tgToro);
        tgToro.addChild(toro);

        // FIGURAS
        Alpha alpha = new Alpha(-1, 4000);
        RotationInterpolator rotator = new RotationInterpolator(alpha, spin);
        BoundingSphere bounds = new BoundingSphere();
        rotator.setSchedulingBounds(bounds);
        spin.addChild(rotator);

        //background and light
        Background background = new Background(1.0f, 1.0f, 1.0f);
        background.setApplicationBounds(bounds);
        root.addChild(background);
        AmbientLight light = new AmbientLight(true, new Color3f(Color.BLUE));
        light.setInfluencingBounds(bounds);
        root.addChild(light);
        PointLight ptlight = new PointLight(new Color3f(Color.CYAN),
                new Point3f(3f, 3f, 3f), new Point3f(1f, 0f, 0f));
        ptlight.setInfluencingBounds(bounds);
        root.addChild(ptlight);
        PointLight ptlight2 = new PointLight(new Color3f(Color.BLUE),
                new Point3f(-2f, 2f, 2f), new Point3f(1f, 0f, 0f));
        ptlight2.setInfluencingBounds(bounds);
        root.addChild(ptlight2);
        
        return root;
    }
}

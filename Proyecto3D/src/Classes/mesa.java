package Classes;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.picking.PickTool;
import com.sun.j3d.utils.picking.behaviors.PickRotateBehavior;
import com.sun.j3d.utils.picking.behaviors.PickTranslateBehavior;
import com.sun.j3d.utils.picking.behaviors.PickZoomBehavior;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import javax.media.j3d.Alpha;
import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.Material;
import javax.media.j3d.Node;
import javax.media.j3d.PointLight;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.TransparencyAttributes;
import javax.vecmath.AxisAngle4d;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

public class mesa extends Applet {

    public void init() {
        GraphicsConfiguration gc = SimpleUniverse.getPreferredConfiguration();
        Canvas3D cv = new Canvas3D(gc);
        setLayout(new BorderLayout());
        add(cv, BorderLayout.CENTER);
        BranchGroup bg = createSceneGraph(cv);
        bg.compile();
        SimpleUniverse su = new SimpleUniverse(cv);
        su.getViewingPlatform().setNominalViewingTransform();
        su.addBranchGraph(bg);
    }

    private BranchGroup createSceneGraph(Canvas3D cv) {
        BranchGroup root = new BranchGroup();
        TransformGroup spin = new TransformGroup();

        spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        spin.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        spin.setCapability(TransformGroup.ENABLE_PICK_REPORTING);
        root.addChild(spin);
        //primitivas
        Appearance ap = new Appearance();
        ap.setMaterial(new Material());
        ColoringAttributes ca = new ColoringAttributes();
        ap.setColoringAttributes(ca);
        //Alpha alpha = new Alpha(-1, 4000);
        BoundingSphere bounds = new BoundingSphere();
        Box rectangulo = new Box(2f, 0.5f, 3f, ap);

        Transform3D tr = new Transform3D();
        tr.setScale(0.20);
        tr.setTranslation(new Vector3f(0f, 0f, 0f));

        TransformGroup tgRectangulo = new TransformGroup(tr);
        ca.setColor(new Color3f(new Color(120,74,31)));
        ap.setColoringAttributes(ca);
        spin.addChild(tgRectangulo);
        tgRectangulo.addChild(rectangulo);

        Box soporte1 = new Box(1f, 6f, 1f, ap);
        Box soporte2 = new Box(1f, 6f, 1f, ap);
        Box soporte3 = new Box(1f, 6f, 1f, ap);
        Box soporte4 = new Box(1f, 6f, 1f, ap);

        tr.setTranslation(new Vector3f(-1.8f, -0.8f, -2.8f));
        TransformGroup tgSoporte1 = new TransformGroup(tr);
        tgRectangulo.addChild(tgSoporte1);
        tgSoporte1.addChild(soporte1);

        tr.setTranslation(new Vector3f(-1.8f, -0.8f, 2.8f));
        TransformGroup tgSoporte2 = new TransformGroup(tr);
        tgRectangulo.addChild(tgSoporte2);
        tgSoporte2.addChild(soporte2);

        tr.setTranslation(new Vector3f(1.8f, -0.8f, 2.8f));
        TransformGroup tgSoporte3 = new TransformGroup(tr);
        tgRectangulo.addChild(tgSoporte3);
        tgSoporte3.addChild(soporte3);

        tr.setTranslation(new Vector3f(1.8f, -0.8f, -2.8f));
        TransformGroup tgSoporte4 = new TransformGroup(tr);
        tgRectangulo.addChild(tgSoporte4);
        tgSoporte4.addChild(soporte4);

        root.addChild(creaEsfera());
        root.addChild(creaCono());
        root.addChild(Cubo());
        root.addChild(Cubo());
        root.addChild(Cilindro());
        root.addChild(creaDodecaedro());
        //root.addChild(creaTorus());

        // rotation
        PickRotateBehavior rotator = new PickRotateBehavior(root, cv, bounds,
                PickTool.GEOMETRY);
        root.addChild(rotator);
        // translation
        PickTranslateBehavior translator = new PickTranslateBehavior(root, cv,
                bounds, PickTool.GEOMETRY);
        root.addChild(translator);
        // zoom
        PickZoomBehavior zoom = new PickZoomBehavior(root, cv, bounds,
                PickTool.GEOMETRY);
        root.addChild(zoom);
        //background and light
        Background background = new Background(0f, 0f, 0f);
        background.setApplicationBounds(bounds);
        root.addChild(background);
        AmbientLight light = new AmbientLight(true, new Color3f(Color.GRAY));
        light.setInfluencingBounds(bounds);
        root.addChild(light);
        PointLight ptlight2 = new PointLight(new Color3f(Color.LIGHT_GRAY),
                new Point3f(-2f, 2f, 2f), new Point3f(1f, 0f, 0f));
        ptlight2.setInfluencingBounds(bounds);
        root.addChild(ptlight2);

        return root;
    }

    private Node creaEsfera() {
        // transform
        Transform3D trans = new Transform3D();
        trans.setTranslation(new Vector3f(-0.4f, 0.14f, 0f));
        trans.setScale(0.1);

        TransformGroup spin = new TransformGroup(trans);
        spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        spin.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        spin.setCapability(TransformGroup.ENABLE_PICK_REPORTING);
        // visual objects
        Appearance ap = new Appearance();
        ap.setColoringAttributes(new ColoringAttributes(new Color3f(Color.GRAY), ColoringAttributes.FASTEST));
        ap.setMaterial(new Material());
        Sphere esfera = new Sphere();
        esfera.setAppearance(ap);

        PickTool.setCapabilities(esfera.getShape(), PickTool.INTERSECT_FULL);
        spin.addChild(esfera);
        return spin;
    }

    private Node creaDodecaedro() {
        // transform
        Transform3D trans = new Transform3D();
        trans.setTranslation(new Vector3f(0.05f, 0.20f, 0f));
        trans.setScale(0.1);

        TransformGroup spin = new TransformGroup(trans);
        spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        spin.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        spin.setCapability(TransformGroup.ENABLE_PICK_REPORTING);
        // visual objects

        Appearance ap = new Appearance();
        ap.setColoringAttributes(new ColoringAttributes(new Color3f(0.4f, 0.4f, 0.4f), ColoringAttributes.FASTEST));
        ap.setMaterial(new Material());
        Shape3D shape = new Dodecahedron();
        shape.setAppearance(ap);
        Sphere esfera = new Sphere();
        esfera.setAppearance(ap);
        PickTool.setCapabilities(shape, PickTool.INTERSECT_FULL);
        spin.addChild(shape);
        return spin;
    }

    private Node creaCono() {
        // transform
        Transform3D trans = new Transform3D();
        trans.setTranslation(new Vector3f(-0.2f, 0.14f, 0f));
        trans.setScale(0.1);

        TransformGroup spin = new TransformGroup(trans);
        spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        spin.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        spin.setCapability(TransformGroup.ENABLE_PICK_REPORTING);
        // visual objects
        Appearance ap = new Appearance();
        ap.setColoringAttributes(new ColoringAttributes(new Color3f(0.2f, 0.8f, 0.2f), ColoringAttributes.FASTEST));
        ap.setMaterial(new Material());
        Cone cono = new Cone();
        cono.setAppearance(ap);

        PickTool.setCapabilities(cono.getShape(1), PickTool.INTERSECT_FULL);
        spin.addChild(cono);
        return spin;

    }

    private Node Cubo() {
        // transform
        Transform3D trans = new Transform3D();
        trans.setTranslation(new Vector3f(-0.01f, 0.50f, 0.1f));
        trans.setScale(0.1);

        TransformGroup spin = new TransformGroup(trans);
        spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        spin.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        spin.setCapability(TransformGroup.ENABLE_PICK_REPORTING);
        // visual objects
        Appearance ap = new Appearance();
        ap.setColoringAttributes(new ColoringAttributes(new Color3f(0.8f, 0.8f, 0.2f), ColoringAttributes.FASTEST));
        ap.setMaterial(new Material());
        Box box = new Box();
        box.setAppearance(ap);

        PickTool.setCapabilities(box.getShape(1), PickTool.INTERSECT_FULL);
        spin.addChild(box);
        return spin;
    }

    private Node Cilindro() {
        // transform
        Transform3D trans = new Transform3D();
        trans.setTranslation(new Vector3f(-0.7f, -0.50f, 0f));
        trans.setScale(0.1);

        TransformGroup spin = new TransformGroup(trans);
        spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        spin.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        spin.setCapability(TransformGroup.ENABLE_PICK_REPORTING);
        // visual objects
        Appearance ap = new Appearance();

        ap.setMaterial(new Material());
        Cylinder cilind = new Cylinder();
        cilind.setAppearance(ap);

        PickTool.setCapabilities(cilind.getShape(1), PickTool.INTERSECT_FULL);
        spin.addChild(cilind);
        return spin;

    }

    public static void main(String[] args) {
        MainFrame a = new MainFrame(new mesa(), 800, 800);
    }
}

package Classes;

import com.sun.j3d.utils.applet.MainFrame;
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
import javax.media.j3d.PointLight;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;

public class Star extends Applet {
  public static void main(String[] args) {
    new MainFrame(new Star(), 640, 480);
  }

  public void init() {
    // create canvas
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
    ColoringAttributes ca = new ColoringAttributes();
    ca.setShadeModel(ColoringAttributes.SHADE_GOURAUD);
    ap.setColoringAttributes(ca);
    Shape3D shape = new Shape3D(new ColorOctahedron(), ap);
    Shape3D shape2 = new Shape3D(new ColorOctahedron2(), ap);
    //rotating object
    Transform3D tr = new Transform3D();
    tr.setScale(0.25);
    TransformGroup tg = new TransformGroup(tr);
    spin.addChild(tg);
    tg.addChild(shape);
    tg.addChild(shape2);
    Alpha alpha = new Alpha(-1, 8000);
    RotationInterpolator rotator = new RotationInterpolator(alpha, spin);
    BoundingSphere bounds = new BoundingSphere();
    rotator.setSchedulingBounds(bounds);
    spin.addChild(rotator);
    
    //light and background
    Background background = new Background(1.0f, 1.0f, 1.0f);
    background.setApplicationBounds(bounds);
    root.addChild(background);
    AmbientLight light = new AmbientLight(true, new Color3f(Color.BLUE));
    light.setInfluencingBounds(bounds);
    root.addChild(light);
    PointLight ptlight = new PointLight(new Color3f(Color.CYAN),
        new Point3f(3f,3f,3f), new Point3f(1f,0f,0f));
    ptlight.setInfluencingBounds(bounds);
    root.addChild(ptlight);
    PointLight ptlight2 = new PointLight(new Color3f(Color.BLUE),
        new Point3f(-2f,2f,2f), new Point3f(1f,0f,0f));
    ptlight2.setInfluencingBounds(bounds);
    root.addChild(ptlight2);
    return root;
  }
}

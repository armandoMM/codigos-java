package Classes;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.media.j3d.Alpha;
import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.LineAttributes;
import javax.media.j3d.Material;
import javax.media.j3d.PointAttributes;
import javax.media.j3d.PointLight;
import javax.media.j3d.PolygonAttributes;
import javax.media.j3d.RenderingAttributes;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JColorChooser;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;

public class Atributos extends Applet implements ActionListener {

    public static void main(String[] args) {
        new MainFrame(new Atributos(), 640, 480);
    }

    public void init() {
        setLayout(new BorderLayout());
        Panel p = new Panel();
        p.setLayout(new GridLayout(12, 1, 10, 5));
        add(p, BorderLayout.EAST);
        p.add(new Panel());
        p.add(new Label("Modo de poligono"));
        Button button = new Button("Point");
        p.add(button);
        button.addActionListener(this);
        button = new Button("Line");
        p.add(button);
        button.addActionListener(this);
        button = new Button("Polygon");
        p.add(button);
        button.addActionListener(this);

        p.add(new Panel());
        p.add(new Label("Atributos de color"));
        button = new Button("Single");
        p.add(button);
        button.addActionListener(this);
        button = new Button("Flat");
        p.add(button);
        button.addActionListener(this);
        button = new Button("Gouraud");
        p.add(button);
        button.addActionListener(this);
        button = new Button("Lighting");
        p.add(button);
        button.addActionListener(this);

        GraphicsConfiguration gc = SimpleUniverse.getPreferredConfiguration();
        Canvas3D cv = new Canvas3D(gc);
        add(cv, BorderLayout.CENTER);
        BranchGroup bg = createSceneGraph();
        bg.compile();
        SimpleUniverse su = new SimpleUniverse(cv);
        su.getViewingPlatform().setNominalViewingTransform();
        su.addBranchGraph(bg);
    }

    Appearance ap;

    private BranchGroup createSceneGraph() {
        BranchGroup root = new BranchGroup();
        TransformGroup spin = new TransformGroup();
        spin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        root.addChild(spin);

        //allow appearance chage
        ap = new Appearance();
        ap.setCapability(Appearance.ALLOW_COLORING_ATTRIBUTES_WRITE);
        ap.setCapability(Appearance.ALLOW_POINT_ATTRIBUTES_WRITE);
        ap.setCapability(Appearance.ALLOW_LINE_ATTRIBUTES_WRITE);
        ap.setCapability(Appearance.ALLOW_POLYGON_ATTRIBUTES_WRITE);
        ap.setCapability(Appearance.ALLOW_RENDERING_ATTRIBUTES_WRITE);
        ap.setCapability(Appearance.ALLOW_MATERIAL_WRITE);

        Shape3D shape = new Shape3D(new ColorOctahedron(), ap);

        Transform3D tr = new Transform3D();
        tr.setScale(0.25);
        TransformGroup tg = new TransformGroup(tr);
        spin.addChild(tg);
        tg.addChild(shape);

        Alpha alpha = new Alpha(-1, 4000);
        RotationInterpolator rotator = new RotationInterpolator(alpha, spin);
        BoundingSphere bounds = new BoundingSphere();
        rotator.setSchedulingBounds(bounds);
        spin.addChild(rotator);

        //background and light
        Background background = new Background(1f, 1f, 1f);
        background.setApplicationBounds(bounds);
        root.addChild(background);
        AmbientLight light = new AmbientLight(true, new Color3f(Color.red));
        light.setInfluencingBounds(bounds);
        root.addChild(light);
        PointLight ptlight = new PointLight(new Color3f(Color.cyan),
                new Point3f(3f, 3f, 3f), new Point3f(1f, 0f, 0f));
        ptlight.setInfluencingBounds(bounds);
        root.addChild(ptlight);
        return root;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String cmd = actionEvent.getActionCommand();
        if ("Point".equals(cmd)) {
            ap.setPolygonAttributes(new PolygonAttributes(
                    PolygonAttributes.POLYGON_POINT, PolygonAttributes.CULL_BACK, 0));
            ap.setPointAttributes(new PointAttributes(10, false));
        } else if ("Line".equals(cmd)) {
            ap.setPolygonAttributes(new PolygonAttributes(
                    PolygonAttributes.POLYGON_LINE, PolygonAttributes.CULL_BACK, 0));
            ap.setLineAttributes(new LineAttributes(3,
                    LineAttributes.PATTERN_DASH, false));
        } else if ("Polygon".equals(cmd)) {
            ap.setPolygonAttributes(new PolygonAttributes(
                    PolygonAttributes.POLYGON_FILL, PolygonAttributes.CULL_BACK, 0));
        } else if ("Single".equals(cmd)) {
            ColoringAttributes ca = new ColoringAttributes();
            Color color = JColorChooser.showDialog(null, "Seleccione un color", Color.gray);
            ca.setColor(new Color3f(color));
            ap.setColoringAttributes(ca);
            ap.setMaterial(null);
            RenderingAttributes ra = new RenderingAttributes();
            ra.setIgnoreVertexColors(true);
            ap.setRenderingAttributes(ra);
        } else if ("Flat".equals(cmd)) {
            ColoringAttributes ca = new ColoringAttributes();
            ca.setShadeModel(ColoringAttributes.SHADE_FLAT);
            ap.setColoringAttributes(ca);
            ap.setMaterial(null);
            RenderingAttributes ra = new RenderingAttributes();
            ra.setIgnoreVertexColors(false);
            ap.setRenderingAttributes(ra);
        } else if ("Gouraud".equals(cmd)) {
            ColoringAttributes ca = new ColoringAttributes();
            ca.setShadeModel(ColoringAttributes.SHADE_GOURAUD);
            ap.setColoringAttributes(ca);
            ap.setMaterial(null);
            RenderingAttributes ra = new RenderingAttributes();
            ra.setIgnoreVertexColors(false);
            ap.setRenderingAttributes(ra);
        } else if ("Lighting".equals(cmd)) {
            ap.setMaterial(new Material());
            RenderingAttributes ra = new RenderingAttributes();
            ra.setIgnoreVertexColors(true);
            ap.setRenderingAttributes(ra);
        }
    }
}


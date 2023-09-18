package Classes;

import javax.vecmath.*;
import java.awt.*;
import java.awt.event.*;
import javax.media.j3d.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.geometry.*;
import java.applet.*;
import com.sun.j3d.utils.applet.MainFrame;

public class superficie3D extends Applet {

    public static void main(String[] args) {
        new MainFrame(new superficie3D(), 640, 480);
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
        ap.setMaterial(new Material());
        Shape3D shape = new Shape3D(createGeometry(), ap);

        Transform3D tr = new Transform3D();
        tr.setScale(0.09);
        TransformGroup tg = new TransformGroup(tr);
        spin.addChild(tg);
        tg.addChild(shape);

        Alpha alpha = new Alpha(-1, 22000);
        RotationInterpolator rotator = new RotationInterpolator(alpha, spin);
        BoundingSphere bounds = new BoundingSphere();
        rotator.setSchedulingBounds(bounds);
        spin.addChild(rotator);

        //background and light
        Background background = new Background(4.0f, 4.0f, 4.0f);
        background.setApplicationBounds(bounds);
        root.addChild(background);
        AmbientLight light = new AmbientLight(true, new Color3f(Color.GREEN));
        light.setInfluencingBounds(bounds);
        root.addChild(light);
        PointLight ptlight = new PointLight(new Color3f(Color.MAGENTA),
                new Point3f(2f, 2f, 2f), new Point3f(1f, 0f, 0f));
        ptlight.setInfluencingBounds(bounds);
        root.addChild(ptlight);
        return root;
    }

    private Geometry createGeometry() {
        int m = 75;
        int n = 90;
        Point3f[] pts = new Point3f[m * n];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                float x = (i - m / 2) * 0.2f;
                float z = (j - n / 2) * ((float) Math.exp(0.2));
                float y = 2f * (float) (Math.cos(x) * Math.sin(z)) / ((float) Math.exp(0.4));;

                pts[idx++] = new Point3f(x, y, z);
            }
        }

        int[] coords = new int[2 * n * (m - 1)];
        System.out.println(coords);
        idx = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                coords[idx++] = i * n + j;
                coords[idx++] = (i - 1) * n + j;
            }
        }

        int[] stripCounts = new int[m - 1];
        for (int i = 0; i < m - 1; i++) {
            stripCounts[i] = 2 * n;
        }

        GeometryInfo gi = new GeometryInfo(GeometryInfo.POLYGON_ARRAY);
        gi.setCoordinates(pts);
        gi.setCoordinateIndices(coords);
        gi.setStripCounts(stripCounts);

        NormalGenerator ng = new NormalGenerator();
        ng.generateNormals(gi);

        return gi.getGeometryArray();
    }

}

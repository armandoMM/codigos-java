package MisObjetos;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;


public class Fantasma{
	private GeneralPath path;
	
	public Fantasma(){
		int[] xFantasma = {31, 41, 51, 61, 71, 71, 43, 50, 57, 64};
		int[] yFantasma = {72, 60, 72, 60, 72, 29, 45, 51, 45, 51};

		path = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
				xFantasma.length);
		
		path.moveTo((31), (29));

		for (int i = 0; i < 6; i++) {
			path.lineTo(xFantasma[i], yFantasma[i]);
		}

		path.curveTo(71, 5, 31, 5, 31, 29);


		for (int i = 6; i < 10; i++) {
			path.lineTo(xFantasma[i], yFantasma[i]);
		}

		Ellipse2D elipse = new Ellipse2D.Double(39, 28, 8, 11);
		path.append(elipse, false);

		elipse = new Ellipse2D.Double(54, 28, 8, 11);
		path.append(elipse, false);
                path.closePath();
	}

	public GeneralPath getPath() {
		return path;
	}	
}

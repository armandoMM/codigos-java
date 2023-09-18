package MisObjetos;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;


public class Estrella {

	private GeneralPath path;

	public Estrella(){
		int[] xEstrella = {0, 75, 100, 125, 200, 150, 160, 100, 40, 50, 0 };
		int[] yEstrella = {85, 75, 10, 75, 85, 125, 190, 150, 190, 125, 85};


		path = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xEstrella.length);

		path.moveTo(0, 85);
		for (int k = 1; k < xEstrella.length; k++){
			path.lineTo(xEstrella[k], yEstrella[k]);
		}

		/*
		path.moveTo(76, 69);
	    path.curveTo(50, 0, 107, 0, 110, 54);
		path.moveTo(110, 54);
	    path.curveTo(110, 78, 137, 79, 136, 46);
		 */

		path.closePath();

	}

	public GeneralPath getPath() {
		return path;
	}	


}

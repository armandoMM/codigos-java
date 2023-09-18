package MisObjetos;

import java.awt.geom.GeneralPath;

public class Flecha {

	private GeneralPath path;

	public Flecha(){
		int[] xVentana = {64, 87, 74, 74, 53, 53, 42};
		int[] yVentana = {90, 137, 137, 184,  184, 137, 137};
	    path = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
	    		xVentana.length);

		path.moveTo(xVentana[0], yVentana[0]);	    
	    path.lineTo(xVentana[1], yVentana[1]);
	    path.lineTo(xVentana[2], yVentana[2]);
	    path.lineTo(xVentana[3], yVentana[3]);
	    path.lineTo(xVentana[4], yVentana[4]);
	    path.lineTo(xVentana[5], yVentana[5]);
	    path.lineTo(xVentana[6], yVentana[6]);
	    path.lineTo(xVentana[0], yVentana[0]);
	    path.closePath();
	}
	
	public GeneralPath getPath() {
		return path;
	}

}

package MisObjetos;
import java.awt.geom.GeneralPath;


public class Globo {
	private GeneralPath path;

	public Globo(){
            path = new GeneralPath();
	    path.moveTo(181,98);	    
	    path.lineTo(285,98);
	    path.curveTo(285,98,298,102,305,115);
	    path.lineTo(305,169);
	    path.curveTo(305,169,298,179,285,184);
	    path.lineTo(220,184);
	    path.lineTo(202,195);
		path.lineTo(186,184);
	    path.curveTo(186,184,166,179,162,169);
	    path.lineTo(162,115);
	    path.curveTo(162,115,166,102,181,98);
            path.closePath();
	
	}
	
	public GeneralPath getPath() {
            return path;
	}

}

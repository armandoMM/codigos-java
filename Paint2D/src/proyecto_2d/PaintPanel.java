package proyecto_2d;


import MisObjetos.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.*;


class PaintPanel extends JPanel implements MouseListener, MouseMotionListener {
    
    static final int NONE = 8000;
    static final int RECTANGLE = 0;
    static final int ROUNDRECTANGLE2D = 1;
    static final int ELLIPSE2D = 2;
    static final int ARC2D = 3;
    static final int LINE2D = 4;
    static final int QUADCURVE2D = 5;
    static final int CUBICCURVE2D = 6;
    static final int POLYGON = 7;
    static final int GENERAL = 8;
    static final int HEART = 9;
    static final int PETALOS = 10;
    public final int FANTASMA = 11;
    public final int ESTRELLA = 12;
    public final int FLECHA = 13;
    public final int GLOBO = 14;
    public final int GUARDADA = 15;
    public final int PACKMAN = 16;
    public final int REBANADA = 17;
    public final int ARCO_VERTICAL = 18;
    public Archivo a = new Archivo();
    String nomFigura;
    
        private double anchoOriginal;
        private double anchoActual;
        private double altoActual;
        private double incrementoAncho;
        private double altoOriginal;
        private double incrementoAlto;

        private int indexModificado;
        
        public Color colorContornoGlob = Color.black;
        public Color colorFillGlob = null;
    int estado = NONE;

    static final int DIBUJO = 0;
        int shapeType = NONE;
    static final int CREACION = 4;
        int modoCreacion = NONE;
            static final int MOVE_TO = 88;
            static final int LINE_TO = 89;
            static final int QUAD_TO = 90;
            static final int CUBIC_TO = 91;
            static final int CLOSE_PATH = 92;
        static int comienza;
    static final int SELECCIONANDO = 1;
        int modoSeleccion = NONE;
            static final int SIMPLE = 4;
            static final int MULTIPLE = 5;
            static final int DOBLE = 22;
    static final int CONFIRMADO = 2;

    static final int MODIFICANDO = 3;

    int modo = NONE;
    static final int STROKE = 1;
    static final int TRANSFORM = 2;
        static final int TRANSLATION = 1;
        static final int ROTATION = 2;
        static final int SCALING = 3;
        static final int SHEARING = 4;
        static final int REFLECTION = 5;
    static final int AREA = 3;
    

    int contDoble;
    
    static Point panterior = null,qu,rr,ss;
    static GeneralPath pathNew = new GeneralPath();
    int transformType = NONE;

    private AffineTransform transformacion;
    
    Vector<Figura> forms = new Vector<Figura>();
    Vector points = new Vector();
    Vector<Figura> selectedforms = new Vector<Figura>();
    Point puntoInicial = new Point();
    int pointIndex = 0;
    Shape partialShape = null;
    DescribePath desPath = new DescribePath();
    Point p = null;
    private GeneralPath pathTemporal = null;
    static int grosorGlobal = 1;
    static final BasicStroke BS  =  new BasicStroke(1,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
    static final BasicStroke BSS = new BasicStroke(1,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_MITER,10.0f,new float[] {16.0f,20.0f},0.0f);
    BasicStroke StrokeGlobal = BS;
    int x0 = 444;
    int y0 = 252;
  //PANEL DE DIBUJO
    public PaintPanel() {
        super();
        setBackground(Color.white);
        setPreferredSize(new Dimension(890, 520));
        addMouseListener(this);
        addMouseMotionListener(this);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Shape s;
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(BS);
        g2.translate(x0, y0);
        g2.setColor(Color.RED);
        g2.drawLine(-1000,0,1000,0);
        g2.drawLine(0,-600,0,600);
        g2.setColor(Color.BLACK);
        Figura f;
        for (int i = 0; i < forms.size(); i++) {
            f = forms.get(i);
            g2.setStroke(BS);
            g2.setColor(Color.BLACK);
            s = f.getShape();
            if(f.getRelleno()!=null){
                g2.setColor(f.getRelleno());
                g2.fill(s);
                g2.setColor(Color.BLACK);
            }
            if(f.getContorno()!= null)
                g2.setColor(f.getContorno());
            if(f.getStroke()!=null)
                g2.setStroke(f.getStroke());
            g2.draw(s); 
        }
        if(estado == CONFIRMADO){
            if(modoSeleccion == SIMPLE){
                Shape modificada;
                for (int i=0; i < selectedforms.size(); i++){
                    g2.setStroke(BSS);
                    g2.setColor(Color.BLACK);
                    f = selectedforms.get(i);
                    modificada = f.getShape();
                    Shape s1 = new Rectangle((int) modificada.getBounds().getMinX(), 
                                             (int) modificada.getBounds().getMinY(), 
                                             (int) modificada.getBounds().width, 
                                             (int) modificada.getBounds().height);
                    g2.draw(s1);
                    g2.setStroke(BS);
                    g2.setColor(Color.BLUE);
                    if(f.getRelleno()!=null){
                        g2.setColor(f.getRelleno());
                        g2.fill(modificada);
                        g2.setColor(Color.BLUE);
                    }
                    if(f.getStroke()!=null)
                        g2.setStroke(f.getStroke());
                    g2.draw(modificada);
                }
                PanelObjetos.sSimple.setSelected(false);
                PanelObjetos.sSimple.setEnabled(false);
                PanelObjetos.sDoble.setEnabled(false);
                PanelObjetos.sMultiple.setEnabled(false);
                PanelObjetos.StrokeToggleB.setEnabled(true);
                PanelObjetos.TransformToggleB.setEnabled(true);
                estado = MODIFICANDO;
                PanelObjetos.BotonBorrar.setEnabled(true);
            }
            else if(modoSeleccion == DOBLE){
                Shape modificada;
                for (int i=0; i < selectedforms.size(); i++){
                    g2.setStroke(BSS);
                    g2.setColor(Color.BLACK);
                    f = selectedforms.get(i);
                    modificada = f.getShape();
                    Shape s1 = new Rectangle((int) modificada.getBounds().getMinX(), 
                                             (int) modificada.getBounds().getMinY(), 
                                             (int) modificada.getBounds().width, 
                                             (int) modificada.getBounds().height);
                    g2.draw(s1);
                    g2.setStroke(BS);
                    g2.setColor(Color.BLUE);
                    if(f.getRelleno()!=null){
                        g2.setColor(f.getRelleno());
                        g2.fill(modificada);
                        g2.setColor(Color.BLUE);
                    }
                    if(f.getStroke()!=null)
                        g2.setStroke(f.getStroke());
                    g2.draw(modificada);
                }
                
                if (contDoble == 2){
                    estado = MODIFICANDO;
//                    PanelObjetos.AreaToggleB.setEnabled(true);
                    PanelObjetos.StrokeToggleB.setEnabled(true);
                    PanelObjetos.TransformToggleB.setEnabled(true);
                    PanelObjetos.BotonBorrar.setEnabled(true);
                    PanelObjetos.sSimple.setEnabled(false);
                    PanelObjetos.sDoble.setEnabled(false);
                    PanelObjetos.sDoble.setEnabled(false);
                    PanelObjetos.sMultiple.setEnabled(false);
                }
                else{
                    estado = SELECCIONANDO;
                }
            }
            else if(modoSeleccion == MULTIPLE){
                Shape modificada;
                for (int i=0; i < selectedforms.size(); i++){
                    g2.setStroke(BSS);
                    g2.setColor(Color.BLACK);
                    f = selectedforms.get(i);
                    modificada = f.getShape();
                    Shape s1 = new Rectangle((int) modificada.getBounds().getMinX(), 
                                             (int) modificada.getBounds().getMinY(), 
                                             (int) modificada.getBounds().width, 
                                             (int) modificada.getBounds().height);
                    g2.draw(s1);
                    g2.setStroke(BS);
                    g2.setColor(Color.BLUE);
                    if(f.getRelleno()!=null){
                        g2.setColor(f.getRelleno());
                        g2.fill(modificada);
                        g2.setColor(Color.BLUE);
                    }
                    if(f.getStroke()!=null)
                        g2.setStroke(f.getStroke());
                    g2.draw(modificada);
                }
                estado = SELECCIONANDO;
            }
        }
        if(estado!=SELECCIONANDO && estado!=MODIFICANDO && estado!=CREACION){
            g2.setColor(Color.BLACK);
            for (int i = 0; i < forms.size(); i++) {
                f = forms.get(i);
                g2.setStroke(BS);
                g2.setColor(Color.BLACK);
                s = f.getShape();
                if(f.getRelleno()!=null){
                    g2.setColor(f.getRelleno());
                    g2.fill(s);
                    g2.setColor(Color.BLACK);
                }
                if(f.getContorno()!= null)
                    g2.setColor(f.getContorno());
                if(f.getStroke()!=null)
                    g2.setStroke(f.getStroke());
                g2.draw(s); 
            }
        }
        if (estado == MODIFICANDO){
            Shape modificada;
            for (int i=0; i < selectedforms.size(); i++){
                g2.setStroke(BSS);
                g2.setColor(Color.BLACK);
                f = selectedforms.get(i);
                modificada = f.getShape();
                Shape s1 = new Rectangle((int) modificada.getBounds().getMinX(), 
                                         (int) modificada.getBounds().getMinY(), 
                                         (int) modificada.getBounds().width, 
                                         (int) modificada.getBounds().height);
                g2.draw(s1);
                g2.setStroke(BS);
                g2.setColor(Color.BLUE);
                if(f.getRelleno()!=null){
                    g2.setColor(f.getRelleno());
                    g2.fill(modificada);
                    g2.setColor(Color.BLUE);
                }
                if(f.getStroke()!=null)
                    g2.setStroke(f.getStroke());
                g2.draw(modificada);
            }
        if(estado==CREACION){
            g2.setColor(Color.BLACK);
            for (int i = 0; i < forms.size(); i++) {
                f = forms.get(i);
                g2.setStroke(BS);
                g2.setColor(Color.BLACK);
                s = f.getShape();
                if(f.getRelleno()!=null){
                    g2.setColor(f.getRelleno());
                    g2.fill(s);
                    g2.setColor(Color.BLACK);
                }
                if(f.getContorno()!= null)
                    g2.setColor(f.getContorno());
                if(f.getStroke()!=null)
                    g2.setStroke(f.getStroke());
                g2.draw(s); 
            }
            g2.setColor(Color.BLACK);
            if(modoCreacion == QUAD_TO){
                g2.draw(partialShape);
            }
            else if(modoCreacion == CUBIC_TO){
                g2.draw(partialShape);
            }
            if(modoCreacion == LINE_TO){
                g2.drawLine(panterior.x, panterior.y, qu.x, qu.y);
            }
        }
     }
    }
 

    @Override
    public void mouseClicked(MouseEvent ev) {
        Graphics g = getGraphics();
        if(estado==MODIFICANDO){
            repaint();
        }
        else if(estado==SELECCIONANDO){
            Figura f = null;
            if(modoSeleccion == SIMPLE){
                puntoInicial = getPoint(ev);
                for(int i=0; i<forms.size(); i++){
                    if(forms.get(i).getShape().contains(puntoInicial)){
                        estado = CONFIRMADO;
                        f = forms.get(i);
                        indexModificado = i;
                        this.repaint();
                    }
                }
                if(f!= null){
                    selectedforms.add(f);
                }
            }
            else if(modoSeleccion == DOBLE){
                puntoInicial = getPoint(ev);
                for(int i=0; i<forms.size(); i++){
                    if(forms.get(i).getShape().contains(puntoInicial) && !selectedforms.contains(forms.get(i))){
                        f = forms.get(i);
                    }
                }
                if(f!= null){
                    selectedforms.add(f);
                    contDoble += 1;
                    estado = CONFIRMADO;
//                    desPath.describePath(f.getShape());
                }
            }
            else if(modoSeleccion == MULTIPLE){
                puntoInicial = getPoint(ev);
                f = null;
                for(int i=0; i<forms.size(); i++){
                    if(forms.get(i).getShape().contains(puntoInicial) && !selectedforms.contains(forms.get(i))){
                        f = forms.get(i);
                        desPath.describePath(f.getShape());
                    }
                }
                if(f!= null){
                    selectedforms.add(f);
                    estado = CONFIRMADO;
                }
                this.repaint();
            }
        }
        else if(estado==CREACION){
            switch(modoCreacion){
                case MOVE_TO:
                    panterior = ev.getPoint();
                    comienza = 0;
                    pathNew.moveTo(panterior.x,panterior.y);
               
                    break;
                case LINE_TO:
                    qu = ev.getPoint();
                    pathNew.lineTo(qu.x,qu.y);
                    g.drawLine(panterior.x,panterior.y, qu.x,qu.y);
                    panterior = qu;
                    if (comienza == 0){
                        comienza = 1;
                        //PanelObjetos.closePathB.setEnabled(true);
                    }
                   
                    break;
                case QUAD_TO:
                    rr = ev.getPoint();
                    ss = ev.getPoint();
                    pathNew.quadTo(rr.x, rr.y, ss.x, ss.y);
                    partialShape = new QuadCurve2D.Float(panterior.x, panterior.y, rr.x, rr.y, ss.x, ss.y);
                    panterior = ss;
                    if (comienza == 0){
                        comienza = 1;
                        //PanelObjetos.closePathB.setEnabled(true);
                    }
                    //PanelObjetos.quadToB.setSelected(false);
                    break;
                case CUBIC_TO:
                    qu = ev.getPoint();
                    rr = ev.getPoint();
                    ss = ev.getPoint();
                    pathNew.curveTo(qu.x, qu.y, rr.x, rr.y, ss.x, ss.y);
                    partialShape = new CubicCurve2D.Float(panterior.x, panterior.y, qu.x, qu.y, rr.x, rr.y, ss.x, ss.y);
                    panterior = ss;
                    if (comienza == 0){
                        comienza = 1;
                       //PanelObjetos.closePathB.setEnabled(true);
                    }
                   // PanelObjetos.cubicToB.setSelected(false);
                    break;
                
            }
        }
        else{
            estado=NONE;
        }
    }
  
    @Override
    public void mouseEntered(MouseEvent ev) {
    }

    @Override
    public void mouseExited(MouseEvent ev) {
    }

    @Override
    public void mousePressed(MouseEvent ev) {
        if(estado==MODIFICANDO){
            repaint();
        }
        if(estado==SELECCIONANDO){
            repaint();
        }
        if (estado==CREACION){
            repaint();
        }
        if(estado!=NONE){
            points.add(getPoint(ev));
            pointIndex++;
            p = null;
        }
    }
  
    public void escalaFigura(Point p1){
        anchoOriginal = pathTemporal.getBounds().getWidth();
        anchoActual = p.getX()-p1.getX();
        incrementoAncho = anchoActual*1.0/anchoOriginal;
        altoOriginal =pathTemporal.getBounds().getHeight();
        altoActual = p.getY()-p1.getY();
        incrementoAlto = altoActual*1.0/altoOriginal;
        transformacion.translate(p1.getX(), p1.getY());
        transformacion.scale(incrementoAncho, incrementoAlto);
    }
  
    public Point getPoint(MouseEvent ev){
        Point p1 = new Point(ev.getPoint().x - x0,ev.getPoint().y - y0);
        return p1;
    }
  
  @Override
    public void mouseDragged(MouseEvent ev) {
        pathTemporal=null;
        if(estado != NONE){
        Graphics2D g = (Graphics2D)getGraphics();
        g.translate(x0, y0);
        g.setXORMode(Color.white);
        transformacion = new AffineTransform();
        Point p1 = (Point)points.get(pointIndex-1);
        switch(estado){
            case DIBUJO:
                switch (shapeType) {
                    case RECTANGLE:
                        if (p != null) 
                            g.drawRect(p1.x, p1.y, p.x-p1.x, p.y-p1.y);
                        p = getPoint(ev);
                        g.drawRect(p1.x, p1.y, p.x-p1.x, p.y-p1.y);
                        break;
                    case ROUNDRECTANGLE2D:
                        if (p != null) 
                            g.drawRoundRect(p1.x, p1.y, p.x-p1.x, p.y-p1.y,10,10);
                        p = getPoint(ev);
                        g.drawRoundRect(p1.x, p1.y, p.x-p1.x, p.y-p1.y,10,10);
                        break;
                    case ELLIPSE2D:
                        if (p != null) 
                            g.drawOval(p1.x, p1.y, p.x-p1.x, p.y-p1.y);
                        p = getPoint(ev);
                        g.drawOval(p1.x, p1.y, p.x-p1.x, p.y-p1.y);
                        break;
                    case ARC2D:
                        if (p != null) 
                            g.drawArc(p1.x, p1.y, p.x-p1.x, p.y-p1.y, 30, 120);
                        p = getPoint(ev);
                        g.drawArc(p1.x, p1.y, p.x-p1.x, p.y-p1.y, 30, 120);
                        break;
                    case LINE2D:
                    case QUADCURVE2D:
                        if (pointIndex == 1) {
                            if (p != null) 
                                g.drawLine(p1.x, p1.y, p.x, p.y);
                            p = getPoint(ev);
                            g.drawLine(p1.x, p1.y, p.x, p.y);
                        } 
                        else {
                            Point p2 = (Point)points.get(pointIndex-2);
                            if (p != null) 
                                g.draw(partialShape);
                            p = getPoint(ev);
                            partialShape = new QuadCurve2D.Float(p2.x, p2.y, p1.x, p1.y, p.x, p.y);
                            g.draw(partialShape);
                        }
                      break;
                    case CUBICCURVE2D:
                        if (pointIndex == 1) {
                            if (p != null) 
                                g.drawLine(p1.x, p1.y, p.x, p.y);
                            p = getPoint(ev);
                            g.drawLine(p1.x, p1.y, p.x, p.y);
                        } else if (pointIndex == 2) {
                            Point p2 = (Point)points.get(pointIndex-2);
                            if (p != null) 
                                g.draw(partialShape);
                            p = getPoint(ev);
                            partialShape = new QuadCurve2D.Float(p2.x, p2.y, p1.x, p1.y, p.x, p.y);
                            g.draw(partialShape);
                        } else {
                            Point p2 = (Point)points.get(pointIndex-2);
                            Point p3 = (Point)points.get(pointIndex-3);
                            if (p != null) 
                                g.draw(partialShape);
                            p = getPoint(ev);
                            partialShape = new CubicCurve2D.Float(p3.x, p3.y, p2.x, p2.y, p1.x, p1.y, p.x, p.y);
                            g.draw(partialShape);
                        }
                      break;
                    case HEART:
                        if (p != null){
                            partialShape = new Heart(p1.x, p1.y, p.x-p1.x, p.y-p1.y); 
                            g.draw(partialShape);
                        }
                        p = getPoint(ev);
                        partialShape = new Heart(p1.x, p1.y, p.x-p1.x, p.y-p1.y);
                        g.draw(partialShape);
                        break;  
                    case PETALOS:
                        if (p != null){
                            partialShape = new Petalos(p1.x, p1.y, p.x-p1.x, p.y-p1.y); 
                            g.draw(partialShape);
                        }
                        p = getPoint(ev);
                        partialShape = new Petalos(p1.x, p1.y, p.x-p1.x, p.y-p1.y);
                        g.draw(partialShape);
                        break;                    
                    case FANTASMA:
                        Fantasma f = new Fantasma();
                        pathTemporal = f.getPath();
                        p = getPoint(ev);
                        escalaFigura(p1);
                        partialShape = transformacion.createTransformedShape(pathTemporal);
                        g.draw(partialShape);
                        break;
                    case ESTRELLA:
                        Estrella e = new Estrella();
                        pathTemporal = e.getPath();
                        p = getPoint(ev);
                        escalaFigura(p1);
                        partialShape = transformacion.createTransformedShape(pathTemporal);
                        g.draw(partialShape);
                        break;
                    case FLECHA:
                        Flecha fl = new Flecha();
                        pathTemporal = fl.getPath();
                        p = getPoint(ev);
                        escalaFigura(p1);
                        partialShape = transformacion.createTransformedShape(pathTemporal);
                        g.draw(partialShape);
                        break;
                    case GLOBO:
                        Globo gl = new Globo();
                        pathTemporal = gl.getPath();
                        p = getPoint(ev);
                        escalaFigura(p1);
                        partialShape = transformacion.createTransformedShape(pathTemporal);
                        g.draw(partialShape);
                        break;
                    case PACKMAN:
                        if (p != null) g.drawArc(p1.x, p1.y, p.x-p1.x, p.y-p1.y, 0, 270);
                        p = ev.getPoint();
                        g.drawArc(p1.x, p1.y, p.x-p1.x, p.y-p1.y, 0, 270);
                        break;
                    case REBANADA:
                        if (p != null) g.drawArc(p1.x, p1.y, p.x-p1.x, p.y-p1.y, 60, -120);
                        p = ev.getPoint();
                        g.drawArc(p1.x, p1.y, p.x-p1.x, p.y-p1.y, 60, -120);
                        break;
                    case ARCO_VERTICAL:
                        if (p != null) g.drawArc(p1.x, p1.y, p.x-p1.x, p.y-p1.y, 60, -120);
                        p = ev.getPoint();
                        g.drawArc(p1.x, p1.y, p.x-p1.x, p.y-p1.y, 60, -120);
                        break;
                    case GUARDADA:
                        HashMap<String,GeneralPath> h =  a.leerFiguras();
                        pathTemporal = h.get(nomFigura);
                        p = getPoint(ev);
                        escalaFigura(p1);
                        partialShape = transformacion.createTransformedShape(pathTemporal);
                        g.draw(partialShape);
                        break;
                }
                break;
            case MODIFICANDO:
                switch(modo){
                    case TRANSFORM:
                        switch (transformType) {
                            case TRANSLATION:
                                p = getPoint(ev);
                                transformacion.setToTranslation(p.x - p1.x, p.y - p1.y);
                                break;
                            case ROTATION:
                                p = getPoint(ev);
                                double a =   Math.atan2(p.y, p.x) - Math.atan2(p1.y, p1.x);
                                transformacion.setToRotation(a);
                                break;
                            case SCALING:
                                p = getPoint(ev);
                                double sx = Math.abs((double)(p.x)/(p1.x));
                                double sy = Math.abs((double)(p.y)/(p1.y));
                                transformacion.setToScale(sx, sy);
                                break;
                            case SHEARING:
                                p = getPoint(ev);
                                double shx = ((double)(p.x)/(p1.x))-1;
                                double shy = ((double)(p.y)/(p1.y))-1;
                                transformacion.setToShear(shx, shy);
                                break;
                            case REFLECTION:
                                transformacion.setTransform(-1,0,0,1,0,0);
                                break;
                        }
                        g.setXORMode(Color.gray);
                        for(Figura fig : selectedforms){
                            partialShape = transformacion.createTransformedShape(fig.getShape());
                            g.draw(partialShape);
                        }
                    break;
                }
            break;
            default:
                repaint();
        }
        }
    }
    
    
    public void quitaDeFiguras(Figura f){
        if (forms.contains(f)){
            forms.remove(f);
        }
    }

    @Override
    public void mouseReleased(MouseEvent ev) {
        if(estado!=NONE){
        Graphics g = getGraphics();
        g.translate(x0, y0);
        Point p1 = (Point)(points.get(pointIndex-1));
        p = getPoint(ev);
        Shape s = null;
        switch (estado){
            case DIBUJO:
                switch (shapeType) {
                    case RECTANGLE:
                        s = new Rectangle(p1.x, p1.y, p.x-p1.x, p.y-p1.y);
                        break;
                    case ROUNDRECTANGLE2D:
                        s = new RoundRectangle2D.Float(p1.x, p1.y, p.x-p1.x, p.y-p1.y, 10, 10);
                        break;
                    case ELLIPSE2D:
                        s = new Ellipse2D.Float(p1.x, p1.y, p.x-p1.x, p.y-p1.y);
                        break;
                    case ARC2D:
                        s = new Arc2D.Float(p1.x, p1.y, p.x-p1.x, p.y-p1.y, 30, 120, Arc2D.OPEN);
                        break;
                    case LINE2D:
                        s = new Line2D.Float(p1.x, p1.y, p.x, p.y);
                        break;
                    case QUADCURVE2D:
                        if (pointIndex > 1) {
                            Point p2 = (Point)points.get(0);
                            s = new QuadCurve2D.Float(p2.x, p2.y, p1.x, p1.y, p.x, p.y);
                        }
                        break;
                    case CUBICCURVE2D:
                        if (pointIndex > 2) {
                            Point p2 = (Point)points.get(pointIndex-2);
                            Point p3 = (Point)points.get(pointIndex-3);
                            s = new CubicCurve2D.Float(p3.x, p3.y, p2.x, p2.y, p1.x, p1.y, p.x, p.y);
                        }
                        break;
                    case HEART:
                        s = new Heart(p1.x, p1.y, p.x-p1.x, p.y-p1.y);
                        break;
                    case PETALOS:
                        s = new Petalos(p1.x, p1.y, p.x-p1.x, p.y-p1.y);
                        break;
                    case FANTASMA: 
                        s = transformacion.createTransformedShape(pathTemporal);
                        break;
                    case ESTRELLA:
                        s = transformacion.createTransformedShape(pathTemporal);
                        break;
                    case FLECHA:
                        s = transformacion.createTransformedShape(pathTemporal);
                        break;
                    case GLOBO:
                        s = transformacion.createTransformedShape(pathTemporal);
                        break;
                    case PACKMAN:
                        s = new Arc2D.Double(p1.x, p1.y, p.x-p1.x, p.y-p1.y, 0, 270, Arc2D.PIE);
                        break;
                    case REBANADA:
                        s = new Arc2D.Float(p1.x, p1.y, p.x-p1.x, p.y-p1.y, 60, -120, Arc2D.PIE);
                        break;
                    case ARCO_VERTICAL:
                        s = new Arc2D.Float(p1.x, p1.y, p.x-p1.x, p.y-p1.y, 90, 135, Arc2D.CHORD);
                        break;
                    case GUARDADA:
                        s = transformacion.createTransformedShape(pathTemporal);
                        break;
                }
                break;
            case MODIFICANDO:
                switch(modo){
                    case(STROKE):
                        break;
                    case(TRANSFORM):
                        switch (transformType) {
                            case TRANSLATION:
                                p = getPoint(ev);
                                transformacion.setToTranslation(p.x - p1.x, p.y - p1.y);
                                break;
                            case ROTATION:
                                p = getPoint(ev);
                                double a =   Math.atan2(p.y, p.x) - Math.atan2(p1.y, p1.x);
                                transformacion.setToRotation(a);
                                break;
                            case SCALING:
                                p = getPoint(ev);
                                double sx = Math.abs((double)(p.x)/(p1.x));
                                double sy = Math.abs((double)(p.y)/(p1.y));
                                transformacion.setToScale(sx, sy);
                                break;
                            case SHEARING:
                                p = getPoint(ev);
                                double shx = ((double)(p.x)/(p1.x))-1;
                                double shy = ((double)(p.y)/(p1.y))-1;
                                transformacion.setToShear(shx, shy);
                                break;
                            case REFLECTION:
                                transformacion.setTransform(-1,0,0,1,0,0);
                                break;
                        }
                        Iterator<Figura> it = selectedforms.iterator();
                        Vector<Figura> aux = new Vector<Figura>();
                        while(it.hasNext()) {
                            Figura f = it.next();
                            quitaDeFiguras(f);
                            f.setShape(transformacion.createTransformedShape(f.getShape()));
                            aux.add(f);
                            it.remove();
                        }
                        selectedforms = aux;
                        for(Figura f : selectedforms){
                            forms.add(f);
                        }
                        aux.clear();
                        estado = NONE;
                        PanelObjetos.SeleccToggleB.setSelected(false);
                        modo = NONE;
                        break;
                    case(AREA):
                        break;
                }
                break;
            default:
                break;
        }
        if (s != null) {
            forms.add(new Figura(s,StrokeGlobal,desPath.obtenerPath(s),colorContornoGlob,colorFillGlob,0));
            points.clear();
            pointIndex = 0;
            partialShape = null;
            p = null;
        }
        repaint();
        }
   }

    @Override
    public void mouseMoved(MouseEvent ev) {
        PanelObjetos.InfoCoordenadas.setText("x: " + (ev.getX()-x0) + "   y: " + ( (ev.getY()-y0)));
    }
}



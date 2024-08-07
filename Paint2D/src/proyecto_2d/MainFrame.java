

package proyecto_2d;

import java.awt.event.WindowEvent;
import javax.swing.*;

public class MainFrame extends JFrame{
    JTabbedPane pestanas;
    PanelObjetos pobj;
    public MainFrame() {
        setTitle("Paint 2D by Ivón LS");
        setSize(1130,725); 
        setLocationRelativeTo(null);
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void initComponents(){
        pestanas = new JTabbedPane();
        pobj = new PanelObjetos();
        pobj.sSimple.setEnabled(false);
        pobj.sMultiple.setEnabled(false);
        //pobj.AreaToggleB.setEnabled(false);
        pobj.StrokeToggleB.setEnabled(false);
        pobj.TransformToggleB.setEnabled(false);
        pobj.opcion.setEnabled(false);
        pobj.quitarSeleccion.setEnabled(false);
        pobj.BotonBorrar.setEnabled(false);
        pobj.sDoble.setEnabled(false);
       
        pestanas.add("Área de trabajo",pobj); 
        setResizable(false);
        add(pestanas);
    }
}

package proyecto_2d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import static proyecto_2d.PaintPanel.BS;
import static proyecto_2d.PaintPanel.NONE;
import static proyecto_2d.PaintPanel.grosorGlobal;

public class PanelObjetos extends javax.swing.JPanel {
    PaintPanel panel = null;
    Archivo a = new Archivo();
    public PanelObjetos() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    private void init(){
        String lista[] = new String[] { "Rectangle", "RoundRectangle", "Ellipse", "Arc","Line" ,"QuadCurve","CubicCurve"};
        ListaObjetos.setModel(new javax.swing.DefaultComboBoxModel<>(lista));
        actualizaMisObjetos();
        opcionesStrokeGolbal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Continuo", "Punteado"}));
        panel = new PaintPanel();
        Panel2.add(panel);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelObjetos = new javax.swing.JPanel();
        SeleccToggleB = new javax.swing.JToggleButton();
        TransformToggleB = new javax.swing.JToggleButton();
        StrokeToggleB = new javax.swing.JToggleButton();
        opcion = new javax.swing.JComboBox<>();
        sSimple = new javax.swing.JToggleButton();
        sMultiple = new javax.swing.JToggleButton();
        opcion1 = new javax.swing.JComboBox<>();
        BotonBorrar = new javax.swing.JButton();
        sDoble = new javax.swing.JToggleButton();
        BotonAbrirSesion = new javax.swing.JButton();
        BotonGuardarSesion = new javax.swing.JButton();
        BotonLimpiar = new javax.swing.JButton();
        quitarSeleccion = new javax.swing.JButton();
        Panel2 = new javax.swing.JPanel();
        panelButtonStroke = new javax.swing.JPanel();
        BotonContorno = new javax.swing.JButton();
        BotonRelleno = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        labelColorCont = new javax.swing.JLabel();
        labelColorRell = new javax.swing.JLabel();
        opcionesStrokeGolbal = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ListaObjetos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        MisObjetos = new javax.swing.JComboBox<>();
        InfoCoordenadas = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setMinimumSize(new java.awt.Dimension(1200, 690));
        setPreferredSize(new java.awt.Dimension(1200, 690));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelObjetos.setBackground(new java.awt.Color(153, 51, 255));
        PanelObjetos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SeleccToggleB.setBackground(new java.awt.Color(51, 0, 102));
        SeleccToggleB.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        SeleccToggleB.setForeground(new java.awt.Color(255, 255, 255));
        SeleccToggleB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/selection_41874.png"))); // NOI18N
        SeleccToggleB.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SeleccToggleBStateChanged(evt);
            }
        });
        SeleccToggleB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccToggleBActionPerformed(evt);
            }
        });
        PanelObjetos.add(SeleccToggleB, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 70, 80));

        TransformToggleB.setBackground(new java.awt.Color(51, 0, 102));
        TransformToggleB.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        TransformToggleB.setForeground(new java.awt.Color(255, 255, 255));
        TransformToggleB.setText("Transform");
        TransformToggleB.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                TransformToggleBStateChanged(evt);
            }
        });
        PanelObjetos.add(TransformToggleB, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 120, 20));

        StrokeToggleB.setBackground(new java.awt.Color(51, 0, 102));
        StrokeToggleB.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        StrokeToggleB.setForeground(new java.awt.Color(255, 255, 255));
        StrokeToggleB.setText("Stroke y Color");
        StrokeToggleB.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                StrokeToggleBStateChanged(evt);
            }
        });
        PanelObjetos.add(StrokeToggleB, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 120, 20));

        opcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionActionPerformed(evt);
            }
        });
        PanelObjetos.add(opcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 150, 20));

        sSimple.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/selection_icon_135212.png"))); // NOI18N
        sSimple.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sSimple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sSimpleActionPerformed(evt);
            }
        });
        PanelObjetos.add(sSimple, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 60, 50));

        sMultiple.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hexagon_multiple_outline_icon_139470.png"))); // NOI18N
        sMultiple.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sMultiple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMultipleActionPerformed(evt);
            }
        });
        PanelObjetos.add(sMultiple, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 60, 50));

        opcion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion1ActionPerformed(evt);
            }
        });
        PanelObjetos.add(opcion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, 150, 20));

        BotonBorrar.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        BotonBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar1.png"))); // NOI18N
        BotonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBorrarActionPerformed(evt);
            }
        });
        PanelObjetos.add(BotonBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 60, 60));

        sDoble.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/vector_selection_icon_137056.png"))); // NOI18N
        sDoble.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sDoble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sDobleActionPerformed(evt);
            }
        });
        PanelObjetos.add(sDoble, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 60, 50));

        BotonAbrirSesion.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        BotonAbrirSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/abrir.png"))); // NOI18N
        BotonAbrirSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAbrirSesionActionPerformed(evt);
            }
        });
        PanelObjetos.add(BotonAbrirSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 60, 60));

        BotonGuardarSesion.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        BotonGuardarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        BotonGuardarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarSesionActionPerformed(evt);
            }
        });
        PanelObjetos.add(BotonGuardarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, 60));

        BotonLimpiar.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        BotonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        BotonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLimpiarActionPerformed(evt);
            }
        });
        PanelObjetos.add(BotonLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 60, 60));

        quitarSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/selection_off_icon_135213.png"))); // NOI18N
        quitarSeleccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        quitarSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarSeleccionActionPerformed(evt);
            }
        });
        PanelObjetos.add(quitarSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 60, 50));

        add(PanelObjetos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1050, 110));

        Panel2.setPreferredSize(new java.awt.Dimension(930, 510));
        add(Panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 810, 510));

        panelButtonStroke.setBackground(new java.awt.Color(153, 51, 255));
        panelButtonStroke.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelButtonStrokeMouseMoved(evt);
            }
        });
        panelButtonStroke.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonContorno.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        BotonContorno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contorno.png"))); // NOI18N
        BotonContorno.setToolTipText("*PARA OBJETOS FUTUROS");
        BotonContorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonContornoActionPerformed(evt);
            }
        });
        panelButtonStroke.add(BotonContorno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 70, 60));

        BotonRelleno.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        BotonRelleno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/relleno.png"))); // NOI18N
        BotonRelleno.setToolTipText("*PARA OBJETOS FUTUROS");
        BotonRelleno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BotonRelleno.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        BotonRelleno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRellenoActionPerformed(evt);
            }
        });
        panelButtonStroke.add(BotonRelleno, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 70, 60));

        jSlider1.setBackground(new java.awt.Color(102, 102, 102));
        jSlider1.setForeground(new java.awt.Color(0, 0, 0));
        jSlider1.setMaximum(18);
        jSlider1.setMinimum(1);
        jSlider1.setValue(1);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        panelButtonStroke.add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 200, 30));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Grosor");
        panelButtonStroke.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        labelColorCont.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelColorCont.setText("ACTUAL");
        panelButtonStroke.add(labelColorCont, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 50, 30));

        labelColorRell.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelColorRell.setText("ACTUAL");
        panelButtonStroke.add(labelColorRell, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 50, 30));

        opcionesStrokeGolbal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionesStrokeGolbalActionPerformed(evt);
            }
        });
        panelButtonStroke.add(opcionesStrokeGolbal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 120, 30));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Línea");
        jLabel3.setToolTipText("");
        panelButtonStroke.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 50, 40));

        jButton1.setBackground(new java.awt.Color(51, 0, 102));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Default");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelButtonStroke.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 110, -1));

        jLabel6.setBackground(new java.awt.Color(204, 153, 255));
        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 255, 102));
        jLabel6.setText("Relleno");
        panelButtonStroke.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jLabel7.setBackground(new java.awt.Color(204, 153, 255));
        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 0, 51));
        jLabel7.setText("Propiedades ");
        panelButtonStroke.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, -1));

        jLabel8.setBackground(new java.awt.Color(204, 153, 255));
        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 204, 204));
        jLabel8.setText("Contorno");
        panelButtonStroke.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 153, 255));
        jLabel4.setText("Ivón López");
        panelButtonStroke.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial Black", 0, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 255));
        jLabel10.setText("Paint 2D");
        panelButtonStroke.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Objetos predeterminados");
        panelButtonStroke.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 180, 20));

        ListaObjetos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ListaObjetos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaObjetosActionPerformed(evt);
            }
        });
        panelButtonStroke.add(ListaObjetos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 190, 20));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Mis objetos");
        panelButtonStroke.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 100, 20));

        MisObjetos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MisObjetosActionPerformed(evt);
            }
        });
        panelButtonStroke.add(MisObjetos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 190, 20));

        add(panelButtonStroke, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 240, 510));

        InfoCoordenadas.setBackground(new java.awt.Color(153, 153, 153));
        InfoCoordenadas.setForeground(new java.awt.Color(255, 255, 255));
        add(InfoCoordenadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 180, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void ListaObjetosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaObjetosActionPerformed
        SeleccToggleB.setSelected(false);
        panel.estado = PaintPanel.DIBUJO;
        panel.selectedforms.clear();
        String command = ListaObjetos.getItemAt(ListaObjetos.getSelectedIndex());
        
        if (null != command) switch (command) {
            case "Rectangle":
                panel.shapeType = PaintPanel.RECTANGLE;
                break;
            case "RoundRectangle":
                panel.shapeType = PaintPanel.ROUNDRECTANGLE2D;
                break;
            case "Ellipse":
                panel.shapeType = PaintPanel.ELLIPSE2D;
                break;
            case "Arc":
                panel.shapeType = PaintPanel.ARC2D;
                break;
            case "Line":
                panel.shapeType = PaintPanel.LINE2D;
                break;
            case "QuadCurve":
                panel.shapeType = PaintPanel.QUADCURVE2D;
                break;
            case "CubicCurve":
                panel.shapeType = PaintPanel.CUBICCURVE2D;
                break;
            default:
                break;
        }
    }//GEN-LAST:event_ListaObjetosActionPerformed

    private void MisObjetosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MisObjetosActionPerformed
        // SIMILAR A LA LISTA DE OBJETOS PERO CON LOS QUE HEMOS CREADO
        SeleccToggleB.setSelected(false);
        panel.estado = PaintPanel.DIBUJO;
        panel.selectedforms.clear();
        String command = MisObjetos.getItemAt(MisObjetos.getSelectedIndex());
        if (null != command) switch (command) {
            case "Corazon":
                panel.shapeType = PaintPanel.HEART;
                break;
            case "Petalos":
                panel.shapeType = PaintPanel.PETALOS;
                break;
            case "Fantasma":
                panel.shapeType = panel.FANTASMA;
                break;
            case "Estrella":
                panel.shapeType = panel.ESTRELLA;
                break;
            case "Flecha":
                panel.shapeType = panel.FLECHA;
                break;
            case "Globo":
                panel.shapeType = panel.GLOBO;
                break;
            case "Packman":
                panel.shapeType = panel.PACKMAN;
                break;
            case "Rebanada":
                panel.shapeType = panel.REBANADA;
                break;
            case "Arco vertical":
                panel.shapeType = panel.ARCO_VERTICAL;
                break;
            default:
                panel.shapeType = panel.GUARDADA;
                panel.nomFigura = command;
                break;
        }
    }//GEN-LAST:event_MisObjetosActionPerformed

    public void actualizaMisObjetos(){
        int i;
        String lista2[];
        String lista1[] = new String[] { "Corazon","Petalos", "Fantasma", "Estrella", "Flecha", "Globo","Packman","Rebanada","Arco vertical"};
        HashMap<String,GeneralPath> h = a.leerFiguras();
        if (h != null){
            lista2 = new String[9+h.size()];
        }
        else{
            lista2 = new String[9];
        }
        for(i = 0;i<9;i++){
            lista2[i] = new String(lista1[i]);
        }
        i=9;
        if (h != null){
            for (String nom : h.keySet()) {
                if (nom!=null){
                lista2[i] = new String(nom);
                i++;}
            }
        }
        MisObjetos.setModel(new javax.swing.DefaultComboBoxModel<>(lista2));
    }
    
    private void BotonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLimpiarActionPerformed
        String[] options = {"Aceptar", "Cancelar"};
        int res = JOptionPane.showOptionDialog(null, "¿Desea eliminar los elementos del panel?","Click a button",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (res == 0){
            limpiar();
        }
    }//GEN-LAST:event_BotonLimpiarActionPerformed

    public void limpiar(){
        Panel2.remove(panel);
        Panel2.revalidate();
        Panel2.repaint();
        panel = null;
        panel = new PaintPanel();
        Panel2.add(panel);
        panel.grosorGlobal = 1;
        panel.colorContornoGlob = null;
        panel.colorFillGlob = null;
        panel.StrokeGlobal = null;
    }
    
    private void BotonContornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonContornoActionPerformed
        // BOTON PARA COLOR
        panel.colorContornoGlob = JColorChooser.showDialog(null, "Seleccione un color", Color.gray);
        labelColorCont.setForeground(panel.colorContornoGlob);
    }//GEN-LAST:event_BotonContornoActionPerformed

    private void BotonRellenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRellenoActionPerformed
        // CONTORNO
        panel.colorFillGlob = JColorChooser.showDialog(null, "Seleccione un color", Color.gray);
        labelColorRell.setForeground(panel.colorFillGlob);
    }//GEN-LAST:event_BotonRellenoActionPerformed

    private void SeleccToggleBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccToggleBActionPerformed
        if(SeleccToggleB.isSelected()){
            sSimple.setEnabled(true);
            sMultiple.setEnabled(true);
            sDoble.setEnabled(true);
            panel.estado = PaintPanel.SELECCIONANDO;
        }
        else{
            sSimple.setEnabled(false);
            sMultiple.setEnabled(false);
            sSimple.setSelected(false);
            sMultiple.setSelected(false);
            //AreaToggleB.setEnabled(false);
            TransformToggleB.setEnabled(false);
            StrokeToggleB.setEnabled(false);
            //AreaToggleB.setSelected(false);
            TransformToggleB.setSelected(false);
            StrokeToggleB.setSelected(false);
            sDoble.setSelected(false);
            sDoble.setEnabled(false);
        }
    }//GEN-LAST:event_SeleccToggleBActionPerformed
 
    private void SeleccToggleBStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SeleccToggleBStateChanged
        if(SeleccToggleB.isSelected()){
            sSimple.setEnabled(true);
            sMultiple.setEnabled(true);
            sDoble.setEnabled(true);
            quitarSeleccion.setEnabled(true);
        }
        else{
            sDoble.setSelected(false);
            sDoble.setEnabled(false);
            sSimple.setEnabled(false);
            sMultiple.setEnabled(false);
            sSimple.setSelected(false);
            quitarSeleccion.setEnabled(false);
            sMultiple.setSelected(false);
            //AreaToggleB.setEnabled(false);
            TransformToggleB.setEnabled(false);
            StrokeToggleB.setEnabled(false);
            //AreaToggleB.setSelected(false);
            TransformToggleB.setSelected(false);
            StrokeToggleB.setSelected(false);
            BotonBorrar.setEnabled(false);
        }
    }//GEN-LAST:event_SeleccToggleBStateChanged

    private void quitarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarSeleccionActionPerformed
        SeleccToggleB.setSelected(false);
        panel.estado = PaintPanel.NONE;
        panel.selectedforms.clear();
        panel.repaint();
    }//GEN-LAST:event_quitarSeleccionActionPerformed

    private void TransformToggleBStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TransformToggleBStateChanged
        if (TransformToggleB.isSelected()) {
            //AreaToggleB.setSelected(false);
            StrokeToggleB.setSelected(false);
            panel.modo = PaintPanel.TRANSFORM;
            String[] lista = {"TRANSLATION", "ROTATION","SCALING","SHEARING","REFLECTION"};
            opcion.setModel(new DefaultComboBoxModel<>(lista));
            opcion.setEnabled(true);
        } else {
            panel.modo = PaintPanel.MODIFICANDO;
            opcion.setModel(new DefaultComboBoxModel<>(new String[] {}));
            opcion.setEnabled(false);
        }
    }//GEN-LAST:event_TransformToggleBStateChanged

    private void StrokeToggleBStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_StrokeToggleBStateChanged
        if (StrokeToggleB.isSelected()) {
            //AreaToggleB.setSelected(false);
            TransformToggleB.setSelected(false);
            panel.modo = PaintPanel.NONE;
            String[] lista = {"COLOR CONTORNO", "COLOR RELLENO","SIN RELLENO","CONTORNO CONTINUO","CONTORNO PUNTEADO","GROSOR"};
            opcion1.setModel(new DefaultComboBoxModel<>(lista));
            opcion1.setEnabled(true);
        } else {
            panel.modo = PaintPanel.MODIFICANDO;
            opcion1.setModel(new DefaultComboBoxModel<>(new String[] {}));
            opcion1.setEnabled(false);
            
        }
    }//GEN-LAST:event_StrokeToggleBStateChanged
 
    private void opcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionActionPerformed
        if (TransformToggleB.isSelected()) {
            String command = opcion.getItemAt(opcion.getSelectedIndex());
            if (null != command) switch (command) {
                case "TRANSLATION":
                    panel.transformType = PaintPanel.TRANSLATION;
                    break;
                case "ROTATION":
                    panel.transformType = PaintPanel.ROTATION;
                    break;
                case "SCALING":
                    panel.transformType = PaintPanel.SCALING;
                    break;
                case "SHEARING":
                    panel.transformType = PaintPanel.SHEARING;
                    break;
                case "REFLECTION":
                    panel.transformType = PaintPanel.REFLECTION;
                    break;
            }
        }
    }//GEN-LAST:event_opcionActionPerformed

    private void opcion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion1ActionPerformed
        Figura f;
        Iterator<Figura> it;
        Vector<Figura> aux = new Vector<Figura>();
        BasicStroke nuevob ;
        Color nuevo;
        int grosor = 1;
        if (StrokeToggleB.isSelected()) {
            String command = opcion1.getItemAt(opcion1.getSelectedIndex());
            if (null != command) switch (command) {
                case "COLOR CONTORNO":
                    nuevo = JColorChooser.showDialog(null, "Seleccione un color", Color.gray);
                    it = panel.selectedforms.iterator();
                    aux.clear();
                    while(it.hasNext()) {
                        f = it.next();
                        panel.quitaDeFiguras(f);
                        f.setContorno(nuevo);
                        aux.add(f);
                        it.remove();
                    }
                    panel.selectedforms = aux;
                    for(Figura fi : panel.selectedforms){
                        panel.forms.add(fi);
                    }
                    panel.estado = PaintPanel.NONE;
                    break;
                case "COLOR RELLENO":
                    nuevo = JColorChooser.showDialog(null, "Seleccione un color", Color.gray);
                    it = panel.selectedforms.iterator();
                    aux.clear();
                    while(it.hasNext()) {
                        f = it.next();
                        panel.quitaDeFiguras(f);
                        f.setRelleno(nuevo);
                        aux.add(f);
                        it.remove();
                    }
                    panel.selectedforms = aux;
                    for(Figura fi : panel.selectedforms){
                        panel.forms.add(fi);
                    }
                    panel.estado = PaintPanel.NONE;
                    break;
                case "SIN RELLENO":
                    it = panel.selectedforms.iterator();
                    aux.clear();
                    while(it.hasNext()) {
                        f = it.next();
                        panel.quitaDeFiguras(f);
                        f.setRelleno(null);
                        aux.add(f);
                        it.remove();
                    }
                    panel.selectedforms = aux;
                    for(Figura fi : panel.selectedforms){
                        panel.forms.add(fi);
                    }
                    panel.estado = PaintPanel.NONE;
                    break;
                case "CONTORNO CONTINUO":
                    it = panel.selectedforms.iterator();
                    while(it.hasNext()) {
                        f = it.next();
                        if (f.getStroke() == null)
                            nuevob = new BasicStroke (1,BasicStroke.CAP_ROUND,                  
                                                  BasicStroke.JOIN_ROUND);
                        else nuevob = new BasicStroke (f.getStroke().getLineWidth(),BasicStroke.CAP_ROUND,                  // End cap
                                                  BasicStroke.JOIN_ROUND);
                        panel.quitaDeFiguras(f);
                        f.setStroke(nuevob);
                        aux.add(f);
                        it.remove();
                    }
                    panel.selectedforms = aux;
                    for(Figura fi : panel.selectedforms){
                        panel.forms.add(fi);
                    }
                    panel.estado = PaintPanel.NONE;
                    break;
                case "CONTORNO PUNTEADO":
                    it = panel.selectedforms.iterator();
                    while(it.hasNext()) {
                        f = it.next();
                        if (f.getStroke() == null)
                        nuevob = new BasicStroke (1,BasicStroke.CAP_SQUARE,                  // End cap
                                                  BasicStroke.JOIN_MITER,10.0f,new float[] {16.0f,20.0f},0.0f);
                        else nuevob = new BasicStroke (f.getStroke().getLineWidth(),BasicStroke.CAP_SQUARE,                  // End cap
                                                  BasicStroke.JOIN_MITER,10.0f,new float[] {16.0f,20.0f},0.0f);
                        panel.quitaDeFiguras(f);
                        f.setStroke(nuevob);
                        aux.add(f);
                        it.remove();
                    }
                    panel.selectedforms = aux;
                    for(Figura fi : panel.selectedforms){
                        panel.forms.add(fi);
                    }
                    panel.estado = PaintPanel.NONE;
                    break;
                case "GROSOR":
                    it = panel.selectedforms.iterator();
                    aux.clear();
                    boolean band = false;
                    while(band == false){
                        try{
                            grosor = parseInt(JOptionPane.showInputDialog(null, "Ingresa un numero > 0 y < 18"));
                            if(grosor >0 && grosor<18) band = true;
                            else JOptionPane.showMessageDialog(null, "Fuera de rango");
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null, "Dato incorrecto");}
                    }
                    while(it.hasNext()) {
                        f = it.next();
                        try{
                            nuevob = new BasicStroke (grosor,f.getStroke().getEndCap(),f.getStroke().getLineJoin(),
                                                  f.getStroke().getMiterLimit(),f.getStroke().getDashArray(),
                                                  f.getStroke().getDashPhase());
                        }
                        catch(RuntimeException e){
                            nuevob = new BasicStroke (grosor,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
                        }
                        panel.quitaDeFiguras(f);
                        f.setStroke(nuevob);
                        aux.add(f);
                        it.remove();
                    }
                    panel.selectedforms = aux;
                    for(Figura fi : panel.selectedforms){
                        panel.forms.add(fi);
                    }
                    panel.estado = PaintPanel.NONE;
                    break;
            }
        }
        SeleccToggleB.setSelected(false);
        panel.repaint();
    }//GEN-LAST:event_opcion1ActionPerformed

    private void panelButtonStrokeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelButtonStrokeMouseMoved
        // TODO add your handling code here:
        panelButtonStroke.setToolTipText("PARA OBJETOS FUTUROS");
    }//GEN-LAST:event_panelButtonStrokeMouseMoved

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        panel.grosorGlobal = jSlider1.getValue();
        String command = opcionesStrokeGolbal.getItemAt(opcionesStrokeGolbal.getSelectedIndex());
        if (null != command) switch (command) {
            case "Continuo":
                panel.StrokeGlobal = new BasicStroke(panel.grosorGlobal,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
                break;
            case "Punteado":
                panel.StrokeGlobal = new BasicStroke(panel.grosorGlobal,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_MITER,10.0f,new float[] {16.0f,20.0f},0.0f);
                break;        // TODO add your handling code here:
        }
    }//GEN-LAST:event_jSlider1StateChanged

    private void BotonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBorrarActionPerformed
        String[] options = {"Aceptar", "Cancelar"};
        int res = JOptionPane.showOptionDialog(null, "¿Desea eliminar los elementos del panel?","Click a button",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (res == 0){
            for(Figura f :panel.selectedforms){
                panel.quitaDeFiguras(f);
                panel.estado = PaintPanel.NONE;
                SeleccToggleB.setSelected(false);
            }
            panel.selectedforms.clear();
        }
        panel.repaint();
        BotonBorrar.setEnabled(false);
    }//GEN-LAST:event_BotonBorrarActionPerformed

    private void sSimpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sSimpleActionPerformed
        if(sSimple.isSelected()){
            panel.selectedforms.clear();
            sMultiple.setSelected(false);
            panel.modoSeleccion = PaintPanel.SIMPLE;
        }
        else{
            panel.selectedforms.clear();
            panel.modoSeleccion = PaintPanel.NONE;
            panel.repaint();
        }
    }//GEN-LAST:event_sSimpleActionPerformed

    private void sMultipleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMultipleActionPerformed
        if(sMultiple.isSelected()){
            panel.selectedforms.clear();
            JOptionPane.showMessageDialog(null, "Desmarca el botón para dejar de seleccionar y modificar");
            sSimple.setSelected(false);
            sSimple.setEnabled(false);
            sDoble.setSelected(false);
            sDoble.setEnabled(false);
            panel.modoSeleccion = PaintPanel.MULTIPLE;
        }
        else{
            JOptionPane.showMessageDialog(null, "Tiempo de selección agotado");
            panel.estado = PaintPanel.MODIFICANDO;
            panel.modoSeleccion = PaintPanel.NONE;
            sSimple.setEnabled(false);
            sMultiple.setEnabled(false);
            StrokeToggleB.setEnabled(true);
            TransformToggleB.setEnabled(true);
            BotonBorrar.setEnabled(true);
        }
    }//GEN-LAST:event_sMultipleActionPerformed

    private void opcionesStrokeGolbalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionesStrokeGolbalActionPerformed
        String command = opcionesStrokeGolbal.getItemAt(opcionesStrokeGolbal.getSelectedIndex());
        if (null != command) switch (command) {
            case "Continuo":
                panel.StrokeGlobal = new BasicStroke(panel.grosorGlobal,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
                break;
            case "Punteado":
                panel.StrokeGlobal = new BasicStroke(panel.grosorGlobal,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_MITER,10.0f,new float[] {16.0f,20.0f},0.0f);
                break;        // TODO add your handling code here:
        }
    }//GEN-LAST:event_opcionesStrokeGolbalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        panel.grosorGlobal = 1;
        panel.colorContornoGlob = null;
        panel.colorFillGlob = null;
        panel.StrokeGlobal = null;
        labelColorCont.setForeground(Color.black);
        labelColorRell.setForeground(Color.black);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sDobleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sDobleActionPerformed
        if(sDoble.isSelected()){
            panel.selectedforms.clear();
            sMultiple.setSelected(false);
            sMultiple.setSelected(false);
            sDoble.setSelected(false);
            sDoble.setEnabled(false);
            panel.modoSeleccion = PaintPanel.DOBLE;
            panel.contDoble = 0;
        }
        else{
            panel.selectedforms.clear();
            panel.modoSeleccion = PaintPanel.NONE;
            panel.repaint();
        }
    }//GEN-LAST:event_sDobleActionPerformed

    private void BotonAbrirSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAbrirSesionActionPerformed
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".spd","spd");
        fc.setFileFilter(filtro);
        int seleccion = fc.showOpenDialog(this);
        if(seleccion == JFileChooser.APPROVE_OPTION){
            File arch = fc.getSelectedFile();
            try{
                FileInputStream arch2 = new FileInputStream(arch);
                ObjectInputStream os = new ObjectInputStream(arch2);
                ArrayList<FiguraSave> figs = (ArrayList<FiguraSave>)os.readObject();
                limpiar();
                panel.forms.clear();
                panel.selectedforms.clear();
                Figura nueva;
                Shape s;
                BasicStroke b;
                AffineTransform tr;
                for(FiguraSave f : figs){
                    b = new BasicStroke(f.grosor,f.cap,f.join,f.qtr,f.fl,f.last);
                    tr = new AffineTransform();
                    s = tr.createTransformedShape(f.getPath());
                    nueva = new Figura(s,b,f.getPath(),f.getContorno(),f.getRelleno(),f.getAlpha());
                    panel.forms.add(nueva);
                    s=null;
                    tr=null;
                    nueva = null;
                }
                panel.estado = PaintPanel.NONE;
                panel.repaint();
                panel.StrokeGlobal = PaintPanel.BS;
                os.close();
                arch2.close();
            }
            catch(IOException el){
                el.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PanelObjetos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_BotonAbrirSesionActionPerformed

    private void BotonGuardarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarSesionActionPerformed
        // TODO add your handling code here:
        if (panel.forms.size()!=0){
            ArrayList<FiguraSave> v = new ArrayList<FiguraSave>();
            float grosor;
            int cap;
            int join;
            float qtr;
            float[] fl;
            float last;
            Shape s;
            DescribePath d = new DescribePath();
            int i = 0;
            for (Figura f : panel.forms){
                AffineTransform at = new AffineTransform();
                grosor = f.getStroke().getLineWidth();
                cap = f.getStroke().getEndCap();
                join = f.getStroke().getLineJoin();
                qtr = f.getStroke().getMiterLimit();
                fl = f.getStroke().getDashArray();
                last = f.getStroke().getDashPhase();
                v.add(new FiguraSave(grosor,cap,join,qtr,fl,last,d.obtenerPath(f.getShape()),f.getContorno(),f.getRelleno(),f.getAlpha()));
            }
            a.ingresaVectorSesion(v);
            JOptionPane.showMessageDialog(null, "Guardado :D");
        }
        else{
            JOptionPane.showMessageDialog(null, "No existen figuras dentro del panel de dibujo");
        }
    }//GEN-LAST:event_BotonGuardarSesionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BotonAbrirSesion;
    static javax.swing.JButton BotonBorrar;
    private javax.swing.JButton BotonContorno;
    public javax.swing.JButton BotonGuardarSesion;
    private javax.swing.JButton BotonLimpiar;
    private javax.swing.JButton BotonRelleno;
    public static javax.swing.JLabel InfoCoordenadas;
    public javax.swing.JComboBox<String> ListaObjetos;
    public javax.swing.JComboBox<String> MisObjetos;
    public javax.swing.JPanel Panel2;
    public javax.swing.JPanel PanelObjetos;
    static javax.swing.JToggleButton SeleccToggleB;
    static javax.swing.JToggleButton StrokeToggleB;
    static javax.swing.JToggleButton TransformToggleB;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel labelColorCont;
    private javax.swing.JLabel labelColorRell;
    public javax.swing.JComboBox<String> opcion;
    public javax.swing.JComboBox<String> opcion1;
    private javax.swing.JComboBox<String> opcionesStrokeGolbal;
    javax.swing.JPanel panelButtonStroke;
    public javax.swing.JButton quitarSeleccion;
    static javax.swing.JToggleButton sDoble;
    static javax.swing.JToggleButton sMultiple;
    static javax.swing.JToggleButton sSimple;
    // End of variables declaration//GEN-END:variables
}

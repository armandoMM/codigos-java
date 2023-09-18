package proyecto3d;

import Classes.ArrayCubos;
import Classes.Atributos;
import Classes.Star;
import Classes.TestDodecahedron;
import Classes.TestPrimitivas;
import Classes.mesa;
import Classes.superficie3D;
import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JRootPane;

public class Principal extends javax.swing.JFrame {

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        setTitle("Proyecto 3D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(900, 700);		
        setLocationRelativeTo(null);		
        setVisible(true);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelInicio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        arreglo = new javax.swing.JMenu();
        cubos = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        primitivas = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        geometrias = new javax.swing.JMenuItem();
        sup = new javax.swing.JMenu();
        superficie = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        estrella = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        atributos = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        mesa = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelInicio.setBackground(new java.awt.Color(216, 175, 52));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setText("Elaborado por:");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("Proyecto Java 3D");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 0));
        jLabel3.setText("Armando Matias Montaño");

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));

        jLabel4.setBackground(new java.awt.Color(255, 204, 51));
        jLabel4.setFont(new java.awt.Font("Colonna MT", 1, 40)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(216, 175, 52));
        jLabel4.setText("Universidad Autónoma del Estado de México ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 0));
        jLabel5.setText("Facultad de Ingeniería");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 0));
        jLabel6.setText("Junio 2022");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 0));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Imagen2.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 0));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Imagen1.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 0));
        jLabel9.setText("Graficación");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IMG-20191202-WA0014.jpg"))); // NOI18N

        javax.swing.GroupLayout PanelInicioLayout = new javax.swing.GroupLayout(PanelInicio);
        PanelInicio.setLayout(PanelInicioLayout);
        PanelInicioLayout.setHorizontalGroup(
            PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(PanelInicioLayout.createSequentialGroup()
                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInicioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)))
                    .addGroup(PanelInicioLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7)
                        .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelInicioLayout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelInicioLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel5))
                                    .addGroup(PanelInicioLayout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(jLabel1))
                                    .addComponent(jLabel3)))
                            .addGroup(PanelInicioLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(38, 38, 38)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );
        PanelInicioLayout.setVerticalGroup(
            PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInicioLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(PanelInicioLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInicioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179))
                    .addGroup(PanelInicioLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel9)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        arreglo.setText("Arreglo");

        cubos.setText("Array cubos");
        cubos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cubosActionPerformed(evt);
            }
        });
        arreglo.add(cubos);

        jMenuBar1.add(arreglo);

        jMenu3.setText("Primitivas");

        primitivas.setText("TestPrimitivas");
        primitivas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primitivasActionPerformed(evt);
            }
        });
        jMenu3.add(primitivas);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Geometrías");

        geometrias.setText("Geometries");
        geometrias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geometriasActionPerformed(evt);
            }
        });
        jMenu4.add(geometrias);

        jMenuBar1.add(jMenu4);

        sup.setText("Superficie");

        superficie.setText("Superficie 3D");
        superficie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                superficieActionPerformed(evt);
            }
        });
        sup.add(superficie);

        jMenuBar1.add(sup);

        jMenu6.setText("Figura");

        estrella.setText("Estrella");
        estrella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estrellaActionPerformed(evt);
            }
        });
        jMenu6.add(estrella);

        jMenuBar1.add(jMenu6);

        jMenu8.setText("Atributos");

        atributos.setText("Atributos");
        atributos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atributosActionPerformed(evt);
            }
        });
        jMenu8.add(atributos);

        jMenuBar1.add(jMenu8);

        jMenu9.setText("Picking");

        mesa.setText("Mesa");
        mesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesaActionPerformed(evt);
            }
        });
        jMenu9.add(mesa);

        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cubosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cubosActionPerformed
        JApplet cubos = new ArrayCubos();
        cubos.init();
        cubos.start();
        this.PanelInicio.removeAll();
        JInternalFrame interno = new JInternalFrame();
        JInternalFrame frame = new JInternalFrame("frame", false, false, false, false);
        interno.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        interno.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        interno.setContentPane(cubos);
        interno.show();
        interno.setSize(900, 700);
        this.PanelInicio.setSize(900, 700);
        this.PanelInicio.add(interno);
        this.setSize(interno.getWidth()+15, interno.getHeight()+60);
    }//GEN-LAST:event_cubosActionPerformed

    private void primitivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primitivasActionPerformed
        Applet primitivas = new TestPrimitivas();
        primitivas.init();
        primitivas.start();
        this.PanelInicio.removeAll();
        JInternalFrame interno = new JInternalFrame();
        JInternalFrame frame = new JInternalFrame("frame", false, false, false, false);
        interno.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        interno.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        interno.setContentPane(primitivas);
        interno.show();
        interno.setSize(900, 700);
        this.PanelInicio.setSize(900, 700);
        this.PanelInicio.add(interno);
        this.setSize(interno.getWidth()+15, interno.getHeight()+60);
    }//GEN-LAST:event_primitivasActionPerformed

    private void geometriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geometriasActionPerformed
        TestDodecahedron geometrias = new TestDodecahedron();
        geometrias.init();
        geometrias.start();
        this.PanelInicio.removeAll();
        JInternalFrame interno = new JInternalFrame();
        JInternalFrame frame = new JInternalFrame("frame", false, false, false, false);
        interno.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        interno.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        interno.setContentPane(geometrias);
        interno.show();
        interno.setSize(900, 700);
        this.PanelInicio.setSize(900, 700);
        this.PanelInicio.add(interno);
        this.setSize(interno.getWidth()+15, interno.getHeight()+60);
    }//GEN-LAST:event_geometriasActionPerformed

    private void superficieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_superficieActionPerformed
        superficie3D superficie = new superficie3D();
        superficie.init();
        superficie.start();
        this.PanelInicio.removeAll();
        JInternalFrame interno = new JInternalFrame();
        JInternalFrame frame = new JInternalFrame("frame", false, false, false, false);
        interno.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        interno.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        interno.setContentPane(superficie);
        interno.show();
        interno.setSize(900, 700);
        this.PanelInicio.setSize(900, 700);
        this.PanelInicio.add(interno);
        this.setSize(interno.getWidth()+15, interno.getHeight()+60);
    }//GEN-LAST:event_superficieActionPerformed

    private void estrellaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estrellaActionPerformed
        Star estrella = new Star();
        estrella.init();
        estrella.start();
        this.PanelInicio.removeAll();
        JInternalFrame interno = new JInternalFrame();
        JInternalFrame frame = new JInternalFrame("frame", false, false, false, false);
        interno.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        interno.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        interno.setContentPane(estrella);
        interno.show();
        interno.setSize(900, 700);
        this.PanelInicio.setSize(900, 700);
        this.PanelInicio.add(interno);
        this.setSize(interno.getWidth()+15, interno.getHeight()+60);
    }//GEN-LAST:event_estrellaActionPerformed

    private void atributosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atributosActionPerformed
        Atributos at= new Atributos();
        at.init();
        at.start();
        this.PanelInicio.removeAll();
        JInternalFrame interno = new JInternalFrame();
        JInternalFrame frame = new JInternalFrame("frame", false, false, false, false);
        interno.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        interno.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        interno.setContentPane(at);
        interno.show();
        interno.setSize(900, 700);
        this.PanelInicio.setSize(900, 700);
        this.PanelInicio.add(interno);
        this.setSize(interno.getWidth()+15, interno.getHeight()+60);
    }//GEN-LAST:event_atributosActionPerformed

    private void mesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesaActionPerformed
        mesa m= new mesa();
        m.init();
        m.start();
        this.PanelInicio.removeAll();
        JInternalFrame interno = new JInternalFrame();
        JInternalFrame frame = new JInternalFrame("frame", false, false, false, false);
        interno.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        interno.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        interno.setContentPane(m);
        interno.show();
        interno.setSize(900, 700);
        this.PanelInicio.setSize(900, 700);
        this.PanelInicio.add(interno);
        this.setSize(interno.getWidth()+15, interno.getHeight()+60);
    }//GEN-LAST:event_mesaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelInicio;
    private javax.swing.JMenu arreglo;
    private javax.swing.JMenuItem atributos;
    private javax.swing.JMenuItem cubos;
    private javax.swing.JMenuItem estrella;
    private javax.swing.JMenuItem geometrias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem mesa;
    private javax.swing.JMenuItem primitivas;
    private javax.swing.JMenu sup;
    private javax.swing.JMenuItem superficie;
    // End of variables declaration//GEN-END:variables
}

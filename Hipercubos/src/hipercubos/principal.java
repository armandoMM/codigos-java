/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercubos;
import java.util.Scanner;
import java.awt.*;
import javax.swing.JOptionPane;

/**
 *
 * @author IvónLs
 */
public class principal extends javax.swing.JFrame {

    /**
     * Creates new form principal
     */
    private Graphics cubo;
    Scanner sc=new Scanner(System.in);
    private rutas rutS=new rutas();
    private boolean ban=false;
    private String resultado="";
    public principal() {
        initComponents();
    }

    @Override
    public void paint(Graphics cubo){
        super.paint(cubo);
        cubo.setColor(new Color(166,173,168));
        /*Arcos 1, 2, 3, 4*/
        cubo.drawArc(120, 70, 300, 100, 0, 180);
        cubo.drawArc(220, 70, 300, 100, 0, 180);
        cubo.drawArc(170, 120, 300, 100, 0, 180);
        cubo.drawArc(270, 120, 300, 100, 0, 180);
        /*Arcos 5, 6, 7, 8*/
        cubo.drawArc(120, 170, 300, 100, 180, 180);
        cubo.drawArc(220, 170, 300, 100, 180, 180);
        cubo.drawArc(170, 220, 300, 100, 180, 180);
        cubo.drawArc(270, 220, 300, 100, 180, 180);
    /*------------CUBO 1------------------*/
        cubo.setColor(Color.black);
        /*Aristas horizontales cubo 1*/
        cubo.drawLine(120,120,220,120);//1-2
        cubo.drawLine(120,220,220,220);//5-6
        cubo.drawLine(170,170,270,170);//3-4
        cubo.drawLine(170,270,270,270);//7-8
        /*Aristas verticalez cubo 1*/
        cubo.drawLine(120, 120, 120, 220);//1 - 5
        cubo.drawLine(220, 120, 220, 220);//2 - 6
        cubo.drawLine(170, 170, 170, 270);//3 - 7
        cubo.drawLine(270, 170, 270, 270);//4 - 8
        /*Aristas faltantes cubo 1*/
        cubo.drawLine(120, 120, 170, 170);//1 - 3
        cubo.drawLine(220, 120, 270, 170);//2 - 4
        cubo.drawLine(220, 220, 270, 270);//2 - 8
        cubo.drawLine(120, 220, 170, 270);//5 - 7
       /*Nodos para cubo 1*/
        cubo.fillOval(115, 115, 8, 8);//1
        cubo.fillOval(215, 115, 8, 8);//2
        cubo.fillOval(165, 165, 8, 8);//3
        cubo.fillOval(265, 165, 8, 8);//4
        cubo.fillOval(115, 215, 8, 8);//5
        cubo.fillOval(215, 215, 8, 8);//6
        cubo.fillOval(265, 265, 8, 8);//7
        cubo.fillOval(165, 265, 8, 8);//8
    /*------------CUBO 2------------------*/
        /*Aristas horizontales para el cubo 2*/
        cubo.drawLine(420, 120, 520, 120);//9 - 10
        cubo.drawLine(420, 220, 520, 220);//13 - 14
        cubo.drawLine(470, 175, 570, 175);//11 - 12
        cubo.drawLine(470, 275, 570, 275);//15 - 16
        /*Aristas veticales para cubo 2*/
        cubo.drawLine(420, 120, 420, 220);//9 - 13
        cubo.drawLine(520, 120, 520, 220);//10 - 14
        cubo.drawLine(470, 175, 470, 275);//11 - 15
        cubo.drawLine(570, 175, 570, 275);//12 - 16
        /*Aristas faltantes cubo 2*/
        cubo.drawLine(420, 120, 470, 175);//9 - 11
        cubo.drawLine(520, 120, 570, 175);//10 - 12
        cubo.drawLine(420, 220, 470, 275);//13 - 15
        cubo.drawLine(520, 220, 570, 275);//14 - 16
        /*Nodos para el cubo 2*/
        cubo.fillOval(415, 115, 8, 8);//9
        cubo.fillOval(515, 115, 8, 8);//10
        cubo.fillOval(467, 167, 8, 8);//11
        cubo.fillOval(567, 167, 8, 8);//12
        cubo.fillOval(415, 215, 8, 8);//13
        cubo.fillOval(515, 215, 8, 8);//14
        cubo.fillOval(467, 267, 8, 8);//15
        cubo.fillOval(567, 267, 8, 8);//16
    /*NOMBRE PARA LOS NODOS*/
        cubo.setColor(new Color(1,59,15));
        cubo.setFont(new Font("Haettenschweiler", Font.PLAIN, 20));
        cubo.drawString("1", 100, 110);
        cubo.drawString("2", 200, 110);
        cubo.drawString("3", 175, 160);
        cubo.drawString("4", 275, 160);
        cubo.drawString("5", 100, 210);
        cubo.drawString("6", 200, 210);
        cubo.drawString("7", 175, 260);
        cubo.drawString("8", 275, 260);
        cubo.drawString("9", 400, 110);
        cubo.drawString("10", 500, 110);
        cubo.drawString("11", 475, 160);
        cubo.drawString("12", 575, 160);
        cubo.drawString("13", 400, 210);
        cubo.drawString("14", 500, 210);
        cubo.drawString("15", 475, 260);
        cubo.drawString("16", 575, 260);
        
        /*DIBUJANDO RUTA*/
        if(ban){
            if(Hipercubos.emi==Hipercubos.rec){
                rutaRes.setText("No hay ruta para tu elección");
            }else{
                int m3=Hipercubos.emi+1;
                resultado="{"+m3;
                rutS.CalcularRuta();
                int []aux=rutS.getaux();
                int x1 = Hipercubos.nodo[Hipercubos.emi][0];
                int y1 = Hipercubos.nodo[Hipercubos.emi][1];
                int x2,y2, num=Hipercubos.emi;
                for(int j=0;j<3;j++){
                    if (aux[j] != 0) {
                        cubo.setColor(Color.red);
                        x2 = inicio(j, num);
                        y2 = fin(j, num);
                        num = nuevo(j, num);
                        int m = num+1;
                        resultado = resultado + ", " + m;
                        cubo.drawLine(x1, y1, x2, y2);
                        x1 = x2;
                        y1 = y2;
                    }
                }
                if (aux[3] != 0) {
                    cubo.setColor(Color.red);
                    if (num == 0 || num == 1 || num == 2 || num == 3 || num == 8 || num == 9 || num == 10 || num == 11) {
                        if (num < 8) {
                            cubo.drawArc(x1, (y1 - 50), 300, 100, 0, 180);//4
                        } else {
                            cubo.drawArc((x1 - 120), (y1 - 50), 300, 100, 0, 180);//4   
                        }

                    } else {
                        if (num < 8) {
                            cubo.drawArc(x1, (y1 - 50), 300, 100, 180, 180);//8   
                        } else {
                            cubo.drawArc((x1 - 120), (y1 - 50), 300, 100, 180, 180);//8     
                        }
                    }
                    int m2=Hipercubos.rec+1;
                    resultado = resultado + ", " + m2;
                }
                rutaRes.setText(resultado + "}");
            }
        }
    }
    /*funciones para agregar los nodos a la ruta*/
    private int inicio(int val, int num) 
    {
        int numero = 0;
        if (val == 0) {
            numero = Hipercubos.nodo[Hipercubos.nodo[num][3]][0];

        }
        if (val == 1) {
            numero = Hipercubos.nodo[Hipercubos.nodo[num][2]][0];
        }
        if (val == 2) {
            numero = Hipercubos.nodo[Hipercubos.nodo[num][4]][0];
        }
        return numero;
    }

    private int fin(int val, int num) 
    {
        int numero = 0;
        if (val == 0) {
            numero = Hipercubos.nodo[Hipercubos.nodo[num][3]][1];
        }
        if (val == 1) {
            numero = Hipercubos.nodo[Hipercubos.nodo[num][2]][1];
        }
        if (val == 2) {
            numero = Hipercubos.nodo[Hipercubos.nodo[num][4]][1];
        }
        return numero;
    }

    private int nuevo(int val, int num) 
    {
        if (val == 0) {
            return Hipercubos.nodo[num][3];
        }
        if (val == 1) {
            return Hipercubos.nodo[num][2];
        }
        if (val == 2) {
            return Hipercubos.nodo[num][4];
        }
        return 0;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        emisor = new javax.swing.JComboBox<>();
        receptor = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        calcular = new javax.swing.JButton();
        rutaRes = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setName("menu"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Heavy Data", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Hipercubo");

        jLabel2.setBackground(new java.awt.Color(0, 0, 204));
        jLabel2.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 10)); // NOI18N
        jLabel2.setText("Elaborado por:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel3.setText("Ivón López Sánchez");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel4.setText("Armando Matías Montaño");

        emisor.setFont(new java.awt.Font("Dubai Light", 1, 12)); // NOI18N
        emisor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Nodo 1", "Nodo 2", "Nodo 3", "Nodo 4", "Nodo 5", "Nodo 6", "Nodo 7", "Nodo 8", " " }));
        emisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emisorActionPerformed(evt);
            }
        });

        receptor.setFont(new java.awt.Font("Dubai Light", 1, 12)); // NOI18N
        receptor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Nodo 9", "Nodo 10", "Nodo 11", "Nodo 12", "Nodo 13", "Nodo 14", "Nodo 15", "Nodo 16" }));
        receptor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receptorActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 51, 0));
        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 0));
        jLabel5.setText("Emisor");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("Receptor");

        calcular.setBackground(new java.awt.Color(204, 204, 255));
        calcular.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        calcular.setForeground(new java.awt.Color(153, 0, 0));
        calcular.setText("Calcular");
        calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularActionPerformed(evt);
            }
        });

        rutaRes.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        rutaRes.setForeground(new java.awt.Color(0, 0, 153));

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("Ruta  localizada:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(emisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(receptor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rutaRes, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(666, 666, 666)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jLabel1)
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(emisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(receptor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(calcular)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rutaRes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emisorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emisorActionPerformed

    private void receptorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receptorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receptorActionPerformed

    private void calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularActionPerformed
        ban = true;
        if (emisor.getSelectedItem() == " ") {
            JOptionPane.showMessageDialog(null, "Seleccione un Nodo de Emisor");
            ban = false;
        } else if (emisor.getSelectedItem() == "Nodo 1"){
            Hipercubos.emi = 0;
            if (receptor.getSelectedItem() == " ") {
                JOptionPane.showMessageDialog(null, "Seleccione un Nodo de Receptor");
                ban = false;
            } else if (receptor.getSelectedItem() == "Nodo 9"){
                Hipercubos.rec = 8;
            } else if (receptor.getSelectedItem() == "Nodo 10"){
                Hipercubos.rec = 9;
            } else if (receptor.getSelectedItem() == "Nodo 11"){
                Hipercubos.rec = 10;
            } else if (receptor.getSelectedItem() == "Nodo 12"){
                Hipercubos.rec = 11;
            } else if (receptor.getSelectedItem() == "Nodo 13"){
                Hipercubos.rec = 12;
            } else if (receptor.getSelectedItem() == "Nodo 14"){
                Hipercubos.rec = 13; 
            } else if (receptor.getSelectedItem() == "Nodo 15"){
                Hipercubos.rec = 14;
            } else if (receptor.getSelectedItem() == "Nodo 16"){
                Hipercubos.rec = 15;
            }
        }else if (emisor.getSelectedItem() == "Nodo 2"){
            Hipercubos.emi = 1;
            if (receptor.getSelectedItem() == " ") {
                JOptionPane.showMessageDialog(null, "Seleccione un Nodo de Receptor");
                ban = false;
            } else if (receptor.getSelectedItem() == "Nodo 9"){
                Hipercubos.rec = 8;
            } else if (receptor.getSelectedItem() == "Nodo 10"){
                Hipercubos.rec = 9;
            } else if (receptor.getSelectedItem() == "Nodo 11"){
                Hipercubos.rec = 10;
            } else if (receptor.getSelectedItem() == "Nodo 12"){
                Hipercubos.rec = 11;
            } else if (receptor.getSelectedItem() == "Nodo 13"){
                Hipercubos.rec = 12;
            } else if (receptor.getSelectedItem() == "Nodo 14"){
                Hipercubos.rec = 13; 
            } else if (receptor.getSelectedItem() == "Nodo 15"){
                Hipercubos.rec = 14;
            } else if (receptor.getSelectedItem() == "Nodo 16"){
                Hipercubos.rec = 15;
            }
        }else if (emisor.getSelectedItem() == "Nodo 3"){
            Hipercubos.emi = 2;
            if (receptor.getSelectedItem() == " ") {
                JOptionPane.showMessageDialog(null, "Seleccione un Nodo de Receptor");
                ban = false;
            } else if (receptor.getSelectedItem() == "Nodo 9"){
                Hipercubos.rec = 8;
            } else if (receptor.getSelectedItem() == "Nodo 10"){
                Hipercubos.rec = 9;
            } else if (receptor.getSelectedItem() == "Nodo 11"){
                Hipercubos.rec = 10;
            } else if (receptor.getSelectedItem() == "Nodo 12"){
                Hipercubos.rec = 11;
            } else if (receptor.getSelectedItem() == "Nodo 13"){
                Hipercubos.rec = 12;
            } else if (receptor.getSelectedItem() == "Nodo 14"){
                Hipercubos.rec = 13; 
            } else if (receptor.getSelectedItem() == "Nodo 15"){
                Hipercubos.rec = 14;
            } else if (receptor.getSelectedItem() == "Nodo 16"){
                Hipercubos.rec = 15;
            }
        }else if (emisor.getSelectedItem() == "Nodo 4"){
            Hipercubos.emi = 3;
            if (receptor.getSelectedItem() == " ") {
                JOptionPane.showMessageDialog(null, "Seleccione un Nodo de Receptor");
                ban = false;
            } else if (receptor.getSelectedItem() == "Nodo 9"){
                Hipercubos.rec = 8;
            } else if (receptor.getSelectedItem() == "Nodo 10"){
                Hipercubos.rec = 9;
            } else if (receptor.getSelectedItem() == "Nodo 11"){
                Hipercubos.rec = 10;
            } else if (receptor.getSelectedItem() == "Nodo 12"){
                Hipercubos.rec = 11;
            } else if (receptor.getSelectedItem() == "Nodo 13"){
                Hipercubos.rec = 12;
            } else if (receptor.getSelectedItem() == "Nodo 14"){
                Hipercubos.rec = 13; 
            } else if (receptor.getSelectedItem() == "Nodo 15"){
                Hipercubos.rec = 14;
            } else if (receptor.getSelectedItem() == "Nodo 16"){
                Hipercubos.rec = 15;
            }
        }else if (emisor.getSelectedItem() == "Nodo 5"){
            Hipercubos.emi = 4;
            if (receptor.getSelectedItem() == " ") {
                JOptionPane.showMessageDialog(null, "Seleccione un Nodo de Receptor");
                ban = false;
            } else if (receptor.getSelectedItem() == "Nodo 9"){
                Hipercubos.rec = 8;
            } else if (receptor.getSelectedItem() == "Nodo 10"){
                Hipercubos.rec = 9;
            } else if (receptor.getSelectedItem() == "Nodo 11"){
                Hipercubos.rec = 10;
            } else if (receptor.getSelectedItem() == "Nodo 12"){
                Hipercubos.rec = 11;
            } else if (receptor.getSelectedItem() == "Nodo 13"){
                Hipercubos.rec = 12;
            } else if (receptor.getSelectedItem() == "Nodo 14"){
                Hipercubos.rec = 13; 
            } else if (receptor.getSelectedItem() == "Nodo 15"){
                Hipercubos.rec = 14;
            } else if (receptor.getSelectedItem() == "Nodo 16"){
                Hipercubos.rec = 15;
            }
        }else if (emisor.getSelectedItem() == "Nodo 6"){
            Hipercubos.emi = 5;
            if (receptor.getSelectedItem() == " ") {
                JOptionPane.showMessageDialog(null, "Seleccione un Nodo de Receptor");
                ban = false;
            } else if (receptor.getSelectedItem() == "Nodo 9"){
                Hipercubos.rec = 8;
            } else if (receptor.getSelectedItem() == "Nodo 10"){
                Hipercubos.rec = 9;
            } else if (receptor.getSelectedItem() == "Nodo 11"){
                Hipercubos.rec = 10;
            } else if (receptor.getSelectedItem() == "Nodo 12"){
                Hipercubos.rec = 11;
            } else if (receptor.getSelectedItem() == "Nodo 13"){
                Hipercubos.rec = 12;
            } else if (receptor.getSelectedItem() == "Nodo 14"){
                Hipercubos.rec = 13; 
            } else if (receptor.getSelectedItem() == "Nodo 15"){
                Hipercubos.rec = 14;
            } else if (receptor.getSelectedItem() == "Nodo 16"){
                Hipercubos.rec = 15;
            }
        }else if (emisor.getSelectedItem() == "Nodo 7"){
            Hipercubos.emi = 6;
            if (receptor.getSelectedItem() == " ") {
                JOptionPane.showMessageDialog(null, "Seleccione un Nodo de Receptor");
                ban = false;
            } else if (receptor.getSelectedItem() == "Nodo 9"){
                Hipercubos.rec = 8;
            } else if (receptor.getSelectedItem() == "Nodo 10"){
                Hipercubos.rec = 9;
            } else if (receptor.getSelectedItem() == "Nodo 11"){
                Hipercubos.rec = 10;
            } else if (receptor.getSelectedItem() == "Nodo 12"){
                Hipercubos.rec = 11;
            } else if (receptor.getSelectedItem() == "Nodo 13"){
                Hipercubos.rec = 12;
            } else if (receptor.getSelectedItem() == "Nodo 14"){
                Hipercubos.rec = 13; 
            } else if (receptor.getSelectedItem() == "Nodo 15"){
                Hipercubos.rec = 14;
            } else if (receptor.getSelectedItem() == "Nodo 16"){
                Hipercubos.rec = 15;
            }
        }else if (emisor.getSelectedItem() == "Nodo 8"){
            Hipercubos.emi = 7;
            if (receptor.getSelectedItem() == " ") {
                JOptionPane.showMessageDialog(null, "Seleccione un Nodo de Receptor");
                ban = false;
            } else if (receptor.getSelectedItem() == "Nodo 9"){
                Hipercubos.rec = 8;
            } else if (receptor.getSelectedItem() == "Nodo 10"){
                Hipercubos.rec = 9;
            } else if (receptor.getSelectedItem() == "Nodo 11"){
                Hipercubos.rec = 10;
            } else if (receptor.getSelectedItem() == "Nodo 12"){
                Hipercubos.rec = 11;
            } else if (receptor.getSelectedItem() == "Nodo 13"){
                Hipercubos.rec = 12;
            } else if (receptor.getSelectedItem() == "Nodo 14"){
                Hipercubos.rec = 13; 
            } else if (receptor.getSelectedItem() == "Nodo 15"){
                Hipercubos.rec = 14;
            } else if (receptor.getSelectedItem() == "Nodo 16"){
                Hipercubos.rec = 15;
            }
        }
        repaint();
    }//GEN-LAST:event_calcularActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calcular;
    private javax.swing.JComboBox<String> emisor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox<String> receptor;
    private javax.swing.JLabel rutaRes;
    // End of variables declaration//GEN-END:variables
}

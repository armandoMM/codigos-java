package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

/**
 * @author yeckz
 */
public class Frame1 extends javax.swing.JFrame implements ActionListener{  
    List <List<String>> listDocMain = new ArrayList<List<String>>();
    List <List<String>> listDocClean = new ArrayList<List<String>>();
    List <List<String>> listAnalized = new ArrayList<List<String>>();
    String reservSimbolos[] = {"data segment","code segment","stack segment",
        "byte ptr","word","dw","db","ends2","mov","ah","dl2","ret","int","cmp",
        "jz","jng","add","jmp","ax","ds","dx","offset","model small"};
    String pseudo[] = {"data segment","code segment","stack segment","model small",
			"byte ptr","word ptr","ends","@data"};
    String inst[] = {"ass","cmpsw","nop","stosb","lea","pop2","cmp","shl","jge",
        "jnbe","jno","loopz"};
    String regs[] = {"ax","bx","cx","dx","ah","bh","ch","dh","al","bl","cl","dl"};
    char numdec [] = {'0','1','2','3','4','5','6','7','8','9'};
    char numhex[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    int iterListDM,iterListDC,iterAn;
    File fileSlctd;
    FileReader fr;
    BufferedReader br;
    
    public Frame1() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        SelectBTN.addActionListener(this);
        AnalizarBTN.addActionListener(this);
        prevBTN.addActionListener(this);
        nextBTN.addActionListener(this);
        prevBTN2.addActionListener(this);
        nextBTN2.addActionListener(this);
        prevBTN3.addActionListener(this);
        nextBTN3.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaArchOriginal = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        AreaArchClean = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        AreaArchAnalized = new javax.swing.JTextArea();
        prevBTN = new javax.swing.JButton();
        nextBTN = new javax.swing.JButton();
        prevBTN2 = new javax.swing.JButton();
        nextBTN2 = new javax.swing.JButton();
        prevBTN3 = new javax.swing.JButton();
        nextBTN3 = new javax.swing.JButton();
        AnalizarBTN = new javax.swing.JButton();
        SelectBTN = new javax.swing.JButton();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(130, 158, 129));
        setResizable(false);

        AreaArchOriginal.setEditable(false);
        AreaArchOriginal.setColumns(20);
        AreaArchOriginal.setRows(5);
        jScrollPane1.setViewportView(AreaArchOriginal);

        javax.swing.GroupLayout contenedor1Layout = new javax.swing.GroupLayout(contenedor1);
        contenedor1.setLayout(contenedor1Layout);
        contenedor1Layout.setHorizontalGroup(
            contenedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
        );
        contenedor1Layout.setVerticalGroup(
            contenedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
        );

        AreaArchClean.setEditable(false);
        AreaArchClean.setColumns(20);
        AreaArchClean.setRows(5);
        jScrollPane2.setViewportView(AreaArchClean);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        AreaArchAnalized.setEditable(false);
        AreaArchAnalized.setColumns(20);
        AreaArchAnalized.setRows(5);
        jScrollPane3.setViewportView(AreaArchAnalized);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        prevBTN.setText("anterior");
        prevBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevBTNActionPerformed(evt);
            }
        });

        nextBTN.setText("siguiente");
        nextBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBTNActionPerformed(evt);
            }
        });

        prevBTN2.setText("anterior");
        prevBTN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevBTN2ActionPerformed(evt);
            }
        });

        nextBTN2.setText("siguiente");
        nextBTN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBTN2ActionPerformed(evt);
            }
        });

        prevBTN3.setText("anterior");
        prevBTN3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevBTN3ActionPerformed(evt);
            }
        });

        nextBTN3.setText("siguiente");
        nextBTN3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBTN3ActionPerformed(evt);
            }
        });

        AnalizarBTN.setText("Analizar texto");
        AnalizarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalizarBTNActionPerformed(evt);
            }
        });

        SelectBTN.setText("Seleccionar archivo");
        SelectBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectBTNActionPerformed(evt);
            }
        });

        label1.setText("Archivo Original");

        label2.setText("Archivo Limpio");

        label3.setText("Archivo Analizado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contenedor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(prevBTN)
                        .addGap(18, 18, 18)
                        .addComponent(nextBTN)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(prevBTN2)
                        .addGap(18, 18, 18)
                        .addComponent(nextBTN2))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(prevBTN3)
                        .addGap(18, 18, 18)
                        .addComponent(nextBTN3)))
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelectBTN))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(AnalizarBTN)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelectBTN)
                    .addComponent(AnalizarBTN))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contenedor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prevBTN)
                            .addComponent(nextBTN)
                            .addComponent(prevBTN2)
                            .addComponent(nextBTN2)
                            .addComponent(prevBTN3)
                            .addComponent(nextBTN3))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void nextBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBTNActionPerformed
        try{
            if(iterListDM>=0 && iterListDM<(listDocMain.size()-1)){
                iterListDM++;
                AreaArchOriginal.setText("");
                for(int j=0;j<20;j++){
                    AreaArchOriginal.append(listDocMain.get(iterListDM).get(j));
                    AreaArchOriginal.append(System.getProperty("line.separator"));
                }
            }else{
               iterListDM=listDocMain.size()-1;
               AreaArchOriginal.setText("");
                for(int j=0;j<20;j++){
                    AreaArchOriginal.append(listDocMain.get(iterListDM).get(j));
                    AreaArchOriginal.append(System.getProperty("line.separator"));
                }
            }
        }catch(IndexOutOfBoundsException err){
        }
        
    }//GEN-LAST:event_nextBTNActionPerformed

    private void prevBTN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevBTN2ActionPerformed
        try{
            if(iterListDC!=0 && iterListDC<=(listDocClean.size()-1)){
                iterListDC--;
                AreaArchClean.setText("");
                for(int j=0;j<20;j++){
                    AreaArchClean.append(listDocClean.get(iterListDC).get(j));
                    AreaArchClean.append(System.getProperty("line.separator"));
                }
            }else{
                iterListDC=0;
                AreaArchClean.setText("");
                for(int j=0;j<20;j++){
                    AreaArchClean.append(listDocClean.get(iterListDC).get(j));
                    AreaArchClean.append(System.getProperty("line.separator"));
                }
            }
        }catch(IndexOutOfBoundsException err){
        }
    }//GEN-LAST:event_prevBTN2ActionPerformed

    private void nextBTN3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBTN3ActionPerformed
        try{
            if(iterAn>=0 && iterAn<(listAnalized.size()-1)){
                iterAn++;
                AreaArchAnalized.setText("");
                for(int j=0;j<20;j++){
                    AreaArchAnalized.append(listAnalized.get(iterAn).get(j));
                    AreaArchAnalized.append(System.getProperty("line.separator"));
                }
            }else{
               iterAn=listAnalized.size()-1;
               AreaArchAnalized.setText("");
                for(int j=0;j<20;j++){
                    AreaArchAnalized.append(listAnalized.get(iterAn).get(j));
                    AreaArchAnalized.append(System.getProperty("line.separator"));
                }
            }
        }catch(IndexOutOfBoundsException err){
        }
    }//GEN-LAST:event_nextBTN3ActionPerformed

    private void SelectBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectBTNActionPerformed
        JFileChooser fileC = new JFileChooser();
        fileC.showOpenDialog(this);
        fileSlctd = fileC.getSelectedFile();
        listDocMain.clear();
        if(fileSlctd != null){
            try{
                //ABRIENDO EL ARCHIVO ORIGINAL
                fr = new FileReader(fileSlctd);
                br = new BufferedReader(fr);
                String line;
                int numLines=0;
                while((line=br.readLine())!=null){
                    if(numLines%20==0)
                        listDocMain.add(new ArrayList<String>());
                    numLines++;
                }
                fr = new FileReader(fileSlctd);
                br = new BufferedReader(fr);
                line=null;
                int k = 1;
                int k2=0;               
                line= br.readLine();
                while(line!=null){
                    listDocMain.get(k2).add(line);
                    if(k%20 == 0){
                        k2++;
                    }
                    line= br.readLine();
                    k++;
                }
                iterListDM=0;
                for(int j=0;j<20;j++){
                    AreaArchOriginal.append(listDocMain.get(iterListDM).get(j));
                    AreaArchOriginal.append(System.getProperty("line.separator"));
                }
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(Frame1.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }//GEN-LAST:event_SelectBTNActionPerformed

    private void prevBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevBTNActionPerformed
        try{
            if(iterListDM!=0 && iterListDM<=(listDocMain.size()-1)){
                iterListDM--;
                AreaArchOriginal.setText("");
                for(int j=0;j<20;j++){
                    AreaArchOriginal.append(listDocMain.get(iterListDM).get(j));
                    AreaArchOriginal.append(System.getProperty("line.separator"));
                }
            }else{
                iterListDM=0;
               AreaArchOriginal.setText("");
                for(int j=0;j<20;j++){
                    AreaArchOriginal.append(listDocMain.get(iterListDM).get(j));
                    AreaArchOriginal.append(System.getProperty("line.separator"));
                }
            }
        }catch(IndexOutOfBoundsException err){
        }
    }//GEN-LAST:event_prevBTNActionPerformed

    private void AnalizarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalizarBTNActionPerformed
        listDocClean.clear();
        String aux[] = null;
        List<List<String>> auxL = new ArrayList<List<String>>();
        int it = 0;
        if(fileSlctd!=null){
            try{
                //limpiando lista
                for(List<String> lines : listDocMain){
                    listDocClean.add(new ArrayList<String>());
                    String l[];
                    for(String line : lines){
                        if(line.matches(".*;.*")){
                            l=line.split(";");
                            l[l.length-1] = "";
                            line = l[0];
                            //for(int i=0; i<l.length;i++)System.out.println(i+" "+l[i]);
                        }
                        if(line.matches("[\t\n\f\r].*")){
                            l=line.split("[\t\n\r\f]");
                            line=l[l.length-1];  
                        }
                        line = line.trim();
                        if(line.matches("[a-zA-Z0-9]+,[ a-z-A-Z0-9]+") | line.matches("[a-zA-Z0-9]+,")){
                            l=line.split(",");
                            for(int k = 0;k<l.length;k++){
                                listDocClean.get(it).add(l[k]);
                            }
                        }else{
                            listDocClean.get(it).add(line);
                        }
                    }
                    it++;
                }
                //vaciando lista limpia
                iterListDC=0;
                AreaArchClean.setText("");
                for(int j=0;j<20;j++){
                    AreaArchClean.append(listDocClean.get(iterListDC).get(j));
                    AreaArchClean.append(System.getProperty("line.separator"));
                }
                Analizer();
            }catch(IndexOutOfBoundsException err){}
        }
        
    }//GEN-LAST:event_AnalizarBTNActionPerformed

    private void nextBTN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBTN2ActionPerformed
        try{
            if(iterListDC>=0 && iterListDC<(listDocClean.size()-1)){
                iterListDC++;
                AreaArchClean.setText("");
                for(int i=0; i<20;i++){
                    AreaArchClean.append(listDocClean.get(iterListDC).get(i));
                    AreaArchClean.append(System.getProperty("line.separator"));
                }
            }else{
                iterListDC=listDocClean.size()-1;
                AreaArchClean.setText("");
                for(int j=0;j<20;j++){
                    AreaArchClean.append(listDocClean.get(iterListDC).get(j));
                    AreaArchClean.append(System.getProperty("line.separator"));
                }
            }
        }catch(IndexOutOfBoundsException err){
        }
    }//GEN-LAST:event_nextBTN2ActionPerformed

    private void prevBTN3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevBTN3ActionPerformed
        try{
            if(iterAn!=0 && iterAn<=(listAnalized.size()-1)){
                iterAn--;
                AreaArchAnalized.setText("");
                for(int j=0;j<20;j++){
                    AreaArchAnalized.append(listAnalized.get(iterAn).get(j));
                    AreaArchAnalized.append(System.getProperty("line.separator"));
                }
            }else{
                iterAn=0;
                AreaArchAnalized.setText("");
                for(int j=0;j<20;j++){
                    AreaArchAnalized.append(listAnalized.get(iterAn).get(j));
                    AreaArchAnalized.append(System.getProperty("line.separator"));
                }
            }
        }catch(IndexOutOfBoundsException err){
        }
    }//GEN-LAST:event_prevBTN3ActionPerformed

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
            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnalizarBTN;
    private javax.swing.JTextArea AreaArchAnalized;
    private javax.swing.JTextArea AreaArchClean;
    private javax.swing.JTextArea AreaArchOriginal;
    private javax.swing.JButton SelectBTN;
    private javax.swing.JPanel contenedor1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private javax.swing.JButton nextBTN;
    private javax.swing.JButton nextBTN2;
    private javax.swing.JButton nextBTN3;
    private javax.swing.JButton prevBTN;
    private javax.swing.JButton prevBTN2;
    private javax.swing.JButton prevBTN3;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO add your handling code here:
    }
    
    public void Analizer(){
        int it=0;
        boolean reserv=false;
        String l[]=null;
        for(List<String> lines:listDocClean){
            listAnalized.add(new ArrayList<String>());
            for(String line : lines){
                if(!line.matches("")){
                    if(line.matches("stack segment") | line.matches("code segment") | line.matches("data segment") | line.matches("model segment") | line.matches("byte segment") | line.matches("word segment")){
                        line=line+"\t~Pseudoinstrucción~";
                        listAnalized.get(it).add(line);
                        continue;
                    }
                    l = line.split(" ");
                    for(int i=0; i<l.length;i++){
                        System.out.println(l[i]);
                        for(int j = 0; j<pseudo.length;j++){
                            if(l[i].equals( pseudo[j]) | l[i].equals( reservSimbolos[j])){
                                line = l[i]+"\t~Pseudoinstrucción~";
                                listAnalized.get(it).add(line);
                                reserv=true;
                                break;
                            }
                        }
                        for(int j=0;j<inst.length;j++){
                            if(l[i].equals(inst[j])){
                                line = l[i]+"\t+Instrucción+";
                                listAnalized.get(it).add(line);
                                break;
                            }
                        }
                        if(l[i].matches("[a-zA-Z0-9]+,")){
                            String m[]=l[i].split(",");
                            for(int j=0;j<regs.length;j++){
                                if(m[0].equals(regs[j])){
                                    line = m[0]+"\t*Registro*";
                                    listAnalized.get(it).add(line);
                                    break; 
                                }
                            }
                        }
                        for(int j =0;j<l.length;j++){
                            if(l[j].matches("[0-9]*")){
                                //System.out.println(m[j]);
                                line=l[j]+"\t<Constante numérico decimal>";
                                listAnalized.get(it).add(line);
                                continue;
                            }
                            if(l[j].matches("[0-9a-f|A-F]+") && reserv==false){
                                line=l[j]+"\t<Constante numérico hexadecimal>";
                                listAnalized.get(it).add(line);
                                continue;  
                            }
                        }
                    }
                    if(line.matches("[a-zA-Z]+[1-9]+")){
                        listAnalized.get(it).add(line+"\t<Símbolo>");   
                    }
                    //
                }
            }
            it++;
        }
        iterAn=0;
        AreaArchAnalized.setText("");
        for(int j=0;j<20;j++){
            AreaArchAnalized.append(listAnalized.get(iterAn).get(j));
            AreaArchAnalized.append(System.getProperty("line.separator"));
        }
    }
    
}


package proyecto2D;

import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;


public class Archivo {
    
    public boolean leeArch (String nomb){
        boolean band = true;
        try {
            FileInputStream arch = new FileInputStream(nomb);  
            ObjectInputStream os = new ObjectInputStream(arch);
            os.close();
            arch.close();
        }
        catch(FileNotFoundException e){
            
            band = false;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return band;
    }
    
    public void creaArch (String nomb,Object o){
        try {
            FileOutputStream arch2 = new FileOutputStream(nomb);  
            ObjectOutputStream os = new ObjectOutputStream(arch2);
            os.writeObject(o);
            os.close();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void borraArch(File arch){
        try {
            if(arch.exists()){
                arch.delete();
            }
        } 
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void ingresaFigura(Figura f){
        GeneralPath p = f.getPath();
        if (!leeArch("Figuras.pdd"))
            creaArch("Figuras.pdd",new HashMap<String,GeneralPath>());
        String nom = JOptionPane.showInputDialog(null, "Ingresa el nombre de la figura");
        try {
            FileInputStream arch = new FileInputStream("Figuras.pdd");  
            ObjectInputStream os = new ObjectInputStream(arch);
            HashMap<String,GeneralPath> figs = new HashMap<>();
            figs = (HashMap<String,GeneralPath>) os.readObject();
            os.close();
            arch.close();
            while (figs.containsKey(nom)){
                JOptionPane.showMessageDialog(null, "Figura con ese nombre ya existente");
                nom = JOptionPane.showInputDialog(null, "Ingresa el nombre de la figura");
            }
            figs.put(nom, p);
            os.close();
            arch.close();
            File arch2 = new File("Figuras.pdd");
            borraArch(arch2);
            creaArch("Figuras.pdd",figs);
        }
        catch(FileNotFoundException e){
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("no hay clase");
        }
    }
    
    public HashMap<String,GeneralPath> leerFiguras(){
        HashMap<String,GeneralPath> figs = null;
        if (!leeArch("Figuras.pdd"))
            creaArch("Figuras.pdd",new HashMap<String,Figura>());
        try {
            FileInputStream arch = new FileInputStream("Figuras.pdd");  
            ObjectInputStream os = new ObjectInputStream(arch);
            figs = new HashMap<>();
            figs = (HashMap<String,GeneralPath>) os.readObject();
            if (figs.size() == 0)
                    figs = null;
            os.close();
            arch.close();
        }
        catch(FileNotFoundException e){
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("no hay clase");
        }
        return figs;
    }
    public void ingresaVectorSesion(ArrayList<FiguraSave> f){
        String nom = JOptionPane.showInputDialog(null, "Ingresa el nombre del archivo de sesion sin extension");
        if (!leeArch(nom +".spd")){
            creaArch(nom + ".spd",f);
        }
        else{
            while (leeArch(nom +".spd")){
                JOptionPane.showMessageDialog(null, "El archivo con nombre " + nom + " ya exite");
                nom = JOptionPane.showInputDialog(null, "Ingresa el nombre del archivo de sesion sin extension");
            }
        }
    }
    
}

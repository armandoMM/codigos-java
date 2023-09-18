/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomatico;

/**
 *
 * @author leledezma
 */
import javax.swing.JOptionPane;

public class Cajero {
    private int cantidad;
    private boolean available=false;
    public Cajero(){
        cantidad=10000;
    }

    public synchronized void retira(int x){
        while (this.cantidad-x <=0 && available==false){
            try {
                wait();
            }catch (InterruptedException e){
                JOptionPane.showMessageDialog(null,"No hay Dinero","Error",JOptionPane.WARNING_MESSAGE);
            }   
        }
        cantidad=cantidad-x;
        available=false;
        notify();
    }

    public synchronized void ingresar(int x){
        while (cantidad+x>=10000 && available==true){
            try {
                wait();
            }
            catch (InterruptedException e){
                JOptionPane.showMessageDialog(null,"No hay Dinero","Error",JOptionPane.WARNING_MESSAGE);
            }
            
        }
        cantidad=cantidad+x;
        available=true;
        notify();
    }

    public synchronized int RegresaCantidad(){
        return cantidad;
    }
}


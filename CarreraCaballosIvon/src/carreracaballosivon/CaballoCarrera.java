/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreracaballosivon;
import java.util.Observable;
/**
 *
 * @author IvónLs
 */
public class CaballoCarrera extends Observable implements Runnable{
    private String caballo;

    public String getCaballo() {
        return caballo;
    }
    
    public CaballoCarrera(String caballo){
        this.caballo=caballo;
    }
    
    @Override
    public void run() {
        int porcent=0, numA;
        try{
            while(porcent<100){
                numA=(int)(Math.random()*(30-1+1)+1);
                porcent+=numA;
                this.setChanged();
                this.notifyObservers(porcent);
                this.clearChanged();
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){}
        
        
    }
    
}

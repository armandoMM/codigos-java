/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercubos;

/**
 *
 * @author IvónLs
 */
public class rutas {

    
    private int [] r1=new int[4];
    private int [] r2=new int[4];
    private int []aux= new int[4];
    public int [] getaux(){
        return aux;
    }
    public void CalcularRuta(){
        int salida, destino,i;
        salida=Hipercubos.nodo[Hipercubos.emi][6];
        destino=Hipercubos.nodo[Hipercubos.rec][6];
        
        r1[0]=salida%10;
        r1[1]=(((salida%100)-r1[0])/10);
        r1[2]=(((salida%1000)-r1[1])/100);
        
        if(salida>=1000){
            r1[3]=salida/1000;
        }else{
            r1[3]=0;
        }
        
        r2[0]=destino%10;
        r2[1]=(((destino%100)-r2[0])/10);
        r2[2]=(((destino%1000)-r2[1])/100);
        
        if(destino>=1000){
            r2[3]=destino/1000;
        }else{
            r2[3]=0;
        }
        i=0;
        while( i<4){
            if(r1[i]!=r2[i]){
                aux[i]=1;
            }else{
                aux[i]=0;
            }
            i++;
        }
    }
    public void run(){
        int i=0;
        while(i<4){
            System.out.println("r1["+i+"]= "+r1[i]);
            i++;
        }
        i=0;
        while(i<4){
            System.out.println("r2["+i+"]= "+r2[i]);
            i++;
        }
    }
}

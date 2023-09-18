/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplicacionmatrizexamen;
import java.util.*;
import java.util.LinkedList;
import static javafx.scene.input.KeyCode.T;
/**
 *
 * @author IvónLs
 */
public class MultiplicacionMatrizExamen {

    /**
     * @param args the command line arguments
     */
    static long ms,ms2,O=73,T=100,Tn,Sn,En,On,Rn,Un,Qn;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Introduzca el número de filas de la primer matriz:");
        int n = input.nextInt();
        System.out.print("Introduzca el número de columnas de la primer matriz:");
        int m = input.nextInt();
        System.out.print("Introduzca el número de filas de la primer matriz:");
        int l = input.nextInt();
        System.out.print("Introduzca el número de columnas de la primer matriz:");
        int o = input.nextInt();
        if(m == l){
            int hilos;
            do{
                System.out.print("Introduzca el número de hilos con los que se quiere trabajar:");
                hilos = input.nextInt();
            }while(hilos==0);
            
            int[][] matriz1=new int [n][m];
            int[][] matriz2=new int [l][o];
            for(int i=0;i<matriz1.length;i++){
                for(int j=0;j<matriz1[0].length;j++){
                    matriz1[i][j]=(int)(Math.random()*(10-1+1)+1);
                }
            }
            for(int i=0;i<matriz2.length;i++){
                for(int j=0;j<matriz2[0].length;j++){
                    matriz2[i][j]=(int)(Math.random()*(10-1+1)+1);
                }
            }
            System.out.println("Datos primer matriz");
            for (int x=0; x < matriz1.length; x++) {
                for (int y=0; y < matriz1[x].length; y++) {
                  System.out.println ("[" + x + "," + y + "] = " + matriz1[x][y]);
                }
            }
            System.out.println("Datos segunda matriz");
            for (int x=0; x < matriz2.length; x++) {
                for (int y=0; y < matriz2[x].length; y++) {
                  System.out.println ("[" + x + "," + y + "] = " + matriz2[x][y]);
                }
            }
            int [][] resultado= new MultiplicacionMatrizExamen().mult(matriz1,matriz2,n,o,hilos);
            System.out.println("Matriz resultante");
            for (int i=0;i<resultado.length; i++){
		for (int j=0;j<resultado[0].length;j++)
                    System.out.print(resultado[i][j]+" ");
                    System.out.println(" ");
            }
            Tn=ms2-ms;
            System.out.println("Tiempo con N hilos: "+Tn+" ms.");
            Sn=T/Tn;
            System.out.println("Factor de mejora de rendimiento: "+Sn);
            En=Sn/hilos;
            System.out.println("Eficiencia: "+En);
            if(En>=0.5)
                System.out.println("El sistema es escalable");
            else System.out.println("El sistema NO es escalable");
            On = 28 + (45+(Tn-T))*hilos;
            Rn= O/On;
            System.out.println("Se tiene una redundancia de: "+On);
            Un=Rn*En;
            System.out.println("Se tiene una utilizacion de: "+Un);
            Qn=(Sn*En)/Rn;
            System.out.println("La calidad del paralelismo es: "+Qn);

                
        }else{
            System.out.println("No se puede efectuar la operación,las columnas de la primer matriz");
            System.out.println("no son iguales a las filas de la segunda matriz.");
            System.out.println("Deben ser del tipo MxN NxP");
            
        }
        

    }

    private int[][] mult(int[][] matriz1, int[][] matriz2,int filas,int columnas, int h) {
        //Dimensiones para matriz resultado
        int [][]matRes=new int[filas][columnas];
        //Hilos
        LinkedList<Thread> hilos= new LinkedList<Thread>();
        for(int i=0;i<=h;i++){//De acuerdo a los hilos ingresados
            for (int f=0; f<filas; f++){
                for (int c=0; c<columnas; c++){
                    Thread hilo = new Thread(new HilosMultiplicaciones(matriz1,matriz2,matRes,f,c));
                    hilos.add(hilo);/*Se agrega a la lista de hilos*/
                    hilo.start();/*Se inicia el hilo*/
                    ms=System.currentTimeMillis();
                }
            }
        }    
        /*Finalizan hilos*/
        for (Thread hilo: hilos)
            try {
		hilo.join();
                ms2=System.currentTimeMillis();
            } catch (InterruptedException e) {}
        
	return matRes;
        


    }
  
}

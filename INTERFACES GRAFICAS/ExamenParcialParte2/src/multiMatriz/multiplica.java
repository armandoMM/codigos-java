package multiMatriz;

import java.util.Scanner;

/**
 *
 * @author yeckz
 */
public class multiplica {
    public static void main(String[] args) {
        int hilos;
        long T,Tn;
        double Sn = 0,En=0,Rn=0,O=88,On,Un,Qn;
        Scanner sc = new Scanner(System.in);
        System.out.println("DAME EL ORDEN DE LAS MATRICES: ");
        System.out.println("FILAS MATRIZ 1: ");
        int x1 = sc.nextInt();
        System.out.println("COLUMNAS MATRIZ 1: ");
        int y1 = sc.nextInt();
        System.out.println("FILAS MATRIZ 2: ");
        int x2 = sc.nextInt();
        System.out.println("COLUMNAS MATRIZ 1: ");
        int y2 = sc.nextInt();
        if(y1==x2){
            Matrix m = new Matrix(x1,y1);
            Matrix m2 = new Matrix(x2,y2);

            m.fillMatrix();
            m2.fillMatrix();

            //TOMANDO TIEMPOS CON 1 HILO
            long ms,ms2;
            ms = System.currentTimeMillis();

            m.showMatrix();
            m2.showMatrix();
            Matrix result = new Matrix(x1,y2,m,m2);

            result.showMatrix();

            ms2 = System.currentTimeMillis();
            T=ms2-ms;
            System.out.println("El tiempo que se tarda con 1 hilo es: "+T+ " ms");

            System.out.println("Dame el total de hilos a ejecutar: ");
            hilos = sc.nextInt();
            
            //TOMANDO TIEMPOS CON VARIOS HILOS
            ms =System.currentTimeMillis();

            Matrix res = new Matrix(x1,y2);
            //for(int k=1;k<=hilos;k++){
                for(int i=0; i<res.getFila(); i++){
                    for(int j=0; j<res.getCol(); j++){
                        for(int k=1;k<=hilos;k++){
                            Multiply c1 = new Multiply(res,m,m2,i, j);
                            Consum c2 = new Consum(res, i, j);
                            c1.start();
                            c2.start();
                        }
                    }
                }
            //}
            res.showMatrix();
            
            ms2 = System.currentTimeMillis();
            Tn=ms2-ms;
            System.out.println("Tiempo con N hilos: "+Tn+" ms.");
            try{
                Sn=(T/Tn)+(T%Tn);
                System.out.println("Factor de mejora de rendimiento: "+Sn);
            }catch(ArithmeticException e){}

            try{
                En=Sn/hilos;
                System.out.println("Eficiencia: "+En);
            }catch(ArithmeticException e){}

            if(En>=0.5)
                System.out.println("El sistema es escalable");
            else System.out.println("El sistema NO es escalable");
            
            try{
                On = 34 + (54+(Tn-T))*hilos;
                Rn= O/On;
                System.out.println("Se tiene una redundancia de: "+On);
            }catch(ArithmeticException e){}
            
            Un=Rn*En;
            System.out.println("Se tiene una utilizacion de: "+Un);
            
            try{
                Qn=(Sn*En)/Rn;
                System.out.println("La calidad del paralelismo es: "+Qn);
            }catch(ArithmeticException e){}
        }        
    }
}

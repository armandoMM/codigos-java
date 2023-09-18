/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplicacionmatrizexamen;

/**
 *
 * @author IvónLs
 */
public class HilosMultiplicaciones implements Runnable {
    private final int[][] matriz1;
    private final int[][] matriz2;
    private final int[][] matRes;
    private final int fila;
    private final int columna;
    public HilosMultiplicaciones(int[][] matriz1, int[][] matriz2, int[][] matRes, int f, int c) {
        this.matriz1=matriz1;
        this.matriz2=matriz2;
        this.matRes=matRes;
        this.fila=f;
        this.columna=c;
    }

    @Override
    public void run() {
       matRes[fila][columna]=0;
        for(int i=0;i<matriz2.length;i++){
            matRes[fila][columna]+=matriz1[fila][i]*matriz2[i][columna];
        }
    }
    
}

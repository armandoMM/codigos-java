/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipercubos;
import java.util.Scanner;

/**
 *
 * @author IvónLs
 */
public class Hipercubos {

    /**
     * @param args the command line arguments
     */
    /*Definiendo los vertices*/
    public static int [][]nodo= {{120,120,2,1,4,8,0},
                                {220,120,3,0,5,9,1},
                                {170,170,0,3,6,10,10},
                                {270,170,1,2,7,11,11},
                                 {120,220,6,5,0,12,100},
                                {220,220,7,4,1,13,101},
                                {170,270,4,7,2,14,110},
                                {270,270,5,6,3,15,111},
                                {420,420,10,9,12,0,1000},
                                {520,420,11,8,13,1,1001},
                                {470,470,8,11,14,2,1010},
                                {570,470,9,10,15,3,1011},
                                {420,520,14,13,8,4,1100},
                                {420,520,15,12,9,5,1101},
                                {470,570,12,15,10,6,1110},
                                {570,570,13,14,11,7,1111}};
    public static int emi,rec;
    public static void main(String[] args) {
        principal menu=new principal();
        Scanner sc= new Scanner(System.in);
        menu.setVisible(true);
    }
    
}

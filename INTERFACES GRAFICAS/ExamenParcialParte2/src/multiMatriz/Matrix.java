package multiMatriz;

/**
 *
 * @author yeckz
 */
public class Matrix {
    private int col;
    private int fila;
    private int [][]matrix;
    public boolean available=false;
    
    public Matrix(int f, int c){
        this.col = c;
        this.fila = f;
        matrix =new int[f][c];
    }
    
    public Matrix(int f, int c, Matrix m1, Matrix m2){
        this.col = c;
        this.fila = f;
        matrix =new int[f][c];
        multiply(m1,m2);
    }
    
    public int getFila(){
        return fila;
    }
    
    public int getCol(){
        return col;
    }
    
    public void fillMatrix(){
        for(int i=0; i<fila; i++){
            for(int j=0; j<col; j++){
                matrix[i][j] = (int)(Math.random() * 10);
            }
        }
    }
    
    public int [][]getMatrix(){
        return matrix;
    }
    
    public void showMatrix(){
        for(int i=0; i<fila; i++){
            for(int j=0; j<col; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    private void multiply(Matrix m1, Matrix m2){
        for(int i=0; i<fila; i++){
            for(int j=0; j<col; j++){
                for(int k=0;k<col;k++){
                    matrix[i][j] += m1.matrix[i][k] * m2.matrix[k][j];
                }
            }
        }
    }
    
    public synchronized int get(int _i, int _j){
        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        available = false;
        notify();
        return matrix[_i][_j];
    }
    
    public synchronized void putNumber(int value, int _i, int _j){
        while (available == true) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        matrix[_i][_j] = value;
        available = true;
        notify();
    }
}

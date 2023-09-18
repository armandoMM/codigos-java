package multiMatriz;

/**
 *
 * @author yeckz
 */
public class Multiply extends Thread{
    private Matrix res;
    private Matrix B;
    private Matrix A;
    private int i,j;
    private int a;
    
    public Multiply(Matrix m, Matrix a, Matrix b, int _i, int _j){
        res=m;
        A=a;
        B=b;
        i=_i;
        j=_j;
    }
        
    @Override
    public void run(){
        //for(int j=0; j<res.getCol(); j++){
            //res.getMatrix()[i][j]=0;
            //a = res.get(i, j);
            //a = 0;
            for(int k=0;k<res.getCol();k++){
                //System.out.println("a: "+A.getMatrix()[i][k]);
                //System.out.println("b: "+B.getMatrix()[k][j]);
                //res.getMatrix()[i][j] += A.getMatrix()[i][k] * B.getMatrix()[k][j];
                a +=  A.getMatrix()[i][k] * B.getMatrix()[k][j];  
            }
            res.putNumber(a, i, j);
        //} 
    }
}

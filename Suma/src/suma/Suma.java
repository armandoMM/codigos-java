package suma;

public class Suma {
    private int v1,v2,res;
    
    public Suma(int val1, int val2){
        this.v1=val1;
        this.v2=val2;
    }
    
    public void operation() {
        res=v1+v2;
    }
    
    public void imprimir() {
        operation();
        System.out.println("Resultado: "+ res);
    }
}

package factorial;

public class MainFactorial {
    public static void main(String[] args) {
        double n = 0;
        Factorial obj = new Factorial();
        while(true){
            System.out.println("Factorial de "+ n +": "+ obj.getFactorial(n));
            n+=1;
        }
    }
}

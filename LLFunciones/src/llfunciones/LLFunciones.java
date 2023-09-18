/*
*Class for a logical function for a washing machine
*/
package llfunciones;
/**
 * @author Armando Matias Montaño
 */
public class LLFunciones {
    private int kg=0, fill=0,typeClothes=0, finish=0, dry=0;
    
    public LLFunciones(int kg, int typeClothes) {
        this.kg=kg;
        this.typeClothes=typeClothes;
    }
    //metodo que sirve para llenar
    private void Fill(){
        if(kg<=12){
            fill=1;
            System.out.println("FILLING...");
            System.out.println("FILLED COMPLETE");
        }else{
            System.out.println("laundry load is very heavy, reduce load");
        }
    }
    //metodo que sirve para lavar
    private void wash(){
        Fill();
        if(fill==1){
            if(typeClothes==1){
                System.out.println("CLOTHES WHITE/ SMOOTH WASH");
                System.out.println("WASHING...");
                finish=1;
            }else if(typeClothes==2){
                System.out.println("CLOTHES COLOR/ INTENSIVE WASH");
                System.out.println("WASHING...");
                finish=1;
            }else{
                System.out.println("Type clothes is not available");
                System.out.println("Only white clothes or color clothes");
            }
        }
    }
    //metodo que sirve para secar
    private void dryOff(){
        wash();
        if(finish==1){
            System.out.println("Dried off...");
            dry=1;
        }
    }
    //verifica el ciclo de lavado
    public void cycleFinished(){
        dryOff();
        if(dry==1){
            System.out.println("CYCLE FINISHED, CLOTHES IS CLEAN");
        }
    }
}

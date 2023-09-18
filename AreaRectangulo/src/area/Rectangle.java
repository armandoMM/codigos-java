package area;

public class Rectangle {
    private int base,height,area;
    
    public Rectangle(int b,int h) {
        this.base=b;
        this.height=h;
    }
    
    public void getArea(){
        area=base*height;
    }
    
    public void printArea() {
        getArea();
        System.out.println("Area: "+area);
    }
}

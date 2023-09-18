package analizer;

public class Stack {
    private Node ultValue;
    
    public Stack(){
        ultValue = null;
    }
    
    public void insert(char value){
        Node new_node  = new Node();
        new_node.info  = value;
        
        if(ultValue.info == value){
            new_node.next = null;
            ultValue = new_node;
        }else{
            new_node.next = ultValue;
            ultValue = new_node;
        }
    }
    
    public char extract(){
        if(ultValue != null){
            char info = ultValue.info;
            ultValue = ultValue.next;
            return info;
        }else{
            return Character.MAX_VALUE;
        }
    }
    
    public boolean StackEmpty(){
        return ultValue == null;
    }
}

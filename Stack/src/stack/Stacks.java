package stack;

import javax.swing.JOptionPane;

public class Stacks {
    private Node ultValue;
    int size;
    String List = "";
    
    public Stacks(){
        ultValue = null;
        size = 0;
    }
    
    public boolean StackEmpty(){
        return ultValue == null;
    }
    
    public void InsertNode(int node){
        Node new_node = new Node(node);
        new_node.next = ultValue;
        ultValue = new_node;
        size++;
    }
    
    public int DeleteNode(){
        int aux = ultValue.value;
        ultValue = ultValue.next;
        size--;
        return aux;
    }
    
    public int ShowValueInserted(){
        return ultValue.value;
    }
    
    public int SizeStack(){
        return size;
    }
    
    public void EmptyStack(){
        while(!StackEmpty()){
            DeleteNode();
        }
    }
    
    public void ShowValues(){
        Node aux = ultValue;
        
        while(aux != null){
            List += aux.value + "\n";
            aux = aux.next;
        }
        JOptionPane.showMessageDialog(null, List);
        List = "";
    }
}

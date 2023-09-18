package classes;

public class Tree {
    private Node root;
    
    public Tree(){
        root = null;
        /*root.left = null;
        root.right = null;
        root.value= 0;*/
    }
    
    public Node getRoot(){
        return this.root;
    }
            
    public boolean search(int val, Node node){
        /*if(node.value == val){
            return true;
        }else {
            
        }*/
        return true;
    }
    
    public void inorder(Node current){
        if(current!=null){
            inorder(current.left);
            System.out.print(current.value + " ");
            inorder(current.right);
        }
    }
    
    public void insert(Node fath, Node current, Node new_node){
        if(current == null){
            current = new_node;
            if(current.value < fath.value){
                fath.left = current;
            }else{
                fath.right = current;
            }   
        }else if(new_node.value < current.value){
            insert(current,current.left,new_node);
        }else{
            insert(current, current.right,new_node);
        }
    }
    
    public void add(int val){
        Node new_node = new Node();
        new_node.value = val;
        new_node.left = null;
        new_node.right = null;
        
        if(getRoot() == null){
            root = new_node;
        }else{
            if(val < root.value){
                insert(root,root.left,new_node);                
            }else{
                insert(root,root.right,new_node);
            }
        }         
    }    
}

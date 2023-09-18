package classes;

import javax.swing.JOptionPane;

public class Queue {
    private Node ini, end;
    String cola = "";
    
    public Queue(){
        ini = null;
        end = null;
    }
    
    public boolean QueueEmpty(){
        if(ini == null)
            return true;
        else
            return false;
    }
    
    public void Insert(int info){
        Node new_node = new Node();
        new_node.value = info;
        new_node.next = null;
        
        if(QueueEmpty()){
            ini =  new_node;
            end = new_node;
        }else{
            end.next = new_node;
            end = new_node;
        }
    }
    
    public int Extract(){
        if (!QueueEmpty()) {
            int info = ini.value;
            
            if (ini == end) {
                ini = null;
                end = null;
            } else {
                ini = ini.next;
            }
            
            return info;
        } else {
            return Integer.MAX_VALUE; //QUE REGRESA??
        }
    }
    
    public void ShowContent(){
        Node recorrido = ini;
        String ColaInvert = "";
        
        while(recorrido != null){
            cola += recorrido.value;
            recorrido = recorrido.next;
        }
        
        String cadena[] = cola.split(" ");
        
        for(int i = cadena.length-1; i>=0; i--){
            ColaInvert += " " + cadena[i];
        }
        
        JOptionPane.showMessageDialog(null, ColaInvert);
        cola = "";
    }
}

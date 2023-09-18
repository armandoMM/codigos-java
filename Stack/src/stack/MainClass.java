package stack;

import javax.swing.JOptionPane;

public class MainClass {
    public static void main(String[] args) {
        int opc=0, node;
        Stacks stack = new Stacks();
        
        do{
            try{
                opc = Integer.parseInt(JOptionPane.showInputDialog(null, "MENU\n" 
                        + "1. INSERT NODE\n" 
                        + "2. DELETE NODE\n" 
                        + "3. VERIFY EMPTY STACK\n" 
                        + "4. ULTIMATE VALUE OF STACK\n" 
                        + "5. SIZE OF STACK\n" 
                        + "6. EMPTY STACK\n" 
                        + "7. SHOW CONTENT\n" 
                        + "8. EXIT\n"));
                switch(opc){
                    case 1:
                        node = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                "ingresa el valor: "));
                        stack.InsertNode(node);
                        break;
                    case 2:
                        if(!stack.StackEmpty()){
                            JOptionPane.showMessageDialog(null, "SE HA ELIMINADO EL VALOR: "
                                    + stack.DeleteNode());
                        }else{
                            JOptionPane.showMessageDialog(null, "LA PILA ESTA VACIA");
                        }
                        break;
                    case 3:
                        if(stack.StackEmpty()){
                            JOptionPane.showMessageDialog(null, "LA PILA ESTA VACIA");
                        }else{
                            JOptionPane.showMessageDialog(null, "LA PILA TIENE ELEMENTOS");
                        }
                        break;
                    case 4:
                        if(!stack.StackEmpty()){
                            JOptionPane.showMessageDialog(null, "EL ULTIMO ELEMENTO ES: " 
                                    + stack.ShowValueInserted());
                        }else{
                            JOptionPane.showMessageDialog(null, "LA PILA ESTA VACIA");
                        }
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "LA PILA TIENE: " + 
                                stack.SizeStack() + "nodos.");
                        break;
                    case 6:
                        if(!stack.StackEmpty()){
                            stack.EmptyStack();
                            JOptionPane.showMessageDialog(null, "LA PILA SE HA VACIADO");
                        }else{
                            JOptionPane.showMessageDialog(null, "LA PILA YA ESTA VACIA");
                        }
                        break;
                    case 7:
                        stack.ShowValues();
                        break;
                    case 8:
                        opc = 8;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Opcion incorrecta");
                        break;
                }
            }catch(NumberFormatException e){
                
            }
        }while(opc != 8);
    }
}

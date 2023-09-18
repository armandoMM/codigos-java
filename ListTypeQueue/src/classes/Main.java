package classes;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int opc = 0, node_info = 0 ;
        Queue cola = new Queue();
        
        do{
            try{
                opc = Integer.parseInt(JOptionPane.showInputDialog(null,"MENÚ DE OPCIONES\n\n" + "1. Insertar nodo\n" + "2. Extraet nodo\n" + "3. Mostrar Cola\n" + "4. salir\n"));
                
                
                switch(opc){
                    case 1:
                        node_info = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el valor del nodo: "));
                        cola.Insert(node_info);
                        break;
                    case 2: 
                        if (!cola.QueueEmpty()) {
                            JOptionPane.showMessageDialog(null, "Se extrajo un nodo con valor de: " + cola.Extract());
                        } else {
                            JOptionPane.showMessageDialog(null, "La cola esta vacia");
                        }
                        break;
                    case 3:
                        cola.ShowContent();
                        break;
                    case 4: 
                        opc = 4;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
                        break;
                }
            }catch(NumberFormatException e){
                
            }
        }while(opc != 4);
    }
}

package projecttest;
import database.Connect;
import javax.swing.*;
import java.awt.event.*;
import static java.lang.System.exit;


/**
 *
 * @author yeckz
 */
public class ProjectTest extends JFrame {
    
    public static void main(String[] args) {
        Connect con = new Connect("root","","jdbc:mysql://localhost:3306/papeleria");
        con.conectar();
        MyFrame frame = new MyFrame();
        frame.setBounds(0, 0, 300, 150);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);        
    }
    
}

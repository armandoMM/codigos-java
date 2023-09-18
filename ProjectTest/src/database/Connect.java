package database;
import java.sql.Connection;
import java.sql.Statement; 
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import projecttest.ProjectTest;

/**
 *
 * @author yeckz
 */
public class Connect {
    static String usr;
    static String pw;
    static String url;
    static Connection conn;
    
    public Connect(String usr,String pw, String url){
        this.usr=usr;
        this.pw = pw;
        this.url=url;
        this.conn = null;
    }
    
    public static void conectar(){
        
        Statement stm;
        ResultSet rs;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjectTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conn = DriverManager.getConnection(url,usr,pw);
            JOptionPane.showMessageDialog(null, "Conectado... "+conn.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ProjectTest.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al conectar...\n"+ex.toString());
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar...\n"+e.toString());
        }finally{
            System.exit(0);
        }
    }
    
    Connection getConn(){
        return this.conn;
    }
}

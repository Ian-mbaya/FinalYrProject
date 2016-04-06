/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Store;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author AnonymousHacker
 */
public class DBConnection {
    Connection conn=null;
    public static Connection ConnecrDB(){
        try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/myproject", "root", "");
    //JOptionPane.showMessageDialog(null, "Connection Established");
    return conn;
            }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            return null;
            }
    }
}

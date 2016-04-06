/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Store;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author AnonymousHacker
 */
public class Test extends JFrame{
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    private JTable table;
    private JButton print;
    public Test(){
        conn=DBConnection.ConnecrDB();
        setLayout(new BorderLayout());
        table=new JTable();
        add(table);
        print=new JButton("PRINT");
        add(print,BorderLayout.SOUTH);
        print.addActionListener(new PrintListener());
        try{
        String sql="select * from patients";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        table.setModel(DbUtils.resultSetToTableModel(rs));
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
        finally{
           try{
               pst.close();
               rs.close();
           }catch(Exception e){
               
           }
       }
    }
    class PrintListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
             MessageFormat header= new MessageFormat("Medical Report");
        MessageFormat footer= new MessageFormat("page{0,number,integer}");
        try{
            table.print(JTable.PrintMode.NORMAL, header, footer);
        }catch(java.awt.print.PrinterException pe){
            System.err.format("Cannot Print",pe.getMessage());
        }
        }
    }
    public static void main(String [] args){
        Test frame=new Test();
        frame.setSize(900,800);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

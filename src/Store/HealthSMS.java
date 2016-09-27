/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Store;

import com.mysql.jdbc.StringUtils;
import java.awt.event.KeyEvent;
import java.io.*;
import static java.lang.Thread.sleep;
import java.net.*;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author AnonymousHacker
 */
public class HealthSMS extends javax.swing.JFrame {
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    /**
     * Creates new form HealthSMS
     */
    public HealthSMS() {
        initComponents();
        conn=DBConnection.ConnecrDB();
        CurrentDateAndTime();
    }
    
    public void CurrentDateAndTime(){
        Thread clock= new Thread(){
            public void run(){
                for(;;){
        Calendar cal=new GregorianCalendar();
        int yr=cal.get(Calendar.YEAR);
        int mnth=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        hdate.setText("Date "+yr+"/"+(mnth + 1)+"/"+day);
        
        int sec=cal.get(Calendar.SECOND);
        int min=cal.get(Calendar.MINUTE);
        int hr=cal.get(Calendar.HOUR);
        htime.setText("Time "+hr+":"+min+":"+sec); 
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        clock.start();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_msg = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        Send = new javax.swing.JButton();
        clr = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        spno = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        hdate = new javax.swing.JMenu();
        htime = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SEND SMS TO PATIENTS");
        setBackground(new java.awt.Color(0, 153, 51));
        setFont(new java.awt.Font("Agency FB", 1, 10)); // NOI18N
        setResizable(false);

        jToolBar1.setRollover(true);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/lightbox-prev.png"))); // NOI18N
        jButton2.setToolTipText("Back");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/logout-icon_small.png"))); // NOI18N
        jButton1.setToolTipText("Log Out");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        txt_msg.setColumns(20);
        txt_msg.setRows(5);
        txt_msg.setText("Type The Message...");
        txt_msg.setToolTipText("Type The Message...");
        txt_msg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_msgMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txt_msg);

        jLabel2.setText("Message");

        Send.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/messages-icon2.png"))); // NOI18N
        Send.setText("Send");
        Send.setToolTipText("Send SMS to Patients");
        Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendActionPerformed(evt);
            }
        });

        clr.setText("Clear");
        clr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clrActionPerformed(evt);
            }
        });

        jLabel1.setText("Phone Number");

        spno.setText("Enter The Phone Number,start +254...");
        spno.setToolTipText("Enter The Phone Number,start +254...");
        spno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spnoMouseClicked(evt);
            }
        });
        spno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                spnoKeyTyped(evt);
            }
        });

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/logout-icon_small.png"))); // NOI18N
        jMenuItem1.setText("Log Out");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        hdate.setText("Date");
        jMenuBar1.add(hdate);

        htime.setText("Time");
        jMenuBar1.add(htime);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(Send)
                        .addGap(27, 27, 27)
                        .addComponent(clr))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spno, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spno, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Send)
                    .addComponent(clr))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(808, 524));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
       new Login().setVisible(true);
       dispose();
       JOptionPane.showMessageDialog(null, "You Logged Out");
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void SendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendActionPerformed

             // Specify your login credentials
             String username = "sheldon";
             String apiKey   = "c596f432c84ad0036af4c7eca10b89f8a9c71520d90975564a8ca122514babca";
        
             // Specify the numbers that you want to send to in a comma-separated list
             // Please ensure you include the country code (+254 for Kenya in this case)
             String recipients = spno.getText();
        
             // And of course we want our recipients to know what we really do
             //String message = "We are lumberjacks. We code all day and sleep all night";
             String message =txt_msg.getText();
        
            // Create a new instance of our awesome gateway class
             AfricasTalkingGateway gateway  = new AfricasTalkingGateway(username, apiKey);
        
             // Thats it, hit send and we'll take care of the rest. Any errors will
             // be captured in the Exception class below
            try {
                JSONArray results = gateway.sendMessage(recipients, message);
                
                for( int i = 0; i < results.length(); ++i ) {
            try{
                      JSONObject result = results.getJSONObject(i);
                      String msgid= result.getString("messageId");
                      String no=result.getString("number");
                      String msg=txt_msg.getText();
                      String cost=result.getString("cost");
                    if(!StringUtils.isNullOrEmpty(msgid) && !StringUtils.isNullOrEmpty(no) && !StringUtils.isNullOrEmpty(msg) && !StringUtils.isNullOrEmpty(cost)){
                      //JSONObject result = results.getJSONObject(i);
                      String sql="insert into p_messages values('"+msgid+"','"+no+"','"+msg+"','"+cost+"')";
                      pst=conn.prepareStatement(sql);
                      /*pst.setString(1, result.getString("messageId"));
                      pst.setString(2, result.getString("number"));
                      pst.setString(3, txt_msg.getText());
                      pst.setString(4, result.getString("cost"));*/
                      pst.execute();
                      System.out.print(result.getString("status") + ","); // status is either "Success" or "error message"
                      System.out.print(result.getString("number") + ",");
                      System.out.print(result.getString("messageId") + ",");
                      System.out.println(result.getString("cost"));
                      JOptionPane.showMessageDialog(null, "Message Sent Successfully");
            }else{
                      JOptionPane.showMessageDialog(null, "Please, Fill All The Fields!!!"); 
            }
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
           }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Encountered an error while sending " + e.getMessage());
            }
            finally{
           try{
               pst.close();
               rs.close();
           }catch(Exception e){
               
           }
       }
    }//GEN-LAST:event_SendActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new Login().setVisible(true);
        dispose();
        JOptionPane.showMessageDialog(null, "You Logged Out");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new SwitchBoard().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Login().setVisible(true);
        dispose();
        JOptionPane.showMessageDialog(null, "You Logged Out");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_msgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_msgMouseClicked
        txt_msg.setText("");
    }//GEN-LAST:event_txt_msgMouseClicked

    private void spnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spnoMouseClicked
        spno.setText("");
    }//GEN-LAST:event_spnoMouseClicked

    private void clrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clrActionPerformed
        
        spno.setText("");
        txt_msg.setText("");
    }//GEN-LAST:event_clrActionPerformed

    private void spnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spnoKeyTyped
        char c=evt.getKeyChar();
       if(!(Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)){
           getToolkit();
           evt.consume();
       }
    }//GEN-LAST:event_spnoKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HealthSMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HealthSMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HealthSMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HealthSMS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HealthSMS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Send;
    private javax.swing.JButton clr;
    private javax.swing.JMenu hdate;
    private javax.swing.JMenu htime;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField spno;
    private javax.swing.JTextArea txt_msg;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Store;

import com.mysql.jdbc.StringUtils;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author AnonymousHacker
 */
public class Login extends javax.swing.JFrame {
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    Statement st=null;
    
    public static String holdNames;
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        conn=DBConnection.ConnecrDB();
        CurrentDateAndTime();
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Store/icons/H-2-icon.png"));
        setIconImage(img);
    }
    public void CurrentDateAndTime(){
        Thread clock= new Thread(){
            public void run(){
                for(;;){
        Calendar cal=new GregorianCalendar();
        int yr=cal.get(Calendar.YEAR);
        int mnth=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        ldate.setText("Date "+yr+"/"+(mnth + 1)+"/"+day);
        
        int sec=cal.get(Calendar.SECOND);
        int min=cal.get(Calendar.MINUTE);
        int hr=cal.get(Calendar.HOUR);
        ltime.setText("Time "+hr+":"+min+":"+sec); 
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmd_login = new javax.swing.JButton();
        txt_mail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_pwrd = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mail_adm = new javax.swing.JTextField();
        pass_adm = new javax.swing.JPasswordField();
        adm_log = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        ldate = new javax.swing.JMenu();
        ltime = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LOGIN");
        setResizable(false);

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/Home-icon.png"))); // NOI18N
        jButton1.setToolTipText("Back Home");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/Button-Close-icon.png"))); // NOI18N
        jButton2.setToolTipText("Exit");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jLabel3.setText("Password");

        cmd_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/login.png"))); // NOI18N
        cmd_login.setToolTipText("Click To Login");
        cmd_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_loginActionPerformed(evt);
            }
        });

        txt_mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mailActionPerformed(evt);
            }
        });
        txt_mail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_mailKeyTyped(evt);
            }
        });

        jLabel2.setText("Email");

        txt_pwrd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_pwrdKeyTyped(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/Keys-icon.png"))); // NOI18N
        jLabel1.setToolTipText("Login");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_mail, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                    .addComponent(txt_pwrd))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cmd_login)
                        .addGap(114, 114, 114))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(86, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_pwrd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(cmd_login)
                .addGap(58, 58, 58))
        );

        jTabbedPane1.addTab("LOGIN", jPanel1);

        jLabel4.setText("Email");

        jLabel5.setText("Password");

        pass_adm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pass_admKeyPressed(evt);
            }
        });

        adm_log.setText("Login");
        adm_log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adm_logActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(adm_log))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mail_adm)
                            .addComponent(pass_adm, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(mail_adm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pass_adm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(adm_log)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ADMIN", jPanel2);

        ldate.setText("Date");
        jMenuBar1.add(ldate);

        ltime.setText("Time");
        jMenuBar1.add(ltime);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(624, 447));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmd_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_loginActionPerformed
         /*try{
            String sql="select * from users where Email=? and Password=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, txt_mail.getText().trim().toLowerCase());
            pst.setString(2, txt_pwrd.getText());
            rs=pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Welcome");
               new  SwitchBoard().setVisible(true);
               dispose();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Wrong Email/Password.please,Try again");
        }*/
        try{
            //String level=combo_lvl.getSelectedItem().toString().trim();
            String mail= txt_mail.getText().trim().toLowerCase();
            String pass=txt_pwrd.getText().trim();
            if(!StringUtils.isNullOrEmpty(mail) && !StringUtils.isNullOrEmpty(pass)){
                if(EmailValidator.email_validation(mail)){
                if(PasswordValidator.pass_validation(pass)){
                String sql="select * from users where  Email='"+mail+"' && Password='"+pass+"'";
                pst=conn.prepareStatement(sql); 
                pst.execute();
                boolean tester = false;
                if(mail.equalsIgnoreCase("piuswanjiru1@gmail.com") && pass.equalsIgnoreCase("Sheldon254#}")){
                    tester = true;
                    JOptionPane.showMessageDialog(null, "Please,Use The Admin Panel!!!");
                }
                if(tester == false){
                new SwitchBoard().setVisible(true);
                String Eo="select * from doctors where Email='"+mail+"'";
                pst=conn.prepareStatement(Eo);
                pst.execute();
                st=conn.createStatement();
                rs=st.executeQuery(Eo);
                while(rs.next()){
                   String f=rs.getString("Fname");
                   String l=rs.getString("Lname");
                   holdNames = f + " " + l;
//                   Empnumber.setEno2(set);
                }
//                String no = Empnumber.getEno2();
//                String sql4="select * from doctors where Doc_No='"+no+"'";
//                pst = conn.prepareCall(sql4);
//                rs = pst.executeQuery(sql4);
//                    while (rs.next()) {                        
//                        String fname = rs.getString("Fname");
//                        String lname = rs.getString("Lname");
//                        String conc = fname + " " + lname;
//                        UserNames.setNames(conc);
//                        holdNames = UserNames.getNames();
//                    }
                
                    dispose();
                JOptionPane.showMessageDialog(null, "Welcome " + holdNames );
                }}else{
                    JOptionPane.showMessageDialog(null, "Invalid Password!!!Please try again");
                }
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Email, please Try again");
                }
            } else{
                JOptionPane.showMessageDialog(null, "Please, Fill All The Fields!!!");
            }
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e);
       }
        finally{
           try{
               pst.close();
               rs.close();
           }catch(Exception e){
               
           }
       }
    }//GEN-LAST:event_cmd_loginActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Home().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mailActionPerformed
        
    }//GEN-LAST:event_txt_mailActionPerformed

    private void txt_mailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mailKeyTyped
      
    }//GEN-LAST:event_txt_mailKeyTyped

    private void txt_pwrdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pwrdKeyTyped
        
    }//GEN-LAST:event_txt_pwrdKeyTyped

    private void adm_logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adm_logActionPerformed
        try{
            String mail= mail_adm.getText().trim().toLowerCase();
            String pass=pass_adm.getText().trim();
            if(!StringUtils.isNullOrEmpty(mail) && !StringUtils.isNullOrEmpty(pass)){
                if(EmailValidator.email_validation(mail)){
                if(PasswordValidator.pass_validation(pass)){
                String sql="select * from users where  Email='piuswanjiru1@gmail.com'  && Password='Sheldon254#}'";
                pst=conn.prepareStatement(sql);
                pst.execute();
                if(mail.equalsIgnoreCase("piuswanjiru1@gmail.com") && pass.equalsIgnoreCase("Sheldon254#}")){
                JOptionPane.showMessageDialog(null, "Welcome " + holdNames);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Sorry,You are not an Admin!!!");
                }
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Password!It should have atleast:six characters,uppercase,lowercase and a special character (@#$%)");
                }
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Email, please Try again");
                }
            } else{
                JOptionPane.showMessageDialog(null, "Please, Fill All The Fields!!!");
            }
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e);
       }
        finally{
           try{
               pst.close();
               rs.close();
           }catch(Exception e){
               
           }
       }
    }//GEN-LAST:event_adm_logActionPerformed

    private void pass_admKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass_admKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            try{
            String mail= mail_adm.getText().trim().toLowerCase();
            String pass=pass_adm.getText().trim();
            if(!StringUtils.isNullOrEmpty(mail) && !StringUtils.isNullOrEmpty(pass)){
                if(EmailValidator.email_validation(mail)){
                if(PasswordValidator.pass_validation(pass)){
                String sql="select * from users where  Email='"+mail+"' && Password='"+pass+"'";
                pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Welcome");
                    new Admin().setVisible(true);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid password");
                }
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Email, please Try again");
                }
            } else{
                JOptionPane.showMessageDialog(null, "Please, Fill All The Fields!!!");
            }
       }catch(SQLException e){
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
        
    }//GEN-LAST:event_pass_admKeyPressed

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
                //UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adm_log;
    private javax.swing.JButton cmd_login;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu ldate;
    private javax.swing.JMenu ltime;
    private javax.swing.JTextField mail_adm;
    private javax.swing.JPasswordField pass_adm;
    public static javax.swing.JTextField txt_mail;
    private javax.swing.JPasswordField txt_pwrd;
    // End of variables declaration//GEN-END:variables
}

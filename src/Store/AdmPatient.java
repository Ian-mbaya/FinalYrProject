/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Store;

import static Store.Login.holdNames;
import com.mysql.jdbc.StringUtils;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author AnonymousHacker
 */
public class AdmPatient extends javax.swing.JFrame {
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    /**
     * Creates new form AdmPatient
     */
    
//    pre-populates the available doctors
    public void prefillDoctors(){
                       
                //        select doctors names
        try {
            String doc_available = (String)dap.getItemAt(0);
//            test.setText(doc_available);
            String sql1 = "select * from doctors where Specialization = '"+doc_available+"'";
            pst = conn.prepareStatement(sql1);
            rs = pst.executeQuery(sql1);
            combo_type.removeAllItems();
            avail_docs.removeAllItems();
              while (rs.next()) {                  
                  String f = rs.getString("Fname");
                  String l = rs.getString("Lname");
                  String comb = f + " " + l;
                   
                  avail_docs.addItem(comb);
              }
        } catch (Exception e1) {
        }
    }
    
//    pre-populates disease types
    public void prefillType(){
                       
                //        select doctors names
        try {
            String type = (String)dap.getItemAt(0);
            test.setText(type);
            String query = "select * from diseases where disease = '"+type+"'";
            System.out.println(query);
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery(query);
            combo_type.removeAllItems();
             combo_type.addItem("Select Type");
              while (rs.next()) {                  
                  String f = rs.getString("type");
                  combo_type.addItem(f);
              }
        } catch (Exception e1) {
        }
    }
    
//    constructor
    public AdmPatient() {
        initComponents();
        conn=DBConnection.ConnecrDB();
        CurrentDateAndTime();
        prefillDoctors();
        prefillType();
        
        
        dap.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                            

               
                //        select doctors names
        try {
            String doc_available = dap.getSelectedItem().toString().trim(); 
//            test.setText(doc_available);
            String sql1 = "select * from doctors where Specialization = '"+doc_available+"'";
            System.err.println(sql1);
            pst = conn.prepareStatement(sql1);
            rs = pst.executeQuery(sql1);
            combo_type.removeAllItems();
            combo_type.addItem("Select Type");
            avail_docs.removeAllItems();
              while (rs.next()) {                  
                  String f = rs.getString("Fname");
                  String l = rs.getString("Lname");
                  String comb = f + " " + l;
                   
                  avail_docs.addItem(comb);
              }
        } catch (Exception e1) {
        }
            }
        });
        
        combo_type.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
             
        try {
            String disease = dap.getSelectedItem().toString().trim();
            String d_type = combo_type.getSelectedItem().toString().trim(); 
            test.setText(d_type);
            String query2 = "select * from doctors where Specialization = '"+disease+"' and type = '"+d_type+"' ";
            System.out.println(query2);
            pst = conn.prepareStatement(query2);
            rs = pst.executeQuery(query2);
            avail_docs.removeAllItems();
            
              while (rs.next()) {                  
                  String f = rs.getString("Fname");
                  String l = rs.getString("Lname");
                  String comb = f + " " + l;
                   
                  avail_docs.addItem(comb);
              }
        } catch (Exception e1) {
        }
            }
        });
        
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Store/icons/H-2-icon.png"));
        setIconImage(img);
        

//        pre-populate doctors names to assigned_to
        try {
            String query9 = "select * from doctors";
            pst = conn.prepareStatement(query9);
            rs = pst.executeQuery(query9);
              while (rs.next()) {                  
                  String f = rs.getString("Fname");
                  String l = rs.getString("Lname");
                  String comb = f + " " + l;
                   
                  sele_doc.addItem(comb);
              }
        } catch (Exception e) {
        }
        
//        Randomly generate the patients number
        int pno = (int)(Math.random() * 1000);
        String pn = Integer.toString(pno);
        txt_pno.setText("PN"+pn);
        String dn = Empnumber.getEno2();
        
        txt_dno.setText(holdNames);
    }
//    end Constructor
    
//    
    public void CurrentDateAndTime(){
        Thread clock= new Thread(){
            public void run(){
                for(;;){
        Calendar cal=new GregorianCalendar();
        int yr=cal.get(Calendar.YEAR);
        int mnth=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        apdate.setText("Date "+yr+"/"+(mnth + 1)+"/"+day);
        
        int sec=cal.get(Calendar.SECOND);
        int min=cal.get(Calendar.MINUTE);
        int hr=cal.get(Calendar.HOUR);
        aptime.setText("Time "+hr+":"+min+":"+sec); 
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        combo_gender = new javax.swing.JComboBox();
        txt_phone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dob = new com.toedter.calendar.JDateChooser();
        psave = new javax.swing.JButton();
        txt_pno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pfname = new javax.swing.JTextField();
        plname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pclear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_area = new javax.swing.JComboBox();
        error_pno = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sele_doc = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_dno = new javax.swing.JTextField();
        pno_txt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descr = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_rec = new javax.swing.JTextArea();
        tsave = new javax.swing.JButton();
        tclear = new javax.swing.JButton();
        dap = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        avail_docs = new javax.swing.JComboBox();
        test = new javax.swing.JTextField();
        combo_type = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        apdate = new javax.swing.JMenu();
        aptime = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("We Treat But God Heals");

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

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        combo_gender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

        txt_phone.setText("Enter Phone Number");
        txt_phone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_phoneMouseClicked(evt);
            }
        });
        txt_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_phoneActionPerformed(evt);
            }
        });
        txt_phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_phoneKeyTyped(evt);
            }
        });

        jLabel4.setText("Date of Birth");

        dob.setToolTipText("Enter Date Of Birth");
        dob.setDateFormatString(" yyyy/MM/d");
        dob.setMaxSelectableDate(new java.util.Date(1484085711000L));

        psave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/Actions-document-save-icon.png"))); // NOI18N
        psave.setText("Save");
        psave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psaveActionPerformed(evt);
            }
        });

        txt_pno.setEditable(false);
        txt_pno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_pnoMouseClicked(evt);
            }
        });

        jLabel2.setText("First Name ");

        pfname.setText("Enter First Name");
        pfname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pfnameMouseClicked(evt);
            }
        });
        pfname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pfnameKeyTyped(evt);
            }
        });

        plname.setText("Enter Last Name");
        plname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plnameMouseClicked(evt);
            }
        });
        plname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plnameActionPerformed(evt);
            }
        });
        plname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                plnameKeyTyped(evt);
            }
        });

        jLabel3.setText("Last Name");

        jLabel5.setText("Gender");

        pclear.setText("Clear");
        pclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pclearActionPerformed(evt);
            }
        });

        jLabel1.setText("Patient Number");

        jLabel7.setText("Phone Number");

        txt_area.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lurambi", "Koro Matangi", "Jua Kali", "Kefinco", "Milimani", "Malaba", "Joy Land", "Town Center", "Lubao", "Tea Zone", "Sichirai", "Mwiyala", "Shinyalu" }));

        jLabel6.setText("Area of Residence");

        jLabel16.setText("Assigned To");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pfname, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_pno, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(plname, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_area, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(psave)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pclear)
                                        .addGap(16, 16, 16))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sele_doc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo_gender, 0, 172, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(error_pno, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(538, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_pno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(pfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(plname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sele_doc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(psave)
                    .addComponent(pclear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(error_pno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(204, 204, 204))
        );

        jTabbedPane1.addTab("Personal Details", jPanel1);

        jLabel8.setText("Admitted By");

        jLabel9.setText("Patient Number");

        jLabel10.setText("Disease/Condition");

        jLabel11.setText("Description");

        txt_dno.setEditable(false);
        txt_dno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_dnoMouseClicked(evt);
            }
        });
        txt_dno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dnoActionPerformed(evt);
            }
        });

        pno_txt.setEditable(false);
        pno_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pno_txtMouseClicked(evt);
            }
        });
        pno_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pno_txtActionPerformed(evt);
            }
        });

        txt_descr.setColumns(20);
        txt_descr.setLineWrap(true);
        txt_descr.setRows(5);
        txt_descr.setText("Enter The Conditions Description");
        txt_descr.setWrapStyleWord(true);
        txt_descr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_descrMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txt_descr);

        jLabel12.setText("Recommedation");

        txt_rec.setColumns(20);
        txt_rec.setLineWrap(true);
        txt_rec.setRows(5);
        txt_rec.setText("Enter Your Recommendation To The Patient");
        txt_rec.setWrapStyleWord(true);
        txt_rec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_recMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(txt_rec);

        tsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/Actions-document-save-icon.png"))); // NOI18N
        tsave.setText("Save");
        tsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tsaveActionPerformed(evt);
            }
        });

        tclear.setText("Clear");
        tclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tclearActionPerformed(evt);
            }
        });

        dap.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "diabetes", "asthma", "cancer", "allergies", "obesity" }));
        dap.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dapItemStateChanged(evt);
            }
        });

        jLabel14.setText("Assigned To");

        combo_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "diabetes mellitus", "diabetes inspidus", "breast cnacer", "skin cancer", "throat cancer", "prostate cancer" }));

        jLabel15.setText("Type");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(test, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(58, 58, 58)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_dno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                        .addComponent(pno_txt, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(avail_docs, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(dap, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(131, 131, 131)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(combo_type, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel10)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(tsave)
                        .addGap(28, 28, 28)
                        .addComponent(tclear)))
                .addContainerGap(511, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_dno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pno_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(dap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(combo_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avail_docs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tsave)
                    .addComponent(tclear, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(367, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Treatment  Details", jPanel2);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/icon_microscope.png"))); // NOI18N

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/Document-New-icon.png"))); // NOI18N
        jMenuItem1.setText("Patient Records");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/messages-icon2.png"))); // NOI18N
        jMenuItem2.setText("SMS Patient");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Message Records");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/logout-icon_small.png"))); // NOI18N
        jMenuItem6.setText("Logout");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        apdate.setText("Date");
        jMenuBar1.add(apdate);

        aptime.setText("Time");
        jMenuBar1.add(aptime);

        jMenu2.setText("Edit");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Edit/Update");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel13)
                .addGap(89, 89, 89))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(890, 890, 890))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addGap(12, 12, 12))
        );

        setSize(new java.awt.Dimension(1373, 1009));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pno_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pno_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pno_txtActionPerformed

    private void tclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tclearActionPerformed
         txt_dno.setText("");
         //pno_txt.setText("");
         //dap.setSelectedItem("");
         txt_descr.setText("");
         txt_rec.setText("");
    }//GEN-LAST:event_tclearActionPerformed

    private void psaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psaveActionPerformed
      
          try{
            String pno= txt_pno.getText().trim();
            String fname=pfname.getText().trim();
            String lname= plname.getText().trim();
//            String sql1 = "select Doc_No from doctors";
//            pst = conn.prepareStatement(sql1);
//            rs = pst.executeQuery(sql1);
//              while (rs.next()) {                  
//                  String DNO = rs.getString("Doc_No");
//                  att_docs.addItem(DNO);
//              }
//            String ass_to= att_docs.getSelectedItem().toString().trim();
            String date=((JTextField)dob.getDateEditor().getUiComponent()).getText();
            String gender= combo_gender.getSelectedItem().toString().trim();
            String phone= txt_phone.getText().trim();
            String area=txt_area.getSelectedItem().toString().trim();
            if(!StringUtils.isNullOrEmpty(pno) && !StringUtils.isNullOrEmpty(fname) && !StringUtils.isNullOrEmpty(lname) && !StringUtils.isNullOrEmpty(date) && !StringUtils.isNullOrEmpty(gender) && !StringUtils.isNullOrEmpty(phone) && !StringUtils.isNullOrEmpty(area)){
                if(PhoneNumberValidator.phone_validation(phone)){
                String sql="insert into patients values('"+pno+"','"+fname+"','"+lname+"','"+date+"','"+gender+"','"+phone+"','"+area+"')";
                pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Registration Successfull");
                }else{
                    error_pno.setText("Invalid Phone Number!!!");
                }
            } else{
                JOptionPane.showMessageDialog(null, "Please, Fill All The Fields!!!");
            }
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e);
       }
    }//GEN-LAST:event_psaveActionPerformed

    private void tsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tsaveActionPerformed
        /*try{
            String sql="insert into patient_treatment values(?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1, txt_dno.getText());
            pst.setString(2, pno_txt.getText());
            pst.setString(3, txt_disease.getText());
            pst.setString(4, txt_descr.getText());
            pst.setString(5, txt_rec.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Saved Successfully");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }*/
         try{
            /*txt_dno.setText("select Emp_No from user where Email=txt_mail.getText()");
            pst=conn.prepareStatement(txt_dno);
            pst.execute();*/
            String pno= txt_dno.getText().trim();
            String dno=pno_txt.getText().trim();
            String disease= dap.getSelectedItem().toString().trim();
            String ass_to = avail_docs.getSelectedItem().toString().trim();
            String descr= txt_descr.getText().trim();
            String recom=txt_rec.getText().trim();
            if(!StringUtils.isNullOrEmpty(pno) && !StringUtils.isNullOrEmpty(dno) && !StringUtils.isNullOrEmpty(disease) && !StringUtils.isNullOrEmpty(ass_to) && !StringUtils.isNullOrEmpty(descr) && !StringUtils.isNullOrEmpty(recom)){
                String sql="insert into treatment values('"+pno+"','"+dno+"','"+disease+"','"+ass_to+"','"+descr+"','"+recom+"')";
                pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Successfull Saved");
            } else{
                JOptionPane.showMessageDialog(null, "Please, Fill All The Fields!!!");
            }
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e);
       }
    }//GEN-LAST:event_tsaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       new Login().setVisible(true);
       dispose();
       JOptionPane.showMessageDialog(null, holdNames + " You Logged Out");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pfnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfnameKeyTyped
        char c=evt.getKeyChar();
       if((Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)){
           getToolkit();
           evt.consume();
       }
    }//GEN-LAST:event_pfnameKeyTyped

    private void plnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_plnameKeyTyped
        char c=evt.getKeyChar();
       if((Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)){
           getToolkit();
           evt.consume();
       }
    }//GEN-LAST:event_plnameKeyTyped

    private void txt_phoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_phoneKeyTyped
        char c=evt.getKeyChar();
       if(!(Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)){
           getToolkit();
           evt.consume();
       }
    }//GEN-LAST:event_txt_phoneKeyTyped

    private void txt_dnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_dnoMouseClicked
        //txt_dno.setText("");
    }//GEN-LAST:event_txt_dnoMouseClicked

    private void pno_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pno_txtMouseClicked
        //pno_txt.setText("");
    }//GEN-LAST:event_pno_txtMouseClicked

    private void txt_descrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_descrMouseClicked
        txt_descr.setText("");
    }//GEN-LAST:event_txt_descrMouseClicked

    private void txt_recMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_recMouseClicked
        txt_rec.setText("");
    }//GEN-LAST:event_txt_recMouseClicked

    private void pclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pclearActionPerformed
        //txt_pno.setText("");
        pfname.setText("");
        plname.setText("");
        txt_phone.setText("");
    }//GEN-LAST:event_pclearActionPerformed

    private void txt_pnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_pnoMouseClicked
        //txt_pno.setText("");
    }//GEN-LAST:event_txt_pnoMouseClicked

    private void pfnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pfnameMouseClicked
        pfname.setText("");
    }//GEN-LAST:event_pfnameMouseClicked

    private void plnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plnameActionPerformed
        plname.setText("");
    }//GEN-LAST:event_plnameActionPerformed

    private void txt_phoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_phoneMouseClicked
        txt_phone.setText("");
    }//GEN-LAST:event_txt_phoneMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new PatientRecords().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new HealthSMS().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new SwitchBoard().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new PatientMessages().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
       pno_txt.setText(txt_pno.getText());
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        //new PatientRecords().setVisible(true);
        //dispose();
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new PatientRecords().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void plnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plnameMouseClicked
       plname.setText("");
    }//GEN-LAST:event_plnameMouseClicked

    private void txt_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_phoneActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new Login().setVisible(true);
        dispose();
        JOptionPane.showMessageDialog(null, "You Logged Out");
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void txt_dnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dnoActionPerformed
        //txt_dno.setText(Eno.getText());
    }//GEN-LAST:event_txt_dnoActionPerformed

    private void dapItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dapItemStateChanged

    }//GEN-LAST:event_dapItemStateChanged

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
            java.util.logging.Logger.getLogger(AdmPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdmPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdmPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdmPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdmPatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu apdate;
    private javax.swing.JMenu aptime;
    private javax.swing.JComboBox avail_docs;
    private javax.swing.JComboBox combo_gender;
    private javax.swing.JComboBox combo_type;
    private javax.swing.JComboBox dap;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JLabel error_pno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton pclear;
    private javax.swing.JTextField pfname;
    private javax.swing.JTextField plname;
    public static javax.swing.JTextField pno_txt;
    private javax.swing.JButton psave;
    private javax.swing.JComboBox sele_doc;
    private javax.swing.JButton tclear;
    private javax.swing.JTextField test;
    private javax.swing.JButton tsave;
    private javax.swing.JComboBox txt_area;
    private javax.swing.JTextArea txt_descr;
    public static javax.swing.JTextField txt_dno;
    private javax.swing.JTextField txt_phone;
    public static javax.swing.JTextField txt_pno;
    private javax.swing.JTextArea txt_rec;
    // End of variables declaration//GEN-END:variables
}

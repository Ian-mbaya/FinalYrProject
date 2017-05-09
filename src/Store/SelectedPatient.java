/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Store;

import static Store.Login.holdNames;
import static Store.PatientRecords.hold;
import static Store.PatientRecords.namef;
import static Store.PatientRecords.namel;
import static Store.PatientRecords.nop;
import com.mysql.jdbc.StringUtils;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Kaboom
 */
public class SelectedPatient extends javax.swing.JFrame {
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    /**
     * Creates new form SelectedPatient
     */
    
     //    pre-populates Sub-counties
    public void prefillSubCounty(){   
        try {
            String county=(String)p_a.getItemAt(0);
//            String[] kksubs = new String[]{"Wamumu","Thiba","Nyangati","Mahigaini","Mutithi","Nguka","Kutus","Karira"};
            subcombo.addItem("Wamumu");
            subcombo.addItem("Thiba");
            subcombo.addItem("Nyangati");
            subcombo.addItem("Mahigaini");
            subcombo.addItem("Mutithi");
            subcombo.addItem("Nguka");
            subcombo.addItem("Kutus");
            subcombo.addItem("Karira");
        } catch (Exception e1) {
        }
    }
    
    public SelectedPatient() {
        initComponents();
        conn=DBConnection.ConnecrDB();
        TableUpdateP();
        TableUpdateT();
//        CurrentDateAndTime();
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Store/icons/H-2-icon.png"));
        setIconImage(img);
        
        tr_by.setText(holdNames);
        
//        populate the disease and type combobox
        try {
            String loggedin = Empnumber.getEno2();
            String sql = "select * from doctors where Doc_No = '"+loggedin+"' ";
            pst = conn.prepareStatement(sql);
            rs= pst.executeQuery();
            while (rs.next()) {                
                String d = rs.getString("Specialization");
                String t = rs.getString("type");
                combo_co.addItem(d);
                combo_ty.addItem(t);
            }
        } catch (Exception e) {
        }
        
         String ptt = "Patient: " + namef.getText() + " " + namel.getText();
         lb_pn.setText(ptt);
         
         //Handle County and sub-county Selection
           p_a.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
        try {
            String county = p_a.getSelectedItem().toString().trim();
            if (county.equalsIgnoreCase("Kakamega")) {
               subcombo.removeAllItems();
               subcombo.addItem("Lurambi");
               subcombo.addItem("Lugari");
               subcombo.addItem("Likunyani");
               subcombo.addItem("Navakholo");
               subcombo.addItem("Butere");
               subcombo.addItem("Mumias East");
               subcombo.addItem("Mumias West");
               subcombo.addItem("Matungu");
               subcombo.addItem("Khwisero");
               subcombo.addItem("Ikolomani");
               subcombo.addItem("Malava");
               subcombo.addItem("Shinyalu");
            }else{
                subcombo.removeAllItems();
                subcombo.addItem("Wamumu");
                subcombo.addItem("Thiba");
                subcombo.addItem("Nyangati");
                subcombo.addItem("Mahigaini");
                subcombo.addItem("Mutithi");
                subcombo.addItem("Nguka");
                subcombo.addItem("Kutus");
                subcombo.addItem("Karira");
            }
        } catch (Exception e1) {
        }
            }
        });
    }
    
    public void CurrentDateAndTime(){
        Thread clock= new Thread(){
            public void run(){
                for(;;){
        Calendar cal=new GregorianCalendar();
        int yr=cal.get(Calendar.YEAR);
        int mnth=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        date.setText("Date "+yr+"/"+(mnth + 1)+"/"+day);
        
        int sec=cal.get(Calendar.SECOND);
        int min=cal.get(Calendar.MINUTE);
        int hr=cal.get(Calendar.HOUR);
        time.setText("Time "+hr+":"+min+":"+sec); 
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
    
     public void TableUpdateP(){
        try{
            String sql="select * from patients where Patient_No='"+nop.getText()+"' ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            select_PTable.setModel(DbUtils.resultSetToTableModel(rs));
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
     
      public void TableUpdateT(){
        try{
            String sql="select * from Admission_details where Patient_No='"+nop.getText()+"' ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            select_Table.setModel(DbUtils.resultSetToTableModel(rs));
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btn_back = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        select_PTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        p_n = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        f_n = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        l_n = new javax.swing.JTextField();
        p_pn = new javax.swing.JTextField();
        g_combo = new javax.swing.JComboBox();
        p_d = new com.toedter.calendar.JDateChooser();
        p_a = new javax.swing.JComboBox();
        P_update = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        p_msg = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        p_msgtxt = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btn_print = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        btn_srch = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        txt_dlt = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        subcombo = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        select_Table = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        pa_no = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tr_by = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_msg = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        pno_T = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txt_mT = new javax.swing.JTextArea();
        btn_smsT = new javax.swing.JButton();
        btn_clrsmsT = new javax.swing.JButton();
        btn_sendT = new javax.swing.JButton();
        combo_co = new javax.swing.JComboBox();
        combo_ty = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lb_pn = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        date = new javax.swing.JMenu();
        time = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/lightbox-prev.png"))); // NOI18N
        btn_back.setFocusable(false);
        btn_back.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_back.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_back);

        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/logout-icon_small.png"))); // NOI18N
        btn_logout.setFocusable(false);
        btn_logout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_logout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_logout);

        select_PTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        select_PTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                select_PTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(select_PTable);

        jLabel1.setText("Edit/update");

        jLabel2.setText("Patient Number");

        jLabel3.setText("First Name");

        jLabel4.setText("Last Name");

        jLabel5.setText("DOB");

        jLabel6.setText("Gender");

        jLabel7.setText("Phone Number");

        jLabel8.setText("County");

        p_pn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_pnActionPerformed(evt);
            }
        });

        g_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

        p_a.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kirinyaga", "Kakamega" }));

        P_update.setText("Update");
        P_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P_updateActionPerformed(evt);
            }
        });

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Send SMS");

        p_msg.setEditable(false);

        p_msgtxt.setColumns(20);
        p_msgtxt.setRows(5);
        jScrollPane1.setViewportView(p_msgtxt);

        jLabel10.setText("Phone Number");

        jLabel11.setText("Message");

        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Clear");

        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/Printer-icon2.png"))); // NOI18N
        btn_print.setFocusable(false);
        btn_print.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_print.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });

        btn_srch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/search-icon.png"))); // NOI18N
        btn_srch.setText("Search");
        btn_srch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_srchActionPerformed(evt);
            }
        });

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/File-Delete-icon.png"))); // NOI18N
        btn_delete.setFocusable(false);
        btn_delete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_delete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/File-Delete-icon.png"))); // NOI18N
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel22.setText("Sub-County");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton3))
                        .addGap(1049, 1049, 1049))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_srch)
                        .addGap(159, 159, 159)
                        .addComponent(btn_print)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_delete)
                        .addGap(190, 190, 190)
                        .addComponent(txt_dlt, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel22))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(p_a, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(f_n)
                                            .addComponent(l_n)
                                            .addComponent(p_pn)
                                            .addComponent(g_combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(p_d, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(p_n, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(P_update)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton2))
                                            .addComponent(subcombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                        .addGap(26, 26, 26)
                                        .addComponent(p_msg, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_srch)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_print, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_dlt)
                                .addComponent(jButton4)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p_n, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(f_n, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_n, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(p_d, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(g_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(p_pn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(p_a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(subcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(P_update)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(p_msg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(67, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Personal Details", jPanel1);

        select_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(select_Table);

        jLabel12.setText("Patient Number");

        pa_no.setEditable(false);

        jLabel13.setText("Treated By");

        tr_by.setEditable(false);

        jLabel14.setText("Disease/Condition");

        jLabel15.setText("Type");

        jLabel16.setText("Recommendation(s)");

        txt_msg.setColumns(20);
        txt_msg.setRows(5);
        jScrollPane4.setViewportView(txt_msg);

        jLabel17.setText("SMS Patient");

        jLabel18.setText("Phone Number");

        pno_T.setEditable(false);

        jLabel19.setText("Message");

        txt_mT.setColumns(20);
        txt_mT.setRows(5);
        jScrollPane5.setViewportView(txt_mT);

        btn_smsT.setText("Send");
        btn_smsT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_smsTActionPerformed(evt);
            }
        });

        btn_clrsmsT.setText("Clear");
        btn_clrsmsT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clrsmsTActionPerformed(evt);
            }
        });

        btn_sendT.setText("Send");
        btn_sendT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendTActionPerformed(evt);
            }
        });

        jLabel20.setText("Prescription(s)");

        jLabel21.setText("or");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(pno_T, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_smsT)
                            .addComponent(btn_clrsmsT)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(pa_no, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                            .addComponent(tr_by)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(combo_ty, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(combo_co, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(btn_sendT)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 972, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(113, 113, 113))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(pa_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(tr_by, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(combo_co, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(combo_ty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel20)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel21)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel16)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_sendT)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pno_T, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(btn_smsT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_clrsmsT))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Treatment Details", jPanel2);

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/lightbox-prev.png"))); // NOI18N
        jMenuItem1.setText("Back");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Store/icons/logout-icon_small.png"))); // NOI18N
        jMenuItem2.setText("Logout");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        date.setText("Date");
        jMenuBar1.add(date);

        time.setText("Time");
        jMenuBar1.add(time);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lb_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(280, 280, 280)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_pn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void select_PTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_select_PTableMouseClicked
        try{
            int row=select_PTable.getSelectedRow();
            String T_click=(select_PTable.getModel().getValueAt(row, 0).toString());
            String sql="select * from patients where Patient_No='"+T_click+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                String pnos=rs.getString("Patient_No");
                p_n.setText(pnos);
                pa_no.setText(pnos);
                String fn=rs.getString("Fname");
                f_n.setText(fn);
                String ln=rs.getString("Lname");
                l_n.setText(ln);
                String dob=rs.getString("DOB");
                ((JTextField)p_d.getDateEditor().getUiComponent()).setText(dob);
                String gd=rs.getString("Gender");
                g_combo.setSelectedItem(gd);
                String phone=rs.getString("Phone_Number");
                p_pn.setText(phone);
                p_msg.setText(phone);
                pno_T.setText(phone);
                String area=rs.getString("County");
                p_a.setSelectedItem(area);
                String sub=rs.getString("Sub_County");
                subcombo.setSelectedItem(sub);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        TableUpdateP();
    }//GEN-LAST:event_select_PTableMouseClicked

    private void P_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P_updateActionPerformed
        try{
            String pn= p_n.getText().trim();
            String fname=f_n.getText().trim();
            String lname= l_n.getText().trim();
            String dob=((JTextField)p_d.getDateEditor().getUiComponent()).getText();
            String gender= g_combo.getSelectedItem().toString().trim();
            String phone= p_pn.getText().trim();
            String area=p_a.getSelectedItem().toString().trim(); 
            String sub=subcombo.getSelectedItem().toString().trim(); 
            String sql="update patients set Patient_No='"+pn+"' ,Fname='"+fname+"' ,Lname='"+lname+"' ,DOB='"+dob+"' "
                    + ",Gender='"+gender+"' ,Phone_Number='"+phone+"' ,County='"+area+"' ,Sub_County='"+sub+"' where Patient_No='"+pn+"'";
            pst=conn.prepareStatement(sql);
           pst.execute();
           JOptionPane.showMessageDialog(null, "Record Successfully Updated");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
       TableUpdateP();
    }//GEN-LAST:event_P_updateActionPerformed

    private void btn_sendTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendTActionPerformed
        try {
            String no = pa_no.getText().trim();
            String treated_by = tr_by.getText().trim();
            String disease = combo_co.getSelectedItem().toString().trim();
            String type = combo_ty.getSelectedItem().toString().trim();
            String presc = txt_msg.getText();
            if (!StringUtils.isNullOrEmpty(no) && !StringUtils.isNullOrEmpty(treated_by) && !StringUtils.isNullOrEmpty(disease) && !StringUtils.isNullOrEmpty(presc)) {
                String sql="insert into treatment values('"+no+"','"+treated_by+"','"+disease+"','"+type+"','"+presc+"')";
                pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Successfully Saved");
            }else{
                JOptionPane.showMessageDialog(null, "Please, Fill all the required fields");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_sendTActionPerformed

    private void btn_smsTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_smsTActionPerformed
        // Specify your login credentials
             String username = "sheldon";
             String apiKey   = "a96461493f41f452edb727ae33e8fca45fc983a331ce2ea452451f2c3e68976c";
        
             // Specify the numbers that you want to send to in a comma-separated list
             // Please ensure you include the country code (+254 for Kenya in this case)
             String recipients = "+254"+pno_T.getText();
        
             // And of course we want our recipients to know what we really do
             //String message = "We are lumberjacks. We code all day and sleep all night";
             String message =txt_mT.getText();
        
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
                      JOptionPane.showMessageDialog(null, "Message Sent Successfully"); 
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
    }//GEN-LAST:event_btn_smsTActionPerformed

    private void btn_clrsmsTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clrsmsTActionPerformed
        txt_mT.setText("");
    }//GEN-LAST:event_btn_clrsmsTActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        p_n.setText("");
        f_n.setText("");
        l_n.setText("");
        p_pn.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Specify your login credentials
             String username = "sheldon";
             String apiKey   = "a96461493f41f452edb727ae33e8fca45fc983a331ce2ea452451f2c3e68976c";
        
             // Specify the numbers that you want to send to in a comma-separated list
             // Please ensure you include the country code (+254 for Kenya in this case)
             String recipients = "+254"+p_msg.getText();
        
             // And of course we want our recipients to know what we really do
             //String message = "We are lumberjacks. We code all day and sleep all night";
             String message =p_msgtxt.getText();
        
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
                      JOptionPane.showMessageDialog(null, "Message Sent Successfully"); 
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        new PatientRecords().setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        MessageFormat header= new MessageFormat("Medical Report");
        MessageFormat footer= new MessageFormat("page{0,number,integer}");
        try{
            select_PTable.print(JTable.PrintMode.NORMAL, header, footer);
        }catch(java.awt.print.PrinterException pe){
            System.err.format("Cannot Print",pe.getMessage());
        }
    }//GEN-LAST:event_btn_printActionPerformed

    private void btn_srchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_srchActionPerformed
        try{
            
            String src="select * from patients where Patient_No=?";
            pst=conn.prepareStatement(src);
            pst.setString(1, txt_search.getText());
            rs=pst.executeQuery();
            if(rs.next()){
                String pnos=rs.getString("Patient_No");
                p_n.setText(pnos);
                String fn=rs.getString("Fname");
                f_n.setText(fn);
                String ln=rs.getString("Lname");
                l_n.setText(ln);
                String dob=rs.getString("DOB");
                ((JTextField)p_d.getDateEditor().getUiComponent()).setText(dob);
                String gd=rs.getString("Gender");
                g_combo.setSelectedItem(gd);
                String phone=rs.getString("Phone_Number");
                p_pn.setText(phone);
                String area=rs.getString("County");
                p_a.setSelectedItem(area);
                String sub=rs.getString("Sub_County");
                subcombo.setSelectedItem(sub);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        TableUpdateP();
    }//GEN-LAST:event_btn_srchActionPerformed

    private void p_pnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_pnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p_pnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int d=JOptionPane.showConfirmDialog(null, "Do You Really Want To Delete???", "Delete", JOptionPane.YES_NO_OPTION);
       if(d==0){
        try{
           String sql="delete from patients where Patient_No=?";
           pst=conn.prepareStatement(sql);
           pst.setString(1, txt_dlt.getText());
           pst.execute();
           JOptionPane.showMessageDialog(null, "Deleted");
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Couldn't Delete");
       }
        finally{
           try{
               pst.close();
               rs.close();
           }catch(Exception e){
               
           }
       }
       }
       TableUpdateP();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int d=JOptionPane.showConfirmDialog(null, "Do You Really Want To Delete???", "Delete", JOptionPane.YES_NO_OPTION);
       if(d==0){
        try{
           String sql="delete from patients where Patient_No=?";
           pst=conn.prepareStatement(sql);
           pst.setString(1, txt_dlt.getText());
           pst.execute();
           JOptionPane.showMessageDialog(null, "Deleted");
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
       TableUpdateP();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new PatientRecords().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        new Login().setVisible(true);
        dispose();
        JOptionPane.showMessageDialog(null, "You Logged Out");
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        new Login().setVisible(true);
        dispose();
        JOptionPane.showMessageDialog(null, "You Logged Out");
    }//GEN-LAST:event_jMenu1ActionPerformed

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
            java.util.logging.Logger.getLogger(SelectedPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectedPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectedPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectedPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectedPatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton P_update;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_clrsmsT;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_sendT;
    private javax.swing.JButton btn_smsT;
    private javax.swing.JButton btn_srch;
    private javax.swing.JComboBox combo_co;
    private javax.swing.JComboBox combo_ty;
    private javax.swing.JMenu date;
    private javax.swing.JTextField f_n;
    private javax.swing.JComboBox g_combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField l_n;
    private javax.swing.JLabel lb_pn;
    private javax.swing.JComboBox p_a;
    private com.toedter.calendar.JDateChooser p_d;
    private javax.swing.JTextField p_msg;
    private javax.swing.JTextArea p_msgtxt;
    private javax.swing.JTextField p_n;
    private javax.swing.JTextField p_pn;
    private javax.swing.JTextField pa_no;
    private javax.swing.JTextField pno_T;
    private javax.swing.JTable select_PTable;
    private javax.swing.JTable select_Table;
    private javax.swing.JComboBox subcombo;
    private javax.swing.JMenu time;
    private javax.swing.JTextField tr_by;
    private javax.swing.JTextField txt_dlt;
    private javax.swing.JTextArea txt_mT;
    private javax.swing.JTextArea txt_msg;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}

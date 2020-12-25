package inf;

import codes.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public final class DoctorInfo extends javax.swing.JFrame {
    
    Connection mahesh = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
              
public DoctorInfo() {
        initComponents();
        mahesh = DBconnect.connect();
        tableDataLoad();
    }

public void tableDataLoad(){

    try {
        String sql = "select id, fname,lname,age,gender,department,pnum,wardno from doctorr";
         
        pst = mahesh.prepareStatement(sql);
        rs = pst.executeQuery();
        table2.setModel(DbUtils.resultSetToTableModel(rs));
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}

public void tableData(){

    int r = table2.getSelectedRow();
    
    String id = table2.getValueAt(r, 0).toString();
    String fname= table2.getValueAt(r, 1).toString();
    String lname= table2.getValueAt(r, 2).toString();
    String age = table2.getValueAt(r, 3).toString();
    String gender = table2.getValueAt(r, 4).toString();
    
    String department= table2.getValueAt(r, 5).toString();
    String phonenum= table2.getValueAt(r,6).toString();
    String wardno= table2.getValueAt(r, 7).toString();
    
    
    idbox.setText(id);
    
    fnamebox.setText(fname);
    lnamebox.setText(lname);
    agebox.setText(age);
    genderbox.setSelectedItem(gender);  
    
    
    departmentbox.setSelectedItem(department);
    phonebox.setText(phonenum);
    wardnobox.setText(wardno);
}

public void search(){

String searchh = searchbox.getText();
        
    try {
        String sql = "SELECT * from doctorr WHERE fname LIKE '%"+searchh+"%' OR lname LIKE '%"+searchh+"%' OR id LIKE '%"+searchh+"%' " ; //search only set up name and id
        pst = mahesh.prepareStatement(sql);
        rs = pst.executeQuery();
        table2.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    } 

}

public void update(){
    //can be updated any values
    String id = idbox.getText();
    String fname= fnamebox.getText();
    String lname= lnamebox.getText();
    String age = agebox.getText();
    String gender = genderbox.getSelectedItem().toString();
   
    
    String department=departmentbox.getSelectedItem().toString();
    String phonenumber= phonebox.getText();
    String wardno =  wardnobox.getText();
    
    //used try catch method beacause can be happend more erorrs
    try {
        String sql = "UPDATE doctorr SET fname='"+fname+"', lname='"+lname+"',age='"+age+"',gender='"+gender+"',department='"+department+"',phonenumber='"+phonenumber+"',wardno='"+wardno+"' WHERE id='"+id+"'";
        pst = mahesh.prepareStatement(sql);
        pst.execute();
        JOptionPane.showMessageDialog(null, "Update is succesful ");
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Not updated");
    }  

}
public void clear(){
    searchbox.setText("");
    idbox.setText("100");
    fnamebox.setText(""); lnamebox.setText("");
    agebox.setText("");
    genderbox.setSelectedItem(1);
    
    departmentbox.setSelectedItem(6);
    phonebox.setText("");
    wardnobox.setText("");


}
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fnamebox = new javax.swing.JTextField();
        agebox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lnamebox = new javax.swing.JTextField();
        wardnobox = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        departmentbox = new javax.swing.JComboBox<String>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        phonebox = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        updatebtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        insertbtn = new javax.swing.JButton();
        genderbox = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        idbox = new javax.swing.JLabel();
        i = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        exitbtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        searchbox = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(java.awt.SystemColor.activeCaption);
        jPanel5.setForeground(new java.awt.Color(153, 153, 153));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Gender");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 20));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("First name");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 30));

        fnamebox.setToolTipText("Enter your name");
        fnamebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameboxActionPerformed(evt);
            }
        });
        jPanel5.add(fnamebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 130, 30));

        agebox.setToolTipText("Enter your age");
        agebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageboxActionPerformed(evt);
            }
        });
        jPanel5.add(agebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 60, 30));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Age");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 30));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Last name");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 30));

        lnamebox.setToolTipText("Enter your name");
        lnamebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameboxActionPerformed(evt);
            }
        });
        jPanel5.add(lnamebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 130, 30));

        wardnobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wardnoboxActionPerformed(evt);
            }
        });
        jPanel5.add(wardnobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 80, -1));

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Department");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        departmentbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Department", "Medecine", "Dental", "Gynaecology", "Nutrition", "Neurology", "Cardiology", "Haematology", "Microbiology" }));
        departmentbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentboxActionPerformed(evt);
            }
        });
        jPanel5.add(departmentbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, -1, -1));

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Phone Number");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("ward / room no");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        phonebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneboxActionPerformed(evt);
            }
        });
        jPanel5.add(phonebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 120, -1));

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DOCTORS DATA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tempus Sans ITC", 1, 14), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(0, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        updatebtn.setBackground(new java.awt.Color(153, 153, 153));
        updatebtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updatebtn.setText("UPDATE");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        jPanel6.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 90, 40));

        deletebtn.setBackground(new java.awt.Color(153, 153, 153));
        deletebtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deletebtn.setText("DELETE");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        jPanel6.add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 90, 40));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 150, 130));

        clearbtn.setBackground(new java.awt.Color(51, 153, 255));
        clearbtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        clearbtn.setText("CLEAR");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });
        jPanel5.add(clearbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 80, 40));

        insertbtn.setBackground(new java.awt.Color(51, 153, 255));
        insertbtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        insertbtn.setText("ADD DOCTOR");
        insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtnActionPerformed(evt);
            }
        });
        jPanel5.add(insertbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 110, 40));

        genderbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Gender", "Male", "Female" }));
        genderbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderboxActionPerformed(evt);
            }
        });
        jPanel5.add(genderbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 70, 20));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idbox.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        idbox.setText("ID");
        jPanel3.add(idbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -20, 30, 70));

        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 40, 30));

        i.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        i.setForeground(new java.awt.Color(51, 0, 51));
        i.setText("DOCTOR ID  : ");
        jPanel5.add(i, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 200, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/doctor.png"))); // NOI18N
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 50, 50));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 400, 540));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 540));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table2.setBackground(new java.awt.Color(0, 153, 153));
        table2.setModel(new javax.swing.table.DefaultTableModel(
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
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        table2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table2KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(table2);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 540, 370));

        exitbtn.setBackground(new java.awt.Color(153, 153, 153));
        exitbtn.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        exitbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cross.png"))); // NOI18N
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });
        jPanel4.add(exitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 480, 60, 50));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/backs.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, 60, 50));

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel5.setText("DEATAILS");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 150, 20));

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 102));
        jLabel4.setText("DOCTORS");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 230, 100));

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)), "SEARCH", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchbox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchbox.setToolTipText("Search");
        searchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchboxActionPerformed(evt);
            }
        });
        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });
        jPanel8.add(searchbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, 30));

        jButton3.setBackground(new java.awt.Color(204, 255, 204));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchpatient.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 60, 40));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 240, 70));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 100));

        jToggleButton1.setBackground(new java.awt.Color(102, 102, 102));
        jToggleButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jToggleButton1.setText("DOCTOR ACTIVITY");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, -1, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 540, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
        search();
    }//GEN-LAST:event_searchboxKeyReleased

    private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchboxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        AdminDoctoLog ob = new AdminDoctoLog();
        ob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void table2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table2KeyReleased
        tableData();
    }//GEN-LAST:event_table2KeyReleased

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked

        tableData();
    }//GEN-LAST:event_table2MouseClicked

    private void genderboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderboxActionPerformed

    private void insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtnActionPerformed

        String fname;
        String lname;
        int age;
        String gender;

        String department;
        int phonenumber;
        int wardno;

        fname = fnamebox.getText();
        lname = lnamebox.getText();
        age =  Integer.parseInt(agebox.getText());  //converting integer
        gender = (String) genderbox.getSelectedItem();

        department = (String) departmentbox.getSelectedItem();
        phonenumber =Integer.parseInt(phonebox.getText());
        wardno =Integer.parseInt(wardnobox.getText());

        try {

            String sql = "INSERT INTO doctorr (fname,lname,age,gender,department,wardno,pnum) VALUES ('"+fname+"','"+lname+"','"+age+"','"+gender+"','"+department+"','"+wardno+"','"+phonenumber+"')" ;
            pst = mahesh.prepareStatement(sql); // run quary
            pst.execute();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,e);
        }
        tableDataLoad();
    }//GEN-LAST:event_insertbtnActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        clear();
    }//GEN-LAST:event_clearbtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed

        int check = JOptionPane.showConfirmDialog(null," Do you want to delete any value!!");

        if(check==0){
            String id = idbox.getText();

            try {
                String sql = "DELETE FROM doctorr WHERE id='"+id+"'";
                pst = mahesh.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Succesfully deleted");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Unsuccesfully deleted");
            }

        }
        tableDataLoad();
        clear();
    }//GEN-LAST:event_deletebtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        update();
        tableDataLoad();
    }//GEN-LAST:event_updatebtnActionPerformed

    private void phoneboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneboxActionPerformed

    private void departmentboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentboxActionPerformed

    }//GEN-LAST:event_departmentboxActionPerformed

    private void wardnoboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wardnoboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wardnoboxActionPerformed

    private void lnameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameboxActionPerformed

    }//GEN-LAST:event_lnameboxActionPerformed

    private void ageboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageboxActionPerformed

    private void fnameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameboxActionPerformed

    }//GEN-LAST:event_fnameboxActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        
        
       Doctoract ob = new Doctoract();
        ob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed

        System.exit(0);
    }//GEN-LAST:event_exitbtnActionPerformed

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
            java.util.logging.Logger.getLogger(DoctorInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agebox;
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JComboBox<String> departmentbox;
    private javax.swing.JButton exitbtn;
    private javax.swing.JTextField fnamebox;
    private javax.swing.JComboBox genderbox;
    private javax.swing.JLabel i;
    private javax.swing.JLabel idbox;
    private javax.swing.JButton insertbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField lnamebox;
    private javax.swing.JTextField phonebox;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTable table2;
    private javax.swing.JButton updatebtn;
    private javax.swing.JTextField wardnobox;
    // End of variables declaration//GEN-END:variables
}

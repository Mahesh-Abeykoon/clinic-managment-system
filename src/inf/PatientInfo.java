package inf;

import codes.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public final class PatientInfo extends javax.swing.JFrame {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
              
public PatientInfo() {
        initComponents();
        conn = DBconnect.connect();
        tableDataLoad();
    }

public void tableDataLoad(){

    try {
        String sql = "select id,fname,lname,age,gender,address,maritial,phonenumber,disease from pationt";
         
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        table1.setModel(DbUtils.resultSetToTableModel(rs));
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}

public void tableData(){

    int r = table1.getSelectedRow();
    
    String id = table1.getValueAt(r, 0).toString();
    String fname= table1.getValueAt(r, 1).toString();
    String lname= table1.getValueAt(r, 2).toString();
    String age = table1.getValueAt(r, 3).toString();
    String gender = table1.getValueAt(r, 4).toString();
    
    String address= table1.getValueAt(r, 5).toString();
    String maritial= table1.getValueAt(r,6).toString();
    String phonenum= table1.getValueAt(r, 7).toString();
    String disease= table1.getValueAt(r, 8).toString();
    
    idbox.setText(id);
    
    fnamebox.setText(fname);
    lnamebox.setText(lname);
    agebox.setText(age);
    genderbox1.setSelectedItem(gender);  
    
    addressbox.setText(address);
    maritialbox.setSelectedItem(maritial);
    phonebox.setText(phonenum);
    diseasebox.setText(disease);
}

public void search(){

String searchh = searchbox.getText();
        
    try {
        String sql = "SELECT * from pationt WHERE fname LIKE '%"+searchh+"%' OR lname LIKE '%"+searchh+"%' OR id LIKE '%"+searchh+"%' " ; //search only set up name and id
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        table1.setModel(DbUtils.resultSetToTableModel(rs));
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
    String gender = genderbox1.getSelectedItem().toString();
   
    String address= addressbox.getText();
    String maritial=maritialbox.getSelectedItem().toString();
    String phonenumber= phonebox.getText();
    String disease =  diseasebox.getText();
    
    //used try catch method beacuse can be happend more erorrs
    try {
        String sql = "UPDATE pationt SET fname='"+fname+"', lname='"+lname+"',age='"+age+"',gender='"+gender+"',address='"+address+"',maritial='"+maritial+"',phonenumber='"+phonenumber+"',disease='"+disease+"' WHERE id='"+id+"'";
        pst = conn.prepareStatement(sql);
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
    genderbox1.setSelectedItem(1);
    addressbox.setText("");
    maritialbox.setSelectedItem(1);
    phonebox.setText("");
    diseasebox.setText("");


}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        exitbtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        searchbox = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        idbox = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        i = new javax.swing.JLabel();
        fnamebox = new javax.swing.JTextField();
        agebox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lnamebox = new javax.swing.JTextField();
        diseasebox = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        maritialbox = new javax.swing.JComboBox<String>();
        Gender = new javax.swing.JLabel();
        addressbox = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        phonebox = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        updatebtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        insertbtn = new javax.swing.JButton();
        genderbox1 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table1.setBackground(new java.awt.Color(153, 255, 204));
        table1.setModel(new javax.swing.table.DefaultTableModel(
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
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table1KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(table1);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 530, 370));

        exitbtn.setBackground(new java.awt.Color(204, 204, 204));
        exitbtn.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        exitbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cross.png"))); // NOI18N
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });
        jPanel4.add(exitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 60, 50));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/backs.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 60, 50));

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel5.setText("DEATAILS");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 53, 150, 20));

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 102));
        jLabel4.setText("PATIENT    ");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 80));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)), "SEARCH", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel2.add(searchbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, 30));

        jPanel7.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 170, 60));

        jButton3.setBackground(new java.awt.Color(204, 255, 204));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchpatient.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 60, 40));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 80));

        jButton4.setBackground(new java.awt.Color(153, 153, 153));
        jButton4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jButton4.setText("PATIENT ACTIVITY");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 460, 210, 50));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 560, 520));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));
        jPanel5.setForeground(new java.awt.Color(153, 153, 153));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idbox.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        idbox.setText("ID");
        jPanel3.add(idbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -20, 30, 70));

        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 40, 30));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gender");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 20));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("First name");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 30));

        i.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        i.setForeground(new java.awt.Color(51, 0, 51));
        i.setText("PATIENT ID : ");
        jPanel5.add(i, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, 30));

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
        agebox.getAccessibleContext().setAccessibleName("");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Age");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 30));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Last name");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 30));

        lnamebox.setToolTipText("Enter your name");
        lnamebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameboxActionPerformed(evt);
            }
        });
        jPanel5.add(lnamebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 130, 30));

        diseasebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diseaseboxActionPerformed(evt);
            }
        });
        jPanel5.add(diseasebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 80, -1));
        diseasebox.getAccessibleContext().setAccessibleName("");
        diseasebox.getAccessibleContext().setAccessibleDescription("Disease");

        jLabel9.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Maritial Status");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        maritialbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Item", "Single", "Married", "Divorced" }));
        maritialbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maritialboxActionPerformed(evt);
            }
        });
        jPanel5.add(maritialbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, -1, -1));

        Gender.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        Gender.setForeground(new java.awt.Color(255, 255, 255));
        Gender.setText("Address");
        jPanel5.add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        addressbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressboxActionPerformed(evt);
            }
        });
        jPanel5.add(addressbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 240, 30));
        addressbox.getAccessibleContext().setAccessibleName("Address");
        addressbox.getAccessibleContext().setAccessibleDescription("");

        jLabel10.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Phone number");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel11.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Disease name");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        phonebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneboxActionPerformed(evt);
            }
        });
        jPanel5.add(phonebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 120, -1));
        phonebox.getAccessibleContext().setAccessibleName("");
        phonebox.getAccessibleContext().setAccessibleDescription("Phone Number");

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PATIENT DATA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tempus Sans ITC", 1, 14), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(0, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        updatebtn.setBackground(new java.awt.Color(102, 153, 255));
        updatebtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updatebtn.setText("UPDATE");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        jPanel6.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 90, 40));
        updatebtn.getAccessibleContext().setAccessibleName("");
        updatebtn.getAccessibleContext().setAccessibleDescription("Update bar");

        deletebtn.setBackground(new java.awt.Color(102, 153, 255));
        deletebtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deletebtn.setText("DELETE");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        jPanel6.add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 90, 40));
        deletebtn.getAccessibleContext().setAccessibleName("");
        deletebtn.getAccessibleContext().setAccessibleDescription("Delete bar");

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 150, 140));

        clearbtn.setBackground(new java.awt.Color(0, 153, 204));
        clearbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clearbtn.setText("CLEAR");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });
        jPanel5.add(clearbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 80, 40));

        insertbtn.setBackground(new java.awt.Color(0, 153, 204));
        insertbtn.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        insertbtn.setText("ADD PATIENT");
        insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtnActionPerformed(evt);
            }
        });
        jPanel5.add(insertbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 110, 40));
        insertbtn.getAccessibleContext().setAccessibleName("");
        insertbtn.getAccessibleContext().setAccessibleDescription("Add bar");

        genderbox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Gender", "Male", "Female" }));
        genderbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderbox1ActionPerformed(evt);
            }
        });
        jPanel5.add(genderbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 70, 20));
        genderbox1.getAccessibleContext().setAccessibleName("Select Gender");

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/patient.png"))); // NOI18N
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 50, 50));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 390, 520));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        clear();
    }//GEN-LAST:event_clearbtnActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
        
        System.exit(0);
        
        
    }//GEN-LAST:event_exitbtnActionPerformed

    private void fnameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameboxActionPerformed

    }//GEN-LAST:event_fnameboxActionPerformed

    private void insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtnActionPerformed
       
        String fname;
        String lname;
        int age;
        String gender;
        String address;
        String maritial;
        int phonenumber;
        String disease;
                
       fname = fnamebox.getText();
       lname = lnamebox.getText();
       age =  Integer.parseInt(agebox.getText());  //converting integer
       gender = (String) genderbox1.getSelectedItem();
       address= addressbox.getText();
       maritial = (String) maritialbox.getSelectedItem();
       phonenumber =Integer.parseInt(phonebox.getText());
       disease = diseasebox.getText();
       
        try {
            
            String sql = "INSERT INTO pationt (fname,lname,age,gender,address,maritial,phonenumber,disease) VALUES ('"+fname+"','"+lname+"','"+age+"','"+gender+"','"+address+"','"+maritial+"','"+phonenumber+"','"+disease+"')" ;
            pst = conn.prepareStatement(sql); // run quary
            pst.execute();
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,e);
        }
        tableDataLoad();
    }//GEN-LAST:event_insertbtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
       update();
       tableDataLoad();
        
        
    }//GEN-LAST:event_updatebtnActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        
        
        tableData();
    }//GEN-LAST:event_table1MouseClicked

    private void table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyReleased
        tableData();
    }//GEN-LAST:event_table1KeyReleased

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
      
        
        int check = JOptionPane.showConfirmDialog(null," Do you want to delete any value!!");
        
        if(check==0){
            String id = idbox.getText();
            
            try {
                String sql = "DELETE FROM pationt WHERE id='"+id+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Succesfully deleted");
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Unsuccesfully deleted");
            }
        
            
        }
        tableDataLoad();
        clear();
    }//GEN-LAST:event_deletebtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        AdminLog ob = new AdminLog();
        ob.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lnameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameboxActionPerformed
       
    }//GEN-LAST:event_lnameboxActionPerformed

    private void maritialboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maritialboxActionPerformed

    }//GEN-LAST:event_maritialboxActionPerformed

    private void phoneboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneboxActionPerformed

    private void diseaseboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diseaseboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diseaseboxActionPerformed

    private void addressboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressboxActionPerformed

    private void ageboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageboxActionPerformed

    private void genderbox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderbox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderbox1ActionPerformed

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
        search();
    }//GEN-LAST:event_searchboxKeyReleased

    private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchboxActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         
       Patientact ob = new Patientact();
        ob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(PatientInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Gender;
    private javax.swing.JTextField addressbox;
    private javax.swing.JTextField agebox;
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JTextField diseasebox;
    private javax.swing.JButton exitbtn;
    private javax.swing.JTextField fnamebox;
    private javax.swing.JComboBox genderbox1;
    private javax.swing.JLabel i;
    private javax.swing.JLabel idbox;
    private javax.swing.JButton insertbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lnamebox;
    private javax.swing.JComboBox<String> maritialbox;
    private javax.swing.JTextField phonebox;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTable table1;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
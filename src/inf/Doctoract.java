package inf;

import codes.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public final class Doctoract extends javax.swing.JFrame {
    
    Connection mahesh = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
              
public Doctoract() {
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


    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        i = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        searchbox = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        idbox = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        i.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        i.setForeground(new java.awt.Color(51, 0, 51));
        i.setText("DOCTOR ID  : ");
        jPanel2.add(i, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 130, 40));

        table2.setBackground(new java.awt.Color(0, 102, 153));
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

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 490, 300));

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 102));
        jLabel4.setText("Doctor ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 80));

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

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 240, 70));

        idbox.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        idbox.setText("ID");
        jPanel2.add(idbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 30, 80));

        jButton1.setBackground(new java.awt.Color(0, 51, 51));
        jButton1.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jButton1.setText("B A C K");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, 90, 40));

        exitbtn.setBackground(new java.awt.Color(255, 102, 102));
        exitbtn.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        exitbtn.setText("E X I T");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });
        jPanel2.add(exitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, 90, 40));

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        jLabel1.setText("Activity");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 140, 80));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 140, 120));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
        search();
    }//GEN-LAST:event_searchboxKeyReleased

    private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchboxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DoctorInfo ob = new DoctorInfo();
        ob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed

        System.exit(0);
    }//GEN-LAST:event_exitbtnActionPerformed

    private void table2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table2KeyReleased
        tableData();
    }//GEN-LAST:event_table2KeyReleased

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked

        tableData();
    }//GEN-LAST:event_table2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Doctoract.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Doctoract.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Doctoract.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Doctoract.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Doctoract().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitbtn;
    private javax.swing.JLabel i;
    private javax.swing.JLabel idbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
}

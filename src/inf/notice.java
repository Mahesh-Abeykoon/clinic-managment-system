
package inf;

import codes.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public final class notice extends javax.swing.JFrame {

    
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
              

  public notice() {
     initComponents();
        conn = DBconnect.connect();
        tableDataLoad();
    }
    

public void tableDataLoad(){

    try {
        String sql = "select id ,message from notice";
         
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
    String msg= table1.getValueAt(r, 1).toString();
   
    
    idbox.setText(id);
    
    msgbox.setText(msg);
   
    
}

  
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        idbox = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        i = new javax.swing.JLabel();
        msgbox = new javax.swing.JTextField();
        insertbtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        exitbtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setForeground(new java.awt.Color(255, 153, 153));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idbox.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        idbox.setText("ID");
        jPanel3.add(idbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -20, 30, 70));

        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 40, 30));

        jLabel1.setBackground(new java.awt.Color(102, 204, 255));
        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("MESSAGE");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 90, 50));

        i.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        i.setForeground(new java.awt.Color(51, 0, 51));
        i.setText("MESSAGE ID : ");
        jPanel5.add(i, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, 30));

        msgbox.setColumns(5);
        msgbox.setToolTipText("Enter your name");
        msgbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msgboxActionPerformed(evt);
            }
        });
        jPanel5.add(msgbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 210, 170));
        msgbox.getAccessibleContext().setAccessibleName("");
        msgbox.getAccessibleContext().setAccessibleDescription("");

        insertbtn.setBackground(new java.awt.Color(0, 153, 204));
        insertbtn.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        insertbtn.setText("ADD MESSAGE");
        insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtnActionPerformed(evt);
            }
        });
        jPanel5.add(insertbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 120, 30));

        deletebtn.setBackground(new java.awt.Color(102, 153, 255));
        deletebtn.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        deletebtn.setText("DELETE");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        jPanel5.add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, -1, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/photo-1562819606-b7a0ebd7e7c5.jpeg"))); // NOI18N
        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 370, 260));

        jPanel8.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 390, 450));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 480));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table1.setBackground(new java.awt.Color(204, 255, 204));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
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

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 400, 270));

        exitbtn.setBackground(new java.awt.Color(255, 102, 102));
        exitbtn.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        exitbtn.setText("E X I T");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });
        jPanel4.add(exitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 90, 40));

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jButton1.setText("B A C K ");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 90, 40));

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel5.setText("notice");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 150, 40));

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 102));
        jLabel4.setText("SPECIAL    ");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 230, 80));
        jPanel7.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, -10, -1, -1));

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel7.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 170, 50));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 80));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 470, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msgboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msgboxActionPerformed

    }//GEN-LAST:event_msgboxActionPerformed

    private void insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtnActionPerformed

        String msg;
    
        msg = msgbox.getText();
        

        try {

            String sql = "INSERT INTO notice (message) VALUES ('"+msg+"')" ;
            pst = conn.prepareStatement(sql); // run quary
            pst.execute();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,e);
        }
        tableDataLoad();
    }//GEN-LAST:event_insertbtnActionPerformed

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
        
    }//GEN-LAST:event_deletebtnActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked

        tableData();
    }//GEN-LAST:event_table1MouseClicked

    private void table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyReleased
        tableData();
    }//GEN-LAST:event_table1KeyReleased

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed

        System.exit(0);

    }//GEN-LAST:event_exitbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Patientact ob = new Patientact();
        ob.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(notice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(notice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(notice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(notice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new notice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton exitbtn;
    private javax.swing.JLabel i;
    private javax.swing.JLabel idbox;
    private javax.swing.JButton insertbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField msgbox;
    private javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables
}

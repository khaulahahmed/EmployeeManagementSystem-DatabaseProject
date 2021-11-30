/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbproject;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hp
 */
public class Emp_Tasks extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Database db;
    int empid;

    public Emp_Tasks(int empid) {
        initComponents();
        this.empid = empid;

//        error1.setVisible(false);
//        error2.setVisible(false);
        db = new Database();
        try {
            db.openConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CreateTask.class.getName()).log(Level.SEVERE, null, ex);
        }

        con = db.con;
        pst = db.pst;
        rs = db.rs;

        //setFields();
        tableupdate();

    }

    private void tableupdate() { //table updated after every change
        int c;
        try {

            pst = con.prepareStatement("select * from Task join employee_Task "
                    + "using (task_id) where employee_id = ?;");
            pst.setInt(1, empid);
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) Etask.getModel();
            dft.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("task_id"));
                    v2.add(rs.getString("task_name"));
                    v2.add(rs.getString("start_date"));
                    v2.add(rs.getString("end_date"));
                    v2.add(rs.getString("status"));
                    v2.add(rs.getString("hours"));
                    v2.add(rs.getString("rating"));
                }

                dft.addRow(v2);
            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Etask = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        taskid = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        taskname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taskdet = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        startdate = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        enddate = new javax.swing.JTextField();
        MarkComplete = new javax.swing.JButton();
        Pending = new javax.swing.JButton();
        Missed = new javax.swing.JButton();
        Finished = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(772, 425));

        jPanel1.setBackground(new java.awt.Color(47, 27, 71));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Your Tasks");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(21, 11, 337, 44);

        Etask.setForeground(new java.awt.Color(48, 27, 71));
        Etask.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Task ID", "Task Name", "Start Date", "End Date", "Status", "Hours", "Rating"
            }
        ));
        Etask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EtaskMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Etask);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(312, 85, 414, 360);

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Task ID:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 80, 160, 19);

        taskid.setEditable(false);
        taskid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskidActionPerformed(evt);
            }
        });
        jPanel1.add(taskid);
        taskid.setBounds(20, 100, 271, 32);

        jLabel12.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Task Name:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(20, 140, 160, 19);

        taskname.setEditable(false);
        taskname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tasknameActionPerformed(evt);
            }
        });
        jPanel1.add(taskname);
        taskname.setBounds(20, 160, 271, 32);

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Task Details:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 190, 163, 22);

        taskdet.setEditable(false);
        taskdet.setColumns(20);
        taskdet.setRows(5);
        jScrollPane1.setViewportView(taskdet);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 210, 271, 70);

        jLabel10.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Start Date:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 280, 160, 19);

        startdate.setEditable(false);
        startdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startdateActionPerformed(evt);
            }
        });
        jPanel1.add(startdate);
        startdate.setBounds(20, 300, 271, 32);

        jLabel11.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("End Date:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(20, 330, 160, 19);

        enddate.setEditable(false);
        enddate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enddateActionPerformed(evt);
            }
        });
        jPanel1.add(enddate);
        enddate.setBounds(20, 350, 271, 32);

        MarkComplete.setBackground(new java.awt.Color(88, 84, 98));
        MarkComplete.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        MarkComplete.setForeground(new java.awt.Color(255, 255, 255));
        MarkComplete.setText("Mark Done");
        MarkComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarkCompleteActionPerformed(evt);
            }
        });
        jPanel1.add(MarkComplete);
        MarkComplete.setBounds(100, 400, 110, 30);

        Pending.setText("Pending");
        jPanel1.add(Pending);
        Pending.setBounds(480, 50, 73, 23);

        Missed.setText("Missed");
        Missed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MissedActionPerformed(evt);
            }
        });
        jPanel1.add(Missed);
        Missed.setBounds(560, 50, 65, 23);

        Finished.setText("Finished");
        jPanel1.add(Finished);
        Finished.setBounds(650, 50, 71, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void taskidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taskidActionPerformed

    private void tasknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tasknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tasknameActionPerformed

    private void startdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startdateActionPerformed

    private void enddateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enddateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enddateActionPerformed

    private void MarkCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarkCompleteActionPerformed

        //gets Data of selected record from table
        DefaultTableModel model = (DefaultTableModel) Etask.getModel();
        int selectedIndex = Etask.getSelectedRow();

        //emp id of selected record, used to update record
        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());

        try {

            String query = "update Employee_Task set hours = ("
                    + "(select start_date from Task where Task_ID = ?) - sysdate())/24 "
                    + " where task_ID = ?";
            pst = con.prepareStatement(query);
            pst.setInt(1, id);
            pst.setInt(2, id);

            pst.executeUpdate();
            pst.close();
            JOptionPane.showMessageDialog(this, "Record Updated.");

            //Table updated after edits
            tableupdate();

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex);
        }

        //fields set empty
//            setfieldsEmpty();
//            error.setVisible(false);
//
//        error1.setVisible(false);

    }//GEN-LAST:event_MarkCompleteActionPerformed

    private void EtaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EtaskMouseClicked
        //setting text fields as a record is selected
        DefaultTableModel model = (DefaultTableModel) Etask.getModel();
        int selectedIndex = Etask.getSelectedRow();

        taskid.setText(model.getValueAt(selectedIndex, 0).toString());
        int tid = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        taskname.setText(model.getValueAt(selectedIndex, 1).toString());
        startdate.setText(model.getValueAt(selectedIndex, 2).toString());
        enddate.setText(model.getValueAt(selectedIndex, 3).toString());

        //bring other fields from table
        try {
            pst = con.prepareStatement("select task_details from Task where task_ID = ?");
            pst.setInt(1, tid);
            rs = pst.executeQuery();

            if (rs.next()) {
                taskdet.setText(rs.getString("task_details"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Admin_Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EtaskMouseClicked

    private void MissedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MissedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MissedActionPerformed

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
            java.util.logging.Logger.getLogger(Emp_Tasks.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Emp_Tasks.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Emp_Tasks.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Emp_Tasks.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Emp_Tasks(2).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Etask;
    private javax.swing.JButton Finished;
    private javax.swing.JButton MarkComplete;
    private javax.swing.JButton Missed;
    private javax.swing.JButton Pending;
    private javax.swing.JTextField enddate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField startdate;
    private javax.swing.JTextArea taskdet;
    private javax.swing.JTextField taskid;
    private javax.swing.JTextField taskname;
    // End of variables declaration//GEN-END:variables
}

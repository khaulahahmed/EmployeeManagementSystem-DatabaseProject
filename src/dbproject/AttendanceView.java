package dbproject;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Hp
 */
public class AttendanceView extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Database db;

    public AttendanceView() {
        initComponents();

        //making connection to database
        db = new Database();
        try {
            db.openConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceView.class.getName()).log(Level.SEVERE, null, ex);
        }

        con = db.con;
        pst = db.pst;
        rs = db.rs;

        tableupdate();
    }

    private void tableupdate() { //table updated after every change
        int c;
        try {

            pst = con.prepareStatement("SELECT a.Employee_ID, e.first_name, "
                    + "e.last_name, a.date, a.`Attendance`\n"
                    + "FROM Attendance a\n"
                    + "INNER JOIN Employee e using (Employee_ID);");
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) Employee.getModel();
            dft.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("employee_id"));
                    v2.add(rs.getString("first_name"));
                    v2.add(rs.getString("last_name"));
                    v2.add(rs.getString("date"));
                    v2.add(rs.getString("attendance"));
                }

                dft.addRow(v2);

            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Sbdate = new javax.swing.JLabel();
        empid = new javax.swing.JTextField();
        search1 = new javax.swing.JButton();
        Date = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        search2 = new javax.swing.JButton();
        empID2 = new javax.swing.JLabel();
        markAtt = new javax.swing.JButton();
        or = new javax.swing.JLabel();
        searchbemp = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Employee = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(52, 45, 71));
        jPanel1.setPreferredSize(new java.awt.Dimension(744, 490));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 45, 71));
        jLabel1.setText("Attendance ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 20, 230, 43);

        Sbdate.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        Sbdate.setForeground(new java.awt.Color(52, 45, 71));
        Sbdate.setText("Search by Date:");
        jPanel1.add(Sbdate);
        Sbdate.setBounds(20, 290, 120, 20);

        empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empidActionPerformed(evt);
            }
        });
        jPanel1.add(empid);
        empid.setBounds(100, 190, 80, 30);

        search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search1ActionPerformed(evt);
            }
        });
        jPanel1.add(search1);
        search1.setBounds(190, 200, 50, 20);

        Date.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        Date.setForeground(new java.awt.Color(52, 45, 71));
        Date.setText("Date: ");
        jPanel1.add(Date);
        Date.setBounds(20, 330, 80, 14);

        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });
        jPanel1.add(date);
        date.setBounds(70, 320, 110, 30);
        jPanel1.add(search2);
        search2.setBounds(190, 330, 50, 20);

        empID2.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        empID2.setForeground(new java.awt.Color(52, 45, 71));
        empID2.setText("Employee ID:");
        jPanel1.add(empID2);
        empID2.setBounds(20, 200, 80, 14);

        markAtt.setBackground(new java.awt.Color(88, 84, 98));
        markAtt.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        markAtt.setForeground(new java.awt.Color(255, 255, 255));
        markAtt.setText("MARK ATTENDANCE");
        markAtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markAttActionPerformed(evt);
            }
        });
        jPanel1.add(markAtt);
        markAtt.setBounds(520, 20, 170, 30);

        or.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        or.setForeground(new java.awt.Color(52, 45, 71));
        or.setText("OR");
        jPanel1.add(or);
        or.setBounds(90, 250, 30, 18);

        searchbemp.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        searchbemp.setForeground(new java.awt.Color(52, 45, 71));
        searchbemp.setText("Search by Employee:");
        jPanel1.add(searchbemp);
        searchbemp.setBounds(20, 160, 150, 18);

        Employee.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 12)); // NOI18N
        Employee.setForeground(new java.awt.Color(52, 45, 71));
        Employee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "First Name", "Last Name", "Date", "Attendance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Employee);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(260, 100, 460, 310);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empidActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void markAttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markAttActionPerformed
        new Mark_Attendance2().setVisible(rootPaneCheckingEnabled);
        this.setVisible(false);
    }//GEN-LAST:event_markAttActionPerformed

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
        if (!empid.getText().isEmpty()) {
            try {
                int emp = Integer.parseInt(empid.getText());

                try {
                    pst = con.prepareStatement("SELECT a.Employee_ID, e.first_name, "
                            + "e.last_name, a.date, a.`Attendance`\n"
                            + "FROM Attendance a\n"
                            + "INNER JOIN Employee e using (Employee_ID) where employee_ID = ?");
                    pst.setInt(1, emp);
                    rs = pst.executeQuery();

                    ResultSetMetaData rsd = rs.getMetaData();
                    DefaultTableModel dft = (DefaultTableModel) Employee.getModel();
                    dft.setRowCount(0);

                    if (rs.next()) {
                        Vector v2 = new Vector();
                        v2.add(rs.getString("employee_id"));
                        v2.add(rs.getString("first_name"));
                        v2.add(rs.getString("last_name"));
                        v2.add(rs.getString("date"));
                        v2.add(rs.getString("attendance"));
                        dft.addRow(v2);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Admin_Employee.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (NumberFormatException ex) {
                empid.setText("");
            }
        }
    }//GEN-LAST:event_search1ActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AttendanceView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    private javax.swing.JTable Employee;
    private javax.swing.JLabel Sbdate;
    private javax.swing.JTextField date;
    private javax.swing.JLabel empID2;
    private javax.swing.JTextField empid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton markAtt;
    private javax.swing.JLabel or;
    private javax.swing.JButton search1;
    private javax.swing.JButton search2;
    private javax.swing.JLabel searchbemp;
    // End of variables declaration//GEN-END:variables
}

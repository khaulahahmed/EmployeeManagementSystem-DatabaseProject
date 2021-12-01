package dbproject;


import dbproject.Admin_Employee;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Hp
 */
public class PerformanceAnalysis extends javax.swing.JFrame {

    /**
     * Creates new form Admin_Employee
     */
    public PerformanceAnalysis() {
        initComponents();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        Employee = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Sbdate = new javax.swing.JLabel();
        empid = new javax.swing.JTextField();
        search1 = new javax.swing.JButton();
        Date = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        search2 = new javax.swing.JButton();
        empID2 = new javax.swing.JLabel();
        or = new javax.swing.JLabel();
        searchbemp = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(744, 490));
        jPanel1.setLayout(null);

        Employee.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Employee);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(290, 80, 430, 370);

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 45, 71));
        jLabel1.setText("Performance Analysis");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 20, 340, 40);

        Sbdate.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        Sbdate.setForeground(new java.awt.Color(52, 45, 71));
        Sbdate.setText("Search by Month:");
        jPanel1.add(Sbdate);
        Sbdate.setBounds(30, 290, 120, 20);

        empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empidActionPerformed(evt);
            }
        });
        jPanel1.add(empid);
        empid.setBounds(120, 190, 70, 30);
        jPanel1.add(search1);
        search1.setBounds(200, 200, 50, 20);

        Date.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        Date.setForeground(new java.awt.Color(52, 45, 71));
        Date.setText("Month: ");
        jPanel1.add(Date);
        Date.setBounds(30, 330, 80, 15);

        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });
        jPanel1.add(date);
        date.setBounds(80, 320, 110, 30);
        jPanel1.add(search2);
        search2.setBounds(200, 330, 50, 20);

        empID2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        empID2.setForeground(new java.awt.Color(52, 45, 71));
        empID2.setText("Employee ID:");
        jPanel1.add(empID2);
        empID2.setBounds(30, 200, 90, 15);

        or.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        or.setForeground(new java.awt.Color(52, 45, 71));
        or.setText("OR");
        jPanel1.add(or);
        or.setBounds(100, 250, 30, 18);

        searchbemp.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        searchbemp.setForeground(new java.awt.Color(52, 45, 71));
        searchbemp.setText("Search by Employee:");
        jPanel1.add(searchbemp);
        searchbemp.setBounds(30, 160, 150, 15);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(52, 45, 71));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbproject/dashboard_32.png"))); // NOI18N
        jButton2.setText("Dashboard");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 45, 71)));
        jButton2.setBorderPainted(false);
        jButton2.setFocusable(false);
        jButton2.setRequestFocusEnabled(false);
        jPanel1.add(jButton2);
        jButton2.setBounds(620, 0, 130, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empidActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

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
                new PerformanceAnalysis().setVisible(true);
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
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel or;
    private javax.swing.JButton search1;
    private javax.swing.JButton search2;
    private javax.swing.JLabel searchbemp;
    // End of variables declaration//GEN-END:variables
}

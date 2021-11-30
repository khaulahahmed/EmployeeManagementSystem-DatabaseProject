/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dbproject;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hp
 */
public class Ad_salary extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    Database db;

    public Ad_salary() {
        initComponents();

        error.setVisible(false);
        error3.setVisible(false);
        error4.setVisible(false);

        db = new Database();
        try {
            db.openConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Ad_salary.class.getName()).log(Level.SEVERE, null, ex);
        }

        con = db.con;
        pst = db.pst;
        rs = db.rs;

        tableupdate();
    }

    private void tableupdate() { //table updated after every change
        int c;
        try {

            pst = con.prepareStatement("SELECT s.Employee_ID, CONCAT_WS(\"-\", e.first_name, e.last_name) as name,"
                    + " s.date, s.salary, s.bonus, s.travel_allowance, s.medical_allowance\n"
                    + "FROM monthly_salary s\n"
                    + "INNER JOIN Employee e using (Employee_ID)");
            rs = pst.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel) sal.getModel();
            dft.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("employee_id"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("date"));
                    v2.add(rs.getString("salary"));
                    v2.add(rs.getString("bonus"));
                    v2.add(rs.getString("travel_allowance"));
                    v2.add(rs.getString("medical_allowance"));
                }

                dft.addRow(v2);

            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Admin_Employee.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    private void setfieldsEmpty() {
        empid.setText("");
        salary.setText("");
        bonus.setText("");
        medical.setText("");
        travel.setText("");
        empid.requestFocus();

    }

    public boolean checkEmployeeExist(int emp) {
        try {
            pst = con.prepareStatement("select * from Employee where employee_ID = ?");
            pst.setInt(1, emp);
            rs = pst.executeQuery();

            if (!rs.isBeforeFirst()) { //employee not exists
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mark_Attendance2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private boolean checkfields() { //check if required fields are there
        if (empid.getText().equals("") || salary.getText().equals("")) {
            error.setVisible(true);

            if (empid.getText().trim().isEmpty()) {
                empid.grabFocus();
                return true;
            } else if (salary.getText().trim().isEmpty()) {
                salary.grabFocus();
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sal = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        first_name = new javax.swing.JLabel();
        empid = new javax.swing.JTextField();
        first_name1 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        first_name2 = new javax.swing.JLabel();
        salary = new javax.swing.JTextField();
        first_name3 = new javax.swing.JLabel();
        bonus = new javax.swing.JTextField();
        first_name4 = new javax.swing.JLabel();
        travel = new javax.swing.JTextField();
        empID = new javax.swing.JLabel();
        emp = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        search1 = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        first_name5 = new javax.swing.JLabel();
        medical = new javax.swing.JTextField();
        error3 = new javax.swing.JLabel();
        error4 = new javax.swing.JLabel();
        reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(52, 45, 71));
        jPanel1.setPreferredSize(new java.awt.Dimension(744, 490));
        jPanel1.setLayout(null);

        sal.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 11)); // NOI18N
        sal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Name", "Date", "Base Salary", "Bonus", "Travel Allowance", "Medical Allowance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(sal);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(279, 90, 480, 350);

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Salary");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 20, 330, 43);

        first_name.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        first_name.setForeground(new java.awt.Color(255, 255, 255));
        first_name.setText("*Employee ID:");
        jPanel1.add(first_name);
        first_name.setBounds(30, 100, 80, 20);

        empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empidActionPerformed(evt);
            }
        });
        empid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                empidKeyTyped(evt);
            }
        });
        jPanel1.add(empid);
        empid.setBounds(30, 120, 90, 30);

        first_name1.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        first_name1.setForeground(new java.awt.Color(255, 255, 255));
        first_name1.setText("Date:");
        jPanel1.add(first_name1);
        first_name1.setBounds(140, 100, 90, 20);

        date.setEditable(false);
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });
        jPanel1.add(date);
        date.setBounds(140, 120, 100, 30);

        first_name2.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        first_name2.setForeground(new java.awt.Color(255, 255, 255));
        first_name2.setText("*Base Salary:");
        jPanel1.add(first_name2);
        first_name2.setBounds(30, 160, 120, 14);

        salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryActionPerformed(evt);
            }
        });
        jPanel1.add(salary);
        salary.setBounds(30, 180, 210, 30);

        first_name3.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        first_name3.setForeground(new java.awt.Color(255, 255, 255));
        first_name3.setText("Bonus:");
        jPanel1.add(first_name3);
        first_name3.setBounds(30, 220, 110, 14);

        bonus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bonusActionPerformed(evt);
            }
        });
        jPanel1.add(bonus);
        bonus.setBounds(30, 240, 210, 30);

        first_name4.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        first_name4.setForeground(new java.awt.Color(255, 255, 255));
        first_name4.setText("Travel allowance:");
        jPanel1.add(first_name4);
        first_name4.setBounds(30, 280, 100, 14);

        travel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                travelActionPerformed(evt);
            }
        });
        jPanel1.add(travel);
        travel.setBounds(30, 300, 210, 30);

        empID.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        empID.setForeground(new java.awt.Color(255, 255, 255));
        empID.setText("Employee ID:");
        jPanel1.add(empID);
        empID.setBounds(440, 60, 80, 14);

        emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empActionPerformed(evt);
            }
        });
        emp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                empKeyTyped(evt);
            }
        });
        jPanel1.add(emp);
        emp.setBounds(520, 50, 80, 30);

        add.setBackground(new java.awt.Color(88, 84, 98));
        add.setFont(new java.awt.Font("Rockwell", 0, 10)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add);
        add.setBounds(50, 410, 70, 30);

        Update.setBackground(new java.awt.Color(88, 84, 98));
        Update.setFont(new java.awt.Font("Rockwell", 0, 10)); // NOI18N
        Update.setForeground(new java.awt.Color(255, 255, 255));
        Update.setText("UPDATE");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jPanel1.add(Update);
        Update.setBounds(140, 410, 80, 30);

        search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search1ActionPerformed(evt);
            }
        });
        jPanel1.add(search1);
        search1.setBounds(610, 50, 50, 20);

        error.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error.setForeground(new java.awt.Color(255, 0, 51));
        error.setText("*enter required fields to proceed");
        jPanel1.add(error);
        error.setBounds(40, 380, 200, 40);

        first_name5.setFont(new java.awt.Font("Rockwell", 0, 11)); // NOI18N
        first_name5.setForeground(new java.awt.Color(255, 255, 255));
        first_name5.setText("Medical Allowance:");
        jPanel1.add(first_name5);
        first_name5.setBounds(30, 340, 110, 14);

        medical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicalActionPerformed(evt);
            }
        });
        jPanel1.add(medical);
        medical.setBounds(30, 360, 210, 30);

        error3.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error3.setForeground(new java.awt.Color(255, 0, 51));
        error3.setText("Salary for this month has been entered.");
        jPanel1.add(error3);
        error3.setBounds(20, 80, 240, 30);

        error4.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        error4.setForeground(new java.awt.Color(255, 0, 51));
        error4.setText("Employee does not exists.");
        jPanel1.add(error4);
        error4.setBounds(30, 80, 220, 30);

        reset.setText("Reset Table");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel1.add(reset);
        reset.setBounds(630, 450, 90, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void salMouseClicked(java.awt.event.MouseEvent evt) {                                 
        //setting text fields as a record is selected
        DefaultTableModel model = (DefaultTableModel) sal.getModel();
        int selectedIndex = sal.getSelectedRow();

        empid.setText(model.getValueAt(selectedIndex, 0).toString());
        date.setText(model.getValueAt(selectedIndex, 2).toString());
        salary.setText(model.getValueAt(selectedIndex, 3).toString());
        bonus.setText(model.getValueAt(selectedIndex, 4).toString());
        travel.setText(model.getValueAt(selectedIndex, 5).toString());
        medical.setText(model.getValueAt(selectedIndex, 6).toString());

    }                                

    private void empidActionPerformed(java.awt.event.ActionEvent evt) {                                      

    }                                     

    private void empidKeyTyped(java.awt.event.KeyEvent evt) {                               
        error.setVisible(false);
        error3.setVisible(false);
        error4.setVisible(false);
    }                              

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void salaryActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void bonusActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    private void travelActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void empActionPerformed(java.awt.event.ActionEvent evt) {                                    
        // TODO add your handling code here:
    }                                   

    private void addActionPerformed(java.awt.event.ActionEvent evt) {                                    
        //req fields are there
        if (!checkfields()) {

            Double bsal = Double.parseDouble(salary.getText());
            Double b = Double.parseDouble(bonus.getText());
            Double TA = Double.parseDouble(travel.getText());
            Double MA = Double.parseDouble(medical.getText());

            try {

                int id = Integer.parseInt(empid.getText());

                try {
                    String query = "insert into Monthly_Salary(employee_id, date,salary, "
                            + "bonus, medical_allowance, travel_allowance) "
                            + "values(?, Date_format(sysdate(),'%M %Y'),?,?,?,?)";
                    pst = con.prepareStatement(query);
                    pst.setInt(1, id);
                    pst.setDouble(2, bsal);
                    pst.setDouble(3, b);
                    pst.setDouble(4, TA);
                    pst.setDouble(5, MA);
                    pst.execute();
                    pst.close();
                    JOptionPane.showMessageDialog(this, "Record Addedd.");

                    //Table updates after insertion
                    tableupdate();

                } catch (SQLIntegrityConstraintViolationException e) {
                    if (checkEmployeeExist(id)) {
                        error3.setVisible(true);
                    } else {
                        error4.setVisible(true);
                    }
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex);
                }

                //fields are set empty again
                setfieldsEmpty();
                error.setVisible(false);
            } catch (NumberFormatException ex) {
                setfieldsEmpty();
            }

        }

    }                                   

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {                                       
        error3.setVisible(false);
        error4.setVisible(false);

        //req fields are there
        if (!checkfields()) {

            //gets Data of selected record from table
            DefaultTableModel model = (DefaultTableModel) sal.getModel();
            int selectedIndex = sal.getSelectedRow();

            Double bsal = Double.parseDouble(salary.getText());
            Double b = Double.parseDouble(bonus.getText());
            Double TA = Double.parseDouble(travel.getText());
            Double MA = Double.parseDouble(medical.getText());

            try {
                int id = Integer.parseInt(empid.getText());

                try {

                    String query = "update Monthly_salary set Salary = ?, bonus = ?,"
                            + " medical_allowance = ?, travel_allowance= ? "
                            + "where Employee_ID = ?";
                    pst = con.prepareStatement(query);
                    pst.setDouble(1, bsal);
                    pst.setDouble(2, b);
                    pst.setDouble(3, MA);
                    pst.setDouble(4, TA);
                    pst.setInt(5, id);
                    pst.executeUpdate();
                    pst.close();
                    JOptionPane.showMessageDialog(this, "Record Updated.");

                    //Table updated after edits
                    tableupdate();

                } catch (SQLIntegrityConstraintViolationException e) {
                    if (checkEmployeeExist(id)) {
                        error3.setVisible(true);
                    } else {
                        error4.setVisible(true);
                    }
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(Admin_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, ex);
                }

                //fields set empty
                setfieldsEmpty();
                error.setVisible(false);
            } catch (NumberFormatException ex) {
                error.setVisible(true);
            }

        }

    }                                      

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if (!emp.getText().isEmpty()) {
            try {
                int vemp = Integer.parseInt(emp.getText());

                try {
                    pst = con.prepareStatement("SELECT s.Employee_ID, CONCAT_WS(\"-\", e.first_name, e.last_name) as name,"
                            + " s.date, s.salary, s.bonus, s.travel_allowance, s.medical_allowance\n"
                            + "FROM monthly_salary s\n"
                            + "INNER JOIN Employee e using (Employee_ID) where employee_ID = ?");
                    pst.setInt(1, vemp);
                    rs = pst.executeQuery();

                    ResultSetMetaData rsd = rs.getMetaData();
                    DefaultTableModel dft = (DefaultTableModel) sal.getModel();
                    dft.setRowCount(0);

                    if (rs.next()) {
                        Vector v2 = new Vector();
                        v2.add(rs.getString("employee_id"));
                        v2.add(rs.getString("name"));
                        v2.add(rs.getString("date"));
                        v2.add(rs.getString("salary"));
                        v2.add(rs.getString("bonus"));
                        v2.add(rs.getString("travel_allowance"));
                        v2.add(rs.getString("medical_allowance"));
                        dft.addRow(v2);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Admin_Employee.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (NumberFormatException ex) {
                empid.setText("");
            }
        }
    }                                       

    private void medicalActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {                                      
        tableupdate();
        empid.setText("");
    }                                     

    private void empKeyTyped(java.awt.event.KeyEvent evt) {                             
        tableupdate();
        empid.setText("");
    }                            

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
            java.util.logging.Logger.getLogger(Ad_salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ad_salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ad_salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ad_salary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ad_salary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton Update;
    private javax.swing.JButton add;
    private javax.swing.JTextField bonus;
    private javax.swing.JTextField date;
    private javax.swing.JTextField emp;
    private javax.swing.JLabel empID;
    private javax.swing.JTextField empid;
    private javax.swing.JLabel error;
    private javax.swing.JLabel error3;
    private javax.swing.JLabel error4;
    private javax.swing.JLabel first_name;
    private javax.swing.JLabel first_name1;
    private javax.swing.JLabel first_name2;
    private javax.swing.JLabel first_name3;
    private javax.swing.JLabel first_name4;
    private javax.swing.JLabel first_name5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField medical;
    private javax.swing.JButton reset;
    private javax.swing.JTable sal;
    private javax.swing.JTextField salary;
    private javax.swing.JButton search1;
    private javax.swing.JTextField travel;
    // End of variables declaration                   
}

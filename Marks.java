package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Marks extends JFrame implements ActionListener {
    
    String usn;
    JButton cancel;
    
    Marks(String usn) {
        this.usn = usn;
        
        setSize(1000, 700);
        setLocation(100, 100);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("SJM INSTITUTE OF TECHNOLOGY");
        heading.setBounds(100, 10, 500, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
        
        JLabel subheading = new JLabel("Result of Examination 2024");
        subheading.setBounds(100, 50, 500, 20);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(subheading);
        
        JLabel lblusn = new JLabel("USN " + usn);
        lblusn.setBounds(60, 100, 500, 20);
        lblusn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblusn);
        
        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(60, 130, 500, 20);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsemester);
        
        JLabel lblcie = new JLabel();
        lblcie.setBounds(60, 160, 500, 20);
        lblcie.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblcie);
        
        JLabel[] subjects = new JLabel[8];
        for (int i = 0; i < subjects.length; i++) {
            subjects[i] = new JLabel();
            subjects[i].setBounds(100, 200 + (i * 30), 500, 20);
            subjects[i].setFont(new Font("Tahoma", Font.PLAIN, 18));
            add(subjects[i]);
        }
        
        Conn c = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        try {
            c = new Conn();
            
            rs1 = c.s.executeQuery("select * from subject where usn = '" + usn + "'");
            if (rs1.next()) {
                for (int i = 1; i <= subjects.length; i++) {
                    subjects[i - 1].setText(rs1.getString("subject" + i));
                }
            }
            
            rs2 = c.s.executeQuery("select * from marks where usn = '" + usn + "'");
            if (rs2.next()) {
                for (int i = 1; i <= subjects.length; i++) {
                    subjects[i - 1].setText(subjects[i - 1].getText() + "-------------------" + rs2.getString("marks" + i));
                }
                lblsemester.setText("Semester " + rs2.getString("semester"));
                lblcie.setText("CIE: " + rs2.getString("cie"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs1 != null) rs1.close();
                if (rs2 != null) rs2.close();
                if (c != null) c.s.close(); // Assuming 's' is the Statement object
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        cancel = new JButton("Back");
        cancel.setBounds(250, 500, 120, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new Marks(""); // Example USN
    }
}

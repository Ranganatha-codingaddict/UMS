package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateTeacher extends JFrame implements ActionListener{
    
    JTextField tfqualification, tfaddress, tfphone, tfemail, tfbranch;
    JLabel labelEmpId;
    JButton submit, cancel;
    Choice cEmpId;
    
    UpdateTeacher() {
        
        setSize(900, 650);
        setLocation(350, 50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 35));
        add(heading);
        
        JLabel lblEmpId = new JLabel("Select Employee Id");
        lblEmpId.setBounds(50, 100, 200, 20);
        lblEmpId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblEmpId);
        
        cEmpId = new Choice();
        cEmpId.setBounds(250, 100, 200, 20);
        add(cEmpId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()) {
                cEmpId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(200, 150, 150, 30);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelname);
        
        JLabel lblfather_name = new JLabel("Father's Name");
        lblfather_name.setBounds(400, 150, 200, 30);
        lblfather_name.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfather_name);
        
        JLabel labelfather_name = new JLabel();
        labelfather_name.setBounds(600, 150, 150, 30);
        labelfather_name.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelfather_name);
        
        lblEmpId = new JLabel("Employee Id");
        lblEmpId.setBounds(50, 200, 200, 30);
        lblEmpId.setFont(new Font("serif", Font.BOLD, 20));
        add(lblEmpId);
        
        labelEmpId = new JLabel();
        labelEmpId.setBounds(200, 200, 200, 30);
        labelEmpId.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelEmpId);
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);
        
        JLabel labeldob = new JLabel();
        labeldob.setBounds(600, 200, 150, 30);
        labeldob.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labeldob);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        JLabel lblbe = new JLabel("BE (%)");
        lblbe.setBounds(400, 300, 200, 30);
        lblbe.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbe);
        
        JLabel labelbe = new JLabel();
        labelbe.setBounds(600, 300, 150, 30);
        labelbe.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelbe);
        
        JLabel lblmtech = new JLabel("MTECH (%)");
        lblmtech.setBounds(50, 350, 200, 30);
        lblmtech.setFont(new Font("serif", Font.BOLD, 20));
        add(lblmtech);
        
        JLabel labelmtech = new JLabel();
        labelmtech.setBounds(200, 350, 150, 30);
        labelmtech.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelmtech);
        
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(400, 350, 200, 30);
        lblaadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(lblaadhar);
        
        JLabel labelaadhar = new JLabel();
        labelaadhar.setBounds(600, 350, 150, 30);
        labelaadhar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelaadhar);
        
        JLabel lblqualification = new JLabel("Qualification");
        lblqualification.setBounds(50, 400, 200, 30);
        lblqualification.setFont(new Font("serif", Font.BOLD, 20));
        add(lblqualification);
        
        tfqualification = new JTextField();
        tfqualification.setBounds(200, 400, 150, 30);
        add(tfqualification);
        
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);
        
        tfbranch = new JTextField();
        tfbranch.setBounds(600, 400, 150, 30);
        add(tfbranch);
        
        try {
            Conn c = new Conn();
            String query = "select * from teacher where empId='"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfather_name.setText(rs.getString("father_name"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelbe.setText(rs.getString("be"));
                labelmtech.setText(rs.getString("mtech"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelEmpId.setText(rs.getString("empId"));
                tfqualification.setText(rs.getString("Qualification"));
                tfbranch.setText(rs.getString("Branch"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from teacher where empId='"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfather_name.setText(rs.getString("father_name"));
                        labeldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        labelbe.setText(rs.getString("BE"));
                        labelmtech.setText(rs.getString("MTECH"));
                        labelaadhar.setText(rs.getString("aadhar"));
                        labelEmpId.setText(rs.getString("empId"));
                        tfqualification.setText(rs.getString("Qualification"));
                        tfbranch.setText(rs.getString("Branch"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        submit = new JButton("Update");
        submit.setBounds(250, 500, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 500, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String empId = labelEmpId.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String qualification = tfqualification .getText();
            String branch = tfbranch.getText();
            
            try {
                String query = "update teacher set address='"+address+"', phone='"+phone+"', email='"+email+"', qualification='"+qualification+"', Branch='"+branch+"' where empId='"+empId+"'";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Teacher Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new UpdateTeacher();
    }
}

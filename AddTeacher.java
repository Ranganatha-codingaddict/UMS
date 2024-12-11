package university.management.system;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddTeacher extends JFrame implements ActionListener{
    
    JTextField tfname, tffather_name, tfempId, tfaddress, tfphone, tfemail, tfbe, tfmtech, tfaadhar;
    JDateChooser dcdob;
    JComboBox cbQualification, cbbranch;
    JButton submit, cancel;
    
    AddTeacher() {
        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);
        
        JLabel college = new JLabel("SJM INSTITUTE OF TECHNOLOGY");
        college.setBounds(200, 0, 600, 50);
        college.setFont(new Font("serif", Font.BOLD, 30));
      
        add(college);
        
        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310, 60, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        heading.setForeground(Color.blue);
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        lblname.setForeground(Color.yellow);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        JLabel lblfather_name = new JLabel("Father's Name");
        lblfather_name.setBounds(400, 150, 200, 30);
        lblfather_name.setFont(new Font("serif", Font.BOLD, 20));
        lblfather_name.setForeground(Color.yellow);
        add(lblfather_name);
        
        tffather_name = new JTextField();
        tffather_name.setBounds(600, 150, 150, 30);
        add(tffather_name);
        
        JLabel lblempId = new JLabel("Employee Id");
        lblempId.setBounds(50, 200, 200, 30);
        lblempId.setFont(new Font("serif", Font.BOLD, 20));
        lblempId.setForeground(Color.yellow);
        add(lblempId);
        
        tfempId = new JTextField();
        tfempId.setBounds(200, 200, 150, 30);
        add(tfempId);
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        lbldob.setForeground(Color.yellow);
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        lbladdress.setForeground(Color.yellow);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        lblphone.setForeground(Color.yellow);
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        lblemail.setForeground(Color.yellow);
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        JLabel lblbe = new JLabel("B.E  (%)");
        lblbe.setBounds(400, 300, 200, 30);
        lblbe.setFont(new Font("serif", Font.BOLD, 20));
        lblbe.setForeground(Color.yellow);
        add(lblbe);
        
        tfbe = new JTextField();
        tfbe.setBounds(600, 300, 150, 30);
        add(tfbe);
        
        JLabel lblmtech = new JLabel("M.Tech (%)");
        lblmtech.setBounds(50, 350, 200, 30);
        lblmtech.setFont(new Font("serif", Font.BOLD, 20));
        lblmtech.setForeground(Color.yellow);
        add(lblmtech);
        
        tfmtech = new JTextField();
        tfmtech.setBounds(200, 350, 150, 30);
        add(tfmtech);
        
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(400, 350, 200, 30);
        lblaadhar.setFont(new Font("serif", Font.BOLD, 20));
        lblaadhar.setForeground(Color.yellow);
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        add(tfaadhar);
        
        JLabel lblqualification = new JLabel("Qualification");
        lblqualification.setBounds(50, 400, 200, 30);
        lblqualification.setFont(new Font("serif", Font.BOLD, 20));
        lblqualification.setForeground(Color.yellow);
        add(lblqualification);
        
        String[] Qualification = {"B.E", "M.Tech", "Phd", "B.Tech", "Msc", "MBA", "MCA", "MCom", "MA", "BA"};
        cbQualification = new JComboBox(Qualification);
        cbQualification.setBounds(200, 400, 150, 30);
        cbQualification.setBackground(Color.WHITE);
        add(cbQualification);
        
        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        lblbranch.setForeground(Color.yellow);
        add(lblbranch);
        
        String[] branch = {"Computer Science", "Electronics&communication", "Mechanical", "Civil", "Electrical & Electronics"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(600, 400, 150, 30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String fname = tffather_name.getText();
            String empId = tfempId.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String be = tfbe.getText();
            String mtech = tfmtech.getText();
            String aadhar = tfaadhar.getText();
            String qualification = (String) cbQualification.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            
            try {
                String query = "INSERT INTO teacher VALUES('" + name + "', '" + fname + "', '" + empId + "', '" + dob + "', '" + address + "', '" + phone + "', '" + email + "', '" + be + "', '" + mtech + "', '" + aadhar + "', '" + qualification + "', '" + branch + "')";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddTeacher();
    }
}

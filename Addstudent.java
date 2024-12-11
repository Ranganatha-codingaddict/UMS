package university.management.system;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Addstudent extends JFrame implements ActionListener {
    JTextField tfname, tffather_name, tfusn, tfaddress, tfphone, tfemail, tfsslc, tfpuc, tfaadhar;
    JDateChooser dcdob;
    JComboBox<String> cbcourse, cbbranch;
    JButton submit, cancel;

    Addstudent() {
        setSize(900, 700);
        setLocation(350, 50);

        setLayout(null);
        JLabel college = new JLabel("SJM INSTITUTE OF TECHNOLOGY");
        college.setBounds(200, 0, 600, 50);
        college.setFont(new Font("serif", Font.BOLD, 30));
        college.setForeground(Color.yellow);
        add(college);

        JLabel heading = new JLabel("NEW STUDENT DETAILS");
        heading.setBounds(280, 60, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        heading.setForeground(Color.RED);
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        lblname.setForeground(Color.MAGENTA);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);

        JLabel lblfather_name = new JLabel("Father's Name");
        lblfather_name.setBounds(400, 150, 200, 30);
        lblfather_name.setFont(new Font("serif", Font.BOLD, 20));
        lblfather_name.setForeground(Color.MAGENTA);
        add(lblfather_name);

        tffather_name = new JTextField();
        tffather_name.setBounds(600, 150, 150, 30);
        add(tffather_name);

        JLabel lblusn = new JLabel("USN");
        lblusn.setBounds(50, 200, 200, 30);
        lblusn.setFont(new Font("serif", Font.BOLD, 20));
        lblusn.setForeground(Color.MAGENTA);
        add(lblusn);

        tfusn = new JTextField();
        tfusn.setBounds(200, 200, 150, 30);
        tfusn.setFont(new Font("serif", Font.BOLD, 20));
        add(tfusn);

        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        lbldob.setForeground(Color.MAGENTA);
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        lbladdress.setForeground(Color.MAGENTA);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        lblphone.setForeground(Color.MAGENTA);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        lblemail.setForeground(Color.MAGENTA);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        JLabel lblsslc = new JLabel("SSLC  (%)");
        lblsslc.setBounds(400, 300, 200, 30);
        lblsslc.setFont(new Font("serif", Font.BOLD, 20));
        lblsslc.setForeground(Color.MAGENTA);
        add(lblsslc);

        tfsslc = new JTextField();
        tfsslc.setBounds(600, 300, 150, 30);
        add(tfsslc);

        JLabel lblpuc = new JLabel("PUC (%)");
        lblpuc.setBounds(50, 350, 200, 30);
        lblpuc.setFont(new Font("serif", Font.BOLD, 20));
        lblpuc.setForeground(Color.MAGENTA);
        add(lblpuc);

        tfpuc = new JTextField();
        tfpuc.setBounds(200, 350, 150, 30);
        add(tfpuc);

        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(400, 350, 200, 30);
        lblaadhar.setFont(new Font("serif", Font.BOLD, 20));
        lblaadhar.setForeground(Color.MAGENTA);
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        add(tfaadhar);

        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        lblcourse.setForeground(Color.MAGENTA);
        add(lblcourse);

        String[] course = {"B.E", "B.Tech", "M.Tech", "B.Plan", "Bsc", "Msc", "MBA", "MCA", "MCom", "MA", "BA"};
        cbcourse = new JComboBox<>(course);
        cbcourse.setBounds(200, 400, 150, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        lblbranch.setForeground(Color.MAGENTA);
        add(lblbranch);

        String[] branch = {"Computer Science", "Electronics&communication", "Mechanical", "Civil", "Electrical&Electronics"};
        cbbranch = new JComboBox<>(branch);
        cbbranch.setBounds(600, 400, 150, 30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif", Font.BOLD, 15));
        submit.setBounds(250, 550, 120, 30);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD, 15));
        cancel.setBounds(450, 550, 120, 30);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
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
            String father_name = tffather_name.getText();
            String usn = tfusn.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String sslc = tfsslc.getText();
            String puc = tfpuc.getText();
            String aadhar = tfaadhar.getText();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();

            try {
                String query = "insert into student values('" + name + "','" + father_name + "','" + usn + "','" + dob + "','" + address + "','" + phone + "','" + email + "','" + sslc + "','" + puc + "','" + aadhar + "','" + course + "','" + branch + "')";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student Details added Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Addstudent();
    }
}

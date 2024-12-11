package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;

public class StudentFeeForm extends JFrame implements ActionListener {

    JComboBox<String> cusn, cbcourse, cbbranch, cbsemester;
    JLabel labelname, labelfather_name, labeltotal;

    JButton update, pay, back;

    StudentFeeForm() {
        setSize(900, 500);
        setLocation(300, 100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 300);
        add(image);

        JLabel lblusn = new JLabel("Select USN ");
        lblusn.setBounds(40, 60, 150, 20);
        lblusn.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblusn);

        cusn = new JComboBox<>();
        cusn.setBounds(200, 60, 150, 20);
        add(cusn);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                cusn.addItem(rs.getString("usn"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 100, 150, 20);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(200, 100, 150, 20);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelname);

        JLabel lblfather_name = new JLabel("Father's Name");
        lblfather_name.setBounds(40, 140, 150, 20);
        lblfather_name.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblfather_name);

        labelfather_name = new JLabel();
        labelfather_name.setBounds(200, 140, 150, 20);
        labelfather_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelfather_name);

        cusn.addActionListener(this);

        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(40, 180, 150, 20);
        lblcourse.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblcourse);

        String course[] = {"B.E", "B.Tech", "M.Tech", "B.Plan", "Bsc", "Msc", "MBA", "MCA", "BA"};
        cbcourse = new JComboBox<>(course);
        cbcourse.setBounds(200, 180, 150, 20);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(40, 220, 150, 20);
        lblbranch.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblbranch);

        String branch[] = {"Computer Science", "Electronics& Communication", "Mechanical", "Civil", "Electrival&Electronics"};
        cbbranch = new JComboBox<>(branch);
        cbbranch.setBounds(200, 220, 150, 20);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        JLabel lblsemester = new JLabel("Semester");
        lblsemester.setBounds(40, 260, 150, 20);
        lblsemester.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblsemester);

        String semester[] = {"Semester1", "Semester2", "Semester3", "Semester4", "Semester5", "Semester6", "Semester7", "Semester8"};
        cbsemester = new JComboBox<>(semester);
        cbsemester.setBounds(200, 260, 150, 20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);

        JLabel lbltotal = new JLabel("Total Payable");
        lbltotal.setBounds(40, 300, 150, 20);
        lbltotal.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbltotal);

        labeltotal = new JLabel();
        labeltotal.setBounds(200, 300, 150, 20);
        labeltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labeltotal);

        update = new JButton("Update");
        update.setBounds(30, 380, 100, 25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        pay = new JButton("Pay Fee");
        pay.setBounds(150, 380, 100, 25);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        pay.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(pay);

        back = new JButton("Back");
        back.setBounds(270, 380, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cusn) {
            try {
                Conn c = new Conn();
                String selectedUsn = (String) cusn.getSelectedItem();
                String query = "select * from student where usn='" + selectedUsn + "'";
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    labelname.setText(rs.getString("name"));
                    labelfather_name.setText(rs.getString("father_name"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            String selectedCourse = (String) cbcourse.getSelectedItem();
            String selectedSemester = (String) cbsemester.getSelectedItem();
            try {
                Conn c = new Conn();
                String query = "select * from fee where course = '" + selectedCourse + "'";
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    labeltotal.setText(rs.getString(selectedSemester));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == pay) {
            String usn = (String) cusn.getSelectedItem();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            String total = labeltotal.getText();

            try {
                Conn c = new Conn();
                String query = "insert into collegefee values('" + usn + "', '" + course + "', '" + branch + "', '" + semester + "', '" + total + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "College fee submitted successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentFeeForm();
    }
}
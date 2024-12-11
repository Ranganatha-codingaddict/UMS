package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class EnterMarks extends JFrame implements ActionListener {

    Choice cusn;
    JComboBox<String> cbsemester, cbcie;
    JTextField tfsub1, tfsub2, tfsub3, tfsub4, tfsub5, tfsub6, tfsub7, tfsub8;
    JTextField[] tfmarks;
    JButton cancel, submit;
    JLabel[] markLabels;
    JPanel markPanel;

    EnterMarks() {
        setSize(1000, 600);
        setLocation(300, 150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 40, 400, 300);
        add(image);

        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel lblusn = new JLabel("Select USN");
        lblusn.setBounds(50, 70, 150, 20);
        add(lblusn);

        cusn = new Choice();
        cusn.setBounds(200, 70, 150, 20);
        add(cusn);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                cusn.add(rs.getString("usn"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(50, 110, 150, 20);
        add(lblsemester);

        String semester[] = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester"};
        cbsemester = new JComboBox<>(semester);
        cbsemester.setBounds(200, 110, 150, 20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel lblcie = new JLabel("Select CIE");
        lblcie.setBounds(50, 140, 150, 20);
        add(lblcie);

        String cie[] = {"IA-1", "IA-2", "IA-3", "ASSIGNMENT-1", "ASSIGNMENT-2", "QUIZ", "SEMINAR"};
        cbcie = new JComboBox<>(cie);
        cbcie.setBounds(200, 140, 150, 20);
        cbcie.setBackground(Color.WHITE);
        add(cbcie);

        cbsemester.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                updateSubjects();
            }
        });
        
        cbcie.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                updateMarksPanel();
            }
        });

        JLabel lblentersubject = new JLabel("Enter Subject");
        lblentersubject.setBounds(100, 160, 200, 40);
        add(lblentersubject);

        tfsub1 = new JTextField();
        tfsub1.setBounds(50, 200, 200, 20);
        add(tfsub1);

        tfsub2 = new JTextField();
        tfsub2.setBounds(50, 230, 200, 20);
        add(tfsub2);

        tfsub3 = new JTextField();
        tfsub3.setBounds(50, 260, 200, 20);
        add(tfsub3);

        tfsub4 = new JTextField();
        tfsub4.setBounds(50, 290, 200, 20);
        add(tfsub4);

        tfsub5 = new JTextField();
        tfsub5.setBounds(50, 320, 200, 20);
        add(tfsub5);

        tfsub6 = new JTextField();
        tfsub6.setBounds(50, 350, 200, 20);
        add(tfsub6);

        tfsub7 = new JTextField();
        tfsub7.setBounds(50, 380, 200, 20);
        add(tfsub7);

        tfsub8 = new JTextField();
        tfsub8.setBounds(50, 410, 200, 20);
        add(tfsub8);

        markPanel = new JPanel();
        markPanel.setBounds(250, 200, 200, 230);
        markPanel.setLayout(new GridLayout(8, 2, 10, 10));
        add(markPanel);

        submit = new JButton("Submit");
        submit.setBounds(70, 450, 150, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Back");
        cancel.setBounds(280, 450, 150, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                Conn c = new Conn();

                String query1 = "insert into subject values('" + cusn.getSelectedItem() + "', '" + cbsemester.getSelectedItem() + "','" + cbcie.getSelectedItem() + "', '" + tfsub1.getText() + "', '" + tfsub2.getText() + "', '" + tfsub3.getText() + "', '" + tfsub4.getText() + "', '" + tfsub5.getText() + "', '" + tfsub6.getText() + "', '" + tfsub7.getText() + "', '" + tfsub8.getText() + "')";
                StringBuilder query2 = new StringBuilder("insert into marks values('" + cusn.getSelectedItem() + "', '" + cbsemester.getSelectedItem() + "','" + cbcie.getSelectedItem() + "', ");
                for (int i = 0; i < tfmarks.length; i++) {
                    query2.append("'").append(tfmarks[i].getText()).append("'");
                    if (i < tfmarks.length - 1) query2.append(", ");
                }
                query2.append(")");

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2.toString());

                JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    private void updateSubjects() {
        String semester = (String) cbsemester.getSelectedItem();
        switch (semester) {
            case "1st Semester":
                tfsub1.setText("21MAT11");
                tfsub2.setText("21PHY12");
                tfsub3.setText("21ELE13");
                tfsub4.setText("21CIV14");
                tfsub5.setText("21EVN15");
                tfsub6.setText("21PHYL16");
                tfsub7.setText("21EGH18");
                tfsub8.setText("21IDT19/29");
                break;
            case "2nd Semester":
                tfsub1.setText("21MAT21");
                tfsub2.setText("21CHE22");
                tfsub3.setText("21PSP23");
                tfsub4.setText("21ELN24");
                tfsub5.setText("21EME25");
                tfsub6.setText("21CHEL26");
                tfsub7.setText("21CPL27");
                tfsub8.setText("21SFH19/29");
                break;
            case "3rd Semester":
                tfsub1.setText("21MAT31");
                tfsub2.setText("21CS32");
                tfsub3.setText("21CS33");
                tfsub4.setText("21CS34");
                tfsub5.setText("21CSL35");
                tfsub6.setText("21UH36");
                tfsub7.setText("21KSK37/47");
                tfsub8.setText("21CIP37/47");
                break;
            case "4th Semester":
                tfsub1.setText("21MAT41");
                tfsub2.setText("21CS42");
                tfsub3.setText("21CS43");
                tfsub4.setText("21CS44");
                tfsub5.setText("21BE45");
                tfsub6.setText("21CSL46");
                tfsub7.setText("21CS482");
                tfsub8.setText("21UH49");
                break;
            case "5th Semester":
                tfsub1.setText("21CS51");
                tfsub2.setText("21CS52");
                tfsub3.setText("21CS53");
                tfsub4.setText("21CS54");
                tfsub5.setText("21CSL55");
                tfsub6.setText("21CS56");
                tfsub7.setText("21HSS57");
                tfsub8.setText("21IOT58");
                break;
            case "6th Semester":
                tfsub1.setText("21CS61");
                tfsub2.setText("21CS62");
                tfsub3.setText("21CS63");
                tfsub4.setText("21CS642");
                tfsub5.setText("21EE652");
                tfsub6.setText("21CSL66");
                tfsub7.setText("21CSMP67");
                tfsub8.setText("21INT68");
                break;
            case "7th Semester":
                tfsub1.setText("21CS71");
                tfsub2.setText("21CS72");
                tfsub3.setText("21CS73");
                tfsub4.setText("21CS74");
                tfsub5.setText("21CSL75");
                tfsub6.setText("21CS76");
                tfsub7.setText("21CS77");
                tfsub8.setText("21IOT78");
                break;
            case "8th Semester":
                tfsub1.setText("21CS81");
                tfsub2.setText("21CS82");
                tfsub3.setText("21CS83");
                tfsub4.setText("21CS84");
                tfsub5.setText("21CSL85");
                tfsub6.setText("21CS86");
                tfsub7.setText("21CS87");
                tfsub8.setText("21IOT88");
                break;
        }
    }

    private void updateMarksPanel() {
        markPanel.removeAll();
        String cie = (String) cbcie.getSelectedItem();

        String[] subjects = {tfsub1.getText(), tfsub2.getText(), tfsub3.getText(), tfsub4.getText(), tfsub5.getText(), tfsub6.getText(), tfsub7.getText(), tfsub8.getText()};
        markLabels = new JLabel[8];
        tfmarks = new JTextField[8];

        for (int i = 0; i < subjects.length; i++) {
            markLabels[i] = new JLabel(subjects[i] + " " + cie + " Marks");
            tfmarks[i] = new JTextField();
            markPanel.add(markLabels[i]);
            markPanel.add(tfmarks[i]);
        }

        markPanel.revalidate();
        markPanel.repaint();
    }

    public static void main(String[] args) {
        new EnterMarks();
    }
}

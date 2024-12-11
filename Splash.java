package university.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Thread t;
    Splash () {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,600, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        
        add(image);
        t= new Thread(this);
        t.start();
        
        setVisible(true);
        
        int X=1;
        for (int i=2; i<=500; i+=4, X+=1) {
            setLocation(500-((i+X)/2), 350-(i/2));
            setSize(i+3*X, i+X/2);
        
            try {
                Thread.sleep(10);
            }   catch (Exception e){}
        }
        
                
    }
    public void run () {
        try {
            Thread.sleep(7000);
            setVisible(false);
            //NEXT FRAME
            new Login();
//            new Project();
        } catch (Exception e) {
        }
    }
                                                     
    public static void main(String [] args) {
        new Splash();
    }
    
}


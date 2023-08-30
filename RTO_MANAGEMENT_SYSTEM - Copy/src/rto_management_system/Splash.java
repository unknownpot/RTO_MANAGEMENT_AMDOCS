package rto_management_system;
import javax.swing.*;

public class Splash extends JFrame implements Runnable{
    Thread t;
    Splash(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/wallpaper.jpg"));
        JLabel image=new JLabel(i1);
        add(image);
         setVisible(true);
         
        setSize(1200,750);
        setLocation(400,120);
        t=new Thread(this);
        t.start(); //calls run function
    }
  
    public void run(){
        try {
            Thread.sleep(3000);
            setVisible(false);
            
            // login frame
            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args ){
        new Splash(); //anonymous object
    }
}

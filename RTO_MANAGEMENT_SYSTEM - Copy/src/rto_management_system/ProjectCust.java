package rto_management_system;

import javax.swing.*;
import java.awt.*;//this is a image package to use image we have to use this 
import java.awt.event.*;//this is a package for the Actionlistener but we  

public class ProjectCust extends JFrame implements ActionListener{
    JButton Sco,look,Sc,Li,ex,ui;
    String con;
    ProjectCust(String con)//constructor 
    {    this.con=con;
                    
        setTitle("Road Transport Office");//provide the title to the screen 
        
        setLayout(null);//to enable our default screen we use this statement
        
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icon/RTOLogion.jpg"));//class to import image i1=object
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);//we are scaling the image as default
        ImageIcon i3 =new ImageIcon(i2);//in jlable we cant push the iamge direcltly so in this we can push imageicon only
        JLabel label = new JLabel(i3);//to paste the image on frame bcz cant do directly
        label.setBounds(100,100,100,100);//the major use of the jbale is to type or provide frame to text but alsoi use tthe dimesiono set
        add(label);//to place on the frame 
        
        ImageIcon i4 =new ImageIcon(ClassLoader.getSystemResource("icon/images.png"));//class to import image i1=object
        Image i5 = i4.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);//we are scaling the image as default
        ImageIcon i6 =new ImageIcon(i5);//in jlable we cant push the iamge direcltly so in this we can push imageicon only
        JLabel labe = new JLabel(i6);//to paste the image on frame bcz cant do directly
        labe.setBounds(800,250,700,500);//the major use of the jbale is to type or provide frame to text but alsoi use tthe dimesiono set
        add(labe);//to place on the frame 
        
        
        JLabel text= new JLabel("Welcome To RTO");//to add the text on the frame
        text.setFont(new Font("Osward",Font.BOLD,40));//here we set the font and size
        text.setBounds(250, 100, 600, 100);//if we dont add the Bounds then it cant see on the screen
        add(text);
//        JTextField check= new JTextField();
//        check.setBounds(650,250,200,50);
//        add(check);
        JLabel data= new JLabel("Choose Category : ");//to add the text on the frame
        data.setFont(new Font("Osward",Font.BOLD,40));//here we set the font and size
        data.setBounds(250, 250, 600, 50);//if we dont add the Bounds then it cant see on the screen
        add(data);// to add on the screen object text
       
        
        Sco = new JButton("New Registration");
        Sco.setBounds(250, 340, 300, 80);
        Sco.setFont(new Font("Osward",Font.BOLD,20));
        Sco.setForeground(Color.WHITE);
        Sco.setBackground(Color.BLACK);
        Sco.addActionListener(this);//add the acxtion listener which teels us  that the botton is clicked
        add(Sco);
        
 
        
        look = new JButton("Vehicle Lookup");//for botton
        look.setBounds(250, 430, 300, 80);
        look.setFont(new Font("Osward",Font.BOLD,20));
        look.setForeground(Color.WHITE);
        look.setBackground(Color.BLACK);
        look.addActionListener(this);
        add(look);//imp to add
         
        
        Sc = new JButton("View Info");
        Sc.setBounds(250, 520, 300, 80);
        Sc.setFont(new Font("Osward",Font.BOLD,20));
        Sc.setForeground(Color.WHITE);
        Sc.setBackground(Color.BLACK);
        Sc.addActionListener(this);
        add(Sc);
        
        ui = new JButton("Update Info");
        ui.setBounds(250, 610, 300, 80);
        ui.setFont(new Font("Osward",Font.BOLD,20));
        ui.setForeground(Color.WHITE);
        ui.setBackground(Color.BLACK);
        ui.addActionListener(this);
        add(ui);
        
        Li = new JButton("Apply License");
        Li.setBounds(250, 700, 300, 80);
        Li.setFont(new Font("Osward",Font.BOLD,20));
        Li.setForeground(Color.WHITE);
        Li.setBackground(Color.BLACK);
        Li.addActionListener(this);
        add(Li);
        
        
        ex = new JButton("Exit");
        ex.setBounds(250, 790, 300, 80);
        ex.setFont(new Font("Osward",Font.BOLD,20));
        ex.setForeground(Color.WHITE);
        ex.setBackground(Color.BLACK);
        ex.addActionListener(this);
        add(ex);
        
        
        
        getContentPane().setBackground(Color.WHITE);//used to set the background color 
        setExtendedState(JFrame.MAXIMIZED_BOTH); //fuction to set frame
        setVisible(true);//fuction to see frame
      //  setLocation(450,50);//to set the frame in the window
    }
    public static void main(String[] args) {
        new ProjectCust("");//object
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==Sco)
        {   new NewReg();
            setVisible(false);
        }
        else if(ae.getSource()==look)
        {
            new VehLook(con);
            setVisible(false);

        }
        else if(ae.getSource()==Sc)
        {
                       new View_Info(con);
                       setVisible(false);
                       
        }

        
        else if(ae.getSource()==Li)
        {
            new Lic_Apply();
                        setVisible(false);

        }
        else if(ae.getSource()==ui)
        {
            new UpdateInfo(con);            
            setVisible(false);

        }
        else if(ae.getSource()==ex)
        {
            setVisible(false);
            new Login();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rto_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.ArrayList;

/**
 *
 * @author saranshg
 */
import javax.swing.*;
import java.awt.*;//this is a image package to use image we have to use this 
import java.awt.event.*;//this is a package for the Actionlistener but we  

public class VehLook extends JFrame implements ActionListener{
    JButton Sco,look,Sc,Li,ex,ui;
    JTextField text1;
    JLabel t1,t2;
    CosLook l = new CosLook();
    ArrayList<ArrayList<String>>  as;
    String con;
    VehLook(String con)//constructor 
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
        JLabel data= new JLabel("Enter Vehicle Number : ");//to add the text on the frame
        data.setFont(new Font("Osward",Font.BOLD,40));//here we set the font and size
        data.setBounds(250, 250, 600, 50);//if we dont add the Bounds then it cant see on the screen
        add(data);// to add on the screen object text
       
        
        text1 = new JTextField();
        text1.setFont(new Font("Serif",Font.BOLD,24));
        text1.setBounds(250,310, 200,50);  
        add(text1);
	     
        Sco = new JButton("SEARCH");
        Sco.setBounds(250, 380, 300, 50);
        Sco.setFont(new Font("Serif",Font.BOLD,30));
        Sco.setForeground(Color.WHITE);
        Sco.setBackground(Color.BLACK);
        Sco.addActionListener(this);//add the acxtion listener which teels us  that the botton is clicked
        add(Sco);
        
        
        
        t1=new JLabel();  
	t1.setFont(new Font("Serif", Font.PLAIN, 24));
        t1.setForeground(Color.red);
	t1.setBounds(250,450, 200,50);
        t1.setVisible(false);
	add(t1);
        

        t2=new JLabel();  
	t2.setFont(new Font("Serif", Font.PLAIN, 24));
        t2.setForeground(Color.red);
	t2.setBounds(250,530, 200,50); 
        t2.setVisible(false);
	add(t2);
        
        ex = new JButton("Exit");
        ex.setBounds(250, 600, 300, 50);
        ex.setFont(new Font("Osward",Font.BOLD,20));
        ex.setForeground(Color.WHITE);
        ex.setBackground(Color.BLACK);
        ex.addActionListener(this);
        add(ex);
        
        
        
        getContentPane().setBackground(Color.WHITE);//used to set the background color
        setSize(1600,900);
        //setExtendedState(JFrame.MAXIMIZED_BOTH); //fuction to set frame
        setVisible(true);//fuction to see frame
        //setLocation(0,50);//to set the frame in the window
    }
    public static void main(String[] args) {
        new VehLook("");//object
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==Sco)
        {
            as = l.search("Customer","vehicleno",text1.getText());
            if(as.size()>0)
            {
                t1.setText(as.get(0).get(0));
                t2.setText(as.get(0).get(3));
                t1.setVisible(true);
                t2.setVisible(true);
            }
            else
            {
                t1.setText("Invalid Vehicle No.");
                t1.setVisible(true);
            }
        }
        else if(ae.getSource()==ex)
        {
            setVisible(false);
            new ProjectCust(con);
        }
    }
}

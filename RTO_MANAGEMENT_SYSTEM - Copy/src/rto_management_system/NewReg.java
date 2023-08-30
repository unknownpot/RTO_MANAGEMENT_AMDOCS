package rto_management_system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.*;

public class NewReg extends JFrame implements ActionListener  {
    JButton back,submit;
    JTextField name,addr,cont,type,model,chasis,number;
    NewReg(){
        
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icon/RTOLogion.jpg"));//class to import image i1=object
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);//we are scaling the image as default
        ImageIcon i3 =new ImageIcon(i2);//in jlable we cant push the iamge direcltly so in this we can push imageicon only
        JLabel label = new JLabel(i3);//to paste the image on frame bcz cant do directly
        label.setBounds(900,0,150,90);//the major use of the jbale is to type or provide frame to text but alsoi use tthe dimesiono set
        add(label);//to place on the frame 
        
        JLabel text= new JLabel("Welcome To RTO,Register Your Vehicle Here...");//to add the text on the frame
        text.setFont(new Font("Tahoma",Font.BOLD,40));//here we set the font and size
        text.setBounds(500, 45, 3000, 140);//if we dont add the Bounds then it cant see on the screen
        add(text);
         setLayout(null);
         
        ImageIcon i4 =new ImageIcon(ClassLoader.getSystemResource("icon/images.png"));//class to import image i1=object
        Image i5 = i4.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);//we are scaling the image as default
        ImageIcon i6 =new ImageIcon(i5);//in jlable we cant push the iamge direcltly so in this we can push imageicon only
        JLabel labe = new JLabel(i6);//to paste the image on frame bcz cant do directly
        labe.setBounds(990,250,700,500);//the major use of the jbale is to type or provide frame to text but alsoi use tthe dimesiono set
        add(labe);
        
         
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(90, 230, 300, 30);
        lblname.setForeground(Color.GRAY);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(lblname);
       
        
       name = new JTextField();
       name.setBounds(490, 230, 350, 30);
       add(name);
        
        JLabel lbladdr = new JLabel("Address");
        lbladdr.setBounds(90, 300, 300, 30);
        lbladdr.setForeground(Color.GRAY);
        lbladdr.setFont(new Font("Tahoma", Font.BOLD, 30));
       add(lbladdr);
        
         addr = new JTextField();
        addr.setBounds(490, 300, 350, 50);
        add(addr);
        
        JLabel lblcont = new JLabel("Contact No.");
        lblcont.setBounds(90, 370, 300, 30);
        lblcont.setForeground(Color.GRAY);
        lblcont.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(lblcont);
        
         cont = new JTextField();
        cont.setBounds(490, 370, 350, 30);
        add(cont);
        
        JLabel lblnumber = new JLabel("Vehicle No.");
        lblnumber.setBounds(90, 440, 300, 30);
        lblnumber.setForeground(Color.GRAY);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(lblnumber);
        
        number = new JTextField();
        number.setBounds(490, 440, 350, 30);
        add(number);
        
        
         JLabel lbltype = new JLabel("Vehicle Type");
        lbltype.setBounds(90, 510, 300, 30);
        lbltype.setForeground(Color.GRAY);
        lbltype.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(lbltype);
        
         type = new JTextField();
        type.setBounds(490, 510, 350, 30);
        add(type);
        
        JLabel lblmodel = new JLabel("Vehicle Model");
        lblmodel.setBounds(90, 580, 300, 30);
        lblmodel.setForeground(Color.GRAY);
        lblmodel.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(lblmodel);
        
         model = new JTextField();
        model.setBounds(490, 580, 350, 30);
        add(model);
        
         JLabel lblchasis = new JLabel("Chasis No.");
        lblchasis.setBounds(90, 650, 300, 30);
        lblchasis.setForeground(Color.GRAY);
        lblchasis.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(lblchasis);
        
         chasis = new JTextField();
        chasis.setBounds(490, 650, 350, 30);
        add(chasis);
         
        submit = new JButton("Create");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250, 775, 120, 45);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,20));
        add(submit);

       back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(550, 775, 120, 45);
       back.addActionListener(this);
       back.setFont(new Font("Tahoma",Font.BOLD,20));
        add(back);
        
        
        
        
        
        
        
        getContentPane().setBackground(Color.WHITE);//used to set the background color 
        setExtendedState(JFrame.MAXIMIZED_BOTH); //fuction to set frame
        setVisible(true);
        
    }
    public static void main(String[] args)
    {
       new NewReg();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
            if(ae.getSource()==back)
           {  
                JOptionPane.showMessageDialog(null, "Please Login Again Once");
                 setVisible(false);
                 new Login();
           }
           else if(ae.getSource()==submit)
           {
                   //JTextField name,addr,cont,type,model,chasis,number;
                 
                 String aname=name.getText();
                 String aaddr=addr.getText();
                 String atype=type.getText();
                 String acontact=cont.getText();
                 String amodel=model.getText();
                 String achasis=chasis.getText();
                 String anumber=number.getText();
                 
                 try{
                     Conn c=new Conn();
                     String query=" insert into new_reg values('"+aname+"','"+aaddr+"','"+acontact+"','"+anumber+"','"+atype+"','"+amodel+"','"+achasis+"')";
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "Vehicle Registered Succesfully");
                 JOptionPane.showMessageDialog(null, "Please Login Again Once");
                 setVisible(false);
                 new ProjectCust("");
                 }catch(Exception e){
                     e.printStackTrace();
                     
                 }
           } 
        
    }
}

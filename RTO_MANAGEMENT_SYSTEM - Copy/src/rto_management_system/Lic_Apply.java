package rto_management_system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.*;

public class Lic_Apply extends JFrame implements ActionListener  {
    JButton back,submit;
    JTextField name,addr,cont,model,chasis,number,dob;
    Choice type;
    Lic_Apply(){
        
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icon/RTOLogion.jpg"));//class to import image i1=object
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);//we are scaling the image as default
        ImageIcon i3 =new ImageIcon(i2);//in jlable we cant push the iamge direcltly so in this we can push imageicon only
        JLabel label = new JLabel(i3);//to paste the image on frame bcz cant do directly
        label.setBounds(900,0,150,90);//the major use of the jbale is to type or provide frame to text but alsoi use tthe dimesiono set
        add(label);//to place on the frame 
        
        JLabel text= new JLabel("Apply For License Here...");//to add the text on the frame
        text.setFont(new Font("Tahoma",Font.BOLD,40));//here we set the font and size
        text.setBounds(700, 45, 3000, 140);//if we dont add the Bounds then it cant see on the screen
        add(text);
         setLayout(null);
         
        ImageIcon i4 =new ImageIcon(ClassLoader.getSystemResource("icon/lic.jpg"));//class to import image i1=object
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
        

        
        
         JLabel lbltype = new JLabel("License Type");
        lbltype.setBounds(90, 440, 300, 30);
        lbltype.setForeground(Color.GRAY);
        lbltype.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(lbltype);
        
        type = new Choice();
        type.add("MCWG");
        type.add("LMV");
        type.add("BOTH");
        type.setBounds(490, 440, 350, 50);
        type.setFont(new Font("Tahoma", Font.BOLD, 20));
        type.setForeground(Color.darkGray);
        add(type);
        
        JLabel lbldob = new JLabel("DOB (dd/mm/yyyy)");
        lbldob.setBounds(90, 510, 390, 30);
        lbldob.setForeground(Color.GRAY);
        lbldob.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(lbldob);
        
         dob = new JTextField();
        dob.setBounds(490, 510, 350, 30);
        add(dob);
        
     
        
         
        

        
       
         
        submit = new JButton("Apply");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250, 620, 120, 45);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,20));
        add(submit);

       back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(550, 620, 120, 45);
       back.addActionListener(this);
       back.setFont(new Font("Tahoma",Font.BOLD,20));
        add(back);
        
        
        
        
        
        
        
        getContentPane().setBackground(Color.WHITE);//used to set the background color 
        setExtendedState(JFrame.MAXIMIZED_BOTH); //fuction to set frame
        setVisible(true);
        
    }
    public static void main(String[] args)
    {
       new Lic_Apply();
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
                 String atype=type.getSelectedItem();
                 String acontact=cont.getText();
                 String adob=dob.getText();
                 String lastfour=adob.substring(adob.length() - 4);
                 int number = Integer.parseInt(lastfour);
                 if(2023-number<18)
                 {
                  JOptionPane.showMessageDialog(null, "Not Eligible");
                 setVisible(false);
                 }
                 else{
                 try{
                     Conn c=new Conn();
                     String query=" insert into license values('"+aname+"','"+acontact+"','"+atype+"','"+adob+"','"+aaddr+"')";
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "License Applied Succesfully");
                 setVisible(false);
                 new ProjectCust("");
                 }catch(Exception e){
                     e.printStackTrace();
                     
                 }
                 }
           } 
        
    }
}

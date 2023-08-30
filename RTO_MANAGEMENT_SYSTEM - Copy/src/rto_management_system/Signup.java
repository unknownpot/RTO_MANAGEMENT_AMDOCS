package rto_management_system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Signup extends JFrame implements ActionListener{
    JButton back,create;
    JTextField username,lblpasss,contact,name,dob;
    Choice accountType;
    Signup()
    {
        getContentPane().setBackground(Color.PINK);
        setBounds(600,290,700,400);
        setLayout(null); //to null default layoutby swing

        JLabel createacc=new JLabel("Create Account") ;
        createacc.setFont(new Font("Tahoma",Font.BOLD,20));
        createacc.setBounds(230,1,200,20);
         add(createacc);
        
        JLabel heading = new JLabel("Create Account As");
        heading.setBounds(60,50, 130, 20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tahoma",Font.BOLD,14));
        add(heading);
        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260, 50, 150, 20);
        add(accountType);
        
        
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 90, 140, 20);
        lblname.setForeground(Color.GRAY);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblname);
        
         name = new JTextField();
        name.setBounds(260, 90, 150, 20);
        add(name);
        
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 130, 140, 20);
        lblusername.setForeground(Color.GRAY);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblusername);
        
         username = new JTextField();
        username.setBounds(260, 130, 150, 20);
        add(username);
        
        
         JLabel lblpass = new JLabel("Password");
        lblpass.setBounds(60, 170, 140, 20);
        lblpass.setForeground(Color.GRAY);
        lblpass.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblpass);
        
        lblpasss = new JPasswordField();
        lblpasss.setBounds(260, 170, 150, 20);
        add(lblpasss);
        
         JLabel lbldob = new JLabel("Date Of Birth(dd/mm/yyyy)");
        lbldob.setBounds(60, 210, 240, 20);
        lbldob.setForeground(Color.GRAY);
        lbldob.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lbldob);
        
         dob = new JTextField();
       // setPlaceholder(dob,"dd/mm/yyyy");
        dob.setBounds(260, 210, 150, 20);
        add(dob);
        
        JLabel lblcontact = new JLabel("Contact No.");
        lblcontact.setBounds(60, 250, 140, 20);
        lblcontact.setForeground(Color.GRAY);
        lblcontact.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblcontact);
        
         contact = new JTextField();
        contact.setBounds(260, 250, 150, 20);
        add(contact);
        

        create = new JButton("Create");
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setBounds(120, 290, 120, 25);
        create.addActionListener(this);
        add(create);

       back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(280, 290, 120, 25);
       back.addActionListener(this);
        add(back);
   
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(415, 30, 250, 250);
        add(image);
         
        setVisible(true);
    }
    
     //JTextField username,lblpasss,contact,name,dob;
    //Choice accountType;
         public void actionPerformed(ActionEvent ae)//actionevent tells which button got triggered
         {
           if(ae.getSource()==back)
           {  
               setVisible(false);
                new Login();
           }
           else if(ae.getSource()==create)
           {
                 String atype=accountType.getSelectedItem();
                 String auser=username.getText();
                 String apass=lblpasss.getText();
                 String acontact=contact.getText();
                 String aname=name.getText();
                 String adob=dob.getText();
                 
                 try{
                     Conn c=new Conn();
                     String query=" insert into login values('"+aname+"','"+auser+"','"+apass+"','"+adob+"','"+acontact+"','"+atype+"')";
                 
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "Acocunt created Succesfully");
                 setVisible(false);
                 new Login();
                 }catch(Exception e){
                     e.printStackTrace();
                     
                 }
           } 
          
         
         
         }
    
    public static void main(String[] args)
    {
        new Signup();
    }

    private void setPlaceholder(JTextField dob, String ddmmyyyy) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

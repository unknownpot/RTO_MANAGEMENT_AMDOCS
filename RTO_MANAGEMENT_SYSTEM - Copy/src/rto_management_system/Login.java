
package rto_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
  JButton login,cancel,Signup;  
  JTextField usern;
  JPasswordField passn;
   Choice  logginin ;
  
        Login(){
       super("LOGIN PAGE"); //frame heading
       setLayout(null); //to null default layoutby swing
        setVisible(true);
        JLabel username=new JLabel("Username") ;
        username.setBounds(300,20,100,20);
         add(username);
         
          usern=new JTextField();
         usern.setBounds(400,20,150,20);
          add(usern);
          
         JLabel pass=new JLabel("Password") ;
        pass.setBounds(300,50,100,40);
         add(pass);
         
           passn=new JPasswordField();
         passn.setBounds(400,50,150,20);
          add(passn);
         
         JLabel loginAs=new JLabel("Logging In As") ;
        loginAs.setBounds(300,80,100,40);
         add(loginAs);
         
        logginin = new Choice();
        logginin.add("Admin");
        logginin.add("Customer");
        logginin.setBounds(400, 87, 150, 20);
        add(logginin);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
         login=new JButton("Login", new ImageIcon(i2));
        login.setBounds(330, 160, 100, 20);
       login.addActionListener(this);
         add(login);
         
         ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i4 = i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
          cancel=new JButton("cancel", new ImageIcon(i4));
         cancel.setBounds(450, 160, 100, 20);
         cancel.addActionListener(this);
         add(cancel);
         
          ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i6 = i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
          Signup=new JButton("Sign up",new ImageIcon(i6));
         Signup.setBounds(390, 200, 100, 20);
         Signup.addActionListener(this);
         add(Signup);
         
          ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/second.png"));
        Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(0, 0, 250, 250);
        add(image);
         
         
        getContentPane().setBackground(Color.PINK);
        setSize(640, 300);
        setLocation(600, 350);
       
       
    }
         public void actionPerformed(ActionEvent ae)//actionevent tells which button got triggered
         {
           if(ae.getSource()==login)
           {
               String auser=usern.getText();
               String apass=passn.getText();
               String atype=logginin.getSelectedItem();
               String s1="Admin",s2="Customer";
               if(atype.equals(s1))
               {
                 try{
                   Conn c=new Conn();
                   String query="select * from login where username = '"+auser+"' and password = '"+apass+"' and user = '"+atype+"'";
                  ResultSet rs = c.s.executeQuery(query);
                    
                  
                  if (rs.next()) 
                  {
                    setVisible(false);
                    new Project();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    usern.setText("");
                    passn.setText("");
                }
               }catch(Exception e){
                   e.printStackTrace();
               }
               }
               else if(atype.equals(s2)){
                                  try{
                   Conn c=new Conn();
                   String query="select * from login where username = '"+auser+"' and password = '"+apass+"' and user = '"+atype+"'";
                  ResultSet rs = c.s.executeQuery(query);
                    
                  
                  if (rs.next()) 
                  {
                    String Contact=rs.getString("phone");
                    setVisible(false);
                    new ProjectCust(Contact);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    usern.setText("");
                    passn.setText("");
                }
               }catch(Exception e){
                   e.printStackTrace();
               }
               }

              
               
           }
           else if(ae.getSource()==Signup)
           {
               setVisible(false); 
               new Signup();
           } 
           else if(ae.getSource()==cancel)
           {
               setVisible(false);
           }
         
         
         }
    
    public static void main(String[] args)
    {
        new Login();
    }
}

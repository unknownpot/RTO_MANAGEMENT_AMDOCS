package rto_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class View_Info extends JFrame implements ActionListener{
     JButton back,submit;
    String con;
    View_Info(String con) {
      
        this.con=con;
        
           JLabel text= new JLabel("Welcome To RTO, Personal Information");//to add the text on the frame
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
       
        
       JLabel name = new JLabel("");
       name.setBounds(490, 230, 350, 30);
       name.setForeground(Color.black);
       name.setFont(new Font("Osward", Font.BOLD, 27));
       add(name);
        
        JLabel lbladdr = new JLabel("Address");
        lbladdr.setBounds(90, 300, 300, 30);
        lbladdr.setForeground(Color.GRAY);
        lbladdr.setFont(new Font("Tahoma", Font.BOLD, 30));
       add(lbladdr);
      
       
        JLabel addr = new JLabel("");
       addr.setBounds(490, 300, 350, 30);
              addr.setForeground(Color.black);
       addr.setFont(new Font("Osward", Font.BOLD, 27));
       add(addr);
        
        
        JLabel lblcont = new JLabel("Contact No.");
        lblcont.setBounds(90, 370, 300, 30);
        lblcont.setForeground(Color.GRAY);
        lblcont.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(lblcont);
        
        JLabel cont = new JLabel("");
       cont.setBounds(490, 370, 350, 30);
              cont.setForeground(Color.black);
       cont.setFont(new Font("Osward", Font.BOLD, 27));
       add(cont);
        
        JLabel lblnumber = new JLabel("Vehicle No.");
        lblnumber.setBounds(90, 440, 300, 30);
        lblnumber.setForeground(Color.GRAY);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(lblnumber);
        
      
          JLabel number = new JLabel("");
       number.setBounds(490, 440, 350, 30);
              number.setForeground(Color.black);
       number.setFont(new Font("Osward", Font.BOLD, 27));
       add(number);
        
         JLabel lbltype = new JLabel("Vehicle Type");
        lbltype.setBounds(90, 510, 300, 30);
        lbltype.setForeground(Color.GRAY);
        lbltype.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(lbltype);
        
       JLabel type = new JLabel("");
       type.setBounds(490, 510, 350, 30);
              type.setForeground(Color.black);
       type.setFont(new Font("Osward", Font.BOLD, 27));
       add(type);
        
        JLabel lblmodel = new JLabel("Vehicle Model");
        lblmodel.setBounds(90, 580, 300, 30);
        lblmodel.setForeground(Color.GRAY);
        lblmodel.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(lblmodel);
        
        JLabel model = new JLabel("");
       model.setBounds(490, 580, 350, 30);
        model.setForeground(Color.black);
       model.setFont(new Font("Osward", Font.BOLD, 27));
       add(model);
    
        
         JLabel lblchasis = new JLabel("Chasis No.");
        lblchasis.setBounds(90, 650, 300, 30);
        lblchasis.setForeground(Color.GRAY);
        lblchasis.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(lblchasis);
        
       
    
        JLabel chasis = new JLabel("");
       chasis.setBounds(490, 650, 350, 30);
       chasis.setForeground(Color.black);
       chasis.setFont(new Font("Osward", Font.BOLD, 27));
       add(chasis);

       back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 775, 120, 45);
       back.addActionListener(this);
       back.setFont(new Font("Tahoma",Font.BOLD,20));
        add(back);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Customer where number = '"+con+"'");
            while(rs.next()) {
                name.setText(rs.getString("name"));
                addr.setText(rs.getString("addr"));
                cont.setText(rs.getString("number"));
                number.setText(rs.getString("vehicleno"));
               type.setText(rs.getString("type"));
                model.setText(rs.getString("model"));
                chasis.setText(rs.getString("chasis"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
     getContentPane().setBackground(Color.WHITE);//used to set the background color 
        setExtendedState(JFrame.MAXIMIZED_BOTH); //fuction to set frame
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back)
        {
                    setVisible(false);
                   new ProjectCust(con);

        }
    }
    
    public static void main(String[] args) {
        new View_Info("");
    }
}
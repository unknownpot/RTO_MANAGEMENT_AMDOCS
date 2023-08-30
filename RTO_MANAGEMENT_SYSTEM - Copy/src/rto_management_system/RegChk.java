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
import javax.swing.table.TableColumnModel;//this is a image package to use image we have to use this 

public class RegChk extends JFrame implements ActionListener{
    JButton ex,ap,de;
    String data[][];
    JScrollPane sp;
    CosLook l = new CosLook();
    JTable jt;
    JPanel panel;
    ArrayList<ArrayList<String>>  as;
    RegChk()//constructor 
    {
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
        labe.setBounds(1000,250,700,500);//the major use of the jbale is to type or provide frame to text but alsoi use tthe dimesiono set
        add(labe);//to place on the frame 
        
        JLabel text= new JLabel("Welcome To RTO");//to add the text on the frame
        text.setFont(new Font("Osward",Font.BOLD,40));//here we set the font and size
        text.setBounds(250, 100, 600, 100);//if we dont add the Bounds then it cant see on the screen
        add(text);
        
        panel=new JPanel();  
        panel.setBounds(250,200,600,500);
        
        jt = createTable();
        sp=new JScrollPane(jt);
	panel.add(sp);          
        add(panel);  

        ap = new JButton("Approve");
        ap.setBounds(250, 720, 250, 50);
        ap.setFont(new Font("Osward",Font.BOLD,20));
        ap.setForeground(Color.WHITE);
        ap.setBackground(Color.BLACK);
        ap.addActionListener(this);
        add(ap);
        
        de = new JButton("Delete");
        de.setBounds(600, 720, 250, 50);
        de.setFont(new Font("Osward",Font.BOLD,20));
        de.setForeground(Color.WHITE);
        de.setBackground(Color.BLACK);
        de.addActionListener(this);
        add(de);
        
        ex = new JButton("Exit");
        ex.setBounds(250, 850, 300, 50);
        ex.setFont(new Font("Osward",Font.BOLD,20));
        ex.setForeground(Color.WHITE);
        ex.setBackground(Color.BLACK);
        ex.addActionListener(this);
        add(ex);
        
        
        
        getContentPane().setBackground(Color.WHITE);//used to set the background color
        //setSize(1600,900);
        setExtendedState(JFrame.MAXIMIZED_BOTH); //fuction to set frame
        setVisible(true);//fuction to see frame
        //setLocation(0,50);//to set the frame in the window
    }
    public static void main(String[] args) {
        new RegChk();//object
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==ex)
        {
            setVisible(false);
            new Project();
        }
        else if(ae.getSource()==de)
        {
            panel.remove(sp);
            panel.repaint();
            String a[] = data[jt.getSelectedRow()];
            l.delete("new_reg", "number", a[2]);
            System.out.println("Delete success");
             JOptionPane.showMessageDialog(null, "Delete successful");
            jt = createTable();
            sp=new JScrollPane(jt);
            panel.add(sp);
            
        }
        else if(ae.getSource()==ap)
        {
            String a[] = data[jt.getSelectedRow()];
            l.insert(a[0], a[1],a[2],a[3],a[4],a[5],a[6]);
            l.delete("new_reg", "number", a[2]);
            System.out.println("Update success");
            JOptionPane.showMessageDialog(null, "Succesfully Approved");
            panel.remove(sp);
            panel.repaint();
            jt = createTable();
            sp=new JScrollPane(jt);
            panel.add(sp);
            
        }
    }
    
    public JTable createTable()
    {
        data = l.toarray(l.search("new_reg"));
        String column[] = {"Name","Address", "Contact", "Vehicle No.", "Type", "Model", "Chassis"};
        jt=new JTable(data,column)
        {
                public boolean isCellEditable(int row,int column)
            {switch(column){
                case 6:
                  return true;
              default: return false;}
            }
        }; 
//        for(int i = 0;i < data[0].length; i++) {
//         jt.setValueAt(Boolean.FALSE, i, 7);
//        }
        jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel columnModel = jt.getColumnModel();
        for (int i = 0; i < 6; i++) {
                columnModel.getColumn(i).setPreferredWidth(100);
        }
        jt.setSize(500,300);
        
        return jt;
    }
}

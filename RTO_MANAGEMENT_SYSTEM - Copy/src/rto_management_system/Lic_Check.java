package rto_management_system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import javax.swing.table.JTableHeader;

public class Lic_Check extends JFrame implements ActionListener{

    Choice meternumber, cmonth;
    JTable table;
    JButton  print,back;
    
    Lic_Check(){
        super("Customer Details");
        
        setSize(1200, 650);
        setLocation(200, 150);
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from License");
            
           table.setModel(DbUtils.resultSetToTableModel(rs));
           JTableHeader Theader = table.getTableHeader();
           Theader.setBackground(Color.pink); 
           Theader.setFont(new Font("Tahome", Font.BOLD, 20));
            table.setFont(new Font("Tahome", Font.BOLD, 15));
              
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        add(sp);
        
        print = new JButton("Print");
        print.addActionListener(this);
        print.setFont(new Font("Tahoma",Font.BOLD,15));
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        add(print, "South");
        
        back = new JButton("Back");
        back.addActionListener(this);
        back.setFont(new Font("Tahoma",Font.BOLD,15));
        add(back, "East");
         back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        
    getContentPane().setBackground(Color.WHITE);//used to set the background color 
        setExtendedState(JFrame.MAXIMIZED_BOTH); //fuction to set frame
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back){
            setVisible(false);
            new Project();
        }
        else{
               try {
            table.print();
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }}
 
    }

    public static void main(String[] args) {
        new Lic_Check();
    }
}

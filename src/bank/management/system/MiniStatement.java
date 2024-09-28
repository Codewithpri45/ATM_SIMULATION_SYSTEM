package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends  JFrame{

    public MiniStatement(String pinnumber) {
        
        setTitle("MINI STATEMENT");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        add(mini);
        
        
        JLabel bank = new JLabel("NATIONAL BANK");
        bank.setFont( new Font("System",Font.BOLD,14));
        bank.setBounds(125,25,150,23);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(45,90,300,23);
        add(card);
        
        JLabel balnce = new JLabel();
        balnce.setBounds(45, 350, 300,23 );
        balnce.setFont(new Font("Raleway", Font.BOLD,12));
        add(balnce);
        
        
      
        try {
              Conn c= new Conn();
              ResultSet rs= c.s.executeQuery("select * from login where pin_Number='"+pinnumber+"'");
              
              while(rs.next())
              {
                  card.setText("Card Number: "+rs.getString("card_Number").substring(0,4)+"XXXXXXXX"+ rs.getString("card_Number").substring(12));
              }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            int bal=0;
            Conn c=  new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
            
            while(rs.next())
            {
              mini.setText(mini.getText() +"<html>"+ rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type") +"&nbsp;&nbsp;&nbsp;"+ rs.getString("amount")+"<br><br><html>");
              
             if (rs.getString("type").equals("Deposit"))
                    {
                       bal+= Integer.parseInt(rs.getString("amount"));
                    }
                    else
                    {
                        bal -= Integer.parseInt(rs.getString("amount"));
                     
            }
            }
            balnce.setText("Your Current Account Balance is : "+bal);
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
        mini.setBounds(45, 140, 300, 150);
                
        setSize(400,450);
        setLocation(20,30);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
    }
  
   
    public static void main(String[] args) {
        
        new MiniStatement("");
    }
}

package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.Date;

public class FastCash  extends JFrame implements  ActionListener{

   JButton  hundred,fivehundred,onethousand,twothousand,fivethousand ,tenthousand,exit;
  String pinnumber;
     FastCash( String pin)  {
        this.pinnumber=pin;
        setLayout(null);
    
    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
     Image i2 = i1.getImage().getScaledInstance(650, 610, Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel image = new JLabel(i3);
     image.setBounds(0,0,650,610);
     add(image);
     
     JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
     text.setBounds(150, 200, 500, 23);
     text.setForeground(Color.WHITE);
     text.setFont( new Font("System",Font.BOLD,12));
     image.add(text);
     
     hundred = new JButton("Rs 100");
     hundred.setBounds(120,283,110,18);
     hundred.addActionListener(this);
     image.add(hundred);
      
     
     fivehundred= new JButton("Rs 500");
     fivehundred.setBounds(258,283,110,18);
     fivehundred.addActionListener(this);
     image.add(fivehundred);
     
     onethousand = new JButton("Rs 1000");
     onethousand.setBounds(120,306,110,18);
     onethousand.addActionListener(this);
     image.add(onethousand);
     
     twothousand = new JButton("Rs 2000");
     twothousand.setBounds(258,306,110,18);
     twothousand.addActionListener(this);
     image.add(twothousand);
     
     fivethousand = new JButton("Rs 5000");
     fivethousand.setBounds(120,329,110,18);
     image.add(fivethousand);
     
     tenthousand = new JButton("Rs 10000");
     tenthousand.setBounds(258,329,110,18);
     tenthousand.addActionListener(this);
     image.add(tenthousand);
     
     exit = new JButton("BACK");
     exit.setBounds(258,352,110,18);
     exit.addActionListener(this);
     image.add(exit);
     
     
     
        
     //getContentPane().setBackground(Color.WHITE);
        setSize(650,600);
        setLocation(300, 35);
        //setUndecorated(true);
        setVisible(true);
      
    
    
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
              
                ResultSet rs= c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
                
                int balance=0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit"))
                    {
                       balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else
                    {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                    if (ae.getSource()!=exit && balance < Integer.parseInt(amount)) {
                        
                        JOptionPane.showMessageDialog(null, "InSufficient Balance !");
                        return;
                    }
                    Date  date= new Date();
                    String query ="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                    
                     c.s.executeUpdate(query);
                     
                     JOptionPane.showMessageDialog(null, "Rs "+ amount +" Debited Successfully");
                     setVisible(false);
                     new Transactions(pinnumber).setVisible(true);
                
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
   
    public static void main(String[] args) {
        
        new FastCash("");
    }
 
}

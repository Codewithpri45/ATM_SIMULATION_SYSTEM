package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    String rpin;
    JButton back;

    public BalanceEnquiry(String pin) {
        this.rpin=pin;
        
     setLayout(null);
     ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
     Image i2 = i1.getImage().getScaledInstance(650, 610, Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel image = new JLabel(i3);
     image.setBounds(0,0,650,610);
     add(image);
     
     back = new JButton("BACK");
     back.setBounds(258,352,110,18);
     back.addActionListener(this);
     image.add(back);
     
      Conn c = new Conn();
        int balance=0;
            try {
              
                ResultSet rs= c.s.executeQuery("select * from bank where pin ='"+rpin+"'");
                
                
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
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
     JLabel text = new JLabel("YOUR CURRENT BALANCE IS : "+ balance);
     text.setBounds(140, 200, 500, 23);
     text.setForeground(Color.WHITE);
     text.setFont( new Font("System",Font.BOLD,12));
     image.add(text);
     

           
     
        
        setSize(650,600);
        setLocation(300, 35);
        //setUndecorated(true);
        setVisible(true);
      
    
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Transactions(rpin).setVisible(true);
    }
    
    
    public static void main(String[] args) {
        
        new BalanceEnquiry("");
    }
}

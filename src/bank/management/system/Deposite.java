package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.*;
import javax.swing.JOptionPane;

public class Deposite extends JFrame implements ActionListener{

    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    
    Deposite(String pin) {
        
        this.pinnumber= pin;
        
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(650, 610, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,650,610);
        add(image);
     
        JLabel text = new JLabel("Enter The Amount You Want To Deposit :");
        text.setBounds(126, 200, 500, 23);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,12));
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(135,240,220,20);
        amount.setFont(new Font("Raleway", Font.BOLD,13));
        image.add(amount);
        
     deposit = new JButton("DEPOSIT");
     deposit.setBounds(258,329,110,18);
     deposit.addActionListener(this);
     image.add(deposit);
     
     back = new JButton("BACK");
     back.setBounds(258,352,110,18);
     back.addActionListener(this);
     image.add(back);
     
     
     
     
        
        
        setSize(650,600);
        setLocation(300, 35);
        //setUndecorated(true);
        setVisible(true);
      
    }
     public void actionPerformed(ActionEvent ae)
     {
         if (ae.getSource()==deposit) {
             
             String number= amount.getText();
             Date date = new Date();
             
             if (number.equals("")) {
                 JOptionPane.showMessageDialog(null,"Please Enter Amount !");
             }
             else{
                 try{
                 Conn c = new Conn();
                 String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                 c.s.executeUpdate(query);
                 
                 JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully");
                     setVisible(false);
                     new Transactions(pinnumber).setVisible(true);
                 }
                 catch(Exception e)
                 {
                     System.out.println(e);
                 }
             }
         }
         else if(ae.getSource()==back)
         {
             setVisible(false);
             new Transactions(pinnumber).setVisible(true);
         }
     }
    
 
    
    public static void main(String[] args) {
        
       new Deposite("");
    }
 
}

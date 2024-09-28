
package bank.management.system;

import javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;
import java.util.*;

public class Withdraw  extends JFrame implements ActionListener{

    JTextField amount;
    JButton withdraw,back;
    String pinnumber;

   
     Withdraw(String pin) {
       this.pinnumber=pin;
        
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(650, 610, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,650,610);
        add(image);
     
        JLabel text = new JLabel("Enter The Amount You Want To Withdraw :");
        text.setBounds(121, 200, 500, 23);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,12));
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(135,240,220,20);
        amount.setFont(new Font("Raleway", Font.BOLD,13));
        image.add(amount);
        
     withdraw = new JButton("WITHDRAW");
     withdraw.setBounds(258,329,110,18);
     withdraw.addActionListener(this);
     image.add(withdraw);
     
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
         if (ae.getSource()==withdraw) {
             
             String numbers= amount.getText();
             Date dates = new Date();
             
             if (numbers.equals("")) {
                 JOptionPane.showMessageDialog(null,"Please Enter Amount !");
             }
         
             else{
                 try{
                 Conn c = new Conn();
                 String query = "insert into bank values('"+pinnumber+"','"+dates+"','Withdrawl','"+numbers+"')";
                 c.s.executeUpdate(query);
                 
                 JOptionPane.showMessageDialog(null, "Rs "+numbers+" Withdraw Successfully!");
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
        
        new Withdraw("");
    }
}

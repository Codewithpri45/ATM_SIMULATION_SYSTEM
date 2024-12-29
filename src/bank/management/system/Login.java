
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import  java .awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
   JButton login, clear, exitt,b1;
   JTextField cardTextField;
   JPasswordField pinTextField;
    
    Login()
    {
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
   
       
       ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
       Image i2= i1.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT);
       ImageIcon i3= new ImageIcon(i2);
       JLabel label = new  JLabel(i3);
       label.setBounds(110, 17, 90, 90);
        add(label);
        
        JLabel text =new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward",Font.BOLD,32));
        text.setBounds(230, 50, 370, 30);
        add(text);
        
          JLabel cardno =new JLabel("CARD NO:");
        cardno.setFont(new Font("Raleway",Font.BOLD,23));
        cardno.setBounds(110, 130, 130, 28);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(270,131,230,25);
        cardTextField.setFont( new Font("Arial",Font.BOLD,12));
        add(cardTextField);
        
          JLabel pin =new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,23));
        pin.setBounds(110, 190, 110, 28);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(270,191,230,25);
        pinTextField.setFont( new Font("Arial",Font.BOLD,12));
        add(pinTextField);
        
        login = new JButton("ENTER");
        login.setBounds(270, 260, 110, 28);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(390, 260, 110, 28);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        exitt = new JButton("NEW CARD");
        exitt.setBounds(270, 310, 230, 28);
        exitt.setBackground(Color.BLACK);
        exitt.setForeground(Color.WHITE);
        exitt.addActionListener(this);
        add(exitt);
        
        b1 = new JButton("EXIT");
        b1.setBounds(390, 360, 110, 28);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        Color customColor = new Color(176,196,222); 
        getContentPane().setBackground(customColor);
      setSize(700,480);
      setVisible(true);
      setLocation(240,120);
}
   @Override
        public void actionPerformed(ActionEvent ae)
      {
          if(ae.getSource()==clear)
          {
           cardTextField.setText("");
           pinTextField.setText("");
          }
          else if(ae.getSource()==exitt){
//             System.exit(0);
              setVisible(false);
           new SignupOne().setVisible(true);
          }
          else if(ae.getSource()==b1){
              System.exit(0);
          }
          else if(ae.getSource()==login)
          {
              Conn c = new Conn();
              String cardnumber = cardTextField.getText();
              String pinnumber = pinTextField.getText();
              String query ="select * from login where card_number ='"+cardnumber+"' and pin_number='"+pinnumber+"'";
              
              try {
                  
                ResultSet rs=  c.s.executeQuery(query);
                  if (rs.next()) {
                      setVisible(false);
                      new Transactions(pinnumber).setVisible(true);
                  }
                  else
                  {
                      JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                  }
                  
              } catch (Exception e) {
             
                  System.out.println(e);
              }
          }
          

}
    
    public static void main (String args [])
    {
      new Login();  
        
    }
    }


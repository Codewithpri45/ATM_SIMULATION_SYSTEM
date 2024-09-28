package bank.management.system;
import  javax.swing.*;
import  java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
   
  JRadioButton r1,r2,r3,r4;
  JCheckBox c1,c2,c3,c4,c5,c6,c7;
  JButton submit,cancel;
  String random;
  Random ran = new Random();
  String pin=""+Math.abs((ran.nextLong()%9000L) +1000L);
  String pinnumber;
            
    public SignupThree(String random){
        this.random=random;
        
        setLayout(null);
        
        
         setTitle("NEW ACCOUNT APPLICATION FROM - PAGE 3");
         
        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("Raleway" , Font.BOLD,17));
        accountDetails.setBounds(200, 50, 350, 22);
        add(accountDetails);
        
        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway" , Font.BOLD,14));
        type.setBounds(75, 110, 110, 21);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway" , Font.BOLD,12));
        r1.setBounds(70, 145 , 180, 19);
        r1.setBackground(Color.WHITE);
        add(r1);
        
        
         r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway" , Font.BOLD,12));
        r2.setBounds(250, 145 , 400, 19);
        r2.setBackground(Color.WHITE);
        add(r2);
       
         r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway" , Font.BOLD,12));
        r3.setBounds(70, 165 , 170, 19);
        r3.setBackground(Color.WHITE);
        add(r3);
                
        r4 = new JRadioButton("Reccuring Deposit Account");
        r4.setFont(new Font("Raleway" , Font.BOLD,12));
        r4.setBounds(250, 165, 400, 19);
        r4.setBackground(Color.WHITE);
        add(r4);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);
        
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway" , Font.BOLD,14));
        card.setBounds(75, 207, 110, 21);
        add(card);
        
        JLabel dummy= new JLabel("XXXX-XXXX-XXXX-8234");
        dummy.setFont(new Font("Raleway", Font.BOLD,12));
        dummy.setBounds(200, 209, 300, 18);
        add(dummy);
        
        JLabel msg= new JLabel("Your 16 Digit Card Number");
        msg.setFont(new Font("Raleway", Font.BOLD,8));
        msg.setBounds(76, 228, 300, 15);
        add(msg);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway" , Font.BOLD,14));
        pin.setBounds(75, 248, 110, 21);
        add(pin);
        
        
        JLabel pinmsg = new JLabel("Your 4 Digit Pin Number");
        pinmsg.setFont(new Font("Raleway" , Font.BOLD,8));
        pinmsg.setBounds(76, 269, 300, 15);
        add(pinmsg);
        
        JLabel dummyPin= new JLabel("XXXX");
        dummyPin.setFont(new Font("Raleway", Font.BOLD,12));
        dummyPin.setBounds(200, 250, 100, 18);
        add(dummyPin);
        
        JLabel services= new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD,14));
        services.setBounds(75, 300, 180, 21);
        add(services);
        
       
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,11));
        c1.setBounds(75,335, 150, 15);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,11));
        c2.setBounds(230,335, 120, 15);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,11));
        c3.setBounds(75,365, 120, 15);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,11));
        c4.setBounds(230,365, 180, 15);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,11));
        c5.setBounds(75,395, 120, 15);
        add(c5);
        
        c6 = new JCheckBox("E-Statements");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,11));
        c6.setBounds(230,395, 150, 15);
        add(c6);
        
        
        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,10));
        c7.setBounds(75,450, 500, 15);
        add(c7);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(200, 500, 100, 23);
        cancel.addActionListener(this);
        add(cancel);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(320, 500, 100, 23);
        submit.addActionListener(this);
        add(submit);
        
        
       getContentPane().setBackground(Color.WHITE);
        setSize(650,600);
        setLocation(300, 35);
        setVisible(true);
        
        
        
    }
    public void actionPerformed(ActionEvent ae){
        
        if (ae.getSource()== submit) {
            String accountType= null;
            if (r1.isSelected()) {
              accountType="Saving Account";
            }
            else if (r2.isSelected()) {
                accountType="Fixed Deposit Account";
            }
            else if (r3.isSelected()) {
               accountType="Current Account"; 
            }
            else if (r4.isSelected()) {
               accountType="Reccuring Deposit Account"; 
            }
            
            String cardNumber =""+Math.abs((ran.nextLong()%90000000L)+ 5040936000000000L);
            
            pinnumber= pin;
            
            String facilities ="";
            
            if (c1.isSelected()) {
                facilities=facilities+" ATM Card";
            }
            else if (c2.isSelected()) {
               facilities= facilities+" Internet Banking" ;
            }
            else if (c3.isSelected()) {
              facilities= facilities+" Mobile Banking";  
            }
            else if (c4.isSelected()) {
               facilities= facilities+ " Email & SMS Alerts" ;
            }
            else if (c5.isSelected()) {
              facilities= facilities+" Cheque Book" ; 
            }
            else if (c6.isSelected()) {
                facilities= facilities+" E-Statements";
            }
            
            try {
               
                if (accountType.equals("")) {
                  
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                }
                else{
                    Conn c= new Conn();
                    
                    String query1="insert into signupthree values('"+random+"','"+accountType+"','"+cardNumber+"','"+pinnumber+"','"+facilities+"')";
                    
                    String query2="insert into login values('"+random+"','"+cardNumber+"','"+pinnumber+"')";
                    
                    c.s.executeUpdate(query1);
                    
                    c.s.executeUpdate(query2);
                    
                 JOptionPane.showMessageDialog(null, "Card Number: "+ cardNumber + "\n Pin: "+pinnumber);
                    setVisible(false);
                    new Deposite(pinnumber).setVisible(true);
                }
                
            } catch (Exception e) {
                
                System.out.println(e);
            }
            
        }
        else if (ae.getSource()==cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
        
    }
    
    
    
    public static void main(String[] args) {
        new SignupThree("");
    }
    
}

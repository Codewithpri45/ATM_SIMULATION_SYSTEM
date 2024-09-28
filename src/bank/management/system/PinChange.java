package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//import java.awt.events.*;

public class PinChange  extends  JFrame implements ActionListener{
    
    JPasswordField pinc,repinn;
    JButton change,back;
    String pinnumber;
    String renpin,npin;

    public PinChange(String pin) {
        
        this.pinnumber=pin;
        
        setLayout(null);
     ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
     Image i2 = i1.getImage().getScaledInstance(650, 610, Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel image = new JLabel(i3);
     image.setBounds(0,0,650,610);
     add(image);
     
     JLabel text = new JLabel("CHANGE YOUR PIN");
     text.setBounds(190, 200, 500, 23);
     text.setForeground(Color.WHITE);
     text.setFont( new Font("System",Font.BOLD,12));
     image.add(text);
     
     JLabel pintext = new JLabel("NEW PIN: ");
     pintext.setBounds(121, 235, 100, 23);
     pintext.setForeground(Color.WHITE);
     pintext.setFont( new Font("System",Font.BOLD,12));
     image.add(pintext);
     
      pinc = new JPasswordField();
      pinc.setBounds(215,235,140,18);
      pinc.setFont(new Font("Raleway", Font.BOLD,13));
      image.add(pinc);
       
     
     JLabel repin = new JLabel("RE-ENTER PIN: ");
     repin.setBounds(121, 275, 100, 23);
     repin.setForeground(Color.WHITE);
     repin.setFont( new Font("System",Font.BOLD,12));
     image.add(repin);
     
      repinn = new JPasswordField();
      repinn.setBounds(215,275,140,18);
      repinn.setFont(new Font("Raleway", Font.BOLD,13));
      image.add(repinn);
      
      
     change = new JButton("CHANGE");
     change.setBounds(258,329,110,18);
     change.addActionListener(this);
     image.add(change);
     
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
        
        if (ae.getSource()==change) {
            
        
        try {
            
            
            npin= pinc.getText();
            renpin=repinn.getText();
            
            if (!npin.equals(renpin)) {
              
                JOptionPane.showMessageDialog(null, "Entered Pin Does Not Match !");
                return;
            }
            if (npin.equals("")) {
              JOptionPane.showMessageDialog(null, "Please Enter  New Pin !");
              return;
            }
            if (renpin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Re-Enter New Pin !");
                return;
            }
            Conn c = new Conn();
            String query1="update bank set pin ='"+renpin+"' where pin='"+pinnumber+"'";
            String query2="update signupthree set pin_number='"+renpin+"' where pin_number ='"+pinnumber+"'";
            String query3="update login set pin_number ='"+renpin+"' where pin_number='"+pinnumber+"'";
            
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "Pin Changed Successfully !");
            
            setVisible(false);
            new Transactions(renpin).setVisible(true);
        }
        catch (Exception e) {
            
            System.out.println(e);
        }
        }
        else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
    }
    
    
    public static void main(String[] args) {
        
        new PinChange("").setVisible(true);
    }
}

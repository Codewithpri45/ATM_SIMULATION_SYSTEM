package bank.management.system;

import bank.management.system.Withdraw;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author psc
 */
public class AccType extends JFrame implements ActionListener{
   
    
 

    JButton current, saving ,exit;
 String pinnumber;
 
 JButton withdra,dep;
    public AccType(String pin)  {
      this.pinnumber=pin;
      
     
     
        setLayout(null);
    
    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
     Image i2 = i1.getImage().getScaledInstance(650, 610, Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel image = new JLabel(i3);
     image.setBounds(0,0,650,610);
     add(image);
     
     JLabel text = new JLabel("PLEASE SELECT ACCOUNT TYPE");
     text.setBounds(140, 200, 500, 23);
     text.setForeground(Color.WHITE);
     text.setFont( new Font("System",Font.BOLD,12));
     image.add(text);
     
    
     saving = new JButton("SAVING");
     saving.setBounds(258,283,110,18);
     saving.addActionListener(this);
     image.add(saving);
     
     
     current = new JButton("CURRENT");
     current.setBounds(258,306,110,18);
     current.addActionListener(this);
     image.add(current);
     
     
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
    
    

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        { 
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else if (ae.getSource()==saving) {
            setVisible(false);
        
            new Withdraw(pinnumber).setVisible(true);
            }
        
        else if (ae.getSource()==current)
        {  
            setVisible(false);
           new Withdraw(pinnumber).setVisible(true);
           
        }
        
       }   
    
    
    
    public static void main(String[] args) {
        
        new AccType("");        
   }
}
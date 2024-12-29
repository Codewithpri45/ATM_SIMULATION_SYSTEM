package bank.management.system;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{
    JButton deposite,withdra,fastcash,statement,pinchange,balancecheck ,exit;
  String pinnumber;

    public JButton getDeposite() {
        return deposite;
    }

    public JButton getWithdra() {
        return withdra;
    }

  
   
    public Transactions( String pin)  {
        this.pinnumber=pin;
        setLayout(null);
    
    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
     Image i2 = i1.getImage().getScaledInstance(650, 610, Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel image = new JLabel(i3);
     image.setBounds(0,0,650,610);
     add(image);
     
     JLabel text = new JLabel("PLEASE SELECT YOUR TRANSACTION");
     text.setBounds(129, 200, 500, 23);
     text.setForeground(Color.WHITE);
     text.setFont( new Font("System",Font.BOLD,12));
     image.add(text);
     
     deposite = new JButton("DEPOSIT");
     deposite.setBounds(120,283,110,18);
     deposite.addActionListener(this);
     image.add(deposite);
      
     withdra = new JButton("WITHDRAWL");
     withdra.setBounds(258,283,110,18);
     withdra.addActionListener(this);
     image.add(withdra);
     
     fastcash = new JButton("FAST CASH");
     fastcash.setBounds(120,306,110,18);
     fastcash.addActionListener(this);
     image.add(fastcash);
     
     statement = new JButton("STATEMENT");
     statement.setBounds(258,306,110,18);
     statement.addActionListener(this);
     image.add(statement);
     
     pinchange = new JButton("PIN CHANGE");
     pinchange.setBounds(120,329,110,18);
     pinchange.addActionListener(this);
     image.add(pinchange);
     
     balancecheck = new JButton("BALANCE");
     balancecheck.setBounds(258,329,110,18);
     balancecheck.addActionListener(this);
     image.add(balancecheck);
     
     exit = new JButton("EXIT");
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
            System.exit(0);
        }
        else if (ae.getSource()==deposite) {
            setVisible(false);
            new Deposite(pinnumber).setVisible(true);
        }
        else if (ae.getSource()==withdra)
        {
            setVisible(false);
            new AccType(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash)
        {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if (ae.getSource()==pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if (ae.getSource()==balancecheck) {
            
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if (ae.getSource()==statement) {
            
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    
    public static void main(String[] args) {
        
         new Transactions("");
        
        
    }
}


package bank.management.system;
import java.awt.*;
import javax.swing.*;
import  java.util.*;
import  com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignupOne extends JFrame implements ActionListener{
 
    
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,
               cityTextField,stateTextField,pincodeTextField;
    JButton next;
    JRadioButton radioButtonMale,radioButtonFemale,other,single, married,otherm;
    JDateChooser dateChooser;
    
    Random ran = new Random();
     long rand =((ran.nextLong() % 9000L)+ 1000L);
     String random=""+Math.abs(rand);
     
        
    public SignupOne() {
        setLayout(null);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway" , Font.BOLD,26));
        formno.setBounds(115, 10, 500, 30);
        add(formno);
        
         JLabel prsnalDetail = new JLabel("Page 1: Personal Details");
        prsnalDetail.setFont(new Font("Raleway" , Font.BOLD,16));
        prsnalDetail.setBounds(200, 50, 350, 21);
        add(prsnalDetail);
        
         JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway" , Font.BOLD,14));
        name.setBounds(75, 100, 80, 21);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway" ,Font.BOLD,12));
        nameTextField.setBounds(200,100,200,21);
        add(nameTextField);
        
         JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway" , Font.BOLD,14));
        fname.setBounds(75, 140, 120, 21);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway" ,Font.BOLD,12));
        fnameTextField.setBounds(200,140,200,21);
        add(fnameTextField);
        
         JLabel dob = new JLabel("Date Of Birth: ");
        dob.setFont(new Font("Raleway" , Font.BOLD,14));
        dob.setBounds(75, 175, 120, 21);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(200, 175, 200, 21);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway" , Font.BOLD,14));
        gender.setBounds(75, 210, 120, 21);
        add(gender);
        
        radioButtonMale= new JRadioButton("Male");
        radioButtonMale.setBounds(195, 210, 60, 21);
        radioButtonMale.setBackground(Color.WHITE);
         add(radioButtonMale);
         
        radioButtonFemale= new JRadioButton("Female");
        radioButtonFemale.setBounds(260, 210, 80, 21);
        radioButtonFemale.setBackground(Color.WHITE);
        add(radioButtonFemale);
        
        other = new JRadioButton("Others");
        other.setBounds(340, 210, 70, 21);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(radioButtonMale);
        genderGroup.add(radioButtonFemale);
        genderGroup.add(other);
        
        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway" , Font.BOLD,14));
        email.setBounds(75, 245, 120, 21);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway" ,Font.BOLD,12));
        emailTextField.setBounds(200,245,200,21);
        add(emailTextField);
        
        
        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway" , Font.BOLD,14));
        marital.setBounds(75, 280, 120, 21);
        add(marital);
        
        single= new JRadioButton("Single");
        single.setBounds(195, 280, 70, 21);
        single.setBackground(Color.WHITE);
         add(single);
         
        married= new JRadioButton("Married");
        married.setBounds(265, 280, 75, 21);
        married.setBackground(Color.WHITE);
        add(married);
        
        otherm = new JRadioButton("Others");
        otherm.setBounds(340, 280, 70, 21);
        otherm.setBackground(Color.WHITE);
        add(otherm);
        
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(single);
        maritalGroup.add(married);
        maritalGroup.add(otherm);
        
        
        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway" , Font.BOLD,14));
        address.setBounds(75, 315, 120, 21);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway" ,Font.BOLD,12));
        addressTextField.setBounds(200,315,200,21);
        add(addressTextField);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway" , Font.BOLD,14));
        city.setBounds(75, 350, 120, 21);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway" ,Font.BOLD,12));
        cityTextField.setBounds(200,350,200,21);
        add(cityTextField);
        
        
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway" , Font.BOLD,14));
        state.setBounds(75, 385, 120, 21);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway" ,Font.BOLD,12));
        stateTextField.setBounds(200,385,200,21);
        add(stateTextField);
        
         JLabel pincode = new JLabel("PinCode: ");
        pincode.setFont(new Font("Raleway" , Font.BOLD,14));
        pincode.setBounds(75, 420, 120, 21);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway" ,Font.BOLD,12));
        pincodeTextField.setBounds(200,420,200,21);
        add(pincodeTextField);
        
        next = new JButton("Next");
        next.setBounds(250, 470, 100, 24);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(650,600);
        setLocation(300, 35);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
     String formno=random;
     String name= nameTextField.getText();
     String fname= fnameTextField.getText();
     String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
     String gender= null;
     if (radioButtonMale.isSelected())
     {
         gender="Male";
     }
     else if(radioButtonFemale.isSelected())
     {
         gender="Female";
     }
     else if(other.isSelected())
     {
         gender="Other";
     }
     
     String email= emailTextField.getText();
     String marital =null;
     
     if(single.isSelected())
     {
         marital="Single";
     }
     else if(married.isSelected())
     {
         marital="Married";
         
     }
     else if(otherm.isSelected())
     {
         marital="Others";
     }
     
     String address = addressTextField.getText();
     String city= cityTextField.getText();
     String state = stateTextField.getText();
     String pincode= pincodeTextField.getText();
     
        try {
           
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Name Is Required !");
                
            }
            else{
                Conn c= new Conn();
                String querry= "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                
                c.s.executeUpdate(querry);
                setVisible(false);
                new SignupTwo(random).setVisible(true);
            }
        } 
        catch (Exception e) {
            
            System.out.println(e);
        }
     
     
    }
    
    
    public static void main(String[] args) {
        
        new SignupOne();
    }
}

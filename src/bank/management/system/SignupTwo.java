
package bank.management.system;
import bank.management.system.Conn;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{

    JComboBox relJComboBox,cateComboBox,incComboBox,qualificatComboBox,occuJComboBox;
    JTextField panTextField,aadharTextField;
    JRadioButton citizenButton,citizenButton2,eaccButton,eaccButton2;
    JButton next2;
    String random;

    public SignupTwo(String random) {
        this.random=random;
        
         setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FROM - PAGE 2");
        
         JLabel otherDetails = new JLabel("Page 2: Additional Details");
        otherDetails.setFont(new Font("Raleway" , Font.BOLD,16));
        otherDetails.setBounds(200, 50, 350, 21);
        add(otherDetails);
        
         JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway" , Font.BOLD,14));
        religion.setBounds(75, 100, 80, 21);
        add(religion);
        
        String valReligion[]= {"Hindu","Muslim","Sikh","Christian","Others"};
        relJComboBox = new JComboBox(valReligion);
        relJComboBox.setBounds(200,100,200,21);
        relJComboBox.setBackground(Color.WHITE);
        add(relJComboBox);
        
       
         JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Raleway" , Font.BOLD,14));
        category.setBounds(75, 140, 120, 21);
        add(category);

        String valCategory[] ={"General","OBC","SC","ST","Others"}; 
        cateComboBox = new JComboBox(valCategory);
        cateComboBox.setBounds(200,140,200,21);
        cateComboBox.setBackground(Color.WHITE);
        add(cateComboBox);
        
        
         JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Raleway" , Font.BOLD,14));
        income.setBounds(75, 180, 120, 21);
        add(income);

        String valIncome[] ={"NULL","50,000-1,50,000","1,50,000-3,00,000","3,00,000-5,00,000","Upto 10,00,000"}; 
        incComboBox = new JComboBox(valIncome);
        incComboBox.setBounds(200,180,200,21);
        incComboBox.setBackground(Color.WHITE);
        add(incComboBox);
         
        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway" , Font.BOLD,14));
        education.setBounds(75, 210, 120, 21);
        add(education);
  
      
        JLabel qualificaLabel = new JLabel("Qualification: ");
        qualificaLabel.setFont(new Font("Raleway" , Font.BOLD,14));
        qualificaLabel.setBounds(75, 225, 120, 21);
        add(qualificaLabel);

        String valQualification[] ={"Post Graduate","Under Graduate","12th","10th","Others"}; 
        qualificatComboBox = new JComboBox(valQualification);
        qualificatComboBox.setBounds(200,225,200,21);
        qualificatComboBox.setBackground(Color.WHITE);
        add(qualificatComboBox);
        
        
        JLabel occu = new JLabel("Occupation: ");
        occu.setFont(new Font("Raleway" , Font.BOLD,14));
        occu.setBounds(75, 265, 120, 21);
        add(occu);
        

        String valOccu[]={"Salaried","Self-Employed","Bussiness","Student","Others"};
        occuJComboBox = new JComboBox(valOccu);
        occuJComboBox.setBackground(Color.WHITE);
        occuJComboBox.setBounds(200,265 , 200, 21);
        add(occuJComboBox);
        
        
        JLabel pan = new JLabel("PAN Number: ");
        pan.setFont(new Font("Raleway" , Font.BOLD,14));
        pan.setBounds(75, 300, 120, 21);
        add(pan);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway" ,Font.BOLD,12));
        panTextField.setBounds(200,300,200,21);
        add(panTextField);
        
        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway" , Font.BOLD,14));
        aadhar.setBounds(75, 335, 120, 21);
        add(aadhar);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway" ,Font.BOLD,12));
        aadharTextField.setBounds(200,335,200,21);
        add(aadharTextField);
        
        
        JLabel scitizen = new JLabel("senior citizen: ");
        scitizen.setFont(new Font("Raleway" , Font.BOLD,14));
        scitizen.setBounds(75, 370, 120, 21);
        add(scitizen);

        citizenButton = new JRadioButton("YES");
        citizenButton.setBounds(200, 370, 70, 21);
        citizenButton.setBackground(Color.WHITE);
         add(citizenButton);
       
        
        citizenButton2 = new JRadioButton("NO");
        citizenButton2.setBounds(275, 370, 70, 21);
        citizenButton2.setBackground(Color.WHITE);
         add(citizenButton2);
       
        ButtonGroup bg= new ButtonGroup();
        bg.add(citizenButton);
        bg.add(citizenButton2);

         JLabel eacc = new JLabel("Existing Account: ");
        eacc.setFont(new Font("Raleway" , Font.BOLD,14));
        eacc.setBounds(75, 405, 125, 21);
        add(eacc);
       
        eaccButton = new JRadioButton("YES");
        eaccButton.setBounds(200, 405, 70, 21);
        eaccButton.setBackground(Color.WHITE);
         add(eaccButton);
       
        
        eaccButton2 = new JRadioButton("NO");
        eaccButton2.setBounds(275, 405, 70, 21);
        eaccButton2.setBackground(Color.WHITE);
         add(eaccButton2);
       
        ButtonGroup bg2= new ButtonGroup();
        bg2.add(eaccButton);
        bg2.add(eaccButton2);

         
        next2 = new JButton("Next");
        next2.setBounds(250, 470, 100, 24);
        next2.setBackground(Color.BLACK);
        next2.setForeground(Color.WHITE);
        next2.addActionListener(this);
        add(next2);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(650,600);
        setLocation(300, 35);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
    // formno=""+random;
     String religion=(String) relJComboBox.getSelectedItem();
     String category= (String) cateComboBox.getSelectedItem();
     String income=(String) incComboBox.getSelectedItem();
     String qalification= (String) qualificatComboBox.getSelectedItem();
     String occupation= (String) occuJComboBox.getSelectedItem();
     String pan= panTextField.getText();
     String aadhar =aadharTextField.getText();
     String citizen =null;
        if (citizenButton.isSelected()) 
       {
        citizen="YES"; 
        }
        else if(citizenButton2.isSelected())
       {
        citizen="NO";
        }
     String existingAcc =null;
     if (eaccButton.isSelected())
     {
         existingAcc="YES";
     }
     else if (eaccButton2.isSelected()) {

         existingAcc="NO";
        }
      
        try {
           
            if(pan.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Pan Number Is Required !");
                
            }
            else{
               Conn c= new Conn();
               String querry= "insert into signuptwo values('"+random+"','"+religion+"','"+category+"','"+income+"','"+qalification+"','"+occupation+"','"+pan+"','"+aadhar+"','"+citizen+"','"+existingAcc+"')";
                
               c.s.executeUpdate(querry);
                setVisible(false);
               new SignupThree(random).setVisible(true);
            }
        } 
        catch (Exception e) {
            
            System.out.println(e);
        }
     
     
    }
        
        
       
    
    
    public static void main(String[] args) {
        
        new SignupTwo("");
    }
}
    
    
    


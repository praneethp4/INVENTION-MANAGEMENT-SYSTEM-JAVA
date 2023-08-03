package net.codejava;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class register implements ActionListener {
    JFrame frame;
    
    JLabel idLabel=new JLabel("UserName");  
    JLabel keyLabel=new JLabel("License_key(if Jury)");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JLabel confirmPasswordLabel=new JLabel("CONFIRM PASSWORD");
    
    JTextField idTextField=new JTextField();   
    JTextField keyField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JPasswordField confirmPasswordField=new JPasswordField();  
    
    JButton registerButton=new JButton("REGISTER");
    JButton resetButton=new JButton("RESET");
    register()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame=new JFrame();
        frame.setTitle("Registration Form");
        frame.setBounds(40,40,379,397);
        frame.getContentPane().setBackground(SystemColor.controlHighlight);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize()
    {
        idLabel.setBounds(20,20,140,70);
        
        keyLabel.setBounds(20,60,200,70);
        passwordLabel.setBounds(20,100,100,70);
        confirmPasswordLabel.setBounds(20,150,140,70);              
        idTextField.setBounds(180,43,165,23);       
        keyField.setBounds(180,83,165,23);
        passwordField.setBounds(180,128,165,23);
        confirmPasswordField.setBounds(180,175,165,23); 
               
        registerButton.setBounds(70,250,100,35);
        resetButton.setBounds(220,250,100,35);
    }
    public void addComponentsToFrame()
    {
        frame.getContentPane().add(idLabel);       
        frame.getContentPane().add(keyLabel);
        frame.getContentPane().add(passwordLabel);
        frame.getContentPane().add(confirmPasswordLabel);        
        frame.getContentPane().add(idTextField);       
        frame.getContentPane().add(keyField);
        frame.getContentPane().add(passwordField);
        frame.getContentPane().add(confirmPasswordField);  
        
        frame.getContentPane().add(registerButton);
        frame.getContentPane().add(resetButton);
    }
    public void actionEvent()
    {
       //Adding Action Listener to buttons
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource()==registerButton)
        {
            try {
                //Creating Connection Object
                Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/oops_project", "postgres", "8440");
                //Preapared Statement
                PreparedStatement Pstatement=connection.prepareStatement("insert into credentials values(?,?,?)");
                //Specifying the values of it's parameter
                Pstatement.setString(1,idTextField.getText());  
                Pstatement.setString(2,keyField.getText());
                Pstatement.setString(3,passwordField.getText());
                            
                //Checking for the Password match
                if(passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText()))
                {
                    //Executing query
                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"password did not match");
                } 
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
 
        }
        if(e.getSource()==resetButton)
        {
            //Clearing Fields
        	idTextField.setText("");
          
            keyField.setText("");
            passwordField.setText("");
            confirmPasswordField.setText("");            
        }
    }
    public static void main(String[] args)
    {
        new register();
    }
 
}
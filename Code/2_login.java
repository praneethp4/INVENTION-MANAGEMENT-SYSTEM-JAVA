package net.codejava;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class login {
	JFrame frame;
	private JTextField txtun;
	private JPasswordField passwordField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	Statement statement;
	
	public login() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(SystemColor.controlHighlight);
		frame.setBounds(100, 100, 606, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblheading = new JLabel("INVENTION MANAGEMENT");
		lblheading.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblheading.setBounds(201, 23, 203, 13);
		frame.getContentPane().add(lblheading);
		
		JLabel lblun = new JLabel("UserName");
		lblun.setBounds(155, 103, 93, 13);
		frame.getContentPane().add(lblun);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setBounds(155, 171, 65, 13);
		frame.getContentPane().add(lblpassword);
		
		txtun = new JTextField();
		txtun.setBounds(258, 100, 96, 19);
		frame.getContentPane().add(txtun);
		txtun.setColumns(10);
		
		JButton btnlogin = new JButton("Login");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/oops_project", "postgres", "8440");//Crating connection with database
					  statement = connection.createStatement();//crating statement object
					
					String query="select * from credentials where username=? and password=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, txtun.getText());
					pst.setString(2, passwordField.getText());

					
					ResultSet rs=pst.executeQuery();
					int count=0;
					
					while(rs.next()) {
						count=count+1;
						
					}
					if(count==1)
					{
						frame.dispose();
						try {
							home window1 = new home();
							window1.frame.setVisible(true);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
					else if(count>1) {
						JOptionPane.showMessageDialog(null, "duplicate");
					}
					else {
						JOptionPane.showMessageDialog(null, "not correct try again");
						
					}
					rs.close();
					pst.close();
					
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);				
				}
			
			}
		});
		btnlogin.setBounds(135, 251, 85, 21);
		frame.getContentPane().add(btnlogin);
		
		JButton btnregister = new JButton("Register");
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					register window2 = new register();
					window2.frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}		
		});
		btnregister.setBounds(319, 251, 85, 21);
		frame.getContentPane().add(btnregister);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(258, 168, 96, 19);
		frame.getContentPane().add(passwordField);
	}
	public void setVisible(boolean b) {		
	}
}
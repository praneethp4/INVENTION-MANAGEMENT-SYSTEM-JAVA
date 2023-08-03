package net.codejava;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;

public class jury_login {

	JFrame frame;
	private JPasswordField passwordField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jury_login window = new jury_login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	Statement statement;
	private JTextField txtid;
	
	public jury_login() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.controlHighlight);
		frame.setBounds(100, 100, 598, 319);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblkey = new JLabel("License_key");
		lblkey.setBounds(159, 127, 96, 24);
		frame.getContentPane().add(lblkey);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(279, 130, 108, 19);
		frame.getContentPane().add(passwordField);
		
		JButton btnlogin = new JButton("Login");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/oops_project", "postgres", "8440");//Crating connection with database
					statement = connection.createStatement();//crating statement object
					
					String query="select * from credentials where username=? and license_key=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, txtid.getText());
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
							jury_verdict window1 = new jury_verdict();
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
		btnlogin.setBounds(232, 191, 85, 21);
		frame.getContentPane().add(btnlogin);
		
		JLabel lblid = new JLabel("Jury_Id");
		lblid.setBounds(159, 90, 45, 13);
		frame.getContentPane().add(lblid);
		
		txtid = new JTextField();
		txtid.setBounds(278, 87, 109, 19);
		frame.getContentPane().add(txtid);
		txtid.setColumns(10);
		
		JLabel lblhead = new JLabel("Jury Login");
		lblhead.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblhead.setBounds(247, 25, 85, 24);
		frame.getContentPane().add(lblhead);
	}
}

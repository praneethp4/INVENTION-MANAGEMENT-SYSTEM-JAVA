package net.codejava;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;

public class home {

	public JFrame frame;	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
	public home() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.controlHighlight);
		frame.setBounds(100, 100, 581, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblhome = new JLabel("HOME");
		lblhome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblhome.setBounds(257, 40, 56, 21);
		frame.getContentPane().add(lblhome);
		
		JButton btninv = new JButton("INVENTIONS");
		btninv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invention_details invdet=new invention_details();
				invdet.setVisible(true);		
			}
		});
		btninv.setBounds(72, 88, 146, 21);
		frame.getContentPane().add(btninv);
		
		JButton btnadd = new JButton("ADD INVENTIONS");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_inventions add=new add_inventions();
				add.setVisible(true);
			}
		});
		btnadd.setBounds(72, 141, 146, 21);
		frame.getContentPane().add(btnadd);
		
		JButton btnnomi = new JButton("NOMINATE");
		btnnomi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nominate nomi=new nominate();
				nomi.setVisible(true);
			}
		});
		btnnomi.setBounds(72, 196, 146, 21);
		frame.getContentPane().add(btnnomi);
		
		JButton btnpanel = new JButton("PANEL");
		btnpanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jury_login window6 = new jury_login();
					window6.frame.setVisible(true);
				} catch (Exception e6) {
					e6.printStackTrace();
			}
			}
		});
		btnpanel.setBounds(72, 252, 146, 21);
		frame.getContentPane().add(btnpanel);
		
		JButton btnlogout = new JButton("LOGOUT");
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					login window6 = new login();
					window6.frame.setVisible(true);
				} catch (Exception e6) {
					e6.printStackTrace();
			}
			}
		});
		btnlogout.setBounds(72, 305, 146, 21);
		frame.getContentPane().add(btnlogout);
	}
	public void setVisible(boolean b) {
	}

}

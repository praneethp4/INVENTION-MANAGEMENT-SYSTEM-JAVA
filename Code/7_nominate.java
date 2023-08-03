package net.codejava;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.SystemColor;

public class nominate extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtawrd;
	private JTextField txtyr;
	private JTable table;
	JFrame frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nominate frame = new nominate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection;
	Statement statement;

	
	public nominate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 417);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setForeground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("Invention_id");
		lblid.setBounds(46, 73, 79, 16);
		contentPane.add(lblid);
		
		JLabel lblaward = new JLabel("Award_id");
		lblaward.setBounds(46, 143, 69, 16);
		contentPane.add(lblaward);
		
		JLabel lblyear = new JLabel("Year_of_Nomination");
		lblyear.setBounds(46, 214, 141, 16);
		contentPane.add(lblyear);
		
		txtid = new JTextField();
		txtid.setBounds(197, 72, 96, 19);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtawrd = new JTextField();
		txtawrd.setBounds(197, 142, 96, 19);
		contentPane.add(txtawrd);
		txtawrd.setColumns(10);
		
		txtyr = new JTextField();
		txtyr.setBounds(197, 213, 96, 19);
		contentPane.add(txtyr);
		txtyr.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(329, 73, 349, 239);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
				
		JButton btnload = new JButton("Load data");
		btnload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/oops_project", "postgres", "8440");//Crating connection with database
					  statement = connection.createStatement();//crating statement object
					String query="select * from nominations";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(	DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
					e1.printStackTrace();
				}
			}	
		});
		btnload.setBounds(458, 333, 106, 21);
		contentPane.add(btnload);
		
		JButton btnnominate = new JButton("Nominate");
		btnnominate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/oops_project", "postgres", "8440");//Crating connection with database
					  statement = connection.createStatement();//crating statement object
					String query="insert into nominations (invention_id,award_id,year_of_nomination) values (?,?,?)";
					
					PreparedStatement pst=connection.prepareStatement(query);					
				    pst.setString(1,txtid.getText());
					pst.setString(2,txtawrd.getText());
					pst.setString(3,txtyr.getText());					
					pst.execute();
					JOptionPane.showMessageDialog(null,"Data saved");
					pst.close();
					} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		btnnominate.setBounds(131, 273, 106, 21);
		contentPane.add(btnnominate);
		
		JLabel lblNewLabel = new JLabel("Nominate");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(288, 10, 106, 13);
		contentPane.add(lblNewLabel);
	}

}

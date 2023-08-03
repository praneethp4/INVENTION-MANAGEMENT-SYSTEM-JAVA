package net.codejava;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

public class jury_verdict {
	JFrame frame;
	private JTextField txtInvid;
	private JTextField txtawrid;
	private JTextField txtawrname;
	private JTextField txtjuid;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jury_verdict window = new jury_verdict();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection;
	Statement statement;

	public jury_verdict() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.controlHighlight);
		frame.setBounds(100, 100, 693, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInvid = new JLabel("Invention_id");
		lblInvid.setBounds(67, 89, 72, 13);
		frame.getContentPane().add(lblInvid);
		
		JLabel lblawrid = new JLabel("Award_id");
		lblawrid.setBounds(67, 142, 72, 13);
		frame.getContentPane().add(lblawrid);
		
		JLabel lblawrname = new JLabel("Award_name");
		lblawrname.setBounds(67, 199, 72, 13);
		frame.getContentPane().add(lblawrname);
		
		JLabel lbljuid = new JLabel("Jury_id");
		lbljuid.setBounds(67, 258, 72, 13);
		frame.getContentPane().add(lbljuid);
		
		JButton btnverdict = new JButton("Verdict");
		btnverdict.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/oops_project", "postgres", "8440");//Crating connection with database
					  statement = connection.createStatement();//crating statement object
					String query="insert into awards(invention_id,award_id,award_name,jury_id) values (?,?,?,?)";
					
					PreparedStatement pst=connection.prepareStatement(query);
					
					pst.setString(1,txtInvid.getText());					
					pst.setString(2,txtawrid.getText());
					pst.setString(3,txtawrname.getText());
					pst.setString(4,txtjuid.getText());					
					pst.execute();
					JOptionPane.showMessageDialog(null,"Data saved");
					pst.close();
					} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		btnverdict.setBounds(123, 304, 85, 21);
		frame.getContentPane().add(btnverdict);
		
		txtInvid = new JTextField();
		txtInvid.setBounds(177, 86, 96, 19);
		frame.getContentPane().add(txtInvid);
		txtInvid.setColumns(10);
		
		txtawrid = new JTextField();
		txtawrid.setBounds(177, 142, 96, 19);
		frame.getContentPane().add(txtawrid);
		txtawrid.setColumns(10);
		
		txtawrname = new JTextField();
		txtawrname.setBounds(177, 196, 96, 19);
		frame.getContentPane().add(txtawrname);
		txtawrname.setColumns(10);
		
		txtjuid = new JTextField();
		txtjuid.setBounds(177, 255, 96, 19);
		frame.getContentPane().add(txtjuid);
		txtjuid.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(342, 73, 313, 236);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnload = new JButton("Load Data");
		btnload.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/oops_project", "postgres", "8440");//Crating connection with database
				  statement = connection.createStatement();//crating statement object
				String query="select * from awards";
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				table.setModel(	DbUtils.resultSetToTableModel(rs));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}	
	});
		btnload.setBounds(438, 323, 141, 21);
		frame.getContentPane().add(btnload);
		
		JLabel lblhead = new JLabel("Jury");
		lblhead.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblhead.setBounds(298, 20, 45, 13);
		frame.getContentPane().add(lblhead);
	}
	public void setVisible(boolean b) {		
	}
}
package net.codejava;
import java.awt.EventQueue;
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
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

public class add_inventions extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtcat;
	private JTextField txtstory;
	private JTextField  txtyear;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_inventions frame = new add_inventions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection;
	Statement statement;
	
	public add_inventions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 468);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("Invention_id");
		lblid.setBounds(38, 82, 92, 13);
		contentPane.add(lblid);
		
		JLabel lblname = new JLabel("Invention_name");
		lblname.setBounds(38, 133, 92, 13);
		contentPane.add(lblname);
		
		JLabel lblcat = new JLabel("Category");
		lblcat.setBounds(38, 189, 74, 13);
		contentPane.add(lblcat);
		
		JLabel lblstory = new JLabel("Story");
		lblstory.setBounds(38, 245, 45, 13);
		contentPane.add(lblstory);
		
		JLabel lblyear = new JLabel("Year_of_invention");
		lblyear.setBounds(38, 300, 106, 13);
		contentPane.add(lblyear);
		
		txtid = new JTextField();
		txtid.setBounds(154, 79, 96, 19);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtname = new JTextField();
		txtname.setBounds(154, 130, 96, 19);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtcat = new JTextField();
		txtcat.setText("\r\n");
		txtcat.setBounds(154, 186, 96, 19);
		contentPane.add(txtcat);
		txtcat.setColumns(10);
		
		txtstory = new JTextField();
		txtstory.setBounds(154, 242, 96, 19);
		contentPane.add(txtstory);
		txtstory.setColumns(10);
		
		txtyear = new JTextField( );
		
     	txtyear.setBounds(154, 300, 96, 19);
		contentPane.add(txtyear);
		txtyear.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(318, 80, 437, 233);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnsave = new JButton("Save");
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/oops_project", "postgres", "8440");//Crating connection with database
					  statement = connection.createStatement();//crating statement object
					String query="insert into inventions (Invention_id,Invention_name,Category,Story,Year_of_invention) values (?,?,?,?,?)";
					
					PreparedStatement pst=connection.prepareStatement(query);					
					pst.setString(1,txtid.getText());
				    pst.setString(2,txtname.getText());
					pst.setString(3,txtcat.getText());
					pst.setString(4,txtstory.getText());
					pst.setString(5,txtyear.getText());
                	pst.execute();
                	JOptionPane.showMessageDialog(null,"Data saved");
                	pst.close();
                	} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
			
		btnsave.setBounds(116, 337, 85, 21);
		contentPane.add(btnsave);
		
		JButton btnload = new JButton("Load data");
		btnload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/oops_project", "postgres", "8440");//Crating connection with database
					  statement = connection.createStatement();//crating statement object
					String query="select * from inventions";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(	DbUtils.resultSetToTableModel(rs));

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}		
		});
		btnload.setBounds(488, 337, 106, 21);
		contentPane.add(btnload);
		
		JLabel lblNewLabel = new JLabel("Add Invention");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(261, 24, 138, 13);
		contentPane.add(lblNewLabel);
	}
}

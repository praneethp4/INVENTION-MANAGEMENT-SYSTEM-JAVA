package net.codejava;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class invention_details implements ActionListener {
	public JFrame frame;

    JFrame frame1;
    JLabel nameLabel;
    JTextField nameTextField;
    JButton fetchButton;
    JButton resetButton;
    
    JFrame frame2;
    DefaultTableModel defaultTableModel;
    JTable table;
    Connection connection;
    Statement statement;
    int flag=0;
    
    invention_details() {
        frame1 = new JFrame();
        
        frame1.setTitle("Search Database");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout bagLayout = new GridBagLayout();
        GridBagConstraints bagConstraints = new GridBagConstraints();
        frame1.setSize(500, 300);//setting the size of first JFrame
        frame1.setLayout(bagLayout);

        bagConstraints.insets = new Insets(15, 40, 0, 0);

      //Setting the property of JLabel and adding it to the first JFrame
        nameLabel = new JLabel("Enter Invention_Id");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        frame1.add(nameLabel, bagConstraints);

      //Setting the property of JTextfield and adding it to the first JFrame
        nameTextField = new JTextField(15);
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 0;
        frame1.add(nameTextField, bagConstraints);

      //Setting the property of JButton(Fetch Data) and adding it to the first JFrame
        fetchButton = new JButton("Fetch Data");
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        bagConstraints.ipadx = 60;
        frame1.add(fetchButton, bagConstraints);

      //Setting the property of JButton(Reset Data) and adding it to the second JFrame
        resetButton = new JButton("Reset Data");
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 1;
        frame1.add(resetButton, bagConstraints);

        //adding ActionListener to both buttons
        fetchButton.addActionListener(this);
        resetButton.addActionListener(this);

        frame1.setVisible(true);//Setting the visibility of First JFrame
        frame1.validate();//Performing relayout of the First JFrame
    }

    public static void main(String[] args) {
        new invention_details();
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == fetchButton) {

            String userName = nameTextField.getText().toString();//getting text of Invention_Id text field and storing it in a String variable
            frameSecond(userName);//passing the text value to frameSecond method

        }
        if (e.getSource() == resetButton) {
            nameTextField.setText("");//resetting the value of Invention_Id text field
        }

    }

    public void frameSecond(String userName) {
   	
    	//setting the properties of second JFrame
        frame2 = new JFrame("Database Results");
        frame2.setLayout(new FlowLayout());
        frame2.setSize(400, 400);

        //Setting the properties of JTable and DefaultTableModel
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(300, 100));
        table.setFillsViewportHeight(true);
        frame2.add(new JScrollPane(table));
        defaultTableModel.addColumn("Invention_Id");
        defaultTableModel.addColumn("Invention_Name");
        defaultTableModel.addColumn("Year_of_Invention");
        defaultTableModel.addColumn("Category");
        defaultTableModel.addColumn("Story");
        
  try {
	  connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/oops_project", "postgres", "8440");//Creating connection with database
	  statement = connection.createStatement();//creating statement object
	  String query = "select * from INVENTIONS where INVENTION_ID = '" + userName + "'";//Storing PostgreySql query in A string variable
	  ResultSet resultSet = statement.executeQuery(query);//executing query and storing result in ResultSet
            while (resultSet.next()) {            	
            	//Retrieving details from the database and storing it in the String variables
                String inv_id = resultSet.getString("Invention_Id");
                String inv_name = resultSet.getString("Invention_Name");
                String year = resultSet.getString("Year_of_Invention");
                String cat = resultSet.getString("Category");
                String story = resultSet.getString("Story");
                
                if (userName.equalsIgnoreCase(inv_id)) {
                    flag = 1;
                    defaultTableModel.addRow(new Object[]{inv_id , inv_name,  year,cat,story});//Adding row in Table
                    frame2.setVisible(true);//Setting the visibility of second Frame
                    frame2.validate();
                    break;
                }

            }
            if (flag == 0) {
                JOptionPane.showMessageDialog(null, "No Such Invention_Id Found");//When invalid username is entered
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
   
    }
	public void setVisible(boolean b) {		
	}
}
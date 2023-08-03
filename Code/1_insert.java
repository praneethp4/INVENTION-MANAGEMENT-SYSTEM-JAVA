package net.codejava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class insert {

	public static void main(String[] args) {
		Connection c = null;
		Statement stmt = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/oops_project", "postgres", "8440");
	         
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         
	         String sql = "INSERT INTO INVENTIONS(Invention_id,Invention_name,Category,Story,Year_of_invention) "
	            + "VALUES ('Inv_1001', 'Steam engine', 'External tools','zyx','1956');";
	         stmt.executeUpdate(sql);

	         sql = "INSERT INTO INVENTIONS(Invention_id,Invention_name,Category,Story,Year_of_invention) "
	 	            + "VALUES ('Inv_1002', 'Automobile','Motorcycles', 'wvu','1900');";
	         stmt.executeUpdate(sql);

	         sql = "INSERT INTO INVENTIONS(Invention_id,Invention_name,Category,Story,Year_of_invention) "
	 	            + "VALUES ('Inv_1003', 'Robot','Robotics', 'rst','2005');";
	         stmt.executeUpdate(sql);

	        sql = "INSERT INTO INVENTIONS(Invention_id,Invention_name,Category,Story,Year_of_invention) "
		 	            + "VALUES ('Inv_1004', 'Telivision','Electronic devices', 'opq','1914');";
	        stmt.executeUpdate(sql);
	         
	        sql = "INSERT INTO INVENTIONS(Invention_id,Invention_name,Category,Story,Year_of_invention) "
		 	            + "VALUES ('Inv_1005', 'IPods','Electronic devices', 'def', '1923');";
	        stmt.executeUpdate(sql);
                 
 //2
                String sql1 = "INSERT INTO INVENTOR(Inventor_id,First_name,Last_name,DOB,City,Country) "
	            + "VALUES ('Inr_1001', 'John','Miller', '23-07-1923','LA','U.S');";
	         stmt.executeUpdate(sql1);

	         sql1 = "INSERT INTO INVENTOR(inventor_id,first_name,Last_name,DOB,city,country) "
	 	            + "VALUES ('Inr_1002', 'Shane','Watson', '22-04-1885','AP','UK');";
	         stmt.executeUpdate(sql1);

	         sql1 = "INSERT INTO INVENTOR(inventor_id,first_name,Last_name,DOB,city,country) "
	 	            + "VALUES ('Inr_1003', 'David','Stokes', '09-07-1986','MA','Australia');";
	         stmt.executeUpdate(sql1);

	         sql1 = "INSERT INTO INVENTOR(inventor_id,first_name,Last_name,DOB,city,country) "
		 	            + "VALUES ('Inr_1004', 'Charles','James','06-04-1946', 'NY','Denmark');";
	         stmt.executeUpdate(sql1);
	         
	         sql1 = "INSERT INTO INVENTOR(inventor_id,first_name,Last_name,DOB,city,country) "
		 	            + "VALUES ('Inr_1005', 'Taylor','Swift','01-03-1980', 'DM','Norway');";
	         stmt.executeUpdate(sql1);
	       

//5
             String sql4= "INSERT INTO Jury(Jury_id,jury_name,years_of_experience) "
	            + "VALUES ('Ju_1001', 'Kane',10);";
	         stmt.executeUpdate(sql4);

	         sql4 ="INSERT INTO Jury(Jury_id,jury_name,years_of_experience) "
	 	            + "VALUES ('Ju_1002', 'Guptill',06);";
	         stmt.executeUpdate(sql4);

	         sql4 = "INSERT INTO Jury(Jury_id,jury_name,years_of_experience) "
	 	            + "VALUES ('Ju_1003', 'Taylor',09);";
	         stmt.executeUpdate(sql4);

	         sql4 = "INSERT INTO Jury(Jury_id,jury_name,years_of_experience) "
		 	            + "VALUES ('Ju_1004', 'Mitchell',08);";
	         stmt.executeUpdate(sql4);
	         
	         sql4 = "INSERT INTO Jury(Jury_id,jury_name,years_of_experience) "
		 	            + "VALUES ('Ju_1005', 'Starc',03);";
	         stmt.executeUpdate(sql4);
	         
	         
	         //3
	         String sql2= "INSERT INTO Awards(invention_id,award_id,award_name,jury_id) "
	        	            + "VALUES ('Inv_1001','Awr_1001', 'Siima','Ju_1001');";
	        	         stmt.executeUpdate(sql2);

	        	         sql2 = "INSERT INTO Awards(invention_id,award_id,award_name,jury_id) "
	        	 	            + "VALUES ('Inv_1002','Awr_1002', 'Ballon-dor','Ju_1002');";
	        	         stmt.executeUpdate(sql2);

	        	         sql2 = "INSERT INTO Awards(invention_id,award_id,award_name,jury_id) "
	        	 	            + "VALUES ('Inv_1003','Awr_1003', 'Best_invention','Ju_1003' );";
	        	         stmt.executeUpdate(sql2);

	        	          sql2 = "INSERT INTO Awards(invention_id,award_id,award_name,jury_id) "
	        		 	            + "VALUES ('Inv_1004','Awr_1004', 'Peoples_award','Ju_1004');";
	        	         stmt.executeUpdate(sql2);
	        	         
	        	         sql2 = "INSERT INTO Awards(invention_id,award_id,award_name,jury_id) "
	        		 	            + "VALUES ('Inv_1005','Awr_1005', 'Creative_award','Ju_1005');";
	        	         stmt.executeUpdate(sql2);
	        	         

//4
	        	         String sql3= "INSERT INTO Nominations(invention_id,award_id,year_of_nomination) "
	        	       	            + "VALUES ('Inv_1001', 'Awr_1001',1986);";
	        	       	         stmt.executeUpdate(sql3);

	        	       	         sql3 ="INSERT INTO Nominations(invention_id,award_id,year_of_nomination) "
	        	       	 	            + "VALUES ('Inv_1002', 'Awr_1002',1925);";
	        	       	         stmt.executeUpdate(sql3);

	        	       	         sql3 = "INSERT INTO Nominations(invention_id,award_id,year_of_nomination) "
	        	       	 	            + "VALUES ('Inv_1003', 'Awr_1003',2009);";
	        	       	         stmt.executeUpdate(sql3);

	        	       	      sql3 = "INSERT INTO Nominations(invention_id,award_id,year_of_nomination) "
	        	       		 	            + "VALUES ('Inv_1004', 'Awr_1004',2001);";
	        	       	         stmt.executeUpdate(sql3);
	        	       	         
	        	       	         sql3 = "INSERT INTO Nominations(invention_id,award_id,year_of_nomination) "
	        	       		 	            + "VALUES ('Inv_1005', 'Awr_1005',2000);";
	        	       	      stmt.executeUpdate(sql3);


//6
             String sql5= "INSERT INTO credentials(username,password,License_key) "
	            + "VALUES ('User_1', 'Pass_1','');";
	         stmt.executeUpdate(sql5);

	         sql5 ="INSERT INTO credentials(username,password,License_key) "
	 	            + "VALUES ('User_2', 'Pass_2','lk_2');";
	         stmt.executeUpdate(sql5);

	         sql5 = "INSERT INTO credentials(username,password,License_key) "
	 	            + "VALUES('User_3', 'Pass_3','');";
	         stmt.executeUpdate(sql5);

	         sql5 = "INSERT INTO credentials(username,password,License_key) "
		 	            + "VALUES ('User_4', 'Pass_4','lk_4');";
	         stmt.executeUpdate(sql5);
	         
	         sql5 = "INSERT INTO credentials(username,password,License_key)"
		 	            + "VALUES ('User_5', 'Pass_5','');";
	         stmt.executeUpdate(sql5);
	         
	         stmt.close();
	         c.commit();
	         c.close();	      
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Records created successfully");
		
	}
}
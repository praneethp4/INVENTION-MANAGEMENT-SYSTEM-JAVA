package net.codejava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class create {

	public static void main(String[] args) {
		Connection c = null;
		Statement stmt = null;
	      try {
	    	  Class.forName("org.postgresql.Driver");
		         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/oops_project", "postgres", "8440");
		         System.out.println("Opened database successfully");
		         stmt = c.createStatement();
//inventions table
	         String sql = "CREATE TABLE INVENTIONS" +
	            "(Invention_id  VARCHAR(50) PRIMARY KEY     NOT NULL," +
	            " Invention_name          VARCHAR(50)    NOT NULL, " +
	            "Category       VARCHAR(100)    NOT NULL, " +
                    "Story      VARCHAR(100)    NOT NULL, " +
	            " Year_of_invention     VARCHAR )";
//inventor table
	         String sql1 = "CREATE TABLE INVENTOR" +
	 	            "(Inventor_id   VARCHAR(50) PRIMARY KEY     NOT NULL," +
	 	            " First_name    VARCHAR(100)    NOT NULL, " +
	 	            " Last_name     VARCHAR(100)    NOT NULL, " +
	 	            " DOB      DATE ,"+
	 	            " City   VARCHAR(50) NOT NULL , "+
	 	            "Country VARCHAR(50) NOT NULL  )";
//jury table
	         String sql2 = "CREATE TABLE Jury" +
		 	            "(Jury_id  VARCHAR(50) PRIMARY KEY     NOT NULL," +
		 	            " Jury_name          VARCHAR(50)    NOT NULL, " +
		 	            " Years_of_experience      INT    NOT NULL )";
//award table
	         String sql3 = "CREATE TABLE Awards" +
		 	            "(Invention_id   VARCHAR(50)      NOT NULL," 
		 	            + "Award_id  VARCHAR(50) PRIMARY KEY     NOT NULL," +
		 	            " Award_name        VARCHAR(50)    NOT NULL, " +
		 	            
		 	            "Jury_id  VARCHAR(10) NOT NULL,"+
		 	            " FOREIGN KEY (Invention_id) REFERENCES inventions,"+
		 	            " FOREIGN KEY (Jury_id) REFERENCES JURY)";
//nominations table	         
	         String sql4 = "CREATE TABLE Nominations" +
		 	            "(Invention_id   VARCHAR(10)      NOT NULL," +
		 	            "Award_id   VARCHAR(10)   NOT NULL, " +
		 	            " Year_of_nomination     VARCHAR   NOT NULL ,"+
		 	            "PRIMARY KEY(INVENTION_ID,AWARD_ID)  ,"+
		 	            "foreign key (Invention_id) references Inventions,"+
		 	            "foreign key (Award_id) references Awards) ";

	        String sql5 = "CREATE TABLE credentials" +
		 	            "(Username   VARCHAR(10)      NOT NULL," +
		 	            "Password  VARCHAR(10)   NOT NULL, " +
		 	            " License_key    VARCHAR(10)  NULL ,"+
		 	            " primary key (username) )";
	 	            
	         stmt.executeUpdate(sql);	         
	         stmt.executeUpdate(sql1);
	         stmt.executeUpdate(sql2);
	         stmt.executeUpdate(sql3);
	         stmt.executeUpdate(sql4);
	         stmt.executeUpdate(sql5);
	         stmt.close();
	         c.close();
	      
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Table created successfully");
		
	}
}
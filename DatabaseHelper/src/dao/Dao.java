package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.DATA_CONVERSION;

public class Dao {
	
	
	 private static final String DB_TABLE = "veterinary_hospital.comments"; 
	 private Connection connect;
	 private Statement statement;
	 private ResultSet resultSet;  
	 private PreparedStatement preparedStatement = null;
	 
	 
	 /**
	  * 
	  CREATE TABLE comments (
        id INT NOT NULL AUTO_INCREMENT,
        MYUSER VARCHAR(30) NOT NULL,
        EMAIL VARCHAR(30),
        WEBPAGE VARCHAR(100) NOT NULL,
        DATUM DATE NOT NULL,
        SUMMARY VARCHAR(40) NOT NULL,
        COMMENTS VARCHAR(400) NOT NULL,
        PRIMARY KEY (ID)
     ); 
	  
	  */
	 
	 
	 /**
	  * 
	  CREATE TABLE pets (
        id INT NOT NULL AUTO_INCREMENT,
        name   VARCHAR(30) NOT NULL,
        kind   VARCHAR(30) NOT NULL,
        weight  FLOAT NOT NULL,
        height  FLOAT NOT NULL,
        length  FLOAT NOT NULL,
        
        
        PRIMARY KEY (id)
     ); 
	  
	  */
	 
	 
	public void connect() throws Exception { 
	        try {
	        	
	            // This will load the MySQL driver, each DB has its own driver
	            Class.forName("com.mysql.jdbc.Driver");
	            // Setup the connection with the DB
	            connect = DriverManager
	                    .getConnection("jdbc:mysql://localhost/veterinary_hospital?"
	                            + "user=root&password=poodb");

	            // Statements allow to issue SQL queries to the database
	            statement = connect.createStatement();
	         
	        } catch (Exception e) {
	        	close(); 
	            throw e;
	        } 
    }
	
	
	
	@SuppressWarnings("deprecation")
	public int insert(String... params) throws SQLException{  
        int lastInsertedId = -1;
        String strSQL = "insert into  "+ DB_TABLE+" values (default, ?, ?, ?, ? , ?, ?)";
        
		// PreparedStatements can use variables and are more efficient
        try {
			
			preparedStatement = connect
			        .prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
		
			
	        preparedStatement.setString(1, "Test");
	        preparedStatement.setString(2, "TestEmail");
	        preparedStatement.setString(3, "TestWebpage");
	        preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
	        preparedStatement.setString(5, "TestSummary");
	        preparedStatement.setString(6, "TestComment");
	        preparedStatement.executeUpdate();
        
	        ResultSet rs = preparedStatement.getGeneratedKeys();
	
			if(rs.next())
               lastInsertedId = rs.getInt(1);
       
        } catch (SQLException e) {
        	close(); 
            throw e;	
        } 
        
        return lastInsertedId; 
        
	}
	
	
	/**
	 * SELECT columna FROM tabla WHERE key = value;
	 * @throws SQLException 
	 */
	public void select(int id) throws SQLException{
		final String select = "SELECT columna FROM tabla WHERE key = value"; 
		String selectSQL = "SELECT ID, MYUSER, webpage, summary,datum,comments FROM "+DB_TABLE+" WHERE id = ?";
		
		try {
		
			/*preparedStatement = connect
			        .prepareStatement("SELECT * FROM " + DB_TABLE + "WHERE id = " +  id);
			resultSet = preparedStatement.executeQuery();*/
			
			preparedStatement = connect
			        .prepareStatement(selectSQL); 
			preparedStatement.setInt(1,id);
			resultSet = preparedStatement.executeQuery();
			writeResultSet(resultSet); 
		} catch (SQLException e) {
			close(); 
            throw e;
		}	
		
		
	}
	
	
	public void delete(int id) throws SQLException{		
		try {
			preparedStatement = connect
			        .prepareStatement("delete from "+DB_TABLE+"  where id= ? ; ");
			 preparedStatement.setInt(1, id);
	         preparedStatement.executeUpdate();
		
	    } catch (SQLException e) {
	    	close(); 
            throw e;
		}
	}
	
	
	public void deleteAll() throws SQLException{			
			try{
				preparedStatement = connect
				        .prepareStatement("truncate "+DB_TABLE);
		         preparedStatement.executeUpdate();		
		    } catch (SQLException e) {
		    	close(); 
	            throw e;
			}	         
	}
	
	
	
	
	
	 // You need to close the resultSet
    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
    
    
    private ArrayList<Map> resultSetToCollection(ResultSet resultSet) throws SQLException { 
        // ResultSet is initially before the first data set
    	 ArrayList<Map> list = new ArrayList<Map>(); 
    	
        while (resultSet.next()) {
        	HashMap<String,String> hashMap = new HashMap<String,String>(); 
        	 String id = resultSet.getString("id");
            String user = resultSet.getString("myuser");
            String website = resultSet.getString("webpage");
            String summary = resultSet.getString("summary");
            Date date = resultSet.getDate("datum");
            String comment = resultSet.getString("comments");
       
            hashMap.put("user",id);
            hashMap.put("user",user);
            hashMap.put("website",website);
            hashMap.put("summary",summary);
            hashMap.put("date",date.toString());
            hashMap.put("comment",comment);
            
            list.add(hashMap);  
        }
        
        return list; 
    }
    
    
    public void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
        	 String id = resultSet.getString("id");
            String user = resultSet.getString("myuser");
            String website = resultSet.getString("webpage");
            String summary = resultSet.getString("summary");
            Date date = resultSet.getDate("datum");
            String comment = resultSet.getString("comments");
            System.out.print("\tid: " + user);
            System.out.print("\tUser: " + user);
            System.out.print("\tWebsite: " + website);
            System.out.print("\tsummary: " + summary);
            System.out.print("\tDate: " + date);
            System.out.print("\tComment: " + comment);
            System.out.print("\t\n");
            
        }
    }





}

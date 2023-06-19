package DAO;




	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

import Classes.Etudiant;
import Classes.SingletonConnection;

	public class LoginEtudiantDAO {

	    public static boolean validateLoginEtudiant(Etudiant e) {
	        boolean status = false;

try {	       

	            // Step 2:Create a statement using connection object
	        Connection conn = SingletonConnection.getConnection();
			  PreparedStatement ps = conn.prepareStatement("select * from etudiant where MassarEtudiant= ? and PasswordEtudiant = ? ");
			            ps.setString(1, e.getMassarEtudiant());
			            ps.setString(2, e.getPasswordEtudiant());
	                     System.out.println(ps);
	            
	            ResultSet rs = ps.executeQuery();
	            status = rs.next();
	    } catch (SQLException e1) {
	        
	        printSQLException(e1);
	    }

	   return status;
	   }
	   		    

	    private static void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	}
	



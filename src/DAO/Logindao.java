package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Classes.SingletonConnection;
import Classes.User;

public class Logindao {
	
	
	
	/*
	 * \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	 */
	
	public static boolean login(User u) throws ClassNotFoundException{
		// TODO Auto-generated method stub
		Connection conn=SingletonConnection.getConnection();
		boolean status = false;
    
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("select * from user where username = ? and password = ? "); 
            preparedStatement.setString(1,u.getUsername());
            preparedStatement.setString(2,u.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
            	System.out.println("username Rs : " + rs.getString("username"));
            	status = true;
            }
           
        } 
    	catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
		return status;
	}
	

	/*
	 * \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	 */
	
	
	
	public static String role(User u) throws ClassNotFoundException{
		Connection conn=SingletonConnection.getConnection();
		String role = null;
		try{
            PreparedStatement preparedStatement = conn.prepareStatement("select role from user where username= ? and password= ? "); 
            preparedStatement.setString(1,u.getUsername());
            preparedStatement.setString(2,u.getPassword());
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
            	role = rs.getString("role");	
				System.out.println("valide");
            }
		}
		catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
		
		return role;
		
		
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

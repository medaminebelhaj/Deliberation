package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Classes.News;
import Classes.SingletonConnection;

public class DaoNews {
	
	public void AddNews( News n ) {

		try {
				
			
	    Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		 ps =conn.prepareStatement("INSERT INTO deliberationdb.news (jourNews,textNews,moisNews,dateNews) VALUES (?,?,?,?)"); 
		
		 ps.setString(1,n.getJourNews());
		 ps.setString(2,n.getTextNews());
		 ps.setString(3,n.getMoisNews());
		 ps.setInt(4,n.getDateNews());
		  System.out.println(ps);
		   int i = ps.executeUpdate();
		   
	 
		    
}	catch(Exception a) {
	
	 a.toString();
	
}}
		
		
		
		/*
		 * /////////////////////////////////////////////////////////////////////////////
		 
		 */



public void DeleteNews(int idNews) {

		Connection con=SingletonConnection.getConnection();
		 PreparedStatement ps;
		try {
			ps = con.prepareStatement("delete from news where idnews=?");
			   ps.setInt(1, idNews);

		        int i = ps.executeUpdate();
		        if(i > 0) {
		            System.out.println("User successfully removed...");
		        }
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
		
		
		
	}

	/*
	 * /////////////////////////////////////////////////////////////////////////////
	 
	 */


	public void UpdateNews(String jourNews,String textNews,String moisNews,int dateNews,int idnews) {
		Connection con=SingletonConnection.getConnection();
		 PreparedStatement ps;
		try {                                  
			ps = con.prepareStatement("update news set jourNews=? , textNews=? , moisNews=? , dateNews=? where idnews=?");
		
			 ps.setString(1,jourNews);
			 ps.setString(2, textNews);
			 ps.setString(3,moisNews);
			 ps.setInt(4,dateNews);
			 ps.setInt(5,idnews);
		        int i = ps.executeUpdate();
		        if(i > 0) {
		            System.out.println("User successfully updated...");
		        }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}




}

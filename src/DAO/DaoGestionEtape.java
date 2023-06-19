package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Classes.Etape;
import Classes.Filiere;
import Classes.SingletonConnection;

public class DaoGestionEtape {
	public void AddEtape(Etape  e) {

		try {
				
			
	    Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		 ps =conn.prepareStatement("INSERT INTO deliberationdb.etape (NmEtape,Diplomante,idFiliere_FK) VALUES (?,?,?)"); 
		
		 ps.setString(1,e.getNmEtape());
		 if (e.isDiplomante() == true) {
				ps.setInt(2, 1);

			} else {
				ps.setInt(2, 0);
			}
		 ps.setInt(3, e.getidFiliere_FK());
		  System.out.println(ps);
		   int i = ps.executeUpdate();
		   
	 
		    
}	catch(Exception a) {
	
	 a.toString();
	
}}
		
		
		
		/*
		 * /////////////////////////////////////////////////////////////////////////////
		 
		 */



public void DeleteEtape(int idEtape) {

		Connection con=SingletonConnection.getConnection();
		 PreparedStatement ps;
		try {
			ps = con.prepareStatement("delete from etape where idetape=?");
			   ps.setInt(1, idEtape);

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



	public void UpdateEtape(int idEtape,String NomEtape,Boolean Diplomante,int idFiliere) {
		Connection con=SingletonConnection.getConnection();
		 PreparedStatement ps;
		try {
			ps = con.prepareStatement("update etape set NmEtape=? , Diplomante=? , idFiliere_FK=? where idetape=?");
		
			ps.setString(1,NomEtape );
			 if (Diplomante == true) {
					ps.setInt(2, 1);

				} else {
					ps.setInt(2, 0);
				}
			 ps.setInt(3,idFiliere );
				ps.setInt(4, idEtape);
			

		        int i = ps.executeUpdate();
		        if(i > 0) {
		            System.out.println("User successfully updated...");
		        }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}



	
}
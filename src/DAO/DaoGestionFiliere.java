package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Classes.Enseignant;
import Classes.Filiere;
import Classes.SingletonConnection;

	

public class DaoGestionFiliere {
	
	
	public int getIdFilierByName(String name) {
		  Connection conn = SingletonConnection.getConnection();
			// TODO Auto-generated method stub
				String Filiere=null;
					try {
						PreparedStatement ps= conn.prepareStatement("select * from filiere where NomFiliere= ?");
						ps.setString(1, name);
						ResultSet rs = ps.executeQuery();
						if  (rs.next()) {
					Filiere =(rs.getString("idfiliere"));
					
					
					 
						}
					}
					catch (SQLException e) {
						 e.printStackTrace();
					}
					return Integer.parseInt(Filiere);
			
	}
	public  String getNameFiliereById(int idfiliere) {
	    Connection conn = SingletonConnection.getConnection();
		// TODO Auto-generated method stub
			String Filiere=null;
				try {
					PreparedStatement ps= conn.prepareStatement("select * from filiere where idfiliere= ?");
					ps.setInt(1, idfiliere);
					ResultSet rs = ps.executeQuery();
					if  (rs.next()) {
				Filiere =(rs.getString("NomFiliere"));
				
				System.out.println("valide");
				 
					}
				}
				catch (SQLException e) {
					 e.printStackTrace();
				}
				return Filiere;
		
	}
	

public void AddFiliere(Filiere u) {

	try {
			
		
    Connection conn = SingletonConnection.getConnection();
	PreparedStatement ps;
	
    
    ps =conn.prepareStatement("INSERT INTO deliberationdb.filiere (NomFiliere) VALUES (?)"); 
   
    		
   
    ps.setString(1,u.getNomFiliere());
   
    System.out.println(ps);
  
    int i = ps.executeUpdate();  
    // ""+i;
			/*
			 * if(i>0) out.print("You are successfully registered...");
			 */
		
		
	}
	catch(Exception e) {
		
		 e.toString();
		
	}

}

	/*
	 * /////////////////////////////////////////////////////////////////////////////
	 
	 */



public void DeleteFiliere(int idFiliere) {
	Connection con=SingletonConnection.getConnection();
	 PreparedStatement ps;
	try {
		ps = con.prepareStatement("delete from filiere where idfiliere=?");
		   ps.setInt(1, idFiliere);

	        int i = ps.executeUpdate();
	        if(i > 0) {
	            System.out.println("User successfully removed...");
	        }
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
	
	
	
}

/*
 * /////////////////////////////////////////////////////////////////////////////
 
 */



public void UpdateFiliere(int idFiliere,String NomFiliere,String Respo) {
	Connection con=SingletonConnection.getConnection();
	 PreparedStatement ps;
	try {
		ps = con.prepareStatement("update filiere set NomFiliere=? , RespoFiliere=? where idfiliere=?");
		  
		ps.setString(1,NomFiliere );
		ps.setString(2,Respo);
		ps.setInt(3, idFiliere);
		

	        int i = ps.executeUpdate();
	        if(i > 0) {
	            System.out.println("User successfully updated...");
	        }
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
	
	
	
}



}
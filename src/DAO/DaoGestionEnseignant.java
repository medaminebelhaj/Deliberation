package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Classes.Enseignant;
import Classes.SingletonConnection;
import Classes.User;

public class DaoGestionEnseignant {

	
	
	public   Enseignant getEnseignantById(int idenseignant) {
	
	    Connection conn = SingletonConnection.getConnection();
		// TODO Auto-generated method stub
				Enseignant c = new Enseignant();
				try {
					PreparedStatement ps= conn.prepareStatement("select * from enseignant where idenseignant= ?");
					ps.setInt(1, idenseignant);
					ResultSet rs = ps.executeQuery();
					if  (rs.next()) {
				c.setNomEnseignant((rs.getString("NomEnseignant")));
				c.setPrenomEnseignant((rs.getString("PrenomEnseignant")));
				c.setUsernameEnseignant((rs.getString("UsernameEnseignant")));
				c.setPasswordEnseignant((rs.getString("PasswordEnseignant")));
				c.setRoleEnseignant((rs.getString("RoleEnseignant")));
				c.setEmailEnseignant((rs.getString("EmailEnseignant")));
			    c.setIdFiliere(Integer.parseInt(rs.getString("idFiliere")));
				c.setIdEnseignant(Integer.parseInt(rs.getString("idenseignant")));
				System.out.println("valide");
				 
					}
				}
				catch (SQLException e) {
					 e.printStackTrace();
				}
				return c;
		
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public   Enseignant getEnseignantByUsername(String Username) {
		
	    Connection conn = SingletonConnection.getConnection();
		// TODO Auto-generated method stub
				Enseignant c = new Enseignant();
				try {
					PreparedStatement ps= conn.prepareStatement("select * from enseignant where UsernameEnseignant= ?");
					ps.setString(1, Username);
					ResultSet rs = ps.executeQuery();
					if  (rs.next()) {
				c.setNomEnseignant((rs.getString("NomEnseignant")));
				c.setPrenomEnseignant((rs.getString("PrenomEnseignant")));
				c.setUsernameEnseignant((rs.getString("UsernameEnseignant")));
				c.setPasswordEnseignant((rs.getString("PasswordEnseignant")));
				c.setRoleEnseignant((rs.getString("RoleEnseignant")));
				c.setEmailEnseignant((rs.getString("EmailEnseignant")));
			    c.setIdFiliere(Integer.parseInt(rs.getString("idFiliere")));
				c.setIdEnseignant(Integer.parseInt(rs.getString("idenseignant")));
				System.out.println("valide");
				 
					}
				}
				catch (SQLException e) {
					 e.printStackTrace();
				}
				return c;
		
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
public void DeleteEnseignant(int id) {
	Connection con=SingletonConnection.getConnection();
	 PreparedStatement ps;
	try {
		ps = con.prepareStatement("delete from enseignant where idenseignant=?");
		   ps.setInt(1, id);

	        int i = ps.executeUpdate();
	        if(i > 0) {
	            System.out.println("User successfully removed...");
	        }
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
	
	
	
}



public void UpdateUser(String NomEnseignant,String PrenomEnseignant ,int idfiliere,String EmailEnseignant ,String UsernameEnseignant,int idenseignant) {
	Connection con=SingletonConnection.getConnection();
	 PreparedStatement ps;
	try {
		ps = con.prepareStatement("update enseignant set NomEnseignant=?,PrenomEnseignant=? ,idFiliere=?,EmailEnseignant=? ,UsernameEnseignant=?   where idenseignant=?");
		  
		ps.setString(1,NomEnseignant);
		ps.setInt(2, idfiliere);
		ps.setString(3,PrenomEnseignant);
		ps.setString(4,EmailEnseignant);
		ps.setString(5,UsernameEnseignant);
		
		ps.setInt(6,idenseignant);

	        int i = ps.executeUpdate();
	        if(i > 0) {
	            System.out.println("User successfully updated...");
	        }
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
	
	
	
}
////////////////////////////////////////////////////////////////////////////////////////////

public void UpdateRole(int idenseigant,String Filiere) {
	Connection con=SingletonConnection.getConnection();
	 PreparedStatement ps;
	try {
		ps = con.prepareStatement("update enseignant set RoleEnseignant=? where idenseignant=?");
		  
		ps.setString(1, "Responsable"+"("+Filiere+")");
		ps.setInt(2,idenseigant);
		

	        int i = ps.executeUpdate();
	        if(i > 0) {
	            System.out.println("Role successfully updated...");
	        } 
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}
	


////////////////////////////////////////////////////////////////////////////////////////////



public void AddUser(Enseignant u) {

	try {
			
		
    Connection conn = SingletonConnection.getConnection();
	PreparedStatement ps;
	
    
    ps =conn.prepareStatement("INSERT INTO deliberationdb.enseignant (NomEnseignant,idFiliere,PrenomEnseignant,EmailEnseignant,UsernameEnseignant,PasswordEnseignant,RoleEnseignant) VALUES (?,?,?,?,?,?,?)"); 
   
    		
    ps.setString(1,u.getNomEnseignant());
    ps.setInt(2, u.getIdFiliere());
    ps.setString(3,u.getPrenomEnseignant());
    
    ps.setString(4,u.getEmailEnseignant() );
    ps.setString(5,u.getUsernameEnseignant());
    ps.setString(6,u.getPasswordEnseignant());
    ps.setString(7,u.getRoleEnseignant());
   
    System.out.println(ps);
  
    int i = ps.executeUpdate();}  
    catch(Exception a) {
    	
   	 a.toString();
   	
   }
}




}

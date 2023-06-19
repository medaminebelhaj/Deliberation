package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Classes.Filiere;
import Classes.SingletonConnection;
import Classes.User;

public class DaoGestionUsers {
	public static User getUserByUsername(String Username) {
	    Connection conn = SingletonConnection.getConnection();
		// TODO Auto-generated method stub
				User c=new User();
				try {
					PreparedStatement ps= conn.prepareStatement("select * from user where username= ?");
					ps.setString(1, Username);
					ResultSet rs = ps.executeQuery();
					if  (rs.next()) {
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setUsername(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				c.setRole(rs.getString("role"));
				c.setEmail(rs.getString("email"));
				c.setPassword(rs.getString("password"));
				c.setIdUser(Integer.parseInt(rs.getString("idUser")));
				System.out.println("valide");
				 
					}
				}
				catch (SQLException e) {
					 e.printStackTrace();
				}
				return c;
		
	}
	
	/*
	 * /////////////////////////////////////////////////////////////////////////////
	 
	 */

	
	public void AddUser(User u) {

		try {
				
			
	    Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		
	    
	    ps =conn.prepareStatement("INSERT INTO deliberationdb.user (nom,prenom,username,password,role,email) VALUES (?,?,?,?,?,?)"); 
	   
	    		
	    ps.setString(1,u.getNom());
	    ps.setString(2,u.getPrenom());
	    ps.setString(3,u.getUsername());
	    ps.setString(4,u.getPassword());
	    ps.setString(5,u.getRole());
	    ps.setString(6,u.getEmail());
	   
	    System.out.println(ps);
	  
	    int i = ps.executeUpdate();}  
	    catch(Exception a) {
	    	
	   	 a.toString();
	   	
	   }
	}
	/*
	 * /////////////////////////////////////////////////////////////////////////////
	 
	 */



public void DeleteUser(int idUser) {
	Connection con=SingletonConnection.getConnection();
	 PreparedStatement ps;
	try {
		ps = con.prepareStatement("delete from user where idUser=?");
		   ps.setInt(1, idUser);

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



public void UpdateUser(String NomUser,String PrenomUser ,String EmailUser,String UsernameUser, String PasswordUser,String Role,int idUser) {
	Connection con=SingletonConnection.getConnection();
	 PreparedStatement ps;
	try {
		ps = con.prepareStatement("update user set nom=? ,prenom=?,email=? ,username=? ,password=? ,role=? where idUser=?");
		  
		ps.setString(1,NomUser);
		ps.setString(2,PrenomUser);
		ps.setString(3,EmailUser);
		ps.setString(4,UsernameUser);
		ps.setString(5,PasswordUser);
		ps.setString(6,Role);
		ps.setInt(7, idUser);

	        int i = ps.executeUpdate();
	        if(i > 0) {
	            System.out.println("User successfully updated...");
	        }
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
	
	
	
}



/*
 * /////////////////////////////////////////////////////////////////////////////
 
 */
public void UpdateUser1(String NomUser,String PrenomUser ,String EmailUser,String UsernameUser, String PasswordUser,String Role,int idUser) {
	Connection con=SingletonConnection.getConnection();
	 PreparedStatement ps;
	try {
		ps = con.prepareStatement("update user set nom=? ,prenom=?,email=? ,username=? ,password=? ,role=? where idUser=?");
		  
		ps.setString(1,NomUser);
		ps.setString(2,PrenomUser);
		ps.setString(3,EmailUser);
		ps.setString(4,UsernameUser);
		ps.setString(5,PasswordUser);
		ps.setString(6,Role);
		ps.setInt(7, idUser);

	        int i = ps.executeUpdate();
	        if(i > 0) {
	            System.out.println("User successfully updated...");
	        }
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
	
	
	
}










  //////////////////////////////////////////////////////////////////////////////////////////// */

public void UpdatePassword(String NewPassword,int idUser) {
	Connection con=SingletonConnection.getConnection();
	 PreparedStatement ps;
	try {
		ps = con.prepareStatement("update user set password=? where idUser=?");
		  
		ps.setString(1, NewPassword);
		ps.setInt(2,idUser);
		

	        int i = ps.executeUpdate();
	        if(i > 0) {
	            System.out.println("Password successfully updated...");
	        }
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
	
	
	
}

/*
 * /////////////////////////////////////////////////////////////////////////////
 
 */









}
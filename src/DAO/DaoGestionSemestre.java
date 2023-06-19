package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Classes.Etape;
import Classes.EtudiantInscriptionAdministrative;
import Classes.Module;
import Classes.Semestre;
import Classes.SingletonConnection;
import Classes.User;

public class DaoGestionSemestre {
	
	 public static ArrayList<String> GetAllEtapesByIdFil(String idFiliere) throws SQLException{
		 ArrayList<String>L=new ArrayList<String>(); 
		    Connection conn = SingletonConnection.getConnection();
		    PreparedStatement preparedStatement = conn.prepareStatement("Select * from deliberationdb.etape where idFiliere_FK=?"); 
            preparedStatement.setString(1,idFiliere);
            
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
		 
		    while (rs.next()) 
	        {  
	            
	       
				
				  int idetap =Integer.parseInt(rs.getString("idetape")); 
				  String Dip=rs.getString("Diplomante");
				  String nomEtape=rs.getString("NmEtape");
		     Etape e = new Etape();
		     e.setidFiliere_FK(Integer.parseInt(idFiliere));
		     e.setDiplomante(Boolean.parseBoolean(Dip));
		     e.setNmEtape(nomEtape);
		     e.setIdEtape(idetap);
			  
			 L.add(e.toString());
				 
		
	        }  
		
			return L; 
			}
	 
	/*
	 * 
	 * |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| |||||||
	 *
	 */
	 public static ArrayList<String> GetAllSemestreByIdEtape(String idetape) throws SQLException{
		 ArrayList<String>L=new ArrayList<String>();
		    Connection conn = SingletonConnection.getConnection();
		    PreparedStatement preparedStatement = conn.prepareStatement("Select * from deliberationdb.semestre where idEtape_FK=?"); 
            preparedStatement.setString(1,idetape);
            
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
		 
		    while (rs.next()) 
	        {  
	            
	       
				
				  int idsem =Integer.parseInt(rs.getString("idsemestre")); 
				  String NumSemestre=rs.getString("NmSemestre");
				  
				  float NoteVal =Float.parseFloat(rs.getString("NoteValidation"));
				  int idEtape =Integer.parseInt(idetape);
		     Semestre s = new Semestre( NumSemestre,idsem,idEtape, NoteVal);
		    
			 L.add(s.toString());
				 
		
	        }  
		
			return L; 
			}
	 /*
		 * 
		 * |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| |||||||
		 *
		 */
	 


public void DeleteSemestre(int idSemestre) {
	Connection con=SingletonConnection.getConnection();
	 PreparedStatement ps;
	try {
		ps = con.prepareStatement("delete from semestre where idsemestre=?");
		   ps.setInt(1, idSemestre);

	        int i = ps.executeUpdate();
	        if(i > 0) {
	            System.out.println("User successfully removed...");
	        }
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
	
	
	
}
	 

/*
 * 
 * |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| |||||||
 *
 */



public void UpdateUser(int idsemestre,String NmSemestre ,float NoteValidation) {
	Connection con=SingletonConnection.getConnection();
	 PreparedStatement ps;
	try {
		ps = con.prepareStatement("update semestre set NmSemestre=?,NoteValidation=? where idSemestre=?");
		  
		ps.setString(1,NmSemestre);
		ps.setFloat(2,NoteValidation);
		ps.setInt(3,idsemestre);

	        int i = ps.executeUpdate();
	        if(i > 0) {
	            System.out.println("User successfully updated...");
	        }
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
	
	
	
}
	/*
	 * ////////////////////////////////////////////////////////////////////////////////////////
	 */

public void AddSemestre(Semestre u) {

	try {
			
		
    Connection conn = SingletonConnection.getConnection();
	PreparedStatement ps;
	
    
    ps =conn.prepareStatement("INSERT INTO deliberationdb.semestre (NmSemestre,NoteValidation,idEtape_FK) VALUES (?,?,?)"); 
   
    		
   
    ps.setString(1,u.getNmSemestre());
    ps.setFloat(2, (int)u.getNoteValidation());
    ps.setInt(3,u.getIdEtape_FK());
   
    System.out.println(ps);
  
    int i = ps.executeUpdate();  
    // ""+i;
			/*
			 * if(i>0) out.print("You are successfully registered...");
			 */
		
		
	}
catch (SQLException e) {
		
		e.printStackTrace();
	}


}
}
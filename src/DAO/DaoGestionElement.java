package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Classes.Module;
import Classes.SingletonConnection;
import Classes.element;

public class DaoGestionElement {
	public  String getNameElementById(int idelement) {
	    Connection conn = SingletonConnection.getConnection();
		// TODO Auto-generated method stub
			String Filiere=null;
				try {
					PreparedStatement ps= conn.prepareStatement("select * from element where idelement= ?");
					ps.setInt(1, idelement);
					ResultSet rs = ps.executeQuery();
					if  (rs.next()) {
				Filiere =(rs.getString("NomElement"));
				
				System.out.println("valide");
				 
					}
				}
				catch (SQLException e) {
					 e.printStackTrace();
				}
				return Filiere;
		
	}
	

	public void AddElement(Module u) {

		try {
				
			
	    Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		
	    
	    ps =conn.prepareStatement("INSERT INTO deliberationdb.element (CorficientElement,NoteEliminatioreElement,NoteValidationElement,NomElement,idenseignant,idmoduleFK) VALUES (?,?,?,?,?,?)"); 
	   
	    		
	   
	    ps.setFloat(1,u.getCoifficiantModule() );
	    ps.setFloat(2,u.getNoteEliminatiore());
	    ps.setFloat(3,u.getNoteValidation());
	    ps.setString(4, u.getNomModule() );
	    ps.setInt(5, u.getIdEns());
	    ps.setInt(6, u.getIdModule());
	  
	    
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
	public void AddElement(element u) {

		try {
				
			
	    Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		
	    
	    ps =conn.prepareStatement("INSERT INTO deliberationdb.element (CorficientElement,NoteEliminatioreElement,NoteValidationElement,NomElement,idenseignant,idmoduleFK) VALUES (?,?,?,?,?,?)"); 
	   
	    		
	   
	    ps.setFloat(1,u.getCorficientElement() );
	    ps.setFloat(2,u.getNoteEliminatioreElement());
	    ps.setFloat(3,u.getNoteValidationElement());
	    ps.setString(4, u.getNomElement() );
	    ps.setInt(5, u.getIdensei());
	    ps.setInt(6, u.getIdmodule());
	  
	    
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
	/////////////////////////////////////////////////////////////////////
	 public static ArrayList<String> GetAllElementByIdModule(int idModule) throws SQLException{
		 ArrayList<String>L=new ArrayList<String>(); 
		    Connection conn = SingletonConnection.getConnection();
		    PreparedStatement preparedStatement = conn.prepareStatement("Select * from deliberationdb.element where idmoduleFK=?"); 
            preparedStatement.setInt(1,idModule);
            
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
		 
		    while (rs.next()) 
	        {  
	            
	       
				
				  int idelement =Integer.parseInt(rs.getString("idelement")); 
				  String NomElement=rs.getString("NomElement");
				  float NoteEliminatioreElement =Float.parseFloat(rs.getString("NoteEliminatioreElement"));
				  int CoifficientModule=Integer.parseInt(rs.getString("CorficientElement")); 
				  
				  float NoteValidationModule =Float.parseFloat(rs.getString("NoteValidationElement"));
				  int idenseignant =Integer.parseInt(rs.getString("idenseignant")); 
				 
		    element e =new element();
		     e.setIdelement(idelement);
		     e.setNomElement(NomElement);
		     e.setNoteEliminatioreElement(NoteEliminatioreElement);
		     e.setNoteValidationElement(NoteValidationModule);
		     e.setCorficientElement(CoifficientModule);
		     e.setIdensei(idenseignant);
	
			 L.add(e.toString1());
				 
		
	        }  
		
			return L; 
			}

}

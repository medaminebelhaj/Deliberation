package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Classes.Etape;
import Classes.Filiere;
import Classes.Module;
import Classes.SingletonConnection;
import Classes.User;
import Classes.element;

public class DaoGestionModule {
	 public static ArrayList<String> GetAllModulesByIdEtape(int idEtape) throws SQLException{
		 ArrayList<String>L=new ArrayList<String>(); 
		    Connection conn = SingletonConnection.getConnection();
		    PreparedStatement preparedStatement = conn.prepareStatement("Select * from deliberationdb.module where idEtape=?"); 
            preparedStatement.setInt(1,idEtape);
            
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
		 
		    while (rs.next()) 
	        {  
	            
	       
				
				  int idModule =Integer.parseInt(rs.getString("idModule")); 
				  String NmModule=rs.getString("NomModule");
				  float NoteEliminatoireModule =Float.parseFloat(rs.getString("NoteEliminatoireModule"));
				  int CoifficientModule=Integer.parseInt(rs.getString("CoifficientModule")); 
				  
				  float NoteValidationModule =Float.parseFloat(rs.getString("NoteValidationModule"));
				 
		     Module e = new Module();
		     e.setIdModule(idModule);
		     e.setNomModule(NmModule);;
		     e.setCoifficiantModule(CoifficientModule);
		     e.setNoteEliminatiore(NoteEliminatoireModule);
		     e.setCoifficiantModule(CoifficientModule);
		     e.setNoteValidation(NoteValidationModule);
	
			 L.add(e.toString());
				 
		
	        }  
		
			return L; 
			}

	/*
	 * /////////////////////////////////////////////////////////////////////////////
	 * /////////
	 * 
	 */	 
	 
	 
	 public static ArrayList<String> GetAllModulesByIdSemestre(int idSemestre) throws SQLException{
		 ArrayList<String>L=new ArrayList<String>(); 
		    Connection conn = SingletonConnection.getConnection();
		    PreparedStatement preparedStatement = conn.prepareStatement("Select * from deliberationdb.module where idSemestre_FK=?"); 
            preparedStatement.setInt(1,idSemestre);
            
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
		 
		    while (rs.next()) 
	        {  
	            
	       
				
				  int idModule =Integer.parseInt(rs.getString("idModule")); 
				  String NmModule=rs.getString("NomModule");
				  float NoteEliminatoireModule =Float.parseFloat(rs.getString("NoteEliminatoireModule"));
				  int CoifficientModule=Integer.parseInt(rs.getString("CoifficientModule")); 
				  
				  float NoteValidationModule =Float.parseFloat(rs.getString("NoteValidationModule"));
				 
		     Module e = new Module();
		     e.setIdModule(idModule);
		     e.setNomModule(NmModule);;
		     e.setCoifficiantModule(CoifficientModule);
		     e.setNoteEliminatiore(NoteEliminatoireModule);
		     e.setCoifficiantModule(CoifficientModule);
		     e.setNoteValidation(NoteValidationModule);
	
			 L.add(e.toString());
				 
		
	        }  
		
			return L; 
			}
	 
	 
	 public static ArrayList<Module> GetAllModulesByIdSemestreAsObject(int idSemestre) throws SQLException{
		 ArrayList<Module>L=new ArrayList<Module>(); 
		    Connection conn = SingletonConnection.getConnection();
		    PreparedStatement preparedStatement = conn.prepareStatement("Select * from deliberationdb.module where idSemestre_FK=?"); 
            preparedStatement.setInt(1,idSemestre);
            
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
		 
		    while (rs.next()) 
	        {  
	            
	       
				
				  int idModule =Integer.parseInt(rs.getString("idModule")); 
				  String NmModule=rs.getString("NomModule");
				  float NoteEliminatoireModule =Float.parseFloat(rs.getString("NoteEliminatoireModule"));
				  int CoifficientModule=Integer.parseInt(rs.getString("CoifficientModule")); 
				  
				  float NoteValidationModule =Float.parseFloat(rs.getString("NoteValidationModule"));
				 
		     Module e = new Module();
		     e.setIdModule(idModule);
		     e.setNomModule(NmModule);;
		     e.setCoifficiantModule(CoifficientModule);
		     e.setNoteEliminatiore(NoteEliminatoireModule);
		     e.setCoifficiantModule(CoifficientModule);
		     e.setNoteValidation(NoteValidationModule);
	
			 L.add(e);
				 
		
	        }  
		
			return L; 
			}
	 
	 
	 public static ArrayList<String> GetAllElementByidModule(int idmodule) throws SQLException{
		 ArrayList<String>L=new ArrayList<String>(); 
		    Connection conn = SingletonConnection.getConnection();
		    PreparedStatement preparedStatement = conn.prepareStatement("Select * from deliberationdb.element where idmoduleFK=?"); 
            preparedStatement.setInt(1,idmodule);
            
            
            ResultSet rs = preparedStatement.executeQuery();
		 
		    while (rs.next()) 
	        {  
	            
	       
		 
		    	  int idElement =Integer.parseInt(rs.getString("idelement")); 
				  String NomElement=rs.getString("NomElement");
				  int idModule =Integer.parseInt(rs.getString("idmoduleFK")); 
				  float NoteEliminatoireModule =Float.parseFloat(rs.getString("NoteEliminatioreElement"));
				  int CoifficientModule=Integer.parseInt(rs.getString("CorficientElement")); 
				 
				  float NoteValidationModule =Float.parseFloat(rs.getString("NoteValidationElement"));
				  int idens =Integer.parseInt(rs.getString("idenseignant")); 
		     element e = new element(idElement,NomElement,idModule,CoifficientModule,idens,NoteEliminatoireModule,NoteValidationModule);
		    
			 L.add(e.toString1());
				 
		
	        }  
		
			return L; 
			}

public void DeleteModule(int idModule) {
	Connection con=SingletonConnection.getConnection();
	 PreparedStatement ps;
	try {
		ps = con.prepareStatement("delete from module where idModule=?");
		   ps.setInt(1, idModule);

	        int i = ps.executeUpdate();
	        if(i > 0) {
	            System.out.println("Module successfully removed...");
	        }
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
	
	
	
}
	/*
	               * ///////////////////////////////////////////////////////////
	              
	 */

public void AddModule(Module u) {

	try {
			
		
    Connection conn = SingletonConnection.getConnection();
	PreparedStatement ps;
	
    
    ps =conn.prepareStatement("INSERT INTO deliberationdb.module (NoteEliminatoireModule,CoifficientModule,NoteValidationModule,NomModule,idSemestre_FK,idEtape,idEnseignant) VALUES (?,?,?,?,?,?,?)"); 
   
    		
   
    ps.setFloat(1,u.getNoteEliminatiore());
    ps.setInt(2, (int)u.getCoifficiantModule());
    ps.setFloat(3,u.getNoteValidation());
    ps.setString(4, u.getNomModule());
    ps.setInt(5, u.getIdSemestre());
    ps.setInt(6, u.getIdEtape());
    ps.setInt(7, u.getIdEns());
    
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
public void UpdateM(int idsemestre,String NmSemestre ,float NoteValidation,float NoteElimini) {
	Connection con=SingletonConnection.getConnection();
	 PreparedStatement ps;
	try {
		ps = con.prepareStatement("update module set NomModule=?,NoteValidationModule=? ,NoteEliminatoireModule=? where idModule=?");
		  
		ps.setString(1,NmSemestre);
		ps.setFloat(2,NoteValidation);
		ps.setFloat(3,NoteElimini);
		ps.setInt(4,idsemestre);

	        int i = ps.executeUpdate();
	        if(i > 0) {
	            System.out.println("Module successfully updated...");
	        }
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
	
	
	
}
	/*
	 *            /////////////////////////////////////////////////////////////////////////////
	 *  
	 */
public Module getTheLastModule() {
    Connection conn = SingletonConnection.getConnection();
	// TODO Auto-generated method stub
			Module m=new Module();
			try {
				PreparedStatement ps= conn.prepareStatement("SELECT * FROM module ORDER BY idModule DESC LIMIT 1");
				
				ResultSet rs = ps.executeQuery();
				if  (rs.next()) {
					m.setCoifficiantModule(Integer.parseInt(rs.getString("CoifficientModule")));
					m.setIdEns(Integer.parseInt(rs.getString("idEnseignant")));
					m.setIdSemestre(Integer.parseInt(rs.getString("idSemestre_FK")));
					m.setIdEtape(Integer.parseInt(rs.getString("idEtape")));
				m.setIdModule(Integer.parseInt(rs.getString("idModule")));
					m.setNomModule((rs.getString("NomModule")));
					m.setNoteEliminatiore(Float.parseFloat(rs.getString("NoteEliminatoireModule")));
					m.setNoteValidation(Float.parseFloat(rs.getString("NoteValidationModule")));
					
		
			System.out.println("valide");
			 
				}
			}
			catch (SQLException e) {
				 e.printStackTrace();
			}
			return m;
	
}
}

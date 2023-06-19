package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import Classes.SingletonConnection;

public class DaoGestionEtudiant {
	public static ArrayList<String> GetAllEtudiantByIdUni(String idAnne,int idSemestre) throws SQLException{
		 ArrayList<String>L=new ArrayList<String>(); 
		    Connection conn = SingletonConnection.getConnection();
		    PreparedStatement preparedStatement = conn.prepareStatement("SELECT  etudiantinscriptionpedago.*,  inscriptionparelement.*, module.idSemestre_FK FROM deliberationdb.inscriptionparelement join module on inscriptionparelement.idModule=module.idModule and module.idSemestre_FK=? and inscriptionparelement.idanneUn=? join etudiantinscriptionpedago on inscriptionparelement.MassarEtudiant=etudiantinscriptionpedago.MassarEtudiant group by etudiantinscriptionpedago.MassarEtudiant" ); 
		    preparedStatement.setInt(1,5);
		    preparedStatement.setString(2,idAnne);
           
           System.out.println(preparedStatement);
           ResultSet rs = preparedStatement.executeQuery();
		 
		    while (rs.next()) 
	        {  
		    	System.out.println("ok");
				  String MassarEtudiant =(rs.getString("MassarEtudiant")); 
				
				  String  NomFr=(rs.getString("NomFr"));
				 String PrenomFr =(rs.getString("PrenomFr"));
				 String DatedeNaissance=(rs.getString("DatedeNaissance"));
				 String LieudeNaissanceFr=(rs.getString("LieudeNaissanceFr"));
				  
				 String obj="[" + MassarEtudiant + "," + NomFr +"," + PrenomFr +"," + DatedeNaissance+"," + LieudeNaissanceFr+"]";
			  
			 L.add(obj.toString());
				 
		
	        }  
		
			return L; 
			}
}

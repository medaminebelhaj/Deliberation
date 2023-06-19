package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.mysql.cj.ParseInfo;

import Classes.Etudiant;
import Classes.EtudiantInscrictionEnligne;
import Classes.EtudiantInscriptionAdministrative;
import Classes.SingletonConnection;

public class DAOdelib {

	
//----------------------------------------------------------------------------------------------------------------
	public void ValiderInscriptionEnligne(EtudiantInscrictionEnligne u) {

		try {
				
			
	    Connection conn = SingletonConnection.getConnection();
		PreparedStatement ps;
	    
	    ps =conn.prepareStatement("insert into deliberationdb.etudiantinscriptionenlignevalide values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
	    
	    ps.setString(1,u.getMassarEtdudiant());
	    ps.setString(2,u.getNomFr());
	    ps.setString(3,u.getNomAr());
	    ps.setString(4,u.getPrenomFr());
	    ps.setString(5,u.getPrenomAr());
	    ps.setString(6,u.getCIN());
	    ps.setString(7,u.getNationalite());
	    ps.setString(8,u.getSexe());
	    ps.setDate(9,u.getDatedeNaissance());
	    ps.setString(10,u.getLieudeNaissanceFr());
	    ps.setString(11,u.getLieudeNaissanceAr());
	    ps.setString(12,u.getVille());
	    ps.setString(13,u.getProvince());
	    ps.setString(14,u.getAnnéedeBAC());
	    ps.setString(15,u.getSeriedeBAC());
	    ps.setString(16,u.getMention());
	    ps.setString(17,u.getLycee());
	    ps.setString(18,u.getLieudeBAC());
	    ps.setString(19,u.getAcademie());
	    ps.setDate(20,u.getDateInscription());
	    ps.setString(21,u.getEtablissement());
	    ps.setInt(22,u.getFiliere());
	 
	    
	  
	    int i = ps.executeUpdate();  
	    // ""+i;
				/*
				 * if(i>0) out.print("You are successfully registered...");
				 */
			
			
		}
		catch(Exception e) {
			
			 System.out.println(e.toString());
			
		}
		}
//----------------------------------------------------------------------------------------------------------------
	
	//----------------------------------------------------------------------------------------------------------------
public void ValiderInscriptionEnligneValide( EtudiantInscriptionAdministrative u) {

	try {
			
		
    Connection conn = SingletonConnection.getConnection();
	PreparedStatement ps;
    
    ps =conn.prepareStatement("insert into deliberationdb.etudiantinscriptionpedago(MassarEtudiant,NomFr,NomAr,PrenomFr,PrenomAr,CIN,Nationalite,Sexe,DatedeNaissance,LieudeNaissanceFr,LieudeNaissanceAr,Ville,Province,AnneedeBAC,SeriedeBAC,Mention,Lycee,LieudeBAC,Academie,DateInscription,Etablisement,idFiliere_FK,AnneUni,stats,usernameEtu) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
   
    ps.setString(1,u.getMassarEtdudiant());
    ps.setString(2,u.getNomFr());
    ps.setString(3,u.getNomAr());
    ps.setString(4,u.getPrenomFr());
    ps.setString(5,u.getPrenomAr());
    ps.setString(6,u.getCIN());
    ps.setString(7,u.getNationalite());
    ps.setString(8,u.getSexe());
    ps.setDate(9,u.getDatedeNaissance());
    ps.setString(10,u.getLieudeNaissanceFr());
    ps.setString(11,u.getLieudeNaissanceAr());
    ps.setString(12,u.getVille());
    ps.setString(13,u.getProvince());
    ps.setString(14,u.getAnnéedeBAC());
    ps.setString(15,u.getSeriedeBAC());
    ps.setString(16,u.getMention());
    ps.setString(17,u.getLycee());
    ps.setString(18,u.getLieudeBAC());
    ps.setString(19,u.getAcademie());
    ps.setDate(20,u.getDateInscription());
   
    ps.setString(21,u.getEtablissement());
    ps.setInt(22,u.getFiliere());
    String aux=u.getDateInscription().toString();
    String a = aux.substring(0,4);
    int s = Integer.parseInt(a);
    int s1 = Integer.parseInt(a)+1;
    String anne =""+s+"/"+s1;
    ps.setString(23,anne);
    ps.setString(24,"non inscrit");
    ps.setString(25,(u.getNomFr()+u.getPrenomFr()).toLowerCase());
    System.out.println("Siuuuuu");
  
    int i = ps.executeUpdate();  
    // ""+i;
			/*
			 * if(i>0) out.print("You are successfully registered...");
			 */
		
		
	}
	catch(Exception e) {
		
		System.out.println(e.toString());
		
	}
	}









///////////////////////////////////////////////////////////////////////////////////////////////////////////////




public void UpdateStats(String stats,String Massar) {
	Connection con=SingletonConnection.getConnection();
	 PreparedStatement ps;
	try {
		ps = con.prepareStatement("update etudiantinscriptionpedago set stats=? where MassarEtudiant=?");
		  
		ps.setString(1,stats);
		ps.setString(2,Massar);

	        int i = ps.executeUpdate();
	        if(i > 0) {
	            System.out.println("Etudiant Inscrit...");
	        }
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
	
	
	
}



}
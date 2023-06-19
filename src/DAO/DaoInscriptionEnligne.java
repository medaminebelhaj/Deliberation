package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Classes.EtudiantInscrictionEnligne;
import Classes.SingletonConnection;

public class DaoInscriptionEnligne {

	public DaoInscriptionEnligne() {
		
		
	}

public void deleteInscriptionEnligne(String Massar) {
	
	String req="DELETE FROM etudiantinscriptionenligne WHERE MassarEtudiant=?";
	
	try{
		new SingletonConnection();
		Connection con=SingletonConnection.getConnection();
		PreparedStatement ps=con.prepareStatement(req);
		ps.setString(1,Massar);
		int status=ps.executeUpdate();

		con.close();
	}
	catch(Exception e)
	{e.printStackTrace();
	}

}

public void valideInscriptionEnligne(String Massar) {
	
	try {
	   Connection conn = SingletonConnection.getConnection();

	   String req="Select * from etudiantinscriptionenligne where MassarEtudiant=?" ;
		   
			PreparedStatement ps=conn.prepareStatement(req);
			ps.setString(1,Massar);
		    ResultSet rs = ps.executeQuery();
		    rs.next();
		    System.out.println(rs.getString(1));
		    
		    String MassarEtdudiant=rs.getString(1);
		    String NomFr =rs.getString(2);
		    String NomAr =rs.getString(3);
		    String PrenomFr =rs.getString(4);
		    String PrenomAr=rs.getString(5);
		    String CIN=rs.getString(6);
		    String Nationalite=rs.getString(7);
		    String Sexe=rs.getString(8);
		   
		    Date DatedeNaissance = Date.valueOf(rs.getString(9));
		    String LieudeNaissanceFr=rs.getString(10);
		    String LieudeNaissanceAr=rs.getString(11);
		    String Ville=rs.getString(12);
		    String Province=rs.getString(13);
		    String AnnéedeBAC=rs.getString(14);
		    String SeriedeBAC=rs.getString(15);
		    String Mention=rs.getString(16);
		    String Lycee=rs.getString(17);
		    String LieudeBAC=rs.getString(18);
		    String Academie =rs.getString(19);
		    
		    Date DateInscription = Date.valueOf(rs.getString(20));
		    String Etablissement =rs.getString(21);
		    int Filiere=rs.getInt(22);
		System.out.println("valide");
		
		   
		    EtudiantInscrictionEnligne EtudiantInscription = new EtudiantInscrictionEnligne(MassarEtdudiant, NomFr, NomAr, PrenomAr, PrenomFr, CIN, Nationalite, Sexe, DatedeNaissance, LieudeNaissanceFr, LieudeNaissanceAr, Ville, Province, AnnéedeBAC, SeriedeBAC, Mention, Lycee, LieudeBAC, Academie, DateInscription, Etablissement,Filiere);
		    DAOdelib dao=new DAOdelib();
			dao.ValiderInscriptionEnligne(EtudiantInscription);



		   
	}
	catch(Exception e) {
		System.out.println(e.toString());
	}
	
	
}
}




package Classes;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;




public class EtudiantInscrictionEnligne {
	private String  MassarEtdudiant ;
	private String  NomFr ;
	private String NomAr;
	private String PrenomAr;
	private String PrenomFr ;
	private String CIN ;
	private String Nationalite ;
	private String Sexe ;
	private Date DatedeNaissance ;
	private String LieudeNaissanceFr ;
	private String  LieudeNaissanceAr ;
	private String Ville ,Province, AnneedeBAC,SeriedeBAC, Mention, Lycee, LieudeBAC, Academie ;
	private Date DateInscription;
	private String Etablissement ;
	private int Filiere ;
	

	
	
	public int getFiliere() {
		return Filiere;
	}
	public void setFiliere(int filiere) {
		 Filiere =filiere;
	}
	public String getMassarEtdudiant() {
		return MassarEtdudiant;
	}
	public void setMassarEtdudiant(String massarEtdudiant) {
		MassarEtdudiant = massarEtdudiant;
	}
	public String getNomFr() {
		return NomFr;
	}
	public void setNomFr(String nomFr) {
		NomFr = nomFr;
	}
	public String getNomAr() {
		return NomAr;
	}
	public void setNomAr(String nomAr) {
		NomAr = nomAr;
	}
	public String getPrenomAr() {
		return PrenomAr;
	}
	public void setPrenomAr(String prenomAr) {
		PrenomAr = prenomAr;
	}
	public String getPrenomFr() {
		return PrenomFr;
	}
	public void setPrenomFr(String prenomFr) {
		PrenomFr = prenomFr;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public String getNationalite() {
		return Nationalite;
	}
	public void setNationalite(String nationalite) {
		Nationalite = nationalite;
	}
	public String getSexe() {
		return Sexe;
	}
	public void setSexe(String sexe) {
		Sexe = sexe;
	}
	
	public String getLieudeNaissanceFr() {
		return LieudeNaissanceFr;
	}
	public void setLieudeNaissanceFr(String lieudeNaissanceFr) {
		LieudeNaissanceFr = lieudeNaissanceFr;
	}

	
	public String getLieudeNaissanceAr() {
		return LieudeNaissanceAr;
	}
	public void setLieudeNaissanceAr(String lieudeNaissanceAr) {
		LieudeNaissanceAr = lieudeNaissanceAr;
	}
	public String getVille() {
		return Ville;
	}
	public void setVille(String ville) {
		Ville = ville;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getAnnéedeBAC() {
		return AnneedeBAC;
	}
	public void setAnnéedeBAC(String annéedeBAC) {
		AnneedeBAC = annéedeBAC;
	}
	public String getSeriedeBAC() {
		return SeriedeBAC;
	}
	public void setSeriedeBAC(String seriedeBAC) {
		SeriedeBAC = seriedeBAC;
	}
	public String getMention() {
		return Mention;
	}
	public void setMention(String mention) {
		Mention = mention;
	}
	public String getLycee() {
		return Lycee;
	}
	public void setLycee(String lycee) {
		Lycee = lycee;
	}
	public String getLieudeBAC() {
		return LieudeBAC;
	}
	public void setLieudeBAC(String lieudeBAC) {
		LieudeBAC = lieudeBAC;
	}
	public String getAcademie() {
		return Academie;
	}
	public void setAcademie(String academie) {
		Academie = academie;
	}
	
	public String getEtablissement() {
		return Etablissement;
	}
	public void setEtablissement(String etablissement) {
		Etablissement = etablissement;
	}

	
	
	
public void InsertInscriptionEnligne() throws SQLException {

	try {
		
    Connection conn = SingletonConnection.getConnection();
	PreparedStatement ps;
    
    ps =conn.prepareStatement("insert into deliberationdb.etudiantinscriptionenligne values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
    
    ps.setString(1,this.MassarEtdudiant);
 
    ps.setString(2,this.NomFr);
    ps.setString(3,this.NomAr);
    ps.setString(4,this.PrenomFr);
    ps.setString(5,this.PrenomAr);
    ps.setString(6,this.CIN);
    ps.setString(7,this.Nationalite);
    ps.setString(8,this.Sexe);
    ps.setDate(9,this.DatedeNaissance);
    ps.setString(10,this.LieudeNaissanceFr);
    ps.setString(11,this.LieudeNaissanceAr);
    ps.setString(12,this.Ville);
    ps.setString(13,this.Province);
    ps.setString(14,this.AnneedeBAC);
    ps.setString(15,this.SeriedeBAC);
    ps.setString(16,this.Mention);
    ps.setString(17,this.Lycee);
    ps.setString(18,this.LieudeBAC);
    ps.setString(19,this.Academie);
    ps.setDate(20,this.DateInscription);
    ps.setString(21,this.Etablissement);
    ps.setInt(22,this.Filiere);
   
  
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
 

public EtudiantInscrictionEnligne() {
	super();
}
public Date getDatedeNaissance() {
	return DatedeNaissance;
}
public void setDatedeNaissance(Date datedeNaissance) {
	DatedeNaissance = datedeNaissance;
}
public Date getDateInscription() {
	return DateInscription;
}
public void setDateInscription(Date dateInscription) {
	DateInscription = dateInscription;
}
public EtudiantInscrictionEnligne(String massarEtdudiant, String nomFr, String nomAr, String prenomAr, String prenomFr,
		String cIN, String nationalite, String sexe, Date datedeNaissance, String lieudeNaissanceFr,
		String lieudeNaissanceAr, String ville, String province, String annéedeBAC, String seriedeBAC, String mention,
		String lycee, String lieudeBAC, String academie, Date dateInscription, String etablissement, int filiere) {
	super();
	MassarEtdudiant = massarEtdudiant;
	NomFr = nomFr;
	NomAr = nomAr;
	PrenomAr = prenomAr;
	PrenomFr = prenomFr;
	CIN = cIN;
	Nationalite = nationalite;
	Sexe = sexe;
	DatedeNaissance = datedeNaissance;
	LieudeNaissanceFr = lieudeNaissanceFr;
	LieudeNaissanceAr = lieudeNaissanceAr;
	Ville = ville;
	Province = province;
	AnneedeBAC = annéedeBAC;
	SeriedeBAC = seriedeBAC;
	Mention = mention;
	Lycee = lycee;
	LieudeBAC = lieudeBAC;
	Academie = academie;
	DateInscription = dateInscription;
	Etablissement = etablissement;
	Filiere = filiere;
}

	
	

}

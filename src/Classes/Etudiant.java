package Classes;

public class Etudiant {
	private String  MassarEtudiant ;
	private String  NomFr ;
	private String NomAr;
	private String PrenomAr;
	private String PrenomFr ;
	private String CIN ;
	private String Nationalite ;
	private String Sexe ;
	private String DatedeNaissance, LieudeNaissanceFr ;
	private String  LieudeNaissanceAr ;
	private String Ville ,Province, AnnéedeBAC,SeriedeBAC, Mention, Lycée, LieudeBAC, Académie ;
	private String DateInscription, Etablissement ;
	private String PasswordEtudiant ,UsernameEtu ;
	public Etudiant(String massarEtudiant, String nomFr, String nomAr, String prenomAr, String prenomFr, String cIN,
			String nationalite, String sexe, String datedeNaissance, String lieudeNaissanceFr, String lieudeNaissanceAr,
			String ville, String province, String annéedeBAC, String seriedeBAC, String mention, String lycée,
			String lieudeBAC, String académie, String dateInscription, String etablissement, String passwordEtudiant,
			String usernameEtu) {
		super();
		MassarEtudiant = massarEtudiant;
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
		AnnéedeBAC = annéedeBAC;
		SeriedeBAC = seriedeBAC;
		Mention = mention;
		Lycée = lycée;
		LieudeBAC = lieudeBAC;
		Académie = académie;
		DateInscription = dateInscription;
		Etablissement = etablissement;
		PasswordEtudiant = passwordEtudiant;
		UsernameEtu = usernameEtu;
	}
	public String getMassarEtudiant() {
		return MassarEtudiant;
	}
	public Etudiant() {
		super();
	}
	public void setMassarEtudiant(String massarEtudiant) {
		MassarEtudiant = massarEtudiant;
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
	public String getDatedeNaissance() {
		return DatedeNaissance;
	}
	public void setDatedeNaissance(String datedeNaissance) {
		DatedeNaissance = datedeNaissance;
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
		return AnnéedeBAC;
	}
	public void setAnnéedeBAC(String annéedeBAC) {
		AnnéedeBAC = annéedeBAC;
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
	public String getLycée() {
		return Lycée;
	}
	public void setLycée(String lycée) {
		Lycée = lycée;
	}
	public String getLieudeBAC() {
		return LieudeBAC;
	}
	public void setLieudeBAC(String lieudeBAC) {
		LieudeBAC = lieudeBAC;
	}
	public String getAcadémie() {
		return Académie;
	}
	public void setAcadémie(String académie) {
		Académie = académie;
	}
	public String getDateInscription() {
		return DateInscription;
	}
	public void setDateInscription(String dateInscription) {
		DateInscription = dateInscription;
	}
	public String getEtablissement() {
		return Etablissement;
	}
	public void setEtablissement(String etablissement) {
		Etablissement = etablissement;
	}
	public String getPasswordEtudiant() {
		return PasswordEtudiant;
	}
	public void setPasswordEtudiant(String passwordEtudiant) {
		PasswordEtudiant = passwordEtudiant;
	}
	public String getUsernameEtu() {
		return UsernameEtu;
	}
	public void setUsernameEtu(String usernameEtu) {
		UsernameEtu = usernameEtu;
	}
	public Etudiant( String usernameEtu,String passwordEtudiant) {
		super();
		UsernameEtu = usernameEtu;
		PasswordEtudiant = passwordEtudiant;
	
	}
}
	
	
	
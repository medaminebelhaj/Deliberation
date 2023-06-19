package Classes;

import java.sql.Date;


public class EtudiantInscrit extends EtudiantInscrictionEnligne {

String username;
	public EtudiantInscrit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EtudiantInscrit(String massarEtdudiant, String nomFr, String nomAr, String prenomAr,
			String prenomFr, String cIN, String nationalite, String sexe, Date datedeNaissance,
			String lieudeNaissanceFr, String lieudeNaissanceAr, String ville, String province, String annéedeBAC,
			String seriedeBAC, String mention, String lycee, String lieudeBAC, String academie, Date dateInscription,
			String etablissement, int filiere,String usernameEtu) {
		super(massarEtdudiant, nomFr, nomAr, prenomAr, prenomFr, cIN, nationalite, sexe, datedeNaissance, lieudeNaissanceFr,
				lieudeNaissanceAr, ville, province, annéedeBAC, seriedeBAC, mention, lycee, lieudeBAC, academie,
				dateInscription, etablissement, filiere);
		usernameEtu=username;
	
		
	}
	public EtudiantInscrit(String massarEtdudiant, String nomFr, String nomAr, String prenomAr,
			String prenomFr, String cIN, String nationalite, String sexe, Date datedeNaissance,
			String lieudeNaissanceFr, String lieudeNaissanceAr, String ville, String province, String annéedeBAC,
			String seriedeBAC, String mention, String lycee, String lieudeBAC, String academie, Date dateInscription,
			String etablissement, int filiere) {
		super(massarEtdudiant, nomFr, nomAr, prenomAr, prenomFr, cIN, nationalite, sexe, datedeNaissance, lieudeNaissanceFr,
				lieudeNaissanceAr, ville, province, annéedeBAC, seriedeBAC, mention, lycee, lieudeBAC, academie,
				dateInscription, etablissement, filiere);
	
	
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


}


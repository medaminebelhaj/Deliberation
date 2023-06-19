package Classes;

import java.sql.Date;

public class EtudiantInscriptionAdministrative extends EtudiantInscrictionEnligne {
	

	public EtudiantInscriptionAdministrative() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EtudiantInscriptionAdministrative(String massarEtdudiant, String nomFr, String nomAr, String prenomAr,
			String prenomFr, String cIN, String nationalite, String sexe, Date datedeNaissance,
			String lieudeNaissanceFr, String lieudeNaissanceAr, String ville, String province, String annéedeBAC,
			String seriedeBAC, String mention, String lycee, String lieudeBAC, String academie, Date dateInscription,
			String etablissement, int filiere) {
		super(massarEtdudiant, nomFr, nomAr, prenomAr, prenomFr, cIN, nationalite, sexe, datedeNaissance, lieudeNaissanceFr,
				lieudeNaissanceAr, ville, province, annéedeBAC, seriedeBAC, mention, lycee, lieudeBAC, academie,
				dateInscription, etablissement, filiere);
	
		
	}


}

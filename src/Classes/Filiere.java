package Classes;

public class Filiere {
	private int IdFiliere;
	private String RespoFiliere,NomFiliere;
	public int getIdFiliere() {
		return IdFiliere;
	}
	public void setIdFiliere(int idFiliere) {
		IdFiliere = idFiliere;
	}
	public String getRespoFiliere() {
		return RespoFiliere;
	}
	public void setRespoFiliere(String respoFiliere) {
		RespoFiliere = respoFiliere;
	}
	public String getNomFiliere() {
		return NomFiliere;
	}
	public void setNomFiliere(String nomFiliere) {
		NomFiliere = nomFiliere;
	}
	public Filiere() {
		super();
	}
	public Filiere(int idFiliere, String nomFiliere) {
		super();
		IdFiliere = idFiliere;
		NomFiliere = nomFiliere;
	}
	public Filiere(int idFiliere, String respoFiliere, String nomFiliere) {
		super();
		IdFiliere = idFiliere;
		RespoFiliere = respoFiliere;
		NomFiliere = nomFiliere;
	}
	public Filiere(String nomFiliere) {
		super();
		NomFiliere = nomFiliere;
	}
	
	

}

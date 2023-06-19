package Classes;

public class Enseignant {
	private String EmailEnseignant ,NomEnseignant,PrenomEnseignant,UsernameEnseignant;
	private int IdEnseignant,IdFiliere;
	private String PasswordEnseignant,RoleEnseignant;
	public String getEmailEnseignant() {
		return EmailEnseignant;
	}
	public Enseignant(String emailEnseignant, String nomEnseignant, String prenomEnseignant, String usernameEnseignant,
			int idEnseignant, int idFiliere, String passwordEnseignant) {
		super();
		EmailEnseignant = emailEnseignant;
		NomEnseignant = nomEnseignant;
		PrenomEnseignant = prenomEnseignant;
		UsernameEnseignant = usernameEnseignant;
		IdEnseignant = idEnseignant;
		IdFiliere = idFiliere;
		PasswordEnseignant = passwordEnseignant;
	}
	public void setEmailEnseignant(String emailEnseignant) {
		EmailEnseignant = emailEnseignant;
	}
	public String getNomEnseignant() {
		return NomEnseignant;
	}
	public void setNomEnseignant(String nomEnseignant) {
		NomEnseignant = nomEnseignant;
	}
	public String getPrenomEnseignant() {
		return PrenomEnseignant;
	}
	public void setPrenomEnseignant(String prenomEnseignant) {
		PrenomEnseignant = prenomEnseignant;
	}
	public String getUsernameEnseignant() {
		return UsernameEnseignant;
	}
	public void setUsernameEnseignant(String usernameEnseignant) {
		UsernameEnseignant = usernameEnseignant;
	}
	public int getIdEnseignant() {
		return IdEnseignant;
	}
	public void setIdEnseignant(int idEnseignant) {
		IdEnseignant = idEnseignant;
	}
	public int getIdFiliere() {
		return IdFiliere;
	}
	public void setIdFiliere(int idFiliere) {
		IdFiliere = idFiliere;
	}
	public String getPasswordEnseignant() {
		return PasswordEnseignant;
	}
	public void setPasswordEnseignant(String passwordEnseignant) {
		PasswordEnseignant = passwordEnseignant;
	}
	public String getRoleEnseignant() {
		return RoleEnseignant;
	}
	public void setRoleEnseignant(String roleEnseignant) {
		RoleEnseignant = roleEnseignant;
	}
	public Enseignant(String emailEnseignant, String nomEnseignant, String prenomEnseignant, String usernameEnseignant,
			int idEnseignant, int idFiliere, String passwordEnseignant, String roleEnseignant) {
		super();
		EmailEnseignant = emailEnseignant;
		NomEnseignant = nomEnseignant;
		PrenomEnseignant = prenomEnseignant;
		UsernameEnseignant = usernameEnseignant;
		IdEnseignant = idEnseignant;
		IdFiliere = idFiliere;
		PasswordEnseignant = passwordEnseignant;
		RoleEnseignant = roleEnseignant;
	}
	public Enseignant(String emailEnseignant, String nomEnseignant, String prenomEnseignant, String usernameEnseignant,
			int idFiliere, String passwordEnseignant, String roleEnseignant) {
		super();
		EmailEnseignant = emailEnseignant;
		NomEnseignant = nomEnseignant;
		PrenomEnseignant = prenomEnseignant;
		UsernameEnseignant = usernameEnseignant;
		IdFiliere = idFiliere;
		PasswordEnseignant = passwordEnseignant;
		RoleEnseignant = roleEnseignant;
	}
	public Enseignant() {
		super();
	}
}
	
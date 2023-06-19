package Classes;

public class User {
	String nom;
	int idUser;
	String prenom;
	String username;
	String password;
	String Role;
	String Email;
	public User(String nom, int idUser, String prenom, String username, String password, String role, String email) {
		super();
		this.nom = nom;
		this.idUser = idUser;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		Role = role;
		Email = email;
	}
	public User(String nom, String prenom, String username, String password, String role, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		Role = role;
		Email = email;
	}
	public User() {
		super();
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Override
	public String toString() {
		return "User [nom=" + nom + ", idUser=" + idUser + ", prenom=" + prenom + ", username=" + username
				+ ", password=" + password + ", Role=" + Role + ", Email=" + Email + "]";
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

}
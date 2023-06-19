package Classes;

public class Etape {
    @Override
	public String toString() {
		return "[" + IdEtape + ", " + NmEtape + " ," + Diplomante + ","
				+ idFiliere_FK + "]";
	}
	private int IdEtape;
   private String NmEtape;
   private boolean Diplomante;
   private int idFiliere_FK;
public Etape() {
	super();
}
public Etape(String nmEtape, boolean diplomante, int iDFiliere_FK) {
	super();
	NmEtape = nmEtape;
	Diplomante = diplomante;
	idFiliere_FK = iDFiliere_FK;
}
public Etape(int idEtape, String nmEtape, boolean diplomante, int iDFiliere_FK) {
	super();
	IdEtape = idEtape;
	NmEtape = nmEtape;
	Diplomante = diplomante;
	idFiliere_FK = iDFiliere_FK;
}
public int getIdEtape() {
	return IdEtape;
}
public void setIdEtape(int idEtape) {
	IdEtape = idEtape;
}
public String getNmEtape() {
	return NmEtape;
}
public void setNmEtape(String nmEtape) {
	NmEtape = nmEtape;
}
public boolean isDiplomante() {
	return Diplomante;
}
public void setDiplomante(boolean diplomante) {
	Diplomante = diplomante;
}
public int getidFiliere_FK() {
	return idFiliere_FK;
}
public void setidFiliere_FK(int idfiliere_FK) {
	idFiliere_FK = idfiliere_FK;
}

}

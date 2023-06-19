package Classes;

public class Semestre {
	private String NmSemestre ;
	private int idSemestre ,idEtape_FK ;
	private float NoteValidation ;
	
	public Semestre(String nmSemestre, int idEtape_FK, float noteValidation) {
		super();
		NmSemestre = nmSemestre;
		this.idEtape_FK = idEtape_FK;
		NoteValidation = noteValidation;
	}
	public String getNmSemestre() {
		return NmSemestre;
	}
	public void setNmSemestre(String nmSemestre) {
		NmSemestre = nmSemestre;
	}
	public int getIdSemestre() {
		return idSemestre;
	}
	public void setIdSemestre(int idSemestre) {
		this.idSemestre = idSemestre;
	}
	public int getIdEtape_FK() {
		return idEtape_FK;
	}
	public void setIdEtape_FK(int idEtape_FK) {
		this.idEtape_FK = idEtape_FK;
	}
	public float getNoteValidation() {
		return NoteValidation;
	}
	public void setNoteValidation(float noteValidation) {
		NoteValidation = noteValidation;
	}
	public Semestre(String nmSemestre, int idSemestre, int idEtape_FK, float noteValidation) {
		super();
		NmSemestre = nmSemestre;
		this.idSemestre = idSemestre;
		this.idEtape_FK = idEtape_FK;
		NoteValidation = noteValidation;
	}
	
	@Override
	public String toString() {
		return "[" + NmSemestre + "," + idSemestre + "," + idEtape_FK
				+ "," + NoteValidation + "]";
	}

	
}
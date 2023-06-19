package Classes;

public class InscriptionParElement {
	
	double NoteTp,NoteExam,NoteCC,CNoteTp,CNoteCC,CNoteExam;
	String MassarEtudiant;
	int idElement ,idModule;
	public InscriptionParElement(double noteTp, double noteExam, double noteCC, double cNoteTp, double cNoteCC,
			double cNoteExam, String massarEtudiant, int idElement, int idModule) {
		super();
		NoteTp = noteTp;
		NoteExam = noteExam;
		NoteCC = noteCC;
		CNoteTp = cNoteTp;
		CNoteCC = cNoteCC;
		CNoteExam = cNoteExam;
		MassarEtudiant = massarEtudiant;
		this.idElement = idElement;
		this.idModule = idModule;
	}
	public double getNoteTp() {
		return NoteTp;
	}
	public void setNoteTp(double noteTp) {
		NoteTp = noteTp;
	}
	public double getNoteExam() {
		return NoteExam;
	}
	public void setNoteExam(double noteExam) {
		NoteExam = noteExam;
	}
	public double getNoteCC() {
		return NoteCC;
	}
	public void setNoteCC(double noteCC) {
		NoteCC = noteCC;
	}
	public double getCNoteTp() {
		return CNoteTp;
	}
	public void setCNoteTp(double cNoteTp) {
		CNoteTp = cNoteTp;
	}
	public double getCNoteCC() {
		return CNoteCC;
	}
	public void setCNoteCC(double cNoteCC) {
		CNoteCC = cNoteCC;
	}
	public double getCNoteExam() {
		return CNoteExam;
	}
	public void setCNoteExam(double cNoteExam) {
		CNoteExam = cNoteExam;
	}
	public String getMassarEtudiant() {
		return MassarEtudiant;
	}
	public void setMassarEtudiant(String massarEtudiant) {
		MassarEtudiant = massarEtudiant;
	}
	public int getIdElement() {
		return idElement;
	}
	public void setIdElement(int idElement) {
		this.idElement = idElement;
	}
	public int getIdModule() {
		return idModule;
	}
	public void setIdModule(int idModule) {
		this.idModule = idModule;
	}
	public InscriptionParElement(double noteTp, double noteExam, double noteCC, String massarEtudiant, int idElement,
			int idModule) {
		super();
		NoteTp = noteTp;
		NoteExam = noteExam;
		NoteCC = noteCC;
		MassarEtudiant = massarEtudiant;
		this.idElement = idElement;
		this.idModule = idModule;
	}
	public InscriptionParElement() {
		super();
	}
	

	}



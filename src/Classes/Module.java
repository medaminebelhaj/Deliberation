package Classes;

public class Module {

	public int getIdEns() {
		return IdEns;
	}
	public void setIdEns(int idEns) {
		IdEns = idEns;
	}

	private float CoifficiantModule;
	private float NoteEliminatiore, NoteValidation;
	private int IdModule,IdEtape,IdSemestre,IdEns;
	private String LabelleModule, NomModule;

	public Module(float coifficiantModule, float noteEliminatiore, float noteValidation, int idModule, int idEtape,
			int idSemestre, String labelleModule, String nomModule) {
		super();
		CoifficiantModule = coifficiantModule;
		NoteEliminatiore = noteEliminatiore;
		NoteValidation = noteValidation;
		IdModule = idModule;
		IdEtape = idEtape;
		IdSemestre = idSemestre;
		LabelleModule = labelleModule;
		NomModule = nomModule;
	}
	public Module(float coifficiantModule, float noteEliminatiore, float noteValidation, int idEtape, int idSemestre,
			String labelleModule, String nomModule) {
		super();
		CoifficiantModule = coifficiantModule;
		NoteEliminatiore = noteEliminatiore;
		NoteValidation = noteValidation;
		IdEtape = idEtape;
		IdSemestre = idSemestre;
		LabelleModule = labelleModule;
		NomModule = nomModule;
	}
	
	public Module(float coifficiantModule, float noteEliminatiore, float noteValidation, int idEtape, int idSemestre,
			String nomModule) {
		super();
		CoifficiantModule = coifficiantModule;
		NoteEliminatiore = noteEliminatiore;
		NoteValidation = noteValidation;
		IdEtape = idEtape;
		IdSemestre = idSemestre;
		NomModule = nomModule;
	}
	public Module() {
		super();
	}
	public Module(int idEtape2, int idsemestre2, String nmSemestre, float noteValidation2, float noteElimi,
			int coifficientModule ,int idens) {
		IdEtape = idEtape2;
		IdSemestre = idsemestre2;
		NomModule = nmSemestre;
		CoifficiantModule = coifficientModule;
		NoteEliminatiore = noteElimi;
		NoteValidation = noteValidation2;
		IdEns=idens;
		
		
		
	}
	public float getCoifficiantModule() {
		return CoifficiantModule;
	}
	public void setCoifficiantModule(int coifficiantModule) {
		CoifficiantModule = coifficiantModule;
	}
	public float getNoteEliminatiore() {
		return NoteEliminatiore;
	}
	public void setNoteEliminatiore(float noteEliminatiore) {
		NoteEliminatiore = noteEliminatiore;
	}
	public float getNoteValidation() {
		return NoteValidation;
	}
	public void setNoteValidation(float noteValidation) {
		NoteValidation = noteValidation;
	}
	public int getIdModule() {
		return IdModule;
	}
	public void setIdModule(int idModule) {
		IdModule = idModule;
	}
	public int getIdEtape() {
		return IdEtape;
	}
	public void setIdEtape(int idEtape) {
		IdEtape = idEtape;
	}
	public int getIdSemestre() {
		return IdSemestre;
	}
	public void setIdSemestre(int idSemestre) {
		IdSemestre = idSemestre;
	}
	public String getLabelleModule() {
		return LabelleModule;
	}
	public void setLabelleModule(String labelleModule) {
		LabelleModule = labelleModule;
	}
	public String getNomModule() {
		return NomModule;
	}
	public void setNomModule(String nomModule) {
		NomModule = nomModule;
	}

	public String toString() {
		return "[" + NomModule + "," + IdModule +"," + CoifficiantModule +"," + NoteEliminatiore+"," + NoteValidation+"]";
	}
}

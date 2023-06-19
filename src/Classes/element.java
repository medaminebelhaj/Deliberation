package Classes;

public class element {
   int idelement;
   String nomElement;
   int idmodule,CorficientElement,idensei;
   
   public element() {
	super();
}

public element(int idelement, String nomElement, int idmodule, int corficientElement, int idensei,
		Float noteEliminatioreElement, Float noteValidationElement) {
	super();
	this.idelement = idelement;
	this.nomElement = nomElement;
	this.idmodule = idmodule;
	CorficientElement = corficientElement;
	this.idensei = idensei;
	NoteEliminatioreElement = noteEliminatioreElement;
	NoteValidationElement = noteValidationElement;
}

public int getIdensei() {
	return idensei;
}

public void setIdensei(int idensei) {
	this.idensei = idensei;
}
Float NoteEliminatioreElement,NoteValidationElement;
 
   


public int getCorficientElement() {
	return CorficientElement;
}

public void setCorficientElement(int corficientElement) {
	CorficientElement = corficientElement;
}

public Float getNoteEliminatioreElement() {
	return NoteEliminatioreElement;
}

public void setNoteEliminatioreElement(Float noteEliminatioreElement) {
	NoteEliminatioreElement = noteEliminatioreElement;
}

public Float getNoteValidationElement() {
	return NoteValidationElement;
}

public void setNoteValidationElement(Float noteValidationElement) {
	NoteValidationElement = noteValidationElement;
}

public element(int idelement, String nomElement, int idmodule) {
	super();
	this.idelement = idelement;
	this.nomElement = nomElement;
	this.idmodule = idmodule;
}

public String toString() {
	return "[" + idelement + "," + nomElement + ","+idmodule+"]";
}
public int getIdelement() {
	return idelement;
}
public void setIdelement(int idelement) {
	this.idelement = idelement;
}
public String getNomElement() {
	return nomElement;
}
public void setNomElement(String nomElement) {
	this.nomElement = nomElement;
}
public int getIdmodule() {
	return idmodule;
}
public void setIdmodule(int idmodule) {
	this.idmodule = idmodule;
}
public String toString1() {
	return "[" + nomElement + "," + idelement +"," + CorficientElement +"," + NoteEliminatioreElement+"," + NoteValidationElement+"]";
}
}

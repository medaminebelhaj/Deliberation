package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classes.Module;
import Classes.element;
import DAO.DaoGestionElement;
import DAO.DaoGestionModule;

/**
 * Servlet implementation class listElement1
 */
@WebServlet("/listElement1")
public class listElement1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listElement1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/listElement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.equals("add")) {
			int idEtape = Integer.parseInt(request.getParameter("idmoduleFK"));
			int idsemestre = Integer.parseInt(request.getParameter("idSemestre_FK"));
			String NmSemestre = request.getParameter("NomElement");
			float NoteValidation = Float.parseFloat(request.getParameter("NoteValidationElement"));
			float NoteElimi = Float.parseFloat(request.getParameter("NoteEliminatioreElement"));
			int CoifficientModule = Integer.parseInt(request.getParameter("CorficientElement"));
			int idEns =Integer.parseInt(request.getParameter("idenseignant"));
			
			DaoGestionElement daoo = new DaoGestionElement();
		   element e = new element();
		   e.setCorficientElement(CoifficientModule);
		  e.setIdensei(idEns);
		  e.setIdmodule(idEtape);
		  e.setNomElement(NmSemestre);
		  e.setNoteEliminatioreElement(NoteElimi);
		  e.setNoteValidationElement(NoteValidation);
		  daoo.AddElement(e);
		  
			
			
	}
		request.getRequestDispatcher("WEB-INF/listModule.jsp").forward(request, response);
		
}
}
package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DaoGestionElement;
import DAO.DaoNotes;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.getRequestDispatcher("/WEB-INF/ExportNote.jsp").forward(request,
   			//  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoNotes dao = new DaoNotes();
		DaoGestionElement d= new DaoGestionElement();
		int idModule = Integer.parseInt(request.getParameter("idModule1"));
		int idElement = Integer.parseInt(request.getParameter("idElement1"));
		double CduTp = Double.parseDouble(request.getParameter("CduTp"));
		double CduCC = Double.parseDouble(request.getParameter("CduCC"));
		double CduExam = Double.parseDouble(request.getParameter("CduExam"));
    String[]NoteTpS=request.getParameterValues("NoteTp");
		/*
		 * double[]NoteTp = new double[NoteTpS.length]; for (int i = 0;
		 * i<NoteTpS.length; i++) NoteTp[i] = Double.parseDouble(NoteTpS[i]);
		 */
    String[]NoteCCS=request.getParameterValues("NoteCC");
		/*
		 * double[]NoteCC = new double[NoteCCS.length]; for (int i = 0;
		 * i<NoteCCS.length; i++) NoteCC[i] = Double.parseDouble(NoteCCS[i]);
		 */
    String[]NoteExamS=request.getParameterValues("NoteEx");
		/*
		 * double[]NoteExam = new double[NoteCC.length]; for (int i = 0;
		 * i<NoteExamS.length; i++) NoteExam[i] = Double.parseDouble(NoteExamS[i]);
		 */
    System.out.println(request.getParameter("idElement1"));
    String[]MassarEtudiant=request.getParameterValues("MassarEtudiant");

    for(int i =0;i<NoteTpS.length;i++) {
    	
    	
    	String  MassarEt= MassarEtudiant[i];
    	double NoteCC1,NoteEx1,NoteTp1;
    	
         NoteTp1 =Double.parseDouble(NoteTpS[i]);
    	 NoteCC1 =Double.parseDouble(NoteCCS[i]);
    	 NoteEx1 =Double.parseDouble(NoteExamS[i]);
    	 double NoteTotal =((NoteTp1*CduTp)+(NoteCC1*CduCC)+(NoteEx1*CduExam));
    	 
    	 
    	 System.out.println("insert ligne :massar="+MassarEt);
    	 System.out.println("insert ligne :Element="+idElement);
    	 System.out.println("insert ligne :Module="+idModule);
    	 System.out.println("insert ligne :note1="+NoteTp1);
    	 System.out.println("insert ligne :note1="+NoteCC1);
    	 System.out.println("insert ligne :note1="+NoteEx1);
    	 dao.UpdateNote(idElement, idModule, MassarEt, NoteTp1, NoteCC1, NoteEx1,NoteTotal);
    	String a = d.getNameElementById(idElement);
    	HttpSession session = request.getSession();
    	session.setAttribute("AAAA", a);
    	session.setAttribute("ide", idElement);
        // doGet(request, response); 
    	 
    	
    	}
    response.sendRedirect("ExportNote"); 
    	
    }
 
    
    
    
	

}

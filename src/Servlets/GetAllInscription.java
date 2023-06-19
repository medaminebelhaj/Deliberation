package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DaoGestionUsers;
import DAO.DaoInscriptionEnligne;

/**
 * Servlet implementation class GetAllInscription
 */
@WebServlet("/GetAllInscription")
public class GetAllInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllInscription() {
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		  try { 
			 String action =request.getParameter("action"); 
			 String MassarEtudiant =request.getParameter("id"); 
			 switch(action) { 
	  case "valide" :
	   
				  DaoInscriptionEnligne d = new DaoInscriptionEnligne();
					 MassarEtudiant = request.getParameter("id");
					 
					 d.valideInscriptionEnligne(MassarEtudiant);
					 d.deleteInscriptionEnligne(MassarEtudiant);
					  request.getRequestDispatcher("/WEB-INF/listInscriptionEnligne.jsp").forward(request,response);
					break;
		case "list":
		  
		  request.getRequestDispatcher("/WEB-INF/listInscriptionEnligne.jsp").forward(request,
		  response); break;
		  
		  case "delete": 
			  System.out.println("AAAAAAAAAA");
			  DaoInscriptionEnligne dao = new DaoInscriptionEnligne();
		  dao.deleteInscriptionEnligne(MassarEtudiant);
		  request.getRequestDispatcher("/WEB-INF/listInscriptionEnligne.jsp").forward(request,response)
		  
		  ; break; 
		
		  
		  } } 
		  
		  catch (Exception e) {
		 



	request.getRequestDispatcher("/WEB-INF/listInscriptionEnligne.jsp").forward(request,response);

	}}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

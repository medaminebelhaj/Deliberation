package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classes.EtudiantInscriptionAdministrative;

import DAO.DaoInscriptionAdministrative;
import DAO.DaoInscriptionEnligne;

/**
 * Servlet implementation class InscriptionAdmServlet
 */
@WebServlet("/InscriptionAdmServlet")
public class InscriptionAdmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionAdmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try { 
			 String action =request.getParameter("action"); 
			 String MassarEtudiant =request.getParameter("id"); 
			 switch(action) { 
	  case "valide" :
	               
				  DaoInscriptionAdministrative d = new DaoInscriptionAdministrative();
					 MassarEtudiant = request.getParameter("id");
					 
					 d.valideInscriptionEnligneValide(MassarEtudiant);
					 d.valideUser(MassarEtudiant);
					 d.deleteInscriptionEnligne(MassarEtudiant);
					  request.getRequestDispatcher("/WEB-INF/ManageInscriptionAdministrative.jsp").forward(request,response);
					break;
		case "list":
		  
		  request.getRequestDispatcher("/WEB-INF/ManageInscriptionAdministrative.jsp").forward(request,
		  response); break;
		  
		  case "delete": 
			;
			DaoInscriptionAdministrative dao = new DaoInscriptionAdministrative();
		  dao.deleteInscriptionEnligne(MassarEtudiant);
		  request.getRequestDispatcher("/WEB-INF/ManageInscriptionAdministrative.jsp").forward(request,response)
		  
		  ; break; 
		
		  
		  } } 
		  
		  catch (Exception e) {
		 



	request.getRequestDispatcher("/WEB-INF/ManageInscriptionAdministrative.jsp").forward(request,response);

	}}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classes.Enseignant;
import Classes.EtudiantInscrictionEnligne;
import Classes.Filiere;
import Classes.SingletonConnection;
import DAO.DAOdelib;
import DAO.DaoGestionEnseignant;
import DAO.DaoGestionFiliere;

/**
 * Servlet implementation class listFiliere
 */
@WebServlet("/listFiliere")
public class listFiliere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listFiliere() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SingletonConnection conn =new SingletonConnection();
		
		try {
		String action =request.getParameter("action");
		int idFiliere = Integer.parseInt(request.getParameter("id"));
		
		
		switch(action) {
		case "list":
			
			request.getRequestDispatcher("WEB-INF/listFiliere.jsp").forward(request, response);
			break;
			
		case "delete":
	   DaoGestionFiliere dao = new DaoGestionFiliere();
	   dao.DeleteFiliere(idFiliere);
			request.getRequestDispatcher("WEB-INF/listFiliere.jsp").forward(request, response);
			break;
		}
		}
		catch (Exception e) {
			request.getRequestDispatcher("WEB-INF/listFiliere.jsp").forward(request, response);
		}
		
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		
		String Oper = request.getParameter("op");
		switch(Oper) {
		case "update":
			DaoGestionEnseignant dao = new DaoGestionEnseignant();
			int idFiliere = Integer.parseInt(request.getParameter("idFiliere"));
			
			String NomFiliere = request.getParameter("NomFiliere");
			int RespoFiliere = Integer.parseInt(request.getParameter("RespoFiliere"));
			Enseignant e =dao.getEnseignantById(RespoFiliere);
			DaoGestionFiliere  dao1 = new DaoGestionFiliere () ;
			String Filiere =dao1.getNameFiliereById(idFiliere);
			String NomComplet =e.getPrenomEnseignant()+" "+e.getNomEnseignant();
			
			dao1.UpdateFiliere(idFiliere, NomFiliere,NomComplet);
			dao.UpdateRole(e.getIdEnseignant(), Filiere);
			request.getRequestDispatcher("WEB-INF/listFiliere.jsp").forward(request, response);
			break;
			
		case "add":
			
			String NomFiliere1 = request.getParameter("NomFiliere");
			Filiere f = new Filiere(NomFiliere1);
			DaoGestionFiliere dao2 = new DaoGestionFiliere();
			dao2.AddFiliere(f);
			request.getRequestDispatcher("WEB-INF/listFiliere.jsp").forward(request, response);
			break;
		}
		}
		
		catch (Exception e) {
			request.getRequestDispatcher("WEB-INF/listFiliere.jsp").forward(request, response);
		}
		
		
	
	}

}

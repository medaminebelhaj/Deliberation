package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Classes.Enseignant;
import DAO.DaoGestionEnseignant;
import DAO.DaoGestionFiliere;

/**
 * Servlet implementation class MyAccountEns
 */
@WebServlet("/MyAccountEns")
public class MyAccountEns extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyAccountEns() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username =request.getParameter("username");
		DaoGestionEnseignant dao =new DaoGestionEnseignant();
	    DaoGestionFiliere dao1 = new DaoGestionFiliere();
	  
		Enseignant e =dao.getEnseignantByUsername(username);
		String FiliereName=dao1.getNameFiliereById(e.getIdEnseignant());
		HttpSession session = request.getSession();
		
		session.setAttribute("prenomEns", e.getPrenomEnseignant());
		session.setAttribute("usernameEns", e.getUsernameEnseignant());
		session.setAttribute("emailEns", e.getEmailEnseignant());
		session.setAttribute("roleEns", e.getRoleEnseignant());
		session.setAttribute("id", e.getIdEnseignant());
		
		session.setAttribute("Filiere",FiliereName);
		session.setAttribute("idFiliere", e.getIdFiliere());
		request.getRequestDispatcher("WEB-INF/MyAccountEns.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

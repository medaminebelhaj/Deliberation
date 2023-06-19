package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DaoGestionFiliere;

/**
 * Servlet implementation class InscriptionPeda
 */
@WebServlet("/InscriptionPeda")
public class InscriptionPeda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionPeda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  request.getRequestDispatcher("WEB-INF/InscriptionPeda.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoGestionFiliere dao = new  DaoGestionFiliere();
		HttpSession session = request.getSession();
		String MassarEtudiant = request.getParameter("MassarEtudiant");
		String NomFr = request.getParameter("NomFr");
		String PrenomFr = request.getParameter("PrenomFr");
		String AnneUni = request.getParameter("AnneUni");
		session.setAttribute("AnneUni", AnneUni);
		String Mention = request.getParameter("Mention");
		String SeriedeBac= request.getParameter("SeriedeBac");
		String DateInscription = request.getParameter("DateInscription");
		int Filiere = Integer.parseInt(request.getParameter("Filiere"));

		session.setAttribute("idFiliere", request.getParameter("Filiere"));
		session.setAttribute("massaeretudiant", MassarEtudiant);
		
		System.out.println(MassarEtudiant);
		System.out.println(NomFr);
		System.out.println(PrenomFr);
		System.out.println(Mention);
		System.out.println(SeriedeBac);
		System.out.println(DateInscription);
		System.out.println(Filiere);
		session.setAttribute("NomFr", request.getParameter("NomFr"));
		session.setAttribute("PrenomFr", request.getParameter("PrenomFr"));
		session.setAttribute("Mention", request.getParameter("Mention"));
		session.setAttribute("SeriedeBac", request.getParameter("SeriedeBac"));
		session.setAttribute("DateInscription", request.getParameter("DateInscription"));
		session.setAttribute("png", ".png");
		String NomFiliere = dao.getNameFiliereById(Filiere);
		session.setAttribute("NomFiliere",NomFiliere);
		 request.getRequestDispatcher("InscriptionPeda2").forward(request,response);
	}

}

package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classes.Enseignant;
import Classes.User;
import DAO.DaoGestionEnseignant;
import DAO.DaoGestionSemestre;
import DAO.DaoGestionUsers;

/**
 * Servlet implementation class listEtudiant
 */
@WebServlet("/listEnseignant")
public class listEnseignant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listEnseignant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  try { 
			 String action =request.getParameter("action"); 
			 int idUser =Integer.parseInt(request.getParameter("id")); 
			 switch(action) { 
		case "list":
		  
		  request.getRequestDispatcher("WEB-INF/listEnseignant.jsp").forward(request,
		  response); break;
		  
		  case "delete": DaoGestionEnseignant dao = new DaoGestionEnseignant();
		  dao.DeleteEnseignant(idUser);
		  request.getRequestDispatcher("WEB-INF/listEnseignant.jsp").forward(request,
		  response)
		  
		  ; break; 
		  
		  } } 
		  
		  catch (Exception e) {
		 

System.out.println(e.toString());

	request.getRequestDispatcher("/WEB-INF/listEnseignant.jsp").forward(request,response);

	}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try{
		String Oper = request.getParameter("op");
		System.out.println(Oper);
		switch (Oper) {

		case "update":
			
			int idenseignant = Integer.parseInt(request.getParameter("idenseignant"));
			String nomEnseignant = request.getParameter("NomEnseignant");
			String PrenomEnseignant = request.getParameter("PrenomEnseignant");
			String EmailEnseignant = request.getParameter("EmailNomEnseignant");
            int idfiliere= Integer.parseInt(request.getParameter("idFiliere"));
			String UsernameEnseignant = request.getParameter("UsernameEnseignant");
			


			DaoGestionEnseignant dao2 = new DaoGestionEnseignant();
			dao2.UpdateUser(nomEnseignant, PrenomEnseignant,idfiliere, EmailEnseignant, UsernameEnseignant, idenseignant);
			;
			request.getRequestDispatcher("WEB-INF/listEnseignant.jsp").forward(request, response);
			break;
		case "add":

		
			String nomEnseignant1 = request.getParameter("NomEnseignant");
			String PrenomEnseignant1 = request.getParameter("PrenomEnseignant");
			String EmailEnseignant1 = request.getParameter("EmailEnseignant");
            int idfiliere1= Integer.parseInt(request.getParameter("idFiliere"));
			String UsernameEnseignant1 = request.getParameter("UsernameEnseignant");
			String RoleEnseignant1="Enseignant";
			int index = EmailEnseignant1.indexOf('@');
			String PasswordEnseignant = EmailEnseignant1.substring(0, index);

            
			Enseignant e = new Enseignant(EmailEnseignant1, nomEnseignant1, PrenomEnseignant1, UsernameEnseignant1, idfiliere1, PasswordEnseignant,RoleEnseignant1);
			  User u = new User();
			   u.setNom(nomEnseignant1);
			   u.setPrenom(PrenomEnseignant1);
			   u.setPassword("User11");
			   u.setRole("enseignant");
			   u.setUsername(UsernameEnseignant1.toLowerCase());
			    DaoGestionUsers daooo = new DaoGestionUsers();
			    daooo.AddUser(u);
			DaoGestionEnseignant dao1 = new DaoGestionEnseignant();
			dao1.AddUser(e);
			request.getRequestDispatcher("WEB-INF/listEnseignant.jsp").forward(request, response);
			break;
			
		}
	}
	catch (Exception e) {
		System.out.println(e.toString());
		request.getRequestDispatcher("WEB-INF/listUserjsp").forward(request, response);
	}
}
}

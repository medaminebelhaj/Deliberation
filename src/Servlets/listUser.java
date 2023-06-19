package Servlets;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Classes.Filiere;
import Classes.News;
import Classes.User;
import DAO.DaoGestionEtape;
import DAO.DaoGestionFiliere;
import DAO.DaoGestionUsers;
import DAO.DaoNews;

/**
 * Servlet implementation class listUser
 */
@WebServlet("/listUser")
public class listUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public listUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		  try { 
			 String action =request.getParameter("action"); 
			 int idUser =Integer.parseInt(request.getParameter("id")); 
			 switch(action) { 
		case "list":
		  
		  request.getRequestDispatcher("WEB-INF/listUser.jsp").forward(request,
		  response); break;
		  
		  case "delete": DaoGestionUsers dao = new DaoGestionUsers();
		  dao.DeleteUser(idUser);
		  request.getRequestDispatcher("WEB-INF/listUser.jsp").forward(request,
		  response)
		  
		  ; break; 
		  
		  } } 
		  
		  catch (Exception e) {
		 



	request.getRequestDispatcher("/WEB-INF/listUser.jsp").forward(request,response);

	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String Oper = request.getParameter("op");
			System.out.println(Oper);
			switch (Oper) {

			case "update":
				
				int idUser = Integer.parseInt(request.getParameter("idUser"));
				String NomUser1 = request.getParameter("nom");
				String PrenomUser11 = request.getParameter("prenom");
				String EmailUser1 = request.getParameter("email");

				String UsernameUser1 = request.getParameter("username");
				String PasswordUser1 = request.getParameter("password");
				String RoleUser1 = request.getParameter("role");

				DaoGestionUsers dao2 = new DaoGestionUsers();
				dao2.UpdateUser(NomUser1, PrenomUser11, EmailUser1, UsernameUser1, PasswordUser1, RoleUser1, idUser);
				
				
				request.getRequestDispatcher("WEB-INF/listUser.jsp").forward(request, response);
				break;
			case "update1":
				
				int idUser2 = Integer.parseInt(request.getParameter("idUser"));
				String NomUser2 = request.getParameter("nom");
				String PrenomUser2 = request.getParameter("prenom");
				String EmailUser2 = request.getParameter("email");
				String UsernameUser2 = request.getParameter("username");
				String PasswordUser2 = request.getParameter("password");
				String RoleUser2 = request.getParameter("role");

				session.setAttribute("nom",NomUser2 );
				session.setAttribute("prenom",PrenomUser2);
				session.setAttribute("email", EmailUser2);
				session.setAttribute("username", UsernameUser2);
				session.setAttribute("password", PasswordUser2);
				session.setAttribute("role",RoleUser2);
				session.setAttribute("id", idUser2);
				DaoGestionUsers dao3 = new DaoGestionUsers();
				dao3.UpdateUser(NomUser2, PrenomUser2, EmailUser2, UsernameUser2, PasswordUser2, RoleUser2, idUser2);
				request.getRequestDispatcher("MyAccountSer").forward(request, response);
				break;
             case "update2":
				
				int idUser3 = Integer.parseInt(request.getParameter("idUser"));
				String NomUser3 = request.getParameter("nom");
				String PrenomUser3 = request.getParameter("prenom");
				String EmailUser3 = request.getParameter("email");
				String UsernameUser3 = request.getParameter("username");
				String PasswordUser3= request.getParameter("password");
				String RoleUser3 = request.getParameter("role");

				DaoGestionUsers dao4 = new DaoGestionUsers();
				dao4.UpdateUser1(NomUser3, PrenomUser3, EmailUser3, UsernameUser3 ,  PasswordUser3, RoleUser3, idUser3);
				
			 
				session.setAttribute("nom",NomUser3);
				session.setAttribute("prenom",PrenomUser3);
				session.setAttribute("email", EmailUser3);
				session.setAttribute("username", UsernameUser3);
				session.setAttribute("password", PasswordUser3);
				session.setAttribute("role",RoleUser3);
				session.setAttribute("id", idUser3);
				request.getRequestDispatcher("MyAccountEns?username="+session.getAttribute("username")).forward(request, response);
				break;
			

			case "add":

				String NomUser = request.getParameter("nom");
				String PrenomUser = request.getParameter("prenom");
				String EmailUser = request.getParameter("email");
				int index = EmailUser.indexOf('@');
				String UsernameUser = EmailUser.substring(0, index);
				String PasswordUser = request.getParameter("password");
				String RoleUser = request.getParameter("role");
				User u = new User(NomUser, PrenomUser, UsernameUser, PasswordUser, RoleUser, EmailUser);

				DaoGestionUsers dao1 = new DaoGestionUsers();
				dao1.AddUser(u);
				request.getRequestDispatcher("WEB-INF/listUser.jsp").forward(request, response);
				break;
				
			
			  case "updatepassword":
			
			  String CurrentPassword = request.getParameter("password");
			  String NewPassword= request.getParameter("newpassword");
			  String RePassword =request.getParameter("repeatpassword"); 
			  int idUser1=Integer.parseInt(request.getParameter("idUser"));
			  if(CurrentPassword.equals(session.getAttribute("password"))&&(RePassword.equals(NewPassword))) {
			
			
				  DaoGestionUsers dao9 = new DaoGestionUsers();
			  dao9.UpdatePassword(NewPassword,idUser1);
			  
			  request.getRequestDispatcher("MyAccountSer").forward(request,response); break;
			  }
			  else {
				  String message = "Veuillez réessayer";
				  response.sendRedirect("MyAccountSer?message=" + URLEncoder.encode(message, "UTF-8"));
				  }
			 
				
				
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
			request.getRequestDispatcher("WEB-INF/listUserjsp").forward(request, response);
		}
	}
}

package Servlets;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import Classes.User;
import DAO.DaoGestionUsers;
import DAO.Logindao;

/**
 * Servlet implementation class loginSer
 */
@WebServlet("/loginSer")
public class loginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginSer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		System.out.println("Username :" + username);
		System.out.println("pass :" + pass);
		User loginC = new User();
		loginC.setUsername(username);
		;
		loginC.setPassword(pass);

		try {
			if (Logindao.login(loginC)) {
				if (Logindao.role(loginC).equals("admin")) {
					HttpSession session = request.getSession();
					System.out.println("session created");
					User u = new User();
					u = DaoGestionUsers.getUserByUsername(username);

					System.out.println("nom :" + u.getNom());
					session.setAttribute("nom", u.getNom());
					session.setAttribute("prenom", u.getPrenom());
					session.setAttribute("username", u.getUsername());
					session.setAttribute("email", u.getEmail());
					session.setAttribute("role", u.getRole());
					session.setAttribute("password", u.getPassword());
					session.setAttribute("id", u.getIdUser());
					System.out.println("session ok");
					response.sendRedirect("listFiliere");
					
					
				} else if (Logindao.role(loginC).equals("etudiant")) {
					HttpSession session = request.getSession();
					System.out.println("session created");
					User u = new User();
					u = DaoGestionUsers.getUserByUsername(username);

					System.out.println("nom :" + u.getNom());
					session.setAttribute("nom", u.getNom());
					session.setAttribute("prenom", u.getPrenom());
					session.setAttribute("username", u.getUsername());
					session.setAttribute("email", u.getEmail());
					session.setAttribute("role", u.getRole());
					session.setAttribute("password", u.getPassword());
					session.setAttribute("id", u.getIdUser());
					System.out.println("session ok");
					request.getRequestDispatcher("indexE").forward(request, response);
				}

				else if (Logindao.role(loginC).equals("enseignant")) {
					HttpSession session = request.getSession();
					System.out.println("session created");
					User u = new User();
					u = DaoGestionUsers.getUserByUsername(username);

					System.out.println("nom :" + u.getNom());
					session.setAttribute("nom", u.getNom());
					session.setAttribute("prenom", u.getPrenom());
					session.setAttribute("username", u.getUsername());
					session.setAttribute("email", u.getEmail());
					session.setAttribute("role", u.getRole());
					session.setAttribute("password", u.getPassword());
					System.out.println("session ok");
					request.getRequestDispatcher("WEB-INF/indexEns.jsp").forward(request, response);

				}

			}

			else {
				System.out.println("yghuhuij");
				String message = "Username ou Mot de Passe Incorrect";

				response.sendRedirect("index.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

				/* * request.setAttribute("msg2", "username ou mot de passe incorrect "); */
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

				/*
				 * response.setContentType("application/text");
				 * response.setCharacterEncoding("UTF-8");
				 * 
				 * PrintWriter out = response.getWriter(); out.println(jsArray);
				 * 
				 * response.getWriter().print(message);
				 * 
				 * 
				 */

			}
		} catch (ClassNotFoundException e) {
			response.sendRedirect("page_404.jsp");
			e.printStackTrace();
		}

	}

}

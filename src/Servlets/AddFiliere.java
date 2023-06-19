package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classes.Filiere;
import DAO.DaoGestionFiliere;

/**
 * Servlet implementation class AddFiliere
 */
@WebServlet("/AddFiliere")
public class AddFiliere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFiliere() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/AddFiliere.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		
		String NomFiliere = request.getParameter("NomFiliere");
		Filiere f = new Filiere(NomFiliere);
		DaoGestionFiliere dao = new DaoGestionFiliere();
		dao.AddFiliere(f);
		request.getRequestDispatcher("WEB-INF/listFiliere.jsp").forward(request, response);
	}
	catch(Exception e) {
		System.out.println(e.toString());
	}
		
	}

}

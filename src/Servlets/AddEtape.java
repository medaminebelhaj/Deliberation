package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classes.Etape;
import Classes.Filiere;
import DAO.DaoGestionEtape;
import DAO.DaoGestionFiliere;

/**
 * Servlet implementation class AddEtape
 */
@WebServlet("/AddEtape")
public class AddEtape extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEtape() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/AddEtape.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String NmEtape = request.getParameter("NmEtape");
			String Diplomante ;
			if (request.getParameter("Diplomante")=="1") {
				Diplomante="false";
				}
			else {
		     Diplomante = "true";}
			System.out.println(Diplomante);
			
			 int idFiliere_FK=Integer.valueOf(request.getParameter("idFiliere_FK")); 
			 
			 
			boolean d = Diplomante.equals("true");
			
			
			Etape etape = new Etape(NmEtape,d,idFiliere_FK);
			 System.out.println(NmEtape +"d="+d+"IdF="+idFiliere_FK); 
			DaoGestionEtape dao = new DaoGestionEtape();
		
			
			dao.AddEtape(etape);
			this.getServletContext().getRequestDispatcher("/WEB-INF/listEtape.jsp").forward(request, response);}
			
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}

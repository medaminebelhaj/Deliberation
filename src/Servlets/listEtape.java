package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classes.Filiere;
import DAO.DaoGestionEtape;
import DAO.DaoGestionFiliere;

/**
 * Servlet implementation class listEtape
 */
@WebServlet("/listEtape")
public class listEtape extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listEtape() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
		String action =request.getParameter("action");
		int idEtape = Integer.parseInt(request.getParameter("id"));
		switch(action) {
		case "list":
			
			request.getRequestDispatcher("WEB-INF/listEtape.jsp").forward(request, response);
			break;
			
		case "delete":
	   DaoGestionEtape dao = new DaoGestionEtape();
	   dao.DeleteEtape(idEtape);
			request.getRequestDispatcher("WEB-INF/listEtape.jsp").forward(request, response);
			break;
		}
		}
		catch (Exception e) {
			request.getRequestDispatcher("WEB-INF/listEtape.jsp").forward(request, response);
		}
		
		
	
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String Oper = request.getParameter("op");
			System.out.println(Oper);
			switch(Oper) {
			case "update":
				
				int idEtape = Integer.parseInt(request.getParameter("idEtape"));
				String NomEtape = request.getParameter("NmEtape");
				String Diplomante ;
				if (request.getParameter("Diplomante")=="1") {
					Diplomante="false";
					}
				else {
			     Diplomante = "true";}
				System.out.println(Diplomante);
				
				 int idFiliere_FK=Integer.valueOf(request.getParameter("idFiliere_FK")); 
				 
				 
				boolean d = Diplomante.equals("true");
				
				DaoGestionEtape dao = new DaoGestionEtape() ;
				dao.UpdateEtape(idEtape, NomEtape,d,idFiliere_FK);
				request.getRequestDispatcher("WEB-INF/listEtape.jsp").forward(request, response);
				break;
				
			case "add":
				
				String NomFiliere1 = request.getParameter("NomFiliere");
				Filiere f = new Filiere(NomFiliere1);
				DaoGestionFiliere dao1 = new DaoGestionFiliere();
				dao1.AddFiliere(f);
				request.getRequestDispatcher("WEB-INF/listEtape.jsp").forward(request, response);
				break;
			}
			}
			
			catch (Exception e) {
				System.out.println(e.toString());
				request.getRequestDispatcher("WEB-INF/listFiliere.jsp").forward(request, response);
			}
			
			
		
		}


}

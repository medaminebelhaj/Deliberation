package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaisirNoteSer
 */
@WebServlet("/SaisirNoteSer")
public class SaisirNoteSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaisirNoteSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("idElement")!=null) {
			int idElement = Integer.parseInt(request.getParameter("idElement"));
			String NomElement =request.getParameter("NomElement");
			int idModule = Integer.parseInt(request.getParameter("idModule"));
			request.setAttribute("idElement", idElement);
			request.setAttribute("NomElement", NomElement);
			request.setAttribute("idModule", idModule);
			
			  request.getRequestDispatcher("WEB-INF/SaisirNote.jsp").forward(request,response);
		}
		else {
		
			  request.getRequestDispatcher("indexEns").forward(request,response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

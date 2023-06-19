package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.DaoGestionEtudiant;
import DAO.DaoGestionModule;
import DAO.DaoGestionSemestre;

/**
 * Servlet implementation class listEtudiant
 */
@WebServlet("/listEtudiant")
public class listEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listEtudiant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/listEtudiant.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idanne = request.getParameter("idanne");
		idanne=idanne.replaceAll("\\s","");
		String idfiliere = request.getParameter("idfiliere");
		String idetape = request.getParameter("idetape");
		int idsemestre = Integer.parseInt(request.getParameter("idsemestre"));
		
		
		try {
			ArrayList<String>L=DaoGestionEtudiant.GetAllEtudiantByIdUni(idanne, idsemestre);
			
			
			
			Gson gson = new Gson();
			String json = gson.toJson(L);
			 // request.setAttribute("src", jsArray); 
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8"); 
				/*
				 * PrintWriter out = response.getWriter(); out.println(jsArray);
				 */
			    response.getWriter().print(json);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}

}

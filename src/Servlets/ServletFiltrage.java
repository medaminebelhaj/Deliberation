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

import DAO.DaoGestionModule;
import DAO.DaoGestionSemestre;

/**
 * Servlet implementation class ServletFiltrage
 */
@WebServlet("/ServletFiltrage")
public class ServletFiltrage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFiltrage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		
		
		if(action.equals("GetAllModulebySemester")) {
			
			
			int idSemestre=Integer.parseInt(request.getParameter("idsemestre"));
			
			System.out.println("je suis entrain de recupurer les mdules du semestre :"+idSemestre);
			try {
				ArrayList<String>L=DaoGestionModule.GetAllModulesByIdSemestre(idSemestre);
				
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
	if(action.equals("GetAllElementbyIdmodule")) {
			
			
			int idSemestre=Integer.parseInt(request.getParameter("idModule"));
			
			System.out.println("je suis entrain de recupurer les elements du module :"+idSemestre);
			try {
				ArrayList<String>L=DaoGestionModule.GetAllElementByidModule(idSemestre);
				
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

}

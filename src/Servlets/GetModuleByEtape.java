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
 * Servlet implementation class GetModuleByEtape
 */
@WebServlet("/GetModuleByEtape")
public class GetModuleByEtape extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetModuleByEtape() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> L;
		try {
			
			 int idetape =Integer.parseInt(request.getParameter("idFiliere")); 
			 System.out.println(idetape);
			L = DaoGestionModule.GetAllModulesByIdEtape(idetape);
			
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
			// TODO Auto-generated catch block
			e.printStackTrace();
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

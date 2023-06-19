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

/**
 * Servlet implementation class listElement
 */
@WebServlet("/listElement")
public class listElement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listElement() {
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
		ArrayList<String> L=new ArrayList<String>();
		try {
		
		String [] moduleid=request.getParameterValues("listmodulechekbox");
		
		for(int i=0;i<moduleid.length;i++) {
		System.out.println("module id"+moduleid[i]);
		ArrayList<String> L1 = DaoGestionModule.GetAllElementByidModule(Integer.parseInt(moduleid[i]));
		for(int j=0;j<L1.size();j++)
			L.add(L1.get(j));
		
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(L);
		 // request.setAttribute("src", jsArray); 
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8"); 
			/*
			 * PrintWriter out = response.getWriter(); out.println(jsArray);
			 */
		    response.getWriter().print(json);
		
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}

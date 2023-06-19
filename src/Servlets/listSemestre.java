package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.IDIV;

import Classes.Etape;
import Classes.Semestre;
import DAO.DaoGestionSemestre;
import DAO.DaoGestionUsers;

/**
 * Servlet implementation class listSemestre
 */
@WebServlet("/listSemestre")
public class listSemestre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listSemestre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try { 
			 String action =request.getParameter("action"); 
			 int idUser =Integer.parseInt(request.getParameter("id")); 
	   switch(action) { 
		case "list":
		  
		  request.getRequestDispatcher("WEB-INF/listSemestre.jsp").forward(request,
		  response); break;
		  
		  case "delete": DaoGestionSemestre dao = new DaoGestionSemestre();
		  dao.DeleteSemestre(idUser);
		  request.setAttribute("msg2", "Semester successfully removed...");
		  request.getRequestDispatcher("WEB-INF/listSemestre.jsp").forward(request,
		  response)
		  
		  ; break; 
		  
		  } }  catch (Exception e) {
				 



				request.getRequestDispatcher("/WEB-INF/listSemestre.jsp").forward(request,response);

				}
				}
				
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String action=request.getParameter("action");
	
	
	if(action.equals("GetIdFiliere")) {
		
		
		String idfilier=request.getParameter("idfiliere");
		try {
			ArrayList<String>L=DaoGestionSemestre.GetAllEtapesByIdFil(idfilier);
			
			
			
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
	else
if(action.equals("GetIdSemestre")) {
	
	System.out.println("je suis entrain de recupurer les semestres");
		
		String idfilier=request.getParameter("idsemestre");
		try {
			ArrayList<String>L=DaoGestionSemestre.GetAllEtapesByIdFil(idfilier);
			
			
			
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
	else if(action.equals("update")) {
		System.out.println("update");
		int idsemestre = Integer.parseInt(request.getParameter("idsemestre"));
		String NmSemestre = request.getParameter("NmSemestre");
		float NoteValidation = Float.parseFloat(request.getParameter("NoteValidation"));

		DaoGestionSemestre dao2 = new DaoGestionSemestre();
		dao2.UpdateUser(idsemestre,NmSemestre,NoteValidation);
		;
		request.getRequestDispatcher("WEB-INF/listSemestre.jsp").forward(request, response);
		
		
		
		
		
	}
	else if(action.equals("add")) {
		System.out.println("add");
		int idEtape = Integer.parseInt(request.getParameter("idEtape"));

		String NmSemestre =(request.getParameter("NmSemestre"));
		float NoteValidation = Float.parseFloat(request.getParameter("NoteValidation"));
		DaoGestionSemestre dao2 = new DaoGestionSemestre();
		Semestre u = new Semestre(NmSemestre,idEtape,NoteValidation);
		
		dao2.AddSemestre(u);
		;
		request.getRequestDispatcher("WEB-INF/listSemestre.jsp").forward(request, response);
		
		
		
		
		
	}
	else {
		
		
		String idetape=request.getParameter("idetape");
	
		try {
			ArrayList<String>L=DaoGestionSemestre.GetAllSemestreByIdEtape(idetape);
			
			
			
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
	
	
	



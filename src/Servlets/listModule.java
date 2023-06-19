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

import Classes.Module;
import DAO.DaoGestionElement;
import DAO.DaoGestionModule;
import DAO.DaoGestionSemestre;

/**
 * Servlet implementation class listModule
 */
@WebServlet("/listModule")
public class listModule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listModule() {
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
		  
		  request.getRequestDispatcher("WEB-INF/listModule.jsp").forward(request,
		  response); break;
		  
		  case "delete": DaoGestionSemestre dao = new DaoGestionSemestre();
		  dao.DeleteSemestre(idUser);
		  request.setAttribute("msg2", "Module successfully removed...");
		  request.getRequestDispatcher("WEB-INF/listModule.jsp").forward(request,
		  response)
		  
		  ; break; 
		  
		  } }  catch (Exception e) {
				 



				request.getRequestDispatcher("/WEB-INF/listModule.jsp").forward(request,response);

				}
				}
				
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		
		if(action.equals("GetIdFiliere")) {
			
			System.out.println("je suis entrain de recupurer les etapes");
			
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
		
		else if(action.equals("GetAllModulebySemester")) {
			System.out.println("je suis entrain de recupurer les tous les modules");
			int idsemestre=Integer.parseInt(request.getParameter("idsemestre"));
			
			try {
				ArrayList<String>L=DaoGestionModule.GetAllModulesByIdEtape(idsemestre);
				
				
				
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
		else if(action.equals("GetAllModulebyIdSeme")) {
			System.out.println("je suis entrain de recupurer les tous les modules");
			int idsemestre=Integer.parseInt(request.getParameter("idsemestre"));
			
			try {
				ArrayList<String>L=DaoGestionModule.GetAllModulesByIdSemestre(idsemestre);
				
				
				
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
			int idsemestre = Integer.parseInt(request.getParameter("idModule"));
			String NmSemestre = request.getParameter("NomModule");
			float NoteValidation = Float.parseFloat(request.getParameter("NoteValidationModule"));
			float NoteEliminatoire = Float.parseFloat(request.getParameter("NoteEliminatoireModule"));
			DaoGestionModule dao3 = new DaoGestionModule();
			dao3.UpdateM(idsemestre,NmSemestre,NoteValidation,NoteEliminatoire);
			;
			request.getRequestDispatcher("WEB-INF/listModule.jsp").forward(request, response);
			
			
			
			
			
		}
		else if(action.equals("add")) {
			int idEtape = Integer.parseInt(request.getParameter("idEtape"));
			int idsemestre = Integer.parseInt(request.getParameter("idSemestre_FK"));
			String NmSemestre = request.getParameter("NomModule");
			float NoteValidation = Float.parseFloat(request.getParameter("NoteValidationModule"));
			float NoteElimi = Float.parseFloat(request.getParameter("NoteEliminatoireModule"));
			int CoifficientModule = Integer.parseInt(request.getParameter("CoifficientModule"));
			int idEns =Integer.parseInt(request.getParameter("idEnseignant"));
			int ok =Integer.parseInt( request.getParameter("ok"));
			DaoGestionModule dao2 = new DaoGestionModule();
			DaoGestionElement daoo = new DaoGestionElement();
			Module u=new Module(idEtape,idsemestre,NmSemestre,NoteValidation,NoteElimi,CoifficientModule,idEns);
			dao2.AddModule(u);
			if (ok==0) {
				Module m = dao2.getTheLastModule();
				daoo.AddElement(m);
				
			}
			
			
		
			;
			request.getRequestDispatcher("WEB-INF/listModule.jsp").forward(request, response);
			
			
			
			
			
		}
		else if(action.equals("GetIdEtape")){
			
			
			System.out.println("je suis entrain de recupurer les semstres");
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
else if(action.equals("GetIdSemestre")){
			
			
			String idetape=request.getParameter("idetape");
		
			try {
				ArrayList<String>L=DaoGestionSemestre.GetAllSemestreByIdEtape((idetape));
				
				
				
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
		
		
		

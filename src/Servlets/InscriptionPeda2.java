package Servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import DAO.DAOdelib;
import DAO.DaoInscriptionPedagique;

/**
 * Servlet implementation class InscriptionPeda2
 */
@WebServlet("/InscriptionPeda2")
public class InscriptionPeda2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionPeda2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" appel");
		 request.getRequestDispatcher("WEB-INF/InscriptionPeda2.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("appel");
		
		HttpSession session = request.getSession();
			
		
			
		 if(request.getParameterValues("listmodulechekbox")!=null){
			 String [] moduleid=request.getParameterValues("listmodulechekbox"); 
			 String [] elementid=request.getParameterValues("listelementchekbox");
			
			 
			
		  for(int i=0;i<elementid.length;i++) { 
				  String ligne=elementid[i]+","+session.getAttribute("massaeretudiant"); 
				  String[] ModuleElement=ligne.split(","); 
				  int idElement=Integer.parseInt(ModuleElement[0]);
				  int idModule=Integer.parseInt(ModuleElement[1]); 
				  String massar=ModuleElement[2];
				  String anneuni=""+session.getAttribute("AnneUni");
			  new DaoInscriptionPedagique().InserInscriptionParElement(idElement, idModule,massar,anneuni);
			  System.out.println(ModuleElement[0]+"+"+ModuleElement[1]+"+"+ModuleElement[2]); 
			  }
			  
			  DAOdelib dao = new DAOdelib();
			  //dao.UpdateStats("inscrit",""+session.getAttribute("massaeretudiant"));
			 
				
				
		 }
		 
		 else {
			 request.getRequestDispatcher("WEB-INF/InscriptionPeda2.jsp").forward(request,response);
		 }
		
		
	}

}

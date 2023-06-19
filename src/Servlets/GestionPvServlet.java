package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classes.Module;
import DAO.DaoGestionModule;
import DAO.DaoGestionPV;

/**
 * Servlet implementation class GestionPvServlet
 */
@WebServlet("/GestionPvServlet")
public class GestionPvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionPvServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("WEB-INF/listPvs.jsp").forward(request,
		  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String IDANNE = request.getParameter("idanne");
	//	idanne=idanne.replaceAll("\\s","");
		String idfiliere = request.getParameter("idfiliere");
		String idetape = request.getParameter("idetape");
		int idsemestre = Integer.parseInt(request.getParameter("idsemestre"));
		
		System.out.println("idsemestre="+idsemestre);
		System.out.println("idannee="+IDANNE);
		String table="";
		String LiteModulerow="<tr height=\"50\">";
	
		int semestre=5;
		
		try {
		
			
			ArrayList<String> EtudiantInscrit=new DaoGestionPV().GetAllEtudiantInscri(idsemestre, IDANNE);
			System.out.println(EtudiantInscrit.size());
			
			ArrayList<String> listeStudenbymodule=new DaoGestionPV().GeneratePvSemestre(idsemestre, IDANNE);
			
			
			
			ArrayList<Module> ListeModule=DaoGestionModule.GetAllModulesByIdSemestreAsObject(5);
			int NombreModule=ListeModule.size();
			
			
			table="<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\">"
					+ "<tr height=\"50\">\r\n"
					+ "<td align=\"center\" width=\"150\" rowspan=\"2\">CNE</td>\r\n"
					+ "<td align=\"center\" width=\"300\" colspan=\""+NombreModule+"\">S"+semestre+"</td>\r\n"
					+ "<td align=\"center\" width=\"150\" rowspan=\"2\">NoteFinal</td>\r\n"
					+ "<td align=\"center\" width=\"150\" rowspan=\"2\">Resultat</td>";
			
			for(int i=0;i<ListeModule.size();i++) {
				String [] listemodule1=ListeModule.get(i).getNomModule().replace("[","").replace("]","").split(",");
				LiteModulerow=LiteModulerow+"<td align=\"center\" width=\"150\">"+listemodule1[0]+"</td>";
				
			}
			LiteModulerow=LiteModulerow+"</tr>";
			
			
			
			String Allrow="";
			for(int i=0;i<EtudiantInscrit.size();i++) {
				 String StudenRow="<tr height=\"50\">";
				//System.out.println("Traitement etudiant:"+EtudiantInscrit.get(i));
				        StudenRow=StudenRow+" <td align=\"center\" width=\"150\">"+EtudiantInscrit.get(i)+"</td>";
				        double note=0;
				        String state="Non Valider";
                    for(int j=0;j<ListeModule.size();j++) {
                    	
                    	
                    	//listemodule1=ListeModule.get(j).replace("[","").replace("]","").split(",");
                    	//System.out.println("Traitement du module :"+listemodule1[0]);
                		
                    	
                    	for(int k=0;k<listeStudenbymodule.size();k++) {
                    		String [] row=listeStudenbymodule.get(k).split(",");
                    		if(row[1].compareTo(ListeModule.get(j).getNomModule())==0) {
                    			
                    			note=Double.parseDouble(row[2]);
                    			if(note>=ListeModule.get(j).getNoteValidation())
                    				state="Valider";
                    		}
                    	}
                    	
                    	
                    	StudenRow=StudenRow+"<td align=\"center\" width=\"150\">"+note+"</td>";
                     	
                    	}
                    StudenRow=StudenRow+"<td align=\"center\" width=\"150\">"+note+"</td>";
                 	StudenRow=StudenRow+"<td align=\"center\" width=\"150\">"+state+"</td>";
                    
                   StudenRow=StudenRow+"</tr>";
                    Allrow=Allrow+StudenRow;
                    }
			
			
			table=table+LiteModulerow+Allrow+"</table>";
					
					             
					
			
			
			
			
			/*
			 * 
			 * 
			 * 
			 * 
			 * 
			 * for(int i=0;i<ListeModule.size();i++) {
			 * 
			 * String []
			 * listemodule1=ListeModule.get(i).replace("[","").replace("]","").split(",");
			 * 
			 * System.out.println(" ---------------Module"+listemodule1[0]+
			 * "-------------------");
			 * LiteModulerow=LiteModulerow+"<td align=\"center\" width=\"150\">"
			 * +listemodule1[0]+"</td>";
			 * 
			 * for(int j=0;j<listeStudenbymodule.size();j++) {
			 * 
			 * String [] row=listeStudenbymodule.get(j).split(",");
			 * 
			 * if(listemodule1[0].compareTo(row[1])==0) {
			 * System.out.println(" Etudiant:"+row[0]+" Note:"+row[2]);
			 * 
			 * 
			 * } }
			 * 
			 * } LiteModulerow=LiteModulerow+" </tr>";
			 */
			System.out.println(table);
				
		}
		catch ( Exception e) {
			System.out.print(e.toString());
		}
		
		response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
		response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
		response.getWriter().write(table);  
	}

}

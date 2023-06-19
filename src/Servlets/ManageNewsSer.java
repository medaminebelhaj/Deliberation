package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classes.News;
import Classes.User;
import DAO.DaoGestionEtape;
import DAO.DaoGestionUsers;
import DAO.DaoNews;

/**
 * Servlet implementation class ManageNewsSer
 */
@WebServlet("/ManageNewsSer")
public class ManageNewsSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageNewsSer() {
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
				
				request.getRequestDispatcher("WEB-INF/ManageNews.jsp").forward(request, response);
				break;
				
			case "delete":
		   DaoNews dao = new DaoNews();
		   dao.DeleteNews(idEtape);
		   request.getRequestDispatcher("WEB-INF/ManageNews.jsp").forward(request, response);
				break;
			}
			}
			catch (Exception e) {
				request.getRequestDispatcher("WEB-INF/ManageNews.jsp").forward(request, response);
			}
			
	}
		
			
		

		/**
		request.getRequestDispatcher("WEB-INF/ManageNews.jsp").forward(request,response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			String Oper = request.getParameter("op");
			System.out.println(Oper);
			switch (Oper) {

			case "update":
				System.out.println("hiuhuihhiu");
				
		
				String jourNews = request.getParameter("jourNews");
				String textNews = request.getParameter("textNews");
				String moisNews = request.getParameter("moisNews");
				int dateNews = Integer.parseInt(request.getParameter("dateNews"));
				int idnews= Integer.parseInt(request.getParameter("idnews"));

               DaoNews d = new DaoNews();
			
				d.UpdateNews(jourNews,textNews,moisNews,dateNews, idnews);
				
				request.getRequestDispatcher("WEB-INF/ManageNews.jsp").forward(request, response);
				break;

			case "add":


				String jourNews1 = request.getParameter("jourNews");
				String textNews1 = request.getParameter("textNews");
				String moisNews1 = request.getParameter("moisNews");
				int dateNews1 = Integer.parseInt(request.getParameter("dateNews"));
			    News u = new News(jourNews1,textNews1,moisNews1,dateNews1);
		         DaoNews d1 = new DaoNews();
				
				d1.AddNews(u);
				request.getRequestDispatcher("WEB-INF/ManageNews.jsp").forward(request, response);
				break;
			}
		}

		catch (Exception e) {
			System.out.println(e.toString());
			request.getRequestDispatcher("WEB-INF/ManageNews.jsp").forward(request, response);
		}
	}

}

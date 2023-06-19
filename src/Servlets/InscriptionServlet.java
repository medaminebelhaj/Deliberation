package Servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Classes.EtudiantInscrictionEnligne;
import DAO.DAOdelib;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/InscriptionServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InscriptionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/InscriptionEnligne.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		  String NomFr = request.getParameter("NomFr");
		  String PrenomFr =request.getParameter("PrenomFr"); String CIN =request.getParameter("CIN");
		  String MassarEtdudiant = request.getParameter("MassarEtdudiant"); 
		  request.getSession().setAttribute("Massar", request.getParameter("MassarEtdudiant"));
		  String NomAr = request.getParameter("NomAr"); String PrenomAr=
		  request.getParameter("PrenomAr"); String Nationalite=
		  request.getParameter("Nationalite"); String Sexe=
		  request.getParameter("Sexe"); Date
		  DatedeNaissance=Date.valueOf(request.getParameter("DatedeNaissance")); String
		  LieudeNaissanceFr= request.getParameter("LieudeNaissanceFr"); String
		  LieudeNaissanceAr= request.getParameter("LieudeNaissanceAr"); String Ville=
		  request.getParameter("Ville"); String Province=
		  request.getParameter("Province"); String AnnéedeBAC =
		  request.getParameter("AnneedeBAC"); String SeriedeBAC =
		  request.getParameter("SeriedeBAC"); String Mention =
		  request.getParameter("Mention"); String Lycee =
		  request.getParameter("Lycee"); String LieudeBAC =
		  request.getParameter("LieudeBAC"); String Academie =
		  request.getParameter("Academie"); Date DateInscription =
		  Date.valueOf(request.getParameter("DateInscription")); String Etablissement =
		  request.getParameter("Etablissement"); 
		  int Filiere =Integer.parseInt(request.getParameter("Filiere")); // UploadFile(request, response);
		  
		
		  
		  
		  EtudiantInscrictionEnligne EtudiantInscription = new
		  EtudiantInscrictionEnligne(MassarEtdudiant, NomFr, NomAr, PrenomAr, PrenomFr,
		  CIN, Nationalite, Sexe, DatedeNaissance, LieudeNaissanceFr,
		  LieudeNaissanceAr, Ville, Province, AnnéedeBAC, SeriedeBAC, Mention, Lycee,
		  LieudeBAC, Academie, DateInscription, Etablissement,Filiere);
		  
		  try {
			EtudiantInscription.InsertInscriptionEnligne();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		 
		
		
	}




	public void UploadFile(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String UPLOAD_DIRECTORY = "Images";
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		// String uploadPath = getServletContext().getContextPath() + File.separator +
		// UPLOAD_DIRECTORY;
		System.out.println(uploadPath);
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {

			uploadDir.mkdir();
		}
		/* Receive file uploaded to the Servlet from the HTML5 form */

		Part filePart = request.getPart("file");
		String fileName = filePart.getSubmittedFileName();
		for (Part part : request.getParts()) {
			System.out.println(uploadPath + File.separator + fileName);
			part.write(uploadPath + File.separator + fileName);
		}

	

	}
}

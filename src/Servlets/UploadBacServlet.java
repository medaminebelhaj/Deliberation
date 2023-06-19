package Servlets;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadBacServlet
 */
@WebServlet("/UploadBacServlet")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)


public class UploadBacServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadBacServlet() {
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
		String Massar =request.getParameter("massar"); 
		String UPLOAD_DIRECTORY="Images";
	
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		//String uploadPath = getServletContext().getContextPath() + File.separator + UPLOAD_DIRECTORY;
		
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
		
			uploadDir.mkdir();
		}
		/* Receive file uploaded to the Servlet from the HTML5 form */
		
		  Part filePart = request.getPart("file1"); 
		  String fileName = filePart.getSubmittedFileName(); 
		  
		 
		  for (Part part : request.getParts()) {
			  System.out.println(uploadPath + File.separator +Massar+ ".pdf");
		 
			  part.write(uploadPath + File.separator +Massar+ ".pdf");

		 }
		 
	    response.getWriter().print("The file uploaded sucessfully in the fatta.");
	  }
	

	}



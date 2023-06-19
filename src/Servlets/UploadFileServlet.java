package Servlets;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;
import java.sql.SQLException;
import java.text.Format.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mysql.cj.xdevapi.Type;

import java.io.File;

import Classes.EtudiantInscrictionEnligne;
import Classes.Filiere;
import DAO.DaoGestionFiliere;



/**
 * Servlet implementation class UploadFileServlet
 */
@WebServlet("/UploadFileServlet")
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "Images";
	private static final int THRESHOLD_SIZE     = 1024 * 1024 * 3;  // 3MB
	private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFileServlet() {
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
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EtudiantInscrictionEnligne etu=new EtudiantInscrictionEnligne();
		String massar=(request.getParameter("id"));
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(THRESHOLD_SIZE);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		 
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(MAX_REQUEST_SIZE);
		
		String uploadPath = getServletContext().getRealPath("")+ File.separator + "Images/photo";
		String uploadPath1 = getServletContext().getRealPath("")+ File.separator + "Images/bac";
		String uploadPath2=getServletContext().getRealPath("")+ File.separator + "Images/relve";
		ArrayList<String> ListPath=new ArrayList<String>();
		ListPath.add(uploadPath);
		ListPath.add(uploadPath1);
		//ListPath.add(uploadPath2);
			// creates the directory if it does not exist
			File uploadDir = new java.io.File(uploadPath);
			if (!uploadDir.exists()) {
			    uploadDir.mkdir();
			}
			
			
			try {
			List formItems = upload.parseRequest(request);
			
			Iterator iter = formItems.iterator();
			 
			int k=0;
			while (iter.hasNext()) {
			    FileItem item = (FileItem) iter.next();
			    // processes only fields that are not form fields
			    if (!item.isFormField()) {
					 
					  if(item.getContentType().compareTo("image/png")==0) {
						  String filePath =ListPath.get(k) + File.separator + massar+".png"; 
						  File storeFile = new File(filePath);
						  item.write(storeFile); 
						  k++;
					  }
					  else {
						  String filePath =ListPath.get(k) + File.separator + massar+".pdf"; 
						  File storeFile = new File(filePath);
						  item.write(storeFile); 
						  k++;
					  }
					 
					  
					  // saves the file on disk 
					
					 
			    }
			    
			    else {
					  
			    	  
					
					  java.lang.reflect.Field f=etu.getClass().getDeclaredField(item.getFieldName());
					  
					  System.out.println("filed namr="+item.getFieldName()+" type="+f.getType());
					  
					  
					  if(f.getType()==Date.class) { 
						  System.out.println(f.getType());
					  
					  Date DateInscription =Date.valueOf(item.getString()); 
					  f.setAccessible(true);
					  f.set(etu,DateInscription); }
					  
					  else if(f.getType()==int.class) { 
						  if(item.getFieldName()=="Filiere") 
						  {
					  System.out.println(f.getType()); 
					  int idFilier=new
					  DaoGestionFiliere().getIdFilierByName(item.getString());
					  System.out.println("idFilier="+idFilier); 
					  f.setAccessible(true);
					  f.set(etu,idFilier); 
					  } 
						  else { 
							  System.out.println(f.getType());
					  f.setAccessible(true); 
					  f.set(etu,Integer.parseInt(item.getString())); 
					  }
					  
					  } 
					  else {
						  System.out.println(f.getType()); 
						  f.setAccessible(true);
					  f.set(etu,item.getString()); 
					  }
					 
					 
			    	
			    	//System.out.println(item.getFieldName()+"="+item.getString());
			    	
			    	//System.out.println("my name is="+etu.getPrenomFr());
			    }
			

			}
			
			
			etu.InsertInscriptionEnligne();
			String message = "vous êtes inscrit avec succès";
			response.sendRedirect("InscriptionServlet?message=" + URLEncoder.encode(message, "UTF-8"));
			
			}
			catch(Exception e) {
				System.out.println(e.toString());
			}
		
			
	}

}

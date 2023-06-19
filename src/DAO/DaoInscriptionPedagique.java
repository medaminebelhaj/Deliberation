package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Classes.SingletonConnection;

public class DaoInscriptionPedagique {

	public void InserInscriptionParElement(int idElement,int idModule,String massar,String anneuni) {
		try {
			
			
		    Connection conn = SingletonConnection.getConnection();
			PreparedStatement ps;
			 ps =conn.prepareStatement("INSERT INTO deliberationdb.inscriptionparelement VALUES (?,?,?,?,?,?,?,?)"); 
			 ps.setString(1, massar);
			 ps.setInt(2, idModule);
			 ps.setInt(3, idElement);
			 ps.setDouble(4, 0);
			 ps.setDouble(5, 0);
			 ps.setDouble(6, 0);
			 ps.setString(7,anneuni);
			 ps.setDouble(8, 0);
			
			 //ps.getResultSet()
			// ps.setString(1,e.getNmEtape());
			
			   int i = ps.executeUpdate();
			   
		 
			    
	}	catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	}
}

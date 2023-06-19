package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import Classes.SingletonConnection;

public class DaoGestionPV {
	
	public ArrayList<String> GeneratePvSemestre(int idSemestre,String idanne ){
		ArrayList<String> l=new ArrayList<String>();
		DecimalFormat df = new DecimalFormat("##.####");
		 Connection conn = SingletonConnection.getConnection();
			
					try {
						
						String req="SELECT inscriptionparelement.MassarEtudiant,module.NomModule,sum(inscriptionparelement.NoteTOTAL*element.CorficientElement)/sum(element.CorficientElement) as NoteModule FROM deliberationdb.module  " + 
								"join inscriptionparelement " + 
								"on module.idModule=inscriptionparelement.idModule and module.idSemestre_FK=5 " + 
								"join element on inscriptionparelement.idElement=element.idelement and inscriptionparelement.idanneUn='2022/2023' " + 
								"group by module.idModule,inscriptionparelement.MassarEtudiant " + 
								";";
						
							
						
					
						PreparedStatement ps= conn.prepareStatement(req);
						//ps.setString(1, name);
						ResultSet rs = ps.executeQuery();
						 while (rs.next()) 
					        
						{
					String massar =(rs.getString("MassarEtudiant"));
					String nommodule =(rs.getString("NomModule"));
					double notemodule =Double.parseDouble(rs.getString("NoteModule"));
					
					String roundDbl =df.format(notemodule);
					
					String row=massar+","+nommodule+","+roundDbl;
					l.add(row);
					
					 
						}
					}
					catch (SQLException e) {
						 e.printStackTrace();
					}
					return l;
	}
	
	public ArrayList<String> GetAllEtudiantInscri(int idsemetre,String idanne){
		ArrayList<String> l=new ArrayList<String>();
		 Connection conn = SingletonConnection.getConnection();
			
					try {
						
		String req="SELECT * FROM deliberationdb.inscriptionparelement\r\n"
				+ "join element on inscriptionparelement.idElement=element.idelement\r\n"
				+ "join module on module.idModule=element.idmoduleFK\r\n"
				+ "where idSemestre_FK=1 and inscriptionparelement.idanneUn='2022/2023'\r\n"
				+ "group by inscriptionparelement.MassarEtudiant\r\n"
				+ ";";
		PreparedStatement ps= conn.prepareStatement(req);
		//ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		 while (rs.next()) 
	        
		{
	String massar =(rs.getString("MassarEtudiant"));
	
	String row=massar;
	l.add(row);
	
	 
		}
	}
	catch (SQLException e) {
		 e.printStackTrace();
	}
	return l;
}
	

}

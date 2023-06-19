package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Classes.News;
import Classes.SingletonConnection;

public class DaoNotes {
	public void UpdateNote(int idElement,int idModule ,String MassarEtudiant,double NoteTp, double NoteCC,double NoteExam,double NoteTotal) {
		Connection con=SingletonConnection.getConnection();
		 PreparedStatement ps;
		try {
			ps = con.prepareStatement("update inscriptionparelement set NoteTp=? ,NoteCC=?,NoteExam=?,NoteTotal=? where idElement=? and idModule=? and MassarEtudiant=? ");
			
			
			ps.setDouble(1,NoteTp);
			ps.setDouble(2,NoteCC);
			ps.setDouble(3,NoteExam);
			ps.setDouble(4,NoteTotal);
			ps.setInt(5,idElement);
			ps.setInt(6,idModule);
			ps.setString(7,MassarEtudiant);

		        int i = ps.executeUpdate();
		        if(i > 0) {
		            System.out.println("User successfully updated...");
		        }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}
}

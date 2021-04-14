package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AnagrammaDAO {

	public boolean isCorret(String anagramma) {
		
		final String sql = "SELECT nome FROM parola WHERE nome= ?";
		boolean presente=false;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			//settare il PARAMETRO 
			st.setString(1, anagramma);
			

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
//
//				int matricola = rs.getInt("matricola");
//				String nome = rs.getString("nome");
//				String cognome=rs.getString("cognome");
//				String cds=rs.getString("CDS");
//
//				System.out.println("iscrizione matricola:"+matricola+"con nome e cognome:"+nome+cognome+"al corso ");

				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
//				Studente tmp=new Studente(matricola,nome,cognome,cds);
//				studenti.add(tmp);
				presente=true;
			
			}

			conn.close();
			
			return presente;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	
	}
	
	
public boolean isContenuto(String anagramma) {
		
		final String sql = "SELECT nome FROM parola WHERE nome= ?";
		boolean presente=false;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			//settare il PARAMETRO 
			st.setString(1, anagramma);
			

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
//
//				int matricola = rs.getInt("matricola");
//				String nome = rs.getString("nome");
//				String cognome=rs.getString("cognome");
//				String cds=rs.getString("CDS");
//
//				System.out.println("iscrizione matricola:"+matricola+"con nome e cognome:"+nome+cognome+"al corso ");

				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
//				Studente tmp=new Studente(matricola,nome,cognome,cds);
//				studenti.add(tmp);
				presente=true;
			
			}

			conn.close();
			
			return presente;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	
	}
}

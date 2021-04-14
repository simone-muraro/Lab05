package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {

	private AnagrammaDAO anagrammaDao;
	
	public Model() {
		this.anagrammaDao=new AnagrammaDAO();
	}
	
	
	public boolean isCorret(String anagramma) {
		
		return this.anagrammaDao.isCorret(anagramma);
	}

		
		public Set<String> anagrammi(String parola) {

			Set<String> risultato = new HashSet<>() ;
			permuta("", parola, 0, risultato) ; // LANCIA la ricorsione
			// cancella dalla lista le parole non valide (leggendo il dizionario)
			return risultato ;

		}

	
		// lettere = le lettere della parola iniziale che ancora non abbiamo utilizzato
		//           (=== il sotto-problema che dobbiamo risolvere)

		private void permuta(String parziale, String lettere, int livello, Set<String> risultato) {
			if( lettere.length()==0 ) { // caso terminale 
				// la soluzione parziale è anche una soluzione completa!!

				// if(parziale è una parola valida?) {
				risultato.add(parziale) ;
			}  else {
			// fai ricorsione
						// sottoproblema == una lettera (un singolo carattere) di 'lettere'
						for(int pos=0; pos<lettere.length(); pos++) {
							
							char tentativo = lettere.charAt(pos) ; 
							
							String nuovaParziale = parziale + tentativo ;
							String nuovaLettere = lettere.substring(0, pos)+lettere.substring(pos+1) ;
								// togli il carattere pos da lettere
							
							// if (nuovaParziale è un PREFISSO valido di almeno una parola nel dizionario)
							// "aqz" -> no ; "car" -> si (carro, carrello, carta...)
							if(anagrammaDao.isCorret(nuovaParziale))
							permuta(nuovaParziale, nuovaLettere, livello+1, risultato) ;
							
							// Backtracking (NON SERVE)
							// rimetti a posto 'parziale'
							// rimetti a posto 'lettere'
							
						}
					}
				}
				
			}
	


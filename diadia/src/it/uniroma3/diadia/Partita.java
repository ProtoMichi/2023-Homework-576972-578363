package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Stanza stanzaCorrente;
	private boolean finita;
	private Labirinto labirinto;//RIFERIMENTO PER LA CLASSE LABIRINTO
	private Giocatore player;

	public Partita(){
		labirinto=new Labirinto();
		Stanza atrio = new Stanza("Atrio");
		stanzaCorrente = atrio;  
		labirinto.creaLabirinto(atrio);//CREAZIONE DEL LABIRINTO 

		this.finita = false;
		player=new Giocatore();//INIZIALIZZO I CFU 
	}



	/*public Stanza getStanzaVincente() { PRESENTE NELLA CLASSE LABIRINTO
		return stanzaVincente;
	}*/

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== labirinto.getStanzaFinale();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (player.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public Giocatore getPlayer() { //AGGIUNTO PER OTTENERE COSI IL RIFERIMENTO AL GIOCATORE 
		return player;
	}
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	public Giocatore getGiocatore() {
		return player;
	}
}

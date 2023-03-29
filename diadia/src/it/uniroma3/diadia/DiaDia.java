package it.uniroma3.diadia;



import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine","posa","prendi"};

	private Partita partita;

	private IOConsole io;
	public DiaDia(IOConsole console) {
		this.io=console;
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);

		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));

	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if(comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());



		else
			io.mostraMessaggio("COMANDO SCONOSCIUTO");
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getPlayer().getCfu();//I CFU ADESSO LI PRENDE DALLA CLASSE GIOCATORE
			this.partita.getPlayer().setCfu(cfu--);//I CFU LI TOGLIE DALLA CLASSE GIOCATORE
		}
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Borsa:");
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());

	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
	//METODI PRENDI E POSA 	
	private void prendi(String nomeAttrezzo) {
		Attrezzo a = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(nomeAttrezzo==null) {
			io.mostraMessaggio("NON SONO PRESENTI ATTREZZI");
		}else {
			if(a==null) {
				io.mostraMessaggio("ATTREZZO NON PRESENTE ");
			}else {

				this.partita.getGiocatore().getBorsa().addAttrezzo(a);
				this.partita.getStanzaCorrente().removeAttrezzoStanza(a);
				io.mostraMessaggio("ATTREZZO PRESO");
			}
		}

	}


	private void posa(String nomeAttrezzo) {
		if(nomeAttrezzo==null) {
			io.mostraMessaggio("NON HAI NULLA DA POSARE");
		}else{
			if(this.partita.getGiocatore().getBorsa().getPeso()==0) {
				io.mostraMessaggio("LA BORSA E' VUOTA ");
			}else {
				Attrezzo a = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
				this.partita.getStanzaCorrente().addAttrezzo(a);
				this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
				io.mostraMessaggio("ATTREZZO POSATO");
			}

		}

	}
	public static void main(String[] argc) {
		IOConsole console=new IOConsole();
		DiaDia gioco = new DiaDia(console);

		gioco.gioca();
	}
}
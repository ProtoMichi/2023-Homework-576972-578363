package it.uniroma3.diadia.giocatore;

public class Giocatore {
	static final private int CFU_INIZIALI = 20;

	private int cfu_correnti;
	private Borsa borsa;
	public Giocatore() {
		this.cfu_correnti=CFU_INIZIALI;
		borsa=new Borsa(100);

	}

	public int getCfu() {
		return this.cfu_correnti;
	}

	public void setCfu(int cfu) {
		this.cfu_correnti = cfu;		
	}	
	public Borsa getBorsa() {
		return borsa;
	}

}

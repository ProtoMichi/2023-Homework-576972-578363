import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
    //TEST PER IL METODO HASATTREZZO
	@Test
	 public void hasAttrezzoStanza() {
		assertTrue(creazioneAttrezzi("Spada").hasAttrezzo("Spada"));
	}
	@Test
	 public void noHasAttrezzoStanza() {
		assertFalse(creazioneAttrezzi("Spada").hasAttrezzo("lanterna"));
	}
	@Test
	 public void noHasAttrezzoStanzaNull() {
		assertFalse(creazioneAttrezzi("lanterna").hasAttrezzo(null));
	}
	
	
	private Stanza creazioneAttrezzi(String nome) {
		Stanza stanza=new Stanza("n11");
		Attrezzo attrezzo=new Attrezzo(nome,0);
		stanza.addAttrezzo(attrezzo);
		return stanza;
		
	}
	//----------------------------------
	
	//TEST PER IL METODO GETSTANZAADIACENTE
	@Test
	public void stanzaAdiacenteGiustaNord() {
	assertEquals("n11", setStanzaAdiacente().getStanzaAdiacente("nord").getNome());	
	}
	@Test
	public void stanzaAdiacenteDiversa() {
	assertNotEquals("n12", setStanzaAdiacente().getStanzaAdiacente("nord").getNome());	
	}
	@Test
	public void stanzaAdiacenteNull() {
	assertEquals(null, setStanzaAdiacente().getStanzaAdiacente("sud"));	
	}
	private Stanza setStanzaAdiacente() {
		Stanza stanza=new Stanza("n11");
		Stanza stanza2=new Stanza("n12");
		stanza2.impostaStanzaAdiacente("nord", stanza);
		return stanza2;
	}
	//-------------------------------------------------------------
	//TEST DI GETDIREZIONI 
	@Test
	public void direzioniGiuste() {
		String[] direzioni = {"nord","sud"};
		assertTrue(Arrays.equals(direzioni,setDirezioni().getDirezioni()));//equals tra array
	}
	@Test
	public void direzioniSbagliate() {
		String[] direzioni = {"est","sud"};
		assertFalse(Arrays.equals(direzioni,setDirezioni().getDirezioni()));//equals tra array
	}
	@Test
	public void direzioniNull() {
		String[] direzioni = {"est",null};
		assertFalse(Arrays.equals(direzioni,setDirezioni().getDirezioni()));//equals tra array
	}
	
	private Stanza setDirezioni() {
		Stanza stanza=new Stanza("n11");
		Stanza stanza2 = new Stanza("n12");
		stanza.impostaStanzaAdiacente("nord", stanza2);
		stanza.impostaStanzaAdiacente("sud", stanza2);
		return stanza;
		
	}
	//---------------------------------------------------------------
}

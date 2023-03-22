import static org.junit.Assert.*;

import org.junit.Test;

public class StanzaTest {

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

}

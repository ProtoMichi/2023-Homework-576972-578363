import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {

	//FIXTURE
		private Borsa borsa;
		private Borsa borsa2;
		private Attrezzo attrezzo;
		private Attrezzo attrezzo2;
		
		
		
		@Before  //JUNIT5   Before in JUNIT 4
		public void setUp() {  //DEVE ESSERE PUBLIC 
			this.borsa= new Borsa();
			this.borsa2= new Borsa();
			
			this.attrezzo=new Attrezzo("lanterna",5);
		    this.borsa.addAttrezzo(attrezzo);
		    this.attrezzo2=new Attrezzo("osso",0);
		    this.borsa2.addAttrezzo(attrezzo2);
	
		}
		
		@Test
		public void test_getAttrezzo() {
			assertSame(attrezzo,borsa.getAttrezzo("lanterna"));
			assertNotSame(null,borsa2.getAttrezzo("osso"));
			
		}

}

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;


public class GiocatoreTest {
	//FIXTURE
	private Giocatore player;
	private Giocatore player2;
	
	
	@Before  //JUNIT5   Before in JUNIT 4
	public void setUp() {  //DEVE ESSERE PUBLIC 
		this.player= new Giocatore();
	    this.player2= new Giocatore();
	    this.player.setCfu(5);
	    this.player2.setCfu(51);
	}
	@Test
	public void test_Get_cfu() {
        assertEquals(5,this.player.getCfu());
        assertEquals(51,this.player2.getCfu());
        
	}
	
	




}

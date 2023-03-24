package diadia.src;
import static org.junit.Assert.*;
import org.junit.Test;
public class PartitaTest {
/*funzione che verifica la memorizzazione di una stanza corrente*/
@Test
public void testSetStanzaCorrente() {
    Partita partita1= new Partita();                                                              //creo una nuova partita per fare la verifica
    Stanza atrio=new Stanza("Atrio");                                                             //creo una nuova stanza da mettere come stanza adiacente                     //stringa stampata in caso di problemi
    partita1.setStanzaCorrente(atrio);
assertEquals(atrio,partita1.getStanzaCorrente());                                     //verifico che l'indirizzo del riferimento all'oggetto sia lo stesso dell'oggetto                                            //verifico che l'indirizzo non sia a null
}
/*funzione che verifica che la stanza corrente non sia impostata a null*/
@Test
public void testNotNullSetStanzaCorrente() {
	Partita m=new Partita();                                                                         //creo una nuova partita per fare la verifica
	String frase="La stanza corrente punta a null verifica che sia tutto ok";                        //messaggio di errore in caso di problemi
	assertNotNull(frase,m.getStanzaCorrente()); 	                                                 //verifico che il riferimento all'oggetto non sia null
}
/*funzione che verifica se la stanza corrente non sia null altrimenti non potrei ottenere la stanza corrente*/
@Test
public void testGetStanzaCorrente() {
    Partita partita2=new Partita();                                                                  //creo una nuova partita per fare la verifica
    String frase="Attenzione verifica che setStanzaCorrente non sia null";                           //messaggio di errore in caso di problemi
   assertNotNull(frase,partita2.getStanzaCorrente());                                                //verifico che il riferimento all'oggetto non sia null
}
/*Funzione da rivedere*
@Test
public void testVinta() {
    Partita nuova=new Partita();
    Stanza biblioteca=new Stanza("Biblioteca");
    nuova.setStanzaCorrente(biblioteca);
    assertTrue(nuova.vinta());
}
*/

@Test
public void testNotVinta() {
    Partita numero1=new Partita();
    assertFalse(numero1.vinta());
}
@Test
public void testIsFinita() {
    Partita prova=new Partita();
    prova.setFinita();
    assertTrue("Attenzione Cfu Finita e vinta sono false controlla se sono inizializzate correttamente",prova.isFinita());
}

@Test
public void testNotIsFinita() {
    Partita prova=new Partita();
    assertFalse("Attenzione Cfu Finita e vinta possono essere almeno una di esse vere controlla se sono inizializzate correttamente",prova.isFinita());
}
}

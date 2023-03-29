import static org.junit.Assert.*;
import org.junit.Test;
public class LabirintoTest{
 /*funzione che verifica se creaLabirinto prende come parametro null e per cui non posso creare la stanza*/
  @Test
  public void testCreaLabirintoNotNull(){
  Stanza atrio=null;
  Labirinto n1;
  assertNotNull("Attenzione hai passato alla funzione un parametro null controlla che sia tutto ok",n1.creaLabirinto(atrio));  //se da errore mi scrive la stringa 
}
  /*funzione che verifica se il parametro Stanza di creaLabirinto è proprio l'atrio*/
  @Test
  public void testCreaLabirintoIsAtrio(){
  Stanza atrio=new Stanza("Atrio");
  Labirinto n2;
  assertEquals("Attenzione la stanza iniziale impostata non è l'atrio per cui il labirinto creato è sbagliato",atrio.getStanzaIniziale(),n2.creaLabirinto(atrio).getStanzaIniziale()); //stampa stringa se c'è errore
  }
  /*Funzione che verifica se la stanza iniziale è l'atrio*/
 @Test
 public void getStanzaIniziale(){
  Stanza atrio=new Stanza("Atrio");
   Labirinto n2;
   assertEquals("Attenzione la stanza iniziale impostata non è l'atrio per cui il labirinto creato è sbagliato",atrio.getStanzainiziale(),n2.creaLabirinto(atrio).getStanzaIniziale());  //stampa stringa se c'è errore
}
   /*Funzione che verifica se la stanza iniziale è null*/
  @Test
 public void getStanzaInizialeNotNull(){
  Stanza atrio=null;
  assertNotNull("Attenzione la stanza è stata inizializzata a null",atrio.getStanzaIniziale()) //stampa stringa se c'è errore
}
  
  /*Funzione che verifica se la stanza iniziale è null*/
  @Test
 public void getStanzaFinale(){
  Stanza biblioteca=new Stanza("Biblioteca");
   Labirinto n3;
  assertEquals("La stanza finale non è la biblioteca ricontrolla se tutto ok",n3.creaLabirinto(biblioteca).getStanzaFinale(),biblioteca.getStanzaFinale()) //stampa stringa se c'è errore
}
  /*Funzione che verifica se la stanza iniziale è null*/
  @Test
 public void getStanzaFinaleNotNull(){
  Stanza biblioteca=null;
  assertNotNull("Attenzione la stanza è stata inizializzata a null",biblioteca.getStanzaFinale()) //stampa stringa se c'è errore
}

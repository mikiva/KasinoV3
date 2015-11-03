package data_TEST;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class cardTest {

	Card c;
	Deck deck;
	
	
	@Before
	public void setUp() throws Exception {
		
		
		c = new Card(2, "Spades", 0);
		deck = new Deck();
		
	}

	@Test
	public void testValueCard(){
		
		
		assertEquals("Wrong Deck size",52, deck.getDeck().size());
		
		assertEquals("Wrong value", 8, deck.getDeck().get(25).getValue());
		
		
	}
	
	@Test
	public void testDrawCards(){
		
		for (int i = 0; i < 5; i++) {
			deck.drawCard();
		}
		
		assertEquals("Error", 47, deck.getDeck().size());
		
		
	}

}

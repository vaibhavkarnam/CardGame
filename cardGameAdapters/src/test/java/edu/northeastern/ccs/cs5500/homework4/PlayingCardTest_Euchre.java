package edu.northeastern.ccs.cs5500.homework4;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;


/**
 * The Class PlayingCardTest_Euchre tests the functionality provided by the EuchreDeckImpl Class.
 * 
 * @author vaibhav
 */
public class PlayingCardTest_Euchre {
	

	/** The ace. */
	final String ACE = "Ace";
	
	/** The spade. */
	final String SPADE = "Spade";
	
	/** The diamond. */
	final String DIAMOND = "Diamond";
	
	/** The club. */
	final String CLUB = "Club";
	
	/** The heart. */
	final String HEART = "Heart";
	
	/** The spadesymbol. */
	final Character SPADESYMBOL = '\u2660';
	
	/** The diamondsymbol. */
	final Character DIAMONDSYMBOL = '\u2666';
	
	/** The clubsymbol. */
	final Character CLUBSYMBOL = '\u2663';
	
	/** The heartsymbol. */
	final Character HEARTSYMBOL = '\u2764';
	
	/** The spade count. */
	int spadeCount = 0;
	
	/** The diamond count. */
	int diamondCount = 0;
	
	/** The club count. */
	int clubCount = 0;
	
	/** The heart count. */
	int heartCount = 0;
	
	/** The face cards array*/
	String faceCardsArray[] = {"Jack","Queen","King","Ace"};
	
	/** The suit cards array. */
	String suitCardsArray[] = {"Spade", "Diamond", "Club", "Heart"};
	
	/** The ranks */
	String cards[] = {"Two","Three","Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
	
	/** The deck of cards. */
	String deckOfCards[] = {"Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
			,"Queen Diamond", "Queen Club", "Queen Heart","King Spade", "King Diamond", "King Club", 
			"King Heart","Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart","Nine Spade", "Nine Diamond",
			"Nine Club", "Nine Heart", "Ten Spade", "Ten Diamond","Ten Club", "Ten Heart"};
	
	/** The deck sorted by rank. */
	String deckSortedByRank[] = {"Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart","Nine Spade", "Nine Diamond", "Nine Club", "Nine Heart", "Ten Spade", "Ten Diamond", 
			"Ten Club", "Ten Heart","Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
			,"Queen Diamond", "Queen Club", "Queen Heart","King Spade", "King Diamond", "King Club", 
			"King Heart"};
	
	/** The deck sorted by both suit and rank. */
	String deckSortedByBothSuitAndRank[] = {"Ace Spade","Nine Spade","Ten Spade","Jack Spade", "Queen Spade",
			"King Spade","Ace Club","Nine Club","Ten Club","Jack Club","Queen Club","King Club",
			"Ace Diamond","Nine Diamond","Ten Diamond","Jack Diamond","Queen Diamond","King Diamond",
			"Ace Heart","Nine Heart","Ten Heart","Jack Heart","Queen Heart","King Heart"};
	
	/** The deck sorted by suit. */
	String deckSortedBySuit[] = {"Jack Club","Queen Club","King Club","Ace Club","Nine Club","Ten Club","Jack Diamond",
			"Queen Diamond","King Diamond","Ace Diamond","Nine Diamond","Ten Diamond","Jack Heart","Queen Heart",
			"King Heart","Ace Heart","Nine Heart","Ten Heart",
			"Jack Spade", "Queen Spade", "King Spade","Ace Spade","Nine Spade",
			"Ten Spade"};
	
	/** The cut deck. */
	String cutDeck[] = {"Queen Heart","King Spade", "King Diamond", "King Club", 
			"King Heart","Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart","Nine Spade", "Nine Diamond",
			"Nine Club", "Nine Heart", "Ten Spade", "Ten Diamond","Ten Club", "Ten Heart","Jack Spade", 
			"Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade","Queen Diamond", "Queen Club"};

	
	
	/** The euchre deck. */
	Deck euchreDeck;
	
	/**Instantiate a deck factory to create decks **/
	DeckFactory deckFactory = new DeckFactory();
	
	/**Set decktype **/
	final String deckType= "Euchre";
	
	/**
	 * Setup executed before tests
	 */
	@Before
	public void setup()
	{
		euchreDeck = deckFactory.createDeckFactory(deckType);
		
	}
	
	
	
	/**
	 * Checks if the deck is created correctly, deck has the right cards
	 *  in it and the right number of cards.
	 *  The expected cards are represented as a String of Rank and Suit names. 
	 *  A correctly constructed deck is represented as an array of such cards
	 *  The actual constructed deck is converted into an array of String where
	 *  each card in the deck is represented as a String.
	 *  The two arrays are then compared to establish if the deck is created correctly.
	 *  The size of the deck is also validated
	 */
	@Test
	   public void deck_Equal() {
		
		Card[] actualDeckArray = new Card[euchreDeck.getDeck().size()];
		actualDeckArray = euchreDeck.getDeck().toArray(actualDeckArray);
		 		
				for(int i=0;i<Array.getLength(actualDeckArray);i++)
				{
					assertEquals(deckOfCards.length,actualDeckArray.length);
					assertEquals(deckOfCards[i],actualDeckArray[i].toString());
					
				}		
		
		assertEquals(24,euchreDeck.getDeck().size());
		
		}
	
	/**
	 * Checks if Shuffled deck not equal to the deck before it was shuffled.
	 */
	@Test
		public void shuffled_Deck_NotEqual()
		{
			List<Card> copiedDeck = euchreDeck.getDeck().stream()
					  .collect(Collectors.toList());
			euchreDeck.shuffle();
			assertNotEquals(euchreDeck,copiedDeck);
			
		}
	
	/**
	 * Checks if the deck is sorted correctly by rank
	 * The expected cards are represented as a String of Rank and Suit names. 
	 *  A correctly constructed sorted deck is represented as an array of such cards
	 *  The actual constructed deck is converted into an array of String where
	 *  each card in the deck is represented as a String.
	 *  The two arrays are then compared to establish if the deck was sorted correctly by rank.
	 */
	@Test
	public void sortedDeck_ByRank_Equal()
	{
		euchreDeck.sort("Rank");
		Card[] actualDeckArray = new Card[euchreDeck.getDeck().size()];
		actualDeckArray = euchreDeck.getDeck().toArray(actualDeckArray);
		 		
				for(int i=0;i<Array.getLength(actualDeckArray);i++)
				{
					assertEquals(deckSortedByRank[i],actualDeckArray[i].toString());
					
				}				
	}
	
	/**
	 * Checks if the deck is sorted by suit .
	 * The cards with same suit are grouped together.
	 * The expected cards are represented as a String of Rank and Suit names. 
	 *  A correctly constructed sorted deck is represented as an array of such cards
	 *  The actual constructed deck is converted into an array of String where
	 *  each card in the deck is represented as a String.
	 *  The two arrays are then compared to establish if the deck was sorted correctly by suits.
	 */
	@Test
	public void sortedDeck_BySuit_Equal()
	{
		euchreDeck.sort("Suit");
		Card[] actualDeckArray = new Card[euchreDeck.getDeck().size()];
		actualDeckArray = euchreDeck.getDeck().toArray(actualDeckArray);
		 		
				for(int i=0;i<Array.getLength(actualDeckArray);i++)
				{
					assertEquals(deckSortedBySuit[i],actualDeckArray[i].toString());
					
				}				
	}
	
	/**
	 * Checks if deck is sorted by both suit and rank.
	 * The cards with same suit are grouped together and cards within each group of suits are
	 * sorted by rank
	 * The expected cards are represented as a String of Rank and Suit names. 
	 * A correctly constructed sorted deck is represented as an array of such cards
	 * The actual constructed deck is converted into an array of String where
	 * each card in the deck is represented as a String.
	 * The two arrays are then compared to establish if the deck was sorted correctly by 
	 * rank and suits.
	 */
	@Test
	public void sortedDeck_ByBothSuitAndRank_Equal()
	{
		euchreDeck.sort("both");
		Card[] actualDeckArray = new Card[euchreDeck.getDeck().size()];
		actualDeckArray = euchreDeck.getDeck().toArray(actualDeckArray);
		 		
				for(int i=0;i<Array.getLength(actualDeckArray);i++)
				{
					assertEquals(deckSortedByBothSuitAndRank[i],actualDeckArray[i].toString());
					
				}		
		
	}
	
	/**
	 * Checks if a deck after being cut is in the right order.
	 * The expected cards are represented as a String of Rank and Suit names. 
	 * A correctly constructed cut deck is represented as an array of such cards
	 * The actual constructed deck is converted into an array of String where
	 * each card in the deck is represented as a String.
	 * The two arrays are then compared to establish if the deck after being cut
	 * is in right order
	 * 
	 */
	@Test
	public void cutDeckArray_Euchre_Equal()
	{
		euchreDeck.cut(7);
		Card[] actualDeckArray = new Card[euchreDeck.getDeck().size()];
		actualDeckArray = euchreDeck.getDeck().toArray(actualDeckArray);
		 		
				for(int i=0;i<Array.getLength(actualDeckArray);i++)
				{
					assertEquals(cutDeck[i],actualDeckArray[i].toString());
					
				}	
		
	}
	
	/**
	 * Checks if a deck after being cut is in the right order.
	 * The cut deck at point cutPoint if cut again at point deck.size - cutPoint
	 * Should result in the original deck
	 */
	@Test
	public void cutDeck_Euchre_Equal()
	{
		final int cutPoint = 7;
		Deck copyDeck = new EuchreDeckImpl();
		
		euchreDeck.cut(cutPoint);
		euchreDeck.cut(euchreDeck.getDeck().size()-cutPoint);
		assertEquals(copyDeck,euchreDeck);
	}
	
	
	/**
	 * Checks if the correct card was pulled from the deck.
	 */
	@Test
	public void pullCard_Euchre_Equal()
	{
		final String pulledCard = "Ten Heart";
		assertEquals(pulledCard,euchreDeck.pullCard().toString());
	}
	
	/**
	 * Checks that the deck after a card is pulled has one less card than before that card was pulled
	 * and the card should no longer be present in the deck
	 * The expected cards are represented as a String of Rank and Suit names. 
	 * A correctly constructed cut deck without the pulled card is represented as an array of such cards
	 * The actual constructed deck is converted into an array of String where
	 * each card in the deck is represented as a String.
	 * The two arrays are then compared to establish if the pulled card is present in the deck or not
	 */
	@Test
	public void pulledCardRemoved_Euchre_Equal()
	{
		Deck euchreDeck = new EuchreDeckImpl();	
		Deck copiedDeck = new EuchreDeckImpl();
		Card pulledCard = euchreDeck.pullCard();
		
		Card[] actualDeckArray = new Card[euchreDeck.getDeck().size()];
		actualDeckArray = euchreDeck.getDeck().toArray(actualDeckArray);
		 		
				for(int i=0;i<Array.getLength(actualDeckArray);i++)
				{
					assertEquals("Ten Heart",pulledCard.toString());
					assertFalse(euchreDeck.getDeck().contains(pulledCard));
					assertEquals(copiedDeck.getDeck().size()-1,euchreDeck.getDeck().size());
				}	
	}
	
	/**
	 * Checks if an empty deck is empty
	 * Removes all the cards in the current deck and checks if it is empty
	 */
	@Test
	public void emptyDeck_Euchre_Equal()
	{
		
		assertFalse(euchreDeck.emptyDeck());
		while(!euchreDeck.emptyDeck())
		{
			euchreDeck.pullCard();	
		}
		assertTrue(euchreDeck.emptyDeck());
	
	}


}

package problem1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import problem1.Card;
import problem1.Deck;
import problem1.VegasDeckImpl;
/**
 * The Class PlayingCardTest_Vegas tests functionality implemented by VegasDeckImpl.
 */
public class PlayingCardTest_Vegas {
	

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
	
	/** The face cards array. */
	String faceCardsArray[] = {"Jack","Queen","King","Ace"};
	
	/** The suit cards array. */
	String suitCardsArray[] = {"Spade", "Diamond", "Club", "Heart"};
	
	/** The cards. */
	String cards[] = {"Two","Three","Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
	
	/** The deck of cards. */
	String deckOfCards[] = {"Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
			,"Queen Diamond", "Queen Club", "Queen Heart","King Spade", "King Diamond", "King Club", 
			"King Heart","Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart", "Two Spade", "Two Diamond",
			"Two Club", "Two Heart", "Three Spade", "Three Diamond", "Three Club", "Three Heart",
			"Four Spade", "Four Diamond", "Four Club", "Four Heart","Five Spade", "Five Diamond", 
			"Five Club", "Five Heart", "Six Spade", "Six Diamond", "Six Club", "Six Heart", "Seven Spade", 
			"Seven Diamond", "Seven Club", "Seven Heart","Eight Spade", "Eight Diamond", "Eight Club",
			"Eight Heart","Nine Spade", "Nine Diamond", "Nine Club", "Nine Heart", "Ten Spade", "Ten Diamond", 
			"Ten Club", "Ten Heart","Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
			,"Queen Diamond", "Queen Club", "Queen Heart","King Spade", "King Diamond", "King Club", 
			"King Heart","Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart", "Two Spade", "Two Diamond",
			"Two Club", "Two Heart", "Three Spade", "Three Diamond", "Three Club", "Three Heart",
			"Four Spade", "Four Diamond", "Four Club", "Four Heart","Five Spade", "Five Diamond", 
			"Five Club", "Five Heart", "Six Spade", "Six Diamond", "Six Club", "Six Heart", "Seven Spade", 
			"Seven Diamond", "Seven Club", "Seven Heart","Eight Spade", "Eight Diamond", "Eight Club",
			"Eight Heart","Nine Spade", "Nine Diamond", "Nine Club", "Nine Heart", "Ten Spade", "Ten Diamond", 
			"Ten Club", "Ten Heart","Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
			,"Queen Diamond", "Queen Club", "Queen Heart","King Spade", "King Diamond", "King Club", 
			"King Heart","Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart", "Two Spade", "Two Diamond",
			"Two Club", "Two Heart", "Three Spade", "Three Diamond", "Three Club", "Three Heart",
			"Four Spade", "Four Diamond", "Four Club", "Four Heart","Five Spade", "Five Diamond", 
			"Five Club", "Five Heart", "Six Spade", "Six Diamond", "Six Club", "Six Heart", "Seven Spade", 
			"Seven Diamond", "Seven Club", "Seven Heart","Eight Spade", "Eight Diamond", "Eight Club",
			"Eight Heart","Nine Spade", "Nine Diamond", "Nine Club", "Nine Heart", "Ten Spade", "Ten Diamond", 
			"Ten Club", "Ten Heart"};
	
	/** The deck sorted by rank. */
	String deckSortedByRank[] = {"Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart", "Ace Spade", 
			"Ace Diamond", "Ace Club", "Ace Heart","Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart",
			"Two Spade", "Two Diamond","Two Club", "Two Heart","Two Spade", "Two Diamond","Two Club", 
			"Two Heart", "Two Spade", "Two Diamond","Two Club", "Two Heart","Three Spade", "Three Diamond", 
			"Three Club", "Three Heart","Three Spade", "Three Diamond", "Three Club", "Three Heart",
			"Three Spade", "Three Diamond", "Three Club", "Three Heart","Four Spade", "Four Diamond",
			"Four Club", "Four Heart","Four Spade", "Four Diamond","Four Club", "Four Heart","Four Spade",
			"Four Diamond","Four Club", "Four Heart","Five Spade", "Five Diamond", "Five Club", "Five Heart",
			"Five Spade", "Five Diamond", "Five Club", "Five Heart","Five Spade", "Five Diamond", "Five Club",
			"Five Heart","Six Spade", "Six Diamond", "Six Club", "Six Heart", "Six Spade", "Six Diamond",
			"Six Club", "Six Heart","Six Spade", "Six Diamond", "Six Club", "Six Heart","Seven Spade", 
			"Seven Diamond", "Seven Club", "Seven Heart","Seven Spade", "Seven Diamond", "Seven Club", 
			"Seven Heart","Seven Spade", "Seven Diamond", "Seven Club", "Seven Heart","Eight Spade", 
			"Eight Diamond", "Eight Club","Eight Heart","Eight Spade","Eight Diamond", "Eight Club","Eight Heart",
			"Eight Spade", "Eight Diamond", "Eight Club","Eight Heart","Nine Spade", "Nine Diamond",
			"Nine Club", "Nine Heart", "Nine Spade", "Nine Diamond", "Nine Club", "Nine Heart","Nine Spade",
			"Nine Diamond", "Nine Club", "Nine Heart","Ten Spade", "Ten Diamond", "Ten Club", "Ten Heart",
			"Ten Spade", "Ten Diamond","Ten Club","Ten Heart","Ten Spade", "Ten Diamond", "Ten Club",
			"Ten Heart","Jack Spade", "Jack Diamond", "Jack Club","Jack Heart","Jack Spade", "Jack Diamond", 
			"Jack Club","Jack Heart","Jack Spade", "Jack Diamond", "Jack Club","Jack Heart", "Queen Spade",
			"Queen Diamond", "Queen Club","Queen Heart", "Queen Spade","Queen Diamond", "Queen Club",
			"Queen Heart", "Queen Spade","Queen Diamond", "Queen Club", "Queen Heart","King Spade",
			"King Diamond", "King Club", "King Heart","King Spade","King Diamond", "King Club","King Heart",
			"King Spade", "King Diamond", "King Club", "King Heart"};
	
	/** The deck sorted by both suit and rank. */
	String deckSortedByBothSuitAndRank[] = {"Ace Spade","Ace Spade","Ace Spade","Two Spade","Two Spade"
			,"Two Spade","Three Spade","Three Spade","Three Spade","Four Spade","Four Spade","Four Spade"
			,"Five Spade","Five Spade","Five Spade","Six Spade","Six Spade","Six Spade","Seven Spade"
			,"Seven Spade","Seven Spade","Eight Spade","Eight Spade","Eight Spade","Nine Spade","Nine Spade"
			,"Nine Spade","Ten Spade","Ten Spade","Ten Spade","Jack Spade","Jack Spade","Jack Spade","Queen Spade"
			,"Queen Spade","Queen Spade","King Spade","King Spade","King Spade","Ace Club","Ace Club","Ace Club"
			,"Two Club","Two Club","Two Club","Three Club","Three Club","Three Club","Four Club","Four Club"
			,"Four Club","Five Club","Five Club","Five Club","Six Club","Six Club","Six Club","Seven Club"
			,"Seven Club","Seven Club","Eight Club","Eight Club","Eight Club","Nine Club","Nine Club","Nine Club"
			,"Ten Club","Ten Club","Ten Club","Jack Club","Jack Club","Jack Club","Queen Club","Queen Club"
			,"Queen Club","King Club","King Club","King Club","Ace Diamond","Ace Diamond","Ace Diamond"
			,"Two Diamond","Two Diamond","Two Diamond","Three Diamond","Three Diamond","Three Diamond"
			,"Four Diamond","Four Diamond","Four Diamond","Five Diamond","Five Diamond","Five Diamond"
			,"Six Diamond","Six Diamond","Six Diamond","Seven Diamond","Seven Diamond","Seven Diamond"
			,"Eight Diamond","Eight Diamond","Eight Diamond","Nine Diamond","Nine Diamond","Nine Diamond"
			,"Ten Diamond","Ten Diamond","Ten Diamond","Jack Diamond","Jack Diamond","Jack Diamond","Queen Diamond"
			,"Queen Diamond","Queen Diamond","King Diamond","King Diamond","King Diamond","Ace Heart","Ace Heart"
			,"Ace Heart","Two Heart","Two Heart","Two Heart","Three Heart","Three Heart","Three Heart","Four Heart"
			,"Four Heart","Four Heart","Five Heart","Five Heart","Five Heart","Six Heart","Six Heart"
			,"Six Heart","Seven Heart","Seven Heart","Seven Heart","Eight Heart","Eight Heart","Eight Heart"
			,"Nine Heart","Nine Heart","Nine Heart","Ten Heart","Ten Heart","Ten Heart","Jack Heart"
			,"Jack Heart","Jack Heart","Queen Heart","Queen Heart","Queen Heart","King Heart"
			,"King Heart","King Heart"};
	
	/** The deck sorted by suit. */
	String deckSortedBySuit[] = {"Jack Spade", "Queen Spade", "King Spade","Ace Spade","Two Spade",
			"Three Spade","Four Spade","Five Spade","Six Spade","Seven Spade","Eight Spade","Nine Spade",
			"Ten Spade","Jack Spade", "Queen Spade", "King Spade","Ace Spade","Two Spade",
			"Three Spade","Four Spade","Five Spade","Six Spade","Seven Spade","Eight Spade","Nine Spade",
			"Ten Spade","Jack Spade", "Queen Spade", "King Spade","Ace Spade","Two Spade",
			"Three Spade","Four Spade","Five Spade","Six Spade","Seven Spade","Eight Spade","Nine Spade",
			"Ten Spade","Jack Club","Queen Club","King Club","Ace Club","Two Club","Three Club","Four Club",
			"Five Club","Six Club","Seven Club","Eight Club","Nine Club","Ten Club","Jack Club","Queen Club",
			"King Club","Ace Club","Two Club","Three Club","Four Club","Five Club","Six Club","Seven Club",
			"Eight Club","Nine Club","Ten Club","Jack Club","Queen Club","King Club","Ace Club","Two Club",
			"Three Club","Four Club","Five Club","Six Club","Seven Club","Eight Club","Nine Club","Ten Club",
			"Jack Diamond","Queen Diamond","King Diamond","Ace Diamond","Two Diamond","Three Diamond",
			"Four Diamond","Five Diamond","Six Diamond","Seven Diamond","Eight Diamond","Nine Diamond",
			"Ten Diamond","Jack Diamond","Queen Diamond","King Diamond","Ace Diamond","Two Diamond",
			"Three Diamond","Four Diamond","Five Diamond","Six Diamond","Seven Diamond","Eight Diamond",
			"Nine Diamond","Ten Diamond","Jack Diamond","Queen Diamond","King Diamond","Ace Diamond",
			"Two Diamond","Three Diamond","Four Diamond","Five Diamond","Six Diamond","Seven Diamond",
			"Eight Diamond","Nine Diamond","Ten Diamond","Jack Heart","Queen Heart","King Heart","Ace Heart",
			"Two Heart","Three Heart","Four Heart","Five Heart","Six Heart","Seven Heart","Eight Heart",
			"Nine Heart","Ten Heart","Jack Heart","Queen Heart","King Heart","Ace Heart","Two Heart",
			"Three Heart","Four Heart","Five Heart","Six Heart","Seven Heart","Eight Heart","Nine Heart"
			,"Ten Heart","Jack Heart","Queen Heart","King Heart","Ace Heart","Two Heart","Three Heart",
			"Four Heart","Five Heart","Six Heart","Seven Heart","Eight Heart","Nine Heart","Ten Heart"};
	
	/** The cut deck. */
	String cutDeck[] = {"Ace Diamond", "Ace Club", "Ace Heart", "Two Spade", "Two Diamond",
			"Two Club", "Two Heart", "Three Spade", "Three Diamond", "Three Club", "Three Heart",
			"Four Spade", "Four Diamond", "Four Club", "Four Heart","Five Spade", "Five Diamond", 
			"Five Club", "Five Heart", "Six Spade", "Six Diamond", "Six Club", "Six Heart", "Seven Spade", 
			"Seven Diamond", "Seven Club", "Seven Heart","Eight Spade", "Eight Diamond", "Eight Club",
			"Eight Heart","Nine Spade", "Nine Diamond", "Nine Club", "Nine Heart", "Ten Spade", "Ten Diamond", 
			"Ten Club", "Ten Heart","Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
			,"Queen Diamond", "Queen Club", "Queen Heart","King Spade", "King Diamond", "King Club", 
			"King Heart","Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart", "Two Spade", "Two Diamond",
			"Two Club", "Two Heart", "Three Spade", "Three Diamond", "Three Club", "Three Heart",
			"Four Spade", "Four Diamond", "Four Club", "Four Heart","Five Spade", "Five Diamond", 
			"Five Club", "Five Heart", "Six Spade", "Six Diamond", "Six Club", "Six Heart", "Seven Spade", 
			"Seven Diamond", "Seven Club", "Seven Heart","Eight Spade", "Eight Diamond", "Eight Club",
			"Eight Heart","Nine Spade", "Nine Diamond", "Nine Club", "Nine Heart", "Ten Spade", "Ten Diamond", 
			"Ten Club", "Ten Heart","Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
			,"Queen Diamond", "Queen Club", "Queen Heart","King Spade", "King Diamond", "King Club", 
			"King Heart","Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart", "Two Spade", "Two Diamond",
			"Two Club", "Two Heart", "Three Spade", "Three Diamond", "Three Club", "Three Heart",
			"Four Spade", "Four Diamond", "Four Club", "Four Heart","Five Spade", "Five Diamond", 
			"Five Club", "Five Heart", "Six Spade", "Six Diamond", "Six Club", "Six Heart", "Seven Spade", 
			"Seven Diamond", "Seven Club", "Seven Heart","Eight Spade", "Eight Diamond", "Eight Club",
			"Eight Heart","Nine Spade", "Nine Diamond", "Nine Club", "Nine Heart", "Ten Spade", "Ten Diamond", 
			"Ten Club", "Ten Heart","Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
			,"Queen Diamond", "Queen Club", "Queen Heart","King Spade", "King Diamond", "King Club", 
			"King Heart","Ace Spade"};


	
	
	/** The vegas deck. */
	Deck vegasDeck;

	
	/**
	 * Setup exected before tests
	 */
	@Before
	public void setup()
	{
		vegasDeck = new VegasDeckImpl(3);	
		
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
		
		Card[] actualDeckArray = new Card[vegasDeck.getDeck().size()];
		actualDeckArray = vegasDeck.getDeck().toArray(actualDeckArray);
		 		
				for(int i=0;i<Array.getLength(actualDeckArray);i++)
				{
					assertEquals(deckOfCards.length,actualDeckArray.length);
					assertEquals(deckOfCards[i],actualDeckArray[i].toString());
					
				}		
		
		assertEquals(156,vegasDeck.getDeck().size());
		
		}
	
	/**
	 * Checks if Shuffled deck not equal to the deck before it was shuffled.
	 */
	@Test
		public void shuffled_Deck_NotEqual()
		{
			List<Card> copiedDeck = vegasDeck.getDeck().stream()
					  .collect(Collectors.toList());
			vegasDeck.shuffle();
			assertNotEquals(vegasDeck,copiedDeck);
			
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
		vegasDeck.sort("Rank");
		Card[] actualDeckArray = new Card[vegasDeck.getDeck().size()];
		actualDeckArray = vegasDeck.getDeck().toArray(actualDeckArray);
		 		
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
		vegasDeck.sort("Suit");
		Card[] actualDeckArray = new Card[vegasDeck.getDeck().size()];
		actualDeckArray = vegasDeck.getDeck().toArray(actualDeckArray);
		 		
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
		vegasDeck.sort("both");
		Card[] actualDeckArray = new Card[vegasDeck.getDeck().size()];
		actualDeckArray = vegasDeck.getDeck().toArray(actualDeckArray);
		 		
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
	public void cutDeckArray_Vegas_Equal()
	{
		vegasDeck.cut(13);
		Card[] actualDeckArray = new Card[vegasDeck.getDeck().size()];
		actualDeckArray = vegasDeck.getDeck().toArray(actualDeckArray);
		 		
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
	public void cutDeck_Vegas_Equal()
	{
		final int cutPoint = 13;
		Deck copyDeck = new VegasDeckImpl(3);
		
		vegasDeck.cut(cutPoint);
		vegasDeck.cut(vegasDeck.getDeck().size()-cutPoint);
		assertEquals(copyDeck,vegasDeck);
	}
	
	
	/**
	 * Checks if the correct card was pulled from the deck.
	 */
	@Test
	public void pullCard_Vegas_Equal()
	{
		
		final String pulledCard = "King Heart";
		vegasDeck.sort("both");
		assertEquals(pulledCard,vegasDeck.pullCard().toString());
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
	public void pulledCardRemoved_Vegas_Equal()
	{
		Deck vegasDeck = new VegasDeckImpl();	
		Deck copiedDeck = new VegasDeckImpl();
		vegasDeck.sort("both");
		Card pulledCard = vegasDeck.pullCard();
		
		Card[] actualDeckArray = new Card[vegasDeck.getDeck().size()];
		actualDeckArray = vegasDeck.getDeck().toArray(actualDeckArray);
		 		
				for(int i=0;i<Array.getLength(actualDeckArray);i++)
				{
					assertEquals("King Heart",pulledCard.toString());
					assertTrue(vegasDeck.getDeck().contains(pulledCard));
					assertEquals(copiedDeck.getDeck().size()-1,vegasDeck.getDeck().size());
				}	
		}
	
	/**
	 * Checks if an empty deck is empty
	 * Removes all the cards in the current deck and checks if it is empty
	 */
	@Test
	public void emptyDeck_Vegas_Equal()
	{
		
		assertFalse(vegasDeck.emptyDeck());
		while(!vegasDeck.emptyDeck())
		{
			vegasDeck.pullCard();	
		}
		assertTrue(vegasDeck.emptyDeck());
	
	}


}

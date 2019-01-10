package problem1;

import org.junit.*;

import problem1.Card;
import problem1.CardImpl;
import problem1.Deck;
import problem1.Rank;
import problem1.RankImpl;
import problem1.StandardDeckImpl;
import problem1.Suit;
import problem1.SuitImpl;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Class PlayingCardTest_Standard tests functionality implemented by StandardDeckImpl
 */
public class PlayingCardTest_Standard {

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
	
	/** The pips array. */
	int pipsArray[] = {0,0,0,0,0,0,0,0,0,0,0,0
			,1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,
			5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,
			10,10,10,10};
	
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
			"Ten Club", "Ten Heart"};
	
	/** The deck sorted by rank. */
	String deckSortedByRank[] = {"Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart", "Two Spade", "Two Diamond",
			"Two Club", "Two Heart", "Three Spade", "Three Diamond", "Three Club", "Three Heart",
			"Four Spade", "Four Diamond", "Four Club", "Four Heart","Five Spade", "Five Diamond", 
			"Five Club", "Five Heart", "Six Spade", "Six Diamond", "Six Club", "Six Heart", "Seven Spade", 
			"Seven Diamond", "Seven Club", "Seven Heart","Eight Spade", "Eight Diamond", "Eight Club",
			"Eight Heart","Nine Spade", "Nine Diamond", "Nine Club", "Nine Heart", "Ten Spade", "Ten Diamond", 
			"Ten Club", "Ten Heart","Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
			,"Queen Diamond", "Queen Club", "Queen Heart","King Spade", "King Diamond", "King Club", 
			"King Heart"};
	
	/** The deck sorted by both suit and rank. */
	String deckSortedByBothSuitAndRank[] = {"Ace Spade","Two Spade","Three Spade","Four Spade","Five Spade","Six Spade"
			,"Seven Spade","Eight Spade","Nine Spade","Ten Spade","Jack Spade", "Queen Spade", "King Spade",
			"Ace Club","Two Club","Three Club","Four Club","Five Club","Six Club","Seven Club",
			"Eight Club","Nine Club","Ten Club","Jack Club","Queen Club","King Club","Ace Diamond","Two Diamond","Three Diamond","Four Diamond","Five Diamond"
			,"Six Diamond","Seven Diamond","Eight Diamond","Nine Diamond","Ten Diamond","Jack Diamond",
			"Queen Diamond","King Diamond","Ace Heart","Two Heart","Three Heart","Four Heart","Five Heart",
			"Six Heart","Seven Heart","Eight Heart","Nine Heart","Ten Heart","Jack Heart","Queen Heart"
			,"King Heart"};
	
	/** The deck sorted by suit. */
	String deckSortedBySuit[] = {"Jack Spade", "Queen Spade", "King Spade","Ace Spade","Two Spade",
			"Three Spade","Four Spade","Five Spade","Six Spade","Seven Spade","Eight Spade","Nine Spade",
			"Ten Spade","Jack Club","Queen Club","King Club","Ace Club","Two Club","Three Club","Four Club",
			"Five Club","Six Club","Seven Club","Eight Club","Nine Club","Ten Club","Jack Diamond",
			"Queen Diamond","King Diamond","Ace Diamond","Two Diamond","Three Diamond","Four Diamond",
			"Five Diamond","Six Diamond","Seven Diamond","Eight Diamond","Nine Diamond","Ten Diamond",
			"Jack Heart","Queen Heart","King Heart","Ace Heart","Two Heart","Three Heart","Four Heart",
			"Five Heart","Six Heart","Seven Heart","Eight Heart","Nine Heart","Ten Heart"};
	
	/** The cut deck. */
	String cutDeck[] = {"Queen Heart","King Spade", "King Diamond", "King Club", 
			"King Heart","Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart", "Two Spade", "Two Diamond",
			"Two Club", "Two Heart", "Three Spade", "Three Diamond", "Three Club", "Three Heart",
			"Four Spade", "Four Diamond", "Four Club", "Four Heart","Five Spade", "Five Diamond", 
			"Five Club", "Five Heart", "Six Spade", "Six Diamond", "Six Club", "Six Heart", "Seven Spade", 
			"Seven Diamond", "Seven Club", "Seven Heart","Eight Spade", "Eight Diamond", "Eight Club",
			"Eight Heart","Nine Spade", "Nine Diamond", "Nine Club", "Nine Heart", "Ten Spade", "Ten Diamond", 
			"Ten Club", "Ten Heart","Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
			,"Queen Diamond", "Queen Club"};

	
	
	/** The standard deck. */
	Deck standardDeck;

	
	/**
	 * Setup executed before the tests
	 */
	@Before
	public void setup()
	{
		standardDeck = new StandardDeckImpl();	
		
	}
	
	
	/**
	 * Checks if Jack of spade card is created correctly.
	 */
	@Test
	   public void jackOfSpade_Card_Equal() {
		
		Card c = new CardImpl((new RankImpl("Jack",0)),(new SuitImpl("Spade",(char)'\u2660')));	
		
	      //To Check that two objects are equal
	      assertEquals("Jack",c.getRank().getName());
	      assertEquals(new Integer(0),c.getRank().getPips());
	      assertEquals("Spade",c.getSuit().getName());
	      assertEquals(new Character('\u2660'),c.getSuit().getSymbol());
}
	
	/**
	 * Checks if Ten of Diamond card is created correctly.
	 */
	@Test
	   public void tenOfDiamond_Card_Equal() {
		
		Card c = new CardImpl((new RankImpl("Ten",10)),(new SuitImpl("Diamond",(char)'\u2666')));	
		
	      //To Check that two objects are equal
	      assertEquals("Ten",c.getRank().getName());
	      assertEquals(new Integer(10),c.getRank().getPips());
	      assertEquals("Diamond",c.getSuit().getName());
	      assertEquals(new Character('\u2666'),c.getSuit().getSymbol());
}
	
	
	/**
	 * Checks if the Rank has the correct name and pips.
	 */
	@Test
	   public void rank_Equal() {
		
		Rank r = new RankImpl("Jack",0);	
		
	      //To Check that two objects are equal
	      assertEquals("Jack",r.getName());
	      assertEquals(new Integer(0),r.getPips());
}
	
	/**
	 * Checks if the Suit contains the correct name and symbol.
	 */
	@Test
	   public void suit_Equal() {
		
		Suit s = new SuitImpl("Diamond",(char)'\u2666');	
		
	      //To Check that two objects are equal
	      assertEquals("Diamond",s.getName());
	      assertEquals(new Character('\u2666'),s.getSymbol());
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
		
		Card[] actualDeckArray = new Card[standardDeck.getDeck().size()];
		actualDeckArray = standardDeck.getDeck().toArray(actualDeckArray);
		 		
				for(int i=0;i<Array.getLength(actualDeckArray);i++)
				{
					assertEquals((Integer)pipsArray[i],actualDeckArray[i].getRank().getPips());
					assertEquals(deckOfCards[i],actualDeckArray[i].toString());
					
				}		
		
		assertEquals(52,standardDeck.getDeck().size());
		
		}
	
	
	/**
	 * Checks if Shuffled deck not equal to the deck before it was shuffled.
	 */
	@Test
		public void shuffled_Deck_NotEqual()
		{
			List<Card> copiedDeck = standardDeck.getDeck().stream()
					  .collect(Collectors.toList());
			standardDeck.shuffle();
			assertNotEquals(standardDeck,copiedDeck);
			
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
		standardDeck.sort("Rank");
		Card[] actualDeckArray = new Card[standardDeck.getDeck().size()];
		actualDeckArray = standardDeck.getDeck().toArray(actualDeckArray);
		 		
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
		standardDeck.sort("Suit");
		Card[] actualDeckArray = new Card[standardDeck.getDeck().size()];
		actualDeckArray = standardDeck.getDeck().toArray(actualDeckArray);
		 		
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
		standardDeck.sort("both");
		Card[] actualDeckArray = new Card[standardDeck.getDeck().size()];
		actualDeckArray = standardDeck.getDeck().toArray(actualDeckArray);
		 		
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
	public void cutDeckArray_Standard_Equal()
	{
		standardDeck.cut(7);
		Card[] actualDeckArray = new Card[standardDeck.getDeck().size()];
		actualDeckArray = standardDeck.getDeck().toArray(actualDeckArray);
		 		
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
	public void cutDeck_Standard_Equal()
	{
		final int cutPoint = 7;
		Deck copyDeck = new StandardDeckImpl();
		
		standardDeck.cut(cutPoint);
		standardDeck.cut(standardDeck.getDeck().size()-cutPoint);
		assertEquals(copyDeck,standardDeck);
	}
	
	
	/**
	 * Checks if the correct card was pulled from the deck.
	 */
	@Test
	public void pullCard_Standard_Equal()
	{
		final String pulledCard = "Ten Heart";
		assertEquals(pulledCard,standardDeck.pullCard().toString());
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
	public void pulledCardRemoved_Standard_Equal()
	{
		Deck standardDeck = new StandardDeckImpl();	
		Deck copiedDeck = new StandardDeckImpl();
		Card pulledCard = standardDeck.pullCard();
		
		Card[] actualDeckArray = new Card[standardDeck.getDeck().size()];
		actualDeckArray = standardDeck.getDeck().toArray(actualDeckArray);
		 		
				for(int i=0;i<Array.getLength(actualDeckArray);i++)
				{
					assertEquals("Ten Heart",pulledCard.toString());
					assertFalse(standardDeck.getDeck().contains(pulledCard));
					assertEquals(copiedDeck.getDeck().size()-1,standardDeck.getDeck().size());
				}	
	}
	
	/**
	 * Checks if an empty deck is empty
	 * Removes all the cards in the current deck and checks if it is empty
	 */
	@Test
	public void emptyDeck_Standard_Equal()
	{
		
		assertFalse(standardDeck.emptyDeck());
		while(!standardDeck.emptyDeck())
		{
			standardDeck.pullCard();	
		}
		assertTrue(standardDeck.emptyDeck());
	
	}


	
}

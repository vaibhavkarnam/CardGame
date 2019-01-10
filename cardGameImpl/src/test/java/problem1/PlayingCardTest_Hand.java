package problem1;

import org.junit.*;

import problem1.Card;
import problem1.Deck;
import problem1.Hand;
import problem1.HandImpl;
import problem1.StandardDeckImpl;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Class PlayingCardTest_Hand tests functionality of HandImpl class.
 */
public class PlayingCardTest_Hand {
	
	/** The player hand. */
	Hand playerHand;
	
	/** The standard deck. */
	Deck standardDeck;

	/** The hand. */
	String hand[] = {"Ten Heart", "Ten Club","Ten Diamond","Ten Spade","Nine Heart","Nine Club",
			"Nine Diamond","Nine Spade","Eight Heart","Eight Club","Eight Diamond","Eight Spade","Seven Heart" };
	
	/** The accepted hand. */
	String acceptedHand[] = {"Ten Heart", "Ten Club","Ten Diamond","Ten Spade","Nine Heart","Nine Club",
			"Nine Diamond","Nine Spade","Eight Heart","Eight Club","Eight Diamond","Eight Spade",
			"Seven Heart","Seven Club" };
	
	/** The hand sorted by rank. */
	String handSortedByRank[] = {"Seven Heart", "Eight Heart", "Eight Club", "Eight Diamond", "Eight Spade" 
			, "Nine Heart", "Nine Club", "Nine Diamond", "Nine Spade", "Ten Heart", "Ten Club",
			"Ten Diamond", "Ten Spade" };
	
	/** The hand sorted by suit. */
	String handSortedBySuit[] = {"Ten Spade","Nine Spade","Eight Spade","Ten Club","Nine Club","Eight Club"
			,"Ten Diamond","Nine Diamond","Eight Diamond","Ten Heart","Nine Heart","Eight Heart","Seven Heart"};
	
	
	/** The hand sorted by both rank and suit. */
	String handSortedByBothRankAndSuit[] = {"Eight Spade","Nine Spade","Ten Spade","Eight Club","Nine Club"
			,"Ten Club","Eight Diamond","Nine Diamond","Ten Diamond","Seven Heart","Eight Heart","Nine Heart"
			,"Ten Heart"};

	
	/**
	 * Setup executed before the tests
	 */
	@Before
	public void setup()
	{
		playerHand = new HandImpl();
		standardDeck = new StandardDeckImpl();	
		for(int i=0;i<13;i++)
		{
		playerHand.accept(standardDeck.pullCard());
		}

	}
	
	/**
	 * Checks if the hand is created correctly, hand has the right cards
	 *  in it and the right number of cards.
	 *  The expected cards are represented as a String of Rank and Suit names. 
	 *  A correctly constructed hand is represented as an array of such cards
	 *  The actual constructed hand is converted into an array of String where
	 *  each card in the deck is represented as a String.
	 *  The two arrays are then compared to establish if the hand is created correctly.
	 */
	@Test
	   public void showCards_Hand_Equal() {
		
		Card[] actualHandArray = new Card[playerHand.showCards().size()];
		actualHandArray = playerHand.showCards().toArray(actualHandArray);
		 		
				for(int i=0;i<Array.getLength(actualHandArray);i++)
				{
					assertEquals(hand[i],actualHandArray[i].toString());
					
				}		
		}
	
	
	/**
	 * Checks if the hand accepts the card correctly after creating new hand
	 *  The expected cards are represented as a String of Rank and Suit names. 
	 *  A correctly constructed hand is represented as an array of such cards
	 *  The actual constructed hand is converted into an array of String where
	 *  each card in the deck is represented as a String.
	 *  The two arrays are then compared to establish if the hand is created correctly.
	 */
	@Test
	   public void acceptCard_Hand_Equal() {
		
		Hand hand = new HandImpl();
		hand.accept(standardDeck.pullCard());
		
		Card[] actualHandArray = new Card[hand.showCards().size()];
		actualHandArray = hand.showCards().toArray(actualHandArray);
		 		
				for(int i=0;i<Array.getLength(actualHandArray);i++)
				{
					assertEquals("Seven Club",actualHandArray[i].toString());
					
				}	
				
	}
	
	/**
	 * Checks if the hand accepts the card correctly in existing hand
	 *  The expected cards are represented as a String of Rank and Suit names. 
	 *  A correctly constructed hand is represented as an array of such cards
	 *  The actual constructed hand is converted into an array of String where
	 *  each card in the deck is represented as a String.
	 *  The two arrays are then compared to establish if the hand is created correctly.
	 */
	@Test
	   public void acceptCardToExsiting_Hand_Equal() {
		
		playerHand.accept(standardDeck.pullCard());
		Card[] actualHandArray = new Card[playerHand.showCards().size()];
		actualHandArray = playerHand.showCards().toArray(actualHandArray);
		 		
				for(int i=0;i<Array.getLength(actualHandArray);i++)
				{
					assertEquals(acceptedHand[i],actualHandArray[i].toString());
					
				}
				
	}
	
	/**
	 * Checks if the card is pulled from the hand correctly and the hand now contains
	 * one card less  
	 */
	@Test
	   public void pullCard_Hand_Equal() {
		
		Hand hand = new HandImpl();
		standardDeck = new StandardDeckImpl();	
		for(int i=0;i<13;i++)
		{
		hand.accept(standardDeck.pullCard());
		}
		
		Card pulledCard = playerHand.pullCard();
		assertEquals("Ten Heart",pulledCard.toString());	
		assertFalse(playerHand.showCards().contains(pulledCard));
		assertEquals(hand.showCards().size()-1,playerHand.showCards().size());
		
	}
	
	
	/**
	 * Checks if the hand contains the given card or not.
	 * when there are no repeated cards a pulled card should give false 
	 */
	@Test
	   public void hasCard_Hand_Equal() {
		
		Hand hand = new HandImpl();
		standardDeck = new StandardDeckImpl();	
		for(int i=0;i<13;i++)
		{
		hand.accept(standardDeck.pullCard());
		}
		
		Card pulledCard = hand.pullCard();
		assertFalse(hand.hasCard(pulledCard));
		
	}
	
	/**
	 * Checks if Shuffled hand is not equal to the hand before it was shuffled.
	 */
	@Test
	public void shuffled_Hand_NotEqual()
	{
		List<Card> copiedHand = playerHand.showCards().stream()
				  .collect(Collectors.toList());
		playerHand.shuffle();
		assertNotEquals(playerHand,copiedHand);
		
	}

	/**
	 * Checks if the hand is sorted correctly by rank
	 * The expected cards are represented as a String of Rank and Suit names. 
	 *  A correctly constructed sorted hand is represented as an array of such cards
	 *  The actual constructed hand is converted into an array of String where
	 *  each card in the hand is represented as a String.
	 *  The two arrays are then compared to establish if the hand was sorted correctly by rank.
	 */
@Test
public void sortedHand_ByRank_Equal()
{
	playerHand.sort("Rank");
	Card[] actualHandArray = new Card[playerHand.showCards().size()];
	actualHandArray = playerHand.showCards().toArray(actualHandArray);
	 		
			for(int i=0;i<Array.getLength(actualHandArray);i++)
			{
				assertEquals(handSortedByRank.length,actualHandArray.length);
				assertEquals(handSortedByRank[i],actualHandArray[i].toString());
			}				
}

/**
 * Checks if the hand is sorted by suit .
 * The cards with same suit are grouped together.
 * The expected cards are represented as a String of Rank and Suit names. 
 *  A correctly constructed sorted hand is represented as an array of such cards
 *  The actual constructed hand is converted into an array of String where
 *  each card in the hand is represented as a String.
 *  The two arrays are then compared to establish if the hand was sorted correctly by suits.
 */
@Test
public void sortedHand_BySuit_Equal()
{
	playerHand.sort("Suit");
	Card[] actualHandArray = new Card[playerHand.showCards().size()];
	actualHandArray = playerHand.showCards().toArray(actualHandArray);
	 		
			for(int i=0;i<Array.getLength(actualHandArray);i++)
			{
				assertEquals(handSortedBySuit.length,actualHandArray.length);
				assertEquals(handSortedBySuit[i],actualHandArray[i].toString());
			}		
}

/**
 * Checks if hand is sorted by both suit and rank.
 * The cards with same suit are grouped together and cards within each group of suits are
 * sorted by rank
 * The expected cards are represented as a String of Rank and Suit names. 
 * A correctly constructed sorted hand is represented as an array of such cards
 * The actual constructed hand is converted into an array of String where
 * each card in the hand is represented as a String.
 * The two arrays are then compared to establish if the hand was sorted correctly by 
 * rank and suits.
 */
@Test
public void sortedHand_ByBothSuitAndRank_Equal()
{
	playerHand.sort("both");
	Card[] actualHandArray = new Card[playerHand.showCards().size()];
	actualHandArray = playerHand.showCards().toArray(actualHandArray);
	 		
			for(int i=0;i<Array.getLength(actualHandArray);i++)
			{
				assertEquals(handSortedByBothRankAndSuit.length,actualHandArray.length);
				assertEquals(handSortedByBothRankAndSuit[i],actualHandArray[i].toString());
			}
	
}


}

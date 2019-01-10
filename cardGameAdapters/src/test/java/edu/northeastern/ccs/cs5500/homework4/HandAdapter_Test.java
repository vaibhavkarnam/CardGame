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
 * The Class HandAdapter_Test tests functionality of NewHandAdapter class.
 */
public class HandAdapter_Test {

		
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
		String handSortedByRank[] = {"Seven Heart","Eight Heart", "Eight Club", "Eight Diamond", "Eight Spade" 
				,"Nine Heart", "Nine Club", "Nine Diamond", "Nine Spade", "Ten Heart", "Ten Club",
				"Ten Diamond", "Ten Spade" };
		
		/** The hand sorted by rank. */
		String DiffhandSortedByRank[] = {"Eight Heart", "Eight Club", "Eight Diamond"
				,"Nine Heart", "Nine Club", "Nine Diamond", "Nine Spade", "Ten Heart", "Ten Club",
				"Ten Diamond", "Ten Spade" };
		
		/** The hand sorted by suit. */
		String handSortedBySuit[] = {"Ten Club","Nine Club","Eight Club","Ten Diamond","Nine Diamond",
				"Eight Diamond","Ten Heart","Nine Heart","Eight Heart","Seven Heart",
				"Ten Spade","Nine Spade","Eight Spade"};
		
		/** The hand sorted by suit. */
		String DiffhandSortedBySuit[] = {"Ten Club","Nine Club","Eight Club","Ten Diamond","Nine Diamond",
				"Eight Diamond","Ten Heart","Nine Heart","Eight Heart",
				"Ten Spade","Nine Spade"};
		
		/** The hand sorted by both rank and suit. */
		String DiffhandSortedByBothRankAndSuit[] = {"Eight Club","Nine Club","Ten Club","Eight Diamond",
				"Nine Diamond","Ten Diamond","Eight Heart","Nine Heart"
				,"Ten Heart","Nine Spade","Ten Spade",};
		
		/** The hand sorted by both rank and suit. */
		String handSortedByBothRankAndSuit[] = {"Eight Club","Nine Club","Ten Club","Eight Diamond",
				"Nine Diamond","Ten Diamond","Seven Heart","Eight Heart","Nine Heart"
				,"Ten Heart","Eight Spade","Nine Spade","Ten Spade",};

		
		/**
		 * Setup executed before the tests
		 */
		@Before
		public void setup()
		{
			playerHand = new NewHandAdapter();
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
			
			Hand hand = new NewHandAdapter();
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
			
			Hand hand = new NewHandAdapter();
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
		 * Checks if the card is pulled from the hand correctly and the hand now contains
		 * one card less when only one card was present in hand and size is now 0 
		 */
		@Test
		   public void pullCard_OneCardHand_Equal() {
			
			Hand hand = new NewHandAdapter();
			standardDeck = new StandardDeckImpl();	

			hand.accept(standardDeck.pullCard());
			
			
			Card pulledCard = hand.pullCard();
			assertEquals("Ten Heart",pulledCard.toString());	
			assertFalse(hand.showCards().contains(pulledCard));
			assertEquals(0,hand.showCards().size());
			
		}
		
		
		/**
		 * Checks if the card is pulled from the hand correctly and the hand now contains
		 * one card less  
		 */
		@Test(expected = IndexOutOfBoundsException.class)
		   public void pullCard_EmptyHand_Equal() {
			
			Hand hand = new NewHandAdapter();
			hand.pullCard();
			
		}
		
		
		/**
		 * Checks if the hand contains the given card or not.
		 * when there are no repeated cards a pulled card should give false 
		 */
		@Test
		   public void hasCard_NewHand_Equal() {
			
			Hand hand = new NewHandAdapter();
			standardDeck = new StandardDeckImpl();	
			for(int i=0;i<13;i++)
			{
			hand.accept(standardDeck.pullCard());
			}
			
			Card pulledCard = hand.pullCard();
			assertFalse(hand.hasCard(pulledCard));
			
		}
		
		/**
		 * Checks if the hand contains the given card or not.
		 * empty hand should give false 
		 */
		@Test
		   public void hasCard_EmptyHand_Equal() {
			
			Hand hand = new NewHandAdapter();
			Suit suit = new SuitImpl(SuitEnum.HEART.suit(),SuitEnum.HEARTSYMBOL.suitSymbol());
			Rank rank = new RankImpl(RankEnum.TEN.rank(),10);
			assertFalse(hand.hasCard(new CardAdapter(rank,suit)));
			
		}
		
		/**
		 * Checks if the hand contains the given card or not.
		 * when there are no repeated cards a pulled card should give false 
		 * The card added to the hand should give true
		 */
		@Test
		   public void hasCard_Hand_Equal() {
			
			Hand hand = new NewHandAdapter();
			standardDeck = new StandardDeckImpl();	
			for(int i=0;i<13;i++)
			{
			hand.accept(standardDeck.pullCard());
			}
			
			Suit suit = new SuitImpl(SuitEnum.HEART.suit(),SuitEnum.HEARTSYMBOL.suitSymbol());
			Rank rank = new RankImpl(RankEnum.TEN.rank(),10);
			
			assertTrue(hand.hasCard(new CardAdapter(rank,suit)));
			
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
		 * Checks if Shuffled empty hand is empty after shuffling
		 */
		@Test(expected = IndexOutOfBoundsException.class)
		public void shuffled_EmptyHand_Equal()
		{
			Hand hand = new NewHandAdapter();
			Hand newHand = new NewHandAdapter();
			hand.shuffle();
			hand.pullCard();
			
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
	 * Checks if the hand is sorted correctly by rank
	 * The expected cards are represented as a String of Rank and Suit names. 
	 *  A correctly constructed sorted hand is represented as an array of such cards
	 *  The actual constructed hand is converted into an array of String where
	 *  each card in the hand is represented as a String.
	 *  The two arrays are then compared to establish if the hand was sorted correctly by rank.
	 */
	@Test
	public void sortedHand2_ByRank_Equal()
	{
	Hand playerHand = new NewHandAdapter();
	Deck standardDeck = new StandardDeckImpl();
	for(int i=0;i<11;i++)
		{
		playerHand.accept(standardDeck.pullCard());
		}
	playerHand.sort("Rank");
	Card[] actualHandArray = new Card[playerHand.showCards().size()];
	actualHandArray = playerHand.showCards().toArray(actualHandArray);
	 		
			for(int i=0;i<Array.getLength(actualHandArray);i++)
			{
				assertEquals(DiffhandSortedByRank.length,actualHandArray.length);
				assertEquals(DiffhandSortedByRank[i],actualHandArray[i].toString());
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
	 * Checks if the hand is sorted by suit .
	 * The cards with same suit are grouped together.
	 * The expected cards are represented as a String of Rank and Suit names. 
	 *  A correctly constructed sorted hand is represented as an array of such cards
	 *  The actual constructed hand is converted into an array of String where
	 *  each card in the hand is represented as a String.
	 *  The two arrays are then compared to establish if the hand was sorted correctly by suits.
	 */
	@Test
	public void sortedHand2_BySuit_Equal()
	{
		Hand playerHand = new NewHandAdapter();
		Deck standardDeck = new StandardDeckImpl();
		for(int i=0;i<11;i++)
			{
			playerHand.accept(standardDeck.pullCard());
			}
		playerHand.sort("Suit");
		
		Card[] actualHandArray = new Card[playerHand.showCards().size()];
		actualHandArray = playerHand.showCards().toArray(actualHandArray);
		 		
				for(int i=0;i<Array.getLength(actualHandArray);i++)
				{
					assertEquals(DiffhandSortedBySuit.length,actualHandArray.length);
					assertEquals(DiffhandSortedBySuit[i],actualHandArray[i].toString());
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
	public void sortedHand2_ByBothSuitAndRank_Equal()
	{
		Hand playerHand = new NewHandAdapter();
		Deck standardDeck = new StandardDeckImpl();
		for(int i=0;i<11;i++)
			{
			playerHand.accept(standardDeck.pullCard());
			}
		playerHand.sort("both");
		Card[] actualHandArray = new Card[playerHand.showCards().size()];
		actualHandArray = playerHand.showCards().toArray(actualHandArray);
		 		
				for(int i=0;i<Array.getLength(actualHandArray);i++)
				{
					assertEquals(DiffhandSortedByBothRankAndSuit.length,actualHandArray.length);
					assertEquals(DiffhandSortedByBothRankAndSuit[i],actualHandArray[i].toString());
				}
		
	}
	
	/* 
	 * Checks if card exists in the given player hand using hasCard and returns false since it
	 * does not exist
	 * */
	@Test
	public void NewHand_hasCard_neg()
	{
		Suit suit = new SuitImpl(SuitEnum.SPADE.suit(),SuitEnum.SPADESYMBOL.suitSymbol());
		Rank rank  = new RankImpl(RankEnum.TWO.rank(),2);
		Card card = new CardAdapter(rank,suit);
		assertEquals(false,playerHand.hasCard(card));
		
 
	}
	
	/* 
	 * Checks if pulled card exists in the given player hand using hasCard and returns false since it
	 * does not exist
	 * */
	@Test
	public void NewHand_hasCardpulled_neg()
	{

		Card card = playerHand.pullCard();
		assertEquals(false,playerHand.hasCard(card));
		
 
	}
	
	/* 
	 * Checks if card exists in the given player hand using hasCard and returns true since it
	 * exists
	 * */
	@Test
	public void NewHand_hasCard_pos()
	{
		Suit suit = new SuitImpl(SuitEnum.DIAMOND.suit(),SuitEnum.DIAMONDSYMBOL.suitSymbol());
		Rank rank  = new RankImpl(RankEnum.TEN.rank(),10);
		Card card = new CardAdapter(rank,suit);
		assertEquals(true,playerHand.hasCard(card));
		
 
	}
	
	
	/* 
	 * Checks if card exists in the given player hand using hasCard and returns falase since it
	 * is empty
	 * */
	@Test
	public void NewHand_hasCard_emptyHand_neg()
	{
		NewHand playerHand = new NewHandAdapter();
		Suit suit = new SuitImpl(SuitEnum.DIAMOND.suit(),SuitEnum.DIAMONDSYMBOL.suitSymbol());
		Rank rank  = new RankImpl(RankEnum.TEN.rank(),10);
		Card card = new CardAdapter(rank,suit);
		assertEquals(false,playerHand.hasCard(card));
		
 
	}
	
	/* 
	 * Checks the number of occurrences of Ka in the given player Shou and returns 0 since it
	 * is empty
	 * */
	@Test
	public void NewHand_noOfOccur_emptyHand_neg()
	{
		NewHand playerHand = new NewHandAdapter();
		Suit suit = new SuitImpl(SuitEnum.DIAMOND.suit(),SuitEnum.DIAMONDSYMBOL.suitSymbol());
		Rank rank  = new RankImpl(RankEnum.TEN.rank(),10);
		Card card = new CardAdapter(rank,suit);
		assertEquals(0,playerHand.occurrencesInHand(card));
		
 
	}
	
	/* 
	 * Checks the number of occurrences of Ka in the given player Shou and returns it
	 * */
	@Test
	public void NewHand_noOfOccur_OneCardHand_pos()
	{
		NewHand playerHand = new NewHandAdapter();
		Suit suit = new SuitImpl(SuitEnum.DIAMOND.suit(),SuitEnum.DIAMONDSYMBOL.suitSymbol());
		Rank rank  = new RankImpl(RankEnum.TEN.rank(),10);
		Card card = new CardAdapter(rank,suit);
		playerHand.accept(card);
		assertEquals(1,playerHand.occurrencesInHand(card));
		
 
	}

	/* 
	 * Checks the number of occurrences of Ka in the given player Shou and returns it
	 * */
	@Test
	public void NewHand_noOfOccur_ManyCardHand_pos()
	{
		NewHand playerHand = new NewHandAdapter();
		Suit suit = new SuitImpl(SuitEnum.DIAMOND.suit(),SuitEnum.DIAMONDSYMBOL.suitSymbol());
		Rank rank  = new RankImpl(RankEnum.TEN.rank(),10);
		Card card = new CardAdapter(rank,suit);
		playerHand.accept(card);
		standardDeck = new StandardDeckImpl();	
		for(int i=0;i<13;i++)
		{
		playerHand.accept(standardDeck.pullCard());
		}
		assertEquals(2,playerHand.occurrencesInHand(card));
		
 
	}
	
	/* 
	 * Checks the number of occurrences of Ka in the given player Shou and returns it
	 * */
	@Test
	public void NewHand_noOfOccur_Many_CardHand_pos()
	{
		NewHand playerHand = new NewHandAdapter();
		Suit suit = new SuitImpl(SuitEnum.DIAMOND.suit(),SuitEnum.DIAMONDSYMBOL.suitSymbol());
		Rank rank  = new RankImpl(RankEnum.TEN.rank(),10);
		Card card = new CardAdapter(rank,suit);
		playerHand.accept(card);
		standardDeck = new StandardDeckImpl();	
		for(int i=0;i<13;i++)
		{
		playerHand.accept(standardDeck.pullCard());
		}
		playerHand.accept(card);

		assertEquals(3,playerHand.occurrencesInHand(card));
		
	}
	
	/* 
	 * Checks the number of occurrences of Ka of given rank in the given player Shou and returns 0 since it
	 * is empty
	 * */
	@Test
	public void NewHand_noOfOccurRank_emptyHand_neg()
	{
		NewHand playerHand = new NewHandAdapter();
		Rank rank  = new RankImpl(RankEnum.TEN.rank(),10);
		assertEquals(0,playerHand.occurrencesInHand(rank));
		
 
	}
	
	/* 
	 * Checks the number of occurrences of Ka of given rank in the given player shou and returns it
	 * */
	@Test
	public void NewHand_noOfOccurRank_OneCardHand_pos()
	{
		NewHand playerHand = new NewHandAdapter();
		Suit suit = new SuitImpl(SuitEnum.DIAMOND.suit(),SuitEnum.DIAMONDSYMBOL.suitSymbol());
		Rank rank  = new RankImpl(RankEnum.TEN.rank(),10);
		Card card = new CardAdapter(rank,suit);
		playerHand.accept(card);
		assertEquals(1,playerHand.occurrencesInHand(rank));
		
 
	}

	/* 
	 * Checks the number of occurrences of the Ka of given rank in the given player Shou and returns it
	 * */
	@Test
	public void NewHand_noOfOccurRank_ManyCardHand_pos()
	{
		NewHand playerHand = new NewHandAdapter();
		Suit suit = new SuitImpl(SuitEnum.DIAMOND.suit(),SuitEnum.DIAMONDSYMBOL.suitSymbol());
		Rank rank  = new RankImpl(RankEnum.TEN.rank(),10);
		Card card = new CardAdapter(rank,suit);
		playerHand.accept(card);
		standardDeck = new StandardDeckImpl();	
		for(int i=0;i<13;i++)
		{
		playerHand.accept(standardDeck.pullCard());
		}
		assertEquals(5,playerHand.occurrencesInHand(rank));
		
 
	}
	
	/* 
	 * Checks the number of occurrences of the Ka of the given rank in the given player Shou and returns it
	 * */
	@Test
	public void NewHand_noOfOccurRanks_Many_CardHand_pos()
	{
		NewHand playerHand = new NewHandAdapter();
		Suit suit = new SuitImpl(SuitEnum.DIAMOND.suit(),SuitEnum.DIAMONDSYMBOL.suitSymbol());
		Rank rank  = new RankImpl(RankEnum.TEN.rank(),10);
		Card card = new CardAdapter(rank,suit);
		playerHand.accept(card);
		standardDeck = new StandardDeckImpl();	
		for(int i=0;i<13;i++)
		{
		playerHand.accept(standardDeck.pullCard());
		}
		playerHand.accept(card);

		assertEquals(6,playerHand.occurrencesInHand(rank));
		
	}
	

	
}

package edu.northeastern.ccs.cs5500.homework4;


import static org.junit.Assert.assertEquals;

import java.lang.reflect.Array;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


/**
 * The Class PlayingCardTest_Game tests the functionality provided by the GameImpl Class.
 */
public class PlayingCardTest_Game {
	
	/** The standard deck of cards. */
	String standardDeckOfCards[] = {"Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
			,"Queen Diamond", "Queen Club", "Queen Heart","King Spade", "King Diamond", "King Club", 
			"King Heart","Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart", "Two Spade", "Two Diamond",
			"Two Club", "Two Heart", "Three Spade", "Three Diamond", "Three Club", "Three Heart",
			"Four Spade", "Four Diamond", "Four Club", "Four Heart","Five Spade", "Five Diamond", 
			"Five Club", "Five Heart", "Six Spade", "Six Diamond", "Six Club", "Six Heart", "Seven Spade", 
			"Seven Diamond", "Seven Club", "Seven Heart","Eight Spade", "Eight Diamond", "Eight Club",
			"Eight Heart","Nine Spade", "Nine Diamond", "Nine Club", "Nine Heart", "Ten Spade", "Ten Diamond", 
			"Ten Club", "Ten Heart"};
	
	/** The twostandard deck of cards. */
	String twostandardDeckOfCards[] = {"Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
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
	
	
	/** The pinochle deck of cards. */
	String pinochleDeckOfCards[] = {"Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
			,"Queen Diamond", "Queen Club", "Queen Heart","King Spade", "King Diamond", "King Club", 
			"King Heart","Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart","Nine Spade", "Nine Diamond",
			"Nine Club", "Nine Heart", "Ten Spade", "Ten Diamond","Ten Club", "Ten Heart","Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
			,"Queen Diamond", "Queen Club", "Queen Heart","King Spade", "King Diamond", "King Club", 
			"King Heart","Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart","Nine Spade", "Nine Diamond",
			"Nine Club", "Nine Heart", "Ten Spade", "Ten Diamond","Ten Club", "Ten Heart"};
	
	/** The two pinochle deck of cards. */
	String twoPinochleDeckOfCards[] = {"Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
			,"Queen Diamond", "Queen Club", "Queen Heart","King Spade", "King Diamond", "King Club", 
			"King Heart","Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart","Nine Spade", "Nine Diamond",
			"Nine Club", "Nine Heart", "Ten Spade", "Ten Diamond","Ten Club", "Ten Heart","Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
			,"Queen Diamond", "Queen Club", "Queen Heart","King Spade", "King Diamond", "King Club", 
			"King Heart","Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart","Nine Spade", "Nine Diamond",
			"Nine Club", "Nine Heart", "Ten Spade", "Ten Diamond","Ten Club", "Ten Heart","Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
			,"Queen Diamond", "Queen Club", "Queen Heart","King Spade", "King Diamond", "King Club", 
			"King Heart","Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart","Nine Spade", "Nine Diamond",
			"Nine Club", "Nine Heart", "Ten Spade", "Ten Diamond","Ten Club", "Ten Heart","Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
			,"Queen Diamond", "Queen Club", "Queen Heart","King Spade", "King Diamond", "King Club", 
			"King Heart","Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart","Nine Spade", "Nine Diamond",
			"Nine Club", "Nine Heart", "Ten Spade", "Ten Diamond","Ten Club", "Ten Heart"};
	
	/** The euchre deck of cards. */
	String euchreDeckOfCards[] = {"Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
			,"Queen Diamond", "Queen Club", "Queen Heart","King Spade", "King Diamond", "King Club", 
			"King Heart","Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart","Nine Spade", "Nine Diamond",
			"Nine Club", "Nine Heart", "Ten Spade", "Ten Diamond","Ten Club", "Ten Heart"};
	
	/** The three euchre deck of cards. */
	String threeEuchreDeckOfCards[] = {"Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
			,"Queen Diamond", "Queen Club", "Queen Heart","King Spade", "King Diamond", "King Club", 
			"King Heart","Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart","Nine Spade", "Nine Diamond",
			"Nine Club", "Nine Heart", "Ten Spade", "Ten Diamond","Ten Club", "Ten Heart","Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
			,"Queen Diamond", "Queen Club", "Queen Heart","King Spade", "King Diamond", "King Club", 
			"King Heart","Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart","Nine Spade", "Nine Diamond",
			"Nine Club", "Nine Heart", "Ten Spade", "Ten Diamond","Ten Club", "Ten Heart","Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
			,"Queen Diamond", "Queen Club", "Queen Heart","King Spade", "King Diamond", "King Club", 
			"King Heart","Ace Spade", "Ace Diamond", "Ace Club", "Ace Heart","Nine Spade", "Nine Diamond",
			"Nine Club", "Nine Heart", "Ten Spade", "Ten Diamond","Ten Club", "Ten Heart"};
	
	/** The vegas deck of cards. */
	String vegasDeckOfCards[] = {"Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
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
	
	
	/** The vegas deck of cards three sets. */
	String vegasDeckOfCards_threeSets[] = {"Jack Spade", "Jack Diamond", "Jack Club", "Jack Heart", "Queen Spade"
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
	
	/** The hand representing player1 in the game */
	String hand_Player1[] = {"Ten Heart","Ten Club","Ten Diamond","Ten Spade", "Nine Heart"};
	
	/** The hand representing player2 in the game */
	String hand_Player2[] = {"Nine Club","Nine Diamond","Nine Spade","Eight Heart","Eight Club"};
	
	/** The hand representing player3 in the game */
	String hand_Player3[] = {"Eight Diamond","Eight Spade","Seven Heart","Seven Club","Seven Diamond"};
	
	/** The game. */
	Game game;
	
	/** The standard. */
	final String STANDARD = "Standard";
	
	/** The euchre. */
	final String EUCHRE = "Euchre";
	
	/** The pinochle. */
	final String PINOCHLE = "Pinochle";
	
	/** The vegas. */
	final String VEGAS = "Vegas";

	
	/**
	 * Setup executed before tests
	 */
	@Before
	public void setup()
	{
		 game = new GameImpl();
		
	}
		
	
	/**
	 * Checks if the deck is created correctly, deck has the right cards
	 *  in it and the right number of cards.
	 *  A standard deck is passed as type of deck to be created
	 *  The expected cards are represented as a String of Rank and Suit names. 
	 *  A correctly constructed deck is represented as an array of such cards
	 *  The actual constructed deck is converted into an array of String where
	 *  each card in the deck is represented as a String.
	 *  The two arrays are then compared to establish if the deck is created correctly.
	 *  The size of the deck is also validated
	 */
	@Test
	   public void createdeck_Standard_Equal() {
		
		 game.createDeck(STANDARD);
		 Deck standardDeck = game.getDeck();
		
		Card[] actualDeckArray = new Card[standardDeck.getDeck().size()];
		actualDeckArray = standardDeck.getDeck().toArray(actualDeckArray);
		 		
				for(int i=0;i<Array.getLength(actualDeckArray);i++)
				{
					assertEquals(standardDeckOfCards.length,actualDeckArray.length);
					assertEquals(standardDeckOfCards[i],actualDeckArray[i].toString());
					
				}		
		
		assertEquals(52,standardDeck.getDeck().size());
		
		}
	
	
	/**
	 * Checks if the deck is created correctly, deck has the right cards
	 *  in it and the right number of cards.
	 *  A standard deck is passed as type of deck to be created and the number of 
	 *  decks passed is 2
	 *  The expected cards are represented as a String of Rank and Suit names. 
	 *  A correctly constructed deck is represented as an array of such cards
	 *  The actual constructed deck is converted into an array of String where
	 *  each card in the deck is represented as a String.
	 *  The two arrays are then compared to establish if the deck is created correctly.
	 *  The size of the deck is also validated
	 */
	@Test
	   public void createdeck_withParam_Standard_Equal() {
		
		 game.createDeck(STANDARD,2);
		 Deck standardDeck = game.getDeck();		
		
		 Card[] actualDeckArray = new Card[standardDeck.getDeck().size()];
		actualDeckArray = standardDeck.getDeck().toArray(actualDeckArray);
		 		
				for(int i=0;i<Array.getLength(actualDeckArray);i++)
				{
					assertEquals(twostandardDeckOfCards.length,actualDeckArray.length);
					assertEquals(twostandardDeckOfCards[i],actualDeckArray[i].toString());
					
				}		
		
		assertEquals(104,standardDeck.getDeck().size());
		
		}
	
	
	/**
	 * Checks if the deck is created correctly, deck has the right cards
	 *  in it and the right number of cards.
	 *  A euchre deck is passed as type of deck to be created
	 *  The expected cards are represented as a String of Rank and Suit names. 
	 *  A correctly constructed deck is represented as an array of such cards
	 *  The actual constructed deck is converted into an array of String where
	 *  each card in the deck is represented as a String.
	 *  The two arrays are then compared to establish if the deck is created correctly.
	 *  The size of the deck is also validated
	 */
	@Test
	   public void createdeck_Euchre_Equal() {
		
		 game.createDeck(EUCHRE);
		 Deck euchreDeck = game.getDeck();		
		
		 Card[] actualDeckArray = new Card[euchreDeck.getDeck().size()];
		 actualDeckArray = euchreDeck.getDeck().toArray(actualDeckArray);
		 		
				for(int i=0;i<Array.getLength(actualDeckArray);i++)
				{
					assertEquals(euchreDeckOfCards.length,actualDeckArray.length);
					assertEquals(euchreDeckOfCards[i],actualDeckArray[i].toString());
					
				}		
		
		assertEquals(24,euchreDeck.getDeck().size());
		
		}
	
	/**
	 * Checks if the deck is created correctly, deck has the right cards
	 *  in it and the right number of cards.
	 *  A euchre deck is passed as type of deck to be created and the number of
	 *  decks to be created is 3
	 *  The expected cards are represented as a String of Rank and Suit names. 
	 *  A correctly constructed deck is represented as an array of such cards
	 *  The actual constructed deck is converted into an array of String where
	 *  each card in the deck is represented as a String.
	 *  The two arrays are then compared to establish if the deck is created correctly.
	 *  The size of the deck is also validated
	 */
	@Test
	   public void createdeck_withParam_Euchre_Equal() {
		
		 game.createDeck(EUCHRE,3);
		 Deck euchreDeck = game.getDeck();	
		 
		Card[] actualDeckArray = new Card[euchreDeck.getDeck().size()];
		actualDeckArray = euchreDeck.getDeck().toArray(actualDeckArray);
		 		
				for(int i=0;i<Array.getLength(actualDeckArray);i++)
				{
					assertEquals(threeEuchreDeckOfCards.length,actualDeckArray.length);
					assertEquals(threeEuchreDeckOfCards[i],actualDeckArray[i].toString());
					
				}		
		
		assertEquals(72,euchreDeck.getDeck().size());
		
		}
	
	/**
	 * Checks if the deck is created correctly, deck has the right cards
	 *  in it and the right number of cards.
	 *  A pinochle deck is passed as type of deck to be created
	 *  The expected cards are represented as a String of Rank and Suit names. 
	 *  A correctly constructed deck is represented as an array of such cards
	 *  The actual constructed deck is converted into an array of String where
	 *  each card in the deck is represented as a String.
	 *  The two arrays are then compared to establish if the deck is created correctly.
	 *  The size of the deck is also validated
	 */
	@Test
	   public void createdeck_pinochle_Equal() {
		
		 game.createDeck(PINOCHLE);
		 Deck pinochleDeck = game.getDeck();	
		 
		Card[] actualDeckArray = new Card[pinochleDeck.getDeck().size()];
		actualDeckArray = pinochleDeck.getDeck().toArray(actualDeckArray);
		 		
				for(int i=0;i<Array.getLength(actualDeckArray);i++)
				{
					assertEquals(pinochleDeckOfCards.length,actualDeckArray.length);
					assertEquals(pinochleDeckOfCards[i],actualDeckArray[i].toString());
					
				}		
		
		assertEquals(48,pinochleDeck.getDeck().size());
		
		}
	
	/**
	 * Checks if the deck is created correctly, deck has the right cards
	 *  in it and the right number of cards.
	 *  A pinochle deck is passed as type of deck to be created and the number of
	 *  decks to be created is 2
	 *  The expected cards are represented as a String of Rank and Suit names. 
	 *  A correctly constructed deck is represented as an array of such cards
	 *  The actual constructed deck is converted into an array of String where
	 *  each card in the deck is represented as a String.
	 *  The two arrays are then compared to establish if the deck is created correctly.
	 *  The size of the deck is also validated
	 */
	@Test
	   public void createdeck_withParam_pinochle_Equal() {
		
		 game.createDeck(PINOCHLE,2);
		 Deck pinochleDeck = game.getDeck();	
		 
		Card[] actualDeckArray = new Card[pinochleDeck.getDeck().size()];
		actualDeckArray = pinochleDeck.getDeck().toArray(actualDeckArray);
		 		
				for(int i=0;i<Array.getLength(actualDeckArray);i++)
				{
					assertEquals(twoPinochleDeckOfCards.length,actualDeckArray.length);
					assertEquals(twoPinochleDeckOfCards[i],actualDeckArray[i].toString());
					
				}		
		
		assertEquals(96,pinochleDeck.getDeck().size());
		
		}
	
	
	/**
	 * Checks if the deck is created correctly, deck has the right cards
	 *  in it and the right number of cards.
	 *  A Vegas deck is passed as type of deck to be created 
	 *  The expected cards are represented as a String of Rank and Suit names. 
	 *  A correctly constructed deck is represented as an array of such cards
	 *  The actual constructed deck is converted into an array of String where
	 *  each card in the deck is represented as a String.
	 *  The two arrays are then compared to establish if the deck is created correctly.
	 *  The size of the deck is also validated
	 */
	@Test
	   public void createdeck_Vegas_Equal() {
		
		 game.createDeck(VEGAS);
		 Deck vegasDeck = game.getDeck();	
		 
		Card[] actualDeckArray = new Card[vegasDeck.getDeck().size()];
		actualDeckArray = vegasDeck.getDeck().toArray(actualDeckArray);
		 		
				for(int i=0;i<Array.getLength(actualDeckArray);i++)
				{
					assertEquals(vegasDeckOfCards.length,actualDeckArray.length);
					assertEquals(vegasDeckOfCards[i],actualDeckArray[i].toString());
					
				}		
		
		assertEquals(416,vegasDeck.getDeck().size());
		
		}
	
	/**
	 * Checks if the deck is created correctly, deck has the right cards
	 *  in it and the right number of cards.
	 *  A Vegas deck is passed as type of deck to be created and the number of standard
	 *  decks is 3
	 *  The expected cards are represented as a String of Rank and Suit names. 
	 *  A correctly constructed deck is represented as an array of such cards
	 *  The actual constructed deck is converted into an array of String where
	 *  each card in the deck is represented as a String.
	 *  The two arrays are then compared to establish if the deck is created correctly.
	 *  The size of the deck is also validated
	 */
	@Test
	   public void createdeck__withParams_Vegas_Equal() {
		
		 game.createDeck(VEGAS,3);
		 Deck vegasDeck = game.getDeck();	
		 
		Card[] actualDeckArray = new Card[vegasDeck.getDeck().size()];
		actualDeckArray = vegasDeck.getDeck().toArray(actualDeckArray);
		 		
				for(int i=0;i<Array.getLength(actualDeckArray);i++)
				{
					assertEquals(vegasDeckOfCards_threeSets.length,actualDeckArray.length);
					assertEquals(vegasDeckOfCards_threeSets[i],actualDeckArray[i].toString());
					
				}		
		
		assertEquals(156,vegasDeck.getDeck().size());
		
		}
	
	/**
	 * Checks if the number of hands are set correctly by validating the size of the hand list in game
	 */
	@Test
	   public void setNoOfHands_Equal() {
		
		final int numberOfHands = 5;
		
		 game.setNumberOfHands(numberOfHands);
		 game.createHands();

		 assertEquals((Integer)5,(Integer)game.getHands().size());
		
		}
	
	/**
	 * Checks if the hands are created correctly by validating if its the instance of HandImpl class 
	 * and the number of hands are set correctly by validating the size of the hand list in game
	 */
	@Test
	   public void createHands_instanceOf_Equal() {
		
		final int numberOfHands = 3;
		
		 game.setNumberOfHands(numberOfHands);
		 game.createHands();
		 List<Hand> createdHands = game.getHands();

		 assertEquals((Integer)3,(Integer)game.getHands().size());
		 for(Hand h : createdHands)
		 {
			 assertEquals(h.getClass(),HandImpl.class);
		 }
		 
		
		}
	
	
	/* 
	 * Checks if the cards in the deck are dealt correctly.
	 * A standard deck is used and three hands are created.
	 * The expected hands are built and the array is compared
	 * to the actual hands
	 * 
	 * */
	@Test
	   public void deal_Equal() {
		
		final int numberOfHands = 3;
		
		 game.createDeck(STANDARD);
		 game.setNumberOfHands(numberOfHands);
		 game.createHands();
		 game.deal();
		 List<Hand> createdHands = game.getHands();
		
		Hand player3 = createdHands.get(createdHands.size()-1); 
		Card[] actualHandArray = new Card[player3.showCards().size()];
		actualHandArray = player3.showCards().toArray(actualHandArray);
		 		
				for(int i=0;i<Array.getLength(actualHandArray);i++)
				{
					assertEquals(hand_Player3.length,actualHandArray.length);
					assertEquals(hand_Player3[i],actualHandArray[i].toString());
					
				}		
		
		assertEquals(5,player3.showCards().size());
		
		Hand player2 = createdHands.get(createdHands.size()-2); 
		Card[] actualHandArray_player2 = new Card[player2.showCards().size()];
		actualHandArray_player2 = player2.showCards().toArray(actualHandArray_player2);
	 		
			for(int i=0;i<Array.getLength(actualHandArray_player2);i++)
			{
				assertEquals(hand_Player2.length,actualHandArray_player2.length);
				assertEquals(hand_Player2[i],actualHandArray_player2[i].toString());
				
			}		
	
		assertEquals(5,player2.showCards().size());
		
		Hand player1 = createdHands.get(createdHands.size()-3); 
		Card[] actualHandArray_player1 = new Card[player1.showCards().size()];
		actualHandArray_player1 = player1.showCards().toArray(actualHandArray_player1);
	 		
			for(int i=0;i<Array.getLength(actualHandArray_player1);i++)
			{
				assertEquals(hand_Player1.length,actualHandArray_player1.length);
				assertEquals(hand_Player1[i],actualHandArray_player1[i].toString());
				
			}		
	
		assertEquals(5,player1.showCards().size());
		
	 }
	
		}

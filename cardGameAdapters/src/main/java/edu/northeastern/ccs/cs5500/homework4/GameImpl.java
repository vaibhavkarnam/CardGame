package edu.northeastern.ccs.cs5500.homework4;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class GameImpl implements the game interface.
 * A game involves a deck and some number of hands
 * 
 * @author vaibhav
 */
public class GameImpl implements Game{
	
	/** The deck of cards*/
	Deck deck;
	
	/** The no of hands in the game*/
	private int noOfHands;
	
	/** The hand list which conatins the hands */
	List<Hand> handList = new ArrayList<>();
	
	/**Instantiate a deck factory to create decks **/
	DeckFactory deckFactory = new DeckFactory();
	
	/**
	 * Creates the deck of specified type.
	 *
	 * @param decktype the type of deck that should be created
	 */
	public void createDeck(String deckType)
	
	{
		deck = deckFactory.createDeckFactory(deckType);
	}
	
	/**
	 * Creates the specified number of decks as a single deck
	 *
	 * @param decktype the type of deck that should be created
	 * @param numberOfDecks the number of decks to be created as a single deck
	 */
	public void createDeck(String deckType, int numberOfDecks)
	{

		deck = deckFactory.createDeckFactory(deckType,numberOfDecks);

	}
	
	/**
	 * Sets the number of hands.
	 *
	 * @param numberOfHands the new number of hands
	 */
	public void setNumberOfHands(int numberOfHands)
	{
		noOfHands = numberOfHands;	
		
	}
	
	/**
	 * Creates the hands in the game.
	 */
	public void createHands()
	{
		for(int i=0;i<noOfHands;i++)
		{
			Hand h = new HandImpl();
			handList.add(h);
		}
	}
	
	/**
	 * returns the hands in the game.
	 *
	 * @return the hands
	 */
	public List<Hand> getHands()
	{
		return handList;
	}
	
	/**
	 * deals the specified number of cards from the deck to the hands
.
	 *
	 * @param noOfCards the no of cards to be dealt
	 */
	public void deal(int noOfCards)
	{
		for(Hand h : handList)
		{
		 for(int i=0;i<noOfCards;i++)
		 {
			 h.accept(deck.pullCard());
		 }
			
		}
	}

	/**
	 * returns the hands in the game.
	 *
	 * @return the hands
	 */
	 public Deck getDeck()
 	{
 		return deck;
 	}
	
	/**
	  * deals the cards from the deck to the hands
	  */
	@Override
	public void deal() {
		
		final int noOfCards = 5;
		
		for(Hand h : handList)
		{
		 for(int i=0;i<noOfCards;i++)
		 {
			 h.accept(deck.pullCard());
		 }
			
		}
		
	}
	

}

package edu.northeastern.ccs.cs5500.homework4;

import java.util.List;

/**
 * The Interface Game.
 * A game involves a deck and some number of hands
 * 
 * @author vaibhav
 */
public interface Game {
	
	/**
	 * Creates the deck of specified type.
	 *
	 * @param decktype the type of deck that should be created
	 */
	void createDeck(String decktype);
	
	/**
	 * Creates the specified number of decks as a single deck
	 *
	 * @param decktype the type of deck that should be created
	 * @param numberOfDecks the number of decks to be created as a single deck
	 */
	void createDeck(String decktype, int numberOfDecks);
	
	/**
	 * Sets the number of hands.
	 *
	 * @param numberOfHands the new number of hands
	 */
	void setNumberOfHands(int numberOfHands);
	
	/**
	 * deals the cards from the deck to the hands
	 */
	void deal();
	
	/**
	 * deals the specified number of cards from the deck to the hands
.
	 *
	 * @param noOfCards the no of cards to be dealt
	 */
	void deal(int noOfCards);
	
	/**
	 * Creates the hands in the game.
	 */
	void createHands();
	
	/**
	 * returns the hands in the game.
	 *
	 * @return the hands
	 */
	List<Hand> getHands();
	
	/**
	 * Gets the deck used in the game.
	 *
	 * @return the deck
	 */
	Deck getDeck();
	

}

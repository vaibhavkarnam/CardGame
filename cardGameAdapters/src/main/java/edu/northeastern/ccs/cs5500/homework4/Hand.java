package edu.northeastern.ccs.cs5500.homework4;

import java.util.List;

/**
 * The Interface Hand.
 * hand represents a player in the game
 * 
 * @author vaibhav
 */
public interface Hand {
	
	/**
	 * Returns the cards of a hand
	 *
	 * @return the list of cards in a hand
	 */
	List<Card> showCards();
	
	/**
	 * Adds the card to the hand
	 *
	 * @param card the card to be added to the handed
	 */
	void accept(Card card);
	
	/**
	 * Returns the first card from the hand
	 *
	 * @return the first card from the hand
	 */
	Card pullCard();
	
	/**
	 * Checks if the hand contains the specified card
	 *
	 * @param card the card to be checked
	 * @return true if the hand contains the card else false
	 */
	boolean hasCard(Card card);
	
	/**
	 * Sorts the cards in a hand byRank, bySuit or both by rank and suit.
	 *
	 * @param bySuitRankboth specifies the type of sorting
	 */
	void sort(String bySuitRankboth);
	
	/**
	 * Shuffles the card of hands so that the order of cards is changed
	 * the cards within the hand are randomly ordered
	 */
	void shuffle();


}

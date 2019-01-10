package edu.northeastern.ccs.cs5500.homework3;
/**
 * The Interface NewHand.
 * NewHand represents a player in the game and extends the Hand Interface
 * 
 * @author vaibhav
 */
public interface NewHand extends Hand{
	/**
	 * Checks if the hand contains the specified card
	 *
	 * @param Card the card to be checked
	 * @return true if the hand contains the card else false
	 */
	boolean hasCard(Card cardToFind);
	/**
	 * Checks the number of times the specified card occurs in the hand
	 *
	 * @param Card the card to be found
	 * @return the number of occurrences of the card
	 */
	int occurrencesInHand(Card cardToFind);
	/**
	 * Checks the number of times the card with specified rank occurs in the hand
	 *
	 * @param Rank for the card to be found
	 * @return the number of occurrences of the card
	 */
	int occurrencesInHand(Rank rankToFind);

}

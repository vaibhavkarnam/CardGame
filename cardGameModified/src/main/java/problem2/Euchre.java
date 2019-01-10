package problem2;

/**
 * The Interface defines a Euchre Deck of playing cards
 * A Euchre deck is a set of cards which is composed of 9, 10, J, Q, K, and A 
 * of the four suits 24 cards in total
 * 
 * @author vaibhav
 */
public interface Euchre {

	/**
	 * Shuffles the deck of cards so that the order of cards is changed
	 * the cards within the deck are randomly ordered
	 */
	void shuffle();
	
	/**
	 * Sorts the deck of cards byRank, bySuit or both by rank and suit.
	 *
	 * @param bySuitRankboth specifies the type of sorting
	 */
	void sort(String bySuitRankboth);
	
	/**
	 * Places the first part of the deck separated by cutPoint at the end of the deck in order.
	 *
	 * @param cutPoint the point until which the cards before in the deck are moved to the end of deck
	 */
	void cut(int cutPoint);
	
	/**
	 * Returns the top card in the deck
	 *
	 * @return top card in deck
	 */
	Card pullCard();
	
	/**
	 * Checks if the deck is empty or not
	 *
	 * @return true if deck is empty else false
	 */
	boolean emptyDeck();
	
}

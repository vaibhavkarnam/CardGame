package problem2;

/**
 * The Interface Card for Creating Playing Cards
 * A card consists of Suit and Rank
 * @author vaibhav
 */
public interface Card {

	/**
	 * Gets the rank.
	 *
	 * @return the rank
	 */
	Rank getRank();
	
	/**
	 * Gets the suit.
	 *
	 * @return the suit
	 */
	Suit getSuit();
	
}

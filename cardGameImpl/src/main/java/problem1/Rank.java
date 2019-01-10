package problem1;

/**
 * The Interface Rank.
 * Represents the rank of card. 
 * It is composed of name and pips
 */
public interface Rank {
	
	/**
	 * Returns the name of the rank.
	 *
	 * @return the name
	 */
	String getName();
	
	/**
	 * Returns the pips of the rank.
	 *
	 * @return the pips
	 */
	Integer getPips();
	
}

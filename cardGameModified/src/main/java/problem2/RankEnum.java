package problem2;

/**
 * The Enum RankEnum for a Rank
 */
public enum RankEnum {

	/** The jack. */
	JACK("Jack"),
	
	/** The queen. */
	QUEEN("Queen"),
	
	/** The king. */
	KING("King"),
	
	/** The ace. */
	ACE("Ace"),
	
	/** The two. */
	TWO("Two"),
	
	/** The three. */
	THREE("Three"),
	
	/** The four. */
	FOUR("Four"),
	
	/** The five. */
	FIVE("Five"),
	
	/** The six. */
	SIX("Six"),
	
	/** The seven. */
	SEVEN("Seven"),
	
	/** The eight. */
	EIGHT("Eight"),
	
	/** The nine. */
	NINE("Nine"),
	
	/** The ten. */
	TEN("Ten");
	
	/** The rank. */
	private String rank;
	
	/**
	 * Instantiates a new rank enum.
	 *
	 * @param rank the rank
	 */
	RankEnum(String rank)
	{
		this.rank = rank;
	}
	
	/**
	 * Returns the Rank.
	 *
	 * @return the string
	 */
	public String rank()
	{
		return rank;
	}
	
}

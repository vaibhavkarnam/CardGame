package edu.northeastern.ccs.cs5500.homework3;

/**
 * The Enum representing the Suit.
 */
public enum SuitEnum {

	/** The spade. */
	SPADE("Spade"),
	
	/** The diamond. */
	DIAMOND("Diamond"),
	
	/** The club. */
	CLUB("Club"),
	
	/** The heart. */
	HEART("Heart"),
	
	/** The spadesymbol. */
	SPADESYMBOL((char)'\u2660'),
	
	/** The diamondsymbol. */
	DIAMONDSYMBOL((char)'\u2666'),
	
	/** The clubsymbol. */
	CLUBSYMBOL((char)'\u2663'),
	
	/** The heartsymbol. */
	HEARTSYMBOL((char)'\u2764');
	
	/** The suit. */
	private String suit;
	
	/** The suit symbol. */
	private char suitSymbol;
	
	/**
	 * Instantiates a new suit enum.
	 *
	 * @param suit the suit to be instantiated
	 */
	SuitEnum(String suit)
	{
		this.suit = suit;
	}
	
	/**
	 * Instantiates a new suit enum.
	 *
	 * @param suitSymbol the suit symbol to be instantiated
	 */
	SuitEnum(char suitSymbol)
	{
		this.suitSymbol = suitSymbol;
	}
	
	/**
	 * Returns the Suit as a String
	 *
	 * @return the string that represents the suit
	 */
	public String suit()
	{
		return suit;
	}
	
	/**
	 * Returns the Suit symbol as a Character.
	 *
	 * @return the char that represents the Suit Symbol
	 */
	public char suitSymbol()
	{
		return suitSymbol;
	}
	
}
package problem2;

import java.util.Objects;

/**
 * The CardImpl Class implements the Card interface .
 * Card contains Rank and Suit.
 * 
 * @author vaibhav
 */
public class CardImpl implements Card{
	
	/** The rank of the Card */
	private Rank rank;
	
	/** The suit of the Card */
	private Suit suit;
	
	/* 
	 * Returns the rank of the Card
	 * 
	 * @return the rank of the current Card
	 * */
	public Rank getRank() {
		return rank;
	}
	
	/**
	 * Sets the rank in the Card
	 *
	 * @param rank the rank to be set
	 */
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	/*
	 Returns the suit of the Card
	 * 
	 * @return the suit of the current Card
	 */
	public Suit getSuit() {
		return suit;
	}
	
	/**
	 * Sets the suit in the card
	 *
	 * @param the new suit to be set in the card
	 */
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	
	/* 
	 * Returns the String representation of the object
	 * 
	 * @return the String representation of the object
	 */
	@Override
	public String toString() {
		return rank.toString()+" "+suit.toString();
	}
	
	/**
	 * Instantiates a new card.
	 *
	 * @param rank the rank of the card
	 * @param suit the suit of the card
	 */
	public CardImpl(Rank rank, Suit suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}
	
	/**
	 * Instantiates a new card .
	 */
	public CardImpl() {
		super();
	}
	
	/* 
	 * Compares if the given object is equal to the current object of the class
	 * 
	 * @param c the card object to be compared to the current object
	 * @return true if the two objects are equal else false. 
	 */
	@Override
    public boolean equals(Object c){
        if (c == this) return true;
        
        if (!(c instanceof CardImpl))
        {
            return false;
        }
        CardImpl card = (CardImpl) c;
        return suit.equals(card.suit) && rank.equals(card.rank);
    }

    /* 
     * Returns the hash representation or hashCode of the card object
     * 
     *@return the hashCode of the card object
     */
    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }
	
	
}

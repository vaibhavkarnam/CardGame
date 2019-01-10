package edu.northeastern.ccs.cs5500.homework3;

import java.util.List;
/**
 * The Class IteratorImpl implements the Iterator interface.
 * Iterator iterates over an aggregate object such as hand * 
 * @author vaibhav
 */

public class IteratorImpl implements Iterator {

	/**
	 * Instantiates a new Iterator.
	 *
	 * @param hand list of cards which represents a hand
	 */
	public IteratorImpl(List<Card> hand) {
		super();
		this.hand = hand;
		count = 0;
	}

	/** Represents the hand of cards as a list*/
	private List<Card> hand;
	/** Counter for the iterator*/
	private int count;
	
	/**
	* Returns the first card of a hand
	*
	* @return the first card in a hand
	*/
	public Card first()
	{
		return hand.get(0);
	}
	/**
	* Returns the next card of a hand
	*
	* @return the next card in a hand
	*/
	public Card next()
	{
		return hand.get(count+1);
	}
	/**
	* Returns true if there are no cards after the current card else false
	*
	* @return true if there are no cards after the current card else false

	*/
	public boolean isDone()
	{
		
		return (count >= hand.size());
	}
	/**
	* Returns true if there are cards after the current card else false
	*
	* @return true if there are cards after the current card else false

	*/
	public Card current()
	{
		return hand.get(count);
	}
	/**
	* Returns the current card where the iterator's pointer is pointing to
	*
	* @return current card where the iterator's pointer is pointing to

	*/	
	public boolean hasNext()
	{
		return (count < hand.size());
	}
	
}

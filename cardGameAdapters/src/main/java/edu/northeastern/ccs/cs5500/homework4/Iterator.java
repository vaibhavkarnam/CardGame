package edu.northeastern.ccs.cs5500.homework4;

/**
 * The Interface Iterator.
 * Iterator iterates over an aggregate object such as hand
 * 
 * @author vaibhav
 */
public interface Iterator {
	/**
	 * Returns the first card of a hand
	 *
	 * @return the first card in a hand
	 */
	 Card first();
	/**
	* Returns the next card of a hand
	*
	* @return the next card in a hand
	*/
	 Card next();      
	/**
	* Returns true if there are no cards after the current card else false
	*
	* @return true if there are no cards after the current card else false

	*/
	 boolean isDone();
	/**
	* Returns true if there are cards after the current card else false
	*
	* @return true if there are cards after the current card else false

	*/
	 boolean hasNext();
	/**
	* Returns the current card where the iterator's pointer is pointing to
	*
	* @return current card where the iterator's pointer is pointing to

	*/	 
	 
	 Card current();      
	
}


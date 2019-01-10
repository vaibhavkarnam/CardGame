package edu.northeastern.ccs.cs5500.homework4;

import java.util.Comparator;

/**
 * The Class SuitSortComparator implements the comparator interface
 * Compares the two objects for sorting
 */
public class SuitSortComparator implements Comparator<Card>{

	/*
	 * Compares the two objects for sorting
	 * 
	 * @param c1 represents a card in the list
	 * @param c2 represents the next card in the list
	 * @return an integer -1, 0 or 1 to say if the first object is less than, equal, or greater 
	 * to the second object. 
	 */
	@Override
	public int compare(Card c1, Card c2) {
		
		return  c1.getSuit().getName().compareTo(c2.getSuit().getName());
	}

}

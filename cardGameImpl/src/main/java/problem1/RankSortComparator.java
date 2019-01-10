package problem1;

import java.util.Comparator;

/**
 * The Class RankSortComparator implements the comparator interface
 * Compares the two objects for sorting
 */
public class RankSortComparator implements Comparator<Card>{

	/*
	 * Compares the two objects for sorting
	 * 
	 * @return an integer -1, 0 or 1 to say if the first object is less than, equal, or greater 
	 * to the second object. 
	 */
	@Override
	public int compare(Card o1, Card o2) {
		
		return o1.getRank().getPips().compareTo(o2.getRank().getPips());
	}

}

package problem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Class HandImpl implements the hand interface.
 * a hand represents a player in the game
 * 
 * @author vaibhav
 */
public class HandImpl implements Hand {
	
	/** Represents the hand of cards as a list*/
	List<Card> hand = new ArrayList<>();

	/**
	 * Returns the cards of a hand
	 *
	 * @return the list of cards in a hand
	 */
	public List<Card> showCards()
	{
		return hand;
	}
	
	/**
	 * Adds the card to the hand
	 *
	 * @param card the card to be added to the handed
	 */
	public void accept(Card card)
	{
		hand.add(card);
	}
	
	/**
	 * Returns the first card from the hand
	 *
	 * @return the first card from the hand
	 */
	public Card pullCard()
	{
		return hand.remove(0);
	}
	
	/**
	 * Checks if the hand contains the specified card
	 *
	 * @param card the card to be checked
	 * @return true if the hand contains the card else false
	 */
	public boolean hasCard(Card card)
	{
		return hand.contains(card);
	}
	
	/**
	 * Shuffles the card of hands so that the order of cards is changed
	 * the cards within the hand are randomly ordered
	 */
	public void shuffle()
	{
		Collections.shuffle(hand);
	}
	
	/**
	 * Sorts the cards in a hand byRank, bySuit or both by rank and suit.
	 *
	 * @param bySuitRankboth specifies the type of sorting
	 */
	public void sort(String bySuitRankBoth)
	{
		if(bySuitRankBoth.equals("Rank"))
		{
			sortHandByRank(hand);
		}
		else if(bySuitRankBoth.equals("Suit"))
		{
			sortHandBySuit();
		}
		else if(bySuitRankBoth.equals("both"))
		{
			sortHandByBothRankAndSuit();

		}
		
	}

/**
 * Sort hand by rank.
 *
 * @param handToSort the hand to sort
 */
private void sortHandByRank(List<Card> handToSort) {
		
		List<Card> faceCards = new ArrayList<>();
		Collections.sort(handToSort, new RankSortComparator());
		for(Card c : handToSort)
		{
			if(c.getRank().getPips() == 0)
			{
				faceCards.add(c);
			}
		}
		for(Iterator<Card> handIterator = handToSort.iterator(); handIterator.hasNext();)
		{
			Card card = handIterator.next();

			if(card.getRank().getPips() == 0)
			{
				handIterator.remove();
			}
		}
		for(Card c : faceCards)
		{
			if(c.getRank().getName().equals(RankEnum.JACK.rank()))
			{
				handToSort.add(c);
			}
		}
		for(Card c : faceCards)
		{
			if(c.getRank().getName().equals(RankEnum.QUEEN.rank()))
			{
				handToSort.add(c);
			}
		}
		for(Card c : faceCards)
		{
			if(c.getRank().getName().equals(RankEnum.KING.rank()))
			{
				handToSort.add(c);
			}
		}
		faceCards.clear();
		
	}
	
	/**
	 * Sort hand by suit.
	 */
	private void sortHandBySuit() 
	{
		
		Collections.sort(hand, new SuitSortComparator());
		
	}
	
	/**
	 * Sort hand by both rank and suit.
	 */
	private void sortHandByBothRankAndSuit()
	{
		Collections.sort(hand, new SuitSortComparator());
		List<Card> spadeHand = hand.stream()
				  .filter(s -> s.getSuit().getSymbol().equals(SuitEnum.SPADESYMBOL.suitSymbol()))
				  .collect(Collectors.toList());
		List<Card> clubHand = hand.stream()
				  .filter(s -> s.getSuit().getSymbol().equals(SuitEnum.CLUBSYMBOL.suitSymbol()))
				  .collect(Collectors.toList());
		List<Card> diamondHand = hand.stream()
				  .filter(s -> s.getSuit().getSymbol().equals(SuitEnum.DIAMONDSYMBOL.suitSymbol()))
				  .collect(Collectors.toList());
		List<Card> heartHand = hand.stream()
				  .filter(s -> s.getSuit().getSymbol().equals(SuitEnum.HEARTSYMBOL.suitSymbol()))
				  .collect(Collectors.toList());
		
		sortHandByRank(spadeHand);
		sortHandByRank(clubHand);
		sortHandByRank(diamondHand);
		sortHandByRank(heartHand);
		
		hand.clear();
		
		for(Card c : spadeHand)
		{
			hand.add(c);
			
		}
		for(Card c : clubHand)
		{
			hand.add(c);
			
		}
		for(Card c : diamondHand)
		{
			hand.add(c);
			
		}
		for(Card c : heartHand)
		{
			hand.add(c);
			
		}

		
	}



}

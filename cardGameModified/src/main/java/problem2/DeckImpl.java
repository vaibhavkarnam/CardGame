package problem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The Class DeckImpl which implements the deck interface
 * A deck is set of cards represented as list of cards
 * 
 * @author vaibhav
 */
public class DeckImpl implements Deck{
	
	/** Represents the deck of cards */
	List<Card> deck = new ArrayList<>();
	
	/**
	 * Instantiates a new deck impl.
	 */
	public DeckImpl() {
		super();
	}
	
	/**
	 * Shuffles the deck of cards so that the order of cards is changed
	 * the cards within the deck are randomly ordered
	 */
	public void shuffle()
	{
		Collections.shuffle(deck);
	}
	
	/**
	 * Sorts the deck of cards byRank, bySuit or both by rank and suit.
	 *
	 * @param bySuitRankboth specifies the type of sorting
	 */
	public void sort(String bySuitRankBoth)
	{
		if(bySuitRankBoth.equals("Rank"))
		{
			sortDeckByRank(deck);
		}
		else if(bySuitRankBoth.equals("Suit"))
		{
			sortDeckBySuit();
		}
		else if(bySuitRankBoth.equals("both"))
		{
			sortDeckByBothRankAndSuit();

		}
		
	}
	
	/**
	 * Places the first part of the deck separated by cutPoint at the end of the deck in order.
	 *
	 * @param cutPoint the point until which the cards before in the deck are moved to the end of deck
	 */
	public void cut(int cutPoint)
	{
		List <Card> cutDeck = new ArrayList<>();
		for(int ele = cutPoint; ele < deck.size(); ele++)
		{
			cutDeck.add(deck.get(ele));
		}
		for(int ele = 0; ele < cutPoint; ele++)
		{
			cutDeck.add(deck.get(ele));
		}
		deck.clear();
		deck = cutDeck.stream()
				  .collect(Collectors.toList());
	}
	
	/**
	 * Returns the top card in the deck
	 *
	 * @return top card in deck
	 */
	public Card pullCard()
	{
		return deck.remove(deck.size()-1);
	}
	
	/**
	 * Checks if the deck is empty or not
	 *
	 * @return true if deck is empty else false
	 */
	public boolean emptyDeck()
	{
		return deck.isEmpty();
	}
	
	/**
	 * Returns the deck of cards
	 *
	 * @return List of cards which represents the deck
	 */
	public List<Card> getDeck()
 	{
 		return deck;
 	}
	
	/**
	 * Sort deck by rank.
	 *
	 * @param deckToSort the deck to sort
	 */
	private void sortDeckByRank(List<Card> deckToSort) {
		
		List<Card> faceDeck = new ArrayList<>();
		Collections.sort(deckToSort, new RankSortComparator());
		for(Card c : deckToSort)
		{
			if(c.getRank().getPips() == 0)
			{
				faceDeck.add(c);
			}
		}
		for(Iterator<Card> deckIterator = deckToSort.iterator(); deckIterator.hasNext();)
		{
			Card card = deckIterator.next();

			if(card.getRank().getPips() == 0)
			{
				deckIterator.remove();
			}
		}
		for(Card c : faceDeck)
		{
			if(c.getRank().getName().equals(RankEnum.JACK.rank()))
			{
				deckToSort.add(c);
			}
		}
		for(Card c : faceDeck)
		{
			if(c.getRank().getName().equals(RankEnum.QUEEN.rank()))
			{
				deckToSort.add(c);
			}
		}
		for(Card c : faceDeck)
		{
			if(c.getRank().getName().equals(RankEnum.KING.rank()))
			{
				deckToSort.add(c);
			}
		}
		faceDeck.clear();
		
	}
	
	/**
	 * Sort deck by suit.
	 */
	private void sortDeckBySuit() 
	{
		
		Collections.sort(deck, new SuitSortComparator());
		
	}
	
	/**
	 * Sort deck by both rank and suit.
	 */
	private void sortDeckByBothRankAndSuit()
	{
		Collections.sort(deck, new SuitSortComparator());
		List<Card> spadeDeck = deck.stream()
				  .filter(s -> s.getSuit().getSymbol().equals(SuitEnum.SPADESYMBOL.suitSymbol()))
				  .collect(Collectors.toList());
		List<Card> clubDeck = deck.stream()
				  .filter(s -> s.getSuit().getSymbol().equals(SuitEnum.CLUBSYMBOL.suitSymbol()))
				  .collect(Collectors.toList());
		List<Card> diamondDeck = deck.stream()
				  .filter(s -> s.getSuit().getSymbol().equals(SuitEnum.DIAMONDSYMBOL.suitSymbol()))
				  .collect(Collectors.toList());
		List<Card> heartDeck = deck.stream()
				  .filter(s -> s.getSuit().getSymbol().equals(SuitEnum.HEARTSYMBOL.suitSymbol()))
				  .collect(Collectors.toList());
		
		sortDeckByRank(spadeDeck);
		sortDeckByRank(clubDeck);
		sortDeckByRank(diamondDeck);
		sortDeckByRank(heartDeck);
		
		deck.clear();
		
		for(Card c : spadeDeck)
		{
			deck.add(c);
			
		}
		for(Card c : clubDeck)
		{
			deck.add(c);
			
		}
		for(Card c : diamondDeck)
		{
			deck.add(c);
			
		}
		for(Card c : heartDeck)
		{
			deck.add(c);
			
		}
		
	}
	
	/* 
	 * Compares if the given object is equal to the current object of the class
	 * 
	 * @param d the deck object to be compared to the current object
	 * @return true if the two objects are equal else false. 
	 */
	@Override
    public boolean equals(Object d){
        if (d == this) return true;
        
        if (!(d instanceof DeckImpl))
        {
            return false;
        }
        DeckImpl deckList = (DeckImpl) d;
        return deck.equals(deckList.deck);
    }

    /* 
     * Returns the hash representation or hashCode of the deck object
     * 
     *@return the hashCode of the deck object
     */
    @Override
    public int hashCode() {
        return Objects.hash(deck);
    }
	

}

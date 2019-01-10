package edu.northeastern.ccs.cs5500.homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The Class PinochleDeckImpl which extends DeckImpl implements Pinochle interface
 * A deck is set of cards represented as list of cards
 *  A pinochle deck, which is composed 9, 10, J, Q, K, and A of the four suits, but there are two copies
 * of each suit. There are 48 cards in total.
 * 
 * @author vaibhav
 */
public class PinochleDeckImpl extends DeckImpl implements Pinochle {

 	
 	/**
	  * Instantiates a new pinochle deck.
	  */
	 public PinochleDeckImpl() {
 		
		List<Rank> ranks = new ArrayList<>();
		List<Suit> suits = new ArrayList<>();
		final int NUMOFDECKS = 2;

		
		suits.add(new SuitImpl(SuitEnum.SPADE.suit(),SuitEnum.SPADESYMBOL.suitSymbol()));
		suits.add(new SuitImpl(SuitEnum.DIAMOND.suit(),SuitEnum.DIAMONDSYMBOL.suitSymbol()));
		suits.add(new SuitImpl(SuitEnum.CLUB.suit(),SuitEnum.CLUBSYMBOL.suitSymbol()));
		suits.add(new SuitImpl(SuitEnum.HEART.suit(),SuitEnum.HEARTSYMBOL.suitSymbol()));
		
		ranks.add(new RankImpl(RankEnum.JACK.rank(),0));
		ranks.add(new RankImpl(RankEnum.QUEEN.rank(),0));
		ranks.add(new RankImpl(RankEnum.KING.rank(),0));
		ranks.add(new RankImpl(RankEnum.ACE.rank(),1));
		ranks.add(new RankImpl(RankEnum.NINE.rank(),9));
		ranks.add(new RankImpl(RankEnum.TEN.rank(),10));
		
		for(int i=0;i<NUMOFDECKS;i++)
		{
		for(Rank r : ranks)
		{
			for(Suit s : suits)
			{
			deck.add(new CardAdapter(r,s));
			}
		}
		}
		
	}
 	
/**
 * Instantiates the specified number of pinochle deck as single deck.
 *
 * @param noOfDecks the no of decks to be instantiated as a single deck.
 */
public PinochleDeckImpl(int noOfDecks) {
		List<Rank> ranks = new ArrayList<>();
		List<Suit> suits = new ArrayList<>();
		
		suits.add(new SuitImpl(SuitEnum.SPADE.suit(),SuitEnum.SPADESYMBOL.suitSymbol()));
		suits.add(new SuitImpl(SuitEnum.DIAMOND.suit(),SuitEnum.DIAMONDSYMBOL.suitSymbol()));
		suits.add(new SuitImpl(SuitEnum.CLUB.suit(),SuitEnum.CLUBSYMBOL.suitSymbol()));
		suits.add(new SuitImpl(SuitEnum.HEART.suit(),SuitEnum.HEARTSYMBOL.suitSymbol()));
		
		ranks.add(new RankImpl(RankEnum.JACK.rank(),0));
		ranks.add(new RankImpl(RankEnum.QUEEN.rank(),0));
		ranks.add(new RankImpl(RankEnum.KING.rank(),0));
		ranks.add(new RankImpl(RankEnum.ACE.rank(),1));
		ranks.add(new RankImpl(RankEnum.NINE.rank(),9));
		ranks.add(new RankImpl(RankEnum.TEN.rank(),10));
		
		for(int i=0;i<noOfDecks;i++)
		{
		for(Rank r : ranks)
		{
			for(Suit s : suits)
			{
			deck.add(new CardImpl(r,s));
			}
		}
		for(Rank r : ranks)
		{
			for(Suit s : suits)
			{
			deck.add(new CardAdapter(r,s));
			}
		}
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
        
        if (!(d instanceof PinochleDeckImpl))
        {
            return false;
        }
        PinochleDeckImpl deckList = (PinochleDeckImpl) d;
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

package edu.northeastern.ccs.cs5500.homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The Class EuchreDeckImpl which extends DeckImpl implements Euchre interface
 * A deck is set of cards represented as list of cards
 * A Euchre deck is a set of cards which is composed of 9, 10, J, Q, K, and A 
 * of the four suits 24 cards in total
 */
public class EuchreDeckImpl extends DeckImpl implements Euchre{
	
   	
 	/**
	  * Instantiates a new euchre deck.
	  */
	 public EuchreDeckImpl() {
 		
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
		
		
		for(Rank r : ranks)
		{
			for(Suit s : suits)
			{
			deck.add(new CardAdapter(r,s));
			}
		}
		
	}
 	
/**
 * Instantiates a new euchre deck.
 *
 * @param noOfDecks the no of decks that needs to be instantiated.
 */
public EuchreDeckImpl(int noOfDecks) {
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
        
        if (!(d instanceof EuchreDeckImpl))
        {
            return false;
        }
        EuchreDeckImpl deckList = (EuchreDeckImpl) d;
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

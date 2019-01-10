package edu.northeastern.ccs.cs5500.homework3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The Class VegasDeckImpl which extends DeckImpl implements Vegas interface
 * It's composed of two or more standard decks. Typically it's six to eight
 * decks.
 * 
 * @author vaibhav
 */
public class VegasDeckImpl extends DeckImpl implements Vegas {
	
/**
 * Instantiates a new vegas deck.
 */
public VegasDeckImpl() {
 		
		List<Rank> ranks = new ArrayList<>();
		List<Suit> suits = new ArrayList<>();
		final int NUMOFDECKS = 8;
		
		suits.add(new SuitImpl(SuitEnum.SPADE.suit(),SuitEnum.SPADESYMBOL.suitSymbol()));
		suits.add(new SuitImpl(SuitEnum.DIAMOND.suit(),SuitEnum.DIAMONDSYMBOL.suitSymbol()));
		suits.add(new SuitImpl(SuitEnum.CLUB.suit(),SuitEnum.CLUBSYMBOL.suitSymbol()));
		suits.add(new SuitImpl(SuitEnum.HEART.suit(),SuitEnum.HEARTSYMBOL.suitSymbol()));
		
		ranks.add(new RankImpl(RankEnum.JACK.rank(),0));
		ranks.add(new RankImpl(RankEnum.QUEEN.rank(),0));
		ranks.add(new RankImpl(RankEnum.KING.rank(),0));
		ranks.add(new RankImpl(RankEnum.ACE.rank(),1));
		ranks.add(new RankImpl(RankEnum.TWO.rank(),2));
		ranks.add(new RankImpl(RankEnum.THREE.rank(),3));
		ranks.add(new RankImpl(RankEnum.FOUR.rank(),4));
		ranks.add(new RankImpl(RankEnum.FIVE.rank(),5));
		ranks.add(new RankImpl(RankEnum.SIX.rank(),6));
		ranks.add(new RankImpl(RankEnum.SEVEN.rank(),7));
		ranks.add(new RankImpl(RankEnum.EIGHT.rank(),8));
		ranks.add(new RankImpl(RankEnum.NINE.rank(),9));
		ranks.add(new RankImpl(RankEnum.TEN.rank(),10));
		

		for(int i=0;i<NUMOFDECKS;i++)
		{
		for(Rank r : ranks)
		{
			for(Suit s : suits)
			{
			deck.add(new CardImpl(r,s));
			}
		}
		}
		
	}
 	
/**
 * Instantiates the specified number of vegas deck of cards as a new deck.
 *
 * @param noOfDecks the no of decks of cards to be instantiated.
 */
public VegasDeckImpl(int noOfDecks) {
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
		ranks.add(new RankImpl(RankEnum.TWO.rank(),2));
		ranks.add(new RankImpl(RankEnum.THREE.rank(),3));
		ranks.add(new RankImpl(RankEnum.FOUR.rank(),4));
		ranks.add(new RankImpl(RankEnum.FIVE.rank(),5));
		ranks.add(new RankImpl(RankEnum.SIX.rank(),6));
		ranks.add(new RankImpl(RankEnum.SEVEN.rank(),7));
		ranks.add(new RankImpl(RankEnum.EIGHT.rank(),8));
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
        
        if (!(d instanceof VegasDeckImpl))
        {
            return false;
        }
        VegasDeckImpl deckList = (VegasDeckImpl) d;
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

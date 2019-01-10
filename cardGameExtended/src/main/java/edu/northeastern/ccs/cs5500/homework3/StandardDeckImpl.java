package edu.northeastern.ccs.cs5500.homework3;

import java.util.ArrayList;
import java.util.List;


/**
 * The Class StandardDeckImpl which extends DeckImpl implements Standard interface
 * A deck is set of cards represented as list of cards
 * Standard represents a standard deck of 52 Cards.
 */
public class StandardDeckImpl extends DeckImpl implements Standard{
	   	
 	/**
	  * Instantiates a new standard deck of cards.
	  */
	 public StandardDeckImpl() {
 		
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
		
		
		for(Rank r : ranks)
		{
			for(Suit s : suits)
			{
			deck.add(new CardImpl(r,s));
			}
		}
		
	}
 	
/**
 * Instantiates the specified number of standard deck of cards as a single deck.
 *
 * @param noOfDecks the no of decks that need to be instantiated as a single deck
 */
public StandardDeckImpl(int noOfDecks) {
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
	

}

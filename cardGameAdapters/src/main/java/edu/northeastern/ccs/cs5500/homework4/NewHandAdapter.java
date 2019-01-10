package edu.northeastern.ccs.cs5500.homework4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import diErBao.Ka;
import diErBao.Shou;
import diErBao.ShouShiXia;
import diErBao.kaShiXia;
import diErBao.kaShiXia.KaPianTaoZhuangEnum;

/**
 * The NewHandAdapter Class implements the NewHand interface .
 * It Adapts the Shou Interface to our implementation of NewHand
 * @author vaibhav
 */
public class NewHandAdapter implements NewHand{
	
	/** Used for mapping of rank of Shou back to NewHand */
	static Map<Integer,String> rankMap = new HashMap<>();
	/** Used for mapping of suit of Shou back to NewHand */
	static Map<Integer,String> suitMap = new HashMap<>();
	/** Used for mapping of suit symbol of Shou back to NewHand */
	static Map<Integer,Character> suitSymbolMap = new HashMap<>();

	
	static {
		rankMap.put(1,"Ace");
		rankMap.put(0,"Jack");
		rankMap.put(0,"Queen");
		rankMap.put(0,"King");
		rankMap.put(2,"Two");
		rankMap.put(3,"Three");
		rankMap.put(4,"Four");
		rankMap.put(5,"Five");
		rankMap.put(6,"Six");
		rankMap.put(7,"Seven");
		rankMap.put(8,"Eight");
		rankMap.put(9,"Nine");
		rankMap.put(10,"Ten");
		
		
		suitMap.put(0,"Heart");
		suitMap.put(1,"Spade");
		suitMap.put(2,"Diamond");
		suitMap.put(3,"Club");
		
		suitSymbolMap.put(0,SuitEnum.HEARTSYMBOL.suitSymbol());
		suitSymbolMap.put(1,SuitEnum.SPADESYMBOL.suitSymbol());
		suitSymbolMap.put(2,SuitEnum.DIAMONDSYMBOL.suitSymbol());
		suitSymbolMap.put(3,SuitEnum.CLUBSYMBOL.suitSymbol());
		
	}
	/**
	 * Instantiates a NewHandAdapter of Type Card.
	 */
	public NewHandAdapter() {
		super();
		shouObj = new ShouShiXia();
	}

	/** Reprents the Shou*/
	Shou shouObj;

	/**
	 * Adds the card to the Shou
	 *
	 * @param card the card to be added to the Shou
	 */
	@Override
	public void accept(Card card) {
		
		CardAdapter cardAdapter = new CardAdapter(card.getRank(), card.getSuit());
		Ka kaCard = cardAdapter.returnKa();
		shouObj.accept(kaCard);
		
	}

	/**
	 * Checks if the Shou contains the specified card
	 *
	 * @param card the card to be checked
	 * @return true if the Shou contains the card else false
	 */
	@Override
	public boolean hasCard(Card card) {
		
		CardAdapter cardAdapter = new CardAdapter(card.getRank(), card.getSuit());
		Ka kaCard = cardAdapter.returnKa();
		return shouObj.hasKa(kaCard);

	}
	
	/**
	 * Returns the first card from the Shou
	 *
	 * @return the first card from the Shou
	 */
	@Override
	public Card pullCard() {

		Ka kaCard =  shouObj.pullKa();
		
		return new CardAdapter(kaCard);
				
	}

	/**
	 * Shuffles the card of Shou so that the order of Ka's is changed
	 * the Ka's within the Shou are randomly ordered
	 */
	@Override
	public void shuffle() {
		
		((ShouShiXia) shouObj).shuffle();
		
	}

	/**
	 * Sorts the cards in a hand byRank, bySuit or both by rank and suit.
	 *
	 * @param bySuitRankboth specifies the type of sorting
	 */
	@Override
	public void sort(String sortType) {
		
		if(sortType.equals("Rank"))
		{
			shouObj.sort();
		}
		else if(sortType.equals("Suit"))
		{
			sortHandBySuit();
		}
		else if(sortType.equals("both"))
		{
			sortHandByBoth();
		}
		
		
	}

	/**
	 * Returns the cards of a Shou
	 *
	 * @return the list of cards in a Shou
	 */
	@Override
	public List<Card> showCards() {
		
		List<Card> cards = new ArrayList<>();
		
		List<Ka> kaCards = ((ShouShiXia) shouObj).showHand();
		
		for(Ka ka : kaCards)
		{
			cards.add(new CardAdapter(ka));
		}
		
		return cards;		
	}
	
	/**
	 * Checks if the Shou contains the specified card
	 *
	 * @param Card the card to be checked
	 * @return true if the Shou contains the card else false
	 */

	@Override
	public int occurrencesInHand(Card cardToFind) {
		
		List<Card> cards = new ArrayList<>();
		
		List<Ka> kaCards = ((ShouShiXia) shouObj).showHand();
		
		for(Ka ka : kaCards)
		{
			cards.add(new CardAdapter(ka));
		}
		
	return (int) cards.stream()
			.filter(c -> c.getRank().equals(cardToFind.getRank())
				&& c.getSuit().equals(cardToFind.getSuit())).count();
		
		
	}

	/**
	 * Checks the number of times the card with specified rank occurs in the Shou
	 *
	 * @param Rank for the card to be found
	 * @return the number of occurrences of the card
	 */
	@Override
	public int occurrencesInHand(Rank rankToFind) {
		
		List<Card> cards = new ArrayList<>();
		
		List<Ka> kaCards = ((ShouShiXia) shouObj).showHand();
		
		for(Ka ka : kaCards)
			{
				cards.add(new CardAdapter(ka));
			}
		
		return (int) cards.stream()
				.filter(c -> c.getRank().equals(rankToFind)).count();
		
	}
	
	/**
	 * Sort Shou by suit. Comparator has been changed so the order will be based on suit names 
	 * instead of suit symbols in earlier assignment
	 */
	private void sortHandBySuit()
	{
		List<Card> cards = new ArrayList<>();
		
		while(((ShouShiXia) shouObj).getHandSize()>0)
		{
			cards.add(new CardAdapter(((ShouShiXia) shouObj).pullKa()));
		}
		
		
		Collections.sort(cards, new SuitSortComparator());
		
		while(!cards.isEmpty())
		{
			Card c = cards.remove(0);
						
			((ShouShiXia) shouObj).accept(createKa
					(c.getRank(),c.getSuit()));
		}

		
		
	}
	
	/**
	 * Sort Shou by both rank and suit.
	 */
	private void sortHandByBoth()
	{
		List<Card> cards = new ArrayList<>();
		
		List<Card> copiedCards = new ArrayList<>();

		while(((ShouShiXia) shouObj).getHandSize()>0)
		{
			cards.add(new CardAdapter(((ShouShiXia) shouObj).pullKa()));
		}
		
		Collections.sort(cards, new SuitSortComparator());
		
		List<Card> spadeHand = cards.stream()
				  .filter(s -> s.getSuit().getSymbol().equals(SuitEnum.SPADESYMBOL.suitSymbol()))
				  .collect(Collectors.toList());
		List<Card> clubHand = cards.stream()
				  .filter(s -> s.getSuit().getSymbol().equals(SuitEnum.CLUBSYMBOL.suitSymbol()))
				  .collect(Collectors.toList());
		List<Card> diamondHand = cards.stream()
				  .filter(s -> s.getSuit().getSymbol().equals(SuitEnum.DIAMONDSYMBOL.suitSymbol()))
				  .collect(Collectors.toList());
		List<Card> heartHand = cards.stream()
				  .filter(s -> s.getSuit().getSymbol().equals(SuitEnum.HEARTSYMBOL.suitSymbol()))
				  .collect(Collectors.toList());
		
		
		while(!clubHand.isEmpty())
		{
			Card c = clubHand.remove(0);
			
			((ShouShiXia) shouObj).accept(createKa
					(c.getRank(),c.getSuit()));
		}
		
		shouObj.sort();
				
		while(((ShouShiXia) shouObj).getHandSize()>0)
		{
			copiedCards.add(new CardAdapter(((ShouShiXia) shouObj).pullKa()));
		}
		
		
		while(!diamondHand.isEmpty())
		{
			Card c = diamondHand.remove(0);
			
			((ShouShiXia) shouObj).accept(createKa
					(c.getRank(),c.getSuit()));
		}
		
		shouObj.sort();
		
		while(((ShouShiXia) shouObj).getHandSize()>0)
		{
			copiedCards.add(new CardAdapter(((ShouShiXia) shouObj).pullKa()));
		}
		
		while(!heartHand.isEmpty())
		{
			Card c = heartHand.remove(0);
			
			((ShouShiXia) shouObj).accept(createKa
					(c.getRank(),c.getSuit()));
			
		}
		
		shouObj.sort();
		
		while(((ShouShiXia) shouObj).getHandSize()>0)
		{
			copiedCards.add(new CardAdapter(((ShouShiXia) shouObj).pullKa()));
		}
		
		while(!spadeHand.isEmpty())
		{
			Card c = spadeHand.remove(0);
			
			((ShouShiXia) shouObj).accept(createKa
					(c.getRank(),c.getSuit()));
			
		}
		
		shouObj.sort();
		
		while(((ShouShiXia) shouObj).getHandSize()>0)
		{
			copiedCards.add(new CardAdapter(((ShouShiXia) shouObj).pullKa()));
		}
		
		while(!copiedCards.isEmpty())
		{
			Card c = copiedCards.remove(0);
			
			((ShouShiXia) shouObj).accept(createKa
					(c.getRank(),c.getSuit()));
			
		}
		
		
	}
	/**
	 * Instantiates a Card of Type Ka.
	 * 
	 * @param rank the rank of the card
	 * @param suit the suit of the card
	 */
	private Ka createKa(Rank rank, Suit suit)
	{
		
		return  new kaShiXia(createKaRank(rank),createKaSuit(suit));
		
		
	}
	/**
	 * Maps the Rank values of the Card to ranks of Ka
	 * 
	 * @param rank the rank of the card
	 */
	private int createKaRank(Rank rank)
	{
        switch(rank.getName()) 
        { 
            case "Two": 
            	return 1;
            case "Three": 
            	return 2;
            case "Four": 
            	return 3;
            case "Five": 
            	return 4;
            case "Six": 
            	return 5;
            case "Seven": 
            	return 6;
            case "Eight": 
            	return 7;
            case "Nine": 
            	return 8;
            case "Ten": 
            	return 9;
            case "Jack": 
            	return 10;
            case "Queen": 
            	return 11;
            case "King": 
            	return 12;
            case "Ace": 
            	return 0;
            default: 
                return 14; 
        } 
	}
	
	/**
	 Returns the suit of the Card by mapping Ka back to Card
	 * 
	 * @return the suit of the current Card
	 */
	private int createKaSuit(Suit suit)
	{
		switch(suit.getName()) 
        { 
            case "Spade": 
            	return KaPianTaoZhuangEnum.tieQiao.ordinal();
            case "Heart": 
            	return KaPianTaoZhuangEnum.xin.ordinal();
            case "Diamond": 
            	return KaPianTaoZhuangEnum.zuanShi.ordinal();
            case "Club": 
            	return KaPianTaoZhuangEnum.juLeBu.ordinal(); 
            default:
            	throw new IllegalArgumentException("Not a Vaild Suit");
        }
	}
	

}

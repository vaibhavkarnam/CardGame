package edu.northeastern.ccs.cs5500.homework4;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import diErBao.Ka;
import diErBao.kaShiXia;
import diErBao.kaShiXia.KaPianTaoZhuangEnum;

/**
 * The CardAdapter Class implements the Card interface .
 * It Adapts the Ka Interface to our implementation of Card
 * @author vaibhav
 */
public class CardAdapter implements Card {
	
	/** The Card of type Ka*/
	Ka kaCard;
	
	/** Used for mapping of Ka back to Card */
	static Map<Integer,String> kaMap = new HashMap<>();
	/** Used for mapping of pips of Ka back to Card */
	static Map<Integer,Integer> kaPipsMap = new HashMap<>();

	static {
		kaMap.put(5,"Six");
		kaMap.put(9,"Ten");
		kaMap.put(0,"Ace");
		kaMap.put(4,"Five");
		kaMap.put(8,"Nine");
		kaMap.put(12,"King");
		kaMap.put(3,"Four");
		kaMap.put(7,"Eight");
		kaMap.put(11,"Queen");
		kaMap.put(2,"Three");
		kaMap.put(6,"Seven");
		kaMap.put(10,"Jack");
		kaMap.put(1,"Two");
		
		kaPipsMap.put(5,6);
		kaPipsMap.put(9,10);
		kaPipsMap.put(0,1);
		kaPipsMap.put(4,5);
		kaPipsMap.put(8,9);
		kaPipsMap.put(12,0);
		kaPipsMap.put(3,4);
		kaPipsMap.put(7,8);
		kaPipsMap.put(11,0);
		kaPipsMap.put(2,3);
		kaPipsMap.put(6,7);
		kaPipsMap.put(10,0);
		kaPipsMap.put(1,2);

	}
	
	/**
	 * Instantiates a CardAdpater of Type Card.
	 * 
	 * @param rank the rank of the card
	 * @param suit the suit of the card
	 */
	public CardAdapter(Rank rank, Suit suit) {
		super();
		createKa(rank,suit);
	}
	
	/**
	 * Instantiates a CardAdpater of Type Card.
	 * 
	 * @param kaCard the crad of type Ka
	 */
	public CardAdapter(Ka kaCard) {
		super();
		this.kaCard = kaCard;
	}

	/** 
	 * Returns the rank of the Card by mapping Ka back to Card
	 * 
	 * @return the rank of the current Card
	 * */
	@Override
	public Rank getRank() {
		
		int num = kaCard.getRank();
		return new RankImpl(kaMap.get(num),kaPipsMap.get(num));
		
	}

	/**
	 Returns the suit of the Card by mapping Ka back to Card
	 * 
	 * @return the suit of the current Card
	 */
	@Override
	public Suit getSuit() {
		
		int num = kaCard.getSuit();
		KaPianTaoZhuangEnum kaSuit = KaPianTaoZhuangEnum.values()[num];
		
		switch(kaSuit.name())
		{
		  case "xin": 
          	return new SuitImpl(SuitEnum.HEART.suit(),SuitEnum.HEARTSYMBOL.suitSymbol());
		  case "tieQiao": 
	          	return new SuitImpl(SuitEnum.SPADE.suit(),SuitEnum.SPADESYMBOL.suitSymbol());
		  case "zuanShi": 
	          	return new SuitImpl(SuitEnum.DIAMOND.suit(),SuitEnum.DIAMONDSYMBOL.suitSymbol());
		  case "juLeBu": 
	          	return new SuitImpl(SuitEnum.CLUB.suit(),SuitEnum.CLUBSYMBOL.suitSymbol());
	      default :
	    	  return null;    	
		}
	}
	
	/**
	 * Instantiates a Card of Type Ka.
	 * 
	 * @param rank the rank of the card
	 * @param suit the suit of the card
	 */
	private void createKa(Rank rank, Suit suit)
	{
		
		kaCard = new kaShiXia(createKaRank(rank),createKaSuit(suit));	
		
	}
	
	/**
	 Returns the card of type Ka
	 * 
	 * @return the card of type Ka
	 */
	public Ka returnKa()
	{
		return kaCard;
		
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
	 * Maps the Suit values of the Card to suits of Ka
	 * 
	 * @param suit the suit of the card
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
	/** 
	 * Returns the String representation of the object
	 * 
	 * @return the String representation of the object
	 */
	@Override
	public String toString() {
		return getRank().toString()+" "+getSuit().toString();
	}

	/** 
	 * Compares if the given object is equal to the current object of the class
	 * 
	 * @param c the card object to be compared to the current object
	 * @return true if the two objects are equal else false. 
	 */
	@Override
    public boolean equals(Object c){
        if (c == this) return true;
        
        if (!(c instanceof CardAdapter))
        {
            return false;
        }
        CardAdapter card = (CardAdapter) c;
        return getSuit().equals(card.getSuit()) && getRank().equals(card.getRank());
    }

    /** 
     * Returns the hash representation or hashCode of the card object
     * 
     *@return the hashCode of the card object
     */
    @Override
    public int hashCode() {
        return Objects.hash(getSuit(), getRank());
    }
	
	
	

}

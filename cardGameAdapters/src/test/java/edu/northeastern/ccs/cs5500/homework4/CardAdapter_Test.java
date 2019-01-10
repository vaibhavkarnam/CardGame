package edu.northeastern.ccs.cs5500.homework4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CardAdapter_Test {
	
	/**
	 * Checks if Jack of spade card is created correctly.
	 */
	@Test
	   public void jackOfSpade_Card_Equal() {
		
		Card c = new CardAdapter((new RankImpl("Jack",0)),(new SuitImpl("Spade",(char)'\u2660')));	
		
	      //To Check that two objects are equal
	      assertEquals("Jack",c.getRank().getName());
	      assertEquals(new Integer(0),c.getRank().getPips());
	      assertEquals("Spade",c.getSuit().getName());
	      assertEquals(new Character('\u2660'),c.getSuit().getSymbol());
}
	
	
	/**
	 * Checks if Jack of spade card is created correctly.
	 */
	@Test
	   public void QueenOfSpade_Card_Equal() {
		
		Card c = new CardAdapter((new RankImpl("Queen",0)),(new SuitImpl("Spade",(char)'\u2660')));	
		
	      //To Check that two objects are equal
	      assertEquals("Queen",c.getRank().getName());
	      assertEquals(new Integer(0),c.getRank().getPips());
	      assertEquals("Spade",c.getSuit().getName());
	      assertEquals(new Character('\u2660'),c.getSuit().getSymbol());
}
	
	/**
	 * Checks if Jack of spade card is created correctly.
	 */
	@Test
	   public void AceOfSpade_Card_Equal() {
		
		Card c = new CardAdapter((new RankImpl("Ace",1)),(new SuitImpl("Spade",(char)'\u2660')));	
		
	      //To Check that two objects are equal
	      assertEquals("Ace",c.getRank().getName());
	      assertEquals(new Integer(1),c.getRank().getPips());
	      assertEquals("Spade",c.getSuit().getName());
	      assertEquals(new Character('\u2660'),c.getSuit().getSymbol());
}
	
	/**
	 * Checks if Jack of spade card is created correctly.
	 */
	@Test
	   public void KingOfSpade_Card_Equal() {
		
		Card c = new CardAdapter((new RankImpl("King",0)),(new SuitImpl("Spade",(char)'\u2660')));	
		
	      //To Check that two objects are equal
	      assertEquals("King",c.getRank().getName());
	      assertEquals(new Integer(0),c.getRank().getPips());
	      assertEquals("Spade",c.getSuit().getName());
	      assertEquals(new Character('\u2660'),c.getSuit().getSymbol());
}
	
	/**
	 * Checks if Jack of spade card is created correctly.
	 */
	@Test
	   public void TwoOfSpade_Card_Equal() {
		
		Card c = new CardAdapter((new RankImpl("Two",2)),(new SuitImpl("Spade",(char)'\u2660')));	
		
	      //To Check that two objects are equal
	      assertEquals("Two",c.getRank().getName());
	      assertEquals(new Integer(2),c.getRank().getPips());
	      assertEquals("Spade",c.getSuit().getName());
	      assertEquals(new Character('\u2660'),c.getSuit().getSymbol());
}

	
	/**
	 * Checks if Three of Heart card is created correctly.
	 */
	@Test
	   public void ThreeOfHeart_Card_Equal() {
		
		Card c = new CardAdapter((new RankImpl("Three",3)),
				(new SuitImpl(SuitEnum.HEART.suit(),SuitEnum.HEARTSYMBOL.suitSymbol())));	
		
	      //To Check that two objects are equal
	      assertEquals("Three",c.getRank().getName());
	      assertEquals(new Integer(3),c.getRank().getPips());
	      assertEquals(SuitEnum.HEART.suit(),c.getSuit().getName());
	      assertEquals(new Character(SuitEnum.HEARTSYMBOL.suitSymbol()),c.getSuit().getSymbol());
}
	
	
	/**
	 * Checks if Nine of Heart card is created correctly.
	 */
	@Test
	   public void nineOfHeart_Card_Equal() {
		
		Card c = new CardAdapter((new RankImpl("Nine",9)),
				(new SuitImpl(SuitEnum.HEART.suit(),SuitEnum.HEARTSYMBOL.suitSymbol())));	
		
	      //To Check that two objects are equal
	      assertEquals("Nine",c.getRank().getName());
	      assertEquals(new Integer(9),c.getRank().getPips());
	      assertEquals(SuitEnum.HEART.suit(),c.getSuit().getName());
	      assertEquals(new Character(SuitEnum.HEARTSYMBOL.suitSymbol()),c.getSuit().getSymbol());
}
	
	
	
	/**
	 * Checks if Seven of Clubs card is created correctly.
	 */
	@Test
	   public void SevenOfClubs_Card_Equal() {
		
		Card c = new CardAdapter((new RankImpl("Seven",7)),
				(new SuitImpl(SuitEnum.CLUB.suit(),SuitEnum.CLUBSYMBOL.suitSymbol())));	
		
	      //To Check that two objects are equal
	      assertEquals("Seven",c.getRank().getName());
	      assertEquals(new Integer(7),c.getRank().getPips());
	      assertEquals(SuitEnum.CLUB.suit(),c.getSuit().getName());
	      assertEquals(new Character(SuitEnum.CLUBSYMBOL.suitSymbol()),c.getSuit().getSymbol());
}
	
	/**
	 * Checks if five of Clubs card is created correctly.
	 */
	@Test
	   public void fiveOfClubs_Card_Equal() {
		
		Card c = new CardAdapter((new RankImpl("Five",5)),
				(new SuitImpl(SuitEnum.CLUB.suit(),SuitEnum.CLUBSYMBOL.suitSymbol())));	
		
	      //To Check that two objects are equal
	      assertEquals("Five",c.getRank().getName());
	      assertEquals(new Integer(5),c.getRank().getPips());
	      assertEquals(SuitEnum.CLUB.suit(),c.getSuit().getName());
	      assertEquals(new Character(SuitEnum.CLUBSYMBOL.suitSymbol()),c.getSuit().getSymbol());
}
	
	/**
	 * Checks if Eight of diamond card is created correctly.
	 */
	@Test
	   public void EightOfDiamond_Card_Equal() {
		
		Card c = new CardAdapter((new RankImpl("Eight",8)),
				(new SuitImpl(SuitEnum.DIAMOND.suit(),SuitEnum.DIAMONDSYMBOL.suitSymbol())));	
		
	      //To Check that two objects are equal
	      assertEquals("Eight",c.getRank().getName());
	      assertEquals(new Integer(8),c.getRank().getPips());
	      assertEquals(SuitEnum.DIAMOND.suit(),c.getSuit().getName());
	      assertEquals(new Character(SuitEnum.DIAMONDSYMBOL.suitSymbol()),c.getSuit().getSymbol());
}
	
	/**
	 * Checks if Ace of diamond card is created correctly.
	 */
	@Test
	   public void AceOfDiamond_Card_Equal() {
		
		Card c = new CardAdapter((new RankImpl("Ace",1)),
				(new SuitImpl(SuitEnum.DIAMOND.suit(),SuitEnum.DIAMONDSYMBOL.suitSymbol())));	
		
	      //To Check that two objects are equal
	      assertEquals("Ace",c.getRank().getName());
	      assertEquals(new Integer(1),c.getRank().getPips());
	      assertEquals(SuitEnum.DIAMOND.suit(),c.getSuit().getName());
	      assertEquals(new Character(SuitEnum.DIAMONDSYMBOL.suitSymbol()),c.getSuit().getSymbol());
	}
	
	/**
	 * Checks if Ten of diamond card is created correctly.
	 */
	@Test
	   public void TenOfDiamond_Card_Equal() {
		
		Card c = new CardAdapter((new RankImpl("Ten",10)),
				(new SuitImpl(SuitEnum.DIAMOND.suit(),SuitEnum.DIAMONDSYMBOL.suitSymbol())));	
		
	      //To Check that two objects are equal
	      assertEquals("Ten",c.getRank().getName());
	      assertEquals(new Integer(10),c.getRank().getPips());
	      assertEquals(SuitEnum.DIAMOND.suit(),c.getSuit().getName());
	      assertEquals(new Character(SuitEnum.DIAMONDSYMBOL.suitSymbol()),c.getSuit().getSymbol());
}
}

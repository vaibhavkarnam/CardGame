package edu.northeastern.ccs.cs5500.homework3;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;


public class Iterator_TestClass {
	
NewHand playerHand;
	
	/** The standard deck. */
	Deck standardDeck;
	
	/**
	 * Setup executed before the tests
	 */
	@Before
	public void setup()
	{
		playerHand = new NewHandImpl();
		standardDeck = new StandardDeckImpl();	
		for(int i=0;i<13;i++)
		{
		playerHand.accept(standardDeck.pullCard());
		}

	}
	
	/**
	 * Checks if the first function in iterator on NewHand correctly finds the
	 * first element in hand when many cards are present in hand
	 */
	@Test
	   public void handIterator_First_ManyCards_Pos() {
		
		Iterator handIter = new IteratorImpl(playerHand.showCards());
		assertEquals("Ten Heart",handIter.first().toString());
		}
	
	
	/**
	 * Checks if the first function in iterator on NewHand correctly finds the
	 * first element in hand when one card is present in hand
	 */
	
	@Test
	   public void handIterator_First_OneCard_Pos() {
		   
		playerHand = new NewHandImpl();

		playerHand.accept(standardDeck.pullCard());
			
		Iterator handIter = new IteratorImpl(playerHand.showCards());
		assertEquals("Seven Club",handIter.first().toString());
		}
	
	/**
	 * Checks if the first function in iterator on NewHand throws exception
	 * when no card is present in hand
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	   public void handIterator_First_NoCard_Pos() {
		   
		playerHand = new NewHandImpl();
			
		Iterator handIter = new IteratorImpl(playerHand.showCards());
		handIter.first();
		}
	
	/**
	 * Checks if the next function in iterator on NewHand correctly finds the
	 * next element in hand when many cards are present in hand
	 */
	@Test
	   public void handIterator_Next_ManyCards_Pos() {
		
		Iterator handIter = new IteratorImpl(playerHand.showCards());
		assertEquals("Ten Club",handIter.next().toString());
		}
	
	
	/**
	 * Checks if the next function in iterator on NewHand correctly finds the
	 * next element in hand when two card is present in hand
	 */
	
	@Test
	   public void handIterator_Next_TwoCard_Pos() {
		   
		playerHand = new NewHandImpl();

		playerHand.accept(standardDeck.pullCard());
		playerHand.accept(standardDeck.pullCard());

			
		Iterator handIter = new IteratorImpl(playerHand.showCards());
		assertEquals("Seven Diamond",handIter.next().toString());
		}
	
	
	
	/**
	 * Checks if the next function in iterator on NewHand throws exception
	 * when one card is present in hand
	 */
	
	@Test(expected = IndexOutOfBoundsException.class)
	   public void handIterator_Next_OneCard_Pos() {
		   
		playerHand = new NewHandImpl();

		playerHand.accept(standardDeck.pullCard());
			
		Iterator handIter = new IteratorImpl(playerHand.showCards());
		handIter.next();
		}
	
	/**
	 * Checks if the next function in iterator on NewHand throws exception
	 * when no card is present in hand
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	   public void handIterator_Next_NoCard_Pos() {
		   
		playerHand = new NewHandImpl();
			
		Iterator handIter = new IteratorImpl(playerHand.showCards());
		handIter.next();
		}
	
	/**
	 * Checks if the isDone function in iterator on NewHand correctly returns
	 * false when many cards are present in hand
	 */
	@Test
	   public void handIterator_isDone_ManyCards_Pos() {
		
		Iterator handIter = new IteratorImpl(playerHand.showCards());
		assertEquals(false,handIter.isDone());
		}
	
	
	/**
	 * Checks if the isDone function in iterator on NewHand correctly returns
	 * false when one card is present in hand
	 */
	
	@Test
	   public void handIterator_isDone_OneCard_Pos() {
		   
		playerHand = new NewHandImpl();

		playerHand.accept(standardDeck.pullCard());
			
		Iterator handIter = new IteratorImpl(playerHand.showCards());
		assertEquals(false,handIter.isDone());
		}
	
	/**
	 * Checks if the isDone function in iterator on NewHand correctly returns
	 * true when no card is present in hand
	 */
	@Test
	   public void handIterator_isDone_NoCard_Pos() {
		   
		playerHand = new NewHandImpl();
			
		Iterator handIter = new IteratorImpl(playerHand.showCards());
		assertEquals(true,handIter.isDone());
		}
	
	/**
	 * Checks if the current function in iterator on NewHand correctly finds the
	 * current element in hand when many cards are present in hand
	 */
	@Test
	   public void handIterator_Current_ManyCards_Pos() {
		
		Iterator handIter = new IteratorImpl(playerHand.showCards());
		assertEquals("Ten Heart",handIter.current().toString());
		}
	
	/**
	 * Checks if the current function in iterator on NewHand throws execption when all cards are
	 * removed in  hand
	 */
	@Test(expected = NoSuchElementException.class)
	   public void handIterator_Current_ManyCardsNext_Pos() {
		
		playerHand = new NewHandImpl();
		standardDeck = new StandardDeckImpl();	
		for(int i=0;i<13;i++)
		{
		playerHand.accept(standardDeck.pullCard());
		}
		
		Iterator handIter = new IteratorImpl(playerHand.showCards());
		while(!handIter.isDone())
		{
			playerHand.pullCard();
		}
		handIter.current();
		}
	
	
	/**
	 * Checks if the current function in iterator on NewHand correctly finds the
	 * current element in hand when many cards are present in hand and all but one is removed
	 */
	@Test
	   public void handIterator_Current_ManyNext_Pos() {
		
		playerHand = new NewHandImpl();
		standardDeck = new StandardDeckImpl();	
		for(int i=0;i<13;i++)
		{
		playerHand.accept(standardDeck.pullCard());
		}
		Iterator handIter = new IteratorImpl(playerHand.showCards());
		for(int i=0;i<12;i++)
		{
			playerHand.pullCard();
		}
		assertEquals("Ten Heart",handIter.current().toString());
		}
	
	/**
	 * Checks if the current function in iterator on NewHand correctly finds the
	 *  element in hand when one card is present in hand
	 */
	
	@Test
	   public void handIterator_Current_OneCard_Pos() {
		   
		playerHand = new NewHandImpl();

		playerHand.accept(standardDeck.pullCard());
			
		Iterator handIter = new IteratorImpl(playerHand.showCards());
		assertEquals("Seven Club",handIter.current().toString());
		}
	
	/**
	 * Checks if the current function in iterator on NewHand throws exception
	 * when no card is present in hand
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	   public void handIterator_Current_NoCard_Pos() {
		   
		playerHand = new NewHandImpl();
			
		Iterator handIter = new IteratorImpl(playerHand.showCards());
		handIter.current();
		}
	
	/**
	 * Checks if the hasNext function in iterator on NewHand correctly returns
	 * true when many cards are present in hand
	 */
	@Test
	   public void handIterator_hasNext_ManyCards_Pos() {
		
		Iterator handIter = new IteratorImpl(playerHand.showCards());
		assertEquals(true,handIter.hasNext());
		}
	
	
	/**
	 * Checks if the hasDone function in iterator on NewHand correctly returns
	 * true when one card is present in hand
	 */
	
	@Test
	   public void handIterator_hasNext_OneCard_Pos() {
		   
		playerHand = new NewHandImpl();

		playerHand.accept(standardDeck.pullCard());
			
		Iterator handIter = new IteratorImpl(playerHand.showCards());
		assertEquals(true,handIter.hasNext());
		}
	
	/**
	 * Checks if the hasNext function in iterator on NewHand correctly returns
	 * false when no card is present in hand
	 */
	@Test
	   public void handIterator_hasNext_NoCard_Pos() {
		   
		playerHand = new NewHandImpl();
			
		Iterator handIter = new IteratorImpl(playerHand.showCards());
		assertEquals(false,handIter.hasNext());
		}

}

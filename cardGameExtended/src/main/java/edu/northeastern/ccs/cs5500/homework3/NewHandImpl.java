package edu.northeastern.ccs.cs5500.homework3;
/**
 * The Class NewHandImpl implements the NewHand interface and Extends HandImpl
 * a hand represents a player in the game
 * @author vaibhav
 */

public class NewHandImpl extends HandImpl implements NewHand{
	/**
	 * Checks if the hand contains the specified card
	 *
	 * @param Card the card to be checked
	 * @return true if the hand contains the card else false
	 */	
	public boolean hasCard(Card cardToFind)
	{
		return findOccurancesOfCard(cardToFind) > 0;
	}
	/**
	 * Checks the number of times the specified card occurs in the hand
	 *
	 * @param Card the card to be found
	 * @return the number of occurrences of the card
	 */
	public int occurrencesInHand(Card cardToFind)
	{
		
		return findOccurancesOfCard(cardToFind);
		
	}
	/**
	 * Checks the number of times the card with specified rank occurs in the hand
	 *
	 * @param Rank for the card to be found
	 * @return the number of occurrences of the card
	 */
	public int occurrencesInHand(Rank rankToFind)
	{
		return findOccurancesOfRank(rankToFind);
	}
	
	/**
	 * Checks the number of times the specified card occurs in the hand
	 *
	 * @param Card the card to be found
	 * @return the number of occurrences of the card
	 */
	
	private int findOccurancesOfCard(Card cardToFind)
	{
		int counter = 0;
		if(cardToFind == null)
			{
				for (Card c : hand)
				{
					if(c == null)
					{
					counter++;
					}
				}

			}
		else
		{
		
			for (Card c : hand)
			{
				if(cardToFind.equals(c))
				{
				counter++;
				}
			}

		}
		return counter;

	}
	
	/**
	 * Checks the number of times the card with specified rank occurs in the hand
	 *
	 * @param Rank for the card to be found
	 * @return the number of occurrences of the card
	 */
	private int findOccurancesOfRank(Rank rankToFind)
	{
		int counter = 0;
		
			for (Card c : hand)
			{
				if(rankToFind.equals(c.getRank()))
				{
				counter++;
				}
			}

		return counter;

	}


}

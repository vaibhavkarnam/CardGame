package problem2;
/**
 * A factory for creating Deck objects.
 */
public class DeckFactory {
	
	/**
	 * Creates a new Deck object of the specified type
	 *
	 * @param deckType the deck type of deck to be created
	 * @return the deck of the required type
	 */
	public Deck createDeckFactory(String deckType)
	{	
		if(deckType.equals("Standard"))
		{
			return new StandardDeckImpl();	
		}
		
		else if(deckType.equals("Euchre"))
		{
			return new EuchreDeckImpl();
		}
		
		
		else if(deckType.equals("Pinochle"))
		{			
			return new PinochleDeckImpl();
		}
		
		else if(deckType.equals("Vegas"))
		{
			return new VegasDeckImpl();
		}

		return null;
	}
	
	
	/**
	 * Creates a new Deck object of the specified type and contains the specified number
	 * of decks
	 *
	 * @param deckType the deck type of deck to be created
	 * @param noOfDecks the no of decks to be created
	 * @return the deck of the required type with the specified number of decks
	 */
	public Deck createDeckFactory(String deckType, int noOfDecks)
	{	
		if(deckType.equals("Standard"))
		{
			return new StandardDeckImpl(noOfDecks);	
		}
		
		else if(deckType.equals("Euchre"))
		{
			return new EuchreDeckImpl(noOfDecks);
		}
		
		
		else if(deckType.equals("Pinochle"))
		{			
			return new PinochleDeckImpl(noOfDecks);
		}
		
		else if(deckType.equals("Vegas"))
		{
			return new VegasDeckImpl(noOfDecks);
		}

		return null;
	}
		
}

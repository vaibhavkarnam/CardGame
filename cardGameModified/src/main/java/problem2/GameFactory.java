package problem2;

import java.util.ArrayList;
import java.util.List;

import problem2.Hand;

/**
 * A factory for creating Game objects.
 */
public class GameFactory {
	
	/** The deck. */
	Deck deck;
	
	/** The deck factory. */
	DeckFactory deckFactory = new DeckFactory();
	
	/** The hand list. */
	List<Hand> handList = new ArrayList<>();

		
	/**
	 * Creates a new Game object with the specified deck type, sets the specified number of hands,
	 * Creates the hands and deals the cards.
	 * 
	 *
	 * @param deckType the deck type to be created
	 * @param noOfHands the no of hands to br set
	 * @return the game
	 */
	public Game createGameFactory(String deckType,int noOfHands)
	{	
		Game game = new GameImpl();
 
		deck = deckFactory.createDeckFactory(deckType);
		game.setNumberOfHands(noOfHands);
		game.createHands();
		game.deal();
		return game;
		
	}
	
	
	/**
	 * Creates a new Game object with the specified deck type and number of decks,
	 * sets the specified number of hands,
	 * Creates the hands and deals the cards.
	 * @param deckType the deck type to be created
	 * @param numberOfDecks the number of decks
	 * @param noOfHands the no of hands
	 * @return the game
	 */
	public Game createGameFactory(String deckType,int numberOfDecks,int noOfHands)
	{	
		Game game = new GameImpl();

		deck = deckFactory.createDeckFactory(deckType,numberOfDecks);
		game.setNumberOfHands(noOfHands);
		game.createHands();
		game.deal();
		return game;
		
	}


	/**
	 * Creates a new Game object with the specified deck type and number of decks,
	 * sets the specified number of hands,
	 * Creates the hands and deals the specified number of cards
	 * @param deckType the deck type
	 * @param numberOfDecks the number of decks
	 * @param noOfHands the no of hands
	 * @param noOfCards the no of cards to be dealt among hands
	 * @return the game
	 */
	public Game createGameFactory(String deckType,int numberOfDecks,int noOfHands,int noOfCards)
	{	
		Game game = new GameImpl();

		deck = deckFactory.createDeckFactory(deckType,numberOfDecks);
		game.setNumberOfHands(noOfHands);
		game.createHands();
		game.deal(noOfCards);
		return game;
		
	}
	
	/**
	 * Creates a new Game object with the specified deck type,
	 * sets the specified number of hands,
	 * Creates the hands and deals the specified number of cards
	 * @param deckType the deck type
	 * @param noOfHands the no of hands
	 * @param noOfCards the no of cards to be dealt among hands
	 * @return the game
	 */
	public Game createDefaultGameFactory(String deckType,int noOfHands,int noOfCards)
	{	
		Game game = new GameImpl();

		deck = deckFactory.createDeckFactory(deckType);
		game.setNumberOfHands(noOfHands);
		game.createHands();
		game.deal(noOfCards);
		return game;
		
	}
	
}

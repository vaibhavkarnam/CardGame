package edu.northeastern.ccs.cs5500.homework4;

import java.util.Objects;

/**
 * The Class SuitImpl implements the Suit interface.
 * the suits are clubs, diamonds, hearts, and spades
 * 
 * @author vaibhav
 */
public class SuitImpl implements Suit{
	
	/**
	 * Instantiates a new suit object.
	 *
	 * @param name the name of the suit
	 * @param symbol the symbol of the suit
	 */
	public SuitImpl(String name, Character symbol) {
		super();
		this.name = name;
		this.symbol = symbol;
	}
	
	/** The name of the suit */
	private String name;
	
	/** The symbol of the suit */
	private Character symbol;
	
	/**
	 * Returns the name of the suit.
	 *
	 * @return the name of the suit
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the name of the suit as String
	 */
	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * Instantiates a new suit object.
	 */
	public SuitImpl() {
		super();
	}
	
	/**
	 * Returns the symbol of the suit.
	 *
	 * @return the symbol representing the suit.
	 */
	public Character getSymbol() {
		return symbol;
	}
	
	/**
	 * Sets the symbol.
	 *
	 * @param symbol the new symbol symbol to be set
	 */
	public void setSymbol(Character symbol) {
		this.symbol = symbol;
	}
	
	/* 
	 * Compares if the given object is equal to the current object of the class
	 * 
	 * @param s the suit object to be compared to the current object
	 * @return true if the two objects are equal else false. 
	 */
	@Override
    public boolean equals(Object s){
        if (s == this) return true;
        
        if (!(s instanceof SuitImpl))
        {
            return false;
        }
        SuitImpl suit = (SuitImpl) s;
        return symbol.equals(suit.symbol) && name.equals(suit.name) ;
    }

	/* 
     * Returns the hash representation or hashCode of the suit object
     * 
     *@return the hashCode of the suit object
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, symbol);
    }
	
	

}

package edu.northeastern.ccs.cs5500.homework4;

import java.util.Objects;

/**
 * The Class RankImpl implements the Rank interface.
 * 
 * @author vaibhav
 */
public class RankImpl implements Rank{
	
	/** The name. of the rank*/
	private String name;
	
	/** The pips. of the rank*/
	private Integer pips;
	
	/**
	 * Returns the name of the rank.
	 *
	 * @return the name
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
	 * Returns the pips of the rank.
	 *
	 * @return the pips
	 */
	public Integer getPips() {
		return pips;
	}
	
	/**
	 * Sets the pips.
	 *
	 * @param pips the new pips
	 */
	public void setPips(Integer pips) {
		this.pips = pips;
	}

	/*
	 * Returns the name of the rank as a String
	 * 
	 */
	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * Instantiates a new rank impl.
	 *
	 * @param name the name of the rank
	 * @param pips the pips  of the rank
	 */
	public RankImpl(String name, Integer pips) {
		super();
		this.name = name;
		this.pips = pips;
	}
	
	/**
	 * Instantiates a new rank.
	 */
	public RankImpl() {
		super();
	}
	
	/* 
	 * Compares if the given object is equal to the current object of the class
	 * 
	 * @param r the rank object to be compared to the current object
	 * @return true if the two objects are equal else false. 
	 */
	@Override
    public boolean equals(Object r){
        if (r == this) return true;
        
        if (!(r instanceof RankImpl))
        {
            return false;
        }
        RankImpl rank = (RankImpl) r;
        return name.equals(rank.name) && pips == rank.pips ;
    }

	/* 
     * Returns the hash representation or hashCode of the rank object
     * 
     *@return the hashCode of the rank object
     */
    @Override
    public int hashCode() {
        return Objects.hash(name , pips);
    }

}

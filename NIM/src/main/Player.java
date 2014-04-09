/**
 * 
 */
package main;

/**
 * @author agardea
 *
 */
public abstract class Player {
	
	public boolean isTurn;
	abstract void takeTurn(BoardState currentState);
	
}

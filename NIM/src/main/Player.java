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
	
	public Player(String name){
		
	}
	
	abstract void takeTurn(BoardState currentState);
	
}

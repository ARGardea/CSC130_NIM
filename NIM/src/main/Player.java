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
	public String Name;
	
	public Player(String name){
		this.Name = name;
	}

	abstract void takeTurn(BoardState currentState);
	
}

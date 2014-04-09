/**
 * 
 */
package main;

import java.util.List;

/**
 * @author agardea
 *
 */
public class GameBoard {
	private List<BoardState> boardStates;
	private BoardState currentState;
	
	public GameBoard(){
		currentState = new BoardState();
		currentState.rows = new int[] {3, 5, 7};
	}

	/**
	 * @return the boardStates
	 */
	public List<BoardState> getBoardStates() {
		return boardStates;
	}
	
	public BoardState getCurrentState() {
		return currentState;
	}
	
	@Override
	public String toString()
	{
		return currentState.toString();
		
	}
}

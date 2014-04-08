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
	
	@Override
	public String toString(){
		String result = new String();
		result += "[";
		for(int i: currentState.rows){
			for(int j = 0; j < i; j++){
				result += " x";
			}
			result += " ]\n";
		}
		return null;
	}
}

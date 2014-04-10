/**
 * 
 */
package main;

/**
 * @author agardea
 *
 */
public class BoardState {
	public int[] rows = new int[3];
	
	public int checkRow(int targetRow){
		int result = -1;
		try{
			result = rows[targetRow - 1];
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
		return result;
	}
	
	public int[] compareStates(BoardState stateOne, BoardState stateTwo){
		int[] resultRows = new int[stateOne.rows.length];
		for(int i = 0; i < resultRows.length; i++){
			resultRows[i] = stateOne.rows[i] - stateTwo.rows[i];
		}
		return resultRows;
	}
	
	public TurnAction howToReachState(BoardState stateToReach){
		TurnAction action = null;
		
		int[] stateDifference = compareStates(this, stateToReach);
		
		int selectedRow = -1;
		boolean movePossible = true;
		
		for(int i = 0; i < stateDifference.length; i++){
			if(stateDifference[i] > 0 && selectedRow == -1){
				selectedRow = i;
			}else if(stateDifference[i] > 0 || stateDifference[i] < 0 || (selectedRow == -1 && i == stateDifference.length - 1)){
				movePossible = false;
			}
		}
		
		if(movePossible){
			System.out.println("Move is possible");
			action = new TurnAction();
			action.setTargetRow(selectedRow + 1);
			action.setTokenAmount(stateDifference[selectedRow]);
		}
		
		return action;
	}
	
	public boolean tryTurn(TurnAction actionToTry){
		boolean successful = false;
		
		if(rows[actionToTry.getTargetRow() - 1] <= actionToTry.getTokenAmount()){
			rows[actionToTry.getTargetRow() - 1] -= actionToTry.getTokenAmount();
			successful = true;
		}
		
		return successful;
	}
	
	@Override
	public String toString(){
		String result = new String();
		for(int i = 0; i < rows.length; i++){
			result += (i + 1) + ") [";
			for(int j = 0; j < rows[i]; j++){
				result += " x";
			}
			result += " ]\n";
		}
		return result;
	}
}

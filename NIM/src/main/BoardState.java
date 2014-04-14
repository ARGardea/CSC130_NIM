/**
 * 
 */
package main;

/**
 * @author agardea
 *
 */
public class BoardState {
	//TODO: revise code so that semantic arrays are NOT used
	//     Changes will need to be made in classes that refer to these arrays as well.
	public int[] rows = new int[3];
	public static final int invalidRowCode = -1;
	public static final int noneSelected = -2;
	
	public int checkRow(int targetRow){
		int result = 0;
		try{
			result = rows[targetRow - 1];
		}catch(ArrayIndexOutOfBoundsException e){
			result = invalidRowCode;
		}
		return result;
	}
	
	public int[] compareStates(BoardState stateOne, BoardState stateTwo){
		int[] rowDifferences = new int[stateOne.rows.length];
		for(int i = 0; i < rowDifferences.length; i++){
			rowDifferences[i] = stateOne.rows[i] - stateTwo.rows[i];
		}
		return rowDifferences;
	}
	
	public TurnAction tryToReachState(BoardState stateToReach){
		TurnAction suggestedAction = null;
		
		int[] stateComparisonResults = compareStates(this, stateToReach);
		int selectedRow = noneSelected;
		boolean movePossible = true;
		
		for(int i = 0; i < stateComparisonResults.length; i++){
			boolean noStateDifference = (selectedRow == noneSelected && i == stateComparisonResults.length - 1);
			boolean isFirstStateDifference = (stateComparisonResults[i] > 0 && selectedRow == noneSelected);
			if(isFirstStateDifference){
				selectedRow = i;
			}else if(representsStateDifference(stateComparisonResults[i]) || noStateDifference){
				movePossible = false;
			}
		}
		
		if(movePossible){
			suggestedAction = new TurnAction();
			suggestedAction.setTargetRow(selectedRow + 1);
			suggestedAction.setTokenAmount(stateComparisonResults[selectedRow]);
		}
		 
		return suggestedAction;
	}
	
	public boolean representsStateDifference(int testedValue){
		boolean representsDifference = (testedValue != 0);
		return representsDifference;
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

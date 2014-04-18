/**
 * 
 */
package main;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author agardea
 *
 */
public class BoardState {
	//TODO: revise code so that semantic arrays are NOT used
	//     Changes will need to be made in classes that refer to these arrays as well.
	public int[] rows = new int[3];
	public static final int invalidRowCode = -1;
	public static final int noRowSelected = -2;
	
	public int checkRow(int targetRow){
		int result = 0;
		try{
			result = rows[targetRow - 1];
		}catch(ArrayIndexOutOfBoundsException e){
			result = invalidRowCode;
		}
		return result;
	}
	
	public Iterator<Integer> compareStates(BoardState stateOne, BoardState stateTwo){
		ArrayList<Integer> rowDifferences = new ArrayList<Integer>();
		for(int i = 0; i < rowDifferences.size(); i++){
			rowDifferences.add(stateOne.rows[i] - stateTwo.rows[i]);
		}
		return rowDifferences.iterator();
	}
	
	public TurnAction tryToReachBoardState(BoardState stateToReach){
		TurnAction suggestedAction = null;
		
		Iterator stateComparisonResults = compareStates(this, stateToReach);
		int selectedRow = noRowSelected;
		int selectedRowTokens = 0;
		boolean movePossible = true;
		
		int checkedRowTokens = 0;
		int rowNumber = 1;
		
		boolean comparisonInProgress = stateComparisonResults.hasNext();
		
		while(comparisonInProgress){
			checkedRowTokens = (Integer)stateComparisonResults.next();
			comparisonInProgress = stateComparisonResults.hasNext();
			
			if(representsTokensRemoved(checkedRowTokens)){
				if(selectedRow == noRowSelected){
					selectedRow = rowNumber;
					selectedRowTokens = checkedRowTokens;
				}else{
					comparisonInProgress = false;
					movePossible = false;
				}
			}else if(representsTokensAdded(checkedRowTokens)){
				comparisonInProgress = false;
				movePossible = false;
			}
			rowNumber++;
		}
		
		if(movePossible){
			suggestedAction = new TurnAction();
			suggestedAction.setTargetRow(selectedRow);
			suggestedAction.setTokenAmount(selectedRowTokens);
		}
		 
		return suggestedAction;
	}
	
	public boolean representsTokensAdded(int testedValue){
		return (testedValue < 0);
	}
	
	public boolean representsTokensRemoved(int testedValue){
		return (testedValue > 0);
	}
	
	public boolean representsStateDifference(int testedValue){
		boolean representsDifference = (testedValue != 0);
		return representsDifference;
	}
	
	public int getBoardStateRowSum(){
		int rowSum = 0;
		
		for(int tokenNumber: rows){
			rowSum += tokenNumber;
		}
		
		return rowSum;
	}
	
	public int getBoardStateCode(){
		String concatenatedRowValues = "";
		int boardStateCode = 0;
		
		for(int rowTokens: rows){
			concatenatedRowValues += rowTokens;
		}
		
		boardStateCode = Integer.parseInt(concatenatedRowValues);
		
		return boardStateCode;
	}
	
	public boolean tryTurn(TurnAction actionToTry){
		boolean successful = false;
		
		int tokenAmount = actionToTry.getTokenAmount();
		int targetedRowCount = actionToTry.getTargetRow() - 1;
		
		if(rows[targetedRowCount] >= tokenAmount){
			rows[targetedRowCount] -= tokenAmount;
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

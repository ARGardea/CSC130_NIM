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
public class BoardState implements Iterable{
	//TODO: revise code so that semantic arrays are NOT used
	//     Changes will need to be made in classes that refer to these arrays as well.
	public int[] rows = new int[3];
	public static final int invalidRowCode = -1;
	public static final int noRowSelected = -2;
	
	public BoardState(int[] rows){
		this.rows = rows;
	}
	
	public BoardState(){
		
	}
	
	public int checkRow(int targetRow){
		int result = 0;
		try{
			result = rows[targetRow - 1];
		}catch(ArrayIndexOutOfBoundsException e){
			result = invalidRowCode;
		}
		return result;
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



	@Override
	public Iterator<TurnAction> iterator() {
		// TODO Auto-generated method stub
		PossibleStateIterator iterator = new PossibleStateIterator();
		iterator.setIteratedState(new BoardState(this.rows.clone()));
		return iterator;
	}
}

class PossibleStateIterator implements Iterator{

	int currentRow = 0;
	int rowTokens = 0;
	int maxRowNumber = 0;
	BoardState iteratedState;
	
	void setIteratedState(BoardState state){
		this.iteratedState = state;
		this.maxRowNumber = state.rows.length;
		this.rowTokens = state.rows[currentRow];
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		boolean currentRowHasTokens = this.rowTokens > 0;
		boolean hasNext = false;
		
		assert(!(currentRow > maxRowNumber));
		
		if(currentRowHasTokens){
			hasNext = true;
		}else{
			if(currentRow < maxRowNumber){
				int checkedRow = 0;
				int checkedTokens;
				boolean checkInProgress = true;
				while(checkInProgress){
					checkedRow = currentRow + 1;
					checkedTokens = iteratedState.checkRow(checkedRow + 1);
					boolean checkedBoolean = (checkedTokens > 0);
					if(!checkedBoolean){
						checkedBoolean = checkedRow == maxRowNumber;
					}
					checkInProgress = checkedBoolean;
				}
			}
		}
		
		return hasNext;
	}

	@Override
	public TurnAction next() {
		// TODO Auto-generated method stub
		TurnAction nextPossibleAction = null;
		int checkedRow = currentRow;
		int checkedTokens = iteratedState.rows[checkedRow] - 1;
		boolean searchingForNext = !(checkedTokens >= 0);
		while(searchingForNext){
			checkedTokens = iteratedState.rows[checkedRow] - 1;
			boolean tokensValid = (checkedTokens >= 0);
			if(tokensValid){
				searchingForNext = false;
				nextPossibleAction = new TurnAction();
				BoardState nextPossibleState = new BoardState(iteratedState.rows.clone());
				nextPossibleState.rows[checkedRow] = checkedTokens;
				nextPossibleAction.setTargetRow(checkedRow);
				nextPossibleAction.setTokenAmount(nextPossibleState.rows[checkedRow]-checkedTokens);
			}else if(checkedRow != maxRowNumber){
				checkedRow++;
			}
		}
		return nextPossibleAction;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}

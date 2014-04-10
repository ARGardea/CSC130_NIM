/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author agardea
 *
 */
public class Computer extends Player {

	public Computer(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see main.Player#takeTurn()
	 */
	@Override
	public void takeTurn(GameBoard currentBoard) {
		Random rand = new Random();
		
		int randRow = 0;
		int rowTokens = 0;
		ArrayList<Integer> validRowList = new ArrayList<Integer>();
		int[] validRows = { 1, 2, 3 };
		for(int i: validRows){
			validRowList.add(i);
		}
		boolean selectionValid = false;
		while(!selectionValid){
			randRow = validRowList.get(rand.nextInt(validRowList.size()));
			rowTokens = currentBoard.getCurrentState().checkRow(randRow);
			if(rowTokens > 0){
				selectionValid = true;
			}else{
				validRowList.remove((Object)randRow);
			}
		}
		int randTokenAmount = rand.nextInt(rowTokens) + 1;
		
		if(rowTokens > 0) {
			boolean inputValidToken = false; 
			
			while(!inputValidToken) {
				TurnAction action = new TurnAction();
				action.setTargetRow(randRow);
				action.setTokenAmount(randTokenAmount);
				boolean successful = currentBoard.getCurrentState().tryTurn(action);
					inputValidToken = successful;
					
				System.out.println("Computer chose row " + (randRow) + ".\n" 
						+ "Computer has removed " + randTokenAmount + " from that row.");
				System.out.println(currentBoard.toString());
			}
		}
	}
	
	public void evaluateChoice(){
		
	}

}

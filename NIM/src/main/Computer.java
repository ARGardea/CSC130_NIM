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
		
		int randomlySelectedRow = 0;
		int tokensInRow = 0;
		ArrayList<Integer> validRowNumbers = new ArrayList<Integer>();
		int[] validRowNumberValues = { 1, 2, 3 };
		for(int i: validRowNumberValues){
			validRowNumbers.add(i);
		}
		boolean selectionValid = false;
		while(!selectionValid){
			randomlySelectedRow = validRowNumbers.get(rand.nextInt(validRowNumbers.size()));
			tokensInRow = currentBoard.getCurrentState().checkRow(randomlySelectedRow);
			selectionValid = (tokensInRow > 0)?true:validRowNumbers.remove((Object)randomlySelectedRow);
		}
		int randTokenAmount = rand.nextInt(tokensInRow) + 1;
		
		if(tokensInRow > 0) {
			boolean inputValidToken = false; 
			
			while(!inputValidToken) {
				TurnAction action = new TurnAction();
				action.setTargetRow(randomlySelectedRow);
				action.setTokenAmount(randTokenAmount);
				boolean successful = currentBoard.getCurrentState().tryTurn(action);
					inputValidToken = successful;
					
				System.out.println("Computer chose row " + (randomlySelectedRow) + ".\n" 
						+ "Computer has removed " + randTokenAmount + " from that row.");
				System.out.println(currentBoard.toString());
			}
		}
	}
	
	public void evaluateChoice(){
		
	}

}

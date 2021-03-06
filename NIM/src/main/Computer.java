/**
 * 
 */
package main;

import java.util.ArrayList;
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
		boolean selectionNotValid = true;
		while(selectionNotValid){
			randomlySelectedRow = validRowNumbers.get(rand.nextInt(validRowNumbers.size()));
			tokensInRow = currentBoard.getCurrentState().checkRow(randomlySelectedRow);
			selectionNotValid = (tokensInRow > 0)?false:validRowNumbers.remove((Object)randomlySelectedRow);
		}
		int randTokenAmount = rand.nextInt(tokensInRow) + 1;
		
		TurnAction action = new TurnAction();
		action.setTargetRow(randomlySelectedRow);
		action.setTokenAmount(randTokenAmount);
		
		System.out.println("Computer chose row " + (randomlySelectedRow) + ".\n" 
				+ "Computer has removed " + randTokenAmount + " from that row.");
		System.out.println(currentBoard.toString());
		currentBoard.MakeMove(action);
	}
	
	public void evaluateChoice(){
		
	}

}

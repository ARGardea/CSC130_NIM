/**
 * 
 */
package main;

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
		
		int randRow = rand.nextInt(3);
		
		int rowTokens = currentBoard.getCurrentState().checkRow(randRow);
		int randTokenAmount = rand.nextInt(rowTokens);
		
		if(rowTokens > 0) {
			boolean inputValidToken = false; 
			
			while(!inputValidToken) {
				
				if(currentBoard.getCurrentState().rows[randRow] >= randTokenAmount) {
					currentBoard.getCurrentState().rows[randRow] -= randTokenAmount;
					
					inputValidToken = true; 
				}
				System.out.println("Computer chose row " + randRow + ".\n " 
						+ "Computer has removed " + randTokenAmount + " from that row.");
				System.out.println(currentBoard.toString());
			}
		}
	}
	
	public void evaluateChoice(){
		
	}

}

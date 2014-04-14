package main;

import java.util.Scanner;

/**
 * @author agardea, nkagee
 *
 */
public class Human extends Player {

	public Human(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see main.Player#takeTurn()
	 */
	@Override
	public void takeTurn(GameBoard currentBoard) {
		
		boolean inputValid = false;
		Scanner sc = Main.Scan;
		String invalidInputMessage = this.Name + ", that input is invalid.\n Please select a row by entering its number.";
		while(!inputValid){
			System.out.println(currentBoard.toString());
			System.out.print(this.Name + ", select a row: ");
			String response = sc.next();
			if(response.length() == 1){
				try {
					int r = Integer.parseInt(response);
					int rowTokens = currentBoard.getCurrentState().checkRow(r);
					if(rowTokens > 0) {
						//row tokens is the number of tokens in the selected row
						//in the row selected
						
						boolean inputValidToken = false;
						while(!inputValidToken) {
							System.out.println("Remove how many tokens?");
							
							int tokensToRemove = sc.nextInt();
							TurnAction action = new TurnAction();
							action.setTargetRow(r);
							action.setTokenAmount(tokensToRemove);
							boolean successful = currentBoard.getCurrentState().tryTurn(action);
								inputValidToken = successful;
								inputValid = successful;
							System.out.println(currentBoard.toString());
						}			
						
					} else {
						System.out.println(invalidInputMessage);
					}
				} catch (java.lang.NumberFormatException e){
					System.out.println(invalidInputMessage);
				}
			} else {
				System.out.println(invalidInputMessage);
			}
		}
	}
}

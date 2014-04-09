package main;

import java.util.Scanner;

/**
 * @author agardea
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
		// TODO Auto-generated method stub
		Boolean inputValid = false;
		Scanner sc = new Scanner(System.in);
		String invalidInputMessage = this.Name + ", that input is invalid.\n Please select a row by entering its number.";
		while(!inputValid){
			System.out.println(currentBoard.toString());
			System.out.print(this.Name + ", select a row: ");
			String response = sc.next();
			if(response.length() == 1){
				try{
					int r = Integer.parseInt(response);
					int rowTokens = currentBoard.getCurrentState().checkRow(r);
					if(rowTokens > 0){
						//row tokens is the number of tokens in the selected row
						//in the row selected
						
						boolean inputValidToken = false;
						while(!inputValidToken)
						{
							System.out.println("Remove how many tokens?");
							
							int tokensToRemove = sc.nextInt();
							
							if(currentBoard.getCurrentState().rows[r - 1] >= tokensToRemove)
							{
								currentBoard.getCurrentState().rows[r - 1] -= tokensToRemove;
								
								inputValidToken = true;
								inputValid = true;
							}
							
							System.out.println(currentBoard.toString());
						}
						
					}else{
						System.out.println(invalidInputMessage);
					}
				}catch(java.lang.NumberFormatException e){
					System.out.println(invalidInputMessage);
				}
			}else{
				System.out.println(invalidInputMessage);
			}
		}
		sc.close();
	}

}

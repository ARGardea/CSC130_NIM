/**
 * 
 */
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
	void takeTurn(BoardState currentState) {
		// TODO Auto-generated method stub
		Boolean inputValid = false;
		Scanner sc = new Scanner(System.in);
		String invalidInputMessage = this.Name + ", that input is invalid.\n Please select a row by entering its number.";
		while(!inputValid){
			System.out.println(currentState.toString());
			System.out.print(this.Name + ", select a row: ");
			String response = sc.next();
			if(response.length() == 1){
				try{
					int r = Integer.parseInt(response);
					int rowTokens = currentState.checkRow(r);
					if(rowTokens > 0){
						inputValid = true;
						System.out.println(response);
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

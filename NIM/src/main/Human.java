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

	/* (non-Javadoc)
	 * @see main.Player#takeTurn()
	 */
	@Override
	void takeTurn(BoardState currentState) {
		// TODO Auto-generated method stub
		Boolean inputValid = false;
		String invalidInputMessage = "That input is invalid.\n Please select a row by entering its number.";
		while(!inputValid){
			System.out.println(currentState.toString());
			Scanner sc = new Scanner(System.in);
			System.out.print("Select a row: ");
			String response = sc.next();
			if(response.length() == 1){
				try{
					int r = Integer.parseInt(response);
					if(r > 0 && r < 4){
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
			sc.close();
		}
	}

}

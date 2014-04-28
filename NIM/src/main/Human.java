package main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author agardea, nkagee
 *
 */
public class Human extends Player {

	public Human(String name) {
		super(name);
	}
	
	public int getIntInput(String promptMessage, String invalidInputMessage){
		int userInput = 0;
		boolean inputInvalid = true;
		while (inputInvalid) {
			System.out.print(promptMessage);
			String response = Main.Scan.next();
			Pattern digitPattern = Pattern.compile("([0-9]+)");
			Matcher digitMatches = digitPattern.matcher(response);
			if (digitMatches.find()) {
				userInput = Integer.parseInt(digitMatches.group(1));
				inputInvalid = false;
			}else{
				System.out.println(invalidInputMessage);
			}
		}
		return userInput;
	}

	/* (non-Javadoc)
	 * @see main.Player#takeTurn()
	 */
	@Override
	public void takeTurn(GameBoard currentBoard) {

		boolean inputInvalid = true;
		Scanner sc = Main.Scan;
		String invalidRowInputMessage = this.Name
				+ ", that input is invalid.\n Please select a row by entering its number.";
		String rowPrompt = currentBoard.toString() + "\n\n" + Name
				+ ", select a row: ";

		while (inputInvalid) {
			int input = this.getIntInput(rowPrompt, invalidRowInputMessage);
			boolean userInputFits = input > 0
					&& input <= currentBoard.getCurrentState()
							.getNumberOfRows();
			if (userInputFits) {
				int rowTokens = currentBoard.getCurrentState().checkRow(input);
				if (rowTokens > 0) {
					// row tokens is the number of tokens in the selected row
					// in the row selected

					boolean inputInvalidToken = true;
					while (inputInvalidToken) {
						String tokenPrompt = "There are " + rowTokens
								+ " tokens in row " + input
								+ ".\n How many tokens will you remove?";
						String invalidTokenInputMessage = "That is not a valid number of tokens.\nPlease select a value greater than 0 and NOT greater than "
								+ rowTokens;

						int tokensToRemove = getIntInput(tokenPrompt,
								invalidTokenInputMessage);

						TurnAction action = new TurnAction();
						action.setTargetRow(input);
						action.setTokenAmount(tokensToRemove);
						boolean successful = currentBoard.getCurrentState()
								.tryTurn(action);
						if (successful) {
							inputInvalidToken = !successful;
							inputInvalid = !successful;
						} else {
							System.out.println(invalidTokenInputMessage);
						}
					}

				} else {
					System.out
							.println("There are not any tokens in that row. Please choose a different row.");
				}
			} else {
				System.out
						.println("That is not a valid row. Please select the number of one of the rows displayed.");
			}
		}
	}
}

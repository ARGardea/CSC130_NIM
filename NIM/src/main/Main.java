package main;

import java.util.Scanner;

public class Main {
	public static Scanner Scan;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scan = new Scanner(System.in);
		GameEngine initGame = new GameEngine();
		initGame.startMenu();
		Scan.close();
		
		/*BoardState state = new BoardState();
		state.rows = new int[] {3, 5, 7};
		BoardState testState = new BoardState();
		testState.rows = new int[] {3, 5, 5};
		TurnAction action = state.howToReachState(testState);
		if(action != null){
			System.out.println(action.toString());
		}else{
			System.out.println("No valid move.");
		}*/
	}

}

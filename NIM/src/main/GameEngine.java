/**
 * 
 */
package main;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author agardea, nkagee
 * 
 */
public class GameEngine {
	Game runningGame;
	boolean userDone;
	public void startMenu() {
		userDone = false;
		Scanner sc = Main.Scan;
		int pvpCode = 1;
		int pvcCode = 2;
		int cvcCode = 3;
		while (!userDone) {
			System.out.println("Welcome to NIM. Choose game option:");
//			System.out.println(pvpCode + " - Player vs. Player \n"
//					+ pvcCode + " - Player vs. Computer \n"
//					+ cvcCode + " - Computer vs. Computer \n" + "Any Other Value - Exit");
			try {
				int menuNumber = 0;
				for(MenuOption option: MenuOption.values()){
					System.out.println(menuNumber + "): " + option.getPrompt());
					menuNumber++;
				}
				
				int answer = Integer.parseInt(sc.next());
				runningGame = new Game();
				
				MenuOption.getValue(answer).execute(this);
				
//				if (answer == pvpCode) {
//					initGame.setGameType(GameType.PvP);
//				} else if (answer == pvcCode) {
//					initGame.setGameType(GameType.PvC);
//				} else if (answer == cvcCode) {
//					System.out
//							.println("How many games should the computers play?");
//					int rounds = sc.nextInt();
//					initGame.setGameType(GameType.CvC);
//					initGame.setRoundsToPlay(rounds);
//				} else {
//					userDone = true;
//				}
				
				if(!userDone){
					runningGame.setupGame();
					runningGame.gameLoop();
				}
			} catch (NumberFormatException|IndexOutOfBoundsException e) {
				System.out.println("That input is not valid.\n");
			}
		}
	}
	
	public void setUserDone(boolean valueToSet){
		userDone = valueToSet;
	}
	
	public void SetGameType(GameType typeToSet){
		runningGame.setGameType(typeToSet);
	}
	
	public void setGameRounds(int numberOfRounds){
		runningGame.setRoundsToPlay(numberOfRounds);
	}
}

enum MenuOption{
	pvp{
		
		@Override
		void execute(GameEngine engine) {
			// TODO Auto-generated method stub
			engine.runningGame.setGameType(GameType.PvP);
		}

		@Override
		String getPrompt() {
			// TODO Auto-generated method stub
			return "Player vs. Player";
		}
	},
	
	pvc{

		@Override
		void execute(GameEngine engine) {
			// TODO Auto-generated method stub
			engine.runningGame.setGameType(GameType.PvC);
		}

		@Override
		String getPrompt() {
			// TODO Auto-generated method stub
			return "Player vs. Computer";
		}
		
	},
	
	cvc{

		@Override
		void execute(GameEngine engine) {
			// TODO Auto-generated method stub
			System.out.println("How many games should the computers play?");
			int rounds = Main.Scan.nextInt();	
			engine.runningGame.setGameType(GameType.CvC);
			engine.setGameRounds(rounds);
		}

		@Override
		String getPrompt() {
			// TODO Auto-generated method stub
			return "Computer vs. Computer";
		}
		
	},
	
	quit{

		@Override
		void execute(GameEngine engine) {
			engine.setUserDone(true);
		}

		@Override
		String getPrompt() {
			// TODO Auto-generated method stub
			return "Quit Game";
		}
		
	};
	String prompt;
	abstract void execute(GameEngine engine);
	abstract String getPrompt();
	
	public static MenuOption getValue(int valueNumber){
		return values()[valueNumber];
	}
}

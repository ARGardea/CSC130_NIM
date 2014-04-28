/**
 * 
 */
package main;

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
		while (!userDone) {
			System.out.println("Welcome to NIM. Choose game option:");
			try {
				int menuNumber = 0;
				for(MenuOption option: MenuOption.values()){
					System.out.println(menuNumber + "): " + option.getPrompt());
					menuNumber++;
				}
				
				int answer = Integer.parseInt(sc.next());
				
				MenuOption.getValue(answer).execute(this);
				
				if(!userDone) {
					runningGame.gameLoop(MenuOption.getValue(answer).getGameRounds());
				}
				
			} catch (NumberFormatException|IndexOutOfBoundsException e) {
				System.out.println("That input is not valid.\n");
			}
		}
	}
	
	public void setUserDone(boolean valueToSet){
		userDone = valueToSet;
	}
	
//	
//	public void setGameRounds(int numberOfRounds){
//		runningGame.setRoundsToPlay(numberOfRounds);
//	}
}

enum MenuOption{
	pvp{
		
		@Override
		void execute(GameEngine engine) {
			// TODO Auto-generated method stub
			engine.runningGame = new Game(GameType.PvP);
		}

		@Override
		String getPrompt() {
			// TODO Auto-generated method stub
			return "Player vs. Player";
		}

		@Override
		int getGameRounds()
		{
			// TODO Auto-generated method stub
			return 1;
		}
	},
	
	pvc{

		@Override
		void execute(GameEngine engine) {
			// TODO Auto-generated method stub
			engine.runningGame = new Game(GameType.PvC);
		}

		@Override
		String getPrompt() {
			// TODO Auto-generated method stub
			return "Player vs. Computer";
		}

		@Override
		int getGameRounds()
		{
			// TODO Auto-generated method stub
			return 1;
		}
		
	},
	
	cvc{

		@Override
		void execute(GameEngine engine) {
			// TODO Auto-generated method stub
			engine.runningGame = new Game(GameType.CvC);
		}

		@Override
		String getPrompt() {
			// TODO Auto-generated method stub
			return "Computer vs. Computer";
		}

		@Override
		int getGameRounds()
		{
			System.out.println("How many games should the computers play?");
			int rounds = Main.Scan.nextInt();	
			return rounds;
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

		@Override
		int getGameRounds()
		{
			// TODO Auto-generated method stub
			return 0;
		}		
	};
	
	abstract void execute(GameEngine engine);
	abstract String getPrompt();
	abstract int getGameRounds();
	
	public static MenuOption getValue(int valueNumber){
		return values()[valueNumber];
	}
}

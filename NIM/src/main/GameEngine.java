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
	public void startMenu() {
		boolean userDone = false;
		Game initGame;
		Scanner sc = Main.Scan;
		int pvpCode = 1;
		int pvcCode = 2;
		int cvcCode = 3;
		while (!userDone) {
			System.out.println("Welcome to NIM. Choose game option:");
			System.out.println(pvpCode + " - Player vs. Player \n"
					+ pvcCode + " - Player vs. Computer \n"
					+ cvcCode + " - Computer vs. Computer \n" + "Any Other Value - Exit");
			try {
				int answer = Integer.parseInt(sc.next());
				initGame = new Game();
				if (answer == pvpCode) {
					initGame.setGameType(GameType.PvP);
				} else if (answer == pvcCode) {
					initGame.setGameType(GameType.PvC);
				} else if (answer == cvcCode) {
					System.out
							.println("How many games should the computers play?");
					int rounds = sc.nextInt();
					initGame.setGameType(GameType.CvC);
					initGame.setRoundsToPlay(rounds);
				} else {
					userDone = true;
				}
				
				if(!userDone){
					initGame.setupGame();
					initGame.gameLoop();
				}
			} catch (NumberFormatException e) {
				System.out.println("That input is not valid.\n");
			}
		}
	}
}

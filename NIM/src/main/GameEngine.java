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
				
				if (answer == pvpCode) {
					initGame = new Game(GameType.PvP);
					initGame.gameLoop();
				} else if (answer == pvcCode) {
					initGame = new Game(GameType.PvC);
					initGame.gameLoop();
				} else if (answer == cvcCode) {
					System.out
							.println("How many games should the computers play?");
					int rounds = sc.nextInt();
					initGame = new Game(GameType.CvC, rounds);
					initGame.gameLoop();
				} else {
					userDone = true;
				}
			} catch (NumberFormatException e) {
				System.out.println("That input is not valid.\n");
			}
		}
	}
}

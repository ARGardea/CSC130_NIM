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
	public void startMenu() {
		boolean userDone = false;
		Game initGame;
		Scanner sc = Main.scan;
		while (!userDone) {
			System.out.println("Welcome to NIM. Choose game option:");
			System.out.println("1 - Player vs. Player \n"
					+ "2 - Player vs. Computer \n"
					+ "3 - Computer vs. Computer \n" + "Any Other Value - Exit");

			int answer = sc.nextInt();

			if (answer == 1) {
				initGame = new Game(GameType.PvP);
				initGame.gameLoop();
			} else if (answer == 2) {
				initGame = new Game(GameType.PvC);
				initGame.gameLoop();
			} else if (answer == 3) {
				System.out.println("How many games should the computers play?");
				int rounds = sc.nextInt();
				initGame = new Game(GameType.CvC, rounds);
				initGame.gameLoop();
			} else {
				userDone = true;
			}
		}
	}
}

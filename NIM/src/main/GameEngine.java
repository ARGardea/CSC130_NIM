/**
 * 
 */
package main;

import java.util.Scanner;

/**
 * @author agardea, nkagee
 *
 */
public class GameEngine 
{
	public void startMenu() {
		
		Game initGame;
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to NIM. Choose game option:");
		System.out.println("1 - Player vs. Player \n"
				+ "2 - Player vs. Computer \n"
				+ "3 - Computer vs. Computer \n"
				+ "0 - Exit");
		
		int answer = scan.nextInt();
		
		if(answer == 1) {
			initGame = new Game(GameType.PvP);
		}
		else if(answer == 2) {
			initGame = new Game(GameType.PvC);
		}
		else if(answer == 3) {
			
			System.out.println("How many games should the computers play?");
			int rounds = scan.nextInt();
			initGame = new Game(GameType.CvC, rounds);
		}
		else {
			System.exit(0);
		}
		
		
		scan.close();
	}
}

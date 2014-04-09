package main;

import java.util.Scanner;

public class Main {
	public static Scanner scan;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scan = new Scanner(System.in);
		GameEngine initGame = new GameEngine();
		initGame.startMenu();
		scan.close();
	}

}

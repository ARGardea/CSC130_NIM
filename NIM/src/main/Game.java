package main;

public class Game
{
	Player player1;
	Player player2;
	
	boolean isValidTurn = true;
	boolean firstPlayerTurn = true;
	
	public Game(GameType type)
	{
		if(type.equals(GameType.PvP))
		{
			System.out.println("Test complete.");
			startPvPGame();
		}
		else if(type.equals(GameType.PvC))
		{
			System.out.println("Test 1 complete.");
		}
	}
	
	public Game(GameType type, int roundsToPlay)
	{
		System.out.println("Test complete.");
		startCvCGame(roundsToPlay);
	}
	
	public void startPvPGame()
	{
		GameBoard board = new GameBoard();
		player1 = new Human();
		player2 = new Human();
	}
	
	public void startPvCGame()
	{
		GameBoard board = new GameBoard();
		player1 = new Human();
		player2 = new Computer();
	}
	
	public void startCvCGame(int roundsToPlay)
	{
		for(int i = 0; i < roundsToPlay; i++)
		{
			System.out.println(roundsToPlay);
		}
		GameBoard board = new GameBoard();
		player1 = new Computer();
		player2 = new Computer();
	}
}

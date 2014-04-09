package main;

public class Game
{
	Player player1;
	Player player2;
	GameBoard board;
	
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
	
	public void startNewTurn(){
		firstPlayerTurn = !firstPlayerTurn;
		printPlayerTurnMessage();
		if(firstPlayerTurn){
			player1.takeTurn(board.getCurrentState());
		}else{
			player2.takeTurn(board.getCurrentState());
		}
	}
	
	public void checkGameVictory(){
		
	}
	
	public void printPlayerTurnMessage(){
		String currentPlayerName = "Magnificent Steven";
		if(firstPlayerTurn){
			currentPlayerName = player1.Name;
		}else{
			currentPlayerName = player2.Name;
		}
		System.out.println(currentPlayerName + ", it's your turn!");
	}
	
	public void startPvPGame()
	{
		board = new GameBoard();
		player1 = new Human("Player 1");
		player2 = new Human("Player 2");
	}
	
	public void startPvCGame()
	{
		board = new GameBoard();
		player1 = new Human("Player");
		player2 = new Computer("Computer");
	}
	
	public void startCvCGame(int roundsToPlay)
	{
		for(int i = 0; i < roundsToPlay; i++)
		{
			System.out.println(roundsToPlay);
		}
		board = new GameBoard();
		player1 = new Computer("Computer 1");
		player2 = new Computer("Computer 2");
	}
}

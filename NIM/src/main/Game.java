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
	
	public int checkGameStatus(){
		BoardState currentState = board.getCurrentState();
		int row1 = currentState.rows[0];
		int row2 = currentState.rows[1];
		int row3 = currentState.rows[2];
		int rowTotal = row1 + row2 + row3;
		if(rowTotal != 0 && rowTotal != 1){
			rowTotal = -1;
		}
		return rowTotal;
	}
	
	public Boolean didFirstPlayerWin(){
		Boolean result = null;
		int gameStatus = checkGameStatus();
		if(gameStatus == 0){
			result = !firstPlayerTurn;
		}else if(gameStatus == 1){
			result = firstPlayerTurn;
		}
		return result;
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

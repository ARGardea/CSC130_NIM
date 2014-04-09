package main;

public class Game
{
	Player player1;
	Player player2;
	GameBoard board;
	
	boolean isValidTurn = true;
	boolean firstPlayerTurn = true;
	int numberOfTurns = 0;
	int roundsToPlay = 0;
	
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
		numberOfTurns++;
		printPlayerTurnMessage();
		if(firstPlayerTurn){
			player1.takeTurn(board);
		}else{
			player2.takeTurn(board);
		}
		firstPlayerTurn = !firstPlayerTurn;
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
			result = firstPlayerTurn;
		}else if(gameStatus == 1){
			result = !firstPlayerTurn;
		}
		return result;
	}
	
	public void printPlayerVictoryMessage(Boolean firstPlayerWin){
		String currentPlayerName = "Magnificent Steven";
		if(firstPlayerWin){
			currentPlayerName = player1.Name;
		}else{
			currentPlayerName = player2.Name;
		}
		System.out.println(currentPlayerName + ", you win!");
		System.out.println("Press any key to continue.");
		Main.scan.next();
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

	public void gameLoop() {
		while (roundsToPlay > 0) {
			Boolean gameComplete = false;
			while (!gameComplete) {
				startNewTurn();
				Boolean firstPlayerWin = didFirstPlayerWin();
				if (firstPlayerWin != null) {
					gameComplete = true;
					printPlayerVictoryMessage(firstPlayerWin);
				}
			}
			roundsToPlay--;
		}
	}
	
	public void startPvPGame()
	{
		int numberOfTurns = 0;
		roundsToPlay = 1;
		board = new GameBoard();
		player1 = new Human("Player 1");
		player2 = new Human("Player 2");
	}
	
	public void startPvCGame()
	{
		int numberOfTurns = 0;
		roundsToPlay = 1;
		board = new GameBoard();
		player1 = new Human("Player");
		player2 = new Computer("Computer");
	}
	
	public void startCvCGame(int roundsToPlay)
	{
		this.roundsToPlay = roundsToPlay;
		int numberOfTurns = 0;
		for(int i = 0; i < roundsToPlay; i++)
		{
			System.out.println(roundsToPlay);
		}
		board = new GameBoard();
		player1 = new Computer("Computer 1");
		player2 = new Computer("Computer 2");
	}
}

package main;

public class Game
{
	Player player1;
	Player player2;
	GameBoard board;
	GameHistory history; 
	
	boolean isValidTurn = true;
	boolean firstPlayerTurn = true;
	int numberOfTurns = 0;
	int roundsToPlay = 0;
	
	public Game(GameType type) {
		if(type.equals(GameType.PvP)) {
			startPvPGame();
		}
		else if(type.equals(GameType.PvC)) {
			startPvCGame();
		}
	}
	
	public Game(GameType type, int roundsToPlay) {
		startCvCGame(roundsToPlay);
	}
	
	public void startNewTurn() {
		numberOfTurns++;
		printPlayerTurnMessage();
		if(firstPlayerTurn) {
			player1.takeTurn(board);
		} else {
			player2.takeTurn(board);
		}
		
		history.addState(board.getCurrentState());
		
		firstPlayerTurn = !firstPlayerTurn;
	}
	
	public int checkGameStatus() {
		BoardState currentState = board.getCurrentState();
		return currentState.getBoardStateRowSum();
	}
	
	public Boolean didFirstPlayerWin() {
		Boolean result = null;
		int gameStatus = checkGameStatus();
		if(gameStatus == 0) {
			result = firstPlayerTurn;
		} else if(gameStatus == 1) {
			result = !firstPlayerTurn;
		}
		return result;
	}
	
	public void printPlayerVictoryMessage(boolean firstPlayerWin) {
		String currentPlayerName = "Magnificent Steven";
		if(firstPlayerWin) {
			currentPlayerName = player1.Name;
		} else {
			currentPlayerName = player2.Name;
		}
		System.out.println(currentPlayerName + ", you win!\n");
	}
	
	public void printPlayerTurnMessage() {
		String currentPlayerName = "Magnificent Steven";
		currentPlayerName = (firstPlayerTurn)? player1.Name:player2.Name;
		System.out.println(currentPlayerName + ", it's your turn!");
	}

	public void gameLoop() {
		while (roundsToPlay > 0) {
			board = new GameBoard();
			boolean gameComplete = false;
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
	
	public void startPvPGame() {
		numberOfTurns = 0;
		roundsToPlay = 1;
		history = new GameHistory();
		board = new GameBoard();
		player1 = new Human("Player 1");
		player2 = new Human("Player 2");
		
		history.addState(board.getCurrentState());
	}
	
	public void startPvCGame() {
		numberOfTurns = 0;
		roundsToPlay = 1;
		history = new GameHistory();
		board = new GameBoard();
		player1 = new Human("Player");
		player2 = new Computer("Computer");
		
		history.addState(board.getCurrentState());
	}
	
	public void startCvCGame(int roundsToPlay) {
		this.roundsToPlay = roundsToPlay;
		numberOfTurns = 0;
		for(int i = 0; i < roundsToPlay; i++)
		{
			System.out.println(roundsToPlay);
		}
		history = new GameHistory();
		board = new GameBoard();
		player1 = new Computer("Computer 1");
		player2 = new Computer("Computer 2");
		
		history.addState(board.getCurrentState());
	}
}

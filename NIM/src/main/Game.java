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
		player1 = new Human("Player 1");
		player2 = new Human("Player 2");
		setUpGame(GameType.PvP);
		
	}
	
	public void startPvCGame() {
		player1 = new Human("Player");
		player2 = new Computer("Computer");
		setUpGame(GameType.PvC);
	}
	
	public void startCvCGame(int roundsToPlay) {
		this.roundsToPlay = roundsToPlay;
		numberOfTurns = 0;
		player1 = new Computer("Computer 1");
		player2 = new Computer("Computer 2");
		setUpGame(GameType.CvC);
	}
	
	public void setUpGame(GameType type) {
		if(type.equals(GameType.PvP) || type.equals(GameType.PvC)) {
			numberOfTurns = 0;
			roundsToPlay = 1;
		}
		
		history = new GameHistory();
		board = new GameBoard();
		history.addState(board.getCurrentState());
	}
}

package main;

public class Game
{
	Player player1;
	Player player2;
	GameBoard board;
	GameHistory history;
	
	GameType type;
	
	boolean isValidTurn = true;
	boolean firstPlayerTurn = true;
	int numberOfTurns = 0;
	
	public Game(GameType type) {
		this.type = type;
		this.setupGame();
//		this.roundsToPlay = 1;
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

	public void gameLoop(int roundsToPlay) {
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
	
	public void setPlayers(Player player1, Player player2) {
		this.player1 = player1; 
		this.player2 = player2;
	}
	
	public void setupGame() {
		history = new GameHistory();
		board = new GameBoard();
		history.addState(board.getCurrentState());
		type.createPlayers(this);
	}
}

enum GameType
{
	PvP {
		@Override 
		void createPlayers(Game game){
			game.setPlayers(new Human("Player 1"), new Human("Player 2"));
		}
	},
	PvC {
		@Override 
		void createPlayers(Game game){
			game.setPlayers(new Human("Player"), new Computer("Computer"));
		}
	},
	CvC {
		@Override 
		void createPlayers(Game game){
			game.setPlayers(new Computer("Computer 1"), new Computer("Computer 2"));
		}
	};

	abstract void createPlayers(Game game);
}


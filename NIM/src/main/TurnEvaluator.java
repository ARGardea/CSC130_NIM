package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TurnEvaluator
{
	private ArrayList<GameHistory> historyList;
	private HashMap turnScores;
	
	public TurnEvaluator() {
		historyList = new ArrayList<GameHistory>();
		turnScores = new HashMap();
	}
	
	public ArrayList<GameHistory> getHistoryList() {
		return historyList;
	}
	
	public void EvaluateHistory(GameHistory historyToEvaluate){
		historyList.add(historyToEvaluate);
		Iterator<BoardState> turnHistoryIterator = historyToEvaluate.getStateList();
		
		int totalTurns = historyToEvaluate.getNumberOfBoardStates();
		
		boolean wasLastTurnWin = historyToEvaluate.wasLastBoardStateWin();
		
		float startingScore = (wasLastTurnWin)? 1:-1;
		
		boolean scorePositive = (startingScore > 0);
		for(int i = totalTurns; i > 0; i--){
			
		}
	}
	
	public boolean didBoardStateEqualWin(BoardState stateToJudge){
		return (stateToJudge.getBoardStateRowSum() == 0);
	}
}

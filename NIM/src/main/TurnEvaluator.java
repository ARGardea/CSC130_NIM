package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TurnEvaluator
{
	private ArrayList<GameHistory> historyList;
	private HashMap<Integer, Integer> turnScores;
	
	public TurnEvaluator() {
		historyList = new ArrayList<GameHistory>();
		turnScores = new HashMap<Integer, Integer>();
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
	
	public Iterator<Integer> calculateLosingScores(int numberOfTurns){
		int numberOfScores = (numberOfTurns%2==0)? ((numberOfTurns/2)-1):(numberOfTurns/2);
		ArrayList<Integer> scores = new ArrayList<Integer>();
		int multiplier = -1;
		
		return scores.iterator();
	}
	
	public Iterator<Float> calculateScores(int numberOfScores, int multiplier){
		ArrayList<Float> scores = new ArrayList<Float>();
		
		for(int i = 1; !(i>numberOfScores); i++){
			Float score = (float)(((float)i/(float)numberOfScores)*(float)multiplier);
			scores.add(score);
		}
		
		return scores.iterator();
	}
	
	public Iterator<Integer> calculateWinningScores(int numberOfTurns){
		int numberOfScores = (numberOfTurns%2==0)? (numberOfTurns/2):((numberOfTurns/2) -1);
		ArrayList<Integer> scores = new ArrayList<Integer>();
		int multiplier = -1;
		
		return scores.iterator();
	}
}

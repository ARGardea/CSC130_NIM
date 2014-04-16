package main;

import java.util.ArrayList;

public class TurnEvaluator
{
	private ArrayList<GameHistory> historyList; 
	
	public TurnEvaluator() {
		historyList = new ArrayList<GameHistory>();
	}
	
	public ArrayList<GameHistory> getHistoryList() {
		return historyList;
	}
	
	public void EvaluateHistory(GameHistory historyToEvaluate){
		historyList.add(historyToEvaluate);
	}
}

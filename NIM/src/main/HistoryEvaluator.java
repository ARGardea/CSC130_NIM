package main;

import java.util.ArrayList;

public class HistoryEvaluator
{
	private ArrayList<GameHistory> historyList; 
	
	public HistoryEvaluator() {
		historyList = new ArrayList<GameHistory>();
	}
	
	public ArrayList<GameHistory> getHistoryList() {
		return historyList;
	}
}

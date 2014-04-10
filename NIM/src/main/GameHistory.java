package main;

import java.util.ArrayList;

public class GameHistory
{
	private ArrayList<BoardState> stateList;
	
	public GameHistory() {
		stateList = new ArrayList<BoardState>();
	}
	
	public void addState(BoardState boardState) {
		stateList.add(boardState);
	}
	
	public void  removeState(BoardState boardState) {
		stateList.remove(boardState);
	}
	
	public ArrayList<BoardState> getStateList() {
		return stateList;
	}
}

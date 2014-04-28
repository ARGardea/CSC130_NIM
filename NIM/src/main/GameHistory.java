package main;

import java.util.ArrayList;
import java.util.Iterator;

public class GameHistory
{
	private ArrayList<BoardState> stateList;
	
	public GameHistory() {
		stateList = new ArrayList<BoardState>();
	}
	
	public boolean calculateLastStateWin(){
		boolean wasLastStateWin = (stateList.get(stateList.size() - 1).getBoardStateRowSum() == 0);
		return wasLastStateWin;
	}
	
	public void addState(BoardState boardState) {
		stateList.add(boardState);
	}
	
	public void  removeState(BoardState boardState) {
		stateList.remove(boardState);
	}
	
	public int getNumberOfBoardStates(){
		return stateList.size();
	}
	
	public Iterator<BoardState> getStateList() {
		return stateList.iterator();
	}
}

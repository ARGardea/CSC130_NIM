package main;

import java.util.ArrayList;
import java.util.Iterator;

public class GameHistory
{
	private ArrayList<BoardState> stateList;
	private boolean wasLastStateWin;
	
	public GameHistory() {
		stateList = new ArrayList<BoardState>();
	}
	
	public void calculateLastStateWin(){
		wasLastStateWin = (stateList.get(stateList.size() - 1).getBoardStateRowSum() == 0);
	}
	
	public boolean wasLastBoardStateWin(){
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

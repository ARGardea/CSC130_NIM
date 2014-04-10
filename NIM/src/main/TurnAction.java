package main;

public class TurnAction {
	private int targetRow;
	private int tokenAmount;
	/**
	 * @return the targetRow
	 */
	public int getTargetRow() {
		return targetRow;
	}
	/**
	 * @param targetRow the targetRow to set
	 */
	public void setTargetRow(int targetRow) {
		this.targetRow = targetRow;
	}
	/**
	 * @return the tokenAmount
	 */
	public int getTokenAmount() {
		return tokenAmount;
	}
	/**
	 * @param tokenAmount the tokenAmount to set
	 */
	public void setTokenAmount(int tokenAmount) {
		this.tokenAmount = tokenAmount;
	}
	
	@Override
	public String toString(){
		String result = "Remove " + tokenAmount + " tokens from row " + targetRow + ".";
		return result;
	}
}

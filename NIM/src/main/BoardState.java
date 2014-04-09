/**
 * 
 */
package main;

/**
 * @author agardea
 *
 */
public class BoardState {
	public int[] rows = new int[3];
	
	public int checkRow(int targetRow){
		int result = -1;
		try{
			result = rows[targetRow];
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
		return result;
	}
	
	@Override
	public String toString(){
		String result = new String();
		for(int i = 0; i < rows.length; i++){
			result += (i + 1) + ") [";
			for(int j = 0; j < rows[i]; j++){
				result += " x";
			}
			result += " ]\n";
		}
		return result;
	}
}

package is.ru.tictac;
public class Board {

	private int size = 3;
	private char[][] board;

	Board(){
		board = new char[size][size];
		char temp = '1';
		for (int i = 0; i < size; i++){
			for (int j = 0; j < size; j++) {
				board[i][j] = temp;
				temp++;
			}
		}
	}

	Board(int size, char[][] board){
		this.size = size;
		this.board = board;
	}

	public void setSize(int size){
		this.size = size;
	}

	public boolean checkRow(char[] row){
		for(int i = 0; i < size-1; i++) {
			if(row[i] != row[i+1]){
				return false;
			}
		}
		return true;
	}

	public boolean checkVertical(){
		for(int i = 0; i < size; i++){
			char[] temp = new char[size];
			for(int j = 0; j < size; j++){
				temp[j] = board[j][i];
			}
				if(checkRow(temp))
				{
					return true;
				}
			}
			return false;
	}

	public boolean checkHorizontal(){
		for(int i = 0; i < size; i++){
			char[] temp = new char[size];
			for(int j = 0; j < size; j++){
				temp[j] = board[i][j];
			}
			if(checkRow(temp))
			{
				return true;
			}
		}
		return false;
	}

	public boolean checkDiagonal(){
		char[] tempL = new char[size];
		char[] tempR = new char[size];

		for(int i = 0; i < size; i++){
			tempL[i] = board[i][i];
			tempR[i] = board[i][size-i-1];
		}
		if(checkRow(tempL)||checkRow(tempR)){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean checkCellOccupied(int x, int y){
		if(board[x][y] == 'X' || board[x][y] == 'O'){
			return true;
		}
		else{
			return false;
		}
	}

}


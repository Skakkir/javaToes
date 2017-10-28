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
}
package is.ru.tictac;
public class Board {

	private int size = 3; 
	private char[][] board;
	private int boardCount = 0;

	Board(){
		// initialise the board as sizexsize or 3x3
		board = new char[size][size];
		// Number all the cells in the board from 1 - 9
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
	//returns the state of the board.
	public char[][] getBoard(){
		return board;
	}
	//returns true if all the cells in that row contain the same symbol, otherwise it returns false
	public boolean checkRow(char[] row){
		for(int i = 0; i < size-1; i++) {
			if(row[i] != row[i+1]){
				return false;
			}
		}
		return true;
	}
	//returns true if all the cells in that vertical line contain the same symbol, otherwise it returns false.
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

	//returns true if all the cells in that horizontal line contain the same symbo, otherwise it returns false.
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

	//returns true if all the celss in thit diagonal line contain the same symbol, otherwise it returns false.
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

	// Returns true if the cell that is looked for contains eitheir an X or an O, otherwise it returns false. 
	public boolean checkCellOccupied(int x, int y){
		if(board[x][y] == 'X' || board[x][y] == 'O'){
			return true;
		}
		else{
			return false;
		}
	}

	// Returns an array of integers, finds the coordinates of the player.
	public int[] posToCoord(int pos){
		int[] result = new int[2];
		int row;
		int col;
		if(pos%size == 0){
			row = (pos / size)-1;
			col = size-1;
		}
		else{
			row = pos/size;
			col = (pos%size)-1;
		}

		result[0] = row;
		result[1] = col;
		return result;
	}

	// Returns false if the input is  out of range from the board (lower than 0 or bigger then the size of the board) and
	// if the cell that is chosen is occupied(has an X or an O in it), otherwise it returns true and puts the symbol corresponding to 
	// the player in that cell, and puts boardcount up by 1.
	public boolean add(int pos, Player p){
		int[] cords = posToCoord(pos);
		if(pos < 0 || pos > size*size){
			System.out.println("select a number between: 0 and " + size*size);
			return false;
		}
		else if(checkCellOccupied(cords[0], cords[1])){
			System.out.println("this cell is occupied!!!!");
			return false;
		}
		else{
			boardCount++;
			board[cords[0]][cords[1]] = p.getSymbol();
			return true;
		}
	}

	// Returns true if boardCount is the same as the size of the board, else it returns false.
	public boolean checkFullBoard(){
		if(boardCount == (size*size)){
			return true;
		}
		else{
			return false;
		}
	}

	// Returns true if either Vertical, Horizontal or Diagonal lines have the same symbol in them, X or O, otherwise it returns false. 
	public boolean checkWinner(Player p){

		if(checkVertical() || checkHorizontal() || checkDiagonal()){
			return true;
		}
		else{
			return false;
		}
	}

	// Sets the board to its original state, all cells numbered from 1 - size.
	public void reset(){
		char temp = '1';
		for (int i = 0; i < size; i++){
			for (int j = 0; j < size; j++) {
				board[i][j] = temp;
				temp++;
			}
		}
	}
	// prints out the board.
	public void print(){

		String seperartor = "-";
		for(int i = 0; i < size; i++){
			seperartor += "----";
		}

		System.out.println(seperartor);

		for(int i = 0; i < size; i++){
			System.out.print("| ");
			for (int j = 0; j < 3; j++){
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println(seperartor);
		}
	}

}


package is.ru.tictac;
import java.io.IOException;
import java.util.Scanner;


public class TicTac {

	private Board board = new Board();
	private Player currentPlayer = new Player('X');
	
	public void addToBoard(int num){
		board.add(num, currentPlayer);
	}

	public static void main(String[] args) {
		TicTac game = new TicTac();
		game.addToBoard(2);
		game.addToBoard(3);
		game.addToBoard(6);
		
		game.board.print();
 	}

}